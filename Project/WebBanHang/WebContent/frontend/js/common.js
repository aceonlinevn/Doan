$(document).ready(function(){
    var arr_price;
    $(".product-price").addClass("img_price");
    $(".img_price").each(function(){
        str_price = $(this).text().trim();
        if(str_price !='Liên hệ' && str_price !='Contact'){
            arr_price = str_price.split("");
            for(i=0;i< arr_price.length;i++){
                if(arr_price[i] == 0) arr_price[i] = "<span class='price-number-0'></span>";
                if(arr_price[i] == 1) arr_price[i] = "<span class='price-number-1'></span>";
                if(arr_price[i] == 2) arr_price[i] = "<span class='price-number-2'></span>";
                if(arr_price[i] == 3) arr_price[i] = "<span class='price-number-3'></span>";
                if(arr_price[i] == 4) arr_price[i] = "<span class='price-number-4'></span>";
                if(arr_price[i] == 5) arr_price[i] = "<span class='price-number-5'></span>";
                if(arr_price[i] == 6) arr_price[i] = "<span class='price-number-6'></span>";
                if(arr_price[i] == 7) arr_price[i] = "<span class='price-number-7'></span>";
                if(arr_price[i] == 8) arr_price[i] = "<span class='price-number-8'></span>";
                if(arr_price[i] == 9) arr_price[i] = "<span class='price-number-9'></span>";
                if(arr_price[i] == '.') arr_price[i] = "<span class='price-number-dot'></span>";
                if(i> arr_price.length - 4) arr_price[i]="";
            }

            $(this).html(arr_price);
        }
    });

    var arr_full_price;
    $(".img_price_full").each(function(){
        str_price = $(this).text().trim();

        if(str_price !='Liên hệ' && str_price !='Contact'){
            arr_price = str_price.split("");

            for(i=0;i< arr_price.length;i++){
                if(arr_price[i] == 0) arr_price[i] = "<span class='price-number-0'></span>";
                if(arr_price[i] == 1) arr_price[i] = "<span class='price-number-1'></span>";
                if(arr_price[i] == 2) arr_price[i] = "<span class='price-number-2'></span>";
                if(arr_price[i] == 3) arr_price[i] = "<span class='price-number-3'></span>";
                if(arr_price[i] == 4) arr_price[i] = "<span class='price-number-4'></span>";
                if(arr_price[i] == 5) arr_price[i] = "<span class='price-number-5'></span>";
                if(arr_price[i] == 6) arr_price[i] = "<span class='price-number-6'></span>";
                if(arr_price[i] == 7) arr_price[i] = "<span class='price-number-7'></span>";
                if(arr_price[i] == 8) arr_price[i] = "<span class='price-number-8'></span>";
                if(arr_price[i] == 9) arr_price[i] = "<span class='price-number-9'></span>";
                if(arr_price[i] == '.') arr_price[i] = "<span class='price-number-dot'></span>";
                if(arr_price[i] == "VNĐ") arr_price[i] = "";
            }
            $(this).html(arr_price);
        }
    });
    //Tool tip
    $(".products").addClass("istooltip");
    $(".product-hover").addClass("tooltip");
    var w_tooltip = $(".tooltip").width();;
    var h_tooltip = 0;
    var pad = 10; 
    var x_mouse = 0; var y_mouse = 0;
    var wrap_left = 0;
    var wrap_right = 0;
    var wrap_top = 0;
    var wrap_bottom = 0;
    $(".istooltip .product .product-image").mousemove(function(e){
        wrap_left = $(this).parent().parent().offset().left;
        wrap_top = $(this).parent().parent().offset().top;
        wrap_bottom = $(this).parent().parent().offset().top + $(this).parent().parent().parents(".istooltip").height();
        x_mouse = e.pageX - $(this).parent().parent().offset().left;
        y_mouse = e.pageY - $(this).parent().parent().offset().top;
        h_tooltip = $(this).parent().children(".tooltip").height();
        $(".tooltip").hide();
        
       
        //Move Horizontal
        if($(this).offset().left - pad - w_tooltip > wrap_left){
            $(this).parent().children(".tooltip").css("left", 0-(w_tooltip + pad) + x_mouse);
        }else{
            $(this).parent().children(".tooltip").css("left", pad + x_mouse + 20);
        }
        
        //Move Vertical     
        if(e.pageY + h_tooltip >= $(window).height() + $(window).scrollTop()){
            $(this).parent().children(".tooltip").css("top", y_mouse - h_tooltip - pad);
        }else{
            $(this).parent().children(".tooltip").css("top", pad+ y_mouse + 20);
            }
        //Show tooltip  
        $(this).parent().children(".tooltip").show();
    });
        
    $(".istooltip .product .product-image").mouseout(function(){
        $(".tooltip").hide();
        });
    if(jQuery.browser.mobile==true){
        $(".product-hover").removeClass("tooltip");
        console.log(jQuery.browser.mobile);
    }
});
function checkBrowserEnableCookie() {
	var e = navigator.cookieEnabled ? true : false;
	if (typeof navigator.cookieEnabled == "undefined" && !e) {
		document.cookie = "testcookie";
		e = document.cookie.indexOf("testcookie") != -1 ? true : false
	}
	if (e) return true;
	else return false
}
function hura_create_cookie(e, t, n) {
	if (n) {
		var r = new Date;
		r.setTime(r.getTime() + n * 24 * 60 * 60 * 1e3);
		var i = "; expires=" + r.toGMTString()
	} else var i = "";
	document.cookie = e + "=" + Base64.encode(t) + i + "; path=/;"
}

