<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!-- https://github.com/Ryanmufasa/awesomePlace/issues/8  //작성자: 양준모 -->
</head>
<body>

<c:if test="${selectResult == 1 }">
	<script>
		alert("회원정보가 일치합니다.")
		location.href = "${pageContext.request.contextPath }/idfound/idconfirm.jsp";
	</script>
</c:if>
<c:if test="${selectResult == 0 }">
	<script>
		alert("회원 정보가 일치하지 않습니다.")
		location.href = history.back();
	</script>
</c:if>

</body>
</html>