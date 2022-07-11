/* // https://github.com/Ryanmufasa/awesomePlace/issues/57 -- 작성자 정다영 
 * 호스트 예약 페이지에서 구동될 스크립트  
 */

// Search.js의 체크인, 체크아웃 설정함수를 통한 예약 설정 처리 기능 추가  
$(function(){
	
	var cin = document.getElementById('checkIn1');
	var cout = document.getElementById('checkOut1');
	
	$('#st').prop('hidden', true);
	$('#nd').prop('hidden', true);
	$('#cal').prop('hidden', true);
	
	var start_date;
	var end_date;
	var s;
	var e;
	var ms;
	var r;
	var s_date;
	var e_date;
	var s_index;
	var e_index;
	
	var st_prop;
	var nd_prop;
	
	cin.addEventListener('change', (event) =>{
		if(event.target.value === ""){
			alert('체크인 날짜를 입력해주세요')
			$('#start_date').text("");
			$('#st').prop('hidden', true);
			$('#total_date').text('');
			$('#tt').text('');
			$('#cal').prop('hidden', true)
		}else{
			//alert(event.target.value);
			$('#start_date').text(event.target.value);
			$('#st').prop('hidden', false);
			start_date = event.target.value;
			
			s = new Date(start_date);
			
			if(cin.value != "" && cout.value != ""){
				
				if(cin.value > cout.value){
					//alert("cin.value > cout.value");
					cout.value = null;
					cout.focus();
					$('#end_date').text("");
					$('#nd').prop('hidden', true);
					$('#total_date').text('');
					$('#tt').text('');
				}else if(cin.value == cout.value ){
					alert('같은 날짜를 입력할 수 없습니다! 날짜 입력을 확인해주세요');
					cin.value = null;
					cin.focus();
					$('#start_date').text("");
					$('#st').prop('hidden', true);
					$('#total_date').text('');
					$('#tt').text('');
				}else{
					ms = e.getTime() - s.getTime();
					//alert("ms1 : "+ms);
					r = ms/(1000 * 60 * 60 * 24);
					
					$('#total_date').text(r);
					$('#tDate').prop('value',r);
					s_date = getDate(s);
					e_date = getDate(e);
					$('#tt').text("박  (" +s_date+" ~ " + e_date + ")");
					
					s_index = getIndex(s_date);
					e_index = getIndex(e_date);
					
					// var t_amt = getAmt(r); 
					
					//$('#pay_amt').text(t_amt);
					
				}
				
			}
			nd_prop = $('#nd').prop('hidden');
			
			if(nd_prop){ // hidden 속성이 true 
				//alert("nd_prop1 : " + nd_prop);
				$('#cal').prop('hidden', true)
			}else if(nd_prop == false){
				//alert("nd_prop1 : " + nd_prop);
				$('#cal').prop('hidden', false);
			}
		}
	})
	
	
	
	cout.addEventListener('change', (event2) =>{
		if(event2.target.value === ""){
			alert('체크아웃 날짜를 입력해주세요');
			$('#end_date').text("");
			$('#nd').attr('hidden', true);
			$('#total_date').text('');
			$('#tt').text('');
		}else{
			//alert(event2.target.value)
			$('#end_date').text(event2.target.value);
			$('#nd').prop('hidden', false);
			end_date = event2.target.value;
			
			e = new Date(end_date);
			
			if(cin.value != "" && cout.value != ""){
				
				if(cin.value == cout.value){
					alert('같은 날짜를 입력할 수 없습니다! 날짜 입력을 확인해주세요');
					cout.value = null;
					cout.focus();
					$('#end_date').text("");
					$('#nd').prop('hidden', true);
					$('#total_date').text('');
					$('#tt').text('');
				}else{
					ms = e.getTime() - s.getTime();
					//alert("ms2 : "+ms);
					r = ms/(1000 * 60 * 60 * 24);
					
					$('#total_date').text(r);
					$('#tDate').prop('value',r);
					s_date = getDate(s);
					e_date = getDate(e);
					$('#tt').text("박  (" +s_date+" ~ " + e_date + ")");
					
					s_index = getIndex(s_date);
					e_index = getIndex(e_date);
					
					// var t_amt = getAmt(r); 
					
					//$('#pay_amt').text(t_amt);
					
				}
				
			}
		}
		
		nd_prop = $('#nd').prop('hidden');
		if(nd_prop){ // hidden 속성이 true 
			//alert("nd_prop2 : " + nd_prop);
			$('#cal').prop('hidden', true)
		}else if(nd_prop == false){
			//alert("nd_prop2 : " + nd_prop);
			$('#cal').prop('hidden', false);
		}
	})
	
	
	var cal = document.getElementById('cal');
	var d_amt;
	var e_amt;
	var total_pay_amt = 0;
	
	cal.addEventListener('click', (event3) => {
		
		//alert('예약 금액 계산 ');
		//alert(event3.target.value);
		
		var imsi = new Array();
		imsi = event3.target.value.split(',');
		
		d_amt = imsi[0];
		e_amt = imsi[1];
		//alert(d_amt);
		//alert(e_amt);
		
		var amt = [
			{ date:'일', amt:e_amt},
			{ date:'월', amt:d_amt},
			{ date:'화', amt:d_amt},
			{ date:'수', amt:d_amt},
			{ date:'목', amt:d_amt},
			{ date:'금', amt:d_amt},
			{ date:'토', amt:e_amt}];
			
		var tot = (d_amt * 5) + (e_amt * 2); //7박 숙박 요금
		//alert("7일 숙박시 금액"+tot);
		
		// 일,월,화,수,목,금,토 요일 배열 인덱스 번호 얻기
		s_index = getIndex(s_date);	 
		//alert("시작 요일 인덱스 : "+s_index);
		e_index = getIndex(e_date);
		//alert("종료 요일 인덱스 : "+e_index);
		
		ms = e.getTime() - s.getTime();
		r = ms/(1000 * 60 * 60 * 24);
		//alert("총 숙박 일수 : "+r); // 몇박인지 
		
		var i = parseInt(r/7); 
		var j = (r%7); 
		//alert("몇 주 : "  + i + ",  몇 일 : " + j) 
		
		// 요일에 따른 숙박 요금 계산
		// 1주 숙박 금액은 구해져있으므로 j 기준으로 계산. 
		if(j == 0){ // 7읠 배수 일자 예약일때 
			total_pay_amt = i*tot;
			//alert(i+"주 예약 금액 : " + total_pay_amt);
			
		}else { // j 가 0이 아닐때, 즉 6일 이하 값이 있을 경우
			var imsi_amt = 0;
			// 시작 요일이 종료 요일보다 인덱스 값이 클때
			if(s_index > e_index){ 
				
				// 종료 요일과 시작 요일 사이값을 더해서 7일 요금에서 빼기
				amt.map((obj, index) => {
				
					var imsi = {};
					imsi[obj.date] = obj.amt;
					
					if(index >= e_index && index < s_index){
						//alert("예외일자 금액 : "+index + "  "+ obj.amt);
						imsi_amt += parseInt(obj.amt);
						// 제외될 일자들의 금액 합하기
					}
				
				})
				//alert("1주 금액에서 빼야할 금액 : " + imsi_amt);
				imsi_amt = tot-imsi_amt;
				//alert("예약 일자 금액 : " + imsi_amt);
				// 일주일 숙박 요금에서 제외될 날짜 숙박 요금 빼기
				
				total_pay_amt = 0;
				total_pay_amt = imsi_amt + (i*tot);
				// 일자 금액에다가 주별 요금 더하기
				//alert("총 금액 : " + total_pay_amt);
			
			
			// 시작요일이 종료요일 인덱스 값보다 작을 경우 	
			}else{
				var imsi_amt = 0;
				// 시작요일과 종료요일 까지의 금액 구하기
				amt.map((obj, index) =>{
					
					var imsi = {};
					imsi[obj.date] = obj.amt;
					
					if(index >= s_index && index < e_index){
						//alert("예약 일자별 금액 : "+index + "  "+ obj.amt);
						imsi_amt += parseInt(obj.amt);
						// 시작일자부터 종료일자 전까지 금액 합하기
					}
				})
				
				//alert("예약 일자 금액 : " + imsi_amt);
				
				total_pay_amt = 0;
				total_pay_amt =imsi_amt + i*tot;
				// 구한 일자별 금액에다가 주별 요금 더하기 
				//alert("총 금액 : " + total_pay_amt)
				
			}
			
		}
		// 계산 금액 표시
		$('#pay_amt').text(total_pay_amt +'원');
		$('#total_pay_amt').prop('value', total_pay_amt);
		
		
	})

});
	

