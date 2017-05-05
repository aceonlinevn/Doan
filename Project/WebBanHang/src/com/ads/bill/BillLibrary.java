package com.ads.bill;
import com.*;
import com.gui.product.ProductModel;
import com.object.*;
import java.util.*;
public class BillLibrary {	
	private ProductModel pm;
	
	 public BillLibrary(ConnectionPool cp) {
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
	    public String viewBill(ArrayList<BillObject> bills){
	        String tmp = "";
	         int i = 1;
	        for(BillObject bill : bills){
	        	String selected1 = "";
	        	String selected2 = "";
	        	String selected3 = "";
	        	String selected4 = "";
	        	if(bill.getBill_status() == 0){
	        		selected1 = "selected";
				}else if(bill.getBill_status() == 1){
					selected2 = "selected";
				}else if(bill.getBill_status() == 2){
					selected3 = "selected";
				}else if(bill.getBill_status() == 3){
					selected4 = "selected";
				}
	        	tmp += "<form action=\"/WebBanHang/bill/view\" method=\"post\"";
	        	tmp += "<tr>";
	        	tmp += "<td>"+i+"</td>";
	        	tmp += "<td>"+bill.getBill_id()+"</td>";
	        	tmp += "<td>"+bill.getBill_date_created()+"</td>";
	        	tmp += "<td colspan=\"2\">";
	        	tmp +="<table class=\"tb1\">" ;
	        	if(bill.getBill_product_detail() != null){
		        	String[] pritems = bill.getBill_product_detail().split(",");
		        	if(pritems.length > 1){
						for(int j =1;j<pritems.length;j++){
							String[] pritem = pritems[j].split("-");
							ProductObject po = pm.getProductObject(Integer.parseInt(pritem[1]));
							tmp += "<tr>";
							tmp += "<td><a href=\"WebBanHang/frontend/page.jsp?paction=detail?prid="+po.getProduct_id()+"\" target=\"_blank\" title="+po.getProduct_name()+">"+po.getProduct_name()+"</a></td>";
							tmp += "<td>"+pritem[2]+"</td>";
							tmp += "</tr>";
						}
		        	}
	        	}
				tmp += "</table>";
	        	tmp += "</td>";
	        	tmp += "<td>";
	        	tmp += "<select name=slcStatus>";
	        	tmp += "<option value=0 "+selected1+">Chưa xử lý</option>";
	        	tmp += "<option value=1 "+selected2+">Đã xác nhận</option>";
	        	tmp += "<option value=2 "+selected3+">Đang giao hàng</option>";
	        	tmp += "<option value=3 "+selected4+">Hoàn thành</option>";
	        	tmp += "</select>";
	        	tmp += "<input type=hidden name=\"hdbBillId\" value="+bill.getBill_id()+">";
	        	tmp += "<input type=hidden name=\"hdbBillProductDetail\" value="+bill.getBill_product_detail()+">";
	        	tmp += "</td>";
	        	tmp += "<td><button type=submit class=\"btn btn-primary\">Thay đổi trạng thái</button></td>";
	        	tmp += "</tr>";
	        	tmp += "</form>";
	        	i++;
	        }

	        return tmp;
	    }
}
