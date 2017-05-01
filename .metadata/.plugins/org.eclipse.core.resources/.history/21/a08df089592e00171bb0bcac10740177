package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPoolImpl implements ConnectionPool{
	 //De luu tru ket noi nguoi ta dung stack ap dung last in first out - LIFO
    //Tai khoan dang nhap CSDL
    private String username,userpass;

    //Trinh dieu khien lam viec või he quan tri Mysql
    private String driver;

    //Duong dan chay Mysql
    private String url;

    //Doi tuong luu tru cac ket noi
    private Stack pool;

	public ConnectionPoolImpl() {
		//Xác ðinh thông tin tai khoan
        this.username = "root";
        this.userpass = "123456";

        //Xac dinh trinh dieu khien
        this.driver = "com.mysql.jdbc.Driver";

        //Xac dinh duong dan chay Mysql
        this.url = "jdbc:mysql://localhost:3306/dacn_webbanhang?autoReconnect=true&useSSL=false";
        //Khoi tao bo nho lýu tru ket noi
        this.pool = new Stack();

        //Nap trinh dieu khien
        this.loadDriver();
	}
	
	private void loadDriver(){
        try {
            Class.forName(this.driver).newInstance();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
    }

	@Override
	public Connection getConnection(String objectName) throws SQLException {
		  if(this.pool.isEmpty()){
	            System.out.println(objectName+ " have create a new Connection!\n");
	            return DriverManager.getConnection(this.url,this.username,this.userpass);
	        }else{
	            System.out.println(objectName+ " have popped the Connection!");
	            return (Connection) this.pool.pop(); // pop lay ra
	        }
	}

	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException {
		 System.out.println(objectName+ " have pushed the Connection!");
	        this.pool.push(con); // push day vao
		
	}

    //Phuong thuc don dep viet cuoi cung
    protected void finalize() throws Throwable{
        this.pool.clear();
        this.pool = null;

        super.finalize();

        System.out.println("ConnectionPool is closed!");
    }
    public static void main(String[] args){
    	ConnectionPool cp = new ConnectionPoolImpl();
    	try {
			cp.getConnection("User");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
