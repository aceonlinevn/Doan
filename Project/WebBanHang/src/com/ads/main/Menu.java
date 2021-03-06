package com.ads.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Menu
 */
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType(CONTENT_TYPE);
	        PrintWriter out = response.getWriter();
	        out.println("<div class=\"nav-side-menu\">");
	        out.println("<div class=\"brand\">Brand Logo</div>");
	        out.println("<i class=\"fa fa-bars fa-2x toggle-btn\" data-toggle=\"collapse\" data-target=\"#menu-content\"></i>");
	        out.println("<div class=\"menu-list\">");
	        out.println("<ul id=\"menu-content\" class=\"menu-content collapse out\">");
	        out.println("<li><a href=\"#\"><i class=\"fa fa-dashboard fa-lg\"></i> Tổng quan</a></li>");
	        out.println("<li  data-toggle=\"collapse\" data-target=\"#report\" class=\"collapsed\"><a href=\"#\"><i class=\"fa fa-gift fa-lg\"></i> Báo cáo <span class=\"arrow\"></span></a></li>");
	        out.println("<ul class=\"sub-menu collapse\" id=\"report\">");
	        out.println("<li class=\"active\"><a href=\"#\">Bán hàng</a></li>");
	        out.println("<li><a href=\"#\">Mua hàng</a></li>");
	        out.println("<li><a href=\"#\">Kho</a></li>");
	        out.println("<li><a href=\"#\">Công nợ</a></li>");
	        out.println("<li><a href=\"#\">Quỹ tiền</a></li>");
	        out.println("<li><a href=\"#\">Lợi nhuận</a></li>");
	        out.println("</ul>");
	        out.println("<li data-toggle=\"collapse\" data-target=\"#products\" class=\"collapsed\"><a href=\"#\"><i class=\"fa fa-product-hunt\" aria-hidden=\"true\"></i> Quản lý sản phẩm <span class=\"arrow\"></span></a></li>  ");
	        out.println("<ul class=\"sub-menu collapse\" id=\"products\">");
	        out.println("<li><a href=\"/WebBanHang/categorygroup/view\">Quản lý hệ sản phẩm</a></li>");
	        out.println("<li><a href=\"/WebBanHang/category/view\">Quản lý loại sản phẩm</a></li>");
	        out.println("<li><a href=\"/WebBanHang/product/view\">Quản lý sản phẩm</a></li>");
	        out.println("</ul>");
	        out.println("<li data-toggle=\"collapse\" data-target=\"#store\" class=\"collapsed\"><a href=\"#\"><i class=\"fa fa-life-ring\" aria-hidden=\"true\"></i> Kho <span class=\"arrow\"></span></a></li>  ");
	        out.println("<ul class=\"sub-menu collapse\" id=\"store\">");
	        out.println("<li><a href=\"#\">Nhập kho</a></li>");
	        out.println("<li><a href=\"#\">Xuất kho</a></li>");
	        out.println("<li><a href=\"#\">Chuyển kho</a></li>");
	        out.println("<li><a href=\"#\">Kiểm kê kho</a></li>");
	        out.println("<li><a href=\"#\">Tổng hợp tồn kho</a></li>");
	        out.println("</ul>");
	        out.println("<li data-toggle=\"collapse\" data-target=\"#receipt\" class=\"collapsed\"><a href=\"#\"><i class=\"fa fa-files-o\" aria-hidden=\"true\"></i> Hóa đơn <span class=\"arrow\"></span></a></li>  ");
	        out.println("<ul class=\"sub-menu collapse\" id=\"receipt\">");
	        out.println("<li><a href=\"/WebBanHang/bill/view\">Tình trạng hóa đơn</a></li>");
	        out.println("</ul>");
	        out.println("<li data-toggle=\"collapse\" data-target=\"#customer\" class=\"collapsed\"><a href=\"#\"><i class=\"fa fa-user-o\" aria-hidden=\"true\"></i> Khách hàng <span class=\"arrow\"></span></a></li>  ");
	        out.println("<ul class=\"sub-menu collapse\" id=\"customer\">");
	        out.println("<li><a href=\"#\">Danh sách khách hàng</a></li>");
	        out.println("<li><a href=\"#\">Chăm sóc khách hàng</a></li>");
	        out.println("</ul>");
	        out.println("<li data-toggle=\"collapse\" data-target=\"#article\" class=\"collapsed\"><a href=\"#\"><i class=\"fa fa-file-text-o\" aria-hidden=\"true\"></i> Quản lý nội dung <span class=\"arrow\"></span></a></li>  ");
	        out.println("<ul class=\"sub-menu collapse\" id=\"article\">");
	        out.println("<li><a href=\"#\">Quản lý chuyên mục</a></li>");
	        out.println("<li><a href=\"#\">Đăng bài</a></li>");
	        out.println("<li><a href=\"#\">Quảng cáo</a></li>");
	        out.println("</ul>");
	        out.println("<li><a href=\"#\"><i class=\"fa fa-exclamation-triangle\" aria-hidden=\"true\"></i> Bảo hành</a></li>");
	        out.println("<li data-toggle=\"collapse\" data-target=\"#sales\" class=\"collapsed\"><a href=\"#\"><i class=\"fa fa-gift fa-lg\"></i> Khuyến mại <span class=\"arrow\"></span></a></li>  ");
	        out.println("<ul class=\"sub-menu collapse\" id=\"sales\">");
	        out.println("<li><a href=\"#\">Chương trình khuyến mại</a></li>");
	        out.println("<li><a href=\"#\">Thẻ Voucher</a></li>");
	        out.println("</ul>");
	        out.println("<li><a href=\"#\"><i class=\"fa fa-users fa-lg\"></i> Users</a></li>");
	        out.println("</ul>");
	        out.println("</div>");
	        out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
