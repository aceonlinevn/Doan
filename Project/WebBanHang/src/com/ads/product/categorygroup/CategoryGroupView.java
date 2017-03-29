package com.ads.product.categorygroup;

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
 * Servlet implementation class CategoryGroupView
 */
@WebServlet("/categorygroup/view")
public class CategoryGroupView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryGroupView() {
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
        CategoryGroupControl cgc = new CategoryGroupControl(cp);
        if(cp != null){
            getServletContext().setAttribute("cpool",cgc.getConnectionPool());
        }
        
        String keyword = (String) request.getSession().getAttribute("key");
        request.getSession().setAttribute("key",null);
        String saveKey = (keyword != null) ? keyword : "";
        CategoryGroupObject similar = new CategoryGroupObject();

        similar.setCategory_group_name(saveKey.trim());
        String viewCategoryGroups = cgc.viewCategoryGroups(similar,1,(byte) 20);
        cgc.releaseConnection();
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
        out.println("<a class=\"btn btn-primary\" href=\"/WebBanHang/categorygroup/ae\"><span class=\"glyphicon glyphicon-plus\"></span> Thêm mới</a>");
        out.println("</td>");
        out.println("<td colspan=11 align=\"right\">");
        out.println("<form class=\"form-inline\" name=\"frmSearch\" action =\"/WebBanHang/categorygroup/view\" method=\"POST\" >");
        out.println("<input type=text name=\"txtKeyword\" class=\"form-control\" size = 30 value=\""+saveKey+"\" />");
        out.println("<input class=\"btn btn-default\" type=submit value=\"Tìm kiếm\" />");
        out.println("</form>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        
        out.println("<tr>");
        out.println("<th>STT</th>");
        out.println("<th>Tên hệ sản phẩm</th>");
        out.println("<th>Ngày tạo</th>");
        out.println("<th>Ẩn/Hiện</th>");
        out.println("<th>Ghi chú</th>");
        out.println("<th colspan=2>Thực Hiện</th>");
        out.println("<th>ID</th>");
        out.println("</tr>");
        out.println(viewCategoryGroups);
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
        response.sendRedirect("/WebBanHang/categorygroup/view");
	}
	
	//Clean up resources
    public void destroy() {
    }

}
