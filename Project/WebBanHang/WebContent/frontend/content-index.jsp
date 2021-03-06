<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tp-main-content">
	<script src="<%=request.getContextPath()%>/frontend/js/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#tabs").tabs();
		});
	</script>
	<div id="tabs">
		<ul>
			<li><a href="#products-sale-tab">Sản phẩm khuyến mại</a></li>
			<li><a href="#products-selling-tab">Sản phẩm bán chạy</a></li>
			<li><a href="#products-new-tab">Sản phẩm mới</a></li>
			<li><a href="#products-liquidation-tab">Sản phẩm thanh lý</a></li>
		</ul>
		<div id="products-sale-tab">
			<%
				String viewProductPromotion = (String) session.getAttribute("viewProductPromotion");
				if (viewProductPromotion != null) {
					out.print(viewProductPromotion);
				} else {
					out.print("<p>Sản phẩm đang update...</p>");
				}
			%>
		</div>
		<div id="products-selling-tab">
			<%
				String viewProductForSelling = (String) session.getAttribute("viewProductForSelling");
				if (viewProductForSelling != null) {
					out.print(viewProductForSelling);
				} else {
					out.print("<p>Sản phẩm đang update...</p>");
				}
			%>
		</div>
		<div id="products-new-tab">
			<%
				String viewProductForNew = (String) session.getAttribute("viewProductForNew");
				if (viewProductForNew != null) {
					out.print(viewProductForNew);
				} else {
					out.print("<p>Sản phẩm đang update...</p>");
				}
			%>
		</div>
		<div id="products-liquidation-tab">
			<%
				String viewProductForLiquidation = (String) session.getAttribute("viewProductForLiquidation");
				if (viewProductForLiquidation != null) {
					out.print(viewProductForLiquidation);
				} else {
					out.print("<p>Sản phẩm đang update...</p>");
				}
			%>
		</div>
	</div>
	<!-- end tabs-->
	<div class="news-area"></div>
	<!-- end news-area-->
</div>
<!-- end tp-main-content-->
<div class="clr"></div>
<div class="bt-main-content">
	<%
		String viewProductForCategory = (String) session.getAttribute("viewProductForCategory");
		if (viewProductForCategory != null) {
			out.print(viewProductForCategory);
		} else {
			out.print("<p>Sản phẩm đang update...</p>");
		}
	%>
</div>
<!-- end bt-main-content-->