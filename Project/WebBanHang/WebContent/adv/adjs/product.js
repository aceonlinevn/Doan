function saveUser(fn){
	if(this.checkValidUser(fn)){
		fn.method = "POST";
		fn.action = "/WebBanHang/product/ae";
		fn.submit();
	}
}
function confirmDel(url){
	var message = "Bạn có chắc chắn xóa sản phẩm này không ?";
	if(window.confirm(message)){
		window.location.href = url;
	}
	else{
		return false;
	}
	
}