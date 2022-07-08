/* https://github.com/Ryanmufasa/awesomePlace/issues/6 | 작성자 이명진 */

	jQuery(function() {
	    var changeTerm = 5000;//ms
	    var fadingTime = 500;//ms
	 
	    var $targetImg = $(".mainDiv-image > img");
	    $targetImg.not(":first").hide();
	 
	    setInterval(change, changeTerm);
	 
	    function change()
	    {
	        $visibleImg = $targetImg.filter(":visible");
	        $visibleImg.fadeOut(fadingTime);
	 	
	        $nextImg = $visibleImg.next();
	        if ($nextImg.length === 0) {
	            $nextImg = $targetImg.filter(":first");
	        }
	        $nextImg.fadeIn(fadingTime);
	    }
	});