package com.library;

import com.object.*;
public class MakeConditions {
	public static String createUserConditions(UserObject item){
		String temp = "";
		
		if(item.getUser_permission_id()!=0){
			temp+="(user_permission_id='"+item.getUser_permission_id()+"')";
		}
		
		return temp;
	}
	
	
}
