/*The script processing for provider.html*/

function setForm(fn){
	fn.btnRegistry.disabled = true;
	fn.reset();
}

function checkValidProvider(fn){
	var name = fn.txtProviderName.value;
	var check = fn.chkAgree.checked;
	
	//Kiểm tra trạng thái
	name = name.trim();
	if(name !="" && check){
		fn.btnRegistry.disabled=false;
	}else{
		fn.btnRegistry.disabled=true;
	}	
}