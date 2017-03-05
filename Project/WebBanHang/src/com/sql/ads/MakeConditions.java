package com.sql.ads;

import com.object.*;

public class MakeConditions {

	public static String createCondition(ProductObject similar){
        String tmp = "";
        if(similar != null){
            //Lay thong tin tu khoa tim kiem
            String keyword = similar.getProduct_name();

            tmp = "";
            if(keyword != null && !keyword.equalsIgnoreCase("")){
                tmp += "(product_name LIKE '%"+keyword+"%') OR ";
                tmp += "(product_specification LIKE '%"+keyword+"%') OR ";
                tmp += "(product_note LIKE '%"+keyword+"%')";
            }
        }
        return tmp;
    }
}
