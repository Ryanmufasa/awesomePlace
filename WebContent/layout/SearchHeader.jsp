<!-- https://github.com/Ryanmufasa/awesomePlace/issues/9 | 작성자 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 태그 라이브러리 추가 --%> 
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

	<link href="${contextPath }/resources/css/Header.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
	<script src="${contextPath }/resources/js/jquery-3.6.0.js?v=<%=System.currentTimeMillis() %>" ></script>
	<script src ="${contextPath }/resources/js/Header.js?v=<%=System.currentTimeMillis() %>"></script>
	
	<%-- 스크립트 추가 --- 작성자 정다영  --%>
	<script src ="${contextPath }/resources/js/Search.js?v=<%=System.currentTimeMillis() %>" ></script>
	<script src ="${contextPath }/resources/js/LoginNout.js?v=<%=System.currentTimeMillis() %>"></script>
	<%-- --------------------------- --%>	
	
<meta charset="UTF-8">
<title>즐거운 한국여행 어썸플레이스입니다.</title>
</head>
<body>
<header class="header"> <!-- 헤더 블록 -->

	<a href="/awesomePlace/" id="img1"><img src="${contextPath }/resources/image/temp.png" width="150" ></a>
	
	<div id="title"> <!-- 타이틀 블록 -->
	<a href="/awesomePlace/">the AwesomePlace</a>
	</div>

	<div id="btns">

		<div class="btns">		
		<c:choose> <%-- Header.js 대신 임시처리 위해 적용....  --%>
			<c:when test="${login != null  }">
				<c:choose>
					<c:when test="${admin != null }">
						<button class="btn4" onclick="location.href='/awesomePlace/#/admin.do'">관리자 페이지</button> 
						<!--  -->
					</c:when>
					<c:otherwise>
						<button class="btn1" onclick="location.href='/awesomePlace/myhosting/myhosting.do'">마이 호스팅</button>
						<button class="btn6" onclick="location.href='/awesomePlace/mypage/mypage.do'">마이 페이지</button>
					</c:otherwise>
				</c:choose>
				<button class="btn5" onclick="location.href='/awesomePlace/login/logout.do'">로그아웃</button>
			</c:when>
			<c:otherwise>
				<button class="btn1" onclick="checkLogin()">마이 호스팅</button>
				<button class="btn2" onclick="location.href='/awesomePlace/login/loginForm.do'">로그인</button> 
				<button class="btn3" onclick="location.href='/awesomePlace/join/joinForm.do'">회원가입</button>
			</c:otherwise>
		</c:choose>	
		</div>		
	</div>
				
	<div id="searchBar"> <!-- 검색창 블록 -->
		<form action="/awesomePlace/search/search.do" method="post" name="searchForm">
			어디를 갈까? <input type="search" name="search" id="searchInput" size="6" placeholder="어디든지" >
			체크인  <input type="date" min="2022-06-05" name="checkIn" id="checkIn">
			체크아웃 <input type="date" min="2022-06-05" name="checkOut" id="checkOut" disabled>
				숙박인원 선택 <select id="guestCnt" name="guestCnt" onchange="flip();">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="other">그 외</option>
				</select>
			<input type="hidden" 
							id="optionInput" 
							pattern="[1-9]{1}[0-9]{1}" 
							placeholder="10~99" 
							required 
							maxlength="2" size="3"
							onkeyup="this.value = this.value.replace(/[^0-9]/g, '');">
							<!-- IE외 브라우저의 경우 한글입력을 막을 수 없기때문에 위 onkeyup 코드 추가 -->
			<button type="button" name="doSearch" onclick="searchCheck(searchForm)">검색</button>
		</form>
	</div>
	
</header>
	<hr id="hr1">

