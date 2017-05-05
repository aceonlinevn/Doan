<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<div class="content">
<div class="wrapper">
	<div class="sub-content">
		<div class="sidebar">
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