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
			<th>예약 회원 번호</th>
			<th>예약 신청 일자</th>
			<th>예약 시작일자(Check in)</th>
			<th>예약 종료일자(Check out)</th>
			<th>예약 인원</th>
			<th>지불 금액</th>
			<th>예약 승인 여부</th>
		</tr>
		<c:choose>
		<c:when test="${orderInfoList != null }">
			<c:forEach items="${orderInfoList }" var="oi">
			<tr>
				<td>${oi.order_num }</td>
				<td>${oi.mem_num }</td>
				<td>${oi.order_date }</td>
				<td>${oi.checkIn_date }</td>
				<td>${oi.checkOut_date }</td>
				<td>${oi.guest_cnt }</td>
				<td>${oi.pay_amt }</td>
				<td>${oi.order_sign }</td>
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
	</div>
	<span id="counter"></span>
</div>

<%@ include file="/layout/Footer.jsp" %> 