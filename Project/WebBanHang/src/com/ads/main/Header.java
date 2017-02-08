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
        out.print("<html>");
        out.print(" <head>");
        out.print("  <title> Quản trị hệ thống </title>");
        out.print("  <link href =\"./adv/adcss/layout.css\" rel=\"stylesheet\" type = \"text/css\"/>");
        out.print("  <script language=\"JavaScript\" src=\"./adv/adjs/jquery-3.1.1.min.js\"></script>");
        out.print("  <script language=\"JavaScript\" src=\"./adv/adjs/layout.js\"></script>");
        out.print(" </head>");
        out.print(" <body>");
        out.print("  <div class=\"main\">");
        out.print("   <div class=\"logo\">");
        out.print("   </div>");
        out.print("   <div class=\"acc\">");
        out.print("    <h3> Quyền quản trị </h3>");
        out.print("    Tên đăng nhập");
        out.print("    <a href=\"#\">admin(Nguyễn Hùng Cường)</a>&nbsp;&nbsp;|&nbsp;&nbsp;");
        out.print("    <a href=\"#\">Thay đổi mật khẩu</a>&nbsp;&nbsp;|&nbsp;&nbsp;");
        out.print("    <a href=\"#\">Thoát</a>");
        out.print("   </div>");
        out.print("   <div class=\"clr\"></div>");
      //Tim tham chi\u1EBFu c\u1EE7a menu ghép vào
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
