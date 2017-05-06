package com.ads.images;

import com.object.*;
import java.util.*;

public class ImagesLibrary {

	
	//Get select box category group
	public static String viewImages(ArrayList<ImagesObject> items){
		String tmp = "";
		for(ImagesObject item : items){
			tmp += "<a onclick=\"loadImages('"+item.getImages_src()+"')\"><img src='"+item.getImages_src()+"' width=100 height=80 atl='"+item.getImages_name()+"' /></a>";
		}
		return tmp;
	}
}
