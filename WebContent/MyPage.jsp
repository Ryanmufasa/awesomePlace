<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

	header {
	
		background-color: #339999;
		height: 100px;	
	}

	nav {
	
		background-color: #dfe7f0;
		width: 300px;
		float: left;	
	}
	
	section {

		text-align: left;
		width: 1100px;
		float: left;
		padding: 10px;
	
	}
	
	footer {
	
		background-color: #FFCC00;
		height: 100px;
		clear: both;
	}
	
	header, nav, section, footer {text-align: center;}
	header, footer {line-height: 100px;}
	nav, section {line-height: 95px;}

</style>

</head>
<body>

<header>
	<h2>HEADER 부분</h2>
</header>

<nav>
	<a href="">정보수정</a> <br>	
	<a href="">찜목록</a> <br>	
	<a href="">예약내역</a> <br>
	<a href="">마이호스팅</a> <br>
	<a href="">내문의 확인</a> <br>	
</nav>

<section>

	<h1>마이페이지 조회 시 비밀번호 재확인이 필요합니다.</h1>
	
	비밀번호  &nbsp;&nbsp;  
	<input autocomplete="false" type="password" name="pw" id="key" style="width:205px;height:30px;" placeholder="비밀번호">
	<br>
	
	<input type="submit" value="비밀번호 확인" style="width:100px;height:40px;background-color:#3498db;color:white;">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" onclick="self.close();" value="취소" style="width:100px;height:40px;background-color:#3498db;color:white;">
	
</section>

<footer>
	<h2>FOOTER 부분</h2>
</footer>
    
</body>
</html>