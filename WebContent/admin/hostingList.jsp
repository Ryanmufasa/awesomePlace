<!-- https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진 -->
<%@page import="member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@include file ="/Header.jsp" %>
<script src ="${contextPath }/resources/js/memberList.js?v=<%=System.currentTimeMillis() %>"></script>
<div class="mainDiv-child">
<table border="1">
	<tr><th>하우스 이름</th><th>회원 아이디</th><th>등록일자</th><th>활성화여부</th><th>활성화 버튼</th></tr>
		<c:forEach var="hostList" items="${hostList }">
			<tr> 
				<td><a href="#" onclick="hostInfo(${hostList.host_num}); return false;">${hostList.host_name}</a></td>
				<td>
					<c:forEach var="memInfo" items="${memInfo }">
						<c:if test="${hostList.mem_num eq memInfo.mem_num }">
							${memInfo.mem_id }
						</c:if>
					</c:forEach>
				</td>
				<td>${hostList.host_dateS}</td>
				<td>${hostList.sign }</td>
				<td>
					<button onclick="switchHostAvailable(${hostList.host_num},'${hostList.sign }');">
						<c:if test="${hostList.sign eq 'true' }">호스트 비활성화</c:if>
						<c:if test="${hostList.sign eq 'false' }">호스트 활성화</c:if>
					</button>
				</td>
			</tr>
		</c:forEach>	
</table>

<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<%@include file ="/Footer.jsp" %>