package com.ads.product;

import com.library.Utilities;
import com.object.*;

import java.text.*;
import java.util.*;

public class ProductLibrary {

	public static String viewProducts(ArrayList<ProductObject> items){
        String tmp = "";
         int i = 0;
         String modified = "";
         String origin_price = "";
        for(ProductObject item:items){
        	if(item.getProduct_last_modified() == null || item.getProduct_last_modified().equalsIgnoreCase("")){
        		modified = "không sửa";
        	}else{
        		modified = item.getProduct_last_modified();
        	}
            tmp += (i%2 == 0) ? "<tr class=odd>":"<tr>";
            tmp += "<td class=\"NO\">"+ (++i) +"</td>";
            tmp += "<td class=\"NAME\">"+item.getProduct_name()+"</td>";
            tmp += "<td>"+item.getProduct_imported_date()+"</td>";
            tmp += "<td>"+modified+"</td>";
            tmp += "<td>"+item.getProduct_quantity()+"</td>";
            tmp += "<td>"+Utilities.convertMoney(item.getProduct_origin_price())+"</td>";
            tmp += "<td align=\"center\">"+item.getProduct_price_discount()+"%</td>";
            tmp += "<td>"+item.getCategory_name()+"</td>";
            tmp += "<td>"+item.getCategory_group_name()+"</td>";
            tmp += "<td>"+item.getProduct_visited()+"</td>";
            tmp += "<td class=\"ED\"><a class=\"btn btn-info\" href=\"/WebBanHang/product/ae?id="+item.getProduct_id()+"\"><span class=\"glyphicon glyphicon-pencil\"></span> Sửa</a></td>";
//            if(user.getUser_permission() > item.getUser_permission()){
//                tmp += "<td class=\"ED\"><a href=\"javascript:confirmDel('/adv/user/del?id=" + item.getUser_id() + "');void(0);\">Xoa</a></td>";
//            }else{
//                tmp += "<td class=\"ED\">...</td>";
//            }
            tmp += "<td class=\"ED\"><a class=\"btn btn-danger\" href=\"javascript:confirmDel('/WebBanHang/product/del?id=" + item.getProduct_id() + "');void(0);\"><span class=\"glyphicon glyphicon-trash\"></span> Xóa</a></td>";
            tmp += "<td class=\"ID\">"+item.getProduct_id()+"</td>";
            tmp += "</tr>";
        }

        return tmp;
    }
}
