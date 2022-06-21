<%-- https://github.com/Ryanmufasa/awesomePlace/issues/7 -- 작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Header.jsp" %> 
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/joinForm.css?v=<%=System.currentTimeMillis()%>">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/joinForm.js?v=<%=System.currentTimeMillis()%>"></script>

<div id="loginForm" class="mainDiv" align="center">
<form action="${pageContext.request.contextPath }/join/join.do" method="post" name="loginForm">
	<table border="1">
		<tr>
			<td>이름</td>
			<td colspan="2"><input type="text" name="name" required></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" id="id" required></td>
			<td>
			<button type="button" name="idCheck" id="idCheck" disabled>중복확인</button>
			<span id="result1"></span>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td colspan="2"><input type="password" name="pw" id="pw1" class="pw" required></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td colspan="2"><input type="password"  name="pw2" id="pw2" class="pw" required>
				<span id="pwCheck"></span>
			</td>
		</tr>
		<tr>
			<td>연락처</td>
			<td colspan="2">
				<input type="tel" name="tel" id="telinput" required maxlength="13"
				onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"
				placeholder="-를 제외한 휴대폰번호 입력">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email1" id="email1" required> @ 
				<select name="email2" id="email2" required>
					<option value=" ">선택해주세요</option>
					<option value="naver.com">네이버</option>
					<option value="gmail.com">구글</option>
					<option value="daum.net">다음</option>
					<option value="nate.com">네이트</option>
				</select>
			</td>
			<td>
			<button type="button" name="emailCheck" id="emailCheck" disabled>중복확인</button>
			<span id="result2"></span>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><button type="button" onclick="allCheck(loginForm);">회원가입하기</button></td>
			<td><button type="reset">초기화</button></td>
			<td><button type="button" id="back">돌아가기</button></td>
		</tr>
		</table>
	<br><br>
	<span id="msg"></span>
</form>
</div>

<%-- <jsp:include page="/layout/footer.jsp"/> --%>
<%@ include file="/Footer.jsp" %> 