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
	
	
	// ************************************************/
	// hungcuong - hien thi san pham tu arraylist
	public String viewProducts(ArrayList<ProductObject> items){
		return ProductLibrary.viewProducts(items);
	}
	
	public ArrayList<ProductObject> getReferencesProduct(String user_id){
		ConnectionPool cp = getConnectionPool();
		UserRateModel ur = new UserRateModel(cp);
		ArrayList<ProductSuggestObject> suggestProduct = ur.CollaborationFilter(user_id);
		int count = (suggestProduct.size()>=6)?6:suggestProduct.size();
		int index = suggestProduct.size();
		for(int i = 0; i< index-1; i++){
			for(int j = i+1; j <index;j++){
				if(suggestProduct.get(i).getUSER_KNN()<suggestProduct.get(j).getUSER_KNN()){
					ProductSuggestObject temp = suggestProduct.get(i);
					suggestProduct.set(i, suggestProduct.get(j));
					suggestProduct.set(j, temp);
				}
			}
		}
		
		ArrayList<ProductObject> listProduct = new ArrayList<>();
		for(ProductSuggestObject product:suggestProduct){
			ProductObject p = getProductObject(product.getProduct_id());
			if(p!=null){
				listProduct.add(p);
			}
		}
		return listProduct;
	}
	
	public static void main (String[] args){
		ConnectionPool cp = new ConnectionPoolImpl();
		ProductControl pc = new ProductControl(cp);
		ArrayList<ProductObject> list = pc.getReferencesProduct("1");
		for(ProductObject item:list){
			System.out.println(item.getProduct_id());
		}
	}
	
}
