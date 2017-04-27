package com.ads.product;

import com.*;
import com.ads.Collaboration.UserRate;
import com.ads.Collaboration.UserRateControl;
import com.ads.Collaboration.UserRateModel;
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
	 //**********************************************/
    public boolean addProduct(ProductObject item){
        return this.pm.addProduct(item);
    }
    public boolean editProduct(ProductObject item){
        return this.pm.editProduct(item);
    }
    public boolean delProduct(ProductObject item){
        return this.pm.delProduct(item);
    }
	// ************************************************/

	public ProductObject getProductObject(int id) {
		return this.pm.getProductObject(id);
	}

	// ************************************************/
	public String viewProducts(ProductObject similar, int page, byte total) {
		// Lay danh sach doi tuong
		ArrayList items = this.pm.getProductObjects(similar, page, total);

		return ProductLibrary.viewProducts(items);
	}
	
	
	
	
	public static void main (String[] args){
		
	}
	
}
