<!-- https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자 : 이명진 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<link href="${contextPath }/resources/css/Header.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
<link href="${contextPath }/resources/css/adminPage.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
<script src="${contextPath }/resources/js/jquery-3.6.0.js?v=<%=System.currentTimeMillis() %>" ></script>
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
</head>
<body>
<h1 align="center">${memHostList[0].mem_num }번 회원의 호스팅 목록</h1>
	<table border="1" style="width:700px;, left:calc(50% - 150px); margin:auto;">
		<tr><th>호스트번호</th><th>호스트명</th><th>호스트주소</th><th>전화번호</th><th>활성화여부</th></tr>
		<c:forEach var="memHL" items="${memHostList }" varStatus="idx">
			<tr>
				<td>${memHL.host_num }</td>
				<td><a href="#" onclick="hostDetail(${memHL.host_num}); return false;">${memHL.host_name}</a></td>
				<td>${memHL.host_addr }</td>
				<td>${memHL.host_tel }</td>
				<td>${memHL.sign }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<button style="position:absolute; left:calc(50% - 20px);" onclick="window.close();">닫기</button>
</body>
</html>