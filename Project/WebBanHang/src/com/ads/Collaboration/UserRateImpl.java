package com.ads.Collaboration;

import java.sql.*;
import java.util.ArrayList;

import com.*;
import com.ads.basic.*;
import com.object.*;

public class UserRateImpl extends BasicImpl implements UserRate {

	public UserRateImpl(ConnectionPool cp) {
		super(cp, "user");
	}

	@Override
	public ResultSet getSameProduct(String userid1, String userid2) {
		String sql = "SELECT A.product_id,A.user_rate_point,B.user_rate_point FROM user_rate A INNER JOIN user_rate B";
		sql += " WHERE A.product_id = B.product_id";
		sql += " AND A.user_id = " + userid1;
		sql += " AND B.User_id = " + userid2;
		return this.gets(sql);
	}

	@Override
	public ResultSet getUserRateAVG(String userid) {
		String sql = "SELECT user_id, user_rate_avg, user_rate_total FROM user_rate_avg";
		sql += " WHERE user_id = " + userid;
		return this.gets(sql);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		UserRateImpl ur = new UserRateImpl(cp);
		ArrayList<SameUserRateProductObject> items = new ArrayList<>();

		ResultSet rs = ur.getSameProduct("1", "1");
		if (rs != null) {
			try {
				while (rs.next()) {
					SameUserRateProductObject item = new SameUserRateProductObject();
					item.setProductid(rs.getInt(1));
					item.setUserid1("1");
					item.setUserid2("1");
					item.setUser1_rate(rs.getInt(2));
					item.setUser2_rate(rs.getInt(3));
					items.add(item);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Double simPerson = 0d;
		//simPerson = ur.simPerson(items, (float) 3.75, (float) 3.75);
		System.out.println(simPerson);
	}


	@Override
	public boolean addUserRate(UserRateObject item) {
		// TODO Auto-generated method stub
		String sql = "Call sp_user_rate(?,?,?,?) ";
		try {
			PreparedStatement preAdd = this.con.prepareStatement(sql);
			preAdd.setString(1, item.getUser_id());
			preAdd.setInt(2, item.getProduct_id());
			preAdd.setInt(3, item.getUser_rate_point());
			preAdd.setString(4, item.getUser_rate_comment());
			return this.add(preAdd);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addSimPerson(String userid1, String userid2, float simPerson) {
		String sql = "";
		Boolean flagUpdate = isExists(userid1, userid2);
		if (flagUpdate) {
			sql = "UPDATE `dacn_webbanhang`.`simperson` SET `simPerson`=? WHERE (`user_id_1`=? and`user_id_2`=?) OR (`user_id_1`=? and`user_id_2`=?);";
		} else {
			sql = "INSERT INTO `dacn_webbanhang`.`simperson` (`simPerson`, `user_id_1`, `user_id_2`) VALUES (?, ?, ?), (?, ?, ?)";
		}
		try {
			PreparedStatement preAdd = this.con.prepareStatement(sql);
			if(flagUpdate){
				preAdd.setFloat(1, simPerson);
				preAdd.setString(2, userid1);
				preAdd.setString(3, userid2);
				preAdd.setString(4, userid2);
				preAdd.setString(5, userid1);
			}else{
				preAdd.setFloat(1, simPerson);
				preAdd.setString(2, userid1);
				preAdd.setString(3, userid2);
				preAdd.setFloat(4, simPerson);
				preAdd.setString(5, userid2);
				preAdd.setString(6, userid1);
			}
			
			return this.add(preAdd);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private boolean isExists(String userid1, String userid2) {
		Boolean flag = false;
		String sql = "SELECT * FROM dacn_webbanhang.simperson WHERE (user_id_1 = " + userid1 + " AND user_id_2 = "
				+ userid2 + ") OR (user_id_1 = " + userid2 + " AND user_id_2 = " + userid1 + ")";
		ResultSet rs = this.gets(sql); // luu ban ghi khi truy xuat tu CSDL ra

		if (rs != null) {
			try {
				if (rs.next()) {
					flag = true;
				}
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public ResultSet getSimPerson(String userid, byte limit) {
		String sql = "SELECT * FROM dacn_webbanhang.simperson WHERE user_id_1=" + userid 
				+ " ORDER BY simperson DESC";
		sql += " LIMIT 0," + limit;
		return this.gets(sql);
	}

	@Override
	public ResultSet getProductRating(String userid) {
		String sql = "SELECT user_id,product_id,user_rate_point,user_rate_comment FROM dacn_webbanhang.user_rate ";
		sql += "WHERE user_id = " + userid;
		return this.gets(sql);
	}
	
	//get product rating when user_id != userid
	@Override
	public ResultSet getProductRating2(String userid) {
		String sql = "SELECT user_id,product_id,user_rate_point,user_rate_comment FROM dacn_webbanhang.user_rate ";
		sql += "WHERE user_id != " + userid;
		return this.gets(sql);
	}
	
	//get product rating when user 1 not have, user 2 have
	@Override
	public ResultSet getProductRating3(String user_id1,String user_id2) {
		String sql = "SELECT user_id,product_id,user_rate_point,user_rate_comment FROM dacn_webbanhang.user_rate ";
		sql += " WHERE user_id = "+user_id2+" AND product_id NOT IN(SELECT product_id FROM user_rate WHERE user_id = "+user_id1+"); ";
		return this.gets(sql);
	}
	
}
