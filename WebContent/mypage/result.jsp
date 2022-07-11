<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>  <!-- https://github.com/Ryanmufasa/awesomePlace/issues/13  //작성자: 양준모 -->
</head>
<body>

<c:if test="${selectResult == 1}">
	<script>
		alert("비밀번호 확인 완료")
		location.href = "${pageContext.request.contextPath }/mypage/mpmeminfo.do";
	</script>
</c:if>
<c:if test="${selectResult == -1}">
	<script>
		alert("비밀번호가 일치하지 않습니다.")
		location.href = "${pageContext.request.contextPath }/mypage/MyPage.do";
	</script>
</c:if>

</body>