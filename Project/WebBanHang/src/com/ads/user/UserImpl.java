package com.ads.user;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.*;
import com.ads.basic.*;
import com.ads.product.Product;
import com.ads.product.ProductImpl;
import com.object.*;

public class UserImpl extends BasicImpl implements User {

	public UserImpl(ConnectionPool cp) {
		super(cp, "user");
	}

	@Override
	public ResultSet getUser(String id) {
		String sql = "SELECT user_id,user_prefix,user_name,user_last_messaged,user_phonenumber,user_username,"
				+ "user_address,user_email,user_birthdate,user_Lastlogined,user_isLogined,user_gender,user_note,user_permission_id "
				+ " FROM dacn_webbanhang.user " + " WHERE user_id = ?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getUsers(UserObject similar, int at, byte total) {
		String sql = "SELECT user_id,user_prefix,user_name,user_last_messaged,user_phonenumber,user_username,"
				+ "user_address,user_email,user_birthdate,user_Lastlogined,user_isLogined,user_gender,user_note,user_permission_id "
				+ "FROM dacn_webbanhang.user ";

		/*
		 * //Lay dieu kien String conds=MakeConditions.createCondition(similar);
		 * if(!conds.equalsIgnoreCase("")){ sql += "WHERE "+conds+" "; }
		 */

		sql += " ORDER BY user_id ASC ";
		sql += "LIMIT " + at + "," + total;
		return this.gets(sql);
	}

