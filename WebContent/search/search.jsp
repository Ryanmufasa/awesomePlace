<%--https://github.com/Ryanmufasa/awesomePlace/issues/23 -- 작성자 정다영  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/layout/Header.jsp" %>
<!-- 테스트 위해 임시로 구현한 내용입니다. UI 변경 예정 -->
<fmt:setLocale value="ko_KR"/>

<div align="center"  class="mainDiv">
<h1>검색결과 조회 </h1>

	<table border="1">
		<tr>
			<th>번호</th> <!-- DB PK 아님 출력 인덱스 번호 -->
			<th>호스트 명</th>
			<th>방 종류</th>
			<th>방 개수</th>
			<th>숙박 가능 인원 </th>
			<th>평일 숙박 가격</th>
			<th>공휴일 숙박 가격</th>
		</tr>
		<c:forEach var="host" items="${hostli }" varStatus="status">
		<tr>
			<td><c:out value="${status.count }"/></td>
			<td><a href="moreinfo.do?name=${host.host_name }">${host.host_name }</a></td>
			<td><c:set var="room" value="${host.room_type }"/>
				<c:if test="${fn:contains( room, 'A')}"><c:out value="집 전체"/></c:if>
				<c:if test="${fn:contains( room, 'P')}"><c:out value="개인실"/></c:if>
				<c:if test="${fn:contains( room, 'S')}"><c:out value="다인실"/></c:if>
			</td>
			<td>${host.room_cnt }</td>
			<td>${host.guest_cnt }</td>
			<td><fmt:formatNumber type="currency" value="${host.weekday_amt }"/></td>
			<td><fmt:formatNumber type="currency" value="${host.weekend_amt }"/></td>
		</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="/layout/Footer.jsp" %>
