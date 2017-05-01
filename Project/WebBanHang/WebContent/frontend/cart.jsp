<%@page import="com.gui.product.ProductControl"%>
<%@page import="com.object.ProductObject"%>
<%@page import="com.library.Utilities"%>
<%@ page import="com.*,com.object.*"%>
<%@ page import="com.gui.product.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
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
		<div class="main-content">
		<div id="tp-cart">
	      <i class="bg icon_large_cart"></i>
	      <h1>Chi tiết giỏ hàng</h1>
	      <p>Để xóa sản phẩm khỏi giỏ hàng, bấm <i class="fa fa-trash-o" aria-hidden="true"></i>, để mua thêm bấm <b>"Mua thêm sản phẩm khác"</b>.
	        Để sang bước đặt hàng tiếp theo, bấm <b>"Tiếp tục"</b></p>
		</div>
			<%
			Cookie[] listCookie = request.getCookies();
			String name = "";
			int co = 0;
			if(listCookie != null){
		        while(co < listCookie.length){
		          if(listCookie[co].getName().equals("shopping_cart_store")){
		        	  name = listCookie[co].getValue();
		           }
		          co++;
		        }
		  
		      }
			String[] items = Utilities.decodeString(name).split(",");
			ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
			ProductControl pc = new ProductControl(cp);
			if (cp == null) {
				application.setAttribute("cpool", pc.getConnectionPool());
			}
			%>
			<div class="content-cart">
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>STT</th>
							<th colspan="2">TÊN SẢN PHẨM</th>
							<th>GIÁ</th>
							<th>SỐ LƯỢNG</th>
							<th>TỔNG</th>
							<th>XÓA</th>
						</tr>
					</thead>
					<tbody>
					<%
					for(int i=1;i<items.length;i++){
						String[] item = items[i].split("-");
						ProductObject po = pc.getProductObject(Integer.parseInt(item[1]));
						out.println("<tr>");
						out.println("<td>"+(i)+"</td>");
						out.println("<td><img src=\""+po.getProduct_image()+"\" width=\"40\" height=\"30\" /></td>");
						out.println("<td>"+po.getProduct_name()+"</td>");
						out.println("<td><span id=\"sell_price_pro_"+item[1]+"\">"+item[3]+"</span>VND</td>");
						out.println("<td><input name=\"quantity_pro_"+item[1]+"\" id=\"quantity_pro_"+item[1]+"\" value=\""+item[2]+"\" onchange=\"updatePrice('"+item[0]+"','"+item[1]+"',this.value)\" size=\"5\"></td>");
						out.println("<td><b><span id=\"price_pro_"+item[1]+"\"></span> VND</b></td>");
						out.println("<td><a href=\"javascript:deleteShoppingCartItem('"+item[0]+"','"+item[1]+"','"+item[2]+"','"+item[3]+"')\"><i class=\"fa fa-trash-o\" aria-hidden=\"true\"></i></a></td>");
						out.println("</tr>");											
					}
					%>
					</tbody>
				</table>
			</div>
		</div>
		<!-- end main-content-->
	</div>
	<jsp:include page="footer.jsp" flush="false"></jsp:include>