	public String getNextUserId(UserObject item) {
		String id = "0";
		double did = 0;
		String sql = " SELECT user_id FROM  dacn_webbanhang.user WHERE user_prefix = ? ORDER BY user_id DESC LIMIT 1 ";
		ResultSet rs = this.get(sql, item.getUser_prefix());
		if (rs != null) {
			try {
				if (rs.next()) {
					id = rs.getString("user_id");
					id = id.substring(1);
					did = Double.parseDouble(id);
					did++;
				} else {
					did = Double.parseDouble(id);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		NumberFormat formatter = new DecimalFormat("000000000000000");
		String digit = item.getUser_prefix() + formatter.format(did);
		return digit;
	}
	
	@Override
	public String getNextVisitorId() {
		String id = "0";
		double did = 0;
		String sql = " SELECT Visitor_id FROM dacn_webbanhang.visitor ORDER BY Visitor_id DESC LIMIT 1 ";
		ResultSet rs = this.gets(sql);
		if (rs != null) {
			try {
				if (rs.next()) {
					id = rs.getString("Visitor_id");
					id = id.substring(1);
					did = Double.parseDouble(id);
					did++;
				} else {
					did = Double.parseDouble(id);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		NumberFormat formatter = new DecimalFormat("000000000000000");
		String digit = "V" + formatter.format(did);
		return digit;
	}

//	public static void main(String[] args) {
//		ConnectionPool cp = new ConnectionPoolImpl();
//		UserImpl u = new UserImpl(cp);
//		UserObject item = new UserObject();
//		item.setUser_prefix("D");
//		System.out.println(u.getNextVisitorId());
//	}

	@Override
	public boolean addUser(UserObject item) {
		// TODO Auto-generated method stub
		if (this.isExisting(item)) {
			return false;
		}
		if (this.isExistingEmail(item)) {
			return false;
		}
		// id se tu dong tang
		String nextID = getNextUserId(item);
		if (nextID.isEmpty()) {
			return false;
		}
		String sql = "INSERT INTO `user` "
				+ "(`user_id`, `user_prefix`, `user_name`, `user_last_messaged`, `user_phonenumber`,"
				+ " `user_username`, `user_password`, `user_address`, `user_email`, `user_birthdate`, "
				+ "`user_Lastlogined`, `user_isLogined`, `user_gender`, `user_note`, `user_permission_id`,user_is_encryption)";
		sql += " VALUES (?,?, ?, ?, ?, ?, md5(?), ?, ?, ?, 1, ?, ?, ?, ?,1)";
		try {
			PreparedStatement preAdd = this.con.prepareStatement(sql);
			preAdd.setString(1, nextID);
			preAdd.setString(2, item.getUser_prefix());
			preAdd.setString(3, item.getUser_name());
			preAdd.setString(4, item.getUser_last_messased());
			preAdd.setString(5, item.getUser_phonenum());
			preAdd.setString(6, item.getUser_username());
			preAdd.setString(7, item.getUser_password());
			preAdd.setString(8, item.getUser_address());
			preAdd.setString(9, item.getUser_email());
			preAdd.setString(10, item.getUser_birthdate());
			preAdd.setBoolean(11, item.isUser_isloggined());
			preAdd.setBoolean(12, item.isUser_gender());
			preAdd.setString(13, item.getUser_note());
			preAdd.setInt(14, item.getUser_permission_id());
			return this.add(preAdd);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

	private boolean isExisting(UserObject item) {
		boolean flag = false;

		String sql = "SELECT user_id FROM dacn_webbanhang.user WHERE ";
		sql += " user_username = '" + item.getUser_username() + "'";

		ResultSet rs = this.get(sql, 0); // luu ban ghi khi truy xuat tu CSDL ra

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
	public boolean editUser(UserObject item) {
		String sql = "UPDATE `dacn_webbanhang`.`user` SET `user_prefix`=?, `user_name`=?,"
				+ " `user_last_messaged`=?, `user_phonenumber`=?, `user_username`=?,"
				+ (item.getUser_password() == "" ? " " :" `user_password`=md5(?), ")
						+ " `user_address`=?, `user_email`=?, `user_birthdate`=?,"
				+ " `user_Lastlogined`=?, `user_isLogined`=?, `user_gender`=?, `user_note`=?,"
				+ " `user_permission_id`=?" + " WHERE `user_id`=? ";
		try {
			PreparedStatement preEdit = this.con.prepareStatement(sql);
			preEdit.setString(1, item.getUser_prefix());
			preEdit.setString(2, item.getUser_name());
			preEdit.setString(3, item.getUser_last_messased());
			preEdit.setString(4, item.getUser_phonenum());
			preEdit.setString(5, item.getUser_username());
			if(!item.getUser_password().equalsIgnoreCase("")){
				preEdit.setString(6, item.getUser_password());
				preEdit.setString(7, item.getUser_address());
				preEdit.setString(8, item.getUser_email());
				preEdit.setString(9, item.getUser_birthdate());
				preEdit.setInt(10, item.getUser_lastlogined());
				preEdit.setBoolean(11, item.isUser_isloggined());
				preEdit.setBoolean(12, item.isUser_gender());
				preEdit.setString(13, item.getUser_note());
				preEdit.setInt(14, item.getUser_permission_id());
				preEdit.setString(15, item.getUserId());
			}else{
				preEdit.setString(6, item.getUser_address());
				preEdit.setString(7, item.getUser_email());
				preEdit.setString(8, item.getUser_birthdate());
				preEdit.setInt(9, item.getUser_lastlogined());
				preEdit.setBoolean(10, item.isUser_isloggined());
				preEdit.setBoolean(11, item.isUser_gender());
				preEdit.setString(12, item.getUser_note());
				preEdit.setInt(13, item.getUser_permission_id());
				preEdit.setString(14, item.getUserId());
			}

			return this.edit(preEdit);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delUser(UserObject item) {
		if (!this.isEmpty(item)) {
			return false;
		}
		String sql = "DELETE FROM user WHERE user_id = ?";
		try {
			PreparedStatement preDel = this.con.prepareStatement(sql);
			preDel.setString(1, item.getUserId());

			return this.del(preDel);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private boolean isEmpty(UserObject item) {
		boolean flag = true; // mong muon gi thi cho la true hay false

		String sql = "SELECT article_id FROM tblarticle WHERE ";
		sql += " article_author_name = '" + item.getUser_name() + "' ";

		ResultSet rs = this.get(sql, 0); // luu ban ghi khi truy xuat tu CSDL ra

		if (rs != null) {
			try {
				if (rs.next()) {
					flag = false;
				}
				rs.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return true;
	}
	
	private boolean isExistingEmail(UserObject item) {
		boolean flag = false;

		String sql = "SELECT user_id FROM dacn_webbanhang.user WHERE ";
		sql += " user_email = '" + item.getUser_email() + "'";

		ResultSet rs = this.get(sql, 0); // luu ban ghi khi truy xuat tu CSDL ra

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
	
	private UserObject isExistUserName(String input) {
		UserObject item = null;
		String sql = "SELECT user_is_encryption FROM `dacn_webbanhang`.`user` WHERE ";
		if(input.trim().contains("@")){
			sql += " user_email = ? ";
		}else{
			sql += " user_username = ? ";
		}
		ResultSet rs = this.get(sql, input);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserObject();
					item.setUser_is_encryption(rs.getBoolean("user_is_encryption"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}
	@Override
	public ResultSet getUser(String input, String userpass) {
		String sql = "";
		UserObject uo = isExistUserName(input);
		if(uo != null){
			sql += "SELECT * FROM `dacn_webbanhang`.`user` WHERE ";
			if(input.trim().contains("@")){
				sql += " user_email = ? ";
			}else{
				sql += " user_username = ? ";
			}
			if(uo.isUser_is_encryption()){
				sql += " and user_password = md5(?) ";
			}else{
				sql += " and user_password = ? ";
			}
		}
		return this.get(sql, input, userpass);
	}

	@Override
	public boolean addVisitor(Visitor item) {
		String sql = "INSERT INTO `dacn_webbanhang`.`visitor` (`Visitor_id`, `Visitor_prefix`, `Visitor_created_date`, `Visitor_IP`) ";
		sql += " VALUES (?,?,?,?)";
		try {
			PreparedStatement preAdd = this.con.prepareStatement(sql);
			preAdd.setString(1, item.getVisitor_id());
			preAdd.setString(2, item.getVisitor_prefix());
			preAdd.setString(3, item.getVisitor_created_date());
			preAdd.setString(4, item.getVisitor_IP());

			return this.add(preAdd);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delVisitor(Visitor item) {
		String sql = "DELETE FROM visitor WHERE Visitor_id = ?";
		try {
			PreparedStatement preDel = this.con.prepareStatement(sql);
			preDel.setString(1, item.getVisitor_id());

			return this.del(preDel);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet getVisitor(String id) {
		String sql = "SELECT Visitor_id,Visitor_prefix,Visitor_created_date,Visitor_IP FROM dacn_webbanhang.visitor WHERE Visitor_id = ?";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getVisitors(Visitor similar, int at, byte total) {
		String sql = "SELECT Visitor_id,Visitor_prefix,Visitor_created_date,Visitor_IP FROM dacn_webbanhang.visitor ";
		sql += " ORDER BY Visitor_id ASC ";
		sql += "LIMIT " + at + "," + total;
		return this.gets(sql);
	}
	public static void main(String[] args){
        // Tao bo quan ly ket noi
        ConnectionPool cp = new ConnectionPoolImpl();

        //Tao doi tuong thuc thi chuc nang
        User a = new UserImpl(cp);

        // tao doi tuong moi
        UserObject nProduct = new UserObject();
        //nProduct.setUserId("U000000000000005");
        nProduct.setUser_prefix("C");
        nProduct.setUser_name("hthiep-thêm");
        nProduct.setUser_email("hthiep123@gmail.com");
        //Thuc hien
        boolean result = a.addUser(nProduct);
        if(!result){
            System.out.println("\nKhong thanh cong\n");
        }
        //Lay danh sach nguoi su dung

    }

}