function hura_read_cookie(e) {
	var t = e + "=";
	var n = document.cookie.split(";");
	for (var r = 0; r < n.length; r++) {
		var i = n[r];
		while (i.charAt(0) == " ") i = i.substring(1, i.length);
		if (i.indexOf(t) == 0) return Base64.decode(i.substring(t.length, i.length))
	}
	return null
}

function hura_erase_cookie(e) {
	hura_create_cookie(e, "", -1)
}

function countShoppingCart(e) {
	var t = document.getElementById("count_shopping_cart_store");
	var n = document.getElementById("total_shopping_cart_store");
	if (hura_read_cookie(e) == null) {
		hura_create_cookie(e, "-", 1);
		if (t != "underfined" && t != null) {
			t.innerHTML = 0
		}
	} else {
		var r = hura_read_cookie(e);
		var i = r.split(",");
		number_product = i.length;
		if (t != "underfined" && t != null) {
			t.innerHTML = number_product - 1
		}
		if (n != "underfined" && n != null) {
			if ($("#total_shopping_cart_store").length > 0) {
				var s = 0;
				for (var o = 0; o < i.length; o++) {
					item_content = i[o];
					if (item_content.length > 1) {
						item_detail = item_content.split("-");
						item_type = item_detail[0];
						pro_id = item_detail[1];
						pro_quantity = parseInt(item_detail[2]);
						unit_price = parseInt(item_detail[3]);
						s += unit_price * pro_quantity
					}
				}
				n.innerHTML = writeStringToPrice(s + "")
			}
		}
	}
}

function emptyShoppingCart(e) {
	hura_create_cookie(e, "-", 1)
}

function addToShoppingCart(e, t, n, r) {
	if (hura_read_cookie("shopping_cart_store") == null) {
		hura_create_cookie("shopping_cart_store", ",", 1)
	}
	var i = hura_read_cookie("shopping_cart_store");
	if (i.search("," + e + "-" + t + "-") == -1) {
		var s = i + "," + e + "-" + t + "-" + n + "-" + r;
		hura_create_cookie("shopping_cart_store", s, 1);
		window.location = "/WebBanHang/fronted/cart.jsp"
	} else {
	    alert("Sản phẩm bạn chọn đã có trong giỏ hàng!")
	}
}

