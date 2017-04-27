package com.gui.product;

import java.sql.*;

import com.object.*;
import com.sql.gui.MakeConditions;
import com.*;
import com.ads.product.category.*;

public class ProductImpl extends CategoryImpl implements Product {

	public ProductImpl(ConnectionPool cp) {
		super(cp, "Product");
		// TODO Auto-generated constructor stub
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
	

}