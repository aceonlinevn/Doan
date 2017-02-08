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
	        out.print("   <div class=\"menu\">");
	        out.print("    <ul>  ");
	        out.print("    <li> <a href=\"#\"><h3>Tổng quan</h3></a></li>");
	        out.print("    <li><a><h3>Báo cáo</h3></a>");
	        out.print("     <ul  class=\"menuchild\">");
	        out.print("      <li><a href=\"#\"><h3>Bán hàng</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Mua hàng</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Kho</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Công nợ</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Quỹ tiền</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Lợi nhuận</h3></a> </li>  ");
	        out.print("     </ul>");
	        out.print("    </li>");
	        out.print("    <li><a><h3>Quản lý sản phẩm</h3></a>");
	        out.print("     <ul class=\"menuchild\">");
	        out.print("      <li><a href=\"#\"><h3>Quản lý hệ sản phẩm</h3> </a></li>");
	        out.print("      <li><a href=\"#\"><h3>Quản lý loại sản phẩm</h3> </a></li>");
	        out.print("      <li><a href=\"#\"><h3>Quản lý sản phẩm</h3> </a></li>    ");
	        out.print("     </ul>");
	        out.print("    </li>");
	        out.print("    <li><a><h3>Kho</h3></a>");
	        out.print("     <ul class=\"menuchild\">");
	        out.print("      <li><a href=\"#\"><h3>Nhập kho</h3> </a></li>");
	        out.print("      <li><a href=\"#\"><h3>Xuất kho</h3> </a></li>");
	        out.print("      <li><a href=\"#\"><h3>Chuyển kho</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Kiểm kê kho</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Tổng hợp tồn kho</h3></a> </li>");
	        out.print("     </ul>");
	        out.print("    </li>");
	        out.print("    <li><a><h3>Hóa đơn</h3></a>");
	        out.print("     <ul class=\"menuchild\">");
	        out.print("      <li><a href=\"#\"><h3>Xuất hóa đơn</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Hủy hóa đơn</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Tình trạng hóa đơn</h3></a> </li>");
	        out.print("     </ul>");
	        out.print("    </li>");
	        out.print("    <li><a><h3>Khách hàng</h3></a>");
	        out.print("     <ul class=\"menuchild\">");
	        out.print("      <li><a href=\"#\"><h3>Danh sách khách hàng</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Chăm sóc khách hàng</h3></a> </li>");
	        out.print("     </ul>");
	        out.print("    </li>");
	        out.print("    <li> <a href=\"#\"><h3>Bảo hành</h3></a></li>");
	        out.print("    <li><a><h3>Quản lý nội dung</h3></a>");
	        out.print("     <ul class=\"menuchild\">");
	        out.print("      <li><a href=\"#\"><h3>Quản lý chuyên mục</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Đăng bài</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Quảng cáo</h3></a> </li>");
	        out.print("     </ul>");
	        out.print("    </li>");
	        out.print("    <li><a><h3>Khuyến mại</h3></a>");
	        out.print("     <ul class=\"menuchild\">");
	        out.print("      <li><a href=\"#\"><h3>Chương trình khuyến mại</h3></a> </li>");
	        out.print("      <li><a href=\"#\"><h3>Thẻ Voucher</h3></a> </li>");
	        out.print("     </ul>");
	        out.print("    </li>");
	        out.print("    <li> <a href=\"#\"><h3>Đơn hàng</h3></a></li>");
	        out.print("    </ul> ");
	        out.print("   </div> ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
