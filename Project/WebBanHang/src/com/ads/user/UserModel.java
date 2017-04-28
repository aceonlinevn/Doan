package com.ads.user;

import com.*;
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

	 public boolean addUser(UserObject item){
	        return this.u.addUser(item);
	    }

	    public boolean editUser(UserObject item){
	        return this.u.editUser(item);
	    }

	    public boolean delUser(UserObject item){
	        return this.u.delUser(item);
	    }
	    
	    
	    
	    public UserObject getUserObject(String username,String userpass){
	        UserObject item = null;

	        //Lay ban ghi nguoi su dung theo username userpass
	        ResultSet rs = this.u.getUser(username,userpass);
	        if(rs != null){
	            try {
	                if (rs.next()) {
	                    item = new UserObject();
	                    item.setUserId(rs.getString("user_id"));
						item.setUser_name(rs.getString("user_name"));
						item.setUser_last_messased(rs.getString("user_last_messaged"));
						item.setUser_phonenum(rs.getString("user_phonenumber"));
						item.setUser_username(rs.getString("user_username"));
						item.setUser_address(rs.getString("user_address"));
						item.setUser_email(rs.getString("user_email"));
						item.setUser_birthdate(rs.getString("user_birthdate"));
						item.setUser_lastlogined(rs.getString("user_Lastlogined"));
						item.setUser_isloggined(rs.getBoolean("user_isLogined"));
						item.setUser_gender(rs.getBoolean("user_gender"));
						item.setUser_note(rs.getString("user_note"));
						item.setUser_permission_id(rs.getShort("user_permission_id"));
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
					item.setUser_last_messased(rs.getString("user_last_messaged"));
					item.setUser_phonenum(rs.getString("user_phonenumber"));
					item.setUser_username(rs.getString("user_username"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_birthdate(rs.getString("user_birthdate"));
					item.setUser_lastlogined(rs.getString("user_Lastlogined"));
					item.setUser_isloggined(rs.getBoolean("user_isLogined"));
					item.setUser_gender(rs.getBoolean("user_gender"));
					item.setUser_note(rs.getString("user_note"));
					item.setUser_permission_id(rs.getShort("user_permission_id"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}
	
	public ArrayList<UserObject> getUserObjects(UserObject similar, int page, byte total){
        //Danh sach doi tuong
        ArrayList<UserObject> items = new ArrayList<UserObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        UserObject item = null;

        //Lay ban ghi nguoi su dung theo danh sach
        int at = (page -1)* total;
        ResultSet rs = this.u.getUsers(similar, at, total);
        if(rs != null){
            try {
                while (rs.next()) {
                    item = new UserObject();
                    item.setUserId(rs.getString("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_last_messased(rs.getString("user_last_messaged"));
					item.setUser_phonenum(rs.getString("user_phonenumber"));
					item.setUser_username(rs.getString("user_username"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_birthdate(rs.getString("user_birthdate"));
					item.setUser_lastlogined(rs.getString("user_Lastlogined"));
					item.setUser_isloggined(rs.getBoolean("user_isLogined"));
					item.setUser_gender(rs.getBoolean("user_gender"));
					item.setUser_note(rs.getString("user_note"));
					item.setUser_permission_id(rs.getShort("user_permission_id"));
                    //Them doi tuong vao danh sach
                    items.add(item);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return items;
    }
}
