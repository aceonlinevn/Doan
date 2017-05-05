package com.gui.product.category;

import java.sql.*;
import java.text.*;

import com.*;
import com.ads.product.Product;
import com.ads.product.ProductImpl;
import com.ads.product.categorygroup.*;
import com.object.*;
import com.sql.ads.MakeConditions;

public class CategoryImpl extends CategoryGroupImpl implements Category {

	public CategoryImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public ResultSet getCategory(int id) {
		String sql = "SELECT * FROM category WHERE category_id = ? ";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getCategorys(CategoryObject similar, int at, byte total) {
		String sql = "SELECT * FROM category c LEFT JOIN category_group cg ON c.category_group_id = cg.category_group_id ";
		String conds = MakeConditions.createConditionCategory(similar);

        if(!conds.equalsIgnoreCase("")){
            sql += " WHERE c.category_is_enable = 1 AND "+conds+" ";
        }else{
        	sql += " WHERE c.category_is_enable = 1 ";
        }
        sql +="ORDER BY category_name ASC ";
        if(at != 0 && total != 0){
        	sql +="LIMIT "+ at +","+ total;
        }
        return this.gets(sql);
	}
//	public static void main(String[] args){
//        // Tao bo quan ly ket noi
//        ConnectionPool cp = new ConnectionPoolImpl();
//
//        //Tao doi tuong thuc thi chuc nang
//        Category a = new CategoryImpl(cp,"Category");
//
//        // tao doi tuong moi
//        CategoryObject nProduct = new CategoryObject();
//        //Thuc hien
//        
//        //Lay danh sach nguoi su dung
//
//        ResultSet rs = a.getCategorys(null,0,(byte) 10);
//
//        
//    }
}
