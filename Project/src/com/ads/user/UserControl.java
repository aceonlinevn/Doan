package com.ads.user;

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
	// ************************************************/

	public UserObject getUserObject(int id) {
		return this.um.getUserObject(id);
	}

	// ************************************************/
	public String viewUsers(UserObject similar, int page, byte total, UserObject user) {
		// Lay danh sach doi tuong
		ArrayList items = this.um.getUserObjects(similar, page, total);

		return UserLibrary.viewUser(items, user);
	}
}
