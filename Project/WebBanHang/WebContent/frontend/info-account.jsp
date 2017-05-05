<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.gui.product.ProductControl"%>
<%@page import="com.object.ProductObject"%>
<%@page import="com.library.Utilities"%>
<%@ page import="com.*,com.object.*"%>
<%@ page import="com.gui.product.*"%>
<%
	UserObject userLogined = (UserObject) session.getAttribute("userLogined");
	if(userLogined == null){
		out.println("<script>window.location = '/WebBanHang';</script>");
	}
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/css/info-account.css">
<ol class="breadcrumb">
	<li><a href="/WebBanHang"><i class="fa fa-home"
			aria-hidden="true"></i> Trang chủ</a></li>
	<li class="active">Tài khoản của bạn</li>
</ol>
<div class="content-info-account">
	<div class="left-info-account">
		<div class="nav-info-account">
			<div class="nav-title-info">Đơn hàng đặt mua</div>
			<div class="nav-content-info">
				<a href="?view=account-order"><h3>Danh sách đơn hàng</h3></a>
			</div>
			<div class="nav-title-info">Hoạt động cá nhân</div>
			<div class="nav-content-info">
				<a href="?view=account-pro-save"><h3>Sản phẩm đang lưu</h3></a>
			</div>
			<div class="nav-title-info">Thông tin tài khoản</div>
			<div class="nav-content-info">
				<a href="?view=account-detail"><h3>Thông tin cá nhân</h3></a>
				<a href="?view=account-change-pass"><h3>Thay đổi mật khẩu</h3></a>
			</div>
		</div>
	</div>
	<div class="right-info-account">
		<%
			if(request.getParameter("view") != null){
				if(request.getParameter("view").equalsIgnoreCase("account-order")){ %>
					<jsp:include page="account-order.jsp" flush="true"></jsp:include>
				<% }else if(request.getParameter("view").equalsIgnoreCase("account-pro-save")){ %>
					<jsp:include page="account-pro-save.jsp" flush="true"></jsp:include>
				
				<% }else if(request.getParameter("view").equalsIgnoreCase("account-detail")){ %>
					<jsp:include page="account-detail.jsp" flush="true"></jsp:include>
				<% }
				else if(request.getParameter("view").equalsIgnoreCase("account-change-pass")){ %>
					<jsp:include page="account-change-pass.jsp" flush="true"></jsp:include>
				<% }
			}else{ %>
				<jsp:include page="account-order.jsp" flush="true"></jsp:include>
			<% }
		%>
	</div>
</div>