package com.ads.bill;

import com.*;
import com.object.*;
import java.sql.*;
import java.util.*;

public class BillModel {
	private Bill u;

	public BillModel(ConnectionPool cp) {
		this.u = new BillImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.u = null;
		System.gc();// thu gom rac he thong
		System.runFinalization();// Don dep he thong
	}

	public ConnectionPool getConnectionPool() {
		return this.u.getConnectionPool();
	}

	public void releaseConnection() {
		this.u.releaseConnection();
	}

	// ************************************************/

	 public boolean addBill(BillObject item){
	        return this.u.addBill(item);
	    }

	    public boolean editBill(BillObject item){
	        return this.u.editBill(item);
	    }

	    public boolean delBill(BillObject item){
	        return this.u.delBill(item);
	    }
	    
	   
	public BillObject getBillObject(int id) {
		BillObject item = null;

		// Lay ban ghi nguoi su dung theo id
		ResultSet rs = this.u.getBill(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new BillObject();
					item.setBill_id(rs.getInt("bill_id"));
					item.setBill_prefix(rs.getString("bill_prefix"));
					item.setBill_customer_id(rs.getInt("bill_customer_id"));
					item.setBill_date_created(rs.getString("bill_date_created"));
					item.setBill_payments(rs.getString("bill_payments"));
					item.setBill_advance_payment(rs.getDouble("bill_advance_payment"));
					item.setBill_owe(rs.getDouble("bill_owe"));
					item.setBill_discount(rs.getInt("bill_discount"));
					item.setBill_typeunitprice(rs.getInt("TypeUnitPrice"));
					item.setBill_note(rs.getString("bill_note"));
					item.setBill_total_amount(rs.getDouble("bill_Total_Amount"));
					item.setBill_user_created_id(rs.getInt("bill_user_created_id"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}
	
	public ArrayList<BillObject> getBillObjects(BillObject similar, int page, byte total){
        //Danh sach doi tuong
        ArrayList<BillObject> items = new ArrayList<BillObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        BillObject item = null;

        //Lay ban ghi nguoi su dung theo danh sach
        int at = (page -1)* total;
        ResultSet rs = this.u.getBills(similar, at, total);
        if(rs != null){
            try {
                while (rs.next()) {
                	item = new BillObject();
					item.setBill_id(rs.getInt("bill_id"));
					item.setBill_prefix(rs.getString("bill_prefix"));
					item.setBill_customer_id(rs.getInt("bill_customer_id"));
					item.setBill_date_created(rs.getString("bill_date_created"));
					item.setBill_payments(rs.getString("bill_payments"));
					item.setBill_advance_payment(rs.getDouble("bill_advance_payment"));
					item.setBill_owe(rs.getDouble("bill_owe"));
					item.setBill_discount(rs.getInt("bill_discount"));
					item.setBill_typeunitprice(rs.getInt("TypeUnitPrice"));
					item.setBill_note(rs.getString("bill_note"));
					item.setBill_total_amount(rs.getDouble("bill_Total_Amount"));
					item.setBill_user_created_id(rs.getInt("bill_user_created_id"));
                    //Them doi tuong vao danh sach
                    items.add(item);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return items;
    }
}
