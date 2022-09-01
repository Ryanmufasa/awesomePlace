<!-- https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@include file ="/layout/Header.jsp" %>
<link href="${contextPath }/resources/css/adminPage.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
<script src ="${contextPath }/resources/js/adminPage.js?v=<%=System.currentTimeMillis() %>"></script>
<script>
	var steadyRowCnt = "${pageData[7]}";
	$(document).ready(function(){
		scopeColor(steadyRowCnt);
	});
</script>
<div class="mainDiv-child">
<c:if test="${pageData[8] > 10}">
<div class="btnGroup">
	<button class="scopeBtn" id="scope10" onclick="scopeClickMem(${pageData[0]}, 10)">10</button>
	<button class="scopeBtn" id="scope20" onclick="scopeClickMem(${pageData[0]}, 20)">20</button>
	<button class="scopeBtn" id="scope50" onclick="scopeClickMem(${pageData[0]}, 50)">50</button>
</div>
</c:if>
<br><h1 align="center">회원 목록</h1><br>
<table border="1">
	<tr><th>회원번호</th><th>회원 아이디</th><th>회원명</th><th>회원 활성화</th><th>관리항목</th></tr>
<!-- int [] pageData = {page[0],begin[1],end[2],rowStart[3],rowEnd[4],totalCnt[5],rowCnt[6],steadyRowCnt[7],totalRow[8]} -->
		<c:forEach var="memList" items="${memList }" begin="${pageData[3] }" end="${pageData[4] }" step="1" >
			<tr> 
				<th>${memList.mem_num}</th>
				<td><a href="#" onclick="memDetail(${memList.mem_num}); return false;">${memList.mem_id}</a></td>
				<td>${memList.mem_name}</td>
				<td>${memList.mem_sign }</td>
				<th>
				<c:if test="${memList.mem_host_Cnt > 0}">
					<button onclick="memHostList(${memList.mem_num});">호스트 목록 : ${memList.mem_host_Cnt}개</button>
				</c:if>
				<button id="queueConfirm" onclick="switchSign(${memList.mem_num},'${memList.mem_sign}',${pageData[0]},${pageData[7]});">
					<c:if test="${memList.mem_sign eq 'Y' }">회원 비활성화</c:if>
					<c:if test="${memList.mem_sign eq 'N' }">회원 활성화</c:if>
				</button>
				</th>
			</tr>
		</c:forEach>
</table>
<br><br>
<!-- int [] pageData = {page[0],begin[1],end[2],rowStart[3],rowEnd[4],totalCnt[5],rowCnt[6],steadyRowCnt[7],totalRow[8]} -->
<c:if test="${pageData[1] ne pageData[5]}">
	<div class="paging">
		<c:if test="${pageData[0] ne 1}">
			<span><a id="aTag" href="memberList.do?pageIdx=1&steadyRowCnt=${pageData[7]}">&lt;&lt;</a></span>
			<span><a id="aTag" href="memberList.do?pageIdx=${pageData[0]-1 }&steadyRowCnt=${pageData[7]}">&lt;</a></span>
		</c:if>
			<c:forEach varStatus="idx" begin="${pageData[1] }" end="${pageData[2] }" step="1">
				<c:if test="${pageData[0] eq idx.current }">
					<span><a id="currentPage" href="memberList.do?pageIdx=${idx.current }&steadyRowCnt=${pageData[7]}">
					${idx.current }</a></span>
				</c:if>
				<c:if test="${pageData[0] ne idx.current }">
					<span><a id="aTag" href="memberList.do?pageIdx=${idx.current }&steadyRowCnt=${pageData[7]}">
					${idx.current }</a></span>
				</c:if>
			</c:forEach>
		<c:if test="${pageData[0] ne pageData[2]}">
			<span><a id="aTag" href="memberList.do?pageIdx=${pageData[0]+1 }&steadyRowCnt=${pageData[7]}">&gt;</a></span>
			<span><a id="aTag" href="memberList.do?pageIdx=${pageData[5] }&steadyRowCnt=${pageData[7]}">&gt;&gt;</a></span>
		</c:if>
	</div>
</c:if>

<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<%@include file ="/layout/Footer.jsp" %>