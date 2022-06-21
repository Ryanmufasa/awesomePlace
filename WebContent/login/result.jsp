<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${selectResult == 1}">
	<script>
		alert("로그인 완료.")
		location.href = "/awesomePlace/";
	</script>
</c:if>
<c:if test="${selectResult == 0}">
	<script>
		alert("로그인 정보가 일치하지 않습니다.")
		location.href = "/awesomePlace/login/loginForm.do";
	</script>
</c:if>

</body>
</html>