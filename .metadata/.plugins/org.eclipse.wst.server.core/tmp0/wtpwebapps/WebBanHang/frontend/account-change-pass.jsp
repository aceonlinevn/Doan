<%@page import="com.ads.user.UserModel"%>
<%@page import="com.library.Utilities"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.*,com.object.*,com.gui.bill.*"%>
<%@ page import="com.gui.product.*"%>
<%@ page import="java.util.*"%>
<form action="/WebBanHang/user/pass" method="post"
	class="form-horizontal col-sm-12">
	<div class="form-group">
		<label for="txtUserPassNow" class="col-sm-2 control-label">Mật khẩu hiện tại</label>
		<div class="col-sm-2">
			<input type="password" id="txtUserPassNow" name="txtUserPassNow"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="txtUserPassNew" class="col-sm-2 control-label">Mật khẩu mới</label>
		<div class="col-sm-2">
			<input type="password" id="txtUserPassNew" name="txtUserPassNew"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<label for="txtReUserPassNew" class="col-sm-2 control-label">Xác nhận mật khẩu</label>
		<div class="col-sm-2">
			<input type="password" id="txtReUserPassNew" name="txtReUserPassNew"
				class="form-control">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<button type="submit" class="btn btn-primary">Thay đổi mật khẩu</button>
		</div>
	</div>
</form>