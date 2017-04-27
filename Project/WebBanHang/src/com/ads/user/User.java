package com.ads.user;

import com.*;
import com.object.*;
import java.sql.*;


public interface User extends ShareControl {

	public boolean addUser(UserObject item);
    public boolean editUser(UserObject item);
    public boolean delUser(UserObject item);

    public ResultSet getUser(String id);
    public ResultSet getUser(String username,String userpass);
    public ResultSet getUsers(UserObject similar, int at,byte total);
}
