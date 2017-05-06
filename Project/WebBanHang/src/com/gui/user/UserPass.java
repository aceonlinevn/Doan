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
 * Servlet implementation class UserPass
 */
@WebServlet("/user/pass")
public class UserPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		ServletContext application = getServletConfig().getServletContext();
		ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		UserObject userLogined = (UserObject) request.getSession().getAttribute("userLogined");
		String txtUserPassNow = request.getParameter("txtUserPassNow");
		String txtUserPassNew = request.getParameter("txtUserPassNew");
		String txtReUserPassNew = request.getParameter("txtReUserPassNew");
		if(userLogined !=null){
			if(!txtUserPassNew.equalsIgnoreCase(txtReUserPassNew)){
				out.println(Utilities.getMessageRedict("Mật khẩu không khớp", "/WebBanHang/frontend/page.jsp?paction=info-account&view=account-change-pass"));
			}else{
				UserControl uc = new UserControl(cp);
				if (cp == null) {
					application.setAttribute("cpool", uc.getConnectionPool());
				}
				UserObject uo = new UserObject();
				uo.setUser_password(txtUserPassNow);
				if(uc.checkPass(uo)){
					uo = userLogined;
					uo.setUser_password(txtUserPassNew);
					uo.setUser_lastlogined(1);
					boolean rs = uc.editUser(uo);
					if(rs){
						//SMSsender.SmsSender(userLogined.getUser_phonenum(), "Ban vua thuc hien thay doi mat khau tai HC. Mat khau moi la: "+txtUserPassNew);
						out.println(Utilities.getMessageRedict("Thay đổi mật khẩu thành công", "/WebBanHang/frontend/page.jsp?paction=info-account"));
					}else{
						out.println(Utilities.getMessageRedict("Thay đổi mật khẩu thất bại", "/WebBanHang/frontend/page.jsp?paction=info-account"));
					}
				}	
			}
		}
	}

}
