package com.ads.product;

import java.sql.*;

import com.object.*;
import com.sql.ads.MakeConditions;
import com.*;
import com.ads.product.category.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class ProductImpl extends CategoryImpl implements Product {

	public ProductImpl(ConnectionPool cp) {
		super(cp, "Product");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addProduct(ProductObject item) {
		String sql = "INSERT INTO product(";
		sql += "product_prefix,product_name,product_status,product_category_id,";
		sql += "product_quantity,product_origin_price,product_price2,";
		sql += "product_price3,product_price_discount,product_imported_date,";
		sql += "product_specification,product_note,";
		sql += "product_warranty_time,product_provider_id,product_image,product_summary,product_promotion,product_isnew,product_isliquidation,product_isselling";
		sql += ")";
		sql += "VALUES(?,?,?,?,?,?,?,?,?,'"+getDateToday()+"',?,?,?,?,?,?,?,?,?,?)";
		System.out.println("insert: "+sql);
		try {
			PreparedStatement preAdd = this.con.prepareStatement(sql);
			preAdd.setString(1, item.getProduct_prefix());
			preAdd.setString(2, item.getProduct_name());
			preAdd.setBoolean(3, item.isProduct_status());
			preAdd.setInt(4, item.getProduct_category_id());
			preAdd.setInt(5, item.getProduct_quantity());
			preAdd.setDouble(6, item.getProduct_origin_price());
			preAdd.setDouble(7, item.getProduct_price2());
			preAdd.setDouble(8, item.getProduct_price3());
			preAdd.setInt(9, item.getProduct_price_discount());
			preAdd.setString(10, item.getProduct_specification());
			preAdd.setString(11,item.getProduct_note());
			preAdd.setInt(12, item.getProduct_warranty_time());
			preAdd.setInt(13,item.getProduct_provider_id());
			preAdd.setString(14, item.getProduct_image());
			preAdd.setString(15, item.getProduct_summary());
			preAdd.setString(16, item.getProduct_promotion());
			preAdd.setBoolean(17, item.isProduct_isnew());
			preAdd.setBoolean(18, item.isProduct_isliquidation());
			preAdd.setBoolean(19, item.isProduct_isselling());
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
	public boolean delProduct(ProductObject item) {
		if(!isExistingImages(item)){
			return false;
		}
		
		String sql = "DELETE FROM product WHERE product_id = ?";
		
		try {
			PreparedStatement preDel = this.con.prepareStatement(sql);
			preDel.setInt(1, item.getProduct_id());
			
			return this.del(preDel);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean isExistingImages(ProductObject item){
        boolean flag = true;
        String sql = "SELECT images_id FROM tblimages WHERE images_product_id = "+item.getProduct_id()+"";
        ResultSet rs = this.get(sql,0);
        if(rs !=null){
            try {
                if (rs.next()) {
                    flag = false;
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return flag;
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
	
	public static void main(String[] args){
        // Tao bo quan ly ket noi
        ConnectionPool cp = new ConnectionPoolImpl();

        //Tao doi tuong thuc thi chuc nang
        Product a = new ProductImpl(cp);

        // tao doi tuong moi
        ProductObject nProduct = new ProductObject();
        nProduct.setProduct_id(1);
        nProduct.setProduct_name("ban moi3");
        nProduct.setProduct_category_id(2);
        //Thuc hien
        boolean result = a.addProduct(nProduct);
        if(!result){
            System.out.println("\nKhong thanh cong\n");
        }
        //Lay danh sach nguoi su dung

        ResultSet rs = a.getProducts(null,0,(byte) 10);

        //Duyet va hien thi
        if(rs !=null){
            try {
                while (rs.next()) {
                    System.out.print(rs.getInt("product_id")+"\t");
                    System.out.print(rs.getString("product_name")+"\t");
                    System.out.print(rs.getString("product_imported_date")+"\t");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
