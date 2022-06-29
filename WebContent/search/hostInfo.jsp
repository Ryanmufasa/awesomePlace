<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath }/resources/css/Search.css?v=<%=System.currentTimeMillis() %>" 
rel="stylesheet">
<%@ include file="/layout/SearchHeader.jsp" %>
<script type="text/javascript" 
src="${pageContext.request.contextPath }/resources/js/Order.js?v=<%=System.currentTimeMillis()%>"></script>

<style>
.divInfo{
	width:90%;
	min-height:400px;
	background-color:#FFFFAA
}

.divInfoL{
	width:50%;
	float:left;
	min-height:300px;
	box-sizing:border-box;
	background-color:#FFFFCC
}

.divInfoR{
	width:50%;
	float:right;
	min-height:300px;
	box-sizing:border-box;
	background-color:#AAFFFF
}

</style>
<div align="center" class="mainDiv">
<h2>${vo.host_name }</h2>
<hr>
	<div class="divInfo">
		<div class="divInfoL">
			<h3>숙소 유형</h3>
			<c:set var="room" value="${vo.room_type }"/>
				<c:if test="${fn:contains(room, 'A')}"><c:out value="집 전체"/></c:if>
				<c:if test="${fn:contains( room, 'P')}"><c:out value="개인실"/></c:if>
				<c:if test="${fn:contains( room, 'S')}"><c:out value="다인실"/></c:if><br>
				
			방 개수 : ${vo.room_cnt } 개 <br>
			최대 ${vo.guest_cnt } 명 가능<br>
			<span id="dayAmt">${vo.weekday_amt }</span> / 박 (평일)<br>
			<span id="endAmt">${vo.weekend_amt }</span> / 박 (주말)<br>
			${vo.host_content } <br>
			
			위치 정보<br>
			${vo.host_addr }<br>
			<br>	
		
		</div>
	<form action="/awesomePlace/search/hostOrder.do" method="post" name="hostInfo">
		<div class="divInfoR">
			<h3>예약</h3>
			<input type="hidden" name="host_num" value="${vo.host_num }">
			체크인 <input type="date" min="2022-06-05" name="checkIn1" id="checkIn1"><br>
			체크아웃 <input type="date" min="2022-06-05" name="checkOut1" id="checkOut1" disabled><br>
			<span id="start_date"></span><span id="st"> 부터 ~ </span> <br>
			
			<span id="end_date"></span><span id="nd"> 까지</span><br>
			<span id="total_date"></span><span id="tt"></span><br>
			<span id="pay_amt"></span>
	
			<br><br>
			
			<c:choose>
				<c:when test="${login != null }">
					<button type="button" onclick="order(hostInfo);">예약 하기</button>
					<button type="button" onclick="addLike(hostInfo);">찜</button>
				</c:when>
				<c:otherwise> 
					<button type="button" onclick="checkLogin();">예약 하기</button>
					<button type="button" onclick="checkLogin();" >찜</button>
				</c:otherwise>
			</c:choose>
		</div>
	</form>
	</div>
	
<hr>
<button type="button" onclick="history.back()">뒤로가기</button>
</div>
<%@ include file="/layout/SearchFooter.jsp" %>