package com.ads.product;

import java.sql.ResultSet;

import com.ConnectionPool;
import com.ads.product.category.*;
import com.object.ProductObject;

public class ProductImpl extends CategoryImpl implements Product {

	public ProductImpl(ConnectionPool cp) {
		super(cp, "Product");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addProduct(ProductObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editProduct(ProductObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delProduct(ProductObject item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getProducts(ProductObject similar, int at, byte total) {
		// TODO Auto-generated method stub
		return null;
	}

}
