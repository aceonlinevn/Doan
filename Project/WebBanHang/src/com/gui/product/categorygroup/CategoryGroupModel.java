package com.gui.product.categorygroup;

import com.*;
import com.object.*;
import java.sql.*;
import java.util.*;

public class CategoryGroupModel {
	private CategoryGroup cg;

	public CategoryGroupModel(ConnectionPool cp) {
		this.cg = new CategoryGroupImpl(cp,"CategoryGroup");
	}

	protected void finalize() throws Throwable {
		this.cg = null;
		System.gc();// thu gom rac he thong
		System.runFinalization();// Don dep he thong
	}

	public ConnectionPool getConnectionPool() {
		return this.cg.getConnectionPool();
	}

	public void releaseConnection() {
		this.cg.releaseConnection();
	}

	// ************************************************/
	    
	   
	public CategoryGroupObject getCategoryGroupObject(int id) {
		CategoryGroupObject item = null;		
		ResultSet rs = this.cg.getCategoryGroup(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new CategoryGroupObject();
					item.setCategory_group_id(rs.getInt("category_group_id"));
					item.setCategory_group_prefix(rs.getString("category_group_prefix"));
					item.setCategory_group_name(rs.getString("category_group_name"));
					item.setCategory_group_note(rs.getString("category_group_note"));
					item.setCategory_group_created_date(rs.getString("category_group_created_date"));
					item.setCategory_group_manager_id(rs.getInt("category_group_manager_id"));
					item.setCategory_group_is_enable(rs.getBoolean("category_group_is_enable"));
					item.setCategory_group_image(rs.getString("category_group_image"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}
	
	public ArrayList<CategoryGroupObject> getCategoryGroupObjects(CategoryGroupObject similar, int page, byte total){
        //Danh sach doi tuong
        ArrayList<CategoryGroupObject> items = new ArrayList<CategoryGroupObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        CategoryGroupObject item = null;

        //Lay ban ghi nguoi su dung theo danh sach
        int at = (page -1)* total;
        ResultSet rs = this.cg.getCategoryGroups(similar, at, total);
        if(rs != null){
            try {
                while (rs.next()) {
                	item = new CategoryGroupObject();
					item.setCategory_group_id(rs.getInt("category_group_id"));
					item.setCategory_group_prefix(rs.getString("category_group_prefix"));
					item.setCategory_group_name(rs.getString("category_group_name"));
					item.setCategory_group_note(rs.getString("category_group_note"));
					item.setCategory_group_created_date(rs.getString("category_group_created_date"));
					item.setCategory_group_manager_id(rs.getInt("category_group_manager_id"));
					item.setCategory_group_is_enable(rs.getBoolean("category_group_is_enable"));
					item.setCategory_group_image(rs.getString("category_group_image"));
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
