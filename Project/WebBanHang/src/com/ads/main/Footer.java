package com.ads.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Footer
 */
public class Footer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Footer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType(CONTENT_TYPE);
		  response.setContentType(CONTENT_TYPE);
	        PrintWriter out = response.getWriter();
			out.println("<script src=\"/WebBanHang/adv/adjs/jquery-3.1.1.min.js\"></script>");
	        out.println("<script src=\"/WebBanHang/adv/adjs/common.js\"></script>");
			out.println("<script src=\"/WebBanHang/adv/adjs/bootstrap.min.js\"></script>");
		  out.print(" </body>");
		  out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
