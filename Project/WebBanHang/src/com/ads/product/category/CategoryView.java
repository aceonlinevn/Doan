package com.ads.product.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.*;
import com.object.*;
import com.*;
import com.library.Utilities;

/**
 * Servlet implementation class CategoryView
 */
@WebServlet("/category/view")
public class CategoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession section = request.getSession();
        UserObject user = (UserObject) section.getAttribute("userLogined");

        //Kiem tra
        if (user != null) {
            view(request, response,user);
        } else {
            response.sendRedirect("/WebBanHang/user/login");
        }
	}
	//Process the View
    private void view(HttpServletRequest request, HttpServletResponse response,UserObject user) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");
        CategoryControl cc = new CategoryControl(cp);
        if(cp != null){
            getServletContext().setAttribute("cpool",cc.getConnectionPool());
        }
        
        String keyword = (String) request.getSession().getAttribute("key");
        request.getSession().setAttribute("key",null);
        String saveKey = (keyword != null) ? keyword : "";
        CategoryObject similar = new CategoryObject();

        similar.setCategory_name(saveKey.trim());
        String viewCategories = cc.viewCategories(similar,1,(byte) 20);
        cc.releaseConnection();
        RequestDispatcher h = request.getRequestDispatcher("/header");
        if(h!=null){
            h.include(request,response);
        }
        
        String message = (String) request.getSession().getAttribute("err");
        String err = "";
        request.getSession().setAttribute("err", null);
        if(message != null) {
        	if(message.equalsIgnoreCase("failed")){
        		err = "Thất bại";
        	}
        	Utilities.getMessage(err);
        }
        out.println("<div class=\"view\">");
        out.println("<table class=\"table table-striped table-bordered\">");
        
        out.println("<tr>");
        out.println("<td colspan=2>");
        out.println("<a class=\"btn btn-primary\" href=\"/WebBanHang/category/ae\"><span class=\"glyphicon glyphicon-plus\"></span> Thêm mới</a>");
        out.println("</td>");
        out.println("<td colspan=11 align=\"right\">");
        out.println("<form class=\"form-inline\" name=\"frmSearch\" action =\"/WebBanHang/category/view\" method=\"POST\" >");
        out.println("<input type=text name=\"txtKeyword\" class=\"form-control\" size = 30 value=\""+saveKey+"\" />");
        out.println("<input class=\"btn btn-default\" type=submit value=\"Tìm kiếm\" />");
        out.println("</form>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        
        out.println("<tr>");
        out.println("<th>STT</th>");
        out.println("<th>Tên loại sản phẩm</th>");
        out.println("<th>Ngày tạo</th>");
        out.println("<th>Ẩn/Hiện</th>");
        out.println("<th>Ghi chú</th>");
        out.println("<th>Thuộc hệ sản phẩm</th>");
        out.println("<th colspan=2>Thực Hiện</th>");
        out.println("<th>ID</th>");
        out.println("</tr>");
        out.println(viewCategories);
        out.println("</table>");
        out.println("</div>");
        //Tim tham chieu cua footer
        RequestDispatcher f = request.getRequestDispatcher("/footer");
        if(f!=null){
            f.include(request,response);
        }

    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Lay thong tin tu khoa tim kiem
        String keyword = request.getParameter("txtKeyword");
        //Dua vao phien lam viec
        request.getSession().setAttribute("key",keyword);
        //tro ve giao dien t\u00ECm kiem va hien thi danh sach
        response.sendRedirect("/WebBanHang/category/view");
	}
	
	//Clean up resources
    public void destroy() {
    }

}
