<!-- https://github.com/Ryanmufasa/awesomePlace/issues/39 작성자: 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@include file ="/layout/Header.jsp" %>
<div class="mainDiv-child">

<table border="1">
	<tr><th>문의번호</th><th>문의자</th><th>제목</th><th>등록일자</th><th>답변상태</th></tr>
		<c:forEach var="qnaArr" items="${qnaArr }">
			<tr>
				<td>${qnaArr.qna_num}</td>
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


<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<%@include file ="/layout/Footer.jsp" %>

