package com.gui.product.categorygroup;

import com.object.*;
import java.util.*;

public class CategoryGroupLibrary {
	
	
	//Get select box category group
	public static String slcCategoryGroup(CategoryGroupObject similar, ArrayList<CategoryGroupObject> items){
		String tmp = "<select name=slcCategoryGroup class=\"form-control\">";
		String selected = "";
		for(CategoryGroupObject item : items){
			if(item.getCategory_group_id() == similar.getCategory_group_id()){
				selected = "selected";
			}else{
				selected = "";
			}
			tmp += "<option value=\""+item.getCategory_group_id()+"\" "+selected+">"+item.getCategory_group_name()+"</option>";
		}
		tmp += "</select>";
		return tmp;
	}
}
