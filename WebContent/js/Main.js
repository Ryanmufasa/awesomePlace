/* https://github.com/Ryanmufasa/awesomePlace/issues/6 | 작성자 이명진 */

	jQuery(function() {
	    var rolling_time = 5000;
	    var effect_time = 1000;
	 
	    var $rolling_img = $(".mainDiv-child > img");
	    $rolling_img.not(":first").hide();
	 
	    setInterval(rolling, rolling_time);
	 
	    function rolling()
	    {
	        $visible_img = $rolling_img.filter(":visible");
	        $visible_img.fadeOut(effect_time);
	 	
	        $next_img = $visible_img.next();
	        if ($next_img.length === 0) {
	            $next_img = $rolling_img.filter(":first");
	        }
	        $next_img.fadeIn(effect_time);
	    }
	});