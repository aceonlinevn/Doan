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
		String sql = "SELECT u.userId,u.createDate,u.modifiedDate,u.screenName,u.emailAddress,u.greeting,u.firstName,u.lastName,u.middleName,u.lastLoginDate, u.facebookId, "
				+ " u.lastLoginIp,u.loginDate,u.password_,u.status "
				+ " FROM Liferay.User_ u INNER JOIN Liferay.Users_UserGroups g"
				+ " ON u.userId = g.userId "
				+ " WHERE g.userGroupId = '37737' "
				+ " AND u.userId = ?";
		return this.get(sql, id);
	}



	@Override
	public ResultSet getUsers(UserObject similar, int at, byte total) {
		String sql = "SELECT u.userId,u.createDate,u.modifiedDate,u.screenName,u.emailAddress,u.greeting,u.firstName,u.lastName,u.middleName,u.lastLoginDate, u.facebookId, "
				+ " u.lastLoginIp, u.loginDate,u.password_,u.status "
				+ " FROM Liferay.User_ u INNER JOIN Liferay.Users_UserGroups g"
				+ " ON u.userId = g.userId "
				+ " WHERE g.userGroupId = '37737' ";

		/*
		 * //Lay dieu kien String conds=MakeConditions.createCondition(similar);
		 * if(!conds.equalsIgnoreCase("")){ sql += "WHERE "+conds+" "; }
		 */

		sql += "ORDER BY u.emailAddress ASC ";
		sql += "LIMIT " + at + "," + total;
		return this.gets(sql);
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		User u = new UserImpl(cp);

		ResultSet rs = u.getUsers(null, 0, (byte) 10);
		if (rs != null) {
			try {
				while (rs.next()) {
					System.out.print(rs.getInt("userId") + "\t");
					System.out.print(rs.getString("createDate") + "\t");
					System.out.print(rs.getString("screenName") + "\t");
					System.out.print(rs.getString("greeting") + "\t");
					System.out.print(rs.getString("firstname") + "\t");
					System.out.print(rs.getString("lastName") + "\t");
					System.out.print(rs.getString("middleName") + "\t");
					
					System.out.print(rs.getString("emailAddress") + "\n");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
