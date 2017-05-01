<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
</div><!-- end content-->
	<div class="clr"></div>
	<!-- Modal -->
	<div class="modal fade" id="mdLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-sm">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="lblTitle">ĐĂNG NHẬP HỆ THỐNG</h4>
	      </div>
	      <div class="modal-body">
	      <form action="index_submit" method="get" accept-charset="utf-8" class="form-horizontal">
			<div class="form-group">
				<label for="txtUserName" class="col-sm-4 control-label">Tên đăng nhập</label>
		        <div class="col-sm-8"><input type="text" id="txtUserName" name="txtUserName" class="form-control"></div>
	        </div>
	        <div class="form-group">
			    <label for="txtPassword" class="col-sm-4 control-label">Mật khẩu</label>
		       	<div class="col-sm-8"><input type="text" id="txtPassword" name="txtPassword" class="form-control"></div>	
	       	</div>
	      </form>
	      <div class="col-sm-12 text-right">
	      	<a href="javascript:void(0)" id="btnAction" onclick="loadAction()">Quên mật khẩu</a>
	      </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" id="btnSubmit"><i class="fa fa-lock" aria-hidden="true"></i> Đăng nhập</button>
	        <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times" aria-hidden="true"></i> Hủy bỏ</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- end modal-->
	<div class="footer">
		Copyright&copy2017&nbspHUNGCUONGCOMPUTER
	</div><!-- end footer-->
</body>
</html>