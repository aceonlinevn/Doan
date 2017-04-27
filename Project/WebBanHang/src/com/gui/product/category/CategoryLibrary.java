package com.gui.product.category;

import com.object.*;
import java.util.*;

public class CategoryLibrary {

	
	
	//Get select box category group
		public static String slcCategory(CategoryObject similar, ArrayList<CategoryObject> items){
			String tmp = "<select name=slcCategory class=\"form-control\">";
			String selected = "";
			for(CategoryObject item : items){
				if(item.getCategory_id() == similar.getCategory_id()){
					selected = "selected";
				}else{
					selected = "";
				}
				tmp += "<option value=\""+item.getCategory_id()+"\" "+selected+">"+item.getCategory_name()+"</option>";
			}
			tmp += "</select>";
			return tmp;
		}
}
