<%@page import="com.library.Utilities"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<%
	String productDetailImg = (String) session.getAttribute("productDetailImg");
	String productDetailName = (String) session.getAttribute("productDetailName");
	String productDetailPrefix = (String) session.getAttribute("productDetailPrefix");
	int productDetailPrice = (int) session.getAttribute("productDetailPrice");
	String productDetailWarranty = (String) session.getAttribute("productDetailWarranty");
	String productDetailSummary = (String) session.getAttribute("productDetailSummary");
	String productDetailContent = (String) session.getAttribute("productDetailContent");
	String product_id = (String) session.getAttribute("product_id");
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
		<div class="main-content">
			<link rel="stylesheet"
				href="<%=request.getContextPath()%>/frontend/css/jquery.fancybox.css?v=2.1.6"
				type="text/css" media="screen" />
			<script type="text/javascript"
				src="<%=request.getContextPath()%>/frontend/js/jquery.fancybox.pack.js?v=2.1.6"></script>
			<link rel="stylesheet"
				href="<%=request.getContextPath()%>/frontend/css/jquery.fancybox-buttons.css?v=1.0.5"
				type="text/css" media="screen" />
			<script type="text/javascript"
				src="<%=request.getContextPath()%>/frontend/js/jquery.fancybox-buttons.js?v=1.0.5"></script>

			<link rel="stylesheet"
				href="<%=request.getContextPath()%>/frontend/css/magiczoom.css">
			<script src="js/magiczoom.js"></script>
			<script type="text/javascript">
				$(document).ready(function() {
					$(".fancybox").fancybox({
						openEffect : 'elastic',
						closeEffect : 'elastic',
						prevEffect : 'none',
						nextEffect : 'none',
						closeBtn : false,
						helpers : {
							title : {
								type : 'inside'
							},
							buttons : {}
						}
					});
					$("#img_large .MagicZoom").click(function() {
						$(".view-large").click();
					});
				});
			</script>
			<a
				href="<%if (productDetailImg != null) {
				out.print(productDetailImg);
			}%>"
				class="fancybox view-large" rel="gallery" style="display: none;"></a>
			<div class="l-main-content">
				<div class="single-img">
					<div id="img_large">
						<a class="MagicZoom" id="Zoomer" rel="selectors-effect-speed: 600"
							href="<%if (productDetailImg != null) {
				out.print(productDetailImg);
			}%>"
							title="Click để xem ảnh lớn"> <img
							src="<%if (productDetailImg != null) {
				out.print(productDetailImg);
			}%>"
							title="Click để xem ảnh lớn" alt="" />
						</a>
					</div>
					<div class="clr"></div>
				</div>
				<!-- end single-img-->
				<div class="single-content">
					<div class="single-product-title">
						<p>
						<h1>
							<%
								if (productDetailName != null) {
									out.print(productDetailName);
								}
							%>
						</h1>
						</p>
						<p class="product-code">
							Mã sản phẩm :
							<%
							if (productDetailPrefix != null) {
								out.print(productDetailPrefix);
							}
						%>
						</p>
					</div>
					<div class="infor-summary">
						<div class="product-price">
							<%
								if (productDetailPrice > 0) {
									out.print(Utilities.convertMoney(productDetailPrice));
								} else {
									out.print("Liên hệ");
								}
							%>
						</div>
						<div class="clr"></div>
						<div class="product-vote">
							Đánh giá: <span class="star-o"></span> <span class="star-o"></span>
							<span class="star-o"></span> <span class="star-d"></span> <span
								class="star-d"></span>
						</div>
						<div class="product-warranty">
							<strong>Bảo hành: </strong>
							<%
								if (productDetailWarranty != null) {
									out.print(productDetailWarranty);
								}
							%>
						</div>
						<div class="product-summary">
							<strong>Mô tả ngắn: </strong>
							<div class="product-content">
								<%
									if (productDetailSummary != null) {
										out.print(productDetailSummary);
									}
								%>
							</div>
						</div>
					</div>
					<div class="bt-single-product">
						<a href="javascript:addToShoppingCart('pro','<%=product_id %>','1','<%=productDetailPrice %>')" class="add-cart-checkout" title="Đặt hàng">Đặt
							hàng</a> <a href="javascript:addToShoppingCartStop('pro','<%=product_id %>','1','<%=productDetailPrice %>')" class="add-to-cart" title="Cho
							vào giỏ hàng">Cho
							vào giỏ hàng</a> <a href="#" class="add-to-favorite"
							title="Đặt hàng">Lưu sản phẩm</a>
						<div class="single-advantage"></div>
					</div>
					<div class="product-detail">
						<div class="product-detail-title">Mô tả chi tiết sản
							phẩm</div>
						<div class="product-detail-area">
							<%
								if (productDetailContent != null) {
									out.print(productDetailContent);
								}
							%>
						</div>
					</div>
					<div class="rate-area">
						<div class="product-detail-title">Đánh giá sản phẩm</div>
						<div class="rate-content">
							<form action="<%=request.getContextPath()%>/ProductRating" method="post" accept-charset="utf-8">
								<table>
									<tbody>
										<tr>
											<td colspan="5"><textarea
													style="padding: 10px; line-height: 1.4" name="comment" id = "comment" cols="90"
													rows="5" placeholder="Nội dung đánh giá"></textarea></td>
										</tr>
										<tr>
											<td colspan="5" align="left"
												style="color: #333; font-size: 14px; font-weight: bold">Đánh giá :</td>
										</tr>
										<tr align="left">
											<td><input type="radio" id="rdoRate" name="rdoRate" value="5" checked="checked" placeholder="">
												<span class="star-o"></span> <span class="star-o"></span> <span
												class="star-o"></span> <span class="star-o"></span> <span
												class="star-o"></span></td>
											<td><input type="radio" id="rdoRate" name="rdoRate" value="4" placeholder="">
												<span class="star-o"></span> <span class="star-o"></span> <span
												class="star-o"></span> <span class="star-o"></span> <span
												class="star-d"></span></td>
											<td><input type="radio" id="rdoRate" name="rdoRate" value="3" placeholder="">
												<span class="star-o"></span> <span class="star-o"></span> <span
												class="star-o"></span> <span class="star-d"></span> <span
												class="star-d"></span></td>
											<td><input type="radio" id="rdoRate" name="rdoRate" value="2" placeholder="">
												<span class="star-o"></span> <span class="star-o"></span> <span
												class="star-d"></span> <span class="star-d"></span> <span
												class="star-d"></span></td>
											<td><input type="radio" id="rdoRate" name="rdoRate" value="1" placeholder="">
												<span class="star-o"></span> <span class="star-d"></span> <span
												class="star-d"></span> <span class="star-d"></span> <span
												class="star-d"></span></td>
										</tr>
										<tr align="right">
											<td colspan="5"><input class="btnRating" type="submit"
												name="" value="Đánh giá"></td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
					</div>
					<!--End Rating-->
					<jsp:include page="ProductReferences.jsp" flush="true"></jsp:include>
					<!-- end Product references -->
				</div>
				<!-- end single-img-->
			</div>
			<!-- end l-main-content-->
			<div class="r-main-content">
				<div class="single-sidebar-title">Hãng sản xuất</div>
				<div class="sidebar-content">
					<table>
						<tbody>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">Hãng khác(6)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">HIK VISION (8)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title=""> QUESTEK (1)</a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!--end sidebar-->

				<div class="single-sidebar-title">Khoảng giá</div>
				<div class="sidebar-content">
					<table>
						<tbody>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">Dưới 5 triệu(10)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">5triệu đến 6 triệu(2)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">6 triệu đến 7 triệu(3)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">7 triệu đến 8 triệu(3)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">8 triệu đến 9 triệu(3)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">9 triệu đến 10 triệu(3)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">10 triệu đến 11 triệu(3)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">11 triệu đến 12 triệu(3)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">12 triệu đến 13 triệu(3)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">13 triệu đến 14 triệu(3)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">14 triệu đến 15 triệu(3)</a></td>
							</tr>
							<tr>
								<td><input type="checkbox"></td>
								<td><a href="" title="">Trên 15 triệu(10)</a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!--end sidebar-->
			</div>
			<!-- end r-main-content-->
		</div>
		<!-- end main-content-->
	</div>
	<jsp:include page="footer.jsp" flush="false"></jsp:include>