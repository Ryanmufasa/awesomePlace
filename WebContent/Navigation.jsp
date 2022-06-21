<!-- https://github.com/Ryanmufasa/awesomePlace/issues/27 작성자: 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="${contextPath }/resources/js/Nav.js?v=<%=System.currentTimeMillis() %>"></script>
<div class="nav">	<div class="navLine"></div>

	<div id="adminNav" hidden="true">
		<div>
			<a href="QnAList.do">문의목록</a>
		</div>
		<div>
			<a href="memberList.do">회원목록</a>
		</div>
		<div>
			<a href="hostingList.do">호스팅목록</a>
		</div>
	</div>
	
	<div id="myPageNav" hidden="true">
		<div>
			<a href="memberUpdate.do">정보수정</a>
		</div>
		<div>
			<a href="memberLikeList.do">찜 목록</a>
		</div>
		<div>
			<a href="memberResList.do">예약 내역</a>
		</div>
		<div>
			<a href="memberMyHosting.do">마이호스팅</a>
		</div>
		<div>
			<a href="memberQnAList.do">내 문의 확인</a>
		</div>
	</div>
	
	<div id="hostingPageNav" hidden="true">
		<div>
			<a href="memberHostList.do">호스트 목록</a>
		</div>
		<div>
			<a href="memberHostMng.do">호스트 관리</a>
		</div>
		<div>
			<a href="memberHostUpdate.do">호스트 등록</a>
		</div>
	</div>
	
</div>