function addToShoppingCartStop(e, t, n, r, i) {
	if (hura_read_cookie("shopping_cart_store") == null) {
		hura_create_cookie("shopping_cart_store", ",", 1)
	}
	var s = hura_read_cookie("shopping_cart_store");
	if (s.search("," + e + "-" + t + "-") == -1) {
		var o = s + "," + e + "-" + t + "-" + n + "-" + r;
		hura_create_cookie("shopping_cart_store", o, 1);
		countShoppingCart("shopping_cart_store");
		alert("Thêm sản phẩm vào giỏ hàng thành công!")
	} else {
	    alert("Sản phẩm bạn chọn đã có trong giỏ hàng!");
	}
}

function isItemInCart(e, t) {
	var n = hura_read_cookie("shopping_cart_store");
	if (n != null && n.search("," + e + "-" + t + "-") != -1) {
		document.write("Đang trong giỏ hàng")
	}
}

function deleteShoppingCartItem(e, t, n, r) {
	if (confirm("Bạn muốn xóa bỏ sản phẩm này khỏi giỏ hàng ? ")) {
		removeShoppingCartItem(e, t, n, r);
		window.location = "/WebBanHang/frontend/cart.jsp"
	}
}

function removeShoppingCartItem(e, t, n, r) {
	var i = hura_read_cookie("shopping_cart_store");
	i += ",";
	var s = new RegExp("," + e + "-" + t + "-([0-9]+)-([0-9]+),", "i");
	new_cart = i.replace(s, ",");
	new_cart = new_cart.substr(0, new_cart.length - 1);
	hura_create_cookie("shopping_cart_store", new_cart, 1)
}

function writeStringToPrice(e) {
	var t = e.substr(0, e.length % 3);
	var n = e.replace(t, "");
	var r = n.length / 3;
	var i = "";
	for (var s = 0; s < r; s++) {
		group_of_three = n.substr(s * 3, 3);
		i += group_of_three;
		if (s != r - 1) i += "."
	}
	if (t.length > 0) {
		if (i != "") return t + "." + i;
		else return t
	} else {
		if (i != "") return i;
		else return ""
	}
}

function getItemUnitPrice(e, t) {
	var n = document.getElementById("sell_price_" + e + "_" + t).innerHTML;
	while (n.indexOf(".") > 0) {
		n = n.replace(".", "")
	}
	n = parseInt(n);
	return n
}

function getItemQuantity(e, t) {
	var n = document.getElementById("quantity_" + e + "_" + t).value;
	n = parseInt(n);
	return n
}

function updatePrice(e, t, n) {
	if (!check_interger(n)) {
		alert("Vui lòng nhập số > 0");
		n = 1;
		$("#quantity_" + e + "_" + t).val(n)
	}
	show_cart_total(e, t, n);
}

function show_cart_total(e, t, n) {
	unit_price = getItemUnitPrice(e, t);
	document.getElementById("price_" + e + "_" + t).innerHTML = writeStringToPrice(unit_price * n + "");
	reCountTotal()
}

function updatePriceAndCheckStock(e, t, n, r, i) {
	if (!check_interger(n)) {
		alert("Vui lòng nhập số > 0");
		n = i;
		$("#quantity_" + e + "_" + t).val(i)
	} else {
		if (n > r) {
			alert("Hiện tại trong kho chỉ có " + r + " sản phẩm này, quý khách vui lòng nhập lại");
			n = i;
			$("#quantity_" + e + "_" + t).val(i)
		}
	}
	show_cart_total(e, t, n)
}

function check_interger(e) {
	var t = /^\d+$/;
	if (t.test(e)) {
		if (parseInt(e) > 0) return true;
		else return false
	}
	return false
}

