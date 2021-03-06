package com.ads.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionPool;
import com.object.UserObject;

/**
 * Servlet implementation class UserLogin
 */
// @WebServlet("/User/Login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Tim tham so bao loi neu co
		String error = request.getParameter("err");
		String message = "";
		if (error != null && error.equalsIgnoreCase("login")) {
			String at = request.getParameter("at");
			if (at != null) {
				if (at.equalsIgnoreCase("param")) {
					message = "L\u1ED7i tham s\u1ED1 c\u1EE7a Form. ";
				} else if (at.equalsIgnoreCase("value")) {
					message = "L\u1ED7i giá tr\u1ECB nh\u1EADp vào. ";
				} else if (at.equalsIgnoreCase("username")) {
					message = "Tên \u0111\u0103ng nh\u1EADp có d\u1EA5u cách ";
				} else {
					message = "L\u1ED7i \u0111\u0103ng nh\u1EADp, hãy ki\u1EC3m tra l\u1EA1i.";
				}
			}

		}

		// xac dinh kieu noi dung
		response.setContentType(CONTENT_TYPE);

		// Tao doi tuong thuc thi xuat cau truc HTML
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>\u0110\u0103ng nh\u1EADp</title>");
		out.print("<link href=\"../adv/adcss/login.css\" rel=\"stylesheet\" type=\"text/css\" />");
		out.print("<script language=\"javascript\" src=\"../adv/adjs/login.js\"></script>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"loginview\">");
		out.print("<form name=\"frmLogin\" action=\"\" method=\"\">");
		out.print("<table cellspacing=0>");

		if (error != null && !message.equalsIgnoreCase("")) {
			out.print("<tr><td colspan=2 align=center>");
			out.print("<h1 style=\"color:red;\"> " + message + "</h1>");
			out.print("</tr></td>");
		}
		out.print("<tr>");
		out.print(
				"<th colspan=2>\u0110\u0103ng nh\u1EADp</th>      <!--Tiêu \u0111\u1EC1 c\u1EE7a b\u1EA3ng là th-table heading-->");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td class=\"lc\">Tên \u0111\u0103ng nh\u1EADp</td>	<!-- td-table data -->");
		out.print("<td><input type=\"text\" name=\"txtUserName\" /></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td class=\"lc\">M\u1EADt kh\u1EA9u</td>	<!-- td-table data -->");
		out.print("<td><input type=\"password\" name=\"txtUserPass\"  onkeydown = \"if (event.keyCode == 13) document.getElementById('btnLogin').click()\"/></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td class=\"lc\">");
		out.print("<input type=\"checkbox\" id=\"chkSave\" name=\"chkSave\" />");
		out.print("</td>	");
		out.print("<td>");
		out.print("<label for=\"chkSave\">                     <!--G\u1EAFn nhãn cho check box-->");
		out.print(
				"B\u1EA1n có l\u01B0u thông tin \u0111\u0103ng nh\u1EADp?			<!--khi nh\u1EA5n vào ch\u1EEF s\u1EBD check vào ô-->");
		out.print("</label>");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td colspan=2 align=\"center\">");
		out.print("<input type=\"button\" id = \"btnLogin\" value=\"\u0110\u0103ng nh\u1EADp\" onClick=\"login(this.form)\" />");
		out.print("<input type=\"button\" value=\"Thoát\" onClick=\"window.close()\" />");
		out.print("</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td colspan=2 align=\"right\">");
		out.print("<a href=\"#\">English</a>");
		out.print("</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</form>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");

		// Donng luong xuat
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		// Lay thong tin tren giao dien
		String username = request.getParameter("txtUserName");
		String userpass = request.getParameter("txtUserPass");
		String useremail = request.getParameter("txtUserEmail");

		// Kiem tra su ton tai cua tham so
		if (username != null && userpass != null) {
			// Xu ly khoang trong
			username = username.trim();
			userpass = userpass.trim();
			if (!username.equalsIgnoreCase("") && !userpass.equalsIgnoreCase("")) {
				if (username.indexOf(" ") != -1) {
					response.sendRedirect("/WebBanHang/user/login?err=login&at=username");
				} else {
					// Tham chieu ngu canh ung dung cua Serlvet
					ServletContext application = getServletConfig().getServletContext();

					// tim bo quan ly ket noi
					ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
					// cp null ...

					// Tao doi tuong thuc thi chuc nang
					UserControl uc = new UserControl(cp);
					// vi cp null thi basic se tu tao ra cp moi .
					// Lay lai cp tu ben control.
					if (cp == null) {
						application.setAttribute("cpool", uc.getConnectionPool());
					}

					// Thuc hien dang nhap
					UserObject user = uc.getUserObject(username, userpass);

					// tra lai ket noi cho he thong
					uc.releaseConnection();

					// Kiem tra ket qua
					if (user != null) {
						// Tao phien lam viec
						// getSession():
						// ko tham so: Neu co session roi thi dung tiep, neu ko
						// co session thi thoi.
						// true: da co session: tao moi. chua co: tao moi.
						// false: da co session: huy session. ko co session: ko
						// lam gi
						request.getSession().removeAttribute("VisitorNow");
						request.getSession().setAttribute("user_id_now", user.getUserId());
						HttpSession session = request.getSession(true);
						if (user.getUser_permission_id() <= 3) {
							// Dua thong tin dang nhap vao phien
							session.setAttribute("userLogined", user);

							// Chuyen ve giao dien chinh
							response.sendRedirect("/WebBanHang/view");
						} else {
							// Dua thong tin dang nhap vao phien
							session.setAttribute("userLogined", user);
							response.sendRedirect(request.getContextPath());
						}

					} else {
						out.println("<script>");
						out.println("alert('Sai tên đăng nhập hoặc mật khẩu. Vui lòng thử lại');");
						out.println("window.location = '/WebBanHang';");
						out.println("</script>");
					}
				}

			} else {
				response.sendRedirect("/WebBanHang/user/login?err=login&at=value");
			}
		} else {
			// Goi lai doGet va truyen tham so bao loi
			response.sendRedirect("/WebBanHang/user/login?err=login&at=param");

		}
	}

}