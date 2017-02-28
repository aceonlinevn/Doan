package com.ads.product;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.ConnectionPool;
import com.ads.product.category.*;
import com.object.ProductObject;

public class ProductImpl extends CategoryImpl implements Product {

	public ProductImpl(ConnectionPool cp) {
		super(cp, "Product");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addProduct(ProductObject item) {
		String sql = "INSERT INTO product(";
		sql += "product_name,product_status,product_category_id,";
		sql += "product_quantity,product_origin_price,product_price2,";
		sql += "product_price3,product_price_discount,product_imported_date,";
		sql += "product_specification,product_note,";
		sql += "product_warranty_time,product_provider_id";
		sql += ")";
		sql += "VALUES(?,?,?,?,?,?,?,?,'"+getDateToday()+"',?,?,?,?)";
		
		try {
			PreparedStatement preAdd = this.con.prepareStatement(sql);
			preAdd.setString(1, item.getProduct_name());
			preAdd.setBoolean(2, item.isProduct_status());
			preAdd.setInt(3, item.getProduct_category_id());
			preAdd.setInt(4, item.getProduct_quantity());
			preAdd.setDouble(5, item.getProduct_origin_price());
			preAdd.setDouble(6, item.getProduct_price2());
			preAdd.setDouble(7, item.getProduct_price3());
			preAdd.setInt(8, item.getProduct_price_discount());
			preAdd.setString(9, item.getProduct_specification());
			preAdd.setString(10,item.getProduct_note());
			preAdd.setInt(11, item.getProduct_warranty_time());
			preAdd.setInt(12,item.getProduct_provider_id());
			
			return this.add(preAdd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	private String getDateToday(){
        String datetoday = "";
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        datetoday = df.format(date);
        return datetoday;
    }
	
	@Override
	public boolean editProduct(ProductObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delProduct(ProductObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getProducts(ProductObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		return null;
	}

}
