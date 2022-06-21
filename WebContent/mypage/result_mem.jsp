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

<c:if test="${check == 1}">
	<script>
		alert("수정완료");
		location.href = "${pageContext.request.contextPath }/mypage/mp_meminfoclear.do";
	</script>
</c:if>
<c:if test="${check == -1}">
	<script>
		alert("취소");
		location.href = "${pageContext.request.contextPath }/mypageinfo/MyPagememinfo.do";
	</script>
</c:if>

</body>
</html>