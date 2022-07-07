/**
 * 
 */
	// 테스트 페이지 addNewHostFormP
	
$(function(){
	
	$('#host_tel').on("keyup", function(){
		var tel = $(this).val();
		tel = autoHypenTel(tel);
		$(this).val(tel);
	});
	
	$('#weekday_amt').on("keyup", function(){ // 금액 단위 , 찍기 (정규식 활용) 
		var wda = $(this).val().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
		$(this).val(wda);
	});
	
	$('#weekend_amt').on("keyup", function(){
		var wea = $(this).val().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
		$(this).val(wea);
	});
	

	
	
});
// 우편번호 검색시 // 다음 우편번호 서비스 api 
function sample6_execDaumPostcode(){
	new daum.Postcode({
		oncomplete : function(data){
			 // 팝업에서 검색 결과 항목을 클릭했을 때 실행될 내용
			 
			 // 주소 조합 ( 공백 기준으로 나눔 )
			 var addr = '';  // 주소 
			 var extraAddr = ''; // 상세주소 
			 
			 // 사용자가 선택한 주소 타입에 따라 해당 주소값을 가져옴 
			 if(data.userSelectedType === 'R'){ // 도로명 주소 선택시 
				//alert("data.roadAddress : " + data.roadAddress); 
				addr = data.roadAddress;
				//alert("addr : " + addr);
			 	
			 }else { // 지번주소 선택시 
				 addr = data.jibunAddress;
			 }
			 
			 // 선택한 주소가 도로명 타입일때 참고항목 조합 
			 if( data.userSelectedType === 'R'){
				 
				 // 법정동명이 있을 경우 
				 if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					 extraAddr += data.bname;
				 }
				 
				 // 건물명이 있고 공동주택일때 
				 if(data.buildingName !== '' && data.apartment === 'Y'){
					 extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				 }
				 
				 // 표시할 참고 항목이 있을 경우 괄호까지 추가한 최중 문자열 생성
				 if(extraAddr !== '') {
					 extraAddr = ' (' + extraAddr + ')';
				 }
				 
				 // 조합된 참고 항목을 해당 필드에 입력
				 document.getElementById('sample6_extraAddress').value = extraAddr;
				 	
			 } else {
				 document.getElementById('sample6_extraAddress').value = '';
			 }
			 
			 
			 // 우편번호와 주소 정보를 해당 필드에 입력 
			 document.getElementById('sample6_postcode').value = data.zonecode;
			 document.getElementById('sample6_address').value = addr;
			 
			 // 커서를 상세 주소 필드로 이동
			 document.getElementById('sample6_detailAddress').focus();
			
		}
	}).open();
}

// 방 개수 입력시
function changeRoomCnt(){
	
	var selVal = $('#room_cnt_1').val();
	
	if(selVal == 0 ){ // 직접입력 선택시 
		document.getElementById('room_cnt_2').style.visibility='visible';
	}else{
		document.getElementById('room_cnt_2').style.visibility='hidden';
	}
	
}


// 호스트 전화번호 입력시
function autoHypenTel(tel){
	var tmp = '';
	
	if(tel.length < 4){
		return tel;
	} else if(tel.length < 7){
		tmp += tel.substr(0,3);
		tmp += '-';
		tmp += tel.substr(3);
		return tmp;
	} else if(tel.length < 11){
		tmp += tel.substr(0,3);
		tmp += '-';
		tmp += tel.substr(3,3);
		tmp += '-';
		tmp += tel.substr(6);
		return tmp;
	} else {
		tmp += tel.substr(0,3);
		tmp += '-';
		tmp += tel.substr(3,4);
		tmp += '-';
		tmp += tel.substr(7);
		return tmp;
	}
	
}

//등록신청 버튼 클릭시 - 테스트 폼
/*function checkHost(f){
	
	if(f.host_name.value == ""){
		f.host_name.focus();
	}else if(f.host_post_num.value == ""){
		alert("주소 입력을 확인해주세요!");
		f.host_post_num.focus();
	}else if(f.host_addr2.value == ""){
		alert("상세 주소를 입력해주세요!");
		f.host_addr2.focus();
	}else if(f.host_tel.value == ""){
		f.host_tel.focus();
	}else if(f.guest_cnt.value == ""){
		f.guest_cnt.focus();
	}else if(f.weekday_amt.value == ""){
		f.weekday_amt.focus();
	}else if(f.weekend_amt.value == ""){
		f.weekend_amt.focus();
	}else if(f.host_content.value == ""){
		f.host_content.focus();
	}else {

		f.submit();
	}
}*/

// 객실 추가 버튼 클릭시 - 테스트 폼 addNewHostFormP.jsp
function addRow(){
	
	
	const table = document.getElementById('addRow');
	
	const newRow = table.insertRow();
	
/*	const newCell0 = newRow.insertCell(0);
	const newCell1 = newRow.insertCell(1);
	const newCell2 = newRow.insertCell(2);	
	const newCell3 = newRow.insertCell(3);*/
	
		
	const newCell0 = newRow.insertCell();
	newCell0.innerHTML = '<input type="text" name="room_name" placeholder="ex)101호, 커플방, 가족방" required>';
	const newCell1 = newRow.insertCell();
	newCell1.innerHTML = "<input type=text name=guest_cnt min=1 onkeyup=this.value=this.value.replace(/[^0-9]/g,'') required> 명 ";
	const newCell2 = newRow.insertCell();
	newCell2.innerHTML = "<input type=text id=weekday_amt name=week_day_amt onkeyup=this.value=this.value.replace(/[^0-9]/g,'') required> 원 ";
	const newCell3 = newRow.insertCell();
	newCell3.innerHTML = "<input type=text id=weekend_amt name=week_end_amt onkeyup=this.value=this.value.replace(/[^0-9]/g,'') required> 원 ";
	
}