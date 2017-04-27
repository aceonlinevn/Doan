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