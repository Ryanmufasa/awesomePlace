<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>  <!-- https://github.com/Ryanmufasa/awesomePlace/issues/10  //작성자: 양준모 -->
</head>
<body>

<c:if test="${!check }">
	<script>
		location.href = "${pageContext.request.contextPath }/pwfound/result1.jsp";
	</script>
</c:if>
<c:if test="${check }">
	<script>
		alert("실패하였습니다. 다시 시도하여 주십시오.")
		location.href = history.back();
	</script>
</c:if>

</body>
</html>