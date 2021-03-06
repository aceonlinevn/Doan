package com.ads.product.categorygroup;

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
	 //**********************************************/
    public boolean addCategoryGroup(CategoryGroupObject item){
        return this.cg.addCategoryGroup(item);
    }
    public boolean editCategoryGroup(CategoryGroupObject item){
        return this.cg.editCategoryGroup(item);
    }
    public boolean delCategoryGroup(CategoryGroupObject item){
        return this.cg.delCategoryGroup(item);
    }
	// ************************************************/

	public CategoryGroupObject getCategoryGroupObject(int id) {
		return this.cg.getCategoryGroupObject(id);
	}

	// ************************************************/
	public String viewCategoryGroups(CategoryGroupObject similar, int page, byte total) {
		// Lay danh sach doi tuong
		ArrayList items = this.cg.getCategoryGroupObjects(similar, page, total);

		return CategoryGroupLibrary.viewCategoryGroups(items);
	}
	
	public String slcCategoryGroup(CategoryGroupObject similar) {
		// Lay danh sach doi tuong
		ArrayList items = this.cg.getCategoryGroupObjects(similar, 0,(byte) 0);

		return CategoryGroupLibrary.slcCategoryGroup(similar,items);
	}
}
