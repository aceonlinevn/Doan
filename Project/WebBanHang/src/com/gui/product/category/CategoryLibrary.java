package com.gui.product.category;

import com.object.*;
import java.util.*;

public class CategoryLibrary {

	
	
	//Get select box category
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
		//get select box category for search
		public static String slcCategory(ArrayList<CategoryObject> items){
			String tmp = "<select name=slcSearch class=\"slcSearch\">";
			tmp += "<option value=\"0\" selected>Tất cả</option>";
			for(CategoryObject item : items){
				tmp += "<option value=\""+item.getCategory_id()+"\">"+item.getCategory_name()+"</option>";
			}
			tmp += "</select>";
			return tmp;
		}
}
