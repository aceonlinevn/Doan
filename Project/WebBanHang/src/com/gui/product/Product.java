package com.gui.product;

import java.sql.ResultSet;

import com.ShareControl;
import com.object.CategoryObject;
import com.object.ProductObject;

public interface Product extends ShareControl {
	public boolean editProduct(ProductObject item);
    public ResultSet getProduct(int id);
    public ResultSet getProducts(ProductObject similar, int at,byte total);
    public ResultSet getProductForCategory(int categoryID, int at,byte total);
    public ResultSet getCategorys(CategoryObject similar, int at,byte total);
}