function reCountTotal() {
	var e = "";
	var t = document.getElementById("item_update_quantity").value;
	all_item_array = t.split(",");
	var n = 0;
	combo_array = new Array;
	for (var r = 0; r < all_item_array.length; r++) {
		item_id = all_item_array[r];
		if (item_id.length > 0) {
			unformat_price = document.getElementById("sell_price_" + item_id.replace("-", "_")).innerHTML;
			while (unformat_price.indexOf(".") > 0) {
				unformat_price = unformat_price.replace(".", "")
			}
			item_price = parseInt(unformat_price);
			item_quantity = parseInt(document.getElementById("quantity_" + item_id.replace("-", "_")).value);
			e += "," + item_id + "-" + item_quantity + "-" + item_price;
			n += item_price * item_quantity
		}
	}
	hura_create_cookie("shopping_cart_store", e, 1);
	document.getElementById("total_value").innerHTML = writeStringToPrice(n + "");
	document.getElementById("total_cart_value").value = n;
	var i = document.getElementById("total_shopping_cart_store");
	if (i != "undefined" && i != null) {
		i.innerHTML = writeStringToPrice(n + "")
	}
}

function isNumber(e) {
	return !isNaN(parseFloat(e)) && isFinite(e)
}

function makeUrlAcceptQuery(e) {
	if (e.search("?") > 0) return e;
	else return e + "?"
}

function checkCartForm() {
	var e = hura_read_cookie("shopping_cart_store");
	var t = e.split(",");
	number_product = t.length;
	if (number_product <= 1) {
		if (confirm("Giỏ hàng chưa có sản phẩm. Vui lòng chọn sản phẩm vào giỏ hàng")) {
			window.location = "/WebBanHang"
		}
		return false
	} else {
		var n = "";
		var r = document.getElementById("buyer_name").value;
		if (r.length < 4) n += "- Bạn chưa nhập tên\n";
		var i = document.getElementById("buyer_mobile").value;
		if (i.length < 5) n += "- Bạn chưa nhập số di động\n";
		var s = document.getElementById("buyer_address").value;
		if (s.length < 10) n += "- Bạn chưa nhập địa chỉ";
		if (n != "") {
			alert(n);
			return false
		}
		return true
	}
}

function add_compare_product(e) {
	var t = document.getElementById("product_compare_list");
	if (t == "undefined" || t == null) {
		alert("Cần có biến product_compare_list trong template");
		return false
	}
	if (t.value == "") t.value = ",";
	var n = 0;
	if (t.value.length > 1) {
		current_list_id = t.value.split(",");
		n = current_list_id.length - 1
	}
	var r = document.getElementById("compare_box_" + e);
	var i = document.getElementById("text_compare_" + e);
	if (r.checked) {
		if (n > 6) {
			r.checked = "";
			alert("Bạn chỉ có thể so sánh tối đa 6 sản phẩm\nDanh sách đã có đủ 6")
		} else {
			document.getElementById("product_compare_list").value = t.value + e + ",";
			if (i != "undefined" && i != null) {
				i.innerHTML = "Chờ so sánh";
				i.style.backgroundColor = "#FFCC00"
			}
		}
	} else {
		document.getElementById("product_compare_list").value = t.value.replace("," + e + ",", ",");
		if (i != "undefined" && i != null) {
			i.innerHTML = "Chọn so sánh ";
			i.style.backgroundColor = "#FFF"
		}
	}
}

function compare_product() {
	var e = document.getElementById("product_compare_list");
	if (e == "undefined" || e == null) {
		alert("Cần có biến product_compare_list trong template");
		return false
	}
	var t = 0;
	if (e.value.length > 1) {
		current_list_id = e.value.split(",");
		t = current_list_id.length - 2
	}
	if (t > 1) {
		window.location = "/so-sanh?list=" + e.value
	} else {
		alert("Bạn cần chọn tối thiểu 2 sản phẩm để so sánh");
		return false
	}
}

function save_product_view_history(e) {
	if (!check_interger(e)) {
		return false
	}
	var t = "product_view_history";
	if (hura_read_cookie(t) == null) {
		hura_create_cookie(t, ",", 1)
	}
	var n = hura_read_cookie(t);
	if (n.search("," + e + ",") == -1) {
		var r = n + "," + e + ",";
		hura_create_cookie(t, r, 1)
	}
}

