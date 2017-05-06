package com.ads.user;

import com.*;
import com.library.Utilities;
import com.object.*;
import java.sql.*;
import java.util.*;

public class UserModel {
	private User u;

	public UserModel(ConnectionPool cp) {
		this.u = new UserImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.u = null;
		System.gc();// thu gom rac he thong
		System.runFinalization();// Don dep he thong
	}

	public ConnectionPool getConnectionPool() {
		return this.u.getConnectionPool();
	}

	public void releaseConnection() {
		this.u.releaseConnection();
	}

	// ************************************************/

	public boolean addUser(UserObject item) {
		return this.u.addUser(item);
	}

	public boolean editUser(UserObject item) {
		return this.u.editUser(item);
	}

	public boolean delUser(UserObject item) {
		return this.u.delUser(item);
	}

	public UserObject getUserObject(String username, String userpass) {
		UserObject item = null;

		// Lay ban ghi nguoi su dung theo username userpass
		ResultSet rs = this.u.getUser(username, userpass);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserObject();
					item.setUserId(rs.getString("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_prefix(rs.getString("user_prefix"));
					item.setUser_last_messased(rs.getString("user_last_messaged"));
					item.setUser_phonenum(rs.getString("user_phonenumber"));
					item.setUser_username(rs.getString("user_username"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_birthdate(rs.getString("user_birthdate"));
					item.setUser_lastlogined(rs.getInt("user_Lastlogined"));
					item.setUser_isloggined(rs.getBoolean("user_isLogined"));
					item.setUser_gender(rs.getBoolean("user_gender"));
					item.setUser_password(rs.getString("user_password"));
					item.setUser_note(rs.getString("user_note"));
					item.setUser_permission_id(rs.getShort("user_permission_id"));
					item.setUser_is_encryption(rs.getBoolean("user_is_encryption"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}

	public UserObject getUserObject(String id) {
		UserObject item = null;

		// Lay ban ghi nguoi su dung theo id
		ResultSet rs = this.u.getUser(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserObject();
					item.setUserId(rs.getString("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_prefix(rs.getString("user_prefix"));
					item.setUser_last_messased(rs.getString("user_last_messaged"));
					item.setUser_phonenum(rs.getString("user_phonenumber"));
					item.setUser_username(rs.getString("user_username"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_birthdate(rs.getString("user_birthdate"));
					item.setUser_lastlogined(rs.getInt("user_Lastlogined"));
					item.setUser_isloggined(rs.getBoolean("user_isLogined"));
					item.setUser_gender(rs.getBoolean("user_gender"));
					item.setUser_password(rs.getString("user_password"));
					item.setUser_note(rs.getString("user_note"));
					item.setUser_permission_id(rs.getShort("user_permission_id"));
					item.setUser_is_encryption(rs.getBoolean("user_is_encryption"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList<UserObject> getUserObjects(UserObject similar, int page, byte total) {
		// Danh sach doi tuong
		ArrayList<UserObject> items = new ArrayList<UserObject>();// Mac dinh 10
																	// ptu thieu
																	// thi cho
																	// them thua
																	// bo ra
		UserObject item = null;

		// Lay ban ghi nguoi su dung theo danh sach
		int at = (page - 1) * total;
		ResultSet rs = this.u.getUsers(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new UserObject();
					item.setUserId(rs.getString("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_prefix(rs.getString("user_prefix"));
					item.setUser_last_messased(rs.getString("user_last_messaged"));
					item.setUser_phonenum(rs.getString("user_phonenumber"));
					item.setUser_username(rs.getString("user_username"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_birthdate(rs.getString("user_birthdate"));
					item.setUser_lastlogined(rs.getInt("user_Lastlogined"));
					item.setUser_isloggined(rs.getBoolean("user_isLogined"));
					item.setUser_gender(rs.getBoolean("user_gender"));
					item.setUser_password(rs.getString("user_password"));
					item.setUser_note(rs.getString("user_note"));
					item.setUser_permission_id(rs.getShort("user_permission_id"));
					item.setUser_is_encryption(rs.getBoolean("user_is_encryption"));
					// Them doi tuong vao danh sach
					items.add(item);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return items;
	}

	public boolean addVisitor(Visitor item) {
		return this.u.addVisitor(item);
	}

	public boolean delVisitor(Visitor item) {
		return this.u.delVisitor(item);
	}
	
	public String getNextVisitorId(){
		return this.u.getNextVisitorId();
	}
	

	public Visitor getVisitor(String id) {
		Visitor item = null;

		// Lay ban ghi nguoi su dung theo id
		ResultSet rs = this.u.getVisitor(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new Visitor();
					item.setVisitor_id(rs.getString("Visitor_id"));
					item.setVisitor_prefix(rs.getString("Visitor_prefix"));
					item.setVisitor_created_date(rs.getString("Visitor_created_date"));
					item.setVisitor_IP(rs.getString("Visitor_IP"));
					
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}

	public ArrayList<Visitor> getVisitors(Visitor similar, int page, byte total) {
		// Danh sach doi tuong
		ArrayList<Visitor> items = new ArrayList<Visitor>();
		Visitor item = null;

		// Lay ban ghi nguoi su dung theo danh sach
		int at = (page - 1) * total;
		ResultSet rs = this.u.getVisitors(similar, at, total);
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new Visitor();
					item.setVisitor_id(rs.getString("Visitor_id"));
					item.setVisitor_prefix(rs.getString("Visitor_prefix"));
					item.setVisitor_created_date(rs.getString("Visitor_created_date"));
					item.setVisitor_IP(rs.getString("Visitor_IP"));
					// Them doi tuong vao danh sach
					items.add(item);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return items;
	}
	
	public static void main(String[] args){
		Visitor item = new Visitor();
		item.setVisitor_IP("local");
		item.setVisitor_created_date(Utilities.getStringDateNow());
		ConnectionPool cp = new ConnectionPoolImpl();
		UserModel um = new UserModel(cp);
		um.addVisitor(item);
	}
}
