<%--https://github.com/Ryanmufasa/awesomePlace/issues/57 -- 작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath }/resources/css/Search.css?v=<%=System.currentTimeMillis() %>" 
rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/HostInfo.css?v=<%=System.currentTimeMillis() %>" 
rel="stylesheet">
<%@ include file="/layout/Header.jsp" %>
<script type="text/javascript" 
src="${pageContext.request.contextPath }/resources/js/Order.js?v=<%=System.currentTimeMillis()%>"></script>
<%-- 
session.setAttribute("URL", "http://localhost:8080//awesomePlace/search/moreinfo.do?host_name=${vo.host_name }&host_num=${vo.host_num}");
--%>

<div align="center" class="mainDiv">



<%--GetHostInfoService 결과 창 vo 객체 --%>
<h2>${vo.host_name }</h2>
<hr>
	<div class="divInfo">
		<div class="divInfoL">
			<h3>숙소 정보</h3>
			<c:set var="room" value="${vo.room_type }"/>
				<c:if test="${fn:contains(room, 'A')}"><c:out value="집 전체"/></c:if>
				<c:if test="${fn:contains( room, 'P')}"><c:out value="개인실"/></c:if>
				<c:if test="${fn:contains( room, 'S')}"><c:out value="다인실"/></c:if><br>
				
			방 개수 : ${vo.room_cnt } 개 <br><br>
			최대 ${vo.guest_cnt } 명 가능<br><br>
			${vo.weekday_amt } / 박 (평일)<br><br>
			${vo.weekend_amt } / 박 (주말)<br><br>
			
			<textarea cols="50" rows="10" style="resize:none;"readonly>${vo.host_content } </textarea>
			<br><br>
			<table>
				<tr><td>주소</td></tr>
				<tr><td>${vo.host_post_num}</td></tr>
				<tr><td>${vo.host_addr }</td></tr>
			</table>
			<br>
			<!-- <div id="map" style="width:300px;height:300px;"></div> -->
			<%-- 위치 정보<br>
			${vo.host_post_num}<br>
			${vo.host_addr }<br>
			 --%>
			<br>	
		
		</div>
	<form action="/awesomePlace/search/hostOrder.do" method="post" name="hostInfo">
		<div class="divInfoR">
			<h3>예약 안내</h3>
			<p>현재 조회중인 숙소는  </p>
			<c:if test="${!empty tag_name }">
			<p>#${tag_name } (으)로 유명해요! </p>
			</c:if>
			<c:if test="${!empty checkIn }">
			<p>${checkIn } 부터 ${checkOut } 일자까지 </p>
			</c:if>
			<c:if test="${!empty guestCnt }">
			<p>${guestCnt }명 예약 가능한 숙소입니다!</p>
			</c:if>
			<p> 체크인, 체크아웃 날짜를 입력해보세요!</p>

			
			
			예약 인원 
			<input type="text" id="guest_cnt" name="guest_cnt" value="${guestCnt }" >
			<br><br>
			
			<%-- <input type="hidden" name="host" value="${vo }"> --%>
			<input type="hidden" id="host_num" name="host_num" value="${vo.host_num }">
			체크인 <input type="date" min="2022-06-05" name="checkIn1" id="checkIn1" >
			<span id="start_date"></span><span id="st"> 부터 ~ </span> <br>
			<br>
			체크아웃 <input type="date" min="2022-06-05" name="checkOut1" id="checkOut1" disabled >
			<span id="end_date"></span><span id="nd"> 까지</span><br>
			<span id="total_date"></span><span id="tt"></span><br>
			<input type="hidden" id="tDate" value="">
			<br>
			<button type="button" id="cal" value="${vo.weekday_amt },${vo.weekend_amt }">계산하기</button>
			<span id="pay_amt"></span>
			<br><br>
			<button type="button" id="book">예약 가능 확인하기</button>
			<br>
			<!-- onclick="amtCheck('${vo.weekday_amt}, ${vo.weekend_amt }')" -->
			<span id="pay_amt"></span>
			<input type="hidden" id="total_pay_amt" name="pay_amt" value="">
			<br>
			
			
			<c:choose>
				<c:when test="${mem_id != null }">
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
<span id="msg"></span>
</div>

<%@ include file="/layout/Footer.jsp" %>