<!-- https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file ="/layout/Header.jsp" %>
<script src ="${contextPath }/resources/js/adminPage.js?v=<%=System.currentTimeMillis() %>"></script> 

<div class="mainDiv-child">
<table border="1">
	<tr><th>하우스 이름</th><th>회원 아이디</th><th>등록일자</th><th>활성화여부</th></tr>
		<c:forEach var="hostList" items="${hostList}">
			<tr> 
				<td><a href="#" onclick="hostDetail(${hostList.host_num}); return false;">${hostList.host_name}</a></td>
				<td>${hostList.mem_id }</td>
				<td>${hostList.host_dateS}</td>
				<td>${hostList.sign }</td>
			</tr>
		</c:forEach>	
</table>

<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<%@include file ="/layout/Footer.jsp" %>