<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul{
list-style-type : none;
background-color : #ccc;
width : 25%;
padding : 0;
margin : 0;
position : fixed;
height : 100%;
overflow : auto;
}
li a{
text-decoration : none;
display : block;
color : #000;
padding : 8px 15px 8px 15px;
font-weight : bold;
}
li a:hover:not(.mypagememinfo){
background-color : #333;
color : #fff;
}
</style>

<meta charset="UTF-8">
<title>내 정보 수정</title>


</head>
<%@include file ="/layout/Header.jsp" %>
<body>
<ul>
<li><a href="#">정보수정</a></li>
<li><a href="#">찜목록</a></li>
<li><a href="#">예약 내역</a></li>
<li><a href="/awesomePlace/myhosting/myhosting.do">마이호스팅</a></li>
<li><a href="#">내 문의 확인</a></li>
</ul>

<%@include file ="/layout/upperNavigation.jsp" %>
<div class="mainDiv-child">
<form>
<div class="container" style="text-align: center;">
<div class="form-group">

이름 <input type="text" class="form-control" value=${login.name } name="mem_name" maxlength="20" readonly><br>
아이디 <input type="text" class="form-control" value=${login.id } name="mem_id" maxlength="20" readonly><br>
비밀번호 <input type="text" class="form-control" value=${login.pw } name="mem_pw" maxlength="20"><br>
비밀번호 확인 <input type="text" class="form-control" value=${login.pw } name="mem_pwck" maxlength="20"><br>
연락처 <input type="text" class="form-control" value=${login.tel } name="mem_tel" maxlength="20"><br>
이메일<input type="text" class="form-control" value=${login.email } maxlength="20" required><br>

</div>



	<input type="submit" value="수정완료">
	<input type="reset" value="취소">

	</div>
</form> 
	

<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>

<%@include file ="/layout/Footer.jsp" %>