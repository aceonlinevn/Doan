package com.gui.product.categorygroup;

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

}
