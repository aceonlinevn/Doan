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
			doc = Jsoup.connect("https://www.hanoicomputer.vn/laptop-asus-x541uv-xx037d-mong-nhe-moi-nhat-mau-den/p35725.html").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      String title = doc.title();
	      Element  overview = doc.getElementById("pro_detail_page");
	      System.out.println(Integer.parseInt(overview.select("#price_detail .line_through").text().trim().replace(".", "0").substring(0,(overview.select("#price_detail .line_through").text().trim().replace(".", "0").length()-4))));
	      /*System.out.println(overview.select(".avaiable").text());
	      System.out.println(Integer.parseInt(overview.select(".info-wan").text().trim().substring(overview.select(".info-wan").text().indexOf(": ")+2, (overview.select(".info-wan").text().indexOf(": ") + 4))));*/
	      if(!overview.select("#overview div div table tbody td").isEmpty()){
	      System.out.println(overview.select("#overview div div table tbody td").text());
	      }
	}

}
