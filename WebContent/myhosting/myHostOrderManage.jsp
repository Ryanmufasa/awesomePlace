<%--https://github.com/Ryanmufasa/awesomePlace/issues/44 작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/layout/Header.jsp" %>

<div class="mainDiv-child">
<%-- host , orderInfoList --%>
	<div align="center">
	<h1>${host.host_name }의 예약 현황</h1>
	
	<table border="1">
		<tr>
			<th>예약 번호</th>
			<th>예약 회원 아이디</th>
			<th>예약 시작일자(Check in)</th>
			<th>예약 종료일자(Check out)</th>
			<th>결제 일자</th>
			<th>지불 금액</th>
			<th>예약 승인 여부</th>
		</tr>
		<c:choose>
		<c:when test="${orderInfoList != null }">
			<c:forEach items="${orderInfoList }" var="oi">
			<tr>
				<td>${oi.oi_num }</td>
				<td>${oi.oi_mem_id }</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${oi.checkIn_date }"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${oi.checkOut_date }"/></td>
				<td>${oi.pay_date }</td>
				<td>${oi.pay_amt }</td>
				<td>${oi.oi_sign }  <button type="button" onclick='getInfo("${oi.oi_num}")'>확인하기</button></td>
			</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="8" align="center">
					조회된 예약 정보가 없습니다.
				</td>
			</tr>
		</c:otherwise>
		</c:choose>
	</table>
	<br><br><br>
	<button onclick="history.back()">뒤로가기</button>
	
	
	
	</div>
	
	<span id="counter"></span>
</div>

<script>
// 상세정보 보기 버튼 클릭시 팝업창
function getInfo(oi_num){
	
	var order_num = oi_num;
	//alert(order_num);
	
	// 창 크기 지정
	var width = 500;
	var height = 500;
	
	// 화면 가운데 뜨도록 위치 정렬
	var left = (window.screen.width / 2) - (width/2);
	var top = (window.screen.height / 4);
	
	// 팝업 윈도우 속성 지정
	var windowSet = 'width='+ width 
				+ ', height='+ height
				+ ', left=' + left
				+ ', top=' + top
				+ ', scrollbars=yes, status=yes, resizable=yes, titlebar = yes';
	
	// 연결할 url
	var url = "/awesomePlace/myhosting/getOrderInfoMore.do?oi_num="+order_num;
	
	window.open(url, 'orderInfoPop', windowSet);
	
}
</script>
<%@ include file="/layout/Footer.jsp" %> 