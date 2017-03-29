function loadImg(str){
	var url = str.trim();
	$('.productimage').load('/WebBanHang/adv/ajax/loadImage.jsp?url='+url);
}