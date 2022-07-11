/**
 *  orderInfoPopup.jsp 에서 사용될 스크립트 -- 작성자 정다영
 */

$(function(){
	
	var confirm = document.getElementById('confirm');
	var cancle = document.getElementById('cancle');
	
	$('#confirm').on('click',(function(){
		alert(confirm.value);
		var num = parseInt(confirm.value);
		alert(num);
		
		$.ajax({
			async : true,
			type : 'post',
			url : '/awesomePlace/myhosting/confirmOrder.do',
			cache : false,
			data : {"oi_num" : num},
			datatype:'json',
			success : function(confirmResult){
				//var confirmResult = parseInt(confirmResult);
				alert(confirmResult)
				if(confirmResult == 1){
					alert('예약 승인 완료');
					$('#re').text('예약 완료 되었습니다.')
					$('#confirm').prop('hidden', true);
					$('#cancle').prop('hidden',true);
				}else{
					alert('예약 승인 실패. 잠시후에 다시 시도해주세요')
					$('#confirm').prop('hidden', true);
					$('#cancle').prop('hidden',true);
				}
			}, error : function(error){
				alert('에러.승인 할 수 없음.' + error);
			}
		})
		
	}));
	
	$('#cancle').on('click', (function(){
		alert(cancle.value);
		var order_num = parseInt(cancle.value);
		alert(order_num);
		
		$.ajax({
			async : true,
			type : 'post',
			url : '/awesomePlace/myhosting/cancleOrder.do',
			cache: false,
			data : {"oi_num" : order_num},
			datatype :'json',
			success : function(cancleResult){
				//var cancleResult = parseInf(cancleResult);
				alert(cancleResult)
				if(cancleResult == 1){
					alert('예약취소 완료');
					$('#re').text('예약 승인을 취소하였습니다.');
					$('#confirm').prop('hidden', true);
					$('#cancle').prop('hidden',true);
				}else{
					alert('예약 취소 실패. 잠시후에 다시 시도해주세요')
					$('#confirm').prop('hidden', true);
					$('#cancle').prop('hidden',true);
				}
			}, error : function(error1){
				alert('예약 승인 취소 에러 ' + error1);
				
			}
		})
		
	}))

})


$(window).on('blur', function(){
	opener.parent.location.reload();
	//self.close();
})
