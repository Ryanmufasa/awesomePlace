<%--https://github.com/Ryanmufasa/awesomePlace/issues/23 -- 작성자 정다영  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath }/resources/css/Search.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
<%@ include file="/layout/Header.jsp" %>
<fmt:setLocale value="ko_KR"/>
<%-- <% session.setAttribute("URL", "http://localhost:8080/awesomePlace/search/search.do"); %> --%>
<div align="center"  class="mainDiv">
<%--&checkIn=${checkIn }&checkOut=${checkOut }&guestCnt=${guestCnt } --%>
<h2>
	<c:if test='${search != ""}'>
		'${search }',
	</c:if>
	<c:choose>
	<c:when test='${checkOut != ""}'>
		${checkIn } 부터 ${checkOut } 까지, 
	</c:when>
	<c:otherwise>
		<c:if test='${checkIn != "" }'> <%--예상 밖의 에러 발생 가능성... --%>
			${checkIn } 부터 예약 가능한 숙소, 
		</c:if> 
	</c:otherwise>
	</c:choose>
		<%-- <c:if test="${guestCnt < 2 }">
			숙박 인원 : ${guestCnt } 명 으로 검색한 결과 입니다
		</c:if> --%>
		<c:if test="${guestCnt >= 1 }">
			숙박 인원 : ${guestCnt } 명 으로 검색한 결과 입니다
		</c:if>
		<c:if test="${empty guestCnt }">
		</c:if>
		<c:if test="${tag_name}">
			${tag_name } 로 검색한 결과입니다.
		</c:if>
 </h2>
<hr>
<div style="display:inline-flex;">
	<c:forEach var="host" items="${hostli }" varStatus="status">
		<button class="box" id="A" 
		onclick="location.href='/awesomePlace/search/moreinfo.do?host_name=${host.host_name }&host_num=${host.host_num}&checkIn=${checkIn}&checkOut=${checkOut }&guestCnt=${guestCnt }'">

			<h2>${host.host_name }</h2>
			<c:set var="room" value="${host.room_type }"/>
				<c:if test="${fn:contains( room, 'A')}"><c:out value="집 전체"/></c:if>
				<c:if test="${fn:contains( room, 'P')}"><c:out value="개인실"/></c:if>
				<c:if test="${fn:contains( room, 'S')}"><c:out value="다인실"/></c:if><br>
			방 개수 ${host.room_cnt } 개<br>
			숙박 가능 인원 ${host.guest_cnt } 명<br> 
			평일 <fmt:formatNumber type="currency" value="${host.weekday_amt }"/>~<br>
			공휴일 <fmt:formatNumber type="currency" value="${host.weekend_amt }"/>~
		</button>
	</c:forEach>
	<c:if test="${hostli == null}">
		<p>검색 결과가 없습니다!</p>
	</c:if>
</div>
</div>

<%@ include file="/layout/Footer.jsp" %>
