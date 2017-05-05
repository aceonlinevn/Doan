package com.ads.bill;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionPool;
import com.ads.product.ProductControl;
import com.ads.product.category.CategoryControl;
import com.library.Utilities;
import com.object.BillObject;
import com.object.CategoryObject;
import com.object.ProductObject;
import com.object.UserObject;
import com.gui.product.*;


/**
 * Servlet implementation class UserView
 */

public class BillView extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**s
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession section = request.getSession();
        UserObject user = (UserObject) section.getAttribute("userLogined");

        //Kiem tra
        if (user != null) {
            view(request, response,user);
        } else {
            response.sendRedirect("/WebBanHang/user/login");
        }
	}
	//Process the View
    private void view(HttpServletRequest request, HttpServletResponse response,UserObject user) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");
        BillControl bc = new BillControl(cp);
        if(cp != null){
            getServletContext().setAttribute("cpool",bc.getConnectionPool());
        }
        
        BillObject similar = new BillObject();

        String viewBills = bc.viewBills(similar);
        bc.releaseConnection();
        RequestDispatcher h = request.getRequestDispatcher("/header");
        if(h!=null){
            h.include(request,response);
        }
        
        String message = (String) request.getSession().getAttribute("err");
        String err = "";
        request.getSession().setAttribute("err", null);
        if(message != null) {
        	if(message.equalsIgnoreCase("failed")){
        		err = "Thất bại";
        	}
        	out.print(Utilities.getMessage(err));
        }
        out.println("<div class=\"view\">");
        out.println("<table class=\"table table-bordered\">");              
        out.println("<tr>");
        out.println("<th rowspan=2>STT</th>");
        out.println("<th rowspan=2>Mã hóa đơn</th>");
        out.println("<th rowspan=2>Ngày tạo</th>");
        out.println("<th colspan=2>Chi tiết</th>");
        out.println("<th rowspan=2>Tình trạng</th>");
        out.println("<th rowspan=2>Thao tác</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<th>Tên mặt hàng</th>");
        out.println("<th>Số lượng</th>");
        out.println("</tr>");
        out.println(viewBills);
        out.println("</table>");
        out.println("</div>");
        //Tim tham chieu cua footer
        RequestDispatcher f = request.getRequestDispatcher("/footer");
        if(f!=null){
            f.include(request,response);
        }

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType(CONTENT_TYPE);
	     PrintWriter out = response.getWriter();
	     int status = Integer.parseInt(request.getParameter("slcStatus"));
	     int bill_id = Integer.parseInt(request.getParameter("hdbBillId"));
	     String bill_accept_date = "";
	     String bill_finish_date = "";
	     String bill_product_detail = request.getParameter("hdbBillProductDetail");
	     if(status >= 1){
	    	 bill_accept_date = Utilities.getStringDateNow();
	     }
	     if(status == 3){
	    	 bill_finish_date = Utilities.getStringDateNow();
	     }
	     UserObject userLogined = (UserObject) request.getSession().getAttribute("userLogined");
	     
	     BillObject bo = new BillObject();
	     bo.setBill_id(bill_id);
	     bo.setBill_status(status);
	     bo.setBill_accept_date(bill_accept_date);
	     bo.setBill_finish_date(bill_finish_date);
	     bo.setBill_user_accept_id(userLogined.getUserId());
	     ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("cpool");
	     //set lai gia voi trang thai hoan thanh giao hang
	     boolean isprocess = true; // co dc tiep tuc thay doi trang thai cua don hang hay khong
	     if(status >=1){
	    	 if(bill_product_detail !=null){
		    	 String[] pritems = bill_product_detail.split(",");
		    	 if(pritems.length>1){
		    		 for(int i =1;i<pritems.length;i++){
		    				String[] pritem = pritems[i].split("-");
		    				ProductControl pc = new ProductControl(cp);
		    				if (cp == null) {
		    					request.setAttribute("cpool", pc.getConnectionPool());
		    				}
		    				ProductObject po = pc.getProductObject(Integer.parseInt(pritem[1]));
		    				if(po.getProduct_quantity() < Integer.parseInt(pritem[2])){
		    					out.print(Utilities.getMessageRedict("Số lượng sản phẩm không đủ, không thể thực hiện tiếp", "/WebBanHang/bill/view"));
		    					isprocess = false;
		    					break;
		    				}else{
		    					if(status ==3){
		    						po.setProduct_quantity(po.getProduct_quantity() - Integer.parseInt(pritem[2]));
		    					}
		    				}
		    				pc.editProduct(po);
		    			}
		    	 }
	    	 }
	     }
	     if(isprocess){
	        BillControl bc = new BillControl(cp);
	        if(cp == null){
	            getServletContext().setAttribute("cpool",bc.getConnectionPool());
	        }
		     boolean result = bc.editBill(bo);
		     if(result){
		    	 out.println(Utilities.getMessageRedict("Cập nhật trạng thái thành công", request.getContextPath()+"/bill/view"));
		     }else{
		    	 out.println(Utilities.getMessageRedict("Cập nhật trạng thái thất bại", request.getContextPath()+"/bill/view"));
		     }
	     }
	}
}
