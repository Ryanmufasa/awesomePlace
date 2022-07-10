/**https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영 
 * 
 */

$(function(){
	
	$(".infomenu>h3").click(function(){
		var info = $(this).next('form')
		
		if(info.is(':visible')){
			info.slideUp();
		}else{
			info.slideDown();
		}
		
	})
	
	document.getElementById("room_cnt_1").style.visibility="hidden";
	document.getElementById("room_cnt_2").style.visibility="hidden";
	
	$('#host_tel').on("keyup", function(){
		var tel = $(this).val();
		tel = autoHypenTel(tel);
		$(this).val(tel);
	});
	
	$('#weekday_amt').on("keyup", function(){ // 금액 단위 , 찍기 (정규식 활용) 
		var wda = $(this).val().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
		$(this).val(wda);
	});
	
	
	$('#weekend_amt').on("keyup", function(){6
		var wea = $(this).val().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
		$(this).val(wea);
	});
	
	$('#room_cnt').on('click', function(){
		document.getElementById("room_cnt_1").style.visibility="visible";
		$('#db_room_cnt').prop('hidden', true);
	})
	
	$('#info1btn').on('click', function(){
		var host_name = document.getElementById('host_name');
		alert(host_name);
		var host_tel = document.getElementById('host_tel');
		alert(host_tel);
		var host_content = document.getElementById('host_content');
		alert(host_content);
		
	})
	$('#info2btn').on('click', function(){
		
	})
	$('#info3btn').on('click', function(){
		
	})
	$('#info4btn').on('click', function(){
		
	})
	
})

// 토글 메뉴 구성
function showNhide(info){
	if(info.style.display=='block'){
		info.style.display = 'none';
	}else{
		info.style.display='block';
	}
	
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

