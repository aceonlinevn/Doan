<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.*,com.object.*" %>
<%@ page import="com.gui.product.*" %>
<%
ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
ProductControl pc = new ProductControl(cp);
if(cp == null){
  application.setAttribute("cpool",pc.getConnectionPool());
}
//Khai bảo object
ProductObject similar1 = new ProductObject();
ProductObject similar2 = new ProductObject();
ProductObject similar3 = new ProductObject();
ProductObject similar4 = new ProductObject();
//Khởi tạo điểu kiện
similar1.setProduct_isnew(true);
similar2.setProduct_isliquidation(true);
similar3.setProduct_isselling(true);
similar4.setProduct_promotion("km");
//Khởi tạo cấu trúc
String viewProductForNew = pc.viewProducts(similar1 , (byte) 6);
String viewProductForLiquidation = pc.viewProducts(similar2 , (byte) 6);
String viewProductForSelling = pc.viewProducts(similar3 , (byte) 6);
String viewProductPromotion = pc.viewProducts(similar4 , (byte) 6);
//Dua cau truc vao phien lam viec
session.setAttribute("viewProductForNew", viewProductForNew);
session.setAttribute("viewProductForLiquidation", viewProductForLiquidation);
session.setAttribute("viewProductForSelling", viewProductForSelling);
session.setAttribute("viewProductPromotion", viewProductPromotion);

%>