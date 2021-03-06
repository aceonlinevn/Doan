package com.ads.product.categorygroup;

import com.object.*;
import java.util.*;

public class CategoryGroupLibrary {

	public static String viewCategoryGroups(ArrayList<CategoryGroupObject> items){
        String tmp = "";
         int i = 0;
     	String isEnable = "";
     	String note = "";
        for(CategoryGroupObject item:items){
        	if(item.isCategory_group_is_enable()){
        		isEnable = "Hiện";
        	}else{
        		isEnable = "Ẩn";
        	}
        	if(item.getCategory_group_note() == null || item.getCategory_group_note().equalsIgnoreCase("")) {
        		note = "Không";
        	}
        	else{
        			note = item.getCategory_group_note();
        	}
            tmp += "<tr>";
            tmp += "<td class=\"NO\">"+ (++i) +"</td>";
            tmp += "<td class=\"NAME\">"+item.getCategory_group_name()+"</td>";
            tmp += "<td>"+item.getCategory_group_created_date()+"</td>";
            tmp += "<td>"+ isEnable +"</td>";
            tmp += "<td>"+note+"</td>";
            tmp += "<td class=\"ED\"><a class=\"btn btn-info\" href=\"/WebBanHang/categorygroup/ae?id="+item.getCategory_group_id()+"\"><span class=\"glyphicon glyphicon-pencil\"></span> Sửa</a></td>";
//            if(user.getUser_permission() > item.getUser_permission()){
//                tmp += "<td class=\"ED\"><a href=\"javascript:confirmDel('/adv/user/del?id=" + item.getUser_id() + "');void(0);\">Xoa</a></td>";
//            }else{
//                tmp += "<td class=\"ED\">...</td>";
//            }
            tmp += "<td class=\"ED\"><a class=\"btn btn-danger\" href=\"javascript:confirmDel('/WebBanHang/categorygroup/del?id=" + item.getCategory_group_id() + "');void(0);\"><span class=\"glyphicon glyphicon-trash\"></span> Xóa</a></td>";
            tmp += "<td class=\"ID\">"+item.getCategory_group_id()+"</td>";
            tmp += "</tr>";
        }

        return tmp;
    }
	
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
