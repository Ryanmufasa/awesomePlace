<!-- https://github.com/Ryanmufasa/awesomePlace/issues/14 = 작성자 고유주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp" %> 
</head>
<body>
<script src="${pageContext.request.contextPath }/resources/js/Mypage_hostmov.js"></script>
<form action="#" method="post">
<div id="hostadd" style="text-align : center;">
<br><br>
<h2><b>등록된 호스트하우스가 없습니다ㅠㅠ<br>
호스트를 시작하고 수입을 창출해보세요~:)</b></h2>
<br><br><br>
<a href="/awesomePlace/myhosting/addNewHostForm.jsp">등록하러 가기</a>
</div>
</form>


<%@ include file="/layout/footer.jsp" %> 