/**
 * javascript for common
 */

function confirmDel(url){
	var message = "Bạn có chắc chắn xóa không ?";
	if(window.confirm(message)){
		window.location.href = url;
	}
	else{
		return false;
	}
	
}
function saveProduct(fn){
	fn.method = "POST";
	fn.action = "/WebBanHang/product/ae";
	fn.submit();
}
function saveCategory(fn){
	fn.method = "POST";
	fn.action = "/WebBanHang/category/ae";
	fn.submit();
}
function saveCategoryGroup(fn){
	fn.method = "POST";
	fn.action = "/WebBanHang/categorygroup/ae";
	fn.submit();
}
//
function loadImages(url) {
	document.getElementById("thumbbox").innerHTML = "<img src='"+url+"' id='thumbimage' width='150px' height='120px' /><a class='removeimg' href='javascript: removeImg()' ><span class='glyphicon glyphicon-remove'></span></a></span>";  
	document.getElementById("loadimg").value = url;
	$('#popImageManager').modal('hide');
}
function removeImg(){
	$("#thumbimage").attr('src', '').hide();
    $(".removeimg").hide();
}