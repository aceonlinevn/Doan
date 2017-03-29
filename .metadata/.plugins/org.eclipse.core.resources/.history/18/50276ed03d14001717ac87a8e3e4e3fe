package com.ads.product.category;

import com.*;
import com.object.*;
import java.sql.*;
import java.util.*;

public class CategoryModel {
	private Category c;

	public CategoryModel(ConnectionPool cp) {
		this.c = new CategoryImpl(cp,"Category");
	}

	protected void finalize() throws Throwable {
		this.c = null;
		System.gc();// thu gom rac he thong
		System.runFinalization();// Don dep he thong
	}

	public ConnectionPool getConnectionPool() {
		return this.c.getConnectionPool();
	}

	public void releaseConnection() {
		this.c.releaseConnection();
	}

	// ************************************************/

	 public boolean addCategory(CategoryObject item){
	        return this.c.addCategory(item);
	    }

	    public boolean editCategory(CategoryObject item){
	        return this.c.editCategory(item);
	    }

	    public boolean delCategory(CategoryObject item){
	        return this.c.delCategory(item);
	    }
	    
	   
	public CategoryObject getCategoryObject(int id) {
		CategoryObject item = null;		
		ResultSet rs = this.c.getCategory(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new CategoryObject();
					item.setCategory_id(rs.getInt("category_id"));
					item.setCategory_prefix(rs.getString("category_prefix"));
					item.setCategory_name(rs.getString("category_name"));
					item.setCategory_group_id(rs.getInt("category_group_id"));
					item.setCategory_note(rs.getString("category_note"));
					item.setCategory_created_date(rs.getString("category_created_date"));
					item.setCategory_author_created_id(rs.getInt("category_author_created_id"));
					item.setCategory_last_modified(rs.getString("category_last_modified"));
					item.setCategory_mamager_id(rs.getInt("category_mamager_id"));
					item.setCategory_is_enable(rs.getBoolean("category_is_enable"));
					item.setCategory_is_deleted(rs.getBoolean("category_isdeleted"));
					item.setCategory_images(rs.getString("category_image"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}
	
	public ArrayList<CategoryObject> getCategoryObjects(CategoryObject similar, int page, byte total){
        //Danh sach doi tuong
        ArrayList<CategoryObject> items = new ArrayList<CategoryObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        CategoryObject item = null;

        //Lay ban ghi nguoi su dung theo danh sach
        int at = (page -1)* total;
        ResultSet rs = this.c.getCategorys(similar, at, total);
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
					item.setCategory_mamager_id(rs.getInt("category_mamager_id"));
					item.setCategory_is_enable(rs.getBoolean("category_is_enable"));
					item.setCategory_is_deleted(rs.getBoolean("category_isdeleted"));
					item.setCategory_images(rs.getString("category_image"));
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
