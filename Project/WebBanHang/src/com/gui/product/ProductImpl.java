package com.gui.product;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.object.*;
import com.sql.gui.MakeConditions;
import com.*;
import com.ads.product.category.*;
import com.gui.product.category.Category;
import com.gui.product.category.CategoryImpl;

public class ProductImpl extends CategoryImpl implements Product {

	public ProductImpl(ConnectionPool cp) {
		super(cp, "Product");
		// TODO Auto-generated constructor stub
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
		String sql = "UPDATE product SET ";
		sql += "product_prefix=?,product_name = ?,product_status = ?,";
		sql += "product_category_id = ?,product_quantity = ?,";
		sql += "product_origin_price = ?,product_price2 = ?,";
		sql += "product_price3 = ?,product_price_discount = ?,";
		sql += "product_last_modified = '"+getDateToday()+"',product_specification = ?,";
		sql += "product_note = ?,product_warranty_time = ?,";
		sql += "product_provider_id = ?,product_image = ?,product_summary = ?,product_promotion = ?,product_isnew = ?,product_isliquidation = ?,product_isselling = ?";
		sql += " WHERE product_id = ?";
		System.out.println("update: "+sql);
		try {
			PreparedStatement preEdit = this.con.prepareStatement(sql);
			preEdit.setString(1, item.getProduct_prefix());
			preEdit.setString(2, item.getProduct_name());
			preEdit.setBoolean(3, item.isProduct_status());
			preEdit.setInt(4, item.getProduct_category_id());
			preEdit.setInt(5, item.getProduct_quantity());
			preEdit.setDouble(6, item.getProduct_origin_price());
			preEdit.setDouble(7, item.getProduct_price2());
			preEdit.setDouble(8, item.getProduct_price3());
			preEdit.setInt(9, item.getProduct_price_discount());
			preEdit.setString(10, item.getProduct_specification());
			preEdit.setString(11,item.getProduct_note());
			preEdit.setInt(12, item.getProduct_warranty_time());
			preEdit.setInt(13,item.getProduct_provider_id());
			preEdit.setString(14, item.getProduct_image());
			preEdit.setString(15, item.getProduct_summary());
			preEdit.setString(16, item.getProduct_promotion());
			preEdit.setBoolean(17, item.isProduct_isnew());
			preEdit.setBoolean(18, item.isProduct_isliquidation());
			preEdit.setBoolean(19, item.isProduct_isselling());
			preEdit.setInt(20, item.getProduct_id());
			
			return this.edit(preEdit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public ResultSet getProduct(int id) {
		String sql = "SELECT * FROM product WHERE product_id = ?";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getProducts(ProductObject similar, int at, byte total) {
		String sql = "SELECT * FROM product p LEFT JOIN category c ON p.product_category_id = c.category_id LEFT JOIN category_group cg ON c.category_group_id = cg.category_group_id ";
		String conds = MakeConditions.createConditionProduct(similar);

        if(!conds.equalsIgnoreCase("")){
            sql += " WHERE "+conds+" ";
        }
        
        sql +=" ORDER BY product_name ASC ";
        sql +=" LIMIT "+ at +","+ total;
        return this.gets(sql);
	}
	
	@Override
	public ResultSet getProductForCategory(int categoryID, int at, byte total) {
		String sql = "SELECT * FROM product p LEFT JOIN category c ON p.product_category_id = c.category_id LEFT JOIN category_group cg ON c.category_group_id = cg.category_group_id ";
		sql += " WHERE product_category_id = "+categoryID+" AND c.category_is_enable = 1 ";
        sql +=" ORDER BY product_name ASC ";
        
        sql +=" LIMIT "+ at +","+ total;
        return this.gets(sql);
	}
	@Override
	public ResultSet getCategorys(CategoryObject similar, int at, byte total) {
		String sql = "SELECT * FROM category c LEFT JOIN category_group cg ON c.category_group_id = cg.category_group_id ";
		/*String conds = MakeConditions.createConditionCategory(similar);

        if(!conds.equalsIgnoreCase("")){
            sql += " WHERE "+conds+" ";
        }*/
        sql +="ORDER BY category_name ASC ";
        if(at != 0 && total != 0){
        	sql +="LIMIT "+ at +","+ total;
        }
        return this.gets(sql);
	}
	
}
