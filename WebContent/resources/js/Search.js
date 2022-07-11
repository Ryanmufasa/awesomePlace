/* https://github.com/Ryanmufasa/awesomePlace/issues/9 | 작성자 이명진 */

//체크인, 체크아웃 인풋창의 min값 설정함수
$(document).ready(function(){
	var date = new Date();
	var year = date.getFullYear();
	var month = (date.getMonth()+1)>9 ? date.getMonth()+1 : "0"+(date.getMonth()+1);
	var day = date.getDate();	
	var today = year + "-" + month + "-" + day;
	
	$("#checkIn").attr("min",today);
	
	
	 // 출발일자, 도착일자의 선택불가항목 결정 
	//  ->  체크인 날짜 선택시 체크아웃 날짜 자동으로 다음날짜 설정되도록 수정 -- 정다영
	var checkIn = document.getElementById('checkIn');
	
	checkIn.addEventListener('change', (event) =>{
		var checkInDay = $("#checkIn").val();
		if(checkInDay != ""){
			
			//alert("체크인 날짜 " + checkInDay);
			var chIn = new Date(checkInDay);
			//alert(chIn);
			var chOut = new Date(chIn.setDate(chIn.getDate()+1));
			//alert(chOut);
			
			year = chOut.getFullYear();
			//alert(year);
			month = (chOut.getMonth()+1)>9 ? chOut.getMonth()+1 : "0"+(chOut.getMonth()+1);
			//alert(month);
			day = chOut.getDate();
			var checkOutDay = year + "-" + month + "-" + day;
			
			//alert(checkOutDay);
			
			$("#checkOut").attr("min",checkOutDay);
			$('#checkOut').val(checkOutDay);
			$("#checkOut").attr("disabled",false);
			
		}else{
			$('#checkOut').val('');
			$('#checkOut').attr('disabled', true);
		}
		
		
	});
	
	// hostinfo.jsp 에서 날짜 선택시 
	//https://github.com/Ryanmufasa/awesomePlace/issues/25 -- 작성자 정다영
	$('#checkIn1').attr('min',today); 
		
	checkIn1.addEventListener('change', (event2)=>{
		var checkIn1 = $('#checkIn1').val();
		
		if(checkIn1 != ""){
			var ci = new Date(checkIn1);
			var co = new Date(ci.setDate(ci.getDate()+1));
			
			year = co.getFullYear();
			month = (co.getMonth()+1)>9 ? co.getMonth()+1 : "0"+(co.getMonth()+1);
			day = co.getDate();
			var checkOut1 = year + "-" + month + "-" + day;
			
			$("#checkOut1").attr("min", checkOut1);
			//$('#checkOut1').val(checkOut1);
			$('#checkOut1').attr('disabled', false);
		}else{
			$('#checkOut1').val('');
			$('#checkOut1').attr('disabled', true);
		}
		
	})

	
	
	var book = document.getElementById('book');
	
	book.addEventListener("click", (e)=>{
		var host_num = document.getElementById('host_num').value;
		//alert(host_num)
		var checkIn1 = $('#checkIn1').val();
		//alert(checkIn1)
		var checkOut1 = $('#checkOut1').val();
		//alert(checkOut1)
		var guestCnt = document.getElementById('guest_cnt').value;
		//alert(guestCnt);
		
		if(checkIn1 === "" || checkOut1 === ""){
			alert('체크인, 체크아웃 날짜 입력을 확인해주세요!');
		}else if(guestCnt === ""){
			alert('숙박 인원을 입력해주세요!');
			document.getElementById('guest_cnt').focus;
		}else{
			
			$.ajax({
				async : true,
				type : 'post',
				url : '/awesomePlace/myhosting/checkOrderOk.do',
				cache : false,
				data : {
					"host_num" : host_num,
					"checkIn1" : checkIn1,
					"checkOut1" : checkOut1
				},
				datatype : 'json',
				success : function(checkResult){
					//alert(checkResult);
					if(checkResult == 0){
						alert("예약 가능합니다");
					}else{
						alert("예약 불가합니다.");
					}
				},error : function(error){
					alert('에러 : ' + error);
				}
				
			})
		}
	})

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
