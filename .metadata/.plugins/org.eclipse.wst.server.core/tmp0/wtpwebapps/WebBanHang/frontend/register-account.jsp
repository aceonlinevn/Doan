<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form name="registryForm" id="registryForm" method="POST" action="/WebBanHang/UserRegister" onsubmit="">
	<div class="col-sm-12">
		<div class="title-custom">Đăng ký tài khoản</div>
		<div class="col-sm-4">
			<div class="form-group">
				<label for="txtCustomerName">Họ tên </label> <input type="text"
					id="txtCustomerName" name="txtCustomerName" required="required"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="txtCustomerEmail">Địa chỉ email</label> <input
					type="text" id="txtCustomerEmail" name="txtCustomerEmail"
					required="required" class="form-control">
			</div>
			<div class="form-group">
				<label for="txtCustomerPhoneNumber">Điện thoại</label> <input
					type="text" id="txtCustomerPhoneNumber"
					name="txtCustomerPhoneNumber" required="required"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="rdoGender">Giới tính </label> &nbsp;&nbsp;&nbsp;<input
					type="radio" id="rdoGenderMale" name="rdoGender" value="1" checked="checked">
				<label for="rdoGenderMale">Nam</label> &nbsp;&nbsp;&nbsp;
				<input type="radio" id="rdoGenderFemale" name="rdoGender" value="2"><label
					for="rdoGenderFemale">Nữ</label>
			</div>
			<div class="form-group">
				<label for="txtCustomerBirthdate">Ngày sinh </label>
				<input type="date" id="txtCustomerBirthdate" name="txtCustomerBirthdate"
					class="form-control" required="required"></input>
			</div>
			<div class="form-group">
				<label for="txtCustomerAdress">Địa chỉ</label>
				<textarea id="txtCustomerAdress" name="txtCustomerAdress"
					class="form-control" required="required"></textarea>
			</div>
			<div class="form-group">
				<label for="txtCustomerNote">Ghi chú</label>
				<textarea id="txtCustomerNote" name="txtCustomerNote"
					class="form-control"></textarea>
			</div>
			<div class="form-group">
				<label for="txtCustomerNote">Mã captcha</label>
				<div id="captchaImg"><img src="/WebBanHang/captcha-image.jpg"></div>
			</div>
			<div class="form-group">
				<label for="txtReCaptcha">Xác nhận mã captcha</label>
				<input type="text" id="txtReCaptcha" name="txtReCaptcha"
					class="form-control" required="required"></input>
			</div>
			<button type="submit" class="btn btn-danger">Đăng ký</button>
			<a class="btn btn-primary" data-toggle="modal" data-target="#mdLogin">Đăng Nhập</a>
		</div>
	</div>
</form>