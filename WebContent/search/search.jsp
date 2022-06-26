<%--https://github.com/Ryanmufasa/awesomePlace/issues/23 -- 작성자 정다영  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath }/resources/css/Search.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
<%-- <%@ include file="/layout/Header.jsp" %> --%>
<%@ include file="/layout/SearchHeader.jsp" %>
<!-- UI 변경 작업중 -->
<fmt:setLocale value="ko_KR"/>

<div align="center"  class="mainDiv">
<h2>검색결과 </h2>
<hr>
	<c:forEach var="host" items="${hostli }" varStatus="status">
		<div class="box">
		<button class="boxing" id="A" onclick="location.href='/awesomePlace/search/moreinfo.do?host_name=${host.host_name }&host_num=${host.host_num}'">
			<h2>${host.host_name }</h2>
			<c:set var="room" value="${host.room_type }"/>
				<c:if test="${fn:contains( room, 'A')}"><c:out value="집 전체"/></c:if>
				<c:if test="${fn:contains( room, 'P')}"><c:out value="개인실"/></c:if>
				<c:if test="${fn:contains( room, 'S')}"><c:out value="다인실"/></c:if><br>
			방 개수 ${host.room_cnt } 개<br>
			숙박 가능 인원 ${host.guest_cnt } 명<br> 
			평일 <fmt:formatNumber type="currency" value="${host.weekday_amt }"/>~<br>
			공휴일 <fmt:formatNumber type="currency" value="${host.weekend_amt }"/>~<br>
			<%-- <input type="hidden" name="host_num" value="${host.host_num }"> --%>
		</button>
		</div>
	</c:forEach>
	<c:if test="${hostli == null}">
		<p>검색 결과가 없습니다!</p>
	</c:if>
</div>

<%@ include file="/layout/SearchFooter.jsp" %>
