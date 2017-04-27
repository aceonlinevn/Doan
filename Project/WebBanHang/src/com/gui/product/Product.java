package com.gui.product;

import java.sql.ResultSet;

import com.ShareControl;
import com.object.ProductObject;

public interface Product extends ShareControl {
    public ResultSet getProduct(int id);
    public ResultSet getProducts(ProductObject similar, int at,byte total);
}