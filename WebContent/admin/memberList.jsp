<!-- https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진 -->
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@include file ="/Header.jsp" %>
<script src ="${contextPath }/resources/js/memberList.js?v=<%=System.currentTimeMillis() %>"></script>
<div class="mainDiv-child">
<table border="1">
	<tr><th>회원번호</th><th>회원 아이디</th><th>회원명</th><th>회원 활성화</th><th>관리항목</th></tr>
		<c:forEach var="memList" items="${memList }">
			<tr onload="memHostCheck(${memList.mem_num})">
				<td>${memList.mem_num}</td>
				<td><a href="#" onclick="memInfo(${memList.mem_num}); return false;">${memList.mem_id}</a></td>
				<td>${memList.mem_name}</td>
				<td>${memList.mem_available }</td>
				<td>
				<c:if test="${memList.mem_hostingcnt > 0}">
					<button onclick="memHostList(${memList.mem_num});">호스트 목록 : ${memList.mem_hostingcnt}개</button>
				</c:if>
				<c:if test="${memList.mem_available eq 'Y' }">
					<button onclick="unavailable(${memList.mem_num});">회원강퇴</button>
				</c:if>
				<c:if test="${memList.mem_available eq 'N' }">
					<button onclick="available(${memList.mem_num});">회원복구</button>
				</c:if>
				</td>
			</tr>
		</c:forEach>	
</table>

<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<%@include file ="/Footer.jsp" %>