package com.gui.product.category;

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
	// ************************************************/

	public CategoryObject getCategoryObject(int id) {
		return this.cg.getCategoryObject(id);
	}

	public String viewCategory(CategoryObject similar) {
		// Lay danh sach doi tuong
		ArrayList items = this.cg.getCategoryObjects(similar, 0,(byte) 0);

		return CategoryLibrary.viewCategory(items);
	}
	
	// ************************************************/
	
	public String slcCategory(CategoryObject similar) {
		// Lay danh sach doi tuong
		ArrayList items = this.cg.getCategoryObjects(similar, 0,(byte) 0);

		return CategoryLibrary.slcCategory(similar,items);
	}
	
	public String slcCategoryForSearch(CategoryObject similar) {
		// Lay danh sach doi tuong
		ArrayList items = this.cg.getCategoryObjects(similar, 0,(byte) 0);

		return CategoryLibrary.slcCategory(items);
	}
}
