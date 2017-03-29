<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Hùng Cường Computer</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/css/font-awesome.min.css">
	<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/frontend/js/jquery-1.8.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/frontend/js/owl.carousel.js"></script>
	<script src="<%=request.getContextPath()%>/frontend/js/common.js"></script>
</head>
<body>
	<div class="header">
		<div class="tp-header">
			<div class="wrapper">
				<div class="l-tp-header">
					<a href="tel:0965909929" title="Chăm sóc khách hàng"><i class="fa fa-phone" aria-hidden="true"></i> Chăm sóc khách hàng: <span class="phone-number">0965 909 929</span></a>
					<a href="#" title="Tải báo giá,hợp đồng"><i class="fa fa-download" aria-hidden="true"></i> Tải báo giá,hợp đồng</a>
					<a href="#" title="Xây dựng cấu hình"><i class="fa fa-laptop" aria-hidden="true"></i> Xây dựng cấu hình</a>
					<a href="#" title="Tin tức nổi bật"><i class="fa fa-newspaper-o" aria-hidden="true"></i> Tin tức nổi bật</a>
				</div><!-- end l-tp-header-->
				<div class="r-tp-header"></div><!-- end r-tp-header-->
			</div>
		</div><!-- end tp-header-->
		<div class="clr"></div>
		<div class="bt-header">
			<div class="wrapper">
				<div class="l-bt-header">
					<a href="#" title="Hùng cường Computer">logo</a>
				</div><!-- end l-bt-header-->
				<div class="c-bt-header">
					<div class="slider-wrapper theme-default">
						<div id="slider" class="nivoSlider">
							<a href="#"><img src="<%=request.getContextPath()%>/frontend/pictures/banner4.jpg"  alt="" /></a>
							<a href="#"><img src="<%=request.getContextPath()%>/frontend/pictures/banner1.jpg"  alt="" /></a>
							<a href="#"><img src="<%=request.getContextPath()%>/frontend/pictures/banner2.jpg"  alt="" /></a>
						</div>
						</div><!--End .slider-wrapper-->
						<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/frontend/js/jquery.nivo.slider.js"></script>
						<script type="text/javascript">
							$(window).load(function() {
								$('#slider').nivoSlider();
							});
						</script>
				</div><!-- end c-bt-header-->
				<div class="r-bt-header">
					<div class="login-area">
						<a href="#" title="Đăng nhập"><i class="fa fa-user" aria-hidden="true"></i> Đăng nhập</a>
						<a href="#" title="Đăng nhập"><i class="fa fa-user-plus" aria-hidden="true"></i> Đăng ký</a>
					</div>
					<div class="cart-area">
						<a href="#" title="Giỏ hàng"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Giỏ hàng</a>
						<span class="cart-count"><i class="fa fa-comment-o" aria-hidden="true"></i> <span class="count">0<span></span>
					</div>
				</div><!-- end r-bt-header-->				
			</div>
			<div class="clr"></div>
		</div><!-- end bt-header-->
	</div><!-- end header-->
	<div class="clr"></div>
	<div class="content">
		<div class="wrapper">
			<div class="sub-content">
				<div class="sidebar">
					<div class="sidebar-title">Danh mục sản phẩm</div>
					<ul>
						<li><h3><a href="#" title=""><i class="fa fa-laptop" aria-hidden="true"></i>&nbsp&nbspLaptop,phụ kiện</a></h3></li>
						<li><h3><a href="#" title=""><i class="fa fa-gamepad" aria-hidden="true"></i>&nbsp&nbspPC,Workstaion</a></h3></li>
						<li><h3><a href="#" title=""><i class="fa fa-video-camera" aria-hidden="true"></i>&nbsp&nbspCamera giám sát</a></h3></li>
						<li><h3><a href="#" title=""><i class="fa fa-desktop" aria-hidden="true"></i>&nbsp&nbspLinh kiện máy tính, PC</a></h3></li>
						<li><h3><a href="#" title=""><i class="fa fa-usb" aria-hidden="true"></i>&nbsp&nbspThiết bị lưu trữ</a></h3></li>
						<li><h3><a href="#" title=""><i class="fa fa-volume-up" aria-hidden="true"></i>&nbsp&nbspThiết bị nghe nhìn</a></h3></li>
						<li><h3><a href="#" title=""><i class="fa fa-briefcase" aria-hidden="true"></i>&nbsp&nbspSản phẩm thanh lý</a></h3></li>
					</ul>
				</div><!-- end sidebar-->
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
								</select>
								<input type="search" name="txtSearch" class="txtSearch" value="" placeholder="Gõ từ khóa tìm kiếm...">
								<div class="btnSearch-area">
									<button type="submit" name="btnSearch" class="btnSearch"><i class="fa fa-search fa-lg" aria-hidden="true"></i></button>
								</div>
							</form>
						</div>
						<div class="nav">
							<a href="tel:19009068" class="support-number">Hỗ trợ trực tuyến: 1900.9068</a>
							<a href="#" class="news-tp-aside">Tin tức</a>
							<a href="#" class="contact-tp-aside">Liên hệ - hợp tác</a>
						</div>
					</div><!-- end tp-aside-->
					<div class="bt-aside">
						<div class="l-bt-aside">
							<img src="<%=request.getContextPath()%>/frontend/pictures/tv.gif">
						</div><!-- end l-tp-aside-->
						<div class="r-bt-aside">
							<div class="ads">
								<img src="<%=request.getContextPath()%>/frontend/pictures/banner3.jpg">
							</div>
						</div><!-- end r-tp-aside-->
					</div><!-- end bt-aside-->
				</div><!-- end aside-->
			</div><!-- end sub-content-->
			<div class="clr"></div>
			<div class="main-content">
				<div class="tp-main-content">
					<script src="<%=request.getContextPath()%>/frontend/js/jquery-ui.js"></script>
					<script>
					  $( function() {
					    $( "#tabs" ).tabs();
					  } );
				  	</script>
					<div id="tabs">
						<ul>
						    <li><a href="#products-sale-tab">Sản phẩm khuyến mại</a></li>
						    <li><a href="#products-selling-tab">Sản phẩm bán chạy</a></li>
						    <li><a href="#products-new-tab">Sản phẩm mới</a></li>
						    <li><a href="#products-liquidation-tab">Sản phẩm thanh lý</a></li>
					  	</ul>
					  	<div id="products-sale-tab">
					  		<div class="products">
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT001</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr1.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
									<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>					  				
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT002</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr7.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
									<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>					  				
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT003</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr3.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT004</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr4.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT005</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr5.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT006</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr6.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  		</div><!-- end Products-->
					  	</div>
					  	<div id="products-selling-tab">
					  		<div class="products">
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT001</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr1.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT002</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr2.png" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT003</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr3.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  		</div><!-- end Products-->
					  	</div>
					  	<div id="products-new-tab">
					  		<div class="products">
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT001</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr1.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT002</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr7.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT003</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr3.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT004</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr4.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT005</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr5.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  		</div><!-- end Products-->
					  	</div>
					  	<div id="products-liquidation-tab">
					  		<div class="products">
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT001</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr1.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT002</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr7.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT003</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr3.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			<div class="product">
					  				<div class="product-code">Mã sản phẩm: LT004</div>
					  				<div class="product-image">
					  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr4.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
					  				</div>
					  				<div class="product-price">699.000</div>
					  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
					  				<div class="product-add-cart">
					  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
					  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
					  				</div>
					  				<div class="clr"></div>
					  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
					  			</div><!-- end Product-->
					  			
					  		</div><!-- end Products-->
					  	</div>
					</div><!-- end tabs-->
					<div class="news-area"></div><!-- end news-area-->
				</div><!-- end tp-main-content-->
				<div class="clr"></div>
				<div class="bt-main-content">
				<script>
					$(document).ready(function() {
					  $("#laptop").owlCarousel(
					  	{
					  		items : 5,
					  		itemsDesktop : [1199,5],
						    itemsDesktopSmall : [980,4],
						    itemsTablet: [768,3],
						    itemsTabletSmall: false,
						    itemsMobile : [479,2],
						    loop : true,
						    //autoplayHoverPause:true,
						    //slideSpeed : 200,
						    //autoPlay: 3000,
						    navContainer: true,
						    stopOnHover: true,
						    navigation : true,
						    navigationText : [" "," "],
						    rewindNav : true,
						    scrollPerPage : false,
						    responsive: true,
						    responsiveRefreshRate : 200,
						    responsiveBaseWidth: window,
						    baseClass : "owl-carousel",
    						theme : "owl-theme",
						    lazyLoad : true,
						    lazyFollow : true,
						    lazyEffect : "fade",
						    pagination: false,
					  	});
					});
				</script>
					<div class="section">
						<div class="section-title"><h3>Laptop, Phụ kiện</h3></div>
						<div class="products owl-carousel"  id="laptop">
							<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT001</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr1.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">527.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT002</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr2.png" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">615.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT003</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr3.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">429.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT004</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr4.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">899.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT005</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr5.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">239.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT006</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr6.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">784.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT007</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr7.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">658.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
						</div><!-- end products-->
						<div class="view-more">
							<a href="#"><span class="view-more-img" style="background-image: url(<%=request.getContextPath()%>/frontend/images/laptop.jpg)"></span></a>
						</div>
					</div><!-- end-section-->
					<div class="clr"></div>
					<script>
					$(document).ready(function() {
					  $("#pc").owlCarousel(
					  	{
					  		items : 5,
					  		itemsDesktop : [1199,5],
						    itemsDesktopSmall : [980,4],
						    itemsTablet: [768,3],
						    itemsTabletSmall: false,
						    itemsMobile : [479,2],
						    loop : true,
						    //autoplayHoverPause:true,
						    //slideSpeed : 200,
						    //autoPlay: 3000,
						    navContainer: true,
						    stopOnHover: true,
						    navigation : true,
						    navigationText : [" "," "],
						    rewindNav : true,
						    scrollPerPage : false,
						    responsive: true,
						    responsiveRefreshRate : 200,
						    responsiveBaseWidth: window,
						    baseClass : "owl-carousel",
    						theme : "owl-theme",
						    lazyLoad : true,
						    lazyFollow : true,
						    lazyEffect : "fade",
						    pagination: false,
					  	});
					});
				</script>
					<div class="section">
						<div class="section-title"><h3>PC, Workstation</h3></div>
						<div class="products owl-carousel"  id="pc">
							<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT021</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr7.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">582.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT025</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr6.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">819.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT058</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr5.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">364.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT032</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr4.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">601.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT078</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr3.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">999.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
										<div class="product-info">
											<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
											<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
											<p class="product-warranty">Bản hành: 24 tháng</p>
										</div>
										<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
											<p>Mô tả 1</p>
											<p>Mô tả 2</p>
											<p>Mô tả 3</p>
										</div>
										<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
											<p>Khuyến mại 1</p>
											<p>Khuyến mại 2</p>
										</div>
									</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT014</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr2.png" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">567.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
									<div class="product-info">
										<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
										<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
										<p class="product-warranty">Bản hành: 24 tháng</p>
									</div>
									<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
										<p>Mô tả 1</p>
										<p>Mô tả 2</p>
										<p>Mô tả 3</p>
									</div>
									<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
										<p>Khuyến mại 1</p>
										<p>Khuyến mại 2</p>
									</div>
								</div>
				  			</div><!-- end Product-->
				  			<div class="product">
				  				<div class="product-code">Mã sản phẩm: LT098</div>
				  				<div class="product-image">
				  					<a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87"><img src="<%=request.getContextPath()%>/frontend/pictures/pr1.jpg" alt="Keyboard Geezer GS4 Mechanical Blue Switch 87"></a>
				  				</div>
				  				<div class="product-price">329.000</div>
				  				<div class="product-name"><h2><a href="#" title="Keyboard Geezer GS4 Mechanical Blue Switch 87">Keyboard Geezer GS4 Mechanical Blue Switch 87</a></h2></div>
				  				<div class="product-add-cart">
				  					<span class="product-stocking"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Còn hàng</span>
				  					<a href="#" title="Mua ngay"><i class="fa fa-cart-plus" aria-hidden="true"></i> Mua ngay</a>
				  				</div>
				  				<div class="clr"></div>
				  				<div class="product-hover">
									<div class="product-info">
										<p class="product-name-hover">Keyboard Geezer GS4 Mechanical Blue Switch 87</p>
										<p class="product-price-hover"><span class="price-text">Giá bán: </span><span class="img_price">699.000</span></p>
										<p class="product-warranty">Bản hành: 24 tháng</p>
									</div>
									<div class="product-sumary">
											<div class="title-hover">Mô tả tóm tắt</div>
										<p>Mô tả 1</p>
										<p>Mô tả 2</p>
										<p>Mô tả 3</p>
									</div>
									<div class="product-saleoff">
											<div class="title-hover">Khuyến mại</div>
										<p>Khuyến mại 1</p>
										<p>Khuyến mại 2</p>
									</div>
								</div>
				  			</div><!-- end Product-->
						</div><!-- end products-->
						<div class="view-more">
							<a href="#"><span class="view-more-img" style="background-image: url(<%=request.getContextPath()%>/frontend/images/pc.jpg)"></span></a>
						</div>
					</div><!-- end-section-->
					<div class="clr"></div>
				</div><!-- end bt-main-content-->
			</div><!-- end main-content-->
		</div>
	</div><!-- end content-->
	<div class="clr"></div>
	<div class="footer">
		Copyright&copy2017&nbspHUNGCUONGCOMPUTER
	</div><!-- end footer-->
</body>
</html>