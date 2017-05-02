package com.gui.bill;

import java.sql.*;

import com.*;
import com.ads.basic.*;
import com.library.Utilities;
import com.object.*;

public class BillImpl extends BasicImpl implements Bill {

	public BillImpl(ConnectionPool cp) {
		super(cp, "Bill");
	}


	@Override
	public ResultSet getBill(int id) {
		String sql = "SELECT bill_id,bill_prefix,bill_customer_id,bill_date_created,bill_payments,bill_advance_payment,"
				+ "bill_owe,bill_discount,bill_TypeUnitPrice,bill_note,bill_Total_Amount,bill_user_created_id "
				+ "FROM dacn_webbanhang.bill "
				+ " WHERE bill_id = ?";
		return this.get(sql, id);
	}



	@Override
	public ResultSet getBills(BillObject similar, int at, byte total) {
		String sql = "SELECT bill_id,bill_prefix,bill_customer_id,bill_date_created,bill_payments,bill_advance_payment,"
				+ "bill_owe,bill_discount,bill_TypeUnitPrice,bill_note,bill_Total_Amount,bill_user_created_id "
				+ "FROM dacn_webbanhang.bill "
				+ "";

		/*
		 * //Lay dieu kien String conds=MakeConditions.createCondition(similar);
		 * if(!conds.equalsIgnoreCase("")){ sql += "WHERE "+conds+" "; }
		 */

		sql += " ORDER BY Bill_id ASC ";
		sql += "LIMIT " + at + "," + total;
		return this.gets(sql);
	}


	@Override
	public boolean addBill(BillObject item) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO `dacn_webbanhang`.`bill` (`bill_customer_id`, `bill_date_created`, `bill_payments`,"
				+ " `bill_advance_payment`, `bill_tranfer`, `bill_discount`, `bill_note`, `bill_Total_Amount`, "
				+ "`bill_status`,bill_user_accept_id,bill_product_detail,bill_accept_date,bill_finish_date)"
				+ " VALUES (?,'"+Utilities.getDateNow()+"',?,?,?,?,?,?,?,?,?,NULL,NULL);";
		 try {
	            PreparedStatement preAdd = this.con.prepareStatement(sql);
	            preAdd.setInt(1,item.getBill_customer_id());
	            preAdd.setString(2,item.getBill_payments());
	            preAdd.setDouble(3,item.getBill_advance_payment());
	            preAdd.setString(4,item.getBill_tranfer());
	            preAdd.setInt(5,item.getBill_discount());
	            preAdd.setString(6,item.getBill_note());
	            preAdd.setInt(7,item.getBill_total_amount());
	            preAdd.setString(8,item.getBill_note());
	            preAdd.setDouble(9,item.getBill_total_amount());
	            preAdd.setInt(10,item.getBill_status());
	            preAdd.setInt(11,item.getBill_user_accept_id());
	            preAdd.setString(12,item.getBill_product_detail());
	            return this.add(preAdd);

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	}

	@Override
	public boolean editBill(BillObject item) {
		String sql = "UPDATE `dacn_webbanhang`.`bill` SET `bill_status`=?,`bill_user_accept_id`=?,bill_accept_date=?,bill_finish_date=? "
				+ " WHERE `bill_id`= ? ";
		 try {
	            PreparedStatement preEdit = this.con.prepareStatement(sql);
	            preEdit.setInt(1,item.getBill_status());
	            preEdit.setInt(2,item.getBill_user_accept_id());
	            preEdit.setString(3,item.getBill_accept_date());
	            preEdit.setString(4,item.getBill_finish_date());
	            preEdit.setInt(5, item.getBill_id());
	            return this.edit(preEdit);

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

	        return false;
	}


	@Override
	public boolean delBill(BillObject item) {
		
	        String sql = "DELETE FROM dacn_webbanhang.bill WHERE bill_id = ?";
	        try {
	            PreparedStatement preDel = this.con.prepareStatement(sql);
	            preDel.setInt(1, item.getBill_id());

	            return this.del(preDel);
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	}
	


	

}
