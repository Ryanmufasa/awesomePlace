<!-- https://github.com/Ryanmufasa/awesomePlace/issues/9 | 작성자 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐거운 한국여행 어썸플레이스입니다.</title>
	<link href="./css/Header.css" rel="stylesheet">
	<script>
		function goTo(a){
			alert("1");
			document.location.assign(a+'.do');
		}
	</script>
</head>
<body>
<header class="header"> <!-- 헤더 블록 -->
	<a href="Main.jsp" id="img1"><img src="./image/temp.png" width="150" ></a>
	
	<div id="title"> <!-- 타이틀 블록 -->
	the AwesomePlace
	</div>
	<%
		String id = null;
		HttpSession ss1 = request.getSession(false);
		if(ss1 != null){
		id = (String)request.getSession().getAttribute("id");
		}
		
		if(id != null && id.equals("admin")){ %>
			<div id="btns">
				<button class="btn5">로그아웃</button>
			</div>
			<div id="managerBtn"> <!-- 관리자 버튼 블록 -->
				<button class="btn4">관리자 페이지</button>
			</div>
		<% }else if(id != null){%>
				<div id="btns"> <!-- 일반사용자 로그인 후버튼 블록 -->
					<button class="btn1" onclick="goTo('hosting');">마이호스팅</button>
					<button class="btn4">마이페이지</button>
					<button class="btn5">로그아웃</button>
				</div>
		<% }else{ %>
			<div id="btns"> <!-- 일반사용자 로그인 전 버튼 블록 -->
				<button class="btn1" onclick="goTo('hosting')">마이호스팅</button>
				<button class="btn2">로그인</button>
				<button class="btn3">회원가입</button>
			</div>
		<% }%>			
	<div id="searchBar"> <!-- 검색창 블록 -->
		<form action="search.do" method="post">
			<select name="category" style=height:30px;>
				<option>지역명</option>
				<option>키워드명</option>
			</select>
			<input type="search" name="search" size="40" style=height:30px;>
			<button type="submit" name="doSearch" value="검색" style=height:30px;>검색</button>
		</form>
	</div>
	
</header>
	<hr id="hr1">