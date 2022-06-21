<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="member.MemberVO"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul {
	list-style-type: none;
	background-color: #ccc;
	width: 25%;
	padding: 0;
	margin: 0;
	position: fixed;
	height: 100%;
	overflow: auto;
}

li a {
	text-decoration: none;
	display: block;
	color: #000;
	padding: 8px 15px 8px 15px;
	font-weight: bold;
}

li a:hover:not(.mypagememinfo) {
	background-color: #333;
	color: #fff;
}
</style>
<ul>
	<li><a href="#">정보수정</a></li>
	<li><a href="#">찜목록</a></li>
	<li><a href="#">예약 내역</a></li>
	<li><a href="#">마이호스팅</a></li>
	<li><a href="#">내 문의 확인</a></li>
</ul>
<meta charset="UTF-8">
<title>마이페이지 예약내역</title>
</head>
<body>

<table>
<%
List<#VO> reserList=(List<#VO>)request.getAttribute("reserList");
%>

<tr>
<h2>예약내역</h2>

<div class="container" style="text-align: center;">
<table>
<tr>
<td>예약번호</td>
<td>호스트이름</td>
<td>회원이름</td>
<td>예약인원</td>
<td>예약일자</td>
<td>지불가격</td>
<td>예약승인</td>
</tr>

<%
	if(reserList.isEmpty()){
%>
<tr>
<td colspan="5" align="center">예약내역이 없습니다</td>
</tr>
<%} else {
int resernum=0;
for(#VO vo : reserList)
{
resernum=totalCount--;
%>

<tr align="center"><td><%=resernum %></td>
<td align="center"><%=vo.get# %></td>
<td align="center"><%=vo.get# %></td>
<td align="center"><%=vo.get# %></td>
<td align="center"><%=vo.get# %></td>
<td align="center"><%=vo.get# %></td>
<td align="center"><%=vo.get# %></td>
<td align="center"><%=vo.get# %></td>

</div>
</tr>
</table>
</table>
</body>
</html> --%>