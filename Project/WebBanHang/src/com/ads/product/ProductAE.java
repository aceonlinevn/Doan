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
import com.ads.autodata.GetData;
import com.ads.autodata.GetDataImpl;
import com.ads.images.ImagesControl;
import com.ads.product.category.*;
import com.ads.provider.*;
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
        String action = "";
        String url ="";
        if(request.getParameter("action") != null){
        	action = request.getParameter("action");
        }
        if(request.getParameter("url") != null){
        	url = request.getParameter("url");
        } 
        String product_image_url = "";
        String product_name = "",product_summary = "";
        boolean product_status = true,product_isnew = true,product_liqi = true,product_selling = true;
        int product_category_id = 1,product_price_discount=1,product_warranty_time=1,product_provider_id=1,product_visited=1,product_quantity =1;
        double product_price2=1,product_price3=1;
        int product_origin_price = 1;
        String product_specification ="", product_note = "",product_image= "",product_promotion ="",product_prefix="";
        String lblSave = "Thêm mới";
        String readonly = "",checked1="",checked2="",checked3="";
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
            	product_summary = eProduct.getProduct_summary();
            	product_promotion = eProduct.getProduct_promotion();
            	product_status = eProduct.isProduct_status();
            	product_isnew = eProduct.isProduct_isnew();
            	product_liqi = eProduct.isProduct_isliquidation();
            	product_selling = eProduct.isProduct_isselling();
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
            	product_prefix = eProduct.getProduct_prefix();
            	if(product_isnew){
            		checked1 = "checked";
            	}else{
            		checked1 = "";
            	}
            	if(product_liqi){
            		checked2 = "checked";
            	}else{
            		checked2 = "";
            	}
            	if(product_selling){
            		checked3 = "checked";
            	}else{
            		checked3 = "";
            	}
                lblSave = "Cập nhật";
                readonly = "readonly";
                isExisting = true;
                loadImg = "<img src=\""+product_image+"\" id=\"thumbimage\" alt=\""+product_name+"\" width=\"150px\" height=\"120px\" />"; 
            }

            //Tra lai ket noi
            pc.releaseConnection();
        }
        
        if(action.equalsIgnoreCase("getdata") && !url.equalsIgnoreCase("")){
        	GetData gd = new GetDataImpl();
            ProductObject eProduct = gd.getData(url);
            product_name = eProduct.getProduct_name();
        	product_summary = eProduct.getProduct_summary();
        	product_promotion = eProduct.getProduct_promotion();
        	product_status = eProduct.isProduct_status();
        	product_isnew = eProduct.isProduct_isnew();
        	product_liqi = eProduct.isProduct_isliquidation();
        	product_selling = eProduct.isProduct_isselling();
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
        	product_prefix = eProduct.getProduct_prefix();
        	if(product_isnew){
        		checked1 = "checked";
        	}else{
        		checked1 = "";
        	}
        	if(product_liqi){
        		checked2 = "checked";
        	}else{
        		checked2 = "";
        	}
        	if(product_selling){
        		checked3 = "checked";
        	}else{
        		checked3 = "";
        	}
        	loadImg = "<img src=\""+product_image+"\" id=\"thumbimage\" alt=\""+product_name+"\" width=\"150px\" height=\"120px\" />"; 
        }else
        if( request.getParameter("product_image_url") != null)
        {
        	product_image_url = request.getParameter("product_image_url");
        	loadImg = "<img src=\""+product_image_url+"\" id=\"thumbimage\" alt=\""+product_image_url+"\" width=\"150px\" height=\"120px\" />";
        	product_image = product_image_url;
        }
        //Tim tham chieu header
        RequestDispatcher h = request.getRequestDispatcher("/header");
        if (h != null) {
            h.include(request, response);
        }

        out.println("<div class=\"view tblae\">");
        out.println("<form name=\"frmProduct\" action=\"\" method=\"\">");
        out.println("<table class=\"table table-striped table-bordered\">");
        out.println("<tr><th>Thông tin sản phẩm</th>");
        out.println("<th><button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#addFastProduct\">Thêm nhanh sản phẩm</button></th>");
        out.println("</tr>");
        out.println("<tr>");
    	out.println("<td class=\"lc\">Mã sản phẩm</td>");
    	out.println("<td><input type=\"text\" required=\"required\" maxlength=\"20\" id=\"txtProductPrefix\" value=\""+product_prefix+"\" name=\"txtProductPrefix\" size=35 /></td>");
    	out.println("</tr>");
        out.println("<tr>");
    	out.println("<td class=\"lc\">Tên sản phẩm</td>");
    	out.println("<td><input type=\"text\" required=\"required\" id=\"txtProductName\" value=\""+product_name+"\" name=\"txtProductName\" size=35 /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Ảnh đại diện</td>");
    	out.println("<td>"
    			+ "<span id=\"thumbbox\">"+loadImg+"<a class=\"removeimg\" href=\"javascript: removeImg()\" ><span class=\"glyphicon glyphicon-remove\"></span></a></span>"
    			+ "<input style=\"margin-top: 10px;\" onchange=\"loadImg(this.value)\" value=\""+product_image+"\" type=\"text\" id=\"loadimg\" name=\"txtProductImage\" size=35 />"
    			+ "<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#popImageManager\">Chọn ảnh</button>"
    			+ "</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Tóm tắt sản phẩm</td>");
    	out.println("<td><textarea rows=6 cols=80 id=\"txtProductSummary\" name=\"txtProductSummary\">"+product_summary+"</textarea></td>");
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
    	out.println("<td><input type=\"number\" required=\"required\" min=\"0\" name=\"txtProductQuantity\" value=\""+product_quantity+"\" size=20 /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Giá gốc</td>");
    	out.println("<td><input type=\"number\" required=\"required\"  id=\"txtProductOriginPrice\" min=\"0\" name=\"txtProductOriginPrice\" value=\""+product_origin_price+"\" size=35 /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Khuyến mại</td>");
    	out.println("<td><input type=\"number\" required=\"required\" min=\"0\" name=\"txtProductDiscount\" value=\""+product_price_discount+"\" size=10 /><span style=\"color:red\"><b>%</b></span></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Bảo hành</td>");
    	out.println("<td><input type=\"number\" min=\"0\" id=\"txtProductWarrantyTime\" required=\"required\" name=\"txtProductWarrantyTime\" value=\""+product_warranty_time+"\" size=20 /></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Nhà cung cấp</td>");
    	out.println("<td>");
    	ProviderControl pc = new ProviderControl(cp);
    	if(cp != null){
            getServletContext().setAttribute("cpool",cc.getConnectionPool());
        } 
    	ProviderObject similar2 = new ProviderObject();
    	similar2.setProvider_id(product_provider_id);
    	String slcProvider = pc.slcProvider(similar2);
        pc.releaseConnection();
    	out.println(slcProvider);
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Thông số kĩ thuật</td>");
    	out.println("<td><textarea rows=10 cols=80 id=\"txtProductSpecification\" name=\"txtProductSpecification\">"+product_specification+"</textarea></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Thông tin khuyến mại</td>");
    	out.println("<td><textarea rows=10 cols=80 id=\"txtProductPromotion\" name=\"txtProductPromotion\">"+product_promotion+"</textarea></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Ghi chú</td>");
    	out.println("<td><textarea rows=6 cols=80 id=\"txtProductNote\" name=\"txtProductNote\">"+product_note+"</textarea></td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Sản phẩm có mới hay không?</td>");
    	out.println("<td>");
    	out.println("<input type=\"checkbox\" "+checked1+" name=\"ckIsnew\" id=\"ckIsnew\" value=1 > <label for=\"ckIsnew\">Là sản phẩm mới ?</label>");
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Sản phẩm thanh lý?</td>");
    	out.println("<td>");
    	out.println("<input type=\"checkbox\" "+checked2+" name=\"ckli\" id=\"ckli\" value=1 > <label for=\"ckli\">Là sản phẩm thanh lý ?</label>");
    	out.println("</td>");
    	out.println("</tr>");
    	out.println("<tr>");
    	out.println("<td class=\"lc\">Sản phẩm bán chạy?</td>");
    	out.println("<td>");
    	out.println("<input type=\"checkbox\" "+checked3+" name=\"ckSelling\" id=\"ckSelling\" value=1 > <label for=\"ckSelling\">Là sản phẩm bán chạy ?</label>");
    	out.println("</td>");
    	out.println("</tr>");
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
        ImagesControl ic = new ImagesControl(cp);
 		if (cp == null) {
 			getServletContext().setAttribute("cpool", ic.getConnectionPool());
 		}
 		ImagesObject similar12 = new ImagesObject();
 		String viewImages = ic.viewImages(similar12,0,(byte) 0);
 		ic.releaseConnection();
        out.println("<div class=\"modal fade\" id=\"popImageManager\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">");
        out.println("<div class=\"modal-dialog modal-lg\">");
        out.println("<div class=\"modal-content\">");
        out.println("<form action=\"/WebBanHang/pop/uploadfile/view\" method=\"post\" enctype=\"multipart/form-data\">");
        out.println("<div class=\"modal-header\">");
        out.println("<button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>");
        out.println("<h4 class=\"modal-title\" id=\"myModalLabel\">Quản Lý Ảnh</h4>");
        out.println("</div>");
        out.println("<div class=\"modal-body\">");
        out.println(viewImages);
        out.println("<div class=\"form-group\">");
        out.println("<input class=\"form-control\" type=\"file\" name=\"uploadFile\"/>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"modal-footer\">");
        out.println("<button class=\"btn btn-primary\" type=\"submit\" />Upload</button>");
        out.println("<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>");
        out.println("</div>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"modal fade\" id=\"addFastProduct\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">");
        out.println("<div class=\"modal-dialog modal-lg\">");
        out.println("<div class=\"modal-content\">");
        out.println("<div class=\"modal-header\">");
        out.println("<button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>");
        out.println("<h4 class=\"modal-title\" id=\"myModalLabel\">Thêm nhanh sản phẩm</h4>");
        out.println("</div>");
        out.println("<div class=\"modal-body\">");
        out.println("<div class=\"alert alert-warning\" role=\"alert\"><i class=\"fa fa-exclamation-circle\" aria-hidden=\"true\"></i> Lưu ý chức năng mới hỗ trợ lấy dữ liệu từ 2 site <b>Trananh.vn</b> và <b>Hanoicomputer.vn</b></div>");
        out.println("<form action=\"/WebBanHang/product/ae\" method=\"get\">");
        out.println("<table class=\"table table-striped table-bordered\">");
        out.println("<tr>");
        out.println("<td>Nhập link nhanh</td>");
        out.println("<td><input type=\"hidden\" name=\"action\" value=\"getdata\" /><input class=\"form-control\" type=\"text\" name=\"url\" /></td>");
        out.println("<td><button class=\"btn btn-primary\" type=\"submit\" />Lấy dữ liệu</button></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("<table class=\"table table-striped table-bordered\">");
        out.println("<tr>");
        out.println("<th>Ảnh sản phẩm</th>");
        out.println("<th>Tên sản phẩm</th>");
        out.println("<th>Lấy dữ liệu</th>");
        out.println("</tr>");
        out.println(GetDataImpl.getProductForKeywordHN("lap"));
        out.println("</table>");
        out.println("</div>");
        out.println("<div class=\"modal-footer\">");
        out.println("<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("<script src=\"/WebBanHang/adv/ckeditor/ckeditor.js\"></script>");
        out.println("<script>");
        out.println("CKEDITOR.replace( 'txtProductSpecification' );");
        out.println("CKEDITOR.replace( 'txtProductNote' );");
        out.println("CKEDITOR.replace( 'txtProductSummary' );");
        out.println("CKEDITOR.replace( 'txtProductPromotion' );");
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
		String productsummary = request.getParameter("txtProductSummary");
		String productimage = request.getParameter("txtProductImage");
		int productcategory = Integer.parseInt(request.getParameter("slcCategory"));
		int productquantity = Integer.parseInt(request.getParameter("txtProductQuantity"));
		int productoriginprice = Integer.parseInt(request.getParameter("txtProductOriginPrice"));
		int productdiscount = Integer.parseInt(request.getParameter("txtProductDiscount"));
		int productwarrantytime = Integer.parseInt(request.getParameter("txtProductWarrantyTime"));
		int productprovider = Integer.parseInt(request.getParameter("slcProvider"));
		String productspecification = request.getParameter("txtProductSpecification");
		String productnote = request.getParameter("txtProductNote");
		String productpromotion = request.getParameter("txtProductPromotion");
		boolean product_isnew = request.getParameter("ckIsnew") == null || !request.getParameter("ckIsnew").equalsIgnoreCase("1") ? false : true;
		boolean ckli = request.getParameter("ckli")== null || !request.getParameter("ckli").equalsIgnoreCase("1") ? false : true;
		boolean ckSelling = request.getParameter("ckSelling") == null || !request.getParameter("ckSelling").equalsIgnoreCase("1") ? false : true;
		String productprefix = request.getParameter("txtProductPrefix");
		ProductObject po = new ProductObject();
		po.setProduct_name(productname);
		po.setProduct_summary(productsummary);
		po.setProduct_image(productimage);
		po.setProduct_category_id(productcategory);
		po.setProduct_quantity(productquantity);
		po.setProduct_origin_price(productoriginprice);
		po.setProduct_price_discount(productdiscount);
		po.setProduct_warranty_time(productwarrantytime);
		po.setProduct_provider_id(productprovider);
		po.setProduct_specification(productspecification);
		po.setProduct_note(productnote);
		po.setProduct_promotion(productpromotion);
		po.setProduct_isnew(product_isnew);
		po.setProduct_isliquidation(ckli);
		po.setProduct_isselling(ckSelling);
		po.setProduct_prefix(productprefix);
		
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
