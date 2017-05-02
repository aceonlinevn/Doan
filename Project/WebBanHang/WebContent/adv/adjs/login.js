/*The script processing for login.html*/

function checkValidLogin(fn){
	//Lấy giá trị trên giao diện
	var username = fn.txtUserName.value;
	var userpass = fn.txtUserPass.value;
	var usercheck = fn.chkSave.checked;
	
	//Biến xác nhận sự hợp lệ của từng giá trị
	var validUserName = true;
	var validUserPass = true;
	var validUserSave = false;
	
	//Lưu trữ các thông báo
	var messageUserPass = "";
	var messageUserName = "";
	
	//Kiểm tra tên đăng nhập
	username = username.trim();
	if(username == ""){
		messageUserName = "Nhập tên đăng nhập hệ thống.";
		validUserName = false;
	}
	
	//Kiểm tra mật khẩu
	userpass=userpass.trim();
	if(userpass == ""){
		messageUserPass = "\nThiếu mật khẩu đăng nhập hệ thống.";
		validUserPass = false;
	}else{
		if(userpass.length<6){
			messageUserPass = "\nMật khẩu quá ngắn cần lớn hơn 5 kí tự";
			validUserPass = false;
		}
	}
	

	
	//Hiển thị thông báo và di chuyển con trỏ
	var message = messageUserName+messageUserPass;
	if(message != ""){
		window.alert(message);
		if(!validUserName){
				fn.txtUserName.focus();
		
		}else if(!validUserPass){
			fn.txtUserPass.focus();
			fn.txtUserPass.select();
		}
	}
	//Trả về kết quả kiểm tra
	return validUserName && validUserPass;
	
}	

function login(fn){
	if(this.checkValidLogin(fn))
	{
		fn.method="POST"; // goi vao doPost
		fn.action="/WebBanHang/user/login";
		fn.submit();
	}	
	
}