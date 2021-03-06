package com.ads.product.category;

import java.sql.*;
import java.text.*;

import com.*;
import com.ads.product.categorygroup.*;
import com.object.*;
import com.sql.ads.MakeConditions;

public class CategoryImpl extends CategoryGroupImpl implements Category {

	public CategoryImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCategory(CategoryObject item) {
		String sql = "INSERT INTO category(";
		sql += "category_name,category_group_id,";
		sql += "category_note,category_created_date,";
		sql += "category_author_created_id,category_last_modified,";
		sql += "category_manager_id,category_is_enable,category_image,category_icon";
		sql += ")";
		sql += "VALUES(?,?,?,'"+getDateToday()+"',?,'"+getDateToday()+"',?,1,?,?)";
		try{
			PreparedStatement preAdd = this.con.prepareStatement(sql);
			preAdd.setString(1, item.getCategory_name());
			preAdd.setInt(2, item.getCategory_group_id());
			preAdd.setString(3, item.getCategory_note());
			preAdd.setInt(4, item.getCategory_author_created_id());
			preAdd.setInt(5, item.getCategory_mamager_id());
			preAdd.setString(6, item.getCategory_images());
			preAdd.setString(7, item.getCategory_icon());
			
			return this.add(preAdd);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
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
	public boolean editCategory(CategoryObject item) {
		String sql ="UPDATE category SET ";
		sql += "category_name = ?,category_group_id = ?,category_note = ?,";
		sql += "category_created_date = '"+getDateToday()+"',";
		sql += "category_author_created_id = ?,category_last_modified = '"+getDateToday()+"',";
		sql += "category_manager_id = ?,category_is_enable = ?,category_image = ?,category_icon = ?";
		sql += " WHERE category_id = ?";
		
		try {
			PreparedStatement preEdit = this.con.prepareStatement(sql);
			preEdit.setString(1, item.getCategory_name());
			preEdit.setInt(2, item.getCategory_group_id());
			preEdit.setString(3, item.getCategory_note());
			preEdit.setInt(4, item.getCategory_author_created_id());
			preEdit.setInt(5, item.getCategory_mamager_id());
			preEdit.setBoolean(6, item.isCategory_is_enable());
			preEdit.setString(7, item.getCategory_images());
			preEdit.setString(8, item.getCategory_icon());
			preEdit.setInt(9, item.getCategory_id());
			
			return this.edit(preEdit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delCategory(CategoryObject item) {
		if(!isExistingProduct(item)){
			return false;
		}
		String sql = "DELETE FROM category WHERE category_id = ?";
		
		try {
			PreparedStatement preDel = this.con.prepareStatement(sql);
			preDel.setInt(1, item.getCategory_id());
			
			return this.del(preDel);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	
    private boolean isExistingProduct(CategoryObject item){
        boolean flag = true;
        String sql = "SELECT product_id FROM product WHERE product_category_id = "+item.getCategory_id()+"";
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
	public ResultSet getCategory(int id) {
		String sql = "SELECT * FROM category WHERE category_id = ?";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getCategorys(CategoryObject similar, int at, byte total) {
		String sql = "SELECT * FROM category c LEFT JOIN category_group cg ON c.category_group_id = cg.category_group_id ";
		String conds = MakeConditions.createConditionCategory(similar);

        if(!conds.equalsIgnoreCase("")){
            sql += " WHERE "+conds+" ";
        }
        sql +="ORDER BY category_name ASC ";
        if(at != 0 && total != 0){
        	sql +="LIMIT "+ at +","+ total;
        }
        return this.gets(sql);
	}

}
