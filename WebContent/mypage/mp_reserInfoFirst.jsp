<!-- https://github.com/Ryanmufasa/awesomePlace/issues/21 = 작성자 고유주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="orderinfo.OrderinfoVO"%>
<%@page import="memberService.MypageorderinfoService" %>
<%@ include file="/layout/Header.jsp" %>
<script src="${contextPath }/js/jquery-3.6.0.js"></script>

<style>
  table {
    width: 50%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    border-left: 1px solid #444444;
    padding: 10px;
  }
  th:first-child, td:first-child {
    border-left: none;
  }
</style> 

<div id="reser" align="center">
<form action="${pageContext.request.contextPath }/mypage/mpreserinfofirst.do">
<h1><b>예약내역</b></h1>
<br><br>
<c:if test="${check }">
<table border="1">
<tr><td>예약번호</td><td>호스트명</td></tr>
<c:forEach var="reser" items="${reser}">
<tr>
<td><a href = "/awesomePlace/mpreserinfo.do?oi_num=${reser.oi_num}">${reser.oi_num}</a></td>
<td>${reser.oi_host_name}</td>
</tr>
</c:forEach> 
</table>
</c:if>

<c:if test="${!check }">
<br><br>
<h2><b>예약한 내역이 없습니다.</b></h2>
</c:if>

</form>
</div>

<%@ include file="/layout/Footer.jsp" %>