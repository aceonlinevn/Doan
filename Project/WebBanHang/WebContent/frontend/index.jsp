<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<div class="content">
<div class="wrapper">
	<div class="sub-content">
		<div class="sidebar">
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
				<jsp:include page="search.jsp" flush="true"></jsp:include>
				<div class="nav">
					<a href="tel:19009068" class="support-number">Hỗ trợ trực
						tuyến: 1900.9068</a> <a href="#" class="news-tp-aside">Tin tức</a> <a
						href="#" class="contact-tp-aside">Liên hệ - hợp tác</a>
				</div>
			</div>
			<!-- end tp-aside-->
			<div class="bt-aside">
				<div class="l-bt-aside">
					<img src="<%=request.getContextPath()%>/frontend/pictures/tv.gif">
				</div>
				<!-- end l-tp-aside-->
				<div class="r-bt-aside">
					<div class="ads">
						<img
							src="<%=request.getContextPath()%>/frontend/pictures/banner3.jpg">
					</div>
				</div>
				<!-- end r-tp-aside-->
			</div>
			<!-- end bt-aside-->
		</div>
		<!-- end aside-->
	</div>
	<!-- end sub-content-->
	<div class="clr"></div>
	<div class="main-content">
		<jsp:include page="content-index.jsp" flush="true"></jsp:include>
	</div>
	<!-- end main-content-->
</div>
<jsp:include page="footer.jsp" flush="false"></jsp:include>