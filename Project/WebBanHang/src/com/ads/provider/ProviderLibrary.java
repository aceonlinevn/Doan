package com.ads.provider;

import com.library.Utilities;
import com.object.*;

import java.text.*;
import java.util.*;

public class ProviderLibrary {

	public static String viewProviders(ArrayList<ProviderObject> items){
        String tmp = "";
         int i = 0;
         String modified = "";
         String origin_price = "";
        for(ProviderObject item:items){
            tmp += (i%2 == 0) ? "<tr class=odd>":"<tr>";
            tmp += "<td class=\"NO\">"+ (++i) +"</td>";
            tmp += "<td class=\"NAME\">"+item.getProvider_name()+"</td>";
            tmp += "<td>"+item.getProvider_address()+"</td>";
            tmp += "<td>"+item.getProvider_phone()+"</td>";
            tmp += "<td align=\"center\">"+item.getProvider_homephone()+"%</td>";
            tmp += "<td>"+item.getProvider_taxcode()+"</td>";
            tmp += "<td class=\"ED\"><a class=\"btn btn-info\" href=\"/WebBanHang/provider/ae?id="+item.getProvider_id()+"\"><span class=\"glyphicon glyphicon-pencil\"></span> Sửa</a></td>";
            tmp += "<td class=\"ED\"><a class=\"btn btn-danger\" href=\"javascript:confirmDel('/WebBanHang/provider/del?id=" + item.getProvider_id() + "');void(0);\"><span class=\"glyphicon glyphicon-trash\"></span> Xóa</a></td>";
            tmp += "<td class=\"ID\">"+item.getProvider_id()+"</td>";
            tmp += "</tr>";
        }

        return tmp;
    }
	//Get select box category group
	public static String slcProvider(ProviderObject similar, ArrayList<ProviderObject> items){
		String tmp = "<select name=slcProvider class=\"form-control\">";
		String selected = "";
		for(ProviderObject item : items){
			if(item.getProvider_id() == similar.getProvider_id()){
				selected = "selected";
			}else{
				selected = "";
			}
			tmp += "<option value=\""+item.getProvider_id()+"\" "+selected+">"+item.getProvider_name()+"</option>";
		}
		tmp += "</select>";
		return tmp;
	}
	
}
