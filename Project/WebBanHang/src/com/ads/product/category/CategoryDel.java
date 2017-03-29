package com.ads.product.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.object.*;
import com.*;
import com.library.*;

/**
 * Servlet implementation class CategoryDel
 */
@WebServlet("/category/del")
public class CategoryDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Tim thong tin dang nhap trong phien lam viec
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
        //Lay id de xoa doi tuong
        int id = Utilities.getIntParam(request,"id");

        if(id >0){
            //Tim bo quan ly ket noi
            ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");
            //Tao doi tuong thuc thi chuc nang
            CategoryControl cc = new CategoryControl(cp);
            if (cp != null) {
                getServletContext().setAttribute("cpool", cc.getConnectionPool());
            }
            CategoryObject dCategory = new CategoryObject();

            dCategory.setCategory_id(id);
            boolean result = cc.delCategory(dCategory);
            //Tra lai ket noi
            cc.releaseConnection();

            if(result){
                response.sendRedirect("/WebBanHang/category/view");
            }else{
                response.sendRedirect("/WebBanHang/category/view?err=failed");
            }
        }else{
            response.sendRedirect("/WebBanHang/category/view");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//Clean up resources
    public void destroy() {
    }

}
