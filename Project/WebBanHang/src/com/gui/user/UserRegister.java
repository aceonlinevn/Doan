package com.gui.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ConnectionPool;
import com.library.Utilities;
import com.object.UserObject;
import com.smssend.SMSsender;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegister() {
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
		response.setContentType(CONTENT_TYPE);
		ServletContext application = getServletConfig().getServletContext();
		ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
		request.setCharacterEncoding("UTF-8");
		// Tao doi tuong thuc thi xuat cau truc HTML
		PrintWriter out = response.getWriter();

		String user_name = request.getParameter("txtCustomerName");
		String user_email = request.getParameter("txtCustomerEmail");
		String user_phonenum = request.getParameter("txtCustomerPhoneNumber");
		String user_address = request.getParameter("txtCustomerAdress");
		String user_note = request.getParameter("txtCustomerNote");
		String user_gender = request.getParameter("rdoGender");
		String user_birthdate = request.getParameter("txtCustomerBirthdate");
		String catchacode = request.getParameter("txtReCaptcha");
		
		//out.print(user_name + " - " +  user_email + " - " + user_phonenum + " - "  + user_address + " - " + user_note + " - " + user_gender + " - " + user_birthdate);
		UserControl uc = new UserControl(cp);
		UserObject uo = new UserObject();
		if (cp == null) {
			application.setAttribute("cpool", uc.getConnectionPool());
		}
		UserObject userLogined = (UserObject) request.getSession().getAttribute("userLogined");
		String catcha = (String) request.getSession().getAttribute("dns_security_code");
		if(catchacode.equalsIgnoreCase(catcha)){
			if (userLogined != null && userLogined.getUser_permission_id() != 0) {
				uo = userLogined;
				uo.setUser_name(user_name);
				uo.setUser_phonenum(user_phonenum);
				uo.setUser_address(user_address);
				uo.setUser_password("");
				uo.setUser_note(user_note);
				if(user_gender == "2"){
					uo.setUser_gender(true);
				}else{
					uo.setUser_gender(false);
				}
				uo.setUser_birthdate(user_birthdate);
				uc.editUser(uo);
	
			} else {
				String user_pass = Utilities.randomString(8);
				String user_prefix = "C";
				int user_permiss = 4;
				uo.setUser_name(user_name);
				uo.setUser_phonenum(user_phonenum);
				uo.setUser_address(user_address);
				uo.setUser_note(user_note);
				uo.setUser_email(user_email);
				uo.setUser_prefix(user_prefix);
				uo.setUser_password(user_pass);
				uo.setUser_permission_id(user_permiss);
				if(user_gender == "2"){
					uo.setUser_gender(true);
				}else{
					uo.setUser_gender(false);
				}
				uo.setUser_birthdate(user_birthdate);
				boolean result;
				result = uc.addUser(uo);
				if (!result) {
					out.println(Utilities.getMessageRedict(
							"Email đã đăng ký vui lòng đăng nhập để mua hàng. Hoặc sử dụng chức năng quên mật khẩu nếu mất mật khẩu.",
							request.getContextPath() + "/frontend/page.jsp?paction=register-account"));
				} else {
					UserObject user = uc.getUserObject(user_email, user_pass);
					request.getSession().setAttribute("userLogined", user);
					out.println(Utilities.getMessageRedict(
							"Cảm ơn bản đã đăng ký là thành viên của HCComputer.com. Mật khẩu đã được gửi đến số điện thoại đăng ký của bạn!",
							request.getContextPath() + "/"));
					if(user_phonenum != null){
					 SMSsender.SmsSender(user_phonenum, "Cam on ban da dang ky la thanh vien HC voi email: "+user_email+", mat khau:"+user_pass+".Vui long dang nhap va doi mat khau !");
					}
				}
				uc.releaseConnection();
			}
		}else{
			out.print(Utilities.getMessageRedict("Sai mã captcha. Vui lòng nhập lại!", request.getContextPath()+"/frontend/page.jsp?paction=register-account"));
		}
	}
}
