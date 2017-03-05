package com.ads.product;

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
 * Servlet implementation class ProductAE
 */
@WebServlet("/product/ae")
public class ProductAE extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAE() {
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
        String product_name = "";
        boolean product_status = true;
        int product_category_id = 1,product_price_discount=1,product_warranty_time=12,product_provider_id=1,product_visited=1;
        double product_quantity =1,product_origin_price = 1,product_price2=1,product_price3=1;
        String product_specification ="", product_note = "",product_image= "";
        String lblSave = "Thêm mới";
        String readonly = "";
        boolean isExisting = false;
        if(id >0){
            ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");            
            ProductControl pc = new ProductControl(cp);
            if (cp != null) {
                getServletContext().setAttribute("cpool", pc.getConnectionPool());
            } 
            ProductObject eProduct = pc.getProductObject(id);

            
            if(eProduct !=null){
            	product_name = eProduct.getProduct_name();
            	product_status = eProduct.isProduct_status();
            	product_category_id = eProduct.getProduct_category_id();
            	product_price_discount = eProduct.getProduct_price_discount();
            	product_warranty_time = eProduct.getProduct_warranty_time();
            	product_provider_id = eProduct.getProduct_provider_id();
            	product_visited = eProduct.getProduct_visited();
            	product_quantity = eProduct.getProduct_quantity();
            	product_origin_price = eProduct.getProduct_origin_price();
            	product_price2 = eProduct.getProduct_price2();
            	product_price3 = eProduct.getProduct_price3();
            	product_specification = eProduct.getProduct_specification();
            	product_note = eProduct.getProduct_note();
            	product_image = eProduct.getProduct_image();
            	
                lblSave = "Cập nhật";
                readonly = "readonly";
                isExisting = true;
            }

            //Tra lai ket noi
            pc.releaseConnection();
        }
        //Tim tham chieu header
        RequestDispatcher h = request.getRequestDispatcher("/header");
        if (h != null) {
            h.include(request, response);
        }

        out.println("<div class=\"view tblae\">");
        out.println("<table class=\"table table-striped table-bordered\">");
        out.println("<tr><th colspan=2>Thông tin sản phẩm</th></tr>");
        out.println("<tr>");
    	out.println("<td class=\"lc\">Tên sản phẩm</td>");
    	out.println("<td><input type=\"text\" name=\"txtProductName\" size=35/></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Tình trạng</td>");
    	out.println("<td>");
    	out.println("<select name=\"slcStatus\">");
    	out.println("<option value=\"0\">Còn hàng</option>");
    	out.println("<option value=\"1\">Hết hàng</option>");
    	out.println("<option value=\"2\" selected>-------</option>");
    	out.println("</select>");
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Danh mục</td>");
    	out.println("<td>");
    	out.println("<select name=\"slcCategory\">");
    	out.println("<option value=\"0\">Laptop, Phụ kiện</option>");
    	out.println("<option value=\"1\">Pc, WorkStations</option>");
    	out.println("<option value=\"2\" selected>-------</option>");
    	out.println("</select>");
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Số lượng</td>");
    	out.println("<td><input type=\"number\" name=\"txtQuantity\" size=20/></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Giá gốc</td>");
    	out.println("<td><input type=\"text\" name=\"txtOriginPrice\" size=35/></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Khuyến mại</td>");
    	out.println("<td><input type=\"number\" name=\"txtDiscount\" size=20/></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Bảo hành</td>");
    	out.println("<td><input type=\"number\" name=\"txtDiscount\" size=20/></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Nhà cung cấp</td>");
    	out.println("<td>");
    	out.println("<select name=\"slcProvider\">");
    	out.println("<option value=\"0\">SamSung</option>");
    	out.println("<option value=\"1\">Apple</option>");
    	out.println("<option value=\"2\" selected>-------</option>");
    	out.println("</select>");
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Thông số kĩ thuật</td>");
    	out.println("<td><textarea rows=10 cols=80 name=\"txtSpecification\"></textarea></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Ghi chú</td>");
    	out.println("<td><textarea rows=6 cols=80 name=\"txtNote\"></textarea></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td colspan=2 align=\"center\">");
    		out.println("<input class=\"btn btn-default\" type=\"button\" value=\""+lblSave+"\" name=\"btnAdd\"/>");
    		out.println("<input class=\"btn btn-default\" type=\"reset\" value=\"Nhập lại\" name=\"btnReset\"/>");
    		out.println("<a class=\"btn btn-default\" href=\"/WebBanHang/product/view\">Trở về</a>");
    	out.println("</td>");
    out.println("</tr>");
        out.println("</table>");
        out.println("</div>");

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
