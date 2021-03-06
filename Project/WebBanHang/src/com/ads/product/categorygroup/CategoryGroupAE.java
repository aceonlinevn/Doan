package com.ads.product.categorygroup;

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
import com.library.*;
import com.object.*;

/**
 * Servlet implementation class CategoryGroupAE
 */
@WebServlet("/categorygroup/ae")
public class CategoryGroupAE extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryGroupAE() {
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
        String CategoryGroup_name = "";
        boolean CategoryGroup_enable = true;
        String CategoryGroup_note = "";
        String lblSave = "Thêm mới";
        String readonly = "";
        boolean isExisting = false;
        if(id >0){
            ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");            
            CategoryGroupControl cgc = new CategoryGroupControl(cp);
            if (cp != null) {
                getServletContext().setAttribute("cpool", cgc.getConnectionPool());
            } 
            CategoryGroupObject eCategoryGroup = cgc.getCategoryGroupObject(id);

            
            if(eCategoryGroup !=null){
            	CategoryGroup_name = eCategoryGroup.getCategory_group_name();
            	CategoryGroup_enable = eCategoryGroup.isCategory_group_is_enable();
            	CategoryGroup_note = eCategoryGroup.getCategory_group_note();
            	
                lblSave = "Cập nhật";
                readonly = "readonly";
                isExisting = true;
            }

            //Tra lai ket noi
            cgc.releaseConnection();
        }
        //Tim tham chieu header
        RequestDispatcher h = request.getRequestDispatcher("/header");
        if (h != null) {
            h.include(request, response);
        }

        out.println("<div class=\"view tblae\">");
        out.println("<form name=\"frmCategoryGroup\" action=\"\" method=\"\">");
        out.println("<table class=\"table table-striped table-bordered\">");
        out.println("<tr><th colspan=2>Thông tin sản phẩm</th></tr>");
        out.println("<tr>");
    	out.println("<td class=\"lc\">Tên hệ sản phẩm</td>");
    	out.println("<td><input type=\"text\" name=\"txtCategoryGroupName\" value=\""+CategoryGroup_name+"\" required size=35/></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Ẩn/Hiện</td>");
    	out.println("<td>");
    	out.println("<select name=\"slcCategoryGroupEnable\">");
    	if(!CategoryGroup_enable){
    		out.println("<option value=\"0\" selected>Ẩn</option>");
    		out.println("<option value=\"1\">Hiện</option>");
    	}else if(CategoryGroup_enable){
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
    	out.println("<td><textarea rows=6 cols=80 id=\"txtNote\" name=\"txtCategoryGroupNote\">"+CategoryGroup_note+"</textarea></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td colspan=2 align=\"center\">");
    		out.println("<input class=\"btn btn-default\" type=\"button\" value=\""+lblSave+"\" onClick=\"saveCategoryGroup(this.form)\" name=\"btnAdd\"/>");
    		out.println("<input class=\"btn btn-default\" type=\"reset\" value=\"Nhập lại\" name=\"btnReset\"/>");
    		out.println("<a class=\"btn btn-default\" href=\"/WebBanHang/categorygroup/view\">Trở về</a>");
    	out.println("</td>");
    out.println("</tr>");
        out.println("</table>");
        if(isExisting){
            out.print("<input type=\"hidden\" name=\"idForPost\" value=\""+id+"\" />");
        }
        out.println("</form>");
        out.println("</div>");
        out.println("<script src=\"/WebBanHang/adv/adjs/categorygroup.js\"></script>");
        out.println("<script src=\"/WebBanHang/adv/ckeditor/ckeditor.js\"></script>");
        out.println("<script>");
        out.println("CKEDITOR.replace( 'txtCategoryGroupNote' );");
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
		String categorygroupname = request.getParameter("txtCategoryGroupName");
		boolean categoryenable  = request.getParameter("slcCategoryGroupEnable").equalsIgnoreCase("0") ? false : true;
		String categorynote  = request.getParameter("txtCategoryGroupNote");
		
		CategoryGroupObject cgo = new CategoryGroupObject();
		cgo.setCategory_group_name(categorygroupname);
		cgo.setCategory_group_is_enable(categoryenable);
		cgo.setCategory_group_note(categorynote);
		
		
		//Tim bo quan ly
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");
        CategoryGroupControl cc = new CategoryGroupControl(cp);
        if(cp == null){
            getServletContext().setAttribute("cpool",cc.getConnectionPool());
        }
        //Thuc hien
        boolean result;
        if(id >0){
        	cgo.setCategory_group_id(id); //dua id vao de cap nhap
            result = cc.editCategoryGroup(cgo);
        }else{
            result = cc.addCategoryGroup(cgo);
        }

        //Tra ve ket noi
        cc.releaseConnection();
        //Kiem tra
        if(result){
            response.sendRedirect("/WebBanHang/categorygroup/view");
        }else{
            response.sendRedirect("/WebBanHang/categorygroup/ae?err=ae&at=failed");
        }
	}

}
