/**https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영 
 * 
 */

$(function(){
	
	/*var maindiv = $('.mainDiv').css('height');
	var chdiv = $('.mainDiv-child').css('height');
	var hostdiv = $('#host1').css('height');
	alert(maindiv);
	alert(hostdiv);*/
	
	/*$('.mainDiv').style.display="table";
	$('.mainDiv-child').style.display='table-row';*/
	
/*	setDivHeight($('.mainDiv'), $('.mainDiv-child'))*/

	$(".infomenu>h3").click(function(){
		var info = $(this).next('form')
		
		if(info.is(':visible')){
			info.slideUp();
			
		}else{
			info.slideDown();
			$('.mainDiv').css({'height':info.css('height')+'px'})
		}
		
		
		$(function(){
			setTimeout(function() {
			spanResize();
			},300);
		});
		
	})
	
	
	function spanResize(){
		var mainBottom = $("#counter").offset().top; //메인 div 높이 반응형설정
		$(".mainDiv, .mainDiv-image, .nav").css("height",mainBottom-140);
		$(".navLine").css("height",mainBottom-140);
	};
	
	
	/*$('article')[0].addEventListener('click', function(){
		var f_height = $('.info1').css('height');
		alert(f_height);
		$('.mainDiv').css({'height':f_height+'px'});
	})
	
	$('article')[1].addEventListener('click', function(){
		var f_height = document.getElementById('host1').offsetHeight;
		alert(f_height);
		$('.mainDiv').css({'height':f_height+'px'});
	})
	$('article')[2].addEventListener('click', function(){
		var f_height = document.getElementById('host1').offsetHeight;
		alert(f_height);
		$('.mainDiv').css({'height':f_height+'px'});
	})
	$('article')[3].addEventListener('click', function(){
		var f_height = document.getElementById('host1').offsetHeight;
		alert(f_height);
		$('.mainDiv').css({'height':f_height+'px'});
	})
	*/
	
/*	$('.mainDiv-child').addEventListener('resize',function(){
		var f_height = document.getElementById('host1').offsetHeight;
		//alert(f_height);
		$('.mainDiv').css({'height':f_height+'px'});
	})*/

	
	document.getElementById("room_cnt_1").style.visibility="hidden";
	document.getElementById("room_cnt_2").style.visibility="hidden";
	
	$('#host_tel').on("keyup", function(){
		var tel = $(this).val();
		tel = autoHypenTel(tel);
		$(this).val(tel);
	});
	
	$('input[name=room_type][type=radio]').change(function(){
		var roomType = $(this).val();
		//alert(roomType)
		$('#checkedType').val(roomType);
		
	})
	
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
		$('#roomCnt').val('');
	})
	
	$('#room_cnt_1').on('change',function(){
		var selVal = $('#room_cnt_1 option:selected').val();
		if(selVal == 0 ){ // 직접입력 선택시 
			document.getElementById('room_cnt_2').style.visibility='visible';
		}else{
			document.getElementById('room_cnt_2').style.visibility='hidden';
			alert(selVal);
			$('#roomCnt').val(selVal);
		}
	})
	
	$('#room_cnt_2').on('change',function(){
		var rc = $(this).val();
		$('#roomCnt').val(rc);
	})
	
	$('#guest_cnt').on('change',function(){
		var gc = $(this).val();
		$('#guestCnt').val(gc);
	})
	
	$('#info1btn').on('click', function(){
		var host_num = document.getElementById('host_num').value;
		var host_name = document.getElementById('host_name').value;
		var host_tel = document.getElementById('host_tel').value;
		var host_content = document.getElementById('host_content').value;
		
		$.ajax({
			async : true,
			type : 'post',
			url : '/awesomePlace/myhosting/updateInfo1.do',
			cache : false,
			data : {
				"host_num" : host_num,
				"host_name" : host_name,
				"host_tel" : host_tel,
				"host_content" : host_content
			},
			datatype : 'json',
			success : function(update1){
				//alert(update1)
				if(update1 == 1){
					alert('정보 수정을 완료하였습니다.')
				}else{
					alert('정보 수정에 실패하였습니다.')
				}
			},error : function(error){
				alert("에러 "+error);
			}
		})
		
	})
	
	$('#info2btn').on('click', function(){
		var host_num = document.getElementById('host_num').value;
		//alert(host_num)
		var room_type = document.getElementById('checkedType').value;
		//alert(room_type);
		var room_cnt = document.getElementById('roomCnt').value;
		//alert(room_cnt);
		var guest_cnt =  document.getElementById('guestCnt').value;
		//alert(guest_cnt);
		
		$.ajax({
			async : true,
			type : 'post',
			url : '/awesomePlace/myhosting/updateInfo2.do',
			cache : false,
			data : {
				"host_num" : host_num,
				"room_type" : room_type,
				"room_cnt" : room_cnt,
				"guest_cnt" : guest_cnt
			},
			datatype : 'json',
			success : function(update2){
				//alert(update2)
				if(update2 == 1){
					alert('정보 수정을 완료하였습니다.')
				}else{
					alert('정보 수정에 실패하였습니다.')
				}
			},error : function(error){
				alert("에러 "+error);
			}
		})
	})
	
	$('#info3btn').on('click', function(){
		var host_num = document.getElementById('host_num').value;
		var weekday_amt1 = document.getElementById('weekday_amt').value;
		var weekend_amt1 = document.getElementById('weekend_amt').value;
		
		var weekday_amt = weekday_amt1.replace(",", "");
		var weekend_amt = weekend_amt1.replace(",", '');
		//alert(weekday_amt + "   " + weekend_amt);
		
		$.ajax({
			async : true,
			type : 'post',
			url : '/awesomePlace/myhosting/updateInfo3.do',
			cache : false,
			data : {
				"host_num" : host_num,
				"weekday_amt" : weekday_amt,
				"weekend_amt" : weekend_amt,
			},
			datatype : 'json',
			success : function(update3){
				//alert(update3)
				if(update3 == 1){
					alert('정보 수정을 완료하였습니다.')
				}else{
					alert('정보 수정에 실패하였습니다.')
				}
			},error : function(error){
				alert("에러 "+error);
			}
		})
		
	})
	
	$('#addTag').on('click',function(){
		var host_num = document.getElementById('host_num').value;
		//alert(host_num);
		
		var width = 500;
		var height = 500;
		
		var left = (window.screen.width/2) - (width/2);
		var top = (window.screen.height / 4);
		
		
		var windowSet = 'width='+ width 
					+ ', height='+ height
					+ ', left=' + left
					+ ', top=' + top
					+ ', scrollbars=yes, status=yes, resizable=yes, titlebar = yes';
	
		var url = "/awesomePlace/search/hashtagList.do?host_num="+host_num;
		//alert(url);
		
		window.open(url,'hashtagList',windowSet);
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

/*function setDivHeight(objSet, objTar){
	var objSet = document.getElementById(objSet);
	var objTarHeight = document.getElementById(objTar).height();
	objSet.style.height= objTarHeight + "px";
}
*/







// 방 개수 입력시
/*function changeRoomCnt(){
	
	var selVal = $('#room_cnt_1').val();
	
	if(selVal == 0 ){ // 직접입력 선택시 
		document.getElementById('room_cnt_2').style.visibility='visible';
	}else{
		document.getElementById('room_cnt_2').style.visibility='hidden';
	}
	
	var roomCnt = document.getElementById('roomCnt');
	roomCnt = document.getElementByName("room_cnt_2").value;
	alert(roomCnt);
	
}*/


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

