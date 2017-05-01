package com.ads.user;

import com.*;
import com.object.*;
import java.sql.*;


public interface User extends ShareControl {

	public boolean addUser(UserObject item);
    public boolean editUser(UserObject item);
    public boolean delUser(UserObject item);

    public boolean addVisitor(Visitor item);
    public boolean delVisitor(Visitor item);
    
    public ResultSet getUser(String id);
    public ResultSet getUser(String username,String userpass);
    public ResultSet getUsers(UserObject similar, int at,byte total);
    
    public ResultSet getVisitor(String id);
    public ResultSet getVisitors(Visitor similar, int at, byte total);
    public String getNextVisitorId() ;
}
