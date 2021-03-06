package com.ads.autodata;

import java.io.IOException;
import java.util.ArrayList;

import com.object.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class GetDataImpl implements GetData {

	@Override
	public ProductObject getData(String url) {
		ProductObject item = new ProductObject();
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			if(url.contains("trananh.vn")){
				Elements e = doc.getElementsByClass(DataConstant.PRPRIMARYTA);
				item.setProduct_name(e.select(DataConstant.PRNAMETA).text());
				item.setProduct_summary(e.select(DataConstant.PRSUMMARYTA).text());
				if(e.select(DataConstant.PRSTATUSTA).text().equalsIgnoreCase("Còn hàng")){
					item.setProduct_status(true);
				}else{
					item.setProduct_status(false);
				}
				if(e.select(DataConstant.PRWARRANTYTA).isEmpty()){
					item.setProduct_warranty_time(0);
				}else{
				item.setProduct_warranty_time(Integer.parseInt(e.select(DataConstant.PRWARRANTYTA).text().trim().substring(e.select(DataConstant.PRWARRANTYTA).text().indexOf(": ")+2, (e.select(DataConstant.PRWARRANTYTA).text().indexOf(": ") + 4))));
				}
				if(e.select(DataConstant.PRPRICETA).isEmpty()){
					item.setProduct_origin_price(0);
				}else{
					
				String stroriginPrice = getPrice(e.select(DataConstant.PRPRICETA).text());
				item.setProduct_origin_price(Integer.parseInt(stroriginPrice.substring(0, stroriginPrice.length()-1)));
				}
				if(e.select(DataConstant.PRSAFEOFFTA).isEmpty()){
					item.setProduct_promotion(null);
				}else{
					item.setProduct_promotion(e.select(DataConstant.PRSAFEOFFTA).text());
				}
				if(e.select(DataConstant.PRDECTA).isEmpty()){
					item.setProduct_specification(null);
				}else{
					item.setProduct_specification(e.select(DataConstant.PRDECTA).html());
				}
				if(e.select(DataConstant.PRIMGTA).isEmpty()){
					item.setProduct_image("");
				}else{
					item.setProduct_image(e.select(DataConstant.PRIMGTA).attr("src"));
				}
			}else if(url.contains("hanoicomputer.vn")){
				Element e = doc.getElementById(DataConstant.PRPRIMARYHN);
				item.setProduct_name(e.select(DataConstant.PRNAMEHN).text());
				item.setProduct_summary(e.select(DataConstant.PRSUMMARYHN).text());
				if(e.select(DataConstant.PRPRICEHN).isEmpty()){
					item.setProduct_origin_price(0);
				}else{
					String stroriginPrice = getPrice(e.select(DataConstant.PRPRICEHN).text());
					item.setProduct_origin_price(Integer.parseInt(stroriginPrice.substring(0, stroriginPrice.length()-2)));
				}
				if(e.select(DataConstant.PRSAFEOFFHN).isEmpty()){
					item.setProduct_promotion(null);
				}else{
					item.setProduct_promotion(e.select(DataConstant.PRSAFEOFFHN).text());
				}
				if(e.select(DataConstant.PRDECHN).isEmpty()){
					item.setProduct_specification(null);
				}else{
					item.setProduct_specification(e.select(DataConstant.PRDECHN).html());
				}
				if(e.select(DataConstant.PRIMGHN).isEmpty()){
					item.setProduct_image("");
				}else{
					item.setProduct_image("https://www.hanoicomputer.vn/"+e.select(DataConstant.PRIMGHN).attr("href"));
				}
			}
			else{
			item = null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public ArrayList<WebObject> getDatas(String url) {
		// TODO Auto-generated method stub
		return null;
	}
	public static String getPrice(String stroriginPrice){
		for(int i = 0;i < stroriginPrice.length();i++){
			if(stroriginPrice.charAt(i) == '.'){
				stroriginPrice = removeCharAt(stroriginPrice,i);
			}
		}
		return stroriginPrice;
	}
	public static String removeCharAt(String s, int pos) {
	      return s.substring(0, pos) + s.substring(pos + 1);
	}
	public static String getProductForKeywordHN(String key){
		String tmp = "";
		ProductObject item = new ProductObject();
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.hanoicomputer.vn/ajax/get_product_list.php?q="+key).get();
			Elements e = doc.getElementsByClass("autocomplete-suggestion");
			for(int i=0;i< 10;i++){
				tmp += "<tr>";
				tmp += "<td><img src=\"https://hanoicomputer.vn"+e.get(i).select("img").attr("src")+"\" /></td>";
				tmp += "<td><a href=\"https://hanoicomputer.vn"+e.get(i).select(".suggest_link").attr("href")+"\">"+e.get(i).select(".suggest_link").text()+"</a></td>";
				GetData gd = new GetDataImpl();
				//ProductObject po = gd.getData("https://hanoicomputer.vn"+e.get(i).select(".suggest_link").attr("href"));
				String url = "https://hanoicomputer.vn"+e.get(i).select(".suggest_link").attr("href");
				tmp += "<td style=\"display:none\">";
				
				tmp +="</td>";
				tmp += "<td><a href=\"/WebBanHang/product/ae?action=getdata&url="+url+"\" title=\"Lấy dữ liệu\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-floppy-disk\"></span> Lấy dữ liệu</a></td>";
				tmp += "<tr>";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	public static void main(String[] args){
		GetData gd = new GetDataImpl();
		ProductObject productObject = gd.getData("https://www.hanoicomputer.vn/hdd-box-for-laptop-ssk-sata-usb-20/p1068.html");
		if(productObject != null){
		System.out.println(productObject.getProduct_name());
		System.out.println(productObject.getProduct_origin_price());
		System.out.println(productObject.getProduct_summary());
		System.out.println(productObject.getProduct_warranty_time());
		System.out.println(productObject.isProduct_status());
		System.out.println(productObject.getProduct_promotion());
		System.out.println(productObject.getProduct_specification());
		System.out.println(productObject.getProduct_image());
		}
		else{
			System.out.println("Trang web chưa được thêm vào! Liên hệ với quản trị để được bổ sung.");
		}
		//System.out.println(getProductForKeywordHN("LTLE380"));
	}
}
