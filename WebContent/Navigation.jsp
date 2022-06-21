<!-- https://github.com/Ryanmufasa/awesomePlace/issues/27 작성자: 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="${contextPath }/resources/js/Nav.js?v=<%=System.currentTimeMillis() %>"></script>
<div class="nav">	<div class="navLine"></div>

	<div id="adminNav" hidden="true">
		<div id="navCap">
			<a href="*">문의목록</a>
		</div>
		<div id="navCap">
			<a href="*">회원목록</a>
		</div>
		<div id="navCap">
			<a href="*">호스팅목록</a>
		</div>
	</div>
	
	<div id="myPageNav" hidden="true">
		<div id="navCap">
			<a href="*">정보수정</a>
		</div>
		<div id="navCap">
			<a href="*">찜 목록</a>
		</div>
		<div id="navCap">
			<a href="*">예약 내역</a>
		</div>
		<div id="navCap">
			<a href="*">마이호스팅</a>
		</div>
		<div id="navCap">
			<a href="*">내 문의 확인</a>
		</div>
	</div>
	
	<div id="hostingPageNav" hidden="true">
		<div id="navCap">
			<a href="*">호스트 목록</a>
		</div>
		<div id="navCap">
			<a href="*">호스트 관리</a>
		</div>
		<div id="navCap">
			<a href="*">호스트 등록</a>
		</div>
	</div>
	
</div>

