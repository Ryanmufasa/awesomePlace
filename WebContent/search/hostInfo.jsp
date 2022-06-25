<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath }/resources/css/Search.css?v=<%=System.currentTimeMillis() %>" 
rel="stylesheet">
<script type="text/javascript" 
src="${pageContext.request.contextPath }/resources/js/Order.js?v=<%=System.currentTimeMillis()%>"></script>

<%@ include file="/layout/SearchHeader.jsp" %>
<div align="center" class="mainDiv">
<h2>${vo.host_name }</h2>
<hr>
<form action="/awesomePlace/search/hostOrder.do" method="post" name="hostInfo">
	<div class="info">
		<h3>숙소 유형</h3>
		<c:set var="room" value="${vo.room_type }"/>
			<c:if test="${fn:contains(room, 'A')}"><c:out value="집 전체"/></c:if>
			<c:if test="${fn:contains( room, 'P')}"><c:out value="개인실"/></c:if>
			<c:if test="${fn:contains( room, 'S')}"><c:out value="다인실"/></c:if>
		${vo.room_cnt } <br>
		최대 ${vo.guest_cnt } 명<br>
		${vo.weekday_amt } / 박 (평일)<br>
		${vo.weekend_amt } / 박 (주말)<br>
		${vo.host_content }
	</div>
	<div class="info">
		<input type="hidden" name="host_num" value="${vo.host_num }">
		체크인 <input type="date" min="2022-06-05" name="checkIn" id="checkIn"><br>
		체크아웃 <input type="date" min="2022-06-05" name="checkOut" id="checkOut"><br>
		<br><br><br>
		<c:choose>
			<c:when test="${login != null }">
				<button type="button" onclick="order(hostInfo);">예약 하기</button>
				<button type="button" onclick="like(hostInfo);">찜</button>
			</c:when>
			<c:otherwise> 
				<button type="button" onclick="checkLogin();">예약 하기</button>
				<button type="button" onclick="checkLogin();" >찜</button>
			</c:otherwise>
		</c:choose>
	</div>
	<br>
	<div class="location">
		위치 정보<br>
		${vo.host_addr }<br>	
	</div>	
</form>
<hr>
<button type="button" onclick="history.back()">뒤로가기</button>
</div>
<%@ include file="/layout/SearchFooter.jsp" %>