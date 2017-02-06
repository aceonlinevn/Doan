package com.ads.bill;

import java.sql.*;

import com.*;
import com.ads.basic.*;
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
		
		String sql = "INSERT INTO `dacn_webbanhang`.`bill` (`bill_prefix`, `bill_customer_id`, `bill_date_created`, `bill_payments`,"
				+ " `bill_advance_payment`, `bill_owe`, `bill_discount`, `bill_TypeUnitPrice`, `bill_note`, `bill_Total_Amount`, "
				+ "`bill_user_created_id`)"
				+ " VALUES ('?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?');";
		 try {
	            PreparedStatement preAdd = this.con.prepareStatement(sql);
	            preAdd.setString(1,item.getBill_prefix());
	            preAdd.setInt(2,item.getBill_customer_id());
	            preAdd.setString(3,item.getBill_date_created());
	            preAdd.setString(4,item.getBill_payments());
	            preAdd.setDouble(5,item.getBill_advance_payment());
	            preAdd.setDouble(6,item.getBill_owe());
	            preAdd.setInt(7,item.getBill_discount());
	            preAdd.setInt(8,item.getBill_typeunitprice());
	            preAdd.setString(9,item.getBill_note());
	            preAdd.setDouble(10,item.getBill_total_amount());
	            preAdd.setInt(11,item.getBill_user_created_id());
	            return this.add(preAdd);

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	}

	@Override
	public boolean editBill(BillObject item) {
		String sql = "UPDATE `dacn_webbanhang`.`bill` SET `bill_prefix`='?', `bill_customer_id`='?',"
				+ " `bill_date_created`='?', `bill_payments`='?', `bill_advance_payment`='?', `bill_owe`='?',"
				+ " `bill_discount`='?', `bill_TypeUnitPrice`='?', `bill_note`='?', `bill_Total_Amount`='?',"
				+ " `bill_user_created_id`='?'"
				+ " WHERE `bill_id`='?';";
		 try {
	            PreparedStatement preEdit = this.con.prepareStatement(sql);
	            preEdit.setString(1,item.getBill_prefix());
	            preEdit.setInt(2,item.getBill_customer_id());
	            preEdit.setString(3,item.getBill_date_created());
	            preEdit.setString(4,item.getBill_payments());
	            preEdit.setDouble(5,item.getBill_advance_payment());
	            preEdit.setDouble(6,item.getBill_owe());
	            preEdit.setInt(7,item.getBill_discount());
	            preEdit.setInt(8,item.getBill_typeunitprice());
	            preEdit.setString(9,item.getBill_note());
	            preEdit.setDouble(10,item.getBill_total_amount());
	            preEdit.setInt(11,item.getBill_user_created_id());
	            preEdit.setInt(12, item.getBill_id());
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
