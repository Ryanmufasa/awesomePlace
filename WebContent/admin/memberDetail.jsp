<!-- https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자 : 이명진 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
	<script src="${contextPath }/resources/js/jquery-3.6.0.js?v=<%=System.currentTimeMillis() %>" ></script>
	<script src ="${contextPath }/resources/js/adminPage.js?v=<%=System.currentTimeMillis() %>"></script>
<meta charset="UTF-8">
<title></title>
	<% 
		String res = (String)request.getAttribute("memDelRes"); 
		request.removeAttribute("memDelRes");
	%>
<script>
	var res ="<%=res%>";
	$(document).ready(function(){
		if(res=="true"){
			opener.parent.location.reload();
			window.close();
		}
	});
</script>
</head>
<body>
<c:if test="${res ne 'true'}">
	<table border="1" style="width:300px;, left:calc(50% - 150px); margin:auto;">
		<tr><th>회원번호</th><td>${memInfo.mem_num}</td></tr>
		<tr><th>회원명</th><td>${memInfo.mem_name}</td></tr>
		<tr><th>회원 ID</th><td>${memInfo.mem_id}</td></tr>
		<tr><th>전화번호</th><td>${memInfo.mem_tel}</td></tr>
		<tr><th>이메일</th><td>${memInfo.mem_email}</td></tr>
		<tr><th>보유 호스트 개수</th><td>${memInfo.mem_host_Cnt}</td></tr>
		<tr><th>회원 활성화</th><th>${memInfo.mem_sign}
		<c:if test="${memInfo.mem_sign eq 'N'}">
			&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="memberDelete(${memInfo.mem_num});">탈퇴확인</button>
		</c:if>
		</th></tr>
	</table>
	<button style="position:absolute; left:calc(50% - 20px);" onclick="window.close();">닫기</button>
</c:if>
</body>
</html>