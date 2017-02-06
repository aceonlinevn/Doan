package com.ads.bill;

import com.*;
import com.object.*;
import java.util.*;

public class BillControl {
	private BillModel um;

	public BillControl(ConnectionPool cp) {
		this.um = new BillModel(cp);
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

		return BillLibrary.viewUser(items, user);
	}
}
