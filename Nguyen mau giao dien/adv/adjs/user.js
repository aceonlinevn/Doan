/*Các sử lý kịch bản cho user.html*/
function generatePermis(){			//Sinh quyền trong select ở user 
	var permis=new Array();
	permis[0]="---Chọn quyền---";
	permis[1]="Thành viên";
	permis[2]="Tác giả";
	permis[3]="Quản lý";
	permis[4]="Quản trị";
	permis[5]="Quản trị cấp cao";
	var opt = "<select name=\"slcPermission\" onChange=\"refreshPermis(this.form)\" >";
	for(var i=0;i<permis.length;i++){
		opt += "<option value=\""+i+"\" >";
		opt += permis[i];
		opt += "</option>";
	}
	opt += "</select>";
	
	//In ra trình duyệt
	document.write(opt);
}
function generateRoles(){
	var roles = new Array();
	roles[0] = "người sử dụng";
	roles[1] = "chuyên mục bài viết";
	roles[2] = "thể loại bài viết";
	roles[3] = "bài viết, tin tức";
	roles[4] = "hệ sản phẩm";
	roles[5] = "nhóm sản phẩm";
	roles[6] = "loại sản phẩm";
	roles[7] = "sản phẩm";
	roles[8] = "hóa đơn";
	roles[9] = "khách hàng";
	
	var role="<table cellspacing=0>";
	for(var i=0;i<roles.length;i++){
		if(i%3==0){
			role+="<tr>";
		}
		
		role += "<td>";
		role += "<input type=\"checkbox\" name=chks id=chk"+i+" disabled />";
		role += "<label for=chk"+i+" >";
		role += " Quản lý "+roles[i];
		role += "</lable>";
		role += "</td>";
		
		if(i%3==2 || i==role.length-1){
			role+="</tr>";
		}
	}
	role+="</table>"
	document.write(role);
}
//set quyền 
function setCheckbox(fn,dis,check){
	//Duyệt tất cả các phần từ của form
	// Tìm đến các checkbox
	for(var i=0;i<fn.elements.length;i++){		// elements lưu tất cả các phần tử của form
		if(fn.elements[i].type == "checkbox" && fn.elements[i].name == "chks"){
			fn.elements[i].disabled = dis;
			fn.elements[i].checked = check;
		}
	}	
}

function refreshPermis(fn){
	//lấy giá trị permission
	var permis = parseInt(fn.slcPermission.value); // chuyển đổi 1 chuỗi thành số parseInt
	if(permis == 4 || permis == 5){
		this.setCheckbox(fn,true,true);
	}else if(permis == 3){
		this.setCheckbox(fn,false,true);
	}else if(permis == 2){
		this.setCheckbox(fn,false,false);
	}else{
		this.setCheckbox(fn,true,false);
	}
}
function checkValidUser(fn){
	var username = fn.txtUserName.value;
	var userpass = fn.txtUserPass.value;
	var useremail = fn.txtUserEmail.value;
	var userpermis = parseInt(fn.slcPermission.value);
	
	//Biến xác nhận sự hợp lệ
	var validUserName = true;
	var validUserPass = true;
	var validUserEmail = true;
	var validUserPermiss = true;
	//Biến ghi nhận thông báo
	var message = "";
	//Kiểm tra tên tài khoản
	username = username.trim();
	if(username==""){
		validUserName=false;
		message="Thiếu tên đăng nhập cho tài khoản";
	}else{
		if(username.indexOf(" ")!=-1){
			validUserName=false;
			message="Tên đăng nhập không có dấu cách";
		}	
	}
	//Kiểm tra pass
	if(userpass==""){
		validUserPass=false;
		message+="\nCần phải nhập mật khẩu cho tài khoản";
	}else{
		if(userpass.length<6){
			validUserPass=false;
			message+="\nMật khẩu quá ngắn cần nhiều hơn 6 kí tự";
		}
	}
	if(useremail==""){
		validUserEmail=false;
		message+="\nThiếu hộp thư cho tài khoản";
	}else{
		var pattern=/\w+@\w+[.]\w/;
		if(!useremail.match(pattern)){
			validUserEmail= false;
			message+="\nSai định dạng email";
		}
	}
	//Kiểm tra quyền thực thi
	if(userpermis==2 || userpermis==3){
		for(var i=0;i<fn.elements.length;i++){
			if(fn.elements[i].type=="checkbox" && fn.elements[i].name=="chks"){
				if(fn.elements[i].checked){
					validUserPermiss=true
					break;
				}else{
					validUserPermiss=false;
				}
			}
		}
	}
	
	//Ghi nhận thông báo cho quyền
	if(!validUserPermiss){
		
	}
	//Trả về thông báo và định vị con trỏ
	if(message !=""){
		window.alert(message);
		if(!validUserName){
			fn.txtUserName.focus();
			fn.txtUserName.select();
		}else if(!validUserPass){
			fn.txtUserPass.focus();
			fn.txtUserPass.select();
		}else if(!validUserEmail){
			fn.txtUserEmail.focus();
			fb.txtUserEmail.select();
		}else if(!validUserPermiss){
			fn.slcPermission.focus();
		}
	}
	return validUserName && validUserPass && validUserEmail && validUserPermiss;
}

function saveUser(fn){
	if(this.checkValidUser(fn)){
		fn.method="POST";
		fn.action="/adv/user/ae";
		fn.submit();
	}
}

function confirmDel(url){
	var message="Bạn có chắc chắn xóa người sử dụng ?";
	if(window.confirm(message)){
		window.location.href=url;
		
	}else{
		return false;
	}
	
}