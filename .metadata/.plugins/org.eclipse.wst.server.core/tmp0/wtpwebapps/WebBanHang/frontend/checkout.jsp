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
		<div class="main-content text-left">
			<ol class="breadcrumb">
				<li><a href="/WebBanHang"><i class="fa fa-home"
						aria-hidden="true"></i> Trang chủ</a></li>
				<li class="active">Xác nhận đơn hàng</li>
			</ol>
			<%
				Cookie[] listCookie = request.getCookies();
				String name = "";
				if (listCookie != null) {
					for (int i = 0; i < listCookie.length; i++) {
						if (listCookie[i].getName().equalsIgnoreCase("shopping_cart_store")) {
							name = listCookie[i].getValue();
						}
					}
				}
				String[] items = Utilities.decodeString(name + "==").split(",");
				ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
				ProductControl pc = new ProductControl(cp);
				if (cp == null) {
					application.setAttribute("cpool", pc.getConnectionPool());
				}
			%>
			<div class="content-cart">
				<form action="/WebBanHang/product/cart" method="post" accept-charset="UTF-8">
					<div class="col-sm-3">
						<%
							UserObject userLogined = (UserObject) session.getAttribute("userLogined");
							String cusName = "";
							String cusEmail = "";
							String cusPhonenum = "";
							String cusAddress = "";
							String cusNote = "";
							String readonly = "";
							if (userLogined != null && userLogined.getUser_permission_id() != 0) {
								cusName = userLogined.getUser_name();
								cusEmail = userLogined.getUser_email();
								cusPhonenum = userLogined.getUser_phonenum();
								cusAddress = userLogined.getUser_address();
								cusNote = userLogined.getUser_note();
								readonly = "readonly";
							}else{
								out.println("<div class=\"form-group\">Nếu quý khách có tài khoản nhấn vào đây: <a href=\"javascript:void(0)\" class=\"btn btn-primary\" title=\"Đăng nhập\" data-toggle=\"modal\" data-target=\"#mdLogin\">Đăng nhập</a></div>");
							}
						%>
						<div class="title-custom">Thông tin khách hàng</div>
						<div class="form-group">
							<label for="txtCustomerName">Họ tên quý khách</label> <input
								type="text" id="txtCustomerName" name="txtCustomerName"
								required="required" value="<%=cusName %>" class="form-control">
						</div>
						<div class="form-group">
							<label for="txtCustomerEmail">Địa chỉ email</label> <input
								type="text" id="txtCustomerEmail" name="txtCustomerEmail"
								required="required" <%=readonly %> value="<%=cusEmail %>" class="form-control">
						</div>
						<div class="form-group">
							<label for="txtCustomerPhoneNumber">Địa thoại</label> <input
								type="text" id="txtCustomerPhoneNumber"
								name="txtCustomerPhoneNumber" value="<%=cusPhonenum %>" required="required"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="txtCustomerAdress">Địa chỉ</label>
							<textarea id="txtCustomerAdress" name="txtCustomerAdress"
								class="form-control" required="required"><%=cusAddress %></textarea>
						</div>
						<div class="form-group">
							<label for="txtCustomerNote">Ghi chú</label>
							<textarea id="txtCustomerNote" name="txtCustomerNote"
								class="form-control"><%=cusNote %></textarea>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="title-custom">Hình thức thanh toán</div>
						<div class="radio">
							<label> <input type="radio" id="txtCustomPay"
								name="txtCustomPay" value="Thanh toán trực tiếp" checked>&nbsp;&nbsp;Thanh toán trực
								tiếp
							</label>
						</div>
						<div class="title-custom">Hình thức vận chuyển</div>
						<div class="radio">
							<label><input type="radio" name="txtCustomTranfer"
								value="Vận chuyển tính phí theo thỏa thuận" checked>&nbsp;&nbsp;Vận
								chuyển tính phí theo thỏa thuận</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="txtCustomTranfer"
								value="Miễn phí trong nội thành Hà Nội">&nbsp;&nbsp;Miễn
								phí trong nội thành Hà Nội</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="txtCustomTranfer"
								value="Miễn phí trong 35 KM">&nbsp;&nbsp;Miễn phí trong
								35 KM</label>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="title-custom">Xác nhận đơn hàng</div>
						<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>STT</th>
								<th>TÊN SẢN PHẨM</th>
								<th>GIÁ</th>
								<th>SỐ LƯỢNG</th>
							</tr>
						</thead>
						<tbody>
						<%
						String carts =  ",";
						int total = 0;
						for(int i=1;i<items.length;i++){						
							String[] item = items[i].split("-");
							carts += item[0]+"-"+item[1]+"-"+item[2]+",";
							ProductObject po = pc.getProductObject(Integer.parseInt(item[1]));
							if(po != null){
								out.println("<tr>");
								out.println("<td>"+(i)+"</td>");
								out.println("<td><a href=\"/WebBanHang/frontend/detail.jsp?prid="+po.getProduct_id()+"\" target=\"_blank\">"+po.getProduct_name()+"</a></td>");
								out.println("<td><strong style=\"color:red;font-weight: bold;\">"+Utilities.convertMoney(Integer.parseInt(item[3]) * Integer.parseInt(item[2]))+" VND</strong></td>");
								out.println("<td>"+item[2]+"</td>");
								out.println("</tr>");
								total += (Integer.parseInt(item[3]) * Integer.parseInt(item[2]));
							}else{
								out.println("lỗi");
							}
						}
						out.println("<input type=\"hidden\" name=\"send_order\" value=\"yes\">");
						out.println("<input type=\"hidden\" name=\"item_update_quantity\" id=\"item_update_quantity\" value=\""+carts+"\">");
						out.println("<input type=\"hidden\" name=\"update_quantity\" value=\"yes\">");
						out.println("<input type=\"hidden\" name=\"total_cart_value\" id=\"total_cart_value\" value="+total+">");
						%>
						<tr>
							<td colspan="4" align="right">
								<b>Tổng tiền:</b>
	        					<b style="color:red; font-size:18px;"><span class="sub1" id="total_value" style="color: red; font-weight: bold;"><% out.println(Utilities.convertMoney(total)); %></span> VND</b><br>
	        					<b>Chưa bao gồm phí vận chuyển</b>
	        				</td>
						</tr>
						</tbody>
					</table>
					<div class="bt-cart pull-right">
					<button type="submit"  class="btn btn-danger">Đặt hàng</button>
				</div>
					</div>
				</form>
			</div>
		</div>
		<!-- end main-content-->
	</div>
	<jsp:include page="footer.jsp" flush="false"></jsp:include>