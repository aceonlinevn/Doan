<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.gui.product.ProductControl"%>
<%@page import="com.object.ProductObject"%>
<%@page import="com.library.Utilities"%>
<%@ page import="com.*,com.object.*"%>
<%@ page import="com.gui.product.*"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<div class="content">
	<div class="wrapper">
		<div class="sub-content">
			<div class="sidebar side-bar-auto">
				<%
				String viewCategory = (String) session.getAttribute("viewCategory");
				if(viewCategory != null){
					out.print(viewCategory);
				}
				%>
			</div>
			<!-- end sidebar-->
			<div class="aside">
				<div class="tp-aside">
					<jsp:include page="search.jsp" flush="true"></jsp:include>
					<div class="nav">
						<a href="tel:19009068" class="support-number">Hỗ trợ trực
							tuyến: 1900.9068</a> <a href="#" class="news-tp-aside">Tin tức</a> <a
							href="#" class="contact-tp-aside">Liên hệ - hợp tác</a>
					</div>
				</div>
				<!-- end tp-aside-->
			</div>
			<!-- end aside-->
		</div>
		<!-- end sub-content-->
		<div class="clr"></div>
		<div class="main-content text-left">
			<%
				String paction = request.getParameter("paction");
				if(paction != null){
					switch(paction){
						case "checkout" :
							 %><jsp:include page="checkout.jsp" flush="true"></jsp:include><% 
						break;
						case "cart" :
							 %><jsp:include page="cart.jsp" flush="true"></jsp:include><% 
						break;
						case "detail" :
							 %><jsp:include page="detail.jsp" flush="true"></jsp:include><% 
						break;
						case "category" :
							 %><jsp:include page="category.jsp" flush="true"></jsp:include><% 
						break;
						case "info-account" :
							 %><jsp:include page="info-account.jsp" flush="true"></jsp:include><% 
						break;
						case "register-account" :
							 %><jsp:include page="register-account.jsp" flush="true"></jsp:include><% 
						break;
					}
				}
			%>
		</div>
		<!-- end main-content-->
	</div>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>