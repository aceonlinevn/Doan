<%@page import="com.gui.product.category.CategoryControl"%>
<%@page import="com.ads.user.UserModel"%>
<%@page import="com.library.Utilities"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.*,com.object.*"%>
<%@ page import="com.gui.product.*"%>
<%@ page import="java.util.*"%>
<%
	ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
	ProductControl pc = new ProductControl(cp);
	int id = 0;
	if (cp == null) {
		application.setAttribute("cpool", pc.getConnectionPool());
	}
	pc.releaseConnection();
	CategoryControl cc = new CategoryControl(cp);
	if (cp == null) {
		application.setAttribute("cpool", cc.getConnectionPool());
	}
	cc.releaseConnection();
	if (request.getParameter("prid") != null && !request.getParameter("prid").equalsIgnoreCase("")) {
		session.setAttribute("product_id", request.getParameter("prid"));
		id = Integer.parseInt(request.getParameter("prid"));
		ProductObject po = pc.getProductObject(id);
		if (id > 0) {
			//hungcuong - sua lai services - chi goi vao services 1 lan 
			String warranty = "";
			int iwarranty = po.getProduct_warranty_time();
			if (iwarranty < 6) {
				warranty = iwarranty + " năm";
			} else {
				warranty = iwarranty + " tháng";
			}
			// fix lai ham 
			String summary = po.getProduct_summary();
			if (summary == null && summary.equalsIgnoreCase("")) {
				summary = "Mô tả đang được cập nhât";
			}

			String specification = po.getProduct_specification();
			if (specification == null && specification.equalsIgnoreCase("")) {
				specification = "Nội dung đang được cập nhât";
			}

			//hungcuong - load product rate
			int productRate = pc.getProductRateAVG(id);
			session.setAttribute("productRate", productRate);
			ArrayList<UserRateObject> alComments = pc.getProductRating(id);

			String productComment = pc.getUserComment(alComments);
			int productRateCount = alComments.size();
			session.setAttribute("productComment", productComment);
			session.setAttribute("productRateCount", productRateCount);

			//product detail
			session.setAttribute("productDetailImg", po.getProduct_image());
			session.setAttribute("productDetailName", po.getProduct_name());
			session.setAttribute("productDetailPrefix", po.getCategory_group_prefix());
			session.setAttribute("productDetailPrice", po.getProduct_origin_price());
			session.setAttribute("productDetailWarranty", warranty);
			session.setAttribute("productDetailSummary", summary);
			session.setAttribute("productDetailContent", specification);
			session.setAttribute("productDetailQuantity", po.getProduct_quantity());
		}
	}
	//Khai bảo object
	ProductObject similar1 = new ProductObject();
	ProductObject similar2 = new ProductObject();
	ProductObject similar3 = new ProductObject();
	ProductObject similar4 = new ProductObject();
	ProductObject similar = new ProductObject();
	CategoryObject similarc = new CategoryObject();
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
	String viewCategorySearch = cc.slcCategoryForSearch(similarc);
	String viewCategory = cc.viewCategory(similarc);
	//Dua cau truc vao phien lam viec
	session.setAttribute("viewProductForNew", viewProductForNew);
	session.setAttribute("viewProductForLiquidation", viewProductForLiquidation);
	session.setAttribute("viewProductForSelling", viewProductForSelling);
	session.setAttribute("viewProductPromotion", viewProductPromotion);
	session.setAttribute("viewProductForCategory", viewProductForCategory);
	session.setAttribute("viewCategorySearch", viewCategorySearch);
	session.setAttribute("viewCategory", viewCategory);
	//hungcuong - collaboration filter
	String user_id_now = (String) request.getSession().getAttribute("user_id_now");
	String viewProductForReferences = (String) request.getSession().getAttribute("viewProductForReferences");

	ArrayList<ProductObject> listProductReferences = new ArrayList<ProductObject>();
	
	if (user_id_now != null) {
		listProductReferences = pc.getReferencesProduct(user_id_now);
	}
	
	//Neu khong lay duoc danh sach san pham goi y bang thuat toan loc cong tac -> lay danh sach san pham vi du
	if (listProductReferences.size() == 0) {
		listProductReferences = pc.getProductRattingSample();
	}
	// loc bo san pham hien tai
	for (int i = 0; i < listProductReferences.size(); i++) {
		if (listProductReferences.get(i).getProduct_id() == id) {
			listProductReferences.remove(i);
		}
	}
	String viewProductReferences = pc.viewProducts2(listProductReferences);
	request.getSession().setAttribute("viewProductForReferences", viewProductReferences);
%>