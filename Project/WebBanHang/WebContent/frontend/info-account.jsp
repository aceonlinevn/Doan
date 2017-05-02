<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.gui.product.ProductControl"%>
<%@page import="com.object.ProductObject"%>
<%@page import="com.library.Utilities"%>
<%@ page import="com.*,com.object.*"%>
<%@ page import="com.gui.product.*"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<%
	UserObject userLogined = (UserObject) session.getAttribute("userLogined");
	if(userLogined == null){
		out.println("<script>window.location = '/WebBanHang';</script>");
	}
%>
<div class="content">
	<div class="wrapper">
		<div class="sub-content">
			<div class="sidebar side-bar-auto">
				<div class="sidebar-title">Danh mục sản phẩm</div>
				<ul>
					<li><h3>
							<a href="#" title=""><i class="fa fa-laptop"
								aria-hidden="true"></i>&nbsp&nbspLaptop,phụ kiện</a>
						</h3></li>
					<li><h3>
							<a href="#" title=""><i class="fa fa-gamepad"
								aria-hidden="true"></i>&nbsp&nbspPC,Workstaion</a>
						</h3></li>
					<li><h3>
							<a href="#" title=""><i class="fa fa-video-camera"
								aria-hidden="true"></i>&nbsp&nbspCamera giám sát</a>
						</h3></li>
					<li><h3>
							<a href="#" title=""><i class="fa fa-desktop"
								aria-hidden="true"></i>&nbsp&nbspLinh kiện máy tính, PC</a>
						</h3></li>
					<li><h3>
							<a href="#" title=""><i class="fa fa-usb" aria-hidden="true"></i>&nbsp&nbspThiết
								bị lưu trữ</a>
						</h3></li>
					<li><h3>
							<a href="#" title=""><i class="fa fa-volume-up"
								aria-hidden="true"></i>&nbsp&nbspThiết bị nghe nhìn</a>
						</h3></li>
					<li><h3>
							<a href="#" title=""><i class="fa fa-briefcase"
								aria-hidden="true"></i>&nbsp&nbspSản phẩm thanh lý</a>
						</h3></li>
				</ul>
			</div>
			<!-- end sidebar-->
			<div class="aside">
				<div class="tp-aside">
					<div class="form-area clearfix">
						<form action="" method="" name="frmSearch" class="frmSearch">
							<select name="slcSearch" class="slcSearch">
								<option value="0">Tất cả</option>
								<option value="1">Laptop,phụ kiện</option>
								<option value="2">PC,Workstaion</option>
								<option value="3">Camera giám sát</option>
								<option value="4">Linh kiện máy tính, PC</option>
								<option value="5">Thiết bị lưu trữ</option>
								<option value="6">Thiết bị nghe nhìn</option>
								<option value="7">Sản phẩm thanh lý</option>
							</select> <input type="search" name="txtSearch" class="txtSearch" value=""
								placeholder="Gõ từ khóa tìm kiếm...">
							<div class="btnSearch-area">
								<button type="submit" name="btnSearch" class="btnSearch">
									<i class="fa fa-search fa-lg" aria-hidden="true"></i>
								</button>
							</div>
						</form>
					</div>
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
		</div>
		<!-- end main-content-->
	</div>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>