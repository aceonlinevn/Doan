package com.gui.product.categorygroup;

import java.sql.ResultSet;

import com.ShareControl;
import com.object.CategoryGroupObject;

public interface CategoryGroup extends ShareControl{

    public ResultSet getCategoryGroup(int id);
    public ResultSet getCategoryGroups(CategoryGroupObject similar, int at,byte total);
}
