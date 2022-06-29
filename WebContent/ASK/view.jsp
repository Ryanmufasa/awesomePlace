<%@page import="member.MemberDAO"%>
<%@page import="admin.QnAVO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="member.MemberVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!-- https://github.com/Ryanmufasa/awesomePlace/issues/40  작성자: 양준모-->

<style>

table, td, th {
  border: 1px solid #444444;
  border-collapse: collapse;
  text-align : left;
  width : 700px;
  height : 30px;

}

th {
 font-weight: 400; 
}

input:focus {
  outline-style: none;
}

textarea:focus {
  outline: none;
}

input {
  width: auto;
}

button {
  position: absolute;
  left: 300px;
  right: 50px;
  top: 0px;
  width: 70px;
  height: 70px;
  border: 0;
  outline: 0;
  background-color: rgba( 255, 255, 255, 0);
}

img { 
  width : 100%;
  height: 100%; 
}

</style>

<style type="text/css">

body{
		font-size: 14px;
		font-family: 맑은 고딕, 나눔고딕, 돋움, sans-serif;
	}
	
</style>

</head>
<body>

<%
	int qna_num = 0;
	if(request.getParameter("qna_num") != null) {
		qna_num = Integer.parseInt(request.getParameter("qna_num"));
	}
	
	QnAVO qo = new MemberDAO().viewqna(qna_num);
%>

<button onclick="history.back()" style="cursor:pointer;"><img src="${pageContext.request.contextPath }/image/qna/back.png"></button>

<div align="center">

	<table style="border-collapse:collapse;">
		<tr>
			<th style="width:200px;height:50px;background-color:#9c9c9c;color:white;" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				제목
			</th>
			<td style="font-size:16px;width:250px;height:20px;border:0;">
				&nbsp;&nbsp;&nbsp;<%=qo.getQna_title() %>
			</td>
		</tr>
		<tr>
			<th style="width:200px;height:50px;background-color:#9c9c9c;color:white;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				문의자
			</th>
			<td>
				&nbsp;&nbsp;&nbsp;<%=qo.getMem_id() %> 님
			</td>
		</tr>
		<tr>
			<th style="width:200px;height:50px;background-color:#9c9c9c;color:white;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				작성일
			</th>
			<td>
				&nbsp;&nbsp;&nbsp;<%=qo.getQna_date() %>
			</td>
		</tr>
		<tr>
			<th style="width:200px;height:200px;background-color:#9c9c9c;color:white;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				내용
			</th>
			<td>
				&nbsp;&nbsp;
				<textarea name="qna_content" placeholder="&#13;&#10;&#13;&#10;&#13;&#10;&#13;&#10;"
					      id="test_field" style="font-size:16px;width:95%;height:75%;border:0;resize:none;FONT-FAMILY:initial;" readonly><%=qo.getQna_content() %></textarea>
			</td>
		</tr>
	</table> 
	
</div>


</body>
</html>