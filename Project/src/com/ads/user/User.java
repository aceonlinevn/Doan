package com.ads.user;

import com.*;
import com.object.*;
import java.sql.*;


public interface User extends ShareControl {

	public ResultSet getUser(int id);


	public ResultSet getUsers(UserObject similar, int at, byte total);
}
