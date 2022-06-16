<%-- https://github.com/Ryanmufasa/awesomePlace/issues/7 -- 작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/layout/Header.jsp" %> 
<%-- <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/tag.css">  --%>
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
			<td><span id="result"><input type="button" value="중복확인" id="idCheck"></span>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td colspan="2"><input type="password" name="pw" id="pw1" class="pw" required></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td colspan="2"><input type="password" id="pw2" class="pw" required>
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
			<td colspan="2"><input type="text" name="email1" required> @ 
				<select name="email2" required>
					<option value="naver.com">네이버</option>
					<option value="gmail.com">구글</option>
					<option value="daum.net">다음</option>
					<option value="nate.com">네이트</option>
				</select>
			
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><input type="submit" value="회원가입하기" id="submit"></td>
			<td><input type="reset" value="취소"></td>
		</tr>
		</table>
</form>
</div>

<%-- <jsp:include page="/layout/footer.jsp"/> --%>
<%@ include file="/layout/Footer.jsp" %> 