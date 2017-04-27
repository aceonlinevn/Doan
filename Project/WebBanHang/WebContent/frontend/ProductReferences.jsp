<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="product-reference">
	<div class="product-detail-title">Có thể bạn quan tâm</div>
	<%
		String viewProductForReferences = (String) session.getAttribute("viewProductForReferences");
		if (viewProductForReferences != null) {
			out.print(viewProductForReferences);
		} else {
			out.print("<p>Sản phẩm đang update...</p>");
		}
	%>
</div>