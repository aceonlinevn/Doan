package com.ads.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionPool;
import com.ads.bill.BillModel;
import com.ads.product.categorygroup.CategoryGroupControl;
import com.object.BillObject;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		HttpSession session = request.getSession();
		UserObject user = (UserObject) session.getAttribute("userLogined");
		// Kiem tra
		if (user != null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/WebBanHang/user/login");
		}

	}

	// Process the HTTP Get request
	private void view(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws ServletException, IOException {

		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		// Tim tham chieu cua header ghep vao
		RequestDispatcher h = request.getRequestDispatcher("/header");
		if (h != null) {
			h.include(request, response);
		}

		out.print("<div class=\"view\">");
		out.print("<div class=\"alert alert-info\" role=\"alert\">Doanh thu HÙNG CƯỜNG COMPUTER trong năm</div>");
		out.println("<canvas id=\"stBill\" height=\"450\" width=\"600\"></canvas>");
		out.print("</div>");
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");
        BillModel bm = new BillModel(cp);
        if(cp != null){
            getServletContext().setAttribute("cpool",bm.getConnectionPool());
        }
        String label = "";
        String data = "";
        BillObject similar = new BillObject();
        ArrayList<BillObject> items = bm.getBillObjectst(similar);
        for(BillObject item : items){
        	label += "'Tháng "+item.getBill_finish_date()+"',";
        	data += item.getBill_total_amount()+",";
        }
		out.println("<script>");
		out.println("var stData = {");
		out.println("labels : ["+label+"],");
		out.println("datasets : [");
		out.println("{");
		out.println("fillColor : \"rgba(172,194,132,0.4)\",");
		out.println("strokeColor : \"#ACC26D\",");
		out.println("pointColor : \"#fff\",");
		out.println("pointStrokeColor : \"#9DB86D\",");
		out.println("data : ["+data+"]");
		out.println("}");
		out.println("]");
		out.println("}");
		out.println("var stBill = document.getElementById('stBill').getContext('2d');");
		out.println("new Chart(stBill).Line(stData);");
		out.println("</script>");
		// Tim tham chieu cua footer
		RequestDispatcher f = request.getRequestDispatcher("/footer");
		if (f != null) {
			f.include(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
