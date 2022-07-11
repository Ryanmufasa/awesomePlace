<!-- https://github.com/Ryanmufasa/awesomePlace/issues/39 작성자: 이명진 -->
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
	<button class="scopeBtn" id="scope10" onclick="scopeClickQnA(${pageData[0]}, 10)">10</button>
	<button class="scopeBtn" id="scope20" onclick="scopeClickQnA(${pageData[0]}, 20)">20</button>
	<button class="scopeBtn" id="scope50" onclick="scopeClickQnA(${pageData[0]}, 50)">50</button>
</div>
</c:if>
<br><h1 align="center">문의 목록</h1><br>
<table border="1">
	<tr><th>문의번호</th><th>문의자</th><th>제목</th><th>등록일자</th><th>답변상태</th></tr>
<!-- int [] pageData = {page[0],begin[1],end[2],rowStart[3],rowEnd[4],totalCnt[5],rowCnt[6]} -->
		<c:forEach var="qnaArr" items="${qnaArr }">
			<tr>
				<th>${qnaArr.qna_num}</th>
				<td>${qnaArr.mem_id}</td>
				<td><a href="QnAAnswerForm.do?idx=${qnaArr.qna_num}">${qnaArr.qna_title}</a></td>
				<td>${qnaArr.qna_date}</td>
				<c:if test="${qnaArr.qna_sign eq 'Wait'}">
					<td>대기</td>
				</c:if>
				<c:if test="${qnaArr.qna_sign eq 'Done'}">
					<td>답변완료</td>
				</c:if>
			</tr>
		</c:forEach>	
</table>
<br><br>
<!-- int [] pageData = {page[0],begin[1],end[2],rowStart[3],rowEnd[4],totalCnt[5],rowCnt[6]} -->
<c:if test="${pageData[1] ne pageData[5]}">
	<div class="paging">
		<c:if test="${pageData[0] ne 1}">
			<span><a id="aTag" href="QnAList.do?pageIdx=1&rowCnt=${pageData[6]}">&lt;&lt;</a></span>
			<span><a id="aTag" href="QnAList.do?pageIdx=${pageData[0]-1 }&rowCnt=${pageData[6]}">&lt;</a></span>
		</c:if>
			<c:forEach varStatus="idx" begin="${pageData[1] }" end="${pageData[2] }" step="1">
				<c:if test="${pageData[0] eq idx.current }">
					<span><a id="currentPage" href="QnAList.do?pageIdx=${idx.current }&rowCnt=${pageData[6]}">
					${idx.current }</a></span>
				</c:if>
				<c:if test="${pageData[0] ne idx.current }">
					<span><a id="aTag" href="QnAList.do?pageIdx=${idx.current }&rowCnt=${pageData[6]}">
					${idx.current }</a></span>
				</c:if>
			</c:forEach>
		<c:if test="${pageData[0] ne pageData[2]}">
			<span><a id="aTag" href="QnAList.do?pageIdx=${pageData[2] }&rowCnt=${pageData[6]}">&gt;</a></span>
			<span><a id="aTag" href="QnAList.do?pageIdx=${pageData[5] }&rowCnt=${pageData[6]}">&gt;&gt;</a></span>
		</c:if>
	</div>
</c:if>

<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<%@include file ="/layout/Footer.jsp" %>

