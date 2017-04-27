package com.gui.product.categorygroup;

import com.*;
import com.object.*;
import java.util.*;

public class CategoryGroupControl {
	private CategoryGroupModel cg;

	public CategoryGroupControl(ConnectionPool cp) {
		this.cg = new CategoryGroupModel(cp);
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

	public CategoryGroupObject getCategoryGroupObject(int id) {
		return this.cg.getCategoryGroupObject(id);
	}

	// ************************************************/
	
	public String slcCategoryGroup(CategoryGroupObject similar) {
		// Lay danh sach doi tuong
		ArrayList items = this.cg.getCategoryGroupObjects(similar, 0,(byte) 0);

		return CategoryGroupLibrary.slcCategoryGroup(similar,items);
	}
}
