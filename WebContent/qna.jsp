<%@ page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!--  내 문의글 목록을 보기 위한 테스트 버튼입니다.  //작성자: 양준모 -->
</head>
<body>	

<form action="${pageContext.request.contextPath }/qna1.do" method="post">

<input type="submit" value="내 문의 확인" style="width:130px;height:40px;background-color:#5e5e5e;color:white;border:none;cursor:pointer;">

</form>

<br><br>

<input type="button" value="로그인" onclick="location.href='${pageContext.request.contextPath }/login/loginform.do'" style="width:130px;height:40px;background-color:#5e5e5e;color:white;border:none;cursor:pointer;">

 
 <% session.setAttribute("URL" , "http://localhost:6571/awesomePlace/qna.jsp"); %>

</body>
</html> 

