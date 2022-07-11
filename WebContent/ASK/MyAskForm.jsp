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
								<!-- 문의글 등록을 위한 페이지 입니다. -->
<script src="${contextPath }/resources/js/Main.js?v=<%=System.currentTimeMillis() %>"></script>								

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

#askadd, #exit {
	border-radius: 14px;
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

<%@include file ="/layout/Header.jsp" %>

<c:set var="now" value="<%=new java.util.Date() %>"/> <!-- 오늘 요일 출력 --> 
<fmt:formatDate value="${now}" pattern="E" var="today" />

<%
	Date date = new Date(); /* 오늘 날짜 출력 */
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
	String strdate = simpleDate.format(date);


%>
<div class="mainDiv-child">
	<br><br>
		<h2 align="center">고객문의 페이지입니다.</h2>
	<br><br>
<div align="center">
	<form action="${pageContext.request.contextPath }/ASK/askqna.do" method="post">

	<table>
		<tr>
			<th style="width:200px;height:50px;background-color:#9c9c9c;color:white;" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				제목
			</th>
			<td style="border-top: none; border-left: none;border-right: none;">
				&nbsp;&nbsp;
				<input type="text" name="qna_title" placeholder="제목을 입력해 주세요."
						style="font-size:16px;width:250px;height:20px;border:0;" autocomplete="off" onfocus="this.placeholder=''"
						onblur="this.placeholder='제목을 입력해 주세요.'">
			</td>
		</tr>
		<tr>
			<th style="width:200px;height:50px;background-color:#9c9c9c;color:white;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				문의자
			</th>
			<td style="border-top: none; border-left: none;border-right: none;">
				<% MemberVO vo = (MemberVO) session.getAttribute("mem_id");  %>
				&nbsp;&nbsp;&nbsp;<%=vo.getMem_id() %> 님
			</td>
		</tr>
		<tr>
			<th style="width:200px;height:50px;background-color:#9c9c9c;color:white;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				작성일
			</th>
			<td style="border-top: none; border-left: none;border-right: none;">
				&nbsp;&nbsp;&nbsp;<%=strdate %>
			</td>
		</tr>
		<tr>
			<th style="width:200px;height:200px;background-color:#9c9c9c;color:white;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				내용
			</th>
			<td style="border-top: none; border-bottom: none;border-left: none;border-right: none;">
				&nbsp;&nbsp;
				<textarea name="qna_content" placeholder="&#13;&#10;&#13;&#10;&#13;&#10;문의사항을 입력해 주십시요."
					      id="test_field" style="font-size:16px;width:95%;height:75%;border:0;resize:none;FONT-FAMILY:initial;"
					      onfocus="this.placeholder=''"></textarea> <!-- onblur="this.placeholder='문의사항을 입력해 주십시요.'" -->
			</td>
		</tr>
	</table> <br>
		
		<input type="submit" value="문의등록" id="askadd" style="width:130px;height:40px;background-color:#9ddb8f;color:white;border:none;cursor:pointer;">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="취소" id="exit" onclick="history.go(-2)" style="width:130px;height:40px;background-color:#d7db8f;color:white;border:none;cursor:pointer;"> 
	
	</form>
</div>
<span id="counter"></span>
</div>

<%@include file ="/layout/Footer.jsp" %>

</body>
</html>