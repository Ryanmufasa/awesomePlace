<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!-- https://github.com/Ryanmufasa/awesomePlace/issues/5  // 양준모 -->
</head>
<body>

<%
	String from = (String) session.getAttribute("URL");
	System.out.println(from);
%>

<c:if test="${selectResult != null }">
	<script>
		alert("로그인 완료.")
		location.href= "<%=from %>" 
	</script>

</c:if>
<c:if test="${selectResult == null}">
	<script>
		alert("로그인 정보가 일치하지 않습니다.")
		location.href = "${pageContext.request.contextPath }/login/loginform.do";
	</script>
</c:if>

</body>
</html>