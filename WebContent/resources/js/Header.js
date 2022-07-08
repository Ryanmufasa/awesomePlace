/* https://github.com/Ryanmufasa/awesomePlace/issues/9 | 작성자 이명진 */

	//체크인, 체크아웃 인풋창의 min값 설정함수
	$(document).ready(function(){

		var ssId = sessionStorage.getItem("id");
		var ssDoubleCheck = (sessionStorage.getItem("doubleCheck"))==null ? false : true;
		var ssAdminPage = (sessionStorage.getItem("adminPage"))==null ? false : true;
		var ssMyPage = (sessionStorage.getItem("myPage"))==null ? false : true;
		var ssHostingPage = (sessionStorage.getItem("hostingPage"))==null ? false : true;

			if(ssId != null && ssId == "admin"){ //버튼 노출여부 결정
				$("#btnLogin").attr("hidden", true);
				$("#btnJoin").attr("hidden", true);
				$("#btnMyPage").attr("hidden", true);
				$("#btnMyHosting").attr("hidden", true);
				$("#btnLogout").attr("hidden", false);
				$("#btnAdminIn").attr("hidden", false);
				if(!ssAdminPage){
					$("#btnAdmin").text("관리자페이지");
					$("#searchBar").attr("hidden", false);
				}else{
					$("#btnAdmin").text("사용자페이지");
					$("#searchBar").attr("hidden", true);
				}
			}else if(ssId != null){
				$("#btnAdmin").attr("hidden", true);
				$("#btnLogin").attr("hidden", true);
				$("#btnJoin").attr("hidden", true);
				$("#btnMyHosting").attr("hidden", false);
				$("#btnMyPage").attr("hidden", false);
				$("#btnLogout").attr("hidden", false);
			}else if(ssId == null){
				$("#btnAdmin").attr("hidden", true);
				$("#btnLogin").attr("hidden", false);
				$("#btnJoin").attr("hidden", false);
				$("#btnMyHosting").attr("hidden", false);
				$("#btnMyPage").attr("hidden", true);
				$("#btnLogout").attr("hidden", true);
			}
			
			// 버튼 onclick 결과 결정
			$("#btnLogout").on("click",(function(){
				location.assign("logout.do");
			}));
			$("#btnAdminIn").on("click",(function(){
				if(!ssAdminPage){
					location.assign("Admin.do");
				}else{
					location.assign("/awesomePlace/");
				}
			}));
			$("#btnMyHosting").on("click",(function(){
				if(ssId != null && ssDoubleCheck){
					location.assign("myHosting.do");
					sessionStorage.setItem("ssHostingPage", true);
					sessionStorage.removeItem("ssAdminPage");
					sessionStorage.removeItem("ssMyPage");
				}else if(ssId != null){
					location.assign("doubleCheck.do");
				}else{
					alert("로그인이 필요한 서비스 입니다");
					location.assign("/awesomePlace/login/loginForm.do");
				}
			}));
			$("#btnMyPage").on("click",(function(){
				if(ssDoubleCheck){
					location.assign("myPage.do");
					sessionStorage.setItem("ssMyPage", true);
					sessionStorage.removeItem("ssAdminPage");
					sessionStorage.removeItem("ssHostingPage");
				}else{
					location.assign("doubleCheck.do");
				}
			}));
			$("#btnLogin").on("click",(function(){
				location.assign("/awesomePlace/login/loginForm.do");
			}));
			$("#btnJoin").on("click",(function(){
				location.assign("joinForm.do");
			}));
			$("#img1").on("click",(function(){
				if(ssAdminPage){
					location.assign("Admin.do");
				}else{
					location.assign("/awesomePlace/");
					sessionStorage.removeItem("ssAdminPage");
					sessionStorage.removeItem("ssMyPage");
					sessionStorage.removeItem("ssHostingPage");
				}
			}));
			
			/* 아래는 footer 버튼*/
			
			$("#toTop").on("click",(function(){
				$(window).scrollTop(0);
			}));
			
			if(ssId != null && ssDoubleCheck){ // 조건에 따른 버튼 목적지 설정
					$("#csCenter").attr("href", "csCenter.do");
				}else if(ssId != null){
					$("#csCenter").attr("href", "doubleCheck.do");
				}else{
					$("#csCenter").attr("href", "/awesomePlace/login/loginForm.do");
				}
			
			$("#csCenter").on("click",(function(){
				if(ssId != null && ssDoubleCheck){
					sessionStorage.setItem("ssMyPage", true);
					sessionStorage.removeItem("ssAdminPage");
					sessionStorage.removeItem("ssHostingPage");
				}else if(ssId != null){
					location.assign("doubleCheck.do");
				}else{
					location.assign("/awesomePlace/login/loginForm.do");
				}
			}));
			
			
			
			var mainBottom = $("#counter").offset().top; //메인 div 높이 반응형설정
			$(".mainDiv, .mainDiv-image, .nav").css("height",mainBottom-140);
			$(".navLine").css("height",mainBottom-140);
			
			
			
		});
		
		$(window).on("scroll", function (){ //네비게이션바가 스크롤을 따라다니도록 설정
			var ySC = $(window).scrollTop();
			console.log(ySC);
			var mainDivTop = $(".mainDiv").offset().top;
			if(mainDivTop<=ySC){
				$(".upperNav").css("position", "fixed");
			}else{
				$(".upperNav").css("position", "absolute");
			}
		});
