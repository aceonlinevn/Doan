package com.gui.product;

import com.*;
import com.object.*;
import java.sql.*;
import java.util.*;

public class ProductModel {
	private Product p;

	public ProductModel(ConnectionPool cp) {
		this.p = new ProductImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.p = null;
		System.gc();// thu gom rac he thong
		System.runFinalization();// Don dep he thong
	}
	
	public ConnectionPool getConnectionPool() {
		return this.p.getConnectionPool();
	}

	public void releaseConnection() {
		this.p.releaseConnection();
	}    
	public boolean editProduct(ProductObject item){
        return this.p.editProduct(item);
    }
	public ProductObject getProductObject(int id) {
		ProductObject item = null;

		// Lay ban ghi nguoi su dung theo id
		ResultSet rs = this.p.getProduct(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ProductObject();
					item.setProduct_id(rs.getInt("product_id"));
					item.setProduct_prefix(rs.getString("product_prefix"));
					item.setProduct_name(rs.getString("product_name"));
					item.setProduct_status(rs.getBoolean("product_status"));
					item.setProduct_category_id(rs.getInt("product_category_id"));
					item.setProduct_quantity(rs.getInt("product_quantity"));
					item.setProduct_origin_price(rs.getInt("product_origin_price"));
					item.setProduct_price2(rs.getDouble("product_price2"));
					item.setProduct_price3(rs.getDouble("product_price3"));
					item.setProduct_price_discount(rs.getInt("product_price_discount"));
					item.setProduct_imported_date(rs.getString("product_imported_date"));
					item.setProduct_last_modified(rs.getString("product_last_modified"));
					item.setProduct_specification(rs.getString("product_specification"));
					item.setProduct_note(rs.getString("product_note"));
					item.setProduct_warranty_time(rs.getInt("product_warranty_time"));
					item.setProduct_provider_id(rs.getInt("product_provider_id"));
					item.setProduct_image(rs.getString("product_image"));
					item.setProduct_visited(rs.getInt("product_visited"));
					item.setProduct_summary(rs.getString("product_summary"));
					item.setProduct_promotion(rs.getString("product_promotion"));
					item.setProduct_isnew(rs.getBoolean("product_isnew"));
					item.setProduct_isliquidation(rs.getBoolean("product_isliquidation"));
					item.setProduct_isselling(rs.getBoolean("product_isselling"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}
	
	public ArrayList<ProductObject> getProductObjects(ProductObject similar, int page, byte total){
        //Danh sach doi tuong
        ArrayList<ProductObject> items = new ArrayList<ProductObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        ProductObject item = null;

        //Lay ban ghi nguoi su dung theo danh sach
        int at = (page -1)* total;
        ResultSet rs = this.p.getProducts(similar, at, total);
        if(rs != null){
            try {
                while (rs.next()) {
                	item = new ProductObject();
					item.setProduct_id(rs.getInt("product_id"));
					item.setProduct_prefix(rs.getString("product_prefix"));
					item.setProduct_name(rs.getString("product_name"));
					item.setProduct_status(rs.getBoolean("product_status"));
					item.setProduct_category_id(rs.getInt("product_category_id"));
					item.setProduct_quantity(rs.getInt("product_quantity"));
					item.setProduct_origin_price(rs.getInt("product_origin_price"));
					item.setProduct_price2(rs.getDouble("product_price2"));
					item.setProduct_price3(rs.getDouble("product_price3"));
					item.setProduct_price_discount(rs.getInt("product_price_discount"));
					item.setProduct_imported_date(rs.getString("product_imported_date"));
					item.setProduct_last_modified(rs.getString("product_last_modified"));
					item.setProduct_specification(rs.getString("product_specification"));
					item.setProduct_note(rs.getString("product_note"));
					item.setProduct_warranty_time(rs.getInt("product_warranty_time"));
					item.setProduct_provider_id(rs.getInt("product_provider_id"));
					item.setProduct_image(rs.getString("product_image"));
					item.setProduct_visited(rs.getInt("product_visited"));
					item.setCategory_group_name(rs.getString("category_group_name"));
					item.setCategory_name(rs.getString("category_name"));
					item.setProduct_summary(rs.getString("product_summary"));
					item.setProduct_promotion(rs.getString("product_promotion"));
					item.setProduct_isnew(rs.getBoolean("product_isnew"));
					item.setProduct_isliquidation(rs.getBoolean("product_isliquidation"));
					item.setProduct_isselling(rs.getBoolean("product_isselling"));
                    //Them doi tuong vao danh sach
                    items.add(item);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return items;
    }
	public ArrayList<ProductObject> getProductForCategory(int categoryID, int page, byte total){
        //Danh sach doi tuong
        ArrayList<ProductObject> items = new ArrayList<ProductObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        ProductObject item = null;

        //Lay ban ghi nguoi su dung theo danh sach
        int at = (page -1)* total;
        ResultSet rs = this.p.getProductForCategory(categoryID, at, total);
        if(rs != null){
            try {
                while (rs.next()) {
                	item = new ProductObject();
					item.setProduct_id(rs.getInt("product_id"));
					item.setProduct_prefix(rs.getString("product_prefix"));
					item.setProduct_name(rs.getString("product_name"));
					item.setProduct_status(rs.getBoolean("product_status"));
					item.setProduct_category_id(rs.getInt("product_category_id"));
					item.setProduct_quantity(rs.getInt("product_quantity"));
					item.setProduct_origin_price(rs.getInt("product_origin_price"));
					item.setProduct_price2(rs.getDouble("product_price2"));
					item.setProduct_price3(rs.getDouble("product_price3"));
					item.setProduct_price_discount(rs.getInt("product_price_discount"));
					item.setProduct_imported_date(rs.getString("product_imported_date"));
					item.setProduct_last_modified(rs.getString("product_last_modified"));
					item.setProduct_specification(rs.getString("product_specification"));
					item.setProduct_note(rs.getString("product_note"));
					item.setProduct_warranty_time(rs.getInt("product_warranty_time"));
					item.setProduct_provider_id(rs.getInt("product_provider_id"));
					item.setProduct_image(rs.getString("product_image"));
					item.setProduct_visited(rs.getInt("product_visited"));
					item.setCategory_group_name(rs.getString("category_group_name"));
					item.setCategory_name(rs.getString("category_name"));
					item.setProduct_summary(rs.getString("product_summary"));
					item.setProduct_promotion(rs.getString("product_promotion"));
					item.setProduct_isnew(rs.getBoolean("product_isnew"));
					item.setProduct_isliquidation(rs.getBoolean("product_isliquidation"));
					item.setProduct_isselling(rs.getBoolean("product_isselling"));
                    //Them doi tuong vao danh sach
                    items.add(item);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return items;
    }
	public ArrayList<CategoryObject> getCategoryObjects(CategoryObject similar, int page, byte total){
        //Danh sach doi tuong
        ArrayList<CategoryObject> items = new ArrayList<CategoryObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        CategoryObject item = null;

        //Lay ban ghi nguoi su dung theo danh sach
        int at = (page -1)* total;
        ResultSet rs = this.p.getCategorys(similar, at, total);
        if(rs != null){
            try {
                while (rs.next()) {
                	item = new CategoryObject();
					item.setCategory_id(rs.getInt("category_id"));
					item.setCategory_prefix(rs.getString("category_prefix"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_group_id(rs.getInt("category_group_id"));
					item.setCategory_note(rs.getString("category_note"));
					item.setCategory_created_date(rs.getString("category_created_date"));
					item.setCategory_author_created_id(rs.getInt("category_author_created_id"));
					item.setCategory_last_modified(rs.getString("category_last_modified"));
					item.setCategory_mamager_id(rs.getInt("category_manager_id"));
					item.setCategory_is_enable(rs.getBoolean("category_is_enable"));
					item.setCategory_is_deleted(rs.getBoolean("category_isdelete"));
					item.setCategory_images(rs.getString("category_image"));
					item.setCategory_group_name(rs.getString("category_group_name"));
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
