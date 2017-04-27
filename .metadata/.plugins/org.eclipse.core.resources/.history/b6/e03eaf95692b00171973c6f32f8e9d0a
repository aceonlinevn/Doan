/**
 * config popup
 */

function openPopup(url, w, h) {
	var width = w;
	var height = h;
	var from_top = 350;
	var from_left = 500;
	var toolbar = 'no';
	var location = 'no';
	var directories = 'no';
	var status = 'no';
	var menubar = 'no';
	var scrollbars = 'yes';
	var resizable = 'yes';
	var atts = 'width=' + width + ',height=' + height + ',top=' + from_top
			+ ',screenY=';
	atts += from_top + ',left=' + from_left + ',screenX=' + from_left
			+ ',toolbar=' + toolbar;
	atts += ',location=' + location + ',directories=' + directories
			+ ',status=' + status;
	atts += ',menubar=' + menubar + ',scrollbars=' + scrollbars + ',resizable='
			+ resizable;
	window.open(url, '', atts);
}

/*
 * popup upload file
 */
function popImageManager() {
	var tmp = "";
	tmp += '<div class="modal fade" id="popImageManager" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">';
	tmp += '<div class="modal-dialog modal-lg">';
	tmp += '<div class="modal-content">';
	tmp += '<div class="modal-header">';
	tmp += '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>';
	tmp += '<h4 class="modal-title" id="myModalLabel">Modal title</h4>';
	tmp += '</div>';
	tmp += '<div class="modal-body">';
	tmp += '<form action="" method="post">';
	tmp += '<a href="javascript: void(0);" ondblclick="load()">click me</a>';
	tmp += '<input type="file" name="flImageName"/>';
	tmp += '</form>';
	tmp += '</div>';
	tmp += '<div class="modal-footer">';
	tmp += '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
	tmp += '</div>';
	tmp += '</div>';
	tmp += '</div>';
	tmp += '</div>';
	document.write(tmp);
}
function load(){
	document.getElementById("loadimg").value = "/WebBanHang/upload/productimg/33260_01.jpg";
	document.getElementById("thumbbox").innerHTML = "<img src='/WebBanHang/upload/productimg/34327_01.jpg' id='thumbimage' width='150px' height='120px' /><a class='removeimg' href='javascript: removeImg()' ><span class='glyphicon glyphicon-remove'></span></a></span>";
	$('#popImageManager').modal('hide');
}
function getDataPr(){
	document.getElementById("txtProductName").value = document.getElementById("dtProductName").innerHTML;
	document.getElementById("txtProductOriginPrice").value = document.getElementById("dtProductPrice").innerHTML;
	document.getElementById("txtProductSummary").innerHTML = document.getElementById("dtProductSummary").innerHTML;
	document.getElementById("txtProductWarrantyTime").value = document.getElementById("dtProductWarranty").innerHTML;
	document.getElementById("txtProductPromotion").innerHTML = document.getElementById("dtProductPromotion").innerHTML;
	document.getElementById("txtProductSpecification").innerHTML = document.getElementById("dtProductSpecification").innerHTML;
	$('#addFastProduct').modal('hide');
}