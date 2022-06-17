/* https://github.com/Ryanmufasa/awesomePlace/issues/9 | 작성자 이명진 */

	//체크인, 체크아웃 인풋창의 min값 설정함수
	$(document).ready(function(){
		var date = new Date();
		var year = date.getFullYear();
		var month = (date.getMonth()+1)>9 ? date.getMonth()+1 : "0"+(date.getMonth()+1);
		var day = date.getDate();
		
 		var today = year + "-" + month + "-" + day;
 		
		var ssId = sessionStorage.getItem("id");
		var ssDoubleCheck = (sessionStorage.getItem("doubleCheck"))==null ? false : true;
		var ssAdminPage = (sessionStorage.getItem("adminPage"))==null ? false : true;
		var ssMyPage = (sessionStorage.getItem("myPage"))==null ? false : true;
		var ssHostingPage = (sessionStorage.getItem("hostingPage"))==null ? false : true;
		
		$("#checkIn").attr("min",today);
		
		$("#checkIn").on("change", function(){ // 출발일자, 도착일자의 선택불가항목 결정
			var checkInDay = $("#checkIn").val();
			$("#checkOut").attr("min",checkInDay);
			$("#checkOut").attr("disabled",false);
		});
			
			// 버튼 onclick 결과 결정
			$("#btnLogout").on("click",(function(){
				location.assign('logout.do');
			}));
			$("#btnAdminIn").on("click",(function(){
				if(!ssAdminPage){
					location.assign('Admin.do');
					sessionStorage.setItem("ssAdminPage", true);	
				}else{
					location.assign('Main.do');
					sessionStorage.removeItem("ssAdminPage");
				}
			}));
			$("#btnMyHosting").on("click",(function(){
				if(ssDoubleCheck){
					location.assign('myHosting.do');
					sessionStorage.setItem("ssHostingPage", true);
				}else{
					location.assign('doubleCheck.do');
				}
			}));
			$("#btnMyPage").on("click",(function(){
				if(ssDoubleCheck){
					location.assign('myPage.do');
					sessionStorage.setItem("ssMyPage", true);
				}else{
					location.assign('doubleCheck.do');
				}
			}));
			$("#btnLogin").on("click",(function(){
				location.assign('loginForm.do');
			}));
			$("#btnJoin").on("click",(function(){
				location.assign('joinForm.do');
			}));
			$("#img1").on("click",(function(){
				if(ssAdminPage){
					location.assign('Admin.do');
				}else{
					location.assign('Main.do');
					sessionStorage.removeItem("ssAdminPage");
					sessionStorage.removeItem("ssMyPage");
					sessionStorage.removeItem("ssHostingPage");
				}
			}));
			
			if(!ssAdminPage && !ssMyPage && !ssHostingPage){ // 내비게이션 노출여부 결정
				$("#adminNav").hide();
				$("#adminNav").hide();
			}else if(ssAdminPage){
				$("#adminNav").hide();
			}else if(ssMyPage){
				$("#adminNav").hide();
			}else if(ssHostingPage){
				$("#adminNav").hide();
			}
			
			if(ssId != null && ssId == "admin"){ //버튼 노출여부 결정
				$("#btnLogin").hide();
				$("#btnJoin").hide();
				$("#btnMyPage").hide();
				$("#btnMyHosting").hide();
				$("#btnLogout").show();
				$("#btnAdminIn").show();
				if(!ssAdminPage){
					$("#btnAdmin").text("관리자페이지");
					$("#searchBar").show();
				}else{
					$("#btnAdmin").text("사용자페이지");
					$("#searchBar").hide();
				}
			}else if(ssId != null){
				$("#btnAdmin").hide();
				$("#btnLogin").hide();
				$("#btnJoin").hide();
				$("#btnMyHosting").show();
				$("#btnMyPage").show();
				$("#btnLogout").show();
			}else if(ssId == null){
				$("#btnAdmin").hide();
				$("#btnLogin").show();
				$("#btnJoin").show();
				$("#btnMyHosting").show();
				$("#btnMyPage").hide();
				$("#btnLogout").hide();
			}
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