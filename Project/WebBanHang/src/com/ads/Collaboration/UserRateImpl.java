package com.ads.Collaboration;

import java.sql.*;
import java.util.ArrayList;

import com.*;
import com.ads.basic.*;
import com.object.*;

public class UserRateImpl extends BasicImpl {

	public UserRateImpl(ConnectionPool cp) {
		super(cp, "user");
	}

	public ResultSet getUserRate(int id) {
		String sql = "";
		return this.get(sql, id);
	}

	public ResultSet getUserRates(UserRateObject similar, int at, byte total) {
		String sql = "";
		return this.gets(sql);
	}

	public ResultSet getSameProduct(String userid1, String userid2) {
		String sql = "SELECT A.product_id,A.user_rate_point,B.user_rate_point FROM user_rate A INNER JOIN user_rate B";
		sql += " WHERE A.product_id = B.product_id";
		sql += " AND A.user_id = " + userid1;
		sql += " AND B.User_id = " + userid2;
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
		simPerson = ur.simPerson(items, (float)3.45, (float)4);
		System.out.println(simPerson);
	}

	private Double simPerson(ArrayList<SameUserRateProductObject> items, float userAVG1, float userAVG2) {
		double sim = 0d;
		float user1_rate = 0f;
		float user2_rate = 0f;
		float A = 0f;
		float C = 0f;
		float D = 0f;
		for (int i = 0; i < items.size(); i++) {
			user1_rate = items.get(i).getUser1_rate();
			user2_rate = items.get(i).getUser2_rate();
			A += (user1_rate - userAVG1)*(user2_rate - userAVG2);
			C += (user1_rate - userAVG1)*(user1_rate - userAVG1);
			D += (user2_rate - userAVG2)*(user2_rate - userAVG2);
		}
		sim = A/Math.sqrt(C*D);
		return sim;
	}

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

}
