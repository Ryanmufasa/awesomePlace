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

<c:if test="${selectResult != null }">
	<script>
		alert("로그인 완료.")
		location.href = "${pageContext.request.contextPath }/Main.jsp";
	</script>
</c:if>
<c:if test="${selectResult == null}">
	<script>
		alert("로그인 정보가 일치하지 않습니다.")
		location.href = "loginform.jsp";
	</script>
</c:if>

</body>
</html>