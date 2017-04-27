/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.33
 * Generated at: 2017-04-26 19:11:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.frontend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.*;
import com.object.*;
import com.gui.product.*;

public final class data_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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

	ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
	ProductControl pc = new ProductControl(cp);
	if (cp == null) {
		application.setAttribute("cpool", pc.getConnectionPool());
	}
	if (request.getParameter("prid") != null && !request.getParameter("prid").equalsIgnoreCase("")) {
		int id = Integer.parseInt(request.getParameter("prid"));
		ProductObject po = pc.getProductObject(id);
		if (id > 0) {
			String warranty = "";
			if (po.getProduct_warranty_time() < 6) {
				warranty = po.getProduct_warranty_time() + " năm";
			} else {
				warranty = po.getProduct_warranty_time() + " tháng";
			}
			String summary = "";
			if (po.getProduct_summary() != null && !po.getProduct_summary().equalsIgnoreCase("")) {
				summary = po.getProduct_summary();
			} else {
				summary = "Mô tả đang được cập nhât";
			}
			String specification = "";
			if (po.getProduct_specification() != null && !po.getProduct_specification().equalsIgnoreCase("")) {
				specification = po.getProduct_specification();
			} else {
				specification = "Nội dung đang được cập nhât";
			}
			//product detail
			session.setAttribute("productDetailImg", po.getProduct_image());
			session.setAttribute("productDetailName", po.getProduct_name());
			session.setAttribute("productDetailPrefix", po.getCategory_group_prefix());
			session.setAttribute("productDetailPrice", po.getProduct_origin_price());
			session.setAttribute("productDetailWarranty", warranty);
			session.setAttribute("productDetailSummary", summary);
			session.setAttribute("productDetailContent", specification);
		}
	}
	
	//Khai bảo object
	ProductObject similar1 = new ProductObject();
	ProductObject similar2 = new ProductObject();
	ProductObject similar3 = new ProductObject();
	ProductObject similar4 = new ProductObject();
	ProductObject similar = new ProductObject();
	//Khởi tạo điểu kiện
	similar1.setProduct_isnew(true);
	similar2.setProduct_isliquidation(true);
	similar3.setProduct_isselling(true);
	similar4.setProduct_promotion("km");
	//Khởi tạo cấu trúc
	String viewProductForNew = pc.viewProducts(similar1, (byte) 6);
	String viewProductForLiquidation = pc.viewProducts(similar2, (byte) 6);
	String viewProductForSelling = pc.viewProducts(similar3, (byte) 6);
	String viewProductPromotion = pc.viewProducts(similar4, (byte) 6);
	String viewProductForCategory = pc.viewProductsForCategory(similar);
	//Dua cau truc vao phien lam viec
	session.setAttribute("viewProductForNew", viewProductForNew);
	session.setAttribute("viewProductForLiquidation", viewProductForLiquidation);
	session.setAttribute("viewProductForSelling", viewProductForSelling);
	session.setAttribute("viewProductPromotion", viewProductPromotion);
	session.setAttribute("viewProductForCategory", viewProductForCategory);

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
