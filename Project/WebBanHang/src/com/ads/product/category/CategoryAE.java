package com.ads.product.category;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

import com.*;
import com.ads.product.categorygroup.CategoryGroupControl;
import com.library.*;
import com.object.*;

/**
 * Servlet implementation class CategoryAE
 */
@WebServlet("/category/ae")
public class CategoryAE extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryAE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession section = request.getSession();
        UserObject user = (UserObject) section.getAttribute("userLogined");

        //Kiem tra
        if (user != null) {
            view(request, response);
        } else {
            response.sendRedirect("/WebBanHang/user/login");
        }
	}
	
	//Process the View
    private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        //Tim id de chinh sua neu co
        int id = Utilities.getIntParam(request,"id");
        String Category_name = "";
        boolean Category_enable = true;
        String Category_note = "";
        int Category_Group_id = -1;
        String Category_icon= "";
        String lblSave = "Thêm mới";
        String readonly = "";
        boolean isExisting = false;
        if(id >0){
            ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");            
            CategoryControl cc = new CategoryControl(cp);
            if (cp != null) {
                getServletContext().setAttribute("cpool", cc.getConnectionPool());
            } 
            CategoryObject eCategory = cc.getCategoryObject(id);

            
            if(eCategory !=null){
            	Category_name = eCategory.getCategory_name();
            	Category_enable = eCategory.isCategory_is_enable();
            	Category_icon = eCategory.getCategory_icon();
            	Category_note = eCategory.getCategory_note();
            	Category_Group_id = eCategory.getCategory_group_id();
            	
                lblSave = "Cập nhật";
                readonly = "readonly";
                isExisting = true;
            }

            //Tra lai ket noi
            cc.releaseConnection();
        }
        //Tim tham chieu header
        RequestDispatcher h = request.getRequestDispatcher("/header");
        if (h != null) {
            h.include(request, response);
        }

        out.println("<div class=\"view tblae\">");
        out.println("<form name=\"frmCategory\" action=\"\" method=\"\">");
        out.println("<table class=\"table table-striped table-bordered\">");
        out.println("<tr><th colspan=2>Thông tin sản phẩm</th></tr>");
        out.println("<tr>");
    	out.println("<td class=\"lc\">Tên loại sản phẩm</td>");
    	out.println("<td><input type=\"text\" name=\"txtCategoryName\" value=\""+Category_name+"\" required size=35/></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Icon hiển thị</td>");
    	out.println("<td><textarea rows=2 cols=90 id=\"txtCategoryIcon\" name=\"txtCategoryIcon\">"+Category_icon+"</textarea></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Ẩn/Hiện</td>");
    	out.println("<td>");
    	out.println("<select name=\"slcCategoryEnable\">");
    	out.print(Category_enable);
    	if(!Category_enable){
    		out.println("<option value=\"0\" selected>Ẩn</option>");
    		out.println("<option value=\"1\">Hiện</option>");
    	}else if(Category_enable){
    		out.println("<option value=\"0\">Ẩn</option>");
    		out.println("<option value=\"1\" selected>Hiện</option>");
    	}else {
    		out.println("<option value=\"0\">Ẩn</option>");
    		out.println("<option value=\"1\" selected>Hiện</option>");
		}
    	out.println("</select>");
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Ghi chú</td>");
    	out.println("<td><textarea rows=6 cols=80 id=\"txtNote\" name=\"txtCategoryNote\">"+Category_note+"</textarea></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Thuộc hệ sản phẩm</td>");
    	out.println("<td>");
    	ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");
        CategoryGroupControl cgc = new CategoryGroupControl(cp);
    	if(cp != null){
            getServletContext().setAttribute("cpool",cgc.getConnectionPool());
        } 
    	CategoryGroupObject similar = new CategoryGroupObject();
    	similar.setCategory_group_id(Category_Group_id);
    	String slcCategoryGroup = cgc.slcCategoryGroup(similar);
        cgc.releaseConnection();
    	out.println(slcCategoryGroup);
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td colspan=2 align=\"center\">");
    		out.println("<input class=\"btn btn-default\" type=\"button\" value=\""+lblSave+"\" onClick=\"saveCategory(this.form)\" name=\"btnAdd\"/>");
    		out.println("<input class=\"btn btn-default\" type=\"reset\" value=\"Nhập lại\" name=\"btnReset\"/>");
    		out.println("<a class=\"btn btn-default\" href=\"/WebBanHang/category/view\">Trở về</a>");
    	out.println("</td>");
    out.println("</tr>");
        out.println("</table>");
        if(isExisting){
            out.print("<input type=\"hidden\" name=\"idForPost\" value=\""+id+"\" />");
        }
        out.println("</form>");
        out.println("</div>");
        out.println("<script src=\"/WebBanHang/adv/ckeditor/ckeditor.js\"></script>");
        out.println("<script>");
        out.println("CKEDITOR.replace( 'txtCategoryNote' );");
        out.println("</script>");
        //Tim tham chieu cua footer
        RequestDispatcher f = request.getRequestDispatcher("/footer");
        if (f != null) {
            f.include(request, response);
        }

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int id = Utilities.getIntParam(request, "idForPost");
		String Categoryname = request.getParameter("txtCategoryName");
		boolean categoryenable  = request.getParameter("slcCategoryEnable").equalsIgnoreCase("0") ? false : true;
		String categorynote  = request.getParameter("txtCategoryNote");
		int categorygroupid = Integer.parseInt(request.getParameter("slcCategoryGroup"));
		String category_icon = request.getParameter("txtCategoryIcon");
		
		CategoryObject co = new CategoryObject();
		co.setCategory_name(Categoryname);
		co.setCategory_is_enable(categoryenable);
		co.setCategory_note(categorynote);
		co.setCategory_group_id(categorygroupid);
		co.setCategory_icon(category_icon);
		//Tim bo quan ly
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");
        CategoryControl cc = new CategoryControl(cp);
        if(cp == null){
            getServletContext().setAttribute("cpool",cc.getConnectionPool());
        }
        //Thuc hien
        boolean result;
        if(id >0){
        	co.setCategory_id(id); //dua id vao de cap nhap
            result = cc.editCategory(co);
        }else{
            result = cc.addCategory(co);
        }

        //Tra ve ket noi
        cc.releaseConnection();
        //Kiem tra
        if(result){
            response.sendRedirect("/WebBanHang/category/view");
        }else{
            response.sendRedirect("/WebBanHang/category/ae?err=ae&at=failed");
        }
	}

}
