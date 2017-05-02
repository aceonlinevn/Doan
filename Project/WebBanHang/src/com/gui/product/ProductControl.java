package com.gui.product;

import com.*;
import com.ads.Collaboration.UserRateModel;
import com.gui.product.ProductLibrary;
import com.object.*;
import java.util.*;

public class ProductControl {
	private ProductModel pm;

	public ProductControl(ConnectionPool cp) {
		this.pm = new ProductModel(cp);
	}

	protected void finalize() throws Throwable {
		this.pm = null;
	}

	public ConnectionPool getConnectionPool() {
		return this.pm.getConnectionPool();
	}

	public void releaseConnection() {
		this.pm.releaseConnection();
	}
	// ************************************************/

	public ProductObject getProductObject(int id) {
		return this.pm.getProductObject(id);
	}

	// ************************************************/
	public String viewProducts(ProductObject similar, byte total) {
		// Lay danh sach doi tuong
		ArrayList items = this.pm.getProductObjects(similar, 1, total);

		return ProductLibrary.viewProduct(items);
	}

	public String viewProductsForCategory(ProductObject similar) {
		ProductLibrary pl = new ProductLibrary(this.getConnectionPool());
		ArrayList items = this.pm.getCategoryObjects(similar, 0, (byte) 0);
		return pl.viewProductForCategory(items);
	}

	// ************************************************/
	// hungcuong - hien thi san pham tu arraylist
	public String viewProducts2(ArrayList<ProductObject> items) {
		return ProductLibrary.viewProduct(items);
	}

	public ArrayList<ProductObject> getReferencesProduct(String user_id) {
		ConnectionPool cp = getConnectionPool();
		UserRateModel ur = new UserRateModel(cp);
		ArrayList<ProductSuggestObject> suggestProduct = ur.CollaborationFilter(user_id);
		int count = (suggestProduct.size() >= 6) ? 6 : suggestProduct.size();
		for (int i = 0; i < suggestProduct.size() - 1; i++) {
			for (int j = i + 1; j < suggestProduct.size(); j++) {
				if (suggestProduct.get(i).getProduct_id() == suggestProduct.get(j).getProduct_id()) {
					if (suggestProduct.get(i).getUSER_KNN() < suggestProduct.get(j).getUSER_KNN()) {
						suggestProduct.remove(i);
					} else {
						suggestProduct.remove(j);
					}
				}
				if (suggestProduct.get(i).getProduct_id() < suggestProduct.get(j).getProduct_id()) {
					ProductSuggestObject temp = suggestProduct.get(i);
					suggestProduct.set(i, suggestProduct.get(j));
					suggestProduct.set(j, temp);
				}
			}
		}

		for (int i = 0; i < suggestProduct.size() - 1; i++) {
			for (int j = i + 1; j < suggestProduct.size(); j++) {
				if (suggestProduct.get(i).getUSER_KNN() < suggestProduct.get(j).getUSER_KNN()) {
					ProductSuggestObject temp = suggestProduct.get(i);
					suggestProduct.set(i, suggestProduct.get(j));
					suggestProduct.set(j, temp);
				}
			}
		}
		ArrayList<ProductObject> listProduct = new ArrayList<>();
		for (ProductSuggestObject product : suggestProduct) {
			ProductObject p = getProductObject(product.getProduct_id());
			if (p != null) {
				listProduct.add(p);
			}
		}
		return listProduct;
	}
	
	public static void main(String[] args){
		ConnectionPool cp = new ConnectionPoolImpl();
		ProductControl pc = new ProductControl(cp);
		ArrayList<ProductObject> items = pc.getReferencesProduct("U000000000000001");
		for(ProductObject item:items){
			System.out.println(item.getProduct_id());
		}
	}
}
