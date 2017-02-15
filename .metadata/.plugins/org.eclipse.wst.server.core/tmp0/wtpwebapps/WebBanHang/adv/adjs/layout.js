$(document).ready(function(){
	$('.menu').find('li ul').parent().addClass('has-sub');
    $(".has-sub").click(function(){
        $(this).find('.menuchild ').slideToggle();
    });
});