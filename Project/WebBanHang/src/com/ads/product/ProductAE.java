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
import com.ads.product.category.*;
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
        int product_category_id = 1,product_price_discount=1,product_warranty_time=1,product_provider_id=1,product_visited=1,product_quantity =1;
        double product_origin_price = 1,product_price2=1,product_price3=1;
        String product_specification ="", product_note = "",product_image= "";
        String lblSave = "Thêm mới";
        String readonly = "";
        boolean isExisting = false;
        String loadImg = "<img src=\"/WebBanHang/adv/adimg/uploadimg.png\" height=\"120\" width=\"120\" alt=\"Chọn ảnh upload\" id=\"thumbimage\" />"; 
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
                loadImg = "<img src=\""+product_image+"\" id=\"thumbimage\" alt=\""+product_name+"\" width=\"120px\" height=\"120px\" />"; 
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
        out.println("<form name=\"frmProduct\" action=\"\" method=\"\">");
        out.println("<table class=\"table table-striped table-bordered\">");
        out.println("<tr><th colspan=2>Thông tin sản phẩm</th></tr>");
        out.println("<tr>");
    	out.println("<td class=\"lc\">Tên sản phẩm</td>");
    	out.println("<td><input type=\"text\" value=\""+product_name+"\" name=\"txtProductName\" size=35 /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Ảnh đại diện</td>");
    	out.println("<td>"
    			+ "<span id=\"thumbbox\">"+loadImg+"<a class=\"removeimg\" href=\"javascript:\" ><span class=\"glyphicon glyphicon-remove\"></span></a></span>"
    			+ "<input style=\"margin-top: 10px;\" onchange=\"loadImg(this)\" type=\"file\" name=\"txtProductImage\" size=35 />"
    			+ ""
    			+ "</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Tình trạng</td>");
    	out.println("<td>");
    	out.println("<select name=\"slcProductStatus\">");
    	if(product_status){
	    	out.println("<option value=\"0\" selected>Còn hàng</option>");
	    	out.println("<option value=\"1\">Hết hàng</option>");
    	}else if(!product_status){
    		out.println("<option value=\"0\">Còn hàng</option>");
	    	out.println("<option value=\"1\" selected>Hết hàng</option>");
    	}
    	else{
    		out.println("<option value=\"0\" selected>Còn hàng</option>");
	    	out.println("<option value=\"1\">Hết hàng</option>");
    	}
    	out.println("<option value=\"2\">-------</option>");
    	out.println("</select>");
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Thuộc loại sản phẩm</td>");
    	out.println("<td>");
    	ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");
    	CategoryControl cc = new CategoryControl(cp);
    	if(cp != null){
            getServletContext().setAttribute("cpool",cc.getConnectionPool());
        } 
    	CategoryObject similar = new CategoryObject();
    	similar.setCategory_id(product_category_id);
    	String slcCategory = cc.slcCategory(similar);
        cc.releaseConnection();
    	out.println(slcCategory);
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Số lượng</td>");
    	out.println("<td><input type=\"number\" min=\"0\" name=\"txtProductQuantity\" value=\""+product_quantity+"\" size=20 /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Giá gốc</td>");
    	out.println("<td><input type=\"number\" name=\"txtProductOriginPrice\" value=\""+product_origin_price+"\" size=35 /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Khuyến mại</td>");
    	out.println("<td><input type=\"number\" name=\"txtProductDiscount\" value=\""+product_price_discount+"\" size=10 /><span style=\"color:red\"><b>%</b></span></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Bảo hành</td>");
    	out.println("<td><input type=\"number\" name=\"txtProductWarrantyTime\" value=\""+product_warranty_time+"\" size=20 /></td>");
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
    	out.println("<td><textarea rows=10 cols=80 id=\"txtProductSpecification\" name=\"txtProductSpecification\">"+product_specification+"</textarea></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Ghi chú</td>");
    	out.println("<td><textarea rows=6 cols=80 id=\"txtProductNote\" name=\"txtProductNote\">"+product_note+"</textarea></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td colspan=2 align=\"center\">");
    		out.println("<input class=\"btn btn-default\" type=\"button\" value=\""+lblSave+"\" onclick=\"saveProduct(this.form)\" name=\"btnAdd\"/>");
    		out.println("<input class=\"btn btn-default\" type=\"reset\" value=\"Nhập lại\" name=\"btnReset\"/>");
    		out.println("<a class=\"btn btn-default\" href=\"/WebBanHang/product/view\">Trở về</a>");
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
        out.println("CKEDITOR.replace( 'txtProductSpecification' );");
        out.println("CKEDITOR.replace( 'txtProductNote' );");
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
		
		String productname = request.getParameter("txtProductName");
		String productimage = "/WebBanHang/upload/productimg/"+request.getParameter("txtProductImage");
		boolean productstatus = request.getParameter("slcProductStatus").equalsIgnoreCase("0") ? false : true;
		int productcategory = Integer.parseInt(request.getParameter("slcCategory"));
		int productquantity = Integer.parseInt(request.getParameter("txtProductQuantity"));
		double productoriginprice = Double.parseDouble(request.getParameter("txtProductOriginPrice"));
		int productdiscount = Integer.parseInt(request.getParameter("txtProductDiscount"));
		int productwarrantytime = Integer.parseInt(request.getParameter("txtProductWarrantyTime"));
		int productprovider = Integer.parseInt(request.getParameter("slcProvider"));
		String productproductspecification = request.getParameter("txtProductSpecification");
		String productnote = request.getParameter("txtProductNote");
		
		ProductObject po = new ProductObject();
		po.setProduct_name(productname);
		po.setProduct_image(productimage);
		po.setProduct_status(productstatus);
		po.setProduct_category_id(productcategory);
		po.setProduct_quantity(productquantity);
		po.setProduct_origin_price(productoriginprice);
		po.setProduct_price_discount(productdiscount);
		po.setProduct_warranty_time(productwarrantytime);
		po.setProduct_provider_id(productprovider);
		po.setProduct_specification(productproductspecification);
		po.setProduct_note(productnote);
		
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");
        ProductControl pc = new ProductControl(cp);
        if(cp == null){
            getServletContext().setAttribute("cpool",pc.getConnectionPool());
        }
        //Thuc hien
        boolean result;
        if(id >0){
        	po.setProduct_id(id); //dua id vao de cap nhap
            result = pc.editProduct(po);
        }else{
            result = pc.addProduct(po);
        }

        //Tra ve ket noi
        pc.releaseConnection();
        //Kiem tra
        if(result){
            response.sendRedirect("/WebBanHang/product/view");
        }else{
            response.sendRedirect("/WebBanHang/product/ae?err=ae&at=failed");
        }

	}

}