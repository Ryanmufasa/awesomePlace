<%--// https://github.com/Ryanmufasa/awesomePlace/issues/57 -- 작성자 정다영  --%>
<%--임시 페이지  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/layout/Header.jsp" %>    
<div align="center" class="mainDiv">

<c:if test="${check }">



<h2>${msg }</h2>
<c:if test="${!empty InmyPage }">
<a href="${contextPath }/mypage/mpreserinfofirst.do">
예약 내역 확인하기
</a>
</c:if>
<c:if test="${empty InmyPage }">
<a href="${contextPath }/mypage/MyPage.do">
예약 내역 확인하기
</a>

</c:if>


</c:if>
<c:if test="${!check }">

<
<h2>${msg }</h2>

<button type="button" onclick="location.href='main.do'">메인 화면으로</button>
<br>
<button type="button" onclick="location.href='history.back()'">뒤로가기</button>

</c:if>

</div>

<%@ include file="/layout/Footer.jsp" %>
