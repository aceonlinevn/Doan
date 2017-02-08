package com.ads.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.object.UserObject;

/**
 * Servlet implementation class View
 */
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType(CONTENT_TYPE);
		  HttpSession session = request.getSession();
	        UserObject user = (UserObject) session.getAttribute("userLogined");
	        //Kiem tra
	        if (user != null) {
	            view(request, response,user);
	        } else {
	            response.sendRedirect("/WebBanHang/user/login");
	        }

	}
	//Process the HTTP Get request
    private void view(HttpServletRequest request, HttpServletResponse response, UserObject user) throws ServletException, IOException {

        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        //Tim tham chieu cua header ghep vao
        RequestDispatcher h = request.getRequestDispatcher("/header");
        if(h!=null){
            h.include(request,response);
        }

        out.print("<div class=\"view\">");
        out.print("</div>");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
