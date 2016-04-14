jQuery(document).ready(function($){  
	$(window).scroll(function(){
		if (jQuery(this).scrollTop() > 110) {
			$('.navbar').addClass('fixed');
			
          	} 
          	else {
          	$('.navbar').removeClass('fixed');
          	
          	}
		/*if (jQuery(this).scrollTop() > 110) {
			$('.navbar-header > div').css('display', 'inline');
          	} 
          	else {
          	$('.navbar-header > div').css('display', 'none');
          	}
         */
         
    });
	 /*
	var descriptionHeight = $(".w-description").height();
    var imageHeight = ( $(".w-thumb_large").height() );
    
    if (imageHeight > descriptionHeight) {
        $(".w-description").css( 'min-height', imageHeight);
    };
    
    
    
    
    var authorHeight = $(".w-author").height();
    var titleHeight = ( $(".w-title").height() );
    
    if (titleHeight > authorHeight) {
        $(".w-author").css( 'min-height', titleHeight);
    };
    */
});