function getDate(dd){ // 날짜에 따른 요일 계싼
	
	var week = ['일','월','화','수','목','금','토'];
	
	var dayOfWeek = week[new Date(dd).getDay()];
	
	return dayOfWeek;
}

function getIndex(d){
	
	var week1 = ['일','월','화','수','목','금','토'];
	
	var indexOfdate = week1.findIndex(v => v === d);
	
	return indexOfdate;
}

	
function amtCheck(weekday, weekend){
	var weekday_amt = weekday;
	var weekend_amt = weekend;
	
	
	
}
	


function order(f){
	
	cinV = document.getElementById("checkIn1").value;
	coutV = document.getElementById("checkOut1").value;
	dateV = parseInt(document.getElementById('tDate').value);
	//alert(dateV);
	//alert(cinV);
	//alert(coutV);

	
	if(f.checkIn1.value === ""){
		alert('체크인 날짜를 선택해주세요!');
		f.checkIn1.focus();
		
	}else if(f.checkIn1.value != ""){
		if(f.checkOut1.value === ""){
			alert('체크아웃 날짜를 선택해주세요!')
			f.checkOut1.focus();
		}else{
			//alert('ㅇㅇ');
			if(confirm('체크인 일자 : ' + cinV +'\n' + '체크아웃 일자 : ' + coutV + '\n' 
					+ '예약 일수 : ' + dateV + ' 박 '+(dateV+1)+'일') == true ){ // + '금액 : '+ amt + '원'
				//alert('예약 신청화면으로 이동');
				f.submit();
			}
		}
		
	}
}


