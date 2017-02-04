package com.ads.basic;

import java.sql.*;

import com.*;

public interface Basic extends ShareControl {
	 public boolean add(PreparedStatement pre);
	    public boolean edit(PreparedStatement pre);
	    public boolean del(PreparedStatement pre);// phai duoc bien dich va set gia tri sau do moi truyen vao

	    public ResultSet get(String sql,int value);
	    public ResultSet get(String sql,String name,String pass);
	    public ResultSet gets(String sql);
	    public ResultSet[] gets(String[] sqls); // lay nhieu tap ban ghi
	    //3 cach thuc thi
	    //- Statement : có cau lenh la thuc thi >> 1 cau lenh thuc thi 1 lan  chi dung 1 lan
	    //- PreparedStatement : k tu dong thuc thi ma cho doi su ra lenh cua nguoi.
	    // lap trinh 1 lan thuc thi dc nhieu cong viec. phai huy cau lenh tu dong thuc thi cua sql >> nhanh
	   // >> viet cau lenh truc tiep trong ma nguon >> duoc su dung nhieu nhat
	    //-CallableStatement : nhanh nhat. nhunng phai viet thu tuc trong sql.
	    //neu co loi lai phai viet lai trong cau lenh sql

	  /* Chuyen sang ShareControl
	    //Chia se bo quan ly ket noi giua cac doi tuong basic voi nhau
	    public ConnectionPool getConnectionPool();
	    //Ra lenh cac doi tuong tra ve ket noi
	    public void releaseConnection();
	  */
}
