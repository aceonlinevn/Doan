<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.*,com.object.*"%>
<%@ page import="com.gui.product.*"%>
<%@ page import="java.util.*"%>
<%
	ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
	ProductControl pc = new ProductControl(cp);
	if (cp == null) {
		application.setAttribute("cpool", pc.getConnectionPool());
	}
	if (request.getParameter("prid") != null && !request.getParameter("prid").equalsIgnoreCase("")) {
		int id = Integer.parseInt(request.getParameter("prid"));
		ProductObject po = pc.getProductObject(id);
		if (id > 0) {
			String warranty = "";
			if (po.getProduct_warranty_time() < 6) {
				warranty = po.getProduct_warranty_time() + " năm";
			} else {
				warranty = po.getProduct_warranty_time() + " tháng";
			}
			String summary = "";
			if (po.getProduct_summary() != null && !po.getProduct_summary().equalsIgnoreCase("")) {
				summary = po.getProduct_summary();
			} else {
				summary = "Mô tả đang được cập nhât";
			}
			String specification = "";
			if (po.getProduct_specification() != null && !po.getProduct_specification().equalsIgnoreCase("")) {
				specification = po.getProduct_specification();
			} else {
				specification = "Nội dung đang được cập nhât";
			}
			//product detail
			session.setAttribute("productDetailImg", po.getProduct_image());
			session.setAttribute("productDetailName", po.getProduct_name());
			session.setAttribute("productDetailPrefix", po.getCategory_group_prefix());
			session.setAttribute("productDetailPrice", po.getProduct_origin_price());
			session.setAttribute("productDetailWarranty", warranty);
			session.setAttribute("productDetailSummary", summary);
			session.setAttribute("productDetailContent", specification);
		}
	}
	
	//Khai bảo object
	ProductObject similar1 = new ProductObject();
	ProductObject similar2 = new ProductObject();
	ProductObject similar3 = new ProductObject();
	ProductObject similar4 = new ProductObject();
	ProductObject similar = new ProductObject();
	//Khởi tạo điểu kiện
	similar1.setProduct_isnew(true);
	similar2.setProduct_isliquidation(true);
	similar3.setProduct_isselling(true);
	similar4.setProduct_promotion("km");
	//Khởi tạo cấu trúc
	String viewProductForNew = pc.viewProducts(similar1, (byte) 6);
	String viewProductForLiquidation = pc.viewProducts(similar2, (byte) 6);
	String viewProductForSelling = pc.viewProducts(similar3, (byte) 6);
	String viewProductPromotion = pc.viewProducts(similar4, (byte) 6);
	String viewProductForCategory = pc.viewProductsForCategory(similar);
	//Dua cau truc vao phien lam viec
	session.setAttribute("viewProductForNew", viewProductForNew);
	session.setAttribute("viewProductForLiquidation", viewProductForLiquidation);
	session.setAttribute("viewProductForSelling", viewProductForSelling);
	session.setAttribute("viewProductPromotion", viewProductPromotion);
	session.setAttribute("viewProductForCategory", viewProductForCategory);
	
	//hungcuong - loc cong tac
	ArrayList<ProductObject> listProductReferences = pc.getReferencesProduct("1");
	String viewProductReferences = pc.viewProducts2(listProductReferences);
	session.setAttribute("viewProductForReferences", viewProductReferences);
	
%>