<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="${contextPath }/js/jquery-3.3.1.js"></script>
<script src="${contextPath }/js/Main.js"></script>

<style>



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
	
	table {
	
    	margin:auto; 
	}
	
	nav, section {text-align: center;}
	nav, section {line-height: 95px;}

</style>

</head>
<body>

<%@ include file="/layout/header.jsp" %>

<div class="mainDiv">

<nav>
	<a href="">정보수정</a> <br>	
	<a href="">찜목록</a> <br>	
	<a href="">예약내역</a> <br>
	<a href="">마이호스팅</a> <br>
	<a href="">내문의 확인</a> <br>	
</nav>

<section>

	<h1>마이페이지 조회 시 비밀번호 재확인이 필요합니다.</h1>
	
	<form action="${pageContext.request.contextPath }/mypage/mypagePW.do">
	
	<table>
	
		<tr>
			<td>
				비밀번호 &nbsp;&nbsp;
			</td> 
			<td>
				<input autocomplete="false" type="password" name="mem_pw" style="width:205px;height:30px;" placeholder="비밀번호">
			</td>
		</tr>
	</table>
	
	<input type="submit" value="비밀번호 확인" style="width:100px;height:40px;background-color:#3498db;color:white;border:none;">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소" style="width:100px;height:40px;background-color:#3498db;color:white;border:none;">
	
	</form>
	
</section>

</div>

    
</body>
</html>