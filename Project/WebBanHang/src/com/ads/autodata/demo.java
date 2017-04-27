package com.ads.autodata;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.trananh.vn/laptop/laptop-asus-x541ua-xx051d-pid194312cid2").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      String title = doc.title();
	      Elements  overview = doc.getElementsByClass("tit-des-detail");
	      System.out.println(Integer.parseInt(overview.select(".real-price").text().trim().replace(".", "0").substring(0,(overview.select(".real-price").text().trim().replace(".", "0").length()-3))));
	      System.out.println(overview.select(".avaiable").text());
	      System.out.println(Integer.parseInt(overview.select(".info-wan").text().trim().substring(overview.select(".info-wan").text().indexOf(": ")+2, (overview.select(".info-wan").text().indexOf(": ") + 4))));
	      
	}

}