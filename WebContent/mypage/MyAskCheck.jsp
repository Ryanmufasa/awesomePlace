<%@page import="member.MemberVO"%>
<%@page import="admin.QnAPaging"%>
<%@page import="member.MemberDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="admin.QnAVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 문의 확인</title> <!--  https://github.com/Ryanmufasa/awesomePlace/issues/46  //작성자: 양준모 -->

<style>

table, td, th {
  width: 700px;

}

table {
  border-top: none;
  border-collapse: collapse;
  position: relative;
  top: 50px;
}

th, td {
  border-bottom: 1px solid #444444;
  padding: 10px;
}

th {
	border-bottom: none;
}
  
td { 		
  vertical-align: middle; 		
  padding:5px;		
  border: 1px solid #000;		
  overflow:hidden;		
  white-space : nowrap;		
  text-overflow: ellipsis;
  border: none;
  text-align: center;
}	

td.textOverDefault {		
  white-space : normal;		
  text-overflow: clip; 
}

#title12 {
  text-decoration: none;
}

#left {
	border-top-left-radius:14px;
	border-bottom-left-radius:14px;
}
#right {
	border-top-right-radius:14px;
	border-bottom-right-radius:14px;
}
#goMoonee {
	position: relative;
	left: 250px;
}

</style>

<style type="text/css">
	*{
		margin: 0; padding: 0;
		box-sizing: border-box;
		
	}
	
	body{
		font-size: 14px;
		font-family: 맑은 고딕, 나눔고딕, 돋움, sans-serif;
	}
	
	.paginate {
		text-align: center;
		font-size: 14px;
		
	}
	
	.paginate a {
		border: 1px solid #ccc;
		color: #000;
		font-weight: 600;
		text-decoration: none;
		padding: 3px 7px;
		margin-left: 3px;
		vertical-align: middle;
	}
	
	.paginate a:hover, .paginate a:active {
		color: #cb3536;
	}
	
	.paginate span {
		border: 1px solid #e28d8;
		color: #6771ff;
		font-weight: 600;
		text-decoration: none;
		padding: 3px 7px;
		margin-left: 3px;
		vertical-align: middle;
	}
	
	.paginate :first-child {
		margin-left: 0;
	}
	
	.container {
		width: 700px;
		margin: 30px auto;
	}
</style>

</head>
<body>

<% String paging = (String) session.getAttribute("paging"); %>
<%@include file ="/layout/Header.jsp" %>
<div class="mainDiv-child">
<div align="center">

	<table>
		<tr>
			<th id="left" style="height:30px;background-color:#9ddb8f;color:white;font-weight:normal;">
				문의자
			</th>
			<th style="height:30px;width:1200px;background-color:#9ddb8f;color:white;font-weight:normal;"> 
				제목
			</th>
			<th style="height:30px;background-color:#9ddb8f;color:white;font-weight:normal;">
				등록일자
			</th>
			<th id="left" style="height:30px;background-color:#9ddb8f;color:white;font-weight:normal;">
				답변여부
			</th>    
		</tr>
<c:forEach var="qvo" items="${list }">
		<tr>
			<td>
				${qvo.getMem_id() }
			</td>
			<td>
				<a id="title12" href="${pageContext.request.contextPath }/ASK/view.jsp?qna_num=${qvo.getQna_num() }">${qvo.getQna_title() }</a>
			</td>
			<td>
				${qvo.getQna_date() }
			</td>
			<td >
				${qvo.getQna_sign() }
			</td>
		</tr> 
</c:forEach>

	</table> 
<c:if test="${empty list}">
	<br><br><br><br><br><br>			
	<h1>문의하신 목록이 없습니다.</h1>


</c:if>
</div> <br>

<div style="padding-top: 20px;">
		<%= paging %>
</div> <br>


<div align="left" id="goMoonee">
<a href="${pageContext.request.contextPath }/ASK/MyAskForm.do">문의하러 가기</a>
</div>


</div>

<%@include file ="/layout/Footer.jsp" %>
</body>
</html>