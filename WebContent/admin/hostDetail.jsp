<!-- https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<link href="${contextPath }/resources/css/Header.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
<link href="${contextPath }/resources/css/adminPage.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
<script src="${contextPath }/resources/js/jquery-3.6.0.js?v=<%=System.currentTimeMillis() %>" ></script>
<script src ="${contextPath }/resources/js/adminPage.js?v=<%=System.currentTimeMillis() %>"></script>
<script>
	<% 
		String res = (String)request.getAttribute("switchRes"); 
		request.removeAttribute("switchRes");
	%>
	var res ="<%=res%>";
	$(document).ready(function(){
		if(res!="null")
			alert("변경완료");
	});
	
</script>
</head>
<body>
	<h1 align="center">${hostDetail.host_name} 상세정보</h1>
	<table border="1" style="width:400px;, left:calc(50% - 150px); margin:auto;">
		<tr><th>No.${hostDetail.host_num}</th><th>${hostDetail.host_name}</th></tr>
		<tr><th>등록자</th>
			<td>
				<a href="#" onclick="memDetail(${hostDetail.mem_num}); return false;">${hostDetail.mem_id}</a>
			</td>
		</tr>
		<tr><th>등록일자</th><td>${hostDetail.host_dateS}</td></tr>
		<tr><th>주소</th><td>${hostDetail.host_addr}</td></tr>
		<tr><th>우편번호</th><td>${hostDetail.host_post_num}</td></tr>
		<tr><th>전화번호</th><td>${hostDetail.host_tel}</td></tr>
		<tr><th>방 종류</th><td>${hostDetail.room_type}</td></tr>
		<tr><th>방 개수</th><td>${hostDetail.room_cnt}</td></tr>
		<tr><th>총 수용인원</th><td>${hostDetail.guest_cnt}</td></tr>
		<tr><th>평일(일~목) 가격</th><td>${hostDetail.weekday_amt}</td></tr>
		<tr><th>주말(금~토), 공휴일전 가격</th><td>${hostDetail.weekend_amt}</td></tr>
		<tr><th>호스트 활성화</th><td>${hostDetail.sign}</td></tr>
		<tr><th>활성화 전환</th>
			<td>
				<button id="queueConfirm" onclick="switchHostSign(${hostDetail.host_num},'${hostDetail.sign }');">
						<c:if test="${hostDetail.sign eq 'true' }">호스트 비활성화</c:if>
						<c:if test="${hostDetail.sign eq 'false' }">호스트 활성화</c:if>
				</button>
			</td>
		</tr>
	</table>
	<br>
	<button style="position:absolute; left:calc(50% - 20px);" onclick="openerReload();">닫기</button>
</body>
</html>