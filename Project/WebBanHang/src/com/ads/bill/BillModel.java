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
	    
	    public BillObject getBillObject(String Billname,String Billpass){
	        BillObject item = null;

	        //Lay ban ghi nguoi su dung theo Billname Billpass
	        ResultSet rs = this.u.getBill(Billname,Billpass);
	        if(rs != null){
	            try {
	                if (rs.next()) {
	                    item = new BillObject();
	                    item.setBillId(rs.getInt("Bill_id"));
						item.setBill_name(rs.getString("Bill_name"));
						item.setBill_last_messased(rs.getString("Bill_last_messaged"));
						item.setBill_phonenum(rs.getString("Bill_phonenumber"));
						item.setBill_Billname(rs.getString("Bill_Billname"));
						item.setBill_address(rs.getString("Bill_address"));
						item.setBill_email(rs.getString("Bill_email"));
						item.setBill_birthdate(rs.getString("Bill_birthdate"));
						item.setBill_lastlogined(rs.getString("Bill_Lastlogined"));
						item.setBill_isloggined(rs.getBoolean("Bill_isLogined"));
						item.setBill_gender(rs.getBoolean("Bill_gender"));
						item.setBill_note(rs.getString("Bill_note"));
						item.setBill_permission_id(rs.getShort("Bill_permission_id"));
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	        return item;
	    }
	public BillObject getBillObject(int id) {
		BillObject item = null;

		// Lay ban ghi nguoi su dung theo id
		ResultSet rs = this.u.getBill(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new BillObject();
					item.setBillId(rs.getInt("Bill_id"));
					item.setBill_name(rs.getString("Bill_name"));
					item.setBill_last_messased(rs.getString("Bill_last_messaged"));
					item.setBill_phonenum(rs.getString("Bill_phonenumber"));
					item.setBill_Billname(rs.getString("Bill_Billname"));
					item.setBill_address(rs.getString("Bill_address"));
					item.setBill_email(rs.getString("Bill_email"));
					item.setBill_birthdate(rs.getString("Bill_birthdate"));
					item.setBill_lastlogined(rs.getString("Bill_Lastlogined"));
					item.setBill_isloggined(rs.getBoolean("Bill_isLogined"));
					item.setBill_gender(rs.getBoolean("Bill_gender"));
					item.setBill_note(rs.getString("Bill_note"));
					item.setBill_permission_id(rs.getShort("Bill_permission_id"));
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
                    item.setBillId(rs.getInt("Bill_id"));
					item.setBill_name(rs.getString("Bill_name"));
					item.setBill_last_messased(rs.getString("Bill_last_messaged"));
					item.setBill_phonenum(rs.getString("Bill_phonenumber"));
					item.setBill_Billname(rs.getString("Bill_Billname"));
					item.setBill_address(rs.getString("Bill_address"));
					item.setBill_email(rs.getString("Bill_email"));
					item.setBill_birthdate(rs.getString("Bill_birthdate"));
					item.setBill_lastlogined(rs.getString("Bill_Lastlogined"));
					item.setBill_isloggined(rs.getBoolean("Bill_isLogined"));
					item.setBill_gender(rs.getBoolean("Bill_gender"));
					item.setBill_note(rs.getString("Bill_note"));
					item.setBill_permission_id(rs.getShort("Bill_permission_id"));
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
