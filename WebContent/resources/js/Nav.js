//https://github.com/Ryanmufasa/awesomePlace/issues/27 작성자: 이명진

		var ssAdminPage = (sessionStorage.getItem("adminPage")=="null") ? false : true;
		var ssMyPage = (sessionStorage.getItem("myPage")=="null") ? false : true;
		var ssHostingPage = (sessionStorage.getItem("hostingPage")=="null") ? false : true;

$("document").ready(function(){
			if(!ssAdminPage && !ssMyPage && !ssHostingPage){ // 내비게이션 노출여부 결정
				$(".nav").attr("hidden", true);
				$(".navLine").attr("hidden", true);
				$("#adminNav").attr("hidden", true);
				$("#myPageNav").attr("hidden", true);
				$("#hostingPageNav").attr("hidden", true);
				$("hr").css("background-color","#6EE0FF");
				$(".navLine").css("background-color","#6EE0FF");
			}else if(ssAdminPage){
				$(".nav").attr("hidden", false);
				$(".navLine").attr("hidden", false);
				$("#adminNav").attr("hidden", false);
				$("#myPageNav").attr("hidden", true);
				$("#hostingPageNav").attr("hidden", true);
				$("hr").css("background-color","#6A5ACD");
				$(".navLine").css("background-color","#6A5ACD");
			}else if(ssMyPage){
				$(".nav").attr("hidden", false);
				$(".navLine").attr("hidden", false);
				$("#adminNav").attr("hidden", true);
				$("#myPageNav").attr("hidden", false);
				$("#hostingPageNav").attr("hidden", true);
				$("hr").css("background-color","#FF8200");
				$(".navLine").css("background-color","#FF8200");
			}else if(ssHostingPage){
				$(".nav").attr("hidden", false);
				$(".navLine").attr("hidden", false);
				$("#adminNav").attr("hidden", true);
				$("#myPageNav").attr("hidden", true);
				$("#hostingPageNav").attr("hidden", false);
				$("hr").css("background-color","#84FB84");
				$(".navLine").css("background-color","#84FB84");
			}
				hash();
});

function hash(){
			if(!window.location.hash){
				window.location = window.location + "#loaded";
				window.location.reload();
			}
}

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