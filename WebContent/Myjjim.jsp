<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file ="/layout/Header.jsp" %>
<!-- https://github.com/Ryanmufasa/awesomePlace/issues/53 //작성자: 양준모-->
									<!-- 찜목록 보는 페이지 입니다. -->

<style>

#A {
	border-radius: 14px;
	width: 180px;
	height: 180px;
	outline: none;
	border: none;
}

#jjimheart {
	border-bottom-left-radius: 14px;
	border-top-left-radius: 14px;
	outline: none;
	border: none;
}

.box{
  display: inline-block;
  margin: 4%;
}
  
}

.boxing{
  border: 1px solid black;
  cursor:pointer;
  width:250px;
  height:250px;
  margin:auto 0;
  padding:10px;
}

#imgheart {
	width: 40px;
	height: 40px;
}

</style>

<div class="mainDiv-child">

	<c:forEach var="ho" items="${hlist }">
		<div class="box" id="wrapper">
		<button id="jjimheart" onclick="heart();"><a href="${pageContext.request.contextPath }/jjimheart.do?host_num=${ho.getHost_num() }"><img id="imgheart" src="${pageContext.request.contextPath }/image/JJimHeart/colorHeart.png"></a></buttton>
		<button class="boxing" id="A" onclick="location.href='/awesomePlace/search/moreinfo.do?host_name=${host.host_name }&host_num=${host.host_num}'">
			<h2>${ho.getHost_name() } </h2>
			방 개수 ${ho.getRoom_cnt() } 개<br>
			숙박 가능 인원 ${ho.getGuest_cnt() } 명<br> 
			평일 ${ho.getWeekday_amt() }~<br>
			공휴일 ${ho.getWeekend_amt() }~<br>
		</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div> 
	</c:forEach> 
	<c:if test="${empty hlist}">
			<br><br><br><br><br><br>	
			<h1 align="center">찜하신 목록이 없습니다.</h1>
						
	</c:if>
	<br>
	<span id="counter"></span>
</div>


<%@include file ="/layout/Footer.jsp" %>
