<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/layout/header.jsp" %> 
</head>
<body>
<script src="${pageContext.request.contextPath }/resources/js/Mypage_hostmov.js"></script>
<form action="#" method="post">
<div id="hostadd" style="text-align : center;">
<h2><b>등록된 호스트하우스가 없습니다ㅠㅠ<br>
호스트를 시작하고 수입을 창출해보세요~:)</b></h2>
<a href="/awesomePlace/myhosting/addNewHostForm.jsp"">등록하러 가기</a>
</div>
</form>


<%@ include file="/layout/footer.jsp" %> 
</body>
</html>