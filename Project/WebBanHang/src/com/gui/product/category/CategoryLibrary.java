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
		
		//get danh muc san pham
				public static String viewCategory(ArrayList<CategoryObject> items){
					String tmp = "<div class=\"sidebar-title\">Danh mục sản phẩm</div>";
					tmp += "<ul>";
					for(CategoryObject item : items){
						tmp += "<li><h3><a href=\"/WebBanHang/frontend/page.jsp?paction=category&cid="+item.getCategory_id()+"\" title=\""+item.getCategory_name()+"\">"+item.getCategory_icon()+"&nbsp&nbsp"+item.getCategory_name()+"</a></h3></li>";
					}
					tmp += "</ul>";
					return tmp;
				}
}
