<!-- https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@include file ="/layout/Header.jsp" %>
<link href="${contextPath }/resources/css/adminPage.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
<script src ="${contextPath }/resources/js/adminPage.js?v=<%=System.currentTimeMillis() %>"></script>
<script>
	var presentRowCnt = "${pageData[6]+1}";
	$(document).ready(function(){
		scopeColor(presentRowCnt);
	});
</script>
<div class="mainDiv-child">
<c:if test="${pageData[6] >= 9}">
<div class="btnGroup">
	<button class="scopeBtn" id="scope10" onclick="scopeClickHost(${pageData[0]}, 10)">10</button>
	<button class="scopeBtn" id="scope20" onclick="scopeClickHost(${pageData[0]}, 20)">20</button>
	<button class="scopeBtn" id="scope50" onclick="scopeClickHost(${pageData[0]}, 50)">50</button>
</div>
</c:if>
<br><h1 align="center">호스팅 목록</h1><br>
<table border="1">
	<tr><th>No</th><th>하우스 이름</th><th>회원 아이디</th><th>등록일자</th><th>활성화여부</th></tr>
<!-- int [] pageData = {page[0],begin[1],end[2],rowStart[3],rowEnd[4],totalCnt[5],rowCnt[6]} -->
		<c:forEach var="hostList" items="${hostList}">
			<tr> 
				<th>${hostList.host_num}</th>
				<td><a href="#" onclick="hostDetail(${hostList.host_num}); return false;">${hostList.host_name}</a></td>
				<td>${hostList.mem_id }</td>
				<td>${hostList.host_dateS}</td>
				<td>${hostList.sign }</td>
			</tr>
		</c:forEach>	
</table>
<br><br>
<!-- int [] pageData = {page[0],begin[1],end[2],rowStart[3],rowEnd[4],totalCnt[5],rowCnt[6]} -->
<c:if test="${pageData[1] ne pageData[5]}">
	<div class="paging">
		<c:if test="${pageData[0] ne 1}">
			<span><a id="aTag" href="hostingList.do?pageIdx=1&rowCnt=${pageData[6]}">&lt;&lt;</a></span>
			<span><a id="aTag" href="hostingList.do?pageIdx=${pageData[0]-1 }&rowCnt=${pageData[6]}">&lt;</a></span>
		</c:if>
			<c:forEach varStatus="idx" begin="${pageData[1] }" end="${pageData[2] }" step="1">
				<c:if test="${pageData[0] eq idx.current }">
					<span><a id="currentPage" href="hostingList.do?pageIdx=${idx.current }&rowCnt=${pageData[6]}">
					${idx.current }</a></span>
				</c:if>
				<c:if test="${pageData[0] ne idx.current }">
					<span><a id="aTag" href="hostingList.do?pageIdx=${idx.current }&rowCnt=${pageData[6]}">
					${idx.current }</a></span>
				</c:if>
			</c:forEach>
		<c:if test="${pageData[0] ne pageData[2]}">
			<span><a id="aTag" href="hostingList.do?pageIdx=${pageData[2] }&rowCnt=${pageData[6]}">&gt;</a></span>
			<span><a id="aTag" href="hostingList.do?pageIdx=${pageData[5] }&rowCnt=${pageData[6]}">&gt;&gt;</a></span>
		</c:if>
	</div>
</c:if>
<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<%@include file ="/layout/Footer.jsp" %>