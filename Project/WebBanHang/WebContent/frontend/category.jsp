<%@page import="com.gui.product.category.CategoryControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.gui.product.ProductControl"%>
<%@page import="com.object.ProductObject"%>
<%@page import="com.library.Utilities"%>
<%@ page import="com.*,com.object.*"%>
<%@ page import="com.gui.product.*"%>
<%
	ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
	ProductControl pc = new ProductControl(cp);
	if (cp == null) {
		application.setAttribute("cpool", pc.getConnectionPool());
	}
	pc.releaseConnection();
	CategoryControl cc = new CategoryControl(cp);
	if (cp == null) {
		application.setAttribute("cpool", cc.getConnectionPool());
	}
	cc.releaseConnection();
	int category_id = Integer.parseInt(request.getParameter("cid"));
	if(category_id>0){
		CategoryObject co = cc.getCategoryObject(category_id);
		ProductObject similar = new ProductObject();
		out.print(pc.viewProductsForCategory(co, similar));
	}
%>