package com.gui.product;

import com.*;
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
}
