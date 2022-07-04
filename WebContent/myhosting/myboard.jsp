<%--https://github.com/Ryanmufasa/awesomePlace/issues/44  작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/layout/Header.jsp" %>
<!-- 테스트를 위한 임시 페이지 -->
<div class="mainDiv-child">

<button onclick="location.href='/awesomePlace/myhosting/addNewHostForm.do'">새 호스트 등록하기 (기존 작성)</button> 
<br>
<button onclick="location.href='/awesomePlace/addHost/addNewHostTypeCheck.do'">새 호스트 등록하기(테스트)</button>
<br>
<button onclick="location.href='/awesomePlace/myhosting/myHostList.do'">내 호스트 관리</button>

<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<%@ include file="/layout/Footer.jsp" %> 