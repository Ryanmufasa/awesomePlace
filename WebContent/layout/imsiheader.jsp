<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐거운 한국여행 어썸플레이스입니다.</title>
<link type="text/css" href="${pageContext.request.contextPath }/resources/css/Header.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.js"></script>
</head>

<body>
<header class="header">
<%-- 	<a href="/awesomePlace/" id="img1"><img src="${pageContext.request.contextPath }/resources/image/temp.png" width="150" ></a> --%>
	
	<div id="title"> <!-- 타이틀 블록 -->
	<a href="/awesomePlace/">the AwesomePlace</a>
	</div>
	
	<c:choose>
		<c:when test="${login != null  }">
			<c:choose>
				<c:when test="${admin != null }">
					<button class="btn4" onclick="location href='/awesomePlace/#/admin.do'">관리자 페이지</button> 
					<!--  -->
				</c:when>
				<c:otherwise>
					<button class="btn1" onclick="location href='/awesomePlace/#/myhosting.do'">마이 호스팅</button>
					<button class="btn6" onclick="location href='/awesomePlace/#/mypage.do'">마이 페이지</button>
				</c:otherwise>
			</c:choose>
			<button class="btn5" onclick="location href='/awesomePlace/#/logout.do'">로그아웃</button>
		</c:when>
		<c:otherwise>
<!-- 
			<button class="btn1" onclick="location href='/awesomePlace/#/myhosting.do'">마이 호스팅</button>
			<button class="btn2" onclick="location href='/awesomePlace/#/login.do'">로그인</button> -->
			
			<button class="btn3"  onclick="location href='/awesomePlace/join/joinForm.do';">회원가입</button>
			 <a href="/awesomePlace/join/joinForm.do">회원가입</a> 
			 
		</c:otherwise>
	</c:choose>

	<div id="searchBar"> <!-- 검색창 블록 -->
		<form action="search.do" method="post">
			<select name="category" style=height:30px;>
				<option value="none">선택해주세요</option>
				<option value="region">지역명</option>
				<option value="keyword">키워드명</option>
			</select>
			<input type="search" name="search" size="40" style=height:30px;>
			<button type="submit" name="doSearch" value="검색" style=height:30px;>검색</button>
		</form>
	</div>

</header>
	<hr id="hr1">
