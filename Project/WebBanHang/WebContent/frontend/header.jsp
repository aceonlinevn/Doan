<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.object.UserObject"%>
<jsp:include page="data.jsp" flush="true"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Hùng Cường Computer</title>
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/frontend/css/style.css">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/frontend/css/single.css">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/frontend/css/font-awesome.min.css">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/frontend/css/bootstrap.css">
	<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/frontend/js/jquery-1.8.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/frontend/js/owl.carousel.js"></script>
	<script src="<%=request.getContextPath()%>/frontend/js/common.js"></script>
	<script src="<%=request.getContextPath()%>/frontend/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header">
		<div class="tp-header">
			<div class="wrapper">
				<div class="l-tp-header">
					<a href="tel:0965909929" title="Chăm sóc khách hàng"><i
						class="fa fa-phone" aria-hidden="true"></i> Chăm sóc khách hàng: <span
						class="phone-number">0965 909 929</span></a> <a href="#"
						title="Tải báo giá,hợp đồng"><i class="fa fa-download"
						aria-hidden="true"></i> Tải báo giá,hợp đồng</a> <a href="#"
						title="Xây dựng cấu hình"><i class="fa fa-laptop"
						aria-hidden="true"></i> Xây dựng cấu hình</a> <a href="#"
						title="Tin tức nổi bật"><i class="fa fa-newspaper-o"
						aria-hidden="true"></i> Tin tức nổi bật</a>
				</div>
				<!-- end l-tp-header-->
				<div class="r-tp-header"></div>
				<!-- end r-tp-header-->
			</div>
		</div>
		<!-- end tp-header-->
		<div class="clr"></div>
		<div class="bt-header">
			<div class="wrapper">
				<div class="l-bt-header">
					<a href="<%=request.getContextPath() %>" title="Hùng cường Computer"><img style="height:130px"
								src="<%=request.getContextPath()%>/frontend/pictures/logo.jpg"
								alt="" /></a>
				</div>
				<!-- end l-bt-header-->
				<div class="c-bt-header">
					<div class="slider-wrapper theme-default">
						<div id="slider" class="nivoSlider">
							<a href="#"><img
								src="<%=request.getContextPath()%>/frontend/pictures/banner4.jpg"
								alt="" /></a> <a href="#"><img
								src="<%=request.getContextPath()%>/frontend/pictures/banner1.jpg"
								alt="" /></a> <a href="#"><img
								src="<%=request.getContextPath()%>/frontend/pictures/banner2.jpg"
								alt="" /></a>
						</div>
					</div>
					<!--End .slider-wrapper-->
					<script language="javascript" type="text/javascript"
						src="<%=request.getContextPath()%>/frontend/js/jquery.nivo.slider.js"></script>
					<script type="text/javascript">
						$(window).load(function() {
							$('#slider').nivoSlider();
						});
					</script>
				</div>
				<!-- end c-bt-header-->
				<div class="r-bt-header">
					<div class="login-area">
				
						<%
							UserObject userLogined = (UserObject) session.getAttribute("userLogined");
							if (userLogined != null && userLogined.getUser_permission_id()!=0) {
						%>
						<a href="/WebBanHang/" title="<%=userLogined.getUser_name()%>"><i
							class="fa fa-user" style="font-weight: bold;" aria-hidden="true"></i>
							<%=userLogined.getUser_name()%> </a> <a
							href="/WebBanHang/user/logout" title="Thoát"><i class="fa fa-sign-out" aria-hidden="true"></i> Thoát</a>
						<%
							} else {
						%>
						<a href="javascript:void(0)" title="Đăng nhập" data-toggle="modal" data-target="#mdLogin"><i
							class="fa fa-user" aria-hidden="true"></i> Đăng nhập</a> <a href="#"
							title="Đăng ký"><i class="fa fa-user-plus" aria-hidden="true"></i>
							Đăng ký</a>
						<%
						
							}
						%>

					</div>
					<div class="cart-area">
						<a href="/WebBanHang/frontend/cart.jsp" title="Giỏ hàng"><i class="fa fa-shopping-cart"
							aria-hidden="true"></i> Giỏ hàng</a> <span class="cart-count"><i
							class="fa fa-comment-o" aria-hidden="true"></i> <span
							class="count" id="count_shopping_cart_store">0<span></span>
					</div>
				</div>
				<!-- end r-bt-header-->
			</div>
			<div class="clr"></div>
		</div>
		<!-- end bt-header-->
	</div>
	<!-- end header-->
	<div class="clr"></div>