function addLike(f){
	
	alert('찜에 추가');
	f.attr('action', '/awesomePlace/mypage/mpreserinfofirst.do').submit();
	
}

/*	var dayAmt = document.getElementById('dayAmt');

	dayAmt = $('#dayAmt').val().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	$('#dayAmt').val(dayAmt);
	
	var endAmt = document.getElementById('endAmt');
	
	endAmt = $('#endAmt').val().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
	$('#endAmt').val(endAmt);*/

//$('#checkOut1').change(function(){
//	//alert(start_date);
//	//alert(end_date);
//	//s = new Date(start_date);
//   // e = new Date(end_date);
//	//alert(s); //Tue Jun 28 2022 09:00:00 GMT+0900 (한국 표준시)
//	//alert(e);
//    
//   // var ms = e.getTime() - s.getTime();
//   // var r = ms/(1000 * 60 * 60 * 24); // 일수 
//    
//   // alert(r + "박");
//    $('#total_date').text(r);
//    //$('#tt').removeAttr('hidden');
//    
//    
//    // 체크인 일자 요일 구하기
//    s_date = getDate(s);
//    e_date = getDate(e);
//    $('#tt').text("박  (" +s_date+" ~ " + e_date + ")");
//    //alert("시작일자 요일 : " + s_date);
//    //alert("종료일자 요일 : " + e_date);
//    //$('#tt').text("박  (" + getDate(s)+" ~ " + getDate(e1) + ")")
//    //alert(getIndex(s_date));
//    
//    //day_amt = $('#dayAmt').value; // 평일 이용 금액
//    //day_amt = document.getElementById('dayAmt').value;
//    //alert("평일 금액 : " + day_amt);
//    
//    //end_amt = $('#endAmt').value; // 주말 이용 금액 
//    //end_amt = document.getElementById('endAmt').value;
//    //alert("주말 금액 : " + end_amt);
//    
//    var t_amt = getAmt(r); // 총 금액
//   // alert("총 금액 : " + t_amt);
//    
//    $('#pay_amt').text(t_amt);
//    
//});
/*
function getAmt(){ // 예약 일수에 따른 총 비용 계산 
	var amt = [
		{ date:'일', amt:end_amt},
		{ date:'월', amt:day_amt},
		{ date:'화', amt:day_amt},
		{ date:'수', amt:day_amt},
		{ date:'목', amt:day_amt},
		{ date:'금', amt:day_amt},
		{ date:'토', amt:end_amt}
		]; 
	
	var s_index = getIndex(s_date);
	var e_index = getIndex(e_date);

	//total_amt = 0;
	
	var tot = (day_amt * 5) + (end_amt * 2); //7박 숙박 요금

	var i = r/7;
	var j = r%7;
	
	i = i*tot;
	
	if(j == 0){ // 7의 배수 일자 예약일때 
		total_amt = i;
		
	}else { // j <= 6 인 경우 
		
		if(s_index > e_index){ // 시작 요일이 종료 요일보다 인덱스 값이 클때
			
			amt.map((obj, index) => {
				
				var imsi = {};
				imsi[obj.date] = obj.amt;
				
				if(index > e_index && index < s_index){
					// 사이값을 더해서 전체 합한 값에서 빼기
					total_amt += obj.amt;
				}
				total_amt -= tot;
			})
			total_amt += i;
			
		}else{ // 종료 요일이 시작 요일보다 인덱스 값이 클 때 
			
			amt.map((obj, index) => {
				
				var imsi = {};
				imsi[obj.date] = obj.amt;
				
				if(index >= s_index && index <= e_index){
					// 인덱스가 시작요일부터 종료 요일 까지인 범위 내에서
					total_amt += obj.amt;
				}
			})
			total_amt += i;
		}
	}
	
	return total_amt;
	
}*/
	/*if(r == 7 ){ // 7일 예약인 경우 
		
		day_amt *= 5;
		end_amt *= 2;
		total_amt = day_amt + end_amt;
		return total_amt;
		
	}else if(r < 7){ // 예약 일수가 7일 미만일 경우 
		
		if(s_index > e_index){ // 시작 요일이 종료 요일보다 인덱스 값이 클때
			
			amt.map((obj, index) => {
				
				var imsi = {};
				imsi[obj.date] = obj.amt;
				
				if(index > e_index && index < s_index){
					// 사이값을 더해서 전체 합한 값에서 빼기
					total_amt += obj.amt;
				}
				
				total_amt -= tot;
				
			})
			
			return total_amt;
			
		}else{ // 종료 요일이 시작 요일보다 인덱스 값이 클 때 
			
			amt.map((obj, index) => {
				
				var imsi = {};
				imsi[obj.date] = obj.amt;
				
				if(index >= s_index && index <= e_index){
					// 인덱스가 시작요일부터 종료 요일 까지인 범위 내에서
					total_amt += obj.amt;
				}
			})
			
			return total_amt;
		}
		
	}else if(r > 7){ // 예약 일수가 7일 초과인 경우
		
	}*/
	/*else if(f.checkOut1.value != ""){
		if( f.checkIn1.value === ""){
			alert('체크인 날짜를 선택해주세요!');
			f.checkIn1.focus();
		}else{
			//alert('ㅇㅇ');
			if(confirm('체크인 일자 : ' + cinV +'\n' + '체크아웃 일자 : ' + coutV + '\n' 
					+ '예약 일수 : ' + dateV + ' 박 '+(dateV+1)+'일' ) == true ){ // + '금액 : '+ amt + '원'
				alert('예약 신청화면으로 이동');
				f.submit();
			}
		}
	}else{
		
		alert('ㅇㅇ');
		if(confirm('체크인 일자 : ' + cinV +'\n' + '체크아웃 일자 : ' + coutV + '\n' 
				+ '예약 일수 : ' + dateV + ' 일' ) == true ){ // + '금액 : '+ amt + '원'
			alert('예약 신청화면으로 이동');
			f.submit();
		}
	
	}
*/
	