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
			Elements e = null;
			if(url.contains("trananh.vn")){
				e = doc.getElementsByClass(DataConstant.PRPRIMARYTA);
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
					int c = 0;
					int originPrice = 0;
					for(int i = 0;i < e.select(DataConstant.PRPRICETA).text().length();i++){
						if(e.select(DataConstant.PRPRICETA).text().charAt(i) == '.'){
							c++;
						}
					}
					switch (c) {
					case 1:
						originPrice = getOriginPrice(e, 2);
						break;
					case 2: 
						originPrice = getOriginPrice(e, 3);
						break;
					case 3: 
						originPrice = getOriginPrice(e, 4);
						break;
					case 4: 
						originPrice = getOriginPrice(e, 5);
						break;
					}
				item.setProduct_origin_price(originPrice);
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
			}else{
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
	
	private static int getOriginPrice(Elements e,int l){
		int price = 0;
		
		price = Integer.parseInt(e.select(DataConstant.PRPRICETA).text().trim().replace(".", "0").substring(0,(e.select(DataConstant.PRPRICETA).text().trim().replace(".", "0").length()-l)));
		
		return price;
	}
	
	public static void main(String[] args){
		GetData gd = new GetDataImpl();
		ProductObject productObject = gd.getData("https://www.trananh.vn/dien-thoai/dien-thoai-di-dong-iphone-7-plus-128gb-red-pid195239cid338");
		if(productObject != null){
		System.out.println(productObject.getProduct_name());
		System.out.println(productObject.getProduct_origin_price());
		System.out.println(productObject.getProduct_summary());
		System.out.println(productObject.getProduct_warranty_time());
		System.out.println(productObject.isProduct_status());
		System.out.println(productObject.getProduct_promotion());
		System.out.println(productObject.getProduct_specification());
		}
		else{
			System.out.println("Trang web chưa được thêm vào! Liên hệ với quản trị để được bổ sung.");
		}
	}
}
