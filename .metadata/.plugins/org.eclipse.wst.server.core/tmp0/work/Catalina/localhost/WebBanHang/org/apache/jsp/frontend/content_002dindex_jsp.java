/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.33
 * Generated at: 2017-04-26 17:56:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.frontend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class content_002dindex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
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
      out.write("<div class=\"tp-main-content\">\r\n");
      out.write("\t\t\t\t\t<script src=\"");
      out.print(request.getContextPath());
      out.write("/frontend/js/jquery-ui.js\"></script>\r\n");
      out.write("\t\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t  $( function() {\r\n");
      out.write("\t\t\t\t\t    $( \"#tabs\" ).tabs();\r\n");
      out.write("\t\t\t\t\t  } );\r\n");
      out.write("\t\t\t\t  \t</script>\r\n");
      out.write("\t\t\t\t\t<div id=\"tabs\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t    <li><a href=\"#products-sale-tab\">Sản phẩm khuyến mại</a></li>\r\n");
      out.write("\t\t\t\t\t\t    <li><a href=\"#products-selling-tab\">Sản phẩm bán chạy</a></li>\r\n");
      out.write("\t\t\t\t\t\t    <li><a href=\"#products-new-tab\">Sản phẩm mới</a></li>\r\n");
      out.write("\t\t\t\t\t\t    <li><a href=\"#products-liquidation-tab\">Sản phẩm thanh lý</a></li>\r\n");
      out.write("\t\t\t\t\t  \t</ul>\r\n");
      out.write("\t\t\t\t\t  \t<div id=\"products-sale-tab\">\r\n");
      out.write("\t\t\t\t\t  \t\t");

					  			String viewProductPromotion = (String) session.getAttribute("viewProductPromotion");
					  			if (viewProductPromotion != null) {
					  				out.print(viewProductPromotion);
					  			}else{
					  				out.print("<p>Sản phẩm đang update...</p>");
					  			}
					  		
      out.write("\r\n");
      out.write("\t\t\t\t\t  \t</div>\r\n");
      out.write("\t\t\t\t\t  \t<div id=\"products-selling-tab\">\r\n");
      out.write("\t\t\t\t\t  \t\t");

					  			String viewProductForSelling = (String) session.getAttribute("viewProductForSelling");
					  			if (viewProductForSelling != null) {
					  				out.print(viewProductForSelling);
					  			}else{
					  				out.print("<p>Sản phẩm đang update...</p>");
					  			}
					  		
      out.write("\r\n");
      out.write("\t\t\t\t\t  \t</div>\r\n");
      out.write("\t\t\t\t\t  \t<div id=\"products-new-tab\">\r\n");
      out.write("\t\t\t\t\t  \t\t");

					  			String viewProductForNew = (String) session.getAttribute("viewProductForNew");
					  			if (viewProductForNew != null) {
					  				out.print(viewProductForNew);
					  			}else{
					  				out.print("<p>Sản phẩm đang update...</p>");
					  			}
					  		
      out.write("\r\n");
      out.write("\t\t\t\t\t  \t</div>\r\n");
      out.write("\t\t\t\t\t  \t<div id=\"products-liquidation-tab\">\r\n");
      out.write("\t\t\t\t\t  \t\t");

					  			String viewProductForLiquidation = (String) session.getAttribute("viewProductForLiquidation");
					  			if (viewProductForLiquidation != null) {
					  				out.print(viewProductForLiquidation);
					  			}else{
					  				out.print("<p>Sản phẩm đang update...</p>");
					  			}
					  		
      out.write("\r\n");
      out.write("\t\t\t\t\t  \t</div>\r\n");
      out.write("\t\t\t\t\t</div><!-- end tabs-->\r\n");
      out.write("\t\t\t\t\t<div class=\"news-area\"></div><!-- end news-area-->\r\n");
      out.write("\t\t\t\t</div><!-- end tp-main-content-->\r\n");
      out.write("\t\t\t\t<div class=\"clr\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"bt-main-content\">\r\n");
      out.write("\t\t\t\t\t\t\t");

					  			String viewProductForCategory = (String) session.getAttribute("viewProductForCategory");
					  			if (viewProductForCategory != null) {
					  				out.print(viewProductForCategory);
					  			}else{
					  				out.print("<p>Sản phẩm đang update...</p>");
					  			}
					  		
      out.write("\r\n");
      out.write("\t\t\t\t</div><!-- end bt-main-content-->");
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
