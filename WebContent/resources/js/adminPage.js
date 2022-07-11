// https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자 : 이명진

$(document).ready(function(){
	pagingResize();
});

$(window).on("resize", function(){
	pagingResize();
});

function scopeColor(steadyRowCnt){
	if(steadyRowCnt == 10){
		$("#scope10").css("background-color","#6A5ACD" );
		$("#scope10").css("color","white" );
	}else if(steadyRowCnt == 20){
		$("#scope20").css("background-color","#6A5ACD" );
		$("#scope20").css("color","white" );
	}else if(steadyRowCnt == 50){
		$("#scope50").css("background-color","#6A5ACD" );
		$("#scope50").css("color","white" );
	}
}

function scopeClickMem(idx, steadyRowCnt){
	location.assign("memberList.do?pageIdx="+idx+"&steadyRowCnt="+steadyRowCnt);
}
function scopeClickHost(idx, steadyRowCnt){
	location.assign("hostingList.do?pageIdx="+idx+"&steadyRowCnt="+steadyRowCnt);
}
function scopeClickQnA(idx, steadyRowCnt){
	location.assign("QnAList.do?pageIdx="+idx+"&steadyRowCnt="+steadyRowCnt);
}

function pagingResize(){
	var pagingWidth = ($(".paging").width())/2;
	var mainWidth = ($(".mainDiv-child").width())/2;
	var resWidth = mainWidth - pagingWidth;
	$(".paging").css("left", resWidth);
};

function memDetail(idx) { // 멤버 상세정보페이지로 진입하는 컨트롤러로 연결
		var url = "memberDetail.do?idx="+idx;
		var name = "memDetail";
		var opt = "left=calc(50% - 175px), top=calc(50% - 150px), width = 450px, height = 450px, margin:auto";
		
		window.open(url, name, opt);
	}
	
function memHostList(idx) { // 멤버가 보유하고있는 호스트목록 확인페이지로 진입하는 컨트롤러로 연결
		var url = "memberHostList.do?idx="+idx;
		var name = "memHostList";
		var opt = "left=calc(50% - 400px), top=calc(50% - 250px), width = 800px, height = 800px";
		
		window.open(url, name, opt);
}

function switchSign(idx, flag) { // sign 상태 변경 후 멤버 상세정보페이지로 재진입하는 컨트롤러로 연결
		var url = "switchSign.do?idx="+idx+"&flag="+flag;
		if(flag == "Y"){
			var queue = window.confirm("회원 비활성화를 진행하십니까?");
			if(queue)
				location.href=url;
		}else if(flag == "N"){
			var queue = window.confirm("회원을 다시 활성화 하십니까?");
			if(queue)
				location.href=url;
		}
//		$.ajax({
//				type:"GET",
//				url:"memUnavailable.do",
//				data: {idx},
//				success: alert("회원 비활성화 성공"),
//				error: (log)=>{alert("실패"+log)}
//			})
}


function memberDelete(idx){
	var url = "memberDelete.do?idx="+idx;
	var queue = window.confirm("회원정보가 영구히 삭제됩니다. 진행하시겠습니까?");
			if(queue)
				location.href=url;	
}

/////////////////////////////////////// 멤버리스트 관련 함수 끝 //////////////////////////////////////////

// https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자 : 이명진
function hostDetail(idx) { // 호스트 상세정보페이지로 진입하는 컨트롤러로 연결
	var url = "hostDetail.do?idx="+idx;
	var name = "hostDetail";
	var opt = "left=calc(50% - 400px), top=calc(50% - 250px), width = 800px, height = 800px";
	
	window.open(url, name, opt);
}

function switchHostSign(idx, flag) { // sign 상태 변경 후 호스트 상세정보페이지로 재진입하는 컨트롤러로 연결
		var url = "switchHostSign.do?idx="+idx+"&flag="+flag;
		if(flag == "true"){
			var queue = window.confirm("호스트를 다시 비활성화 하십니까?");
			if(queue)
				location.href=url;
		}else if(flag == "false"){
			var queue = window.confirm("호스트 활성화를 진행하십니까?");
			if(queue)
				location.href=url;
		}
}

function openerReload(){ // 팝업창 닫을때 부모창 새로고침
	window.opener.location.reload();
	window.close();
}

function memListPaging(idx){
	memberList.do
}

////////////////////////////////////// 호스트리스트 관련 함수 끝 /////////////////////////////////////////