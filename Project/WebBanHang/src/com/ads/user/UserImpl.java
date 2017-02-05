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

	

}
