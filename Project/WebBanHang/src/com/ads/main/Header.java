package com.ads.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.object.UserObject;

/**
 * Servlet implementation class Header
 */
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType(CONTENT_TYPE);
		// Tim thong tin dang nhap
        UserObject user = (UserObject)request.getSession().getAttribute("userLogined");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        	out.println("<meta charset=\"utf-8\">");
        	out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        	out.println("<title>Quản trị hệ thống</title>");
        	out.println("<link rel=\"stylesheet\" href=\"/WebBanHang/adv/adcss/style.css\">");
        	out.println("<link rel=\"stylesheet\" href=\"/WebBanHang/adv/adcss/bootstrap.min.css\">");
        	out.println("<script src=\"/WebBanHang/adv/adjs/jquery-3.1.1.min.js\"></script>");
	        out.println("<script src=\"/WebBanHang/adv/adjs/common.js\"></script>");
			out.println("<script src=\"/WebBanHang/adv/adjs/bootstrap.min.js\"></script>");
			out.println("<script src=\"/WebBanHang/adv/adjs/popup.js\"></script>");
        out.println("</head>");
        out.println("<body>");
        	out.println("<ul class=\"nav navbar-nav navbar-right\">");
        		out.println("<li class=\"dropdown\">");
        		  	out.println("<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">"+user.getUser_name()+"("+user.getUser_username()+") <span class=\"caret\"></span></a>");
        			  out.println("<ul class=\"dropdown-menu\">");
        			    out.println("<li><a href=\"#\">Thay đổi mật khẩu</a></li>");
        			    out.println("<li class=\"divider\"></li>");
        			    out.println("<li><a href=\"/WebBanHang/user/logout\">Thoát</a></li>");
        			  out.println("</ul>");
        			out.println("</a>");
        		out.println("</li>");
        	out.println("</ul>");
      //Tim tham chi\u1EBFu c\u1EE7a menu ghĂ©p vĂ o
        RequestDispatcher m = request.getRequestDispatcher("/menu");
        if(m!=null){
            m.include(request,response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
