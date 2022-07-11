<%--https://github.com/Ryanmufasa/awesomePlace/issues/44  작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/layout/Header.jsp" %>

<div align="center">

<h2>보안을 위해 비밀번호를 한번 더 입력해주세요!</h2>
<br><br><br>

<form action="${contextPath }/myhosting/pwCheck.do" method="post">
	<table >
		<tr>
			<td> 비밀번호  <td>
			<td>
			<input type="password" name="repw" id="repw"
			autocomplete="false" placeholder="비밀번호를 입력하세요!">
			</td>
		</tr>
	</table>
	<br><br>
	<button type="button" id="checkPw" >비밀번호 확인</button>
	<button type="button" onclick="history.back()">취소</button>
</form>

<span id="counter"></span> 	
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/MyHosting.js?v=<%=System.currentTimeMillis() %>"></script>
<%@ include file="/layout/Footer.jsp" %> 