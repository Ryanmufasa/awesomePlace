<!-- https://github.com/Ryanmufasa/awesomePlace/issues/39 작성자: 이명진 -->
<%@page import="admin.QnAVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@include file ="/layout/Header.jsp" %>

<%	String res = (String)request.getAttribute("QnARes");%>
<script>
	var res = "<%=res%>";
	if(res!="null")
		alert(res);
</script>

<div class="mainDiv-child">
<button id="list">목록으로</button>
<form method="post" action="QnAAnswerForm.do">
	<c:forEach var="QnACon" items="${QnACon }">
			<table border="1" id="QnAAnswer">
				<tr><th>문의번호</th><th>문의자</th><th>등록일자</th></tr>
				<tr><td>${QnACon.qna_num }</td><td>${QnACon.mem_id }</td><td>${QnACon.qna_date }</td></tr>
				<tr><td>제목</td><td colspan="2">${QnACon.qna_title }</td></tr>
				<tr><td colspan="3">${QnACon.qna_content}</td></tr>
			</table>
			<input type="hidden" name="qnaNum" value="${QnACon.qna_num }">
		<c:if test="${QnACon.qna_sign eq 'Wait'}">	
			<textarea name="answer" rows="20" cols="40"></textarea><br>
			<input type="submit" value="답변완료"><input type="reset" value="취소">
		</c:if>
		<c:if test="${QnACon.qna_sign ne 'Wait'}">	
			<textarea name="answer" rows="20" cols="40" >${QnACon.qna_answer }</textarea><br>
			<input type="submit" value="답변수정">
		</c:if>
	</c:forEach>
</form>



<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<%@include file ="/layout/Footer.jsp" %>