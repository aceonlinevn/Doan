package com.gui.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ConnectionPool;
import com.ads.Collaboration.UserRateModel;
import com.ads.user.UserControl;
import com.ads.user.UserModel;
import com.library.Utilities;
import com.object.*;

/**
 * Servlet implementation class ProductRating
 */
@WebServlet("/ProductRating")
public class ProductRating extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id_now = "";
		// TODO Auto-generated method stub
		ServletContext application = getServletConfig().getServletContext();
		// tim bo quan ly ket noi
		ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
		// cp null ...

		// Tao doi tuong thuc thi chuc nang
		UserRateModel ur = new UserRateModel(cp);
		// vi cp null thi basic se tu tao ra cp moi .
		// Lay lai cp tu ben control.
		if (cp == null) {
			application.setAttribute("cpool", ur.getConnectionPool());
		}
		UserObject userlogined = (UserObject) request.getSession().getAttribute("userLogined");
		Visitor visitorNow = (Visitor) request.getSession().getAttribute("VisitorNow");

		if (userlogined == null && visitorNow == null) {
			UserModel um = new UserModel(cp);
			String nextVisitorID = um.getNextVisitorId();
			Visitor visitor = new Visitor();
			visitor.setVisitor_id(nextVisitorID);
			visitor.setVisitor_prefix("V");
			visitor.setVisitor_created_date(Utilities.getStringDateNow());
			visitor.setVisitor_IP("local");
			if (um.addVisitor(visitor)) {
				request.getSession().setAttribute("VisitorNow", visitor);
			}
		}
		
		if (userlogined != null) {
			user_id_now = userlogined.getUserId();
			request.getSession().setAttribute("user_id_now", user_id_now);
			request.getSession().removeAttribute("VisitorNow");
		} else {
			visitorNow = (Visitor) request.getSession().getAttribute("VisitorNow");
			user_id_now = visitorNow.getVisitor_id();
			request.getSession().setAttribute("user_id_now", user_id_now);
		}
		
		//ratting
		UserRateObject ratting = new UserRateObject();
		String product_id = (String) request.getSession().getAttribute("product_id");
		String user_id = user_id_now;
		String rate = request.getParameter("rdoRate");
		String comment = request.getParameter("comment");

		ratting.setProduct_id(Integer.parseInt(product_id));
		ratting.setUser_id(user_id);
		ratting.setUser_rate_point(Integer.parseInt(rate));
		ratting.setUser_rate_comment(comment);

		ur.addUserRate(ratting);
		 
		// tra lai ket noi cho he thong
		ur.releaseConnection();
		response.sendRedirect(request.getContextPath() + "/frontend/detail.jsp");

	}

}
