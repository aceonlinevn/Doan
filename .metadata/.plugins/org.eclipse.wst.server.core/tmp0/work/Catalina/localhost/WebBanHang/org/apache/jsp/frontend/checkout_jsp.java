/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.33
 * Generated at: 2017-05-01 21:24:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.frontend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.gui.product.ProductControl;
import com.object.ProductObject;
import com.library.Utilities;
import com.*;
import com.object.*;
import com.gui.product.*;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("com");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.gui.product");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("com.object");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.library.Utilities");
    _jspx_imports_classes.add("com.gui.product.ProductControl");
    _jspx_imports_classes.add("com.object.ProductObject");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, true);
      out.write("\r\n");
      out.write("<div class=\"content\">\r\n");
      out.write("\t<div class=\"wrapper\">\r\n");
      out.write("\t\t<div class=\"sub-content\">\r\n");
      out.write("\t\t\t<div class=\"sidebar side-bar-auto\">\r\n");
      out.write("\t\t\t\t<div class=\"sidebar-title\">Danh mục sản phẩm</div>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><h3>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" title=\"\"><i class=\"fa fa-laptop\"\r\n");
      out.write("\t\t\t\t\t\t\t\taria-hidden=\"true\"></i>&nbsp&nbspLaptop,phụ kiện</a>\r\n");
      out.write("\t\t\t\t\t\t</h3></li>\r\n");
      out.write("\t\t\t\t\t<li><h3>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" title=\"\"><i class=\"fa fa-gamepad\"\r\n");
      out.write("\t\t\t\t\t\t\t\taria-hidden=\"true\"></i>&nbsp&nbspPC,Workstaion</a>\r\n");
      out.write("\t\t\t\t\t\t</h3></li>\r\n");
      out.write("\t\t\t\t\t<li><h3>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" title=\"\"><i class=\"fa fa-video-camera\"\r\n");
      out.write("\t\t\t\t\t\t\t\taria-hidden=\"true\"></i>&nbsp&nbspCamera giám sát</a>\r\n");
      out.write("\t\t\t\t\t\t</h3></li>\r\n");
      out.write("\t\t\t\t\t<li><h3>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" title=\"\"><i class=\"fa fa-desktop\"\r\n");
      out.write("\t\t\t\t\t\t\t\taria-hidden=\"true\"></i>&nbsp&nbspLinh kiện máy tính, PC</a>\r\n");
      out.write("\t\t\t\t\t\t</h3></li>\r\n");
      out.write("\t\t\t\t\t<li><h3>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" title=\"\"><i class=\"fa fa-usb\" aria-hidden=\"true\"></i>&nbsp&nbspThiết\r\n");
      out.write("\t\t\t\t\t\t\t\tbị lưu trữ</a>\r\n");
      out.write("\t\t\t\t\t\t</h3></li>\r\n");
      out.write("\t\t\t\t\t<li><h3>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" title=\"\"><i class=\"fa fa-volume-up\"\r\n");
      out.write("\t\t\t\t\t\t\t\taria-hidden=\"true\"></i>&nbsp&nbspThiết bị nghe nhìn</a>\r\n");
      out.write("\t\t\t\t\t\t</h3></li>\r\n");
      out.write("\t\t\t\t\t<li><h3>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" title=\"\"><i class=\"fa fa-briefcase\"\r\n");
      out.write("\t\t\t\t\t\t\t\taria-hidden=\"true\"></i>&nbsp&nbspSản phẩm thanh lý</a>\r\n");
      out.write("\t\t\t\t\t\t</h3></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- end sidebar-->\r\n");
      out.write("\t\t\t<div class=\"aside\">\r\n");
      out.write("\t\t\t\t<div class=\"tp-aside\">\r\n");
      out.write("\t\t\t\t\t<div class=\"form-area clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<form action=\"\" method=\"\" name=\"frmSearch\" class=\"frmSearch\">\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"slcSearch\" class=\"slcSearch\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"0\">Tất cả</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"1\">Laptop,phụ kiện</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"2\">PC,Workstaion</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"3\">Camera giám sát</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"4\">Linh kiện máy tính, PC</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"5\">Thiết bị lưu trữ</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"6\">Thiết bị nghe nhìn</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"7\">Sản phẩm thanh lý</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select> <input type=\"search\" name=\"txtSearch\" class=\"txtSearch\" value=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"Gõ từ khóa tìm kiếm...\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"btnSearch-area\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"submit\" name=\"btnSearch\" class=\"btnSearch\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<i class=\"fa fa-search fa-lg\" aria-hidden=\"true\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"tel:19009068\" class=\"support-number\">Hỗ trợ trực\r\n");
      out.write("\t\t\t\t\t\t\ttuyến: 1900.9068</a> <a href=\"#\" class=\"news-tp-aside\">Tin tức</a> <a\r\n");
      out.write("\t\t\t\t\t\t\thref=\"#\" class=\"contact-tp-aside\">Liên hệ - hợp tác</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- end tp-aside-->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- end aside-->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- end sub-content-->\r\n");
      out.write("\t\t<div class=\"clr\"></div>\r\n");
      out.write("\t\t<div class=\"main-content text-left\">\r\n");
      out.write("\t\t\t<ol class=\"breadcrumb\">\r\n");
      out.write("\t\t\t\t<li><a href=\"/WebBanHang\"><i class=\"fa fa-home\"\r\n");
      out.write("\t\t\t\t\t\taria-hidden=\"true\"></i> Trang chủ</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"active\">Xác nhận đơn hàng</li>\r\n");
      out.write("\t\t\t</ol>\r\n");
      out.write("\t\t\t");

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
			
      out.write("\r\n");
      out.write("\t\t\t<div class=\"content-cart\">\r\n");
      out.write("\t\t\t\t<form action=\"/WebBanHang/product/cart\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t");

							UserObject userLogined = (UserObject) session.getAttribute("userLogined");
							String cusName = "";
							String cusEmail = "";
							String cusPhonenum = "";
							String cusAddress = "";
							String cusNote = "";
							if (userLogined != null && userLogined.getUser_permission_id() != 0) {
								cusName = userLogined.getUser_name();
								cusEmail = userLogined.getUser_email();
								cusPhonenum = userLogined.getUser_phonenum();
								cusAddress = userLogined.getUser_address();
								cusNote = userLogined.getUser_note();
							}else{
								out.println("<div class=\"form-group\">Nếu quý khách có tài khoản nhấn vào đây: <a href=\"javascript:void(0)\" class=\"btn btn-primary\" title=\"Đăng nhập\" data-toggle=\"modal\" data-target=\"#mdLogin\">Đăng nhập</a></div>");
							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"title-custom\">Thông tin khách hàng</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"txtCustomerName\">Họ tên quý khách</label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"text\" id=\"txtCustomerName\" name=\"txtCustomerName\"\r\n");
      out.write("\t\t\t\t\t\t\t\trequired=\"required\" value=\"");
      out.print(cusName );
      out.write("\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"txtCustomerEmail\">Địa chỉ email</label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"text\" id=\"txtCustomerEmail\" name=\"txtCustomerEmail\"\r\n");
      out.write("\t\t\t\t\t\t\t\trequired=\"required\" value=\"");
      out.print(cusEmail );
      out.write("\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"txtCustomerPhoneNumber\">Địa thoại</label> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"text\" id=\"txtCustomerPhoneNumber\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"txtCustomerPhoneNumber\" value=\"");
      out.print(cusPhonenum );
      out.write("\" required=\"required\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"txtCustomerAdress\">Địa chỉ</label>\r\n");
      out.write("\t\t\t\t\t\t\t<textarea id=\"txtCustomerAdress\" name=\"txtCustomerAdress\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control\" required=\"required\">");
      out.print(cusAddress );
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"txtCustomerNote\">Ghi chú</label>\r\n");
      out.write("\t\t\t\t\t\t\t<textarea id=\"txtCustomerNote\" name=\"txtCustomerNote\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"form-control\">");
      out.print(cusNote );
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-3\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"title-custom\">Hình thức thanh toán</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"radio\">\r\n");
      out.write("\t\t\t\t\t\t\t<label> <input type=\"radio\" id=\"txtCustomPay\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"txtCustomPay\" value=\"Thanh toán trực tiếp\" checked>&nbsp;&nbsp;Thanh toán trực\r\n");
      out.write("\t\t\t\t\t\t\t\ttiếp\r\n");
      out.write("\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"title-custom\">Hình thức vận chuyển</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"radio\">\r\n");
      out.write("\t\t\t\t\t\t\t<label><input type=\"radio\" name=\"txtCustomTranfer\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"Vận chuyển tính phí theo thỏa thuận\" checked>&nbsp;&nbsp;Vận\r\n");
      out.write("\t\t\t\t\t\t\t\tchuyển tính phí theo thỏa thuận</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"radio\">\r\n");
      out.write("\t\t\t\t\t\t\t<label><input type=\"radio\" name=\"txtCustomTranfer\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"Miễn phí trong nội thành Hà Nội\">&nbsp;&nbsp;Miễn\r\n");
      out.write("\t\t\t\t\t\t\t\tphí trong nội thành Hà Nội</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"radio\">\r\n");
      out.write("\t\t\t\t\t\t\t<label><input type=\"radio\" name=\"txtCustomTranfer\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"Miễn phí trong 35 KM\">&nbsp;&nbsp;Miễn phí trong\r\n");
      out.write("\t\t\t\t\t\t\t\t35 KM</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"title-custom\">Xác nhận đơn hàng</div>\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table table-striped table-bordered\">\r\n");
      out.write("\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>STT</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>TÊN SẢN PHẨM</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>GIÁ</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th>SỐ LƯỢNG</th>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t\t");

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
						out.println("<input type=\"hidden\" name=\"total_cart_value\" id=\"total_cart_value\">");
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"4\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<b>Tổng tiền:</b>\r\n");
      out.write("\t        \t\t\t\t\t<b style=\"color:red; font-size:18px;\"><span class=\"sub1\" id=\"total_value\" style=\"color: red; font-weight: bold;\">");
 out.println(Utilities.convertMoney(total)); 
      out.write("</span> VND</b><br>\r\n");
      out.write("\t        \t\t\t\t\t<b>Chưa bao gồm phí vận chuyển</b>\r\n");
      out.write("\t        \t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t<div class=\"bt-cart pull-right\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\"  class=\"btn btn-danger\">Đặt hàng</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- end main-content-->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
