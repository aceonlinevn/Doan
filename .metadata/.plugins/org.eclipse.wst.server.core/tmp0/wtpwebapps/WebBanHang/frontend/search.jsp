<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% String viewCategorySearch = (String) session.getAttribute("viewCategorySearch"); %>
<div class="form-area clearfix">
	<form action="" method="" name="frmSearch" class="frmSearch">
		<%=viewCategorySearch %>
		<input type="search" name="txtSearch" class="txtSearch" value=""
			placeholder="Gõ từ khóa tìm kiếm...">
		<div class="btnSearch-area">
			<button type="submit" name="btnSearch" class="btnSearch">
				<i class="fa fa-search fa-lg" aria-hidden="true"></i>
			</button>
		</div>
	</form>
</div>