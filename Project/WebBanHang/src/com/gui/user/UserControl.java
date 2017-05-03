package com.gui.user;

import com.*;
import com.object.*;
import java.util.*;

public class UserControl {
	private UserModel um;

	public UserControl(ConnectionPool cp) {
		this.um = new UserModel(cp);
	}

	protected void finalize() throws Throwable {
		this.um = null;
	}

	public ConnectionPool getConnectionPool() {
		return this.um.getConnectionPool();
	}

	public void releaseConnection() {
		this.um.releaseConnection();
	}
	 //**********************************************/
    public boolean addUser(UserObject item){
        return this.um.addUser(item);
    }
    public boolean editUser(UserObject item){
        return this.um.editUser(item);
    }
    public boolean delUser(UserObject item){
        return this.um.delUser(item);
    }
    public boolean checkPass(UserObject item){
        return this.um.checkPass(item);
    }
	// ************************************************/

	public UserObject getUserObject(String id) {
		return this.um.getUserObject(id);
	}
	 public UserObject getUserObject(String username,String userpass){
	        return this.um.getUserObject(username,userpass);
	    }

	// ************************************************/
	public String viewUsers(UserObject similar, int page, byte total, UserObject user) {
		// Lay danh sach doi tuong
		ArrayList items = this.um.getUserObjects(similar, page, total);

		return UserLibrary.viewUser(items, user);
	}
	public  static void main(String[] args){
		ConnectionPool cp = new ConnectionPoolImpl();
		UserControl uc = new UserControl(cp);
		UserObject item = uc.getUserObject("admin2","admin2");
		if(item!=null)
		{
			System.out.println(item.getUser_username());
			}
		}
}
