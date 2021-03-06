package com.ads.product.category;

import com.*;
import com.object.*;
import java.util.*;

public class CategoryControl {
	private CategoryModel cg;

	public CategoryControl(ConnectionPool cp) {
		this.cg = new CategoryModel(cp);
	}

	protected void finalize() throws Throwable {
		this.cg = null;
	}

	public ConnectionPool getConnectionPool() {
		return this.cg.getConnectionPool();
	}

	public void releaseConnection() {
		this.cg.releaseConnection();
	}
	 //**********************************************/
    public boolean addCategory(CategoryObject item){
        return this.cg.addCategory(item);
    }
    public boolean editCategory(CategoryObject item){
        return this.cg.editCategory(item);
    }
    public boolean delCategory(CategoryObject item){
        return this.cg.delCategory(item);
    }
	// ************************************************/

	public CategoryObject getCategoryObject(int id) {
		return this.cg.getCategoryObject(id);
	}

	// ************************************************/
	public String viewCategories(CategoryObject similar, int page, byte total) {
		// Lay danh sach doi tuong
		ArrayList items = this.cg.getCategoryObjects(similar, page, total);

		return CategoryLibrary.viewCategories(items);
	}
	
	public String slcCategory(CategoryObject similar) {
		// Lay danh sach doi tuong
		ArrayList items = this.cg.getCategoryObjects(similar, 0,(byte) 0);

		return CategoryLibrary.slcCategory(similar,items);
	}
}
