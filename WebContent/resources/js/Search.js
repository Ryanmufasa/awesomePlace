/* https://github.com/Ryanmufasa/awesomePlace/issues/9 | 작성자 이명진 */

//체크인, 체크아웃 인풋창의 min값 설정함수
$(document).ready(function(){
	var date = new Date();
	var year = date.getFullYear();
	var month = (date.getMonth()+1)>9 ? date.getMonth()+1 : "0"+(date.getMonth()+1);
	var day = date.getDate();	
	var today = year + "-" + month + "-" + day;
	
	$("#checkIn").attr("min",today);
	
	$("#checkIn").on("change", function(){ // 출발일자, 도착일자의 선택불가항목 결정
		var checkInDay = $("#checkIn").val();
		$("#checkOut").attr("min",checkInDay);
		$("#checkOut").attr("disabled",false);
	});

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



/* https://github.com/Ryanmufasa/awesomePlace/issues/25 -- 작성자 정다영
 */

function searchCheck(f){
	var checkIn = $('#checkIn').val();
	var checkOut = $('#checkOut').val();
	
	if(checkOut != ""){
		if( checkIn === "" ){
			alert('체크인 날짜를 선택해주세요!');
			f.checkIn.focus();
		}else {
			f.submit();
		}
	}else{
		f.submit();
	}
	
}