package com.sql.ads;

import com.object.*;

public class MakeConditions {

	public static String createConditionProduct(ProductObject similar){
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
	
	public static String createConditionCategoryGroup(CategoryGroupObject similar){
        String tmp = "";
        if(similar != null){
            //Lay thong tin tu khoa tim kiem
            String keyword = similar.getCategory_group_name();

            tmp = "";
            if(keyword != null && !keyword.equalsIgnoreCase("")){
                tmp += "(category_group_name LIKE '%"+keyword+"%') OR ";
                tmp += "(category_group_note LIKE '%"+keyword+"%')";
            }
        }
        return tmp;
    }
	
	public static String createConditionCategory(CategoryObject similar){
        String tmp = "";
        if(similar != null){
            //Lay thong tin tu khoa tim kiem
            String keyword = similar.getCategory_name();

            tmp = "";
            if(keyword != null && !keyword.equalsIgnoreCase("")){
                tmp += "(category_name LIKE '%"+keyword+"%') OR ";
                tmp += "(category_note LIKE '%"+keyword+"%')";
            }
        }
        return tmp;
    }
	
	public static String createConditionProvider(ProviderObject similar){
        String tmp = "";
        if(similar != null){
            //Lay thong tin tu khoa tim kiem
            String keyword = similar.getProvider_name();

            tmp = "";
            if(keyword != null && !keyword.equalsIgnoreCase("")){
                tmp += "(provider_name LIKE '%"+keyword+"%') OR ";
                tmp += "(provider_note LIKE '%"+keyword+"%')";
            }
        }
        return tmp;
    }
}
