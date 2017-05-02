package com.gui.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.object.UserObject;
import com.ConnectionPool;
import com.gui.user.*;
import com.library.Utilities;
/**
 * Servlet implementation class ProductCart
 */
@WebServlet("/product/cart")
public class ProductCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// xac dinh kieu noi dung
		response.setContentType(CONTENT_TYPE);
		ServletContext application = getServletConfig().getServletContext();
		ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
		// Tao doi tuong thuc thi xuat cau truc HTML
		PrintWriter out = response.getWriter();
		String bill_customer_id = "";
		String bill_payments = request.getParameter("txtCustomPay");
		String bill_tranfer = request.getParameter("txtCustomTranfer");
		String bill_note = request.getParameter("txtCustomerNote");
		String bill_Total_Amount = request.getParameter("total_cart_value");
		int bill_status = 0;
		String bill_product_detail = request.getParameter("item_update_quantity");
		UserObject userLogined = (UserObject) request.getAttribute("userLogined");
		if(userLogined != null && userLogined.getUser_permission_id() != 0){
			bill_customer_id = userLogined.getUserId();
		}else{
			String user_name = request.getParameter("txtCustomerName");
			String user_email = request.getParameter("txtCustomerEmail");
			String user_phonenum = request.getParameter("txtCustomerPhoneNumber");
			String user_address = request.getParameter("txtCustomerAdress");
			String user_note = request.getParameter("txtCustomerNote");
			String user_pass = Utilities.randomString(8);
			String user_prefix = "C";
			int user_permiss = 4;
			UserControl uc = new UserControl(cp);
			if (cp == null) {
				application.setAttribute("cpool", uc.getConnectionPool());
			}
			
			UserObject uo = new UserObject();
			uo.setUser_prefix(user_prefix);
			uo.setUser_name(user_name);
			uo.setUser_phonenum(user_phonenum);
			uo.setUser_address(user_address);
			uo.setUser_note(user_note);
			uo.setUser_password(user_pass);
			uo.setUser_permission_id(user_permiss);
			uc.addUser(uo);
		}
		
	}

}
