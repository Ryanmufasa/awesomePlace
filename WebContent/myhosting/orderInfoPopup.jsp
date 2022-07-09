<%-- https://github.com/Ryanmufasa/awesomePlace/issues/57 -- 작성자 정다영  -- 작성자 정다영  --%>
<%-- 미완 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.js?v=<%=System.currentTimeMillis() %>" ></script>
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h3>예약 상세 정보</h3>
<hr>
<c:if test="${vo != null }">
	
체크인 일자 :  <fmt:formatDate pattern="yyyy-MM-dd" value="${vo.checkIn_date }"/><br>
체크아웃 일자 : <fmt:formatDate pattern="yyyy-MM-dd" value="${vo.checkOut_date }"/><br>
지불 금액 : ${vo.pay_amt }
<br>
<c:choose>
	<c:when test="${vo.oi_sign == 'wait' }">
		<p id="re">예약 승인하시겠습니까? </p>
		<br>
		<button type="button" id="confirm" onclick="confirmOrder('${vo.oi_num}')">예</button>
		<button type="button" id="cancle" onclick="cancleOrder('${vo.oi_num}')">아니오</button>
		<br>
	</c:when>
	<c:when test="${vo.oi_sign == 'confirm' }">
		<p id="re1">이미 예약 승인이 완료되었습니다. 예약 승인 후 취소는 온라인 고객센터로 문의해주세요</p>
		<br>
		<button type="button" onclick="self.close()">확인</button>
		<br>
	</c:when>
	<c:otherwise>
		<p>취소된 예약건입니다.</p>
		<br>
		<button type="button" onclick="self.close()">확인</button>
		<br>
	</c:otherwise>
</c:choose>


</c:if>
<c:if test="${vo == null }">
<p>정보 불러오기 실패! 잠시후에 다시 시도해주세요 </p>
</c:if>
<br>
<hr>
<button type="button" onclick="self.close()">닫기</button>
</div>

<script>
function confirmOrder(num){
	var oi_num = num;
	
	alert("예약 번호 : " + oi_num);
	
	$.ajax({
		async : true,
		type : 'post',
		url : '/awesomePlace/myhosting/confirmOrder.do',
		cache : false,
		data : {"oi_num" : oi_num},
		datatype:'json',
		success : function(confirmResult){
			var confirmResult = parseInt(confirmResult);
			alert(confirm);
			if(confirmResult == 0){
				alert('예약 승인 실패. 잠시후에 다시 시도해주세요')
				$('#confirm').prop('hidden', true);
				$('#cancle').prop('hidden',true);
			}else{
				alert('예약 승인 완료');
				$('#re').text('예약 완료 되었습니다.')
				$('#confirm').prop('hidden', true);
				$('#cancle').prop('hidden',true);
			}
		}, error : function(request, error){
			//alert('승인 할 수 없음.');
			alter('code : ' + request.status + "\n" 
					+ "message : " + request.responseText +
					"\n" + "error : " + error);
		}
	})
	
}

function cancleOrder(order_num){
	 var oi_num = order_num
	 
	 alert('예약번호 : ' + oi_num);
	
	 $.ajax({
		async : true,
		type : 'post',
		url : '/awesomePlace/myhosting/cancleOrder.do',
		cache:false,
		data:{"oi_num" : oi_num},
		datatype :'json',
		success : function(cancleResult){
			var cancleResult = parseInf(cancleResult);
			alert(cancleResult)
			if(cancleResult == 0){
				alert('예약 취소 실패. 잠시후에 다시 시도해주세요')
				$('#confirm').prop('hidden', true);
				$('#cancle').prop('hidden',true);
			}else{
				alert('예약취소 완료');
				$('#re').text('예약 승인을 취소하였습니다.');
				$('#confirm').prop('hidden', true);
				$('#cancle').prop('hidden',true);
			}
		}, error : function(request, error){
			//alert('예약 승인 취소 에러 ');
			alter('code : ' + request.status + "\n" 
					+ "message : " + request.responseText +
					"\n" + "error : " + error);
		}
	 })
}




$(function(){
	$(window).on('blur', function(){
		opener.parent.location.reload();
		self.close();
	})
})


</script>
</body>
</html>