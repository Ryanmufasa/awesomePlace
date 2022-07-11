<%-- https://github.com/Ryanmufasa/awesomePlace/issues/57 -- 작성자 정다영  -- 작성자 정다영  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.js?v=<%=System.currentTimeMillis() %>" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/orderMng.js?v=<%=System.currentTimeMillis() %>"></script>
<title>예약 상세 정보</title>
</head>
<body>
<div align="center">
<h3>예약 상세 정보</h3>
<hr>
<c:if test="${vo != null }">
	
체크인 일자 :  <fmt:formatDate pattern="yyyy-MM-dd" value="${vo.checkIn_date }"/><br>
체크아웃 일자 : <fmt:formatDate pattern="yyyy-MM-dd" value="${vo.checkOut_date }"/><br>
예약 인원 : ${vo.oi_guest_cnt }<br>
지불 금액 : ${vo.pay_amt }
<br>
<c:choose>
	<c:when test="${vo.oi_sign == 'wait' }">
		<p id="re">예약 승인하시겠습니까? </p>
		<br>
		<button type="button" id="confirm" value="${vo.oi_num }" >예</button> <!-- onclick="confirmOrder('${vo.oi_num}')" -->
		<button type="button" id="cancle" value="${vo.oi_num }">아니오</button> <!-- onclick="cancleOrder('${vo.oi_num}')" -->
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

</script>
</body>
</html>