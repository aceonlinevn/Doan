<%@page import="com.ads.user.UserModel"%>
<%@page import="com.library.Utilities"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.*,com.object.*,com.gui.bill.*"%>
<%@ page import="com.gui.product.*"%>
<%@ page import="java.util.*"%>  
    <% 
	    ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
		BillControl bc = new BillControl(cp);
		if (cp == null) {
			application.setAttribute("cpool", bc.getConnectionPool());
		}
    	UserObject userLogined = (UserObject) session.getAttribute("userLogined");
    	if(userLogined != null){
    		ArrayList<BillObject> items = bc.getBillForCusObject(userLogined.getUserId());
    		
    		if(items.size()>0){
    			String status = "";
    %>
    
	<table class="table table-bordered">
		<thead>
			<tr>
				<th rowspan="2">Mã đơn hàng</th>
				<th rowspan="2">Ngày đặt hàng</th>
				<th colspan="2">Chi tiết</th>
				<th rowspan="2">Tình trạng</th>
				<th rowspan="2">Thao tác</th>
			</tr>
			<tr>
				<th>Tên mặt hàng</th>
				<th>Số lượng</th>
			</tr>
		</thead>
		<tbody>
		<% for(BillObject item : items){ 
			if(item.getBill_status() == 0){
				status = "Chưa xử lý";
			}else if(item.getBill_status() == 1){
				status = "Đã xác nhận";
			}else if(item.getBill_status() == 2){
				status = "Đang giao hàng";
			}else if(item.getBill_status() == 3){
				status = "Hoàn thành";
			}
			
		%>
			<tr>
				<td><%=item.getBill_id() %></td>
				<td><%=item.getBill_date_created() %></td>
				<td colspan="2">
					<table class="tb1">
						<%
							String[] pritems = item.getBill_product_detail().split(",");
							for(int i =1;i<pritems.length;i++){
								String[] pritem = pritems[i].split("-");
								ProductControl pc = new ProductControl(cp);
								if (cp == null) {
									application.setAttribute("cpool", pc.getConnectionPool());
								}
								ProductObject po = pc.getProductObject(Integer.parseInt(pritem[1]));
						%>
						<tr>
							<td><a href="<%=request.getContextPath()+"/frontend/detail.jsp?prid="+po.getProduct_id()%>" target="_blank" title="<%=po.getProduct_name() %>"><%=po.getProduct_name() %></a></td>
							<td><%=pritem[2] %></td>
						</tr>
						<% } %>
					</table>
				</td>
				<td><%=status %></td>
				<td><a href="/WebBanHang/frontend/info-account.jsp?view=account-order&del=<%=item.getBill_id() %>" onclick="return confirm('Bạn có chắn chắn muốn hủy bỏ đơn hàng này không?')"><i class="fa fa-times" aria-hidden="true"></i> Hủy bỏ</a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	<% }else{
		out.println("<b>Chưa có đơn hàng.</b>");
	}
    		}
    if(request.getParameter("del") !=null){
    	BillObject bo = new BillObject();
    	bo.setBill_id(Integer.parseInt(request.getParameter("del")));
    	if(bc.cancelBill(bo)){
    		out.println(Utilities.getMessageRedict("Hủy đơn hàng thành công.","/WebBanHang/frontend/info-account.jsp"));	
    	}else{
    		out.println(Utilities.getMessageRedict("Không hủy được đơn hàng.","/WebBanHang/frontend/info-account.jsp"));
    	}
    }
    		
    		%>