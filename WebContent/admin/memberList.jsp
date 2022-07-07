<!-- https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진 -->
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@include file ="/Header.jsp" %>
<script src ="${contextPath }/resources/js/adminPage.js?v=<%=System.currentTimeMillis() %>"></script>
<script>
	<% 
		String res = (String)request.getAttribute("switchRes"); 
		request.removeAttribute("switchRes");
	%>
	var res ="<%=res%>";
	$(document).ready(function(){
		if(res!="null")
			alert("변경완료");
	});
</script>
<div class="mainDiv-child">
<table border="1">
	<tr><th>회원번호</th><th>회원 아이디</th><th>회원명</th><th>회원 활성화</th><th>관리항목</th></tr>
		<c:forEach var="memList" items="${memList }">
			<tr> 
				<td>${memList.mem_num}</td>
				<td><a href="#" onclick="memDetail(${memList.mem_num}); return false;">${memList.mem_id}</a></td>
				<td>${memList.mem_name}</td>
				<td>${memList.mem_sign }</td>
				<td>
				<c:if test="${memList.mem_hostingcnt > 0}">
					<button onclick="memHostList(${memList.mem_num});">호스트 목록 : ${memList.mem_hostingcnt}개</button>
				</c:if>
				<button onclick="switchSign(${memList.mem_num},'${memList.mem_sign}');">
					<c:if test="${memList.mem_sign eq 'Y' }">회원 비활성화</c:if>
					<c:if test="${memList.mem_sign eq 'N' }">회원 활성화</c:if>
				</button>
				</td>
			</tr>
		</c:forEach>	
</table>

<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<%@include file ="/Footer.jsp" %>