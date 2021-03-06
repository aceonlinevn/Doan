package com.sql.gui;

import com.object.ProductObject;

public class MakeConditions {

	public static String createConditionProduct(ProductObject similar){
        String tmp = "";
        if(similar != null){
        	if(similar.isProduct_isnew()){
        		tmp = " product_isnew = 1 ";
        	}
        	if(similar.isProduct_isliquidation()){
    			tmp = " product_isliquidation = 1 ";
    		}
        	if(similar.isProduct_isselling()){
    			tmp = " product_isselling = 1 ";
    		}
        	if(similar.getProduct_promotion() == "km"){
        		tmp = " product_promotion IS NOT NULL ";
        	}
	        
        }
        return tmp;
    }
}
