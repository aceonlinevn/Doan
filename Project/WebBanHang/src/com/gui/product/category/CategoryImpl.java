package com.gui.product.category;

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