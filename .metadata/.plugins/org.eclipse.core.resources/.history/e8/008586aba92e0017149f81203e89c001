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

	public BillObject getBillObject(int id) {
		return this.um.getBillObject(id);
	}

	// ************************************************/
	public String viewBills(BillObject similar, int page, byte total, BillObject Bill) {
		// Lay danh sach doi tuong
		ArrayList items = this.um.getBillObjects(similar, page, total);

		return BillLibrary.viewBill(items, Bill);
	}
}