function remove_from_history(e) {
	if (confirm("Bạn chắc chắn muốn xóa sản phẩm này ?")) {
		if (!check_interger(e)) {
			return false
		}
		var t = "product_view_history";
		if (hura_read_cookie(t) == null) {
			hura_create_cookie(t, ",", 1)
		}
		var n = hura_read_cookie(t);
		if (n.search("," + e + ",") != -1) {
			var r = n.replace("," + e + ",", ",");
			hura_create_cookie(t, r, 1)
		}
		window.location = window.location
	}
}

function user_like_content(e, t, n) {
	$.post("/ajax/user_like.php", {
		item_id: e,
		content_type: t
	}, function(e) {
		if (e == "error-not-login") {
			if (confirm("Để sử dụng chức năng này bạn cần đăng nhập. Click OK để đăng nhập")) {
				window.location = "/dang-nhap?returnTo=" + window.location
			}
		} else if (e == "error") {
			alert("Bạn đã thực hiện rồi")
		} else {
			$("#" + n).html(e)
		}
	})
}

function user_vote_review(e, t) {
	$.post("/ajax/vote_product_review.php", {
		review_id: e,
		vote: t
	}, function(e) {
		if (e == "error-not-login") {
			if (confirm("Để sử dụng chức năng này bạn cần đăng nhập. Click OK để đăng nhập")) {
				window.location = "/dang-nhap?return_url=" + window.location
			}
		} else if (e == "error-has-voted") {
			alert("Bạn đã chọn rồi")
		} else {
			if (t == "dislike") {
				message = "Bạn không đồng ý với ý kiến này. Bạn có thể muốn viết ý kiến của mình không ?";
				if (confirm(message)) {
					var n = window.location;
					var r = encodeURI(n).replace("=review", "=write-review");
					if (r.search("=write-review") == -1) r += "?section=write-review";
					window.location = r
				}
			} else {
				alert("Cảm ơn bạn đã bày tỏ quan điểm")
			}
		}
	})
}

function check_discount(e, t, n) {
	if (e == "coupon") {
		$("#checking_discount_code").html("vui lòng đợi...");
		$.post("ajax/check_coupon.php", {
			code: t,
			order: n
		}, function(e) {
			var t = jQuery.parseJSON(e);
			if (t.error != "") {
				$("#checking_discount_code").html(t.error);
				$("#discount_code").val("")
			} else {
				var n = "";
				var r = 0;
				var i = document.getElementById("total_value").innerHTML;
				while (i.indexOf(".") > 0) {
					i = i.replace(".", "")
				}
				switch (t.type) {
					case "pro":
						n = t.content;
						break;
					case "cash":
						n = "Giảm " + writeStringToPrice(t.content + "") + " đ";
						r = parseInt(i) - parseInt(t.content);
						$("#total_value").html(writeStringToPrice(r + ""));
						break;
					case "priceoff":
						n = "Giảm " + t.content + "%";
						r = parseInt(i) * parseInt(100 - t.content) / 100;
						$("#total_value").html(writeStringToPrice(r + ""));
						break;
					case "other":
						n = t.content;
						break
				}
				$("#checking_discount_code").html(t.title + ": " + n);
				$("#discount_message").html(t.title + ": " + n)
			}
		})
	}
}

function loadAjaxContent(e, t) {
	if ($("#anchor_top").length > 0) {
		var n = $("#anchor_top").offset();
		var r = n.top;
		$("html, body").animate({
			scrollTop: r
		}, 500)
	}
	$("#" + e).load(t)
}
function change_captcha(e) {
	var t = (new Date).getTime();
	$("#" + e).attr("src", "/includes/captcha/captcha.php?v=" + t)
}

function user_cancel_order(e, t) {
	if (t != "new") {
		alert("Bạn chỉ hủy được đơn hàng chưa được xử lý. Vui lòng liên hệ bộ phận hỗ trợ của chúng tôi");
		return false
	}
	if (confirm("Bạn chắc chắn muốn hủy đơn hàng này ?")) {
		$.post("/ajax/user_account.php", {
			action: "cancel-order",
			order_id: e,
			status: t
		}, function(e) {
			alert("Bạn đã hủy đơn thành công !")
		})
	}
}

