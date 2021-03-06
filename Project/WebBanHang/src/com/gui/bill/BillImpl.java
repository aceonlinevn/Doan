package com.gui.bill;

import java.sql.*;

import com.*;
import com.ads.basic.*;
import com.ads.product.Product;
import com.ads.product.ProductImpl;
import com.library.Utilities;
import com.object.*;

public class BillImpl extends BasicImpl implements Bill {

	public BillImpl(ConnectionPool cp) {
		super(cp, "Bill");
	}


	@Override
	public ResultSet getBill(int id) {
		String sql = "SELECT * "
				+ "FROM bill "
				+ " WHERE bill_id = ?";
		return this.get(sql, id);
	}



	@Override
	public ResultSet getBills(BillObject similar, int at, byte total) {
		String sql = "SELECT * "
				+ " FROM bill "
				+ " ";

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
		
		String sql = "INSERT INTO bill(bill_customer_id, bill_date_created, bill_payments,"
				+ " bill_advance_payment, bill_tranfer, bill_discount, bill_note, bill_Total_Amount, "
				+ "bill_status,bill_user_accept_id,bill_product_detail,bill_accept_date,bill_finish_date,bill_iscancel)"
				+ " VALUES (?,'"+Utilities.getStringDateNowForSQL()+"',?,?,?,?,?,?,?,?,?,NULL,NULL,0);";
		 try {
	            PreparedStatement preAdd = this.con.prepareStatement(sql);
	            preAdd.setString(1,item.getBill_customer_id());
	            preAdd.setString(2,item.getBill_payments());
	            preAdd.setDouble(3,item.getBill_advance_payment());
	            preAdd.setString(4,item.getBill_tranfer());
	            preAdd.setInt(5,item.getBill_discount());
	            preAdd.setString(6,item.getBill_note());
	            preAdd.setInt(7,item.getBill_total_amount());
	            preAdd.setInt(8,item.getBill_status());
	            preAdd.setString(9,item.getBill_user_accept_id());
	            preAdd.setString(10,item.getBill_product_detail());
	            return this.add(preAdd);

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
		 System.out.println(sql);
	        return false;
	}

	@Override
	public boolean editBill(BillObject item) {
		String sql = "UPDATE bill SET bill_status=?,bill_user_accept_id=?,bill_accept_date=?,bill_finish_date=?,bill_iscancel=? "
				+ " WHERE bill_id= ? ";
		 try {
	            PreparedStatement preEdit = this.con.prepareStatement(sql);
	            preEdit.setInt(1,item.getBill_status());
	            preEdit.setString(2,item.getBill_user_accept_id());
	            preEdit.setString(3,item.getBill_accept_date());
	            preEdit.setString(4,item.getBill_finish_date());
	            preEdit.setBoolean(5,item.isBill_iscancel());
	            preEdit.setInt(6, item.getBill_id());
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


	@Override
	public ResultSet getBillForCus(String cusid) {
		String sql = "SELECT * "
				+ "FROM bill "
				+ " WHERE bill_customer_id = ? AND bill_iscancel = 0 ";
		return this.get(sql, cusid);
	}


	@Override
	public boolean cancelBill(BillObject item) {
		String sql = "UPDATE bill SET bill_iscancel=1 "
				+ " WHERE bill_id= ? ";
		 try {
	            PreparedStatement preEdit = this.con.prepareStatement(sql);
	            preEdit.setInt(1, item.getBill_id());
	            return this.edit(preEdit);

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

	        return false;
	}
	
//	public static void main(String[] args) {
//		// Tao bo quan ly ket noi
//		ConnectionPool cp = new ConnectionPoolImpl();
//
//		// Tao doi tuong thuc thi chuc nang
//		Bill a = new BillImpl(cp);
//
//		// tao doi tuong moi
//		BillObject nProduct = new BillObject();
//		nProduct.setBill_customer_id("C000000000000001");
//		nProduct.setBill_payments("Trả tận nơi");
//		nProduct.setBill_tranfer("Chuyển phát nhanh");
//		// Thuc hien
//		boolean result = a.addBill(nProduct);
//		if (!result) {
//			System.out.println("\nKhong thanh cong\n");
//		}
//		// Lay danh sach nguoi su dung
//
//		ResultSet rs = a.getBills(null, 0, (byte) 10);
//
//		// Duyet va hien thi
//		if (rs != null) {
//			try {
//				while (rs.next()) {
//					System.out.print(rs.getInt("bill_id") + "\t");
//					System.out.print(rs.getString("bill_customer_id") + "\t");
//					System.out.print(rs.getString("bill_payments") + "\t");
//					System.out.print(rs.getString("bill_tranfer") + "\t");
//				}
//			} catch (SQLException ex) {
//				ex.printStackTrace();
//			}
//		}
//	}

	

}
