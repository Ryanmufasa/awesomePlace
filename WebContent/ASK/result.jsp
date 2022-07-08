<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!-- https://github.com/Ryanmufasa/awesomePlace/issues/40  작성자: 양준모-->
</head>				
<body>

<c:if test="${check == 1}">
	<script>
	alert("등록이 완료되었습니다.");
	location.href = "${pageContext.request.contextPath }/qna1.do";
	</script>
</c:if>
<c:if test="${check == 0}">
	<script>
		alert("등록 실패")
		location.href = history.back();
	</script>
</c:if>

</body>
</html>