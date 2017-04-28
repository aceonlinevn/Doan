package com.gui.product;

import com.ConnectionPool;
import com.library.Utilities;
import com.object.*;

import java.text.*;
import java.util.*;

public class ProductLibrary {
	private ProductModel pm;
	public ProductLibrary(ConnectionPool cp) {
		this.pm = new ProductModel(cp);
	}

	protected void finalize() throws Throwable {
		this.pm = null;
	}

	public ConnectionPool getConnectionPool() {
		return this.pm.getConnectionPool();
	}
	public void releaseConnection() {
		this.pm.releaseConnection();
	}
	public static String viewProduct(ArrayList<ProductObject> items){
		String tmp = "<div class=\"products\">";
		String warranty = "";
		for(ProductObject item : items){
			String status = "",summary = "",promotion = "";
			if(item.isProduct_status()){
				status = "Còn hàng";
			}else{
				status = "Hết hàng";
			}
			if(item.getProduct_warranty_time() < 5){
				warranty = item.getProduct_warranty_time() + " năm";
			}else{
				warranty = item.getProduct_warranty_time() + " tháng";
			}
			if(item.getProduct_summary() != null && !item.getProduct_summary().equalsIgnoreCase("")){
				summary = item.getProduct_summary();
			}else{
				summary = "<p>Tóm tắt về sản phẩm đang được update...</p>";
			}
			if(item.getProduct_promotion() != null && !item.getProduct_promotion().equalsIgnoreCase("")){
				promotion = item.getProduct_promotion();
			}else{
				promotion = "<p>Sản phẩm chưa có khuyến mại!</p>";
			}
			tmp += "<div class=\"product\">";
			tmp += "<div class=\"product-code\">Mã sản phẩm: "+item.getProduct_prefix()+"</div>";
			tmp += "<div class=\"product-image\">";
			tmp += "<a href=\"/WebBanHang/frontend/detail.jsp?prid="+item.getProduct_id()+"\" title=\""+item.getProduct_name()+"\"><img src=\""+item.getProduct_image()+"\" alt=\""+item.getProduct_name()+"\"></a>";
			tmp += "</div>";
			tmp += "<div class=\"product-price\">"+Utilities.convertMoney(item.getProduct_origin_price())+"</div>";
			tmp += "<div class=\"product-name\"><h2><a href=\"WebBanHang/frontend/detail.jsp?id="+item.getProduct_id()+"\" title=\""+item.getProduct_name()+"\">"+item.getProduct_name()+"</a></h2></div>";
			tmp += "<div class=\"product-add-cart\">";
			tmp += "<span class=\"product-stocking\"><i class=\"fa fa-shopping-cart\" aria-hidden=\"true\"></i> "+ status +"</span>";
			tmp += "<a href=\"javascript:addToShoppingCartStop('pro','"+item.getProduct_id()+"',1,'"+item.getProduct_origin_price()+"')\" title=\"Mua ngay\"><i class=\"fa fa-cart-plus\" aria-hidden=\"true\"></i> Mua ngay</a>";
			tmp += "</div>";
			tmp += "<div class=\"clr\"></div>";
			tmp += "<div class=\"product-hover\">";
			tmp += "<div class=\"product-info\">";
			tmp += "<p class=\"product-name-hover\">"+item.getProduct_name()+"</p>";
			tmp += "<p class=\"product-price-hover\"><span class=\"price-text\">Giá bán: </span><span class=\"img_price\">"+Utilities.convertMoney(item.getProduct_origin_price())+"</span></p>";
			tmp += "<p class=\"product-warranty\">Bản hành: "+ warranty +"</p>";
			tmp += "</div>";
			tmp += "<div class=\"product-sumary\">";
			tmp += "<div class=\"title-hover\">Mô tả tóm tắt</div>";
			tmp += summary;
			tmp += "</div>";
			tmp += "<div class=\"product-saleoff\">";
			tmp += "<div class=\"title-hover\">Khuyến mại</div>";
			tmp += promotion;
			tmp += "</div>";
			tmp += "</div>";
			tmp += "</div><!-- end Product-->";
		}
		tmp += "</div><!-- end Products-->";
		return tmp;
	}
	
	public String viewProductForCategory(ArrayList<CategoryObject> cates){
		String tmp = "";
		for(CategoryObject cate : cates){
			ArrayList items = this.pm.getProductForCategory(cate.getCategory_id(), 1, (byte) 5);
			tmp += "<div class=\"section\">";
			tmp += "<div class=\"section-title\"><h3>"+cate.getCategory_name()+"</h3></div>";
			tmp += viewProduct(items);
			tmp+= "<div class=\"view-more\">";
			tmp += "<a href=\"/WebBanHang/frontend/category.jsp?id="+cate.getCategory_id()+"\"><span class=\"view-more-img\" style=\" background-image: url("+cate.getCategory_images()+")\"></span></a>";
			tmp += "</div>";
			tmp += "</div><!-- end-section-->";
			tmp += "<div class=\"clr\"></div>";
		}
		return tmp;
	}
}
