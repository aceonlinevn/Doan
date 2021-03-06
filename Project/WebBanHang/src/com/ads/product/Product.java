package com.ads.product;

import java.sql.ResultSet;

import com.ShareControl;
import com.object.ProductObject;

public interface Product extends ShareControl {
	public boolean addProduct(ProductObject item);
    public boolean editProduct(ProductObject item);
    public boolean delProduct(ProductObject item);

    public ResultSet getProduct(int id);
    public ResultSet getProducts(ProductObject similar, int at,byte total);
}