function user_vote_review(e, t) {
	$.post("/ajax/vote_product_review.php", {
		review_id: e,
		vote: t
	}, function(e) {
		if (e == "error-not-login") {
			if (confirm("Để sử dụng chức năng này bạn cần đăng nhập. Click OK để đăng nhập")) {
				window.location = "/dang-nhap?return_url=" + window.location
			}
		} else if (e == "error-has-voted") {
			alert("Bạn đã chọn rồi")
		} else {
			if (t == "dislike") {
				message = "Bạn không đồng ý với ý kiến này. Bạn có thể muốn viết ý kiến của mình không ?";
				if (confirm(message)) {
					var n = window.location;
					var r = encodeURI(n).replace("=review", "=write-review");
					if (r.search("=write-review") == -1) r += "?section=write-review";
					window.location = r
				}
			} else {
				alert("Cảm ơn bạn đã bày tỏ quan điểm")
			}
		}
	})
}


var Base64 = {
	_keyStr: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
	encode: function(e) {
		var t = "";
		var n, r, i, s, o, u, a;
		var f = 0;
		e = Base64._utf8_encode(e);
		while (f < e.length) {
			n = e.charCodeAt(f++);
			r = e.charCodeAt(f++);
			i = e.charCodeAt(f++);
			s = n >> 2;
			o = (n & 3) << 4 | r >> 4;
			u = (r & 15) << 2 | i >> 6;
			a = i & 63;
			if (isNaN(r)) {
				u = a = 64
			} else if (isNaN(i)) {
				a = 64
			}
			t = t + this._keyStr.charAt(s) + this._keyStr.charAt(o) + this._keyStr.charAt(u) + this._keyStr.charAt(a)
		}
		return t
	},
	decode: function(e) {
		var t = "";
		var n, r, i;
		var s, o, u, a;
		var f = 0;
		e = e.replace(/[^A-Za-z0-9\+\/\=]/g, "");
		while (f < e.length) {
			s = this._keyStr.indexOf(e.charAt(f++));
			o = this._keyStr.indexOf(e.charAt(f++));
			u = this._keyStr.indexOf(e.charAt(f++));
			a = this._keyStr.indexOf(e.charAt(f++));
			n = s << 2 | o >> 4;
			r = (o & 15) << 4 | u >> 2;
			i = (u & 3) << 6 | a;
			t = t + String.fromCharCode(n);
			if (u != 64) {
				t = t + String.fromCharCode(r)
			}
			if (a != 64) {
				t = t + String.fromCharCode(i)
			}
		}
		t = Base64._utf8_decode(t);
		return t
	},
	_utf8_encode: function(e) {
		e = e.replace(/\r\n/g, "\n");
		var t = "";
		for (var n = 0; n < e.length; n++) {
			var r = e.charCodeAt(n);
			if (r < 128) {
				t += String.fromCharCode(r)
			} else if (r > 127 && r < 2048) {
				t += String.fromCharCode(r >> 6 | 192);
				t += String.fromCharCode(r & 63 | 128)
			} else {
				t += String.fromCharCode(r >> 12 | 224);
				t += String.fromCharCode(r >> 6 & 63 | 128);
				t += String.fromCharCode(r & 63 | 128)
			}
		}
		return t
	},
	_utf8_decode: function(e) {
		var t = "";
		var n = 0;
		var r = c1 = c2 = 0;
		while (n < e.length) {
			r = e.charCodeAt(n);
			if (r < 128) {
				t += String.fromCharCode(r);
				n++
			} else if (r > 191 && r < 224) {
				c2 = e.charCodeAt(n + 1);
				t += String.fromCharCode((r & 31) << 6 | c2 & 63);
				n += 2
			} else {
				c2 = e.charCodeAt(n + 1);
				c3 = e.charCodeAt(n + 2);
				t += String.fromCharCode((r & 15) << 12 | (c2 & 63) << 6 | c3 & 63);
				n += 3
			}
		}
		return t
	}
};
if (window.top !== window.self) window.top.location.replace(window.self.location.href);
$(document).ready(function() {
    countShoppingCart("shopping_cart_store")

})