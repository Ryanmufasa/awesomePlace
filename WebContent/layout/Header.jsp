<!-- https://github.com/Ryanmufasa/awesomePlace/issues/9 | 작성자 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
	<link href="${contextPath }/resources/css/Header.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
	<script src="${contextPath }/resources/js/jquery-3.6.0.js?v=<%=System.currentTimeMillis() %>" ></script>
	<script src ="${contextPath }/resources/js/Header.js?v=<%=System.currentTimeMillis() %>"></script>
	<script src="${contextPath }/resources/js/Nav.js?v=<%=System.currentTimeMillis() %>"></script>
	<%-- 스크립트 추가 --- 작성자 정다영  --%>
	<script src ="${contextPath }/resources/js/Search.js?v=<%=System.currentTimeMillis() %>" ></script>
	<script src ="${contextPath }/resources/js/LoginNout.js?v=<%=System.currentTimeMillis() %>"></script>
	<%-- --------------------------- --%>
<meta charset="UTF-8">
<title>즐거운 한국여행 어썸플레이스입니다.</title>
	<script>
		<% 
			HttpSession ss1 = request.getSession();
			String mem_id = (String)ss1.getAttribute("mem_id"); //memverVO 포함 세션
			String showAdmin = (String)ss1.getAttribute("showAdmin"); // admin로그인 확인 세션
			String adminPage = (String)ss1.getAttribute("adminPage");// adminPage 진입 확인 세션
			String myPage = (String)ss1.getAttribute("myPage");// myPage진입 확인세션 확인 세션
			String hostingPage = (String)ss1.getAttribute("hostingPage");// hostingPage 진입 확인 세션
		%>
			sessionStorage.setItem("mem_id", "<%=mem_id%>");
			sessionStorage.setItem("showAdmin", "<%=showAdmin%>");
			sessionStorage.setItem("adminPage", "<%=adminPage%>");
			sessionStorage.setItem("myPage", "<%=myPage%>");
			sessionStorage.setItem("hostingPage", "<%=hostingPage%>");
	</script>
</head>
<body>
<header> <!-- 헤더 블록 -->
	<a href="#"><img id="img1" src="${contextPath }/resources/image/temp.png" width="150" ></a>
	
	<div id="title"> <!-- 타이틀 블록 -->
	the AwesomePlace
	</div>
	
	<!-- 로그인 상태에 따라 헤더, 내비게이션 버튼 노출여부 결정 -->
		
			<div class="btns"> 
					<button id="btnMyPage" hidden="true">
						마이페이지</button>
					<button id="btnLogout" hidden="true">
						로그아웃</button>
				
				<button id="btnMyHosting" hidden="true">
					마이호스팅</button>
				<button id="btnLogin" hidden="true">
					로그인</button>
				<button id="btnJoin" hidden="true">
					회원가입</button>
			</div>
			
			<div class="adBtns">
					<button id="btnAdmin" hidden="true">
						관리자 페이지</button>
			</div>
				
	<div id="searchBar"> <!-- 검색창 블록 -->
		<form action="search.do" method="post">
			지역명<input type="search" name="search" size="6" placeholder="모든 지역" >
			<input type="date" min="2022-06-05" name="checkIn" id="checkIn">
			<input type="date" min="2022-06-05" name="checkOut" id="checkOut" disabled>
				<select id="guestCnt" name="guestCnt" onchange="flip();">
					<option value="1">1</option>
					<option value="2" selected>2</option>
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
	<hr>
<div class="mainDiv">
<%@include file ="/layout/Navigation.jsp" %>