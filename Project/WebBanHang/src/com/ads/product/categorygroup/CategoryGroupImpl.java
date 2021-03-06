package com.ads.product.categorygroup;

import java.sql.*;
import java.text.*;

import com.*;
import com.ads.basic.*;
import com.ads.product.Product;
import com.ads.product.ProductImpl;
import com.object.*;
import com.sql.ads.MakeConditions;

public class CategoryGroupImpl extends BasicImpl implements CategoryGroup {

	public CategoryGroupImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCategoryGroup(CategoryGroupObject item) {
		String sql = "INSERT INTO category_group(";
		sql += "category_group_name,category_group_note,";
		sql += "category_group_created_date,";
		sql += "category_group_manager_id,category_group_is_enable,";
		sql += "category_group_image";
		sql += ")";
		sql += "VALUES(?,?,'"+getDateToday()+"',?,?,?)";
		try{
			PreparedStatement preAdd = this.con.prepareStatement(sql);
			preAdd.setString(1, item.getCategory_group_name());
			preAdd.setString(2, item.getCategory_group_note());
			preAdd.setInt(3, item.getCategory_group_manager_id());
			preAdd.setBoolean(4, item.isCategory_group_is_enable());
			preAdd.setString(5,item.getCategory_group_image());
			
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
	public boolean editCategoryGroup(CategoryGroupObject item) {
		String sql ="UPDATE category_group SET ";
		sql += "category_group_name = ?,category_group_note = ?,";
		sql += "category_group_created_date = '"+getDateToday()+"',";
		sql += "category_group_manager_id = ?,category_group_is_enable = ?,";
		sql += "category_group_image = ?";
		sql += " WHERE category_group_id = ?";
		
		try {
			PreparedStatement preEdit = this.con.prepareStatement(sql);
			preEdit.setString(1, item.getCategory_group_name());
			preEdit.setString(2, item.getCategory_group_note());
			preEdit.setInt(3, item.getCategory_group_manager_id());
			preEdit.setBoolean(4, item.isCategory_group_is_enable());
			preEdit.setString(5, item.getCategory_group_image());
			preEdit.setInt(6, item.getCategory_group_id());
			
			return this.edit(preEdit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delCategoryGroup(CategoryGroupObject item) {
		if(!isExistingCategory(item)){
			return false;
		}
		String sql = "DELETE FROM category_group WHERE category_group_id = ?";
		
		try {
			PreparedStatement preDel = this.con.prepareStatement(sql);
			preDel.setInt(1, item.getCategory_group_id());
			
			return this.del(preDel);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	
    private boolean isExistingCategory(CategoryGroupObject item){
        boolean flag = true;
        String sql = "SELECT category_id FROM category WHERE category_group_id = "+item.getCategory_group_id()+"";
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
	public ResultSet getCategoryGroup(int id) {
		String sql = "SELECT * FROM category_group WHERE category_group_id = ?";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getCategoryGroups(CategoryGroupObject similar, int at, byte total) {
		String sql = "SELECT * FROM category_group ";
		String conds = MakeConditions.createConditionCategoryGroup(similar);

        if(!conds.equalsIgnoreCase("")){
            sql += "WHERE "+conds+" ";
        }
        sql +="ORDER BY category_group_name ASC ";
        if(at !=0 && total !=0){
        	sql +="LIMIT "+ at +","+ total;
        }
        return this.gets(sql);
	}
	public static void main(String[] args){
        // Tao bo quan ly ket noi
        ConnectionPool cp = new ConnectionPoolImpl();

        //Tao doi tuong thuc thi chuc nang
        CategoryGroup a = new CategoryGroupImpl(cp,"CategoryGroup");

        // tao doi tuong moi
        CategoryGroupObject nProduct = new CategoryGroupObject();
        nProduct.setCategory_group_name("test");
        nProduct.setCategory_group_is_enable(false);
        nProduct.setCategory_group_note("note");
        //Thuc hien
        boolean result = a.addCategoryGroup(nProduct);
        if(!result){
            System.out.println("\nKhong thanh cong\n");
        }
        //Lay danh sach nguoi su dung

        ResultSet rs = a.getCategoryGroups(null,0,(byte) 10);

        //Duyet va hien thi
        if(rs !=null){
            try {
                while (rs.next()) {
                    System.out.print(rs.getString("category_group_name")+"\t");
                    System.out.print(rs.getString("category_group_created_date")+"\t");
                    System.out.print(rs.getString("category_group_is_enable")+"\t");
                    System.out.print(rs.getString("category_group_note")+"\t");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
