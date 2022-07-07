<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!-- 찜목록을 보기위한 테스트 버튼 입니다. //작성자: 양준모 -->
</head>
<body>

<form action="${pageContext.request.contextPath }/jjimlist1.do" method="post">

<input type="submit" value="내 찜목록 확인" style="width:130px;height:40px;background-color:#5e5e5e;color:white;border:none;cursor:pointer;">

</form>

</body>
</html>