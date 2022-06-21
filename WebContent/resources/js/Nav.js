//https://github.com/Ryanmufasa/awesomePlace/issues/27 작성자: 이명진

		var ssId = sessionStorage.getItem("id");
		var ssDoubleCheck = (sessionStorage.getItem("doubleCheck"))==null ? false : true;
		var ssAdminPage = (sessionStorage.getItem("adminPage"))==null ? false : true;
		var ssMyPage = (sessionStorage.getItem("myPage"))==null ? false : true;
		var ssHostingPage = (sessionStorage.getItem("hostingPage"))==null ? false : true;

$("document").ready(function(){
				if(!ssAdminPage && !ssMyPage && !ssHostingPage){ // 내비게이션 노출여부 결정
				$(".navLine").attr("hidden", false);
				$("#adminNav").attr("hidden", true);
				$("#myPageNav").attr("hidden", false);
				$("#hostingPageNav").attr("hidden", true);
			}else if(ssAdminPage){
				$("#adminNav").attr("hidden", false);
				$("#myPageNav").attr("hidden", true);
				$("#hostingPageNav").attr("hidden", true);
			}else if(ssMyPage){
				$("#adminNav").attr("hidden", true);
				$("#myPageNav").attr("hidden", false);
				$("#hostingPageNav").attr("hidden", true);
			}else if(ssHostingPage){
				$("#adminNav").attr("hidden", true);
				$("#myPageNav").attr("hidden", true);
				$("#hostingPageNav").attr("hidden", false);
			}
});

$(window).on("scroll", function (){ //네비게이션바가 스크롤을 따라다니도록 설정
			var ySC = $(window).scrollTop();
			console.log(ySC);
			var mainDivTop = $(".mainDiv").offset().top;
			if(mainDivTop<=ySC){
				$("#adminNav,#myPageNav,#hostingPageNav").css("position", "fixed");
			}else{
				$("#adminNav,#myPageNav,#hostingPageNav").css("position", "absolute");
			}
		});