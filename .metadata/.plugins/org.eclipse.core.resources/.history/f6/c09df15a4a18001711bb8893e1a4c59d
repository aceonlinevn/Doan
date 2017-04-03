package com.ads.product.category;

import com.object.*;
import java.util.*;

public class CategoryLibrary {

	public static String viewCategories(ArrayList<CategoryObject> items){
        String tmp = "";
         int i = 0;
     	String isEnable = "";
     	String note = "";
        for(CategoryObject item:items){
        	if(item.isCategory_is_enable()){
        		isEnable = "Hiện";
        	}else{
        		isEnable = "Ẩn";
        	}
        	if(item.getCategory_note() == null || item.getCategory_note().equalsIgnoreCase("")) {
        		note = "Không";
        	}
        	else{
        			note = item.getCategory_note();
        	}
            tmp += "<tr>";
            tmp += "<td class=\"NO\">"+ (++i) +"</td>";
            tmp += "<td class=\"NAME\">"+item.getCategory_name()+"</td>";
            tmp += "<td>"+item.getCategory_created_date()+"</td>";
            tmp += "<td>"+ isEnable +"</td>";
            tmp += "<td>"+note+"</td>";
            tmp += "<td>"+item.getCategory_group_id()+"</td>";
            tmp += "<td class=\"ED\"><a class=\"btn btn-info\" href=\"/WebBanHang/category/ae?id="+item.getCategory_id()+"\"><span class=\"glyphicon glyphicon-pencil\"></span> Sửa</a></td>";
//            if(user.getUser_permission() > item.getUser_permission()){
//                tmp += "<td class=\"ED\"><a href=\"javascript:confirmDel('/adv/user/del?id=" + item.getUser_id() + "');void(0);\">Xoa</a></td>";
//            }else{
//                tmp += "<td class=\"ED\">...</td>";
//            }
            tmp += "<td class=\"ED\"><a class=\"btn btn-danger\" href=\"javascript:confirmDel('/WebBanHang/category/del?id=" + item.getCategory_id() + "');void(0);\"><span class=\"glyphicon glyphicon-trash\"></span> Xóa</a></td>";
            tmp += "<td class=\"ID\">"+item.getCategory_id()+"</td>";
            tmp += "</tr>";
        }

        return tmp;
    }
	
	//Get select box category group
	public static String slcCategory(ArrayList<CategoryObject> items){
		String tmp = "<select name=slcCategory class=\"form-control\">";
		
		for(CategoryObject item : items){
			tmp += "<option value=\""+item.getCategory_id()+"\">"+item.getCategory_name()+"</option>";
		}
		tmp += "</select>";
		return tmp;
	}
}
