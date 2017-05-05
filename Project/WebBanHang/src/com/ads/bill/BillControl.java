package com.ads.bill;

import com.*;
import com.gui.product.ProductLibrary;
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
	public boolean addBill(BillObject item){
        return this.um.addBill(item);
    }

    public boolean editBill(BillObject item){
        return this.um.editBill(item);
    }

    public boolean delBill(BillObject item){
        return this.um.delBill(item);
    }
	// ************************************************/

	public BillObject getBillObject(int id) {
		return this.um.getBillObject(id);
	}

	// ************************************************/
	public String viewBills(BillObject similar) {
		BillLibrary bl = new BillLibrary(this.getConnectionPool());
		// Lay danh sach doi tuong
		ArrayList items = this.um.getBillObjects(similar, 0, (byte) 0);

		return bl.viewBill(items);
	}
}
