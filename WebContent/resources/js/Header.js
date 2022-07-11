/* https://github.com/Ryanmufasa/awesomePlace/issues/9 | 작성자 이명진 */

	//체크인, 체크아웃 인풋창의 min값 설정함수
	$(document).ready(function(){
		var ssId = (sessionStorage.getItem("mem_id")=="null") ? false : true;
		var ssShowAdmin = (sessionStorage.getItem("showAdmin")=="null") ? false : true;
		var ssAdminPage = (sessionStorage.getItem("adminPage")=="null") ? false : true;
		var ssMyPage = (sessionStorage.getItem("myPage")=="null") ? false : true;
		var ssHostingPage = (sessionStorage.getItem("hostingPage")=="null") ? false : true;
			
			if(ssId && ssShowAdmin){ //버튼 노출여부 결정
				$("#btnLogin").attr("hidden", true);
				$("#btnJoin").attr("hidden", true);
				$("#btnMyPage").attr("hidden", true);
				$("#btnMyHosting").attr("hidden", true);
				$("#btnLogout").attr("hidden", false);
				$("#btnAdmin").attr("hidden", false);
				if(!ssAdminPage){
					$("#btnAdmin").text("관리자페이지");
				}else if(ssAdminPage){
					$("#btnAdmin").text("사용자페이지");
					
				}
			}else if(ssId){
				$("#btnAdmin").attr("hidden", true);
				$("#btnLogin").attr("hidden", true);
				$("#btnJoin").attr("hidden", true);
				$("#btnMyHosting").attr("hidden", false);
				$("#btnMyPage").attr("hidden", false);
				$("#btnLogout").attr("hidden", false);
			}else if(!ssId){
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
			$("#btnAdmin").on("click",(function(){
				if(!ssAdminPage){
					location.assign("adminIn.do");
				}else{
					location.assign("adminOut.do");
				}
			}));
			/*$("#btnMyHosting").on("click",(function(){
				if(ssId){
					location.assign("myHosting.do");
				}else{
					location.assign("loginform.do");
				}
			}));*/
			$("#btnMyPage").on("click",(function(){
					location.assign("MyPage.do");
			}));
			$("#btnLogin").on("click",(function(){
				location.assign("loginform.do");
			}));
			$("#btnJoin").on("click",(function(){
				location.assign("joinForm.do");
			}));
			$("#img1").on("click",(function(){
				if(ssAdminPage){
					location.assign("adminIn.do");
				}else{
					location.assign("main.do");
				}
			}));
			$("#list").on("click",(function (){
				location.assign("QnAList.do");
			}));

			/* 아래는 footer 버튼*/
			
			$("#toTop").on("click",(function(){
				$(window).scrollTop(0);
			}));
			
			
			$("#csCenter").on("click",(function(){
				if(ssId){
					location.assign("MyAskForm.do");
				}else{
					location.assign("loginform.do");
				}
			}));
		
			var mainBottom = $("#counter").offset().top; //메인 div 높이 반응형설정
			$(".mainDiv, .mainDiv-image, .nav").css("height",mainBottom-140);
			$(".navLine").css("height",mainBottom-140);
			
			
		});
		
		$(window).on("scroll", function (){ //네비게이션바가 스크롤을 따라다니도록 설정
			var ySC = $(window).scrollTop();
			var upperW = $(".mainDiv").width();
			var mainDivTop = $(".mainDiv").offset().top;
			if(mainDivTop<=ySC){
				$(".upperNav").css("position", "fixed");
				$(".upperNav").css("width", upperW);
			}else{
				$(".upperNav").css("position", "absolute");
				$(".upperNav").css("width", "100%");
			}
		});
		
		$(window).on("resize", function(){
			var upperW = $(".mainDiv").width();
			$(".upperNav").css("width", upperW);
		});
		
		

	// 목적지, 로그인여부(세션 아이디 존재여부), 마이페이지 비밀번호 재확인 여부 를 받아 각 상황에 맞게 페이지 분배하는 함수
	function flip() { //select 옵션에 따른 입력창 노출여부 함수
		var $guestCntIdx = $("#guestCnt option:selected").val();
		if($guestCntIdx == "other"){
			$("#optionInput").prop("type","text");
				
			$("#optionInput").keypress(function(e) { // 노출된 입력창에 숫자 외 값 입력못하게하는 함수
				var keyRes = e.which;
					if($("#optionInput").val().length == 0){ // 1째 자리는 1~9
						if((48 < keyRes && keyRes < 58) || keyRes == 13) {
						}	else{
							e.preventDefault();
						}
					}else if($("#optionInput").val().length == 1){ // 2째 자리는 0~9
						if((47 < keyRes && keyRes < 58) || keyRes == 13) {
						}	else{
							e.preventDefault();
						}
					}else if(13 != keyRes){ // 3째자리부턴 쓸 수 없음
						e.preventDefault();
					}
			});
		}else{
			$("#optionInput").prop("type","hidden");
		}
	}
	
	
	function tagSearch(num,name){
		// alert(num)
		// alert(name)
	var url = "tagSearch.do?num="+num+"&name="+name;
	//var url = "tagSearch.do?idx="+idx;
	location.href=url;
	}

	
	function LScroll(){
		$(".CD").animate({
			scrollLeft: "-=250px"
		}, 300);
	}
	function RScroll(){
		$(".CD").animate({
			scrollLeft: "+=250px"
		}, 300);
	}