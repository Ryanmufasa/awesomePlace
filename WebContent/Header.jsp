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
	// 목적지, 로그인여부(세션 아이디 존재여부), 마이페이지 비밀번호 재확인 여부 를 받아 각 상황에 맞게 페이지 분배하는 함수
		function sessionCheck(url, id, doubleCheck){  
			if(id == null){
				location.assign('login.jsp?url='+url);
			}else if(doubleCheck == null){
				location.assign('doubleCheck.jsp?url='+url);
			}else{
				location.assign('url');
			}
		}
	</script>
</head>
<body>
<header class="header"> <!-- 헤더 블록 -->
	<a href="Main.jsp" id="img1"><img src="./image/temp.png" width="150" ></a>
	
	<div id="title"> <!-- 타이틀 블록 -->
	the AwesomePlace
	</div>
	<% //로그인 상태에 따라 헤더부분 버튼을 다르게 노출함
		boolean adminPage = false;
		boolean doubleCheck = false;
		String id = null;
		HttpSession ss1 = request.getSession(false);
		if(ss1 != null){// 세션 존재여부 확인
		id = (String)request.getSession().getAttribute("id");// id담기
			if(ss1.getAttribute("adminPage")!=null){// 현재 페이지가 adminPage인가?
				adminPage = true;
			}
			if(ss1.getAttribute("doubleCheck")!=null){// 마이페이지 비밀번호 더블체크가 됬었나?
				doubleCheck = true;
			}
		}
		
		
		if(id != null && id.equals("admin")){ %>
			<div id="btns">
				<button class="btn5" onclick="location.assign('logout.do')">
					로그아웃</button>
			</div>
			
			<%if(!adminPage){ %>
			<div id="managerBtn"> <!-- 관리자 버튼 블록 -->
				<button class="btn4" onclick="location.assign('admin.jsp')">
					관리자 페이지</button>
			</div>
			<%}else{ %>
			<div id="managerBtn"> <!-- 관리자 버튼 블록 -->
				<button class="btn6" onclick="location.assign('main.jsp')">
					사용자 페이지</button>
			</div>
		<% }
			
		}else if(id != null){%>
				<div id="btns"> <!-- 일반사용자 로그인 후버튼 블록 -->
					<button class="btn1" onclick="sessionCheck('hosting.jsp',id,doubleCheck);">
						마이호스팅</button>
					<button class="btn4" onclick="sessionCheck('myPage.jsp',id,doubleCheck);">
						마이페이지</button>
					<button class="btn5" onclick="location.assign('logout.do')">
						로그아웃</button>
				</div>
				
		<% }else{ %>
			<div id="btns"> <!-- 일반사용자 로그인 전 버튼 블록 -->
				<button class="btn1" onclick="sessionCheck('hosting.jsp',id,doubleCheck)">
					마이호스팅</button>
				<button class="btn2" onclick="location.assign('login.jsp')">
					로그인</button>
				<button class="btn3" onclick="location.assign('join.jsp')">
					회원가입</button>
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