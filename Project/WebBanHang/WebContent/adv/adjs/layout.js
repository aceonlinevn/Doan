$(document).ready(function(){
	$('.menu').find('li ul').parent().addClass('has-sub');
    $(".has-sub>a").click(function(){
        $(this).parent().find('.menuchild ').slideToggle();
		if($(this).hasClass('active')){		
			$(this).removeClass('active');
		}
		else
		{
			$(this).addClass('active');
		}
    });
});