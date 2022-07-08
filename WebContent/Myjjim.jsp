<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>  <!-- https://github.com/Ryanmufasa/awesomePlace/issues/53 //작성자: 양준모-->
									<!-- 찜목록 보는 페이지 입니다. -->
<style>

.box{
  margin: 4%;
}

.boxing{
  border: 1px solid black;
  cursor:pointer;
  width:250px;
  height:200px;
  margin:auto 0;
  padding:10px;
}

</style>

</head>
<body>

	<c:forEach var="ho" items="${hlist }">
		<div class="box" style="float:left;" id="wrapper">
		<button class="boxing" id="A" onclick="location.href='/awesomePlace/search/moreinfo.do?host_name=${host.host_name }&host_num=${host.host_num}'">
			<h2>${ho.getHost_name() }</h2>
			방 개수 ${ho.getRoom_cnt() } 개<br>
			숙박 가능 인원 ${ho.getGuest_cnt() } 명<br> 
			평일 ${ho.getWeekday_amt() }~<br>
			공휴일 ${ho.getWeekend_amt() }~<br>
		</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div> 
	</c:forEach> 

</body>
</html>