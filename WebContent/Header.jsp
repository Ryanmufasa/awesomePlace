<!-- https://github.com/Ryanmufasa/awesomePlace/issues/9 | 작성자 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
	<link href="${contextPath }/resources/css/Header.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
	<script src="${contextPath }/resources/js/jquery-3.6.0.js?v=<%=System.currentTimeMillis() %>" ></script>
	<script src ="${contextPath }/resources/js/Header.js?v=<%=System.currentTimeMillis() %>"></script>
<meta charset="UTF-8">
<title>즐거운 한국여행 어썸플레이스입니다.</title>
</head>
<body>
<header> <!-- 헤더 블록 -->
	<img id="img1" src="${contextPath }/resources/image/temp.png" width="150" >
	
	<div id="title"> <!-- 타이틀 블록 -->
	the AwesomePlace
	</div>
	
	<!-- 로그인 상태에 따라 헤더, 내비게이션 버튼 노출여부 결정 -->
		
			<div class="btns"> 
			
			 <!-- 관리자 로그인 후 버튼 -->
			 		<!-- 로그아웃 버튼 -->
					<button id="btnAdmin">
						관리자 페이지</button>
			
				<!-- 일반사용자 로그인 후버튼 블록 -->
					<!-- 마이호스팅 버튼 -->
					<button id="btnMyPage">
						마이페이지</button>
					<button id="btnLogout">
						로그아웃</button>
				
			<!-- 일반사용자 로그인 전 버튼 블록 -->
				<button id="btnMyHosting">
					마이호스팅</button>
				<button id="btnLogin">
					로그인</button>
				<button id="btnJoin">
					회원가입</button>
			</div>
				
	<div id="searchBar"> <!-- 검색창 블록 -->
		<form action="search.do" method="post">
			지역명<input type="search" name="search" size="6" placeholder="모든 지역" >
			<input type="date" min="2022-06-05" name="checkIn" id="checkIn">
			<input type="date" min="2022-06-05" name="checkOut" id="checkOut" disabled>
				<select id="guestCnt" onchange="flip();">
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
			<button type="submit" name="doSearch" value="검색" >검색</button>
		</form>
	</div>
	
</header>
	<hr id="hr1">