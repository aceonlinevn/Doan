package com.ads.product.categorygroup;

import java.sql.ResultSet;

import com.ShareControl;
import com.object.CategoryGroupObject;

public interface CategoryGroup extends ShareControl{
	
	public boolean addCategoryGroup(CategoryGroupObject item);
    public boolean editCategoryGroup(CategoryGroupObject item);
    public boolean delCategoryGroup(CategoryGroupObject item);

    public ResultSet getCategoryGroup(int id);
    public ResultSet getCategoryGroups(CategoryGroupObject similar, int at,byte total);
}
