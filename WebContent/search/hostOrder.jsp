<%--// https://github.com/Ryanmufasa/awesomePlace/issues/57 -- 작성자 정다영  --%>
<%--임시 페이지  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/layout/SearchHeader.jsp" %>    

<c:if test="${check }">


<div align="center" class="mainDiv">

<h2>${msg }</h2>

<a href="#">
예약 내역 확인하기
</a>


</div>

</c:if>
<c:if test="${!check }">

<div align="center" class="mainDiv">

<h2>${msg }</h2>

<a href="/awesomePlace/">
홈으로
</a>


</div>

</c:if>


<%@ include file="/layout/SearchFooter.jsp" %>
