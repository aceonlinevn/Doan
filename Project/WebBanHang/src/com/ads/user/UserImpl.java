package com.ads.user;

import java.sql.*;

import com.*;
import com.ads.basic.*;
import com.object.*;

public class UserImpl extends BasicImpl implements User {

	public UserImpl(ConnectionPool cp) {
		super(cp, "user");
	}


	@Override
	public ResultSet getUser(int id) {
		String sql = "SELECT user_id,user_prefix,user_name,user_last_messaged,user_phonenumber,user_username,user_password,"
				+ "user_address,user_email,user_birthdate,user_Lastlogined,user_isLogined,user_gender,user_note,user_permission_id "
				+ " FROM dacn_webbanhang.user "
				+ " WHERE u.userId = ?";
		return this.get(sql, id);
	}



	@Override
	public ResultSet getUsers(UserObject similar, int at, byte total) {
		String sql = "SELECT user_id,user_prefix,user_name,user_last_messaged,user_phonenumber,user_username,user_password,"
				+ "user_address,user_email,user_birthdate,user_Lastlogined,user_isLogined,user_gender,user_note,user_permission_id "
				+ "FROM dacn_webbanhang.user "
				+ "";

		/*
		 * //Lay dieu kien String conds=MakeConditions.createCondition(similar);
		 * if(!conds.equalsIgnoreCase("")){ sql += "WHERE "+conds+" "; }
		 */

		sql += " ORDER BY user_id ASC ";
		sql += "LIMIT " + at + "," + total;
		return this.gets(sql);
	}


	@Override
	public boolean addUser(UserObject item) {
		// TODO Auto-generated method stub
		if(this.isExisting(item)){
            return false;
        }
		String sql = "INSERT INTO `dacn_webbanhang`.`user` "
				+ "(`user_prefix`, `user_name`, `user_last_messaged`, `user_phonenumber`, `user_username`, `user_password`,"
				+ " `user_address`, `user_email`, `user_birthdate`, `user_Lastlogined`, `user_isLogined`, `user_gender`,"
				+ " `user_note`, `user_permission_id`) ";
		sql += " VALUES ('?', '?', '?', '?', '?', 'md5(?)', '?', '?', '?', '?', ?, ?, '?', '?')";
		 try {
	            PreparedStatement preAdd = this.con.prepareStatement(sql);
	            preAdd.setString(1,item.getUser_prefix());
	            preAdd.setString(2,item.getUser_name());
	            preAdd.setString(3,item.getUser_last_messased());
	            preAdd.setString(4,item.getUser_phonenum());
	            preAdd.setString(5,item.getUser_username());
	            preAdd.setString(6,item.getUser_password());
	            preAdd.setString(7,item.getUser_address());
	            preAdd.setString(8,item.getUser_email());
	            preAdd.setString(9,item.getUser_birthdate());
	            preAdd.setString(10,item.getUser_lastlogined());
	            preAdd.setBoolean(11,item.isUser_isloggined());
	            preAdd.setBoolean(12,item.isUser_gender());
	            preAdd.setString(13,item.getUser_note());
	            preAdd.setInt(14,item.getUser_permission_id());
	          

	            return this.add(preAdd);

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	}

	 private boolean isExisting(UserObject item){
	        boolean flag = false;

	        String sql = "SELECT user_id FROM dacn_webbanhang.user WHERE ";
	        sql += " user_username = '"+item.getUser_username()+"'";

	        ResultSet rs = this.get(sql,0); // luu ban ghi khi truy xuat tu CSDL ra

	        if(rs != null){
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
		String sql = "UPDATE `dacn_webbanhang`.`user` SET `user_prefix`='?', `user_name`='?',"
				+ " `user_last_messaged`='?', `user_phonenumber`='?', `user_username`='?',"
				+ " `user_password`='?', `user_address`='?', `user_email`='?', `user_birthdate`='?',"
				+ " `user_Lastlogined`='?', `user_isLogined`=?, `user_gender`=?, `user_note`='?',"
				+ " `user_permission_id`='?'"
				+ " WHERE `user_id`='?' ";
		 try {
	            PreparedStatement preEdit = this.con.prepareStatement(sql);
	            preEdit.setString(1,item.getUser_prefix());
	            preEdit.setString(2,item.getUser_name());
	            preEdit.setString(3,item.getUser_last_messased());
	            preEdit.setString(4,item.getUser_phonenum());
	            preEdit.setString(5,item.getUser_username());
	            preEdit.setString(6,item.getUser_password());
	            preEdit.setString(7,item.getUser_address());
	            preEdit.setString(8,item.getUser_email());
	            preEdit.setString(9,item.getUser_birthdate());
	            preEdit.setString(10,item.getUser_lastlogined());
	            preEdit.setBoolean(11,item.isUser_isloggined());
	            preEdit.setBoolean(12,item.isUser_gender());
	            preEdit.setString(13,item.getUser_note());
	            preEdit.setInt(14,item.getUser_permission_id());
	            preEdit.setInt(15,item.getUserId());

	            return this.edit(preEdit);

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

	        return false;
	}


	@Override
	public boolean delUser(UserObject item) {
		 if(!this.isEmpty(item)){
	            return false;
	        }
	        String sql = "DELETE FROM user WHERE user_id = ?";
	        try {
	            PreparedStatement preDel = this.con.prepareStatement(sql);
	            preDel.setInt(1, item.getUserId());

	            return this.del(preDel);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	}
	private boolean isEmpty(UserObject item){
        boolean flag = true; // mong muon gi thi cho la true hay false

        String sql = "SELECT article_id FROM tblarticle WHERE ";
        sql += " article_author_name = '"+item.getUser_name()+"' ";

        ResultSet rs = this.get(sql,0); // luu ban ghi khi truy xuat tu CSDL ra

        if(rs != null){
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

	@Override
	public ResultSet getUser(String username, String userpass) {
		 String sql = "SELECT * FROM `dacn_webbanhang`.`user` WHERE ";
	        sql += "user_username = ? and user_password = ?";
	        return this.get(sql, username, userpass);
	}

	

}
