/*The script processing for login.html*/

function checkValidLogin(fn){
	//Lấy giá trị trên giao diện
	var username = fn.txtUserName.value;
	var userpass = fn.txtUserPass.value;
	var useremail = fn.txtEmail.value;
	var usercheck = fn.chkSave.checked;
	
	//Biến xác nhận sự hợp lệ của từng giá trị
	var validUserName = true;
	var validUserPass = true;
	var validEmail = true;
	var validUserSave = false;
	
	//Lưu trữ các thông báo
	var messageUserPass = "";
	var messageUserName = "";
	var messageEmail = "";
	
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
	
	//Kiểm tra sự cần thiết của hộp thư
	useremail=useremail.trim();
	var pattern = /\w+@\w+[.]\w/; // mẫu định dạng email chuẩn js \w - ký tự tùy ý
	if(!validUserName){
		if(useremail == ""){
			messageEmail = "\nCần phải có hộp thư để đăng nhập hoặc phải có tên đăng nhập";
			validEmail = false;
		}else{
			if(!useremail.match(pattern)){			// match - đúng với mẫu trả về true false
				messageEmail = "\nKhông đúng định dạng email";
				validEmail = false;
			}else{
				validUserName = true;
				messageUserName = "";
			}
		}
	}else{
		if(useremail != ""){
			if(!useremail.match(pattern)){			
				messageEmail = "\nKhông đúng định dạng email";
				validEmail = false;
			}
		}
	}
	
	
	//Hiển thị thông báo và di chuyển con trỏ
	var message = messageUserName+messageUserPass+messageEmail;
	if(message != ""){
		window.alert(message);
		if(!validUserName){
			if(!validEmail){
				fn.txtUserName.focus();
			}
		}else if(!validUserPass){
			fn.txtUserPass.focus();
			fn.txtUserPass.select();
		}else if(!validEmail){
			fn.txtEmail.focus();
			fn.txtEmail.select();
		}
	}
	//Trả về kết quả kiểm tra
	return validUserName && validUserPass && validEmail;
	
}	

function login(fn){
	if(this.checkValidLogin(fn))
	{
		fn.method="POST"; // goi vao doPost
		fn.action="/adv/user/login";
		fn.submit();
	}	
	
}