package com.gui.bill;

import com.*;
import com.object.*;
import java.util.*;

public class BillControl {
	private BillModel bm;

	public BillControl(ConnectionPool cp) {
		this.bm = new BillModel(cp);
	}

	protected void finalize() throws Throwable {
		this.bm = null;
	}

	public ConnectionPool getConnectionPool() {
		return this.bm.getConnectionPool();
	}

	public void releaseConnection() {
		this.bm.releaseConnection();
	}
	 //**********************************************/
    public boolean addProduct(BillObject item){
        return this.bm.addBill(item);
    }
    public boolean editProduct(BillObject item){
        return this.bm.editBill(item);
    }
    public boolean delProduct(BillObject item){
        return this.bm.delBill(item);
    }
	// ************************************************/

	public BillObject getBillObject(int id) {
		return this.bm.getBillObject(id);
	}

	// ************************************************/
	public String viewBills(BillObject similar, int page, byte total, BillObject Bill) {
		// Lay danh sach doi tuong
		ArrayList items = this.bm.getBillObjects(similar, page, total);

		return BillLibrary.viewBill(items, Bill);
	}
}