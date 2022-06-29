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

<c:if test="${check }">
	<script>
		alert("정보 수정 완료")
		location.href = "${pageContext.request.contextPath }/mypage/MyPage_meminfo.jsp";
	</script>
</c:if>
<c:if test="${!check }">
	<script>
		alert("정보 수정 취소")
		location.href = "${pageContext.request.contextPath }/mypage/MyPage_meminfo.jsp";
	</script>
</c:if>

</body>
</html>