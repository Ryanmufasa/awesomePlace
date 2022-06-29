<%@page import="admin.QnaPaging"%>
<%@page import="member.memberDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.memberVO"%>
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
  border-top: 1px solid #444444;
  border-collapse: collapse;
}

th, td {
  border-bottom: 1px solid #444444;
  padding: 10px;
}
  
td { 		
  vertical-align: middle; 		
  padding:5px;		
  border: 1px solid #000;		
  overflow:hidden;		
  white-space : nowrap;		
  text-overflow: ellipsis;	 
}	

td.textOverDefault {		
  white-space : normal;		
  text-overflow: clip; 
}

#title {
  text-decoration: none;
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

<%
	memberDAO dao = new memberDAO();

	String pageNum = request.getParameter("page");
	int current_page = 1;
	if(pageNum != null) {
		current_page = Integer.parseInt(pageNum);
	}
	
	QnaPaging admin = new QnaPaging();
	
	int dataCount = dao.getCount();
	int rows = 4;
	int total_page = admin.pageCount(rows, dataCount);
	if(current_page > total_page) {
		current_page = total_page;
	}
	
	String list_url = "qna1.do";
	String paging = admin.paging(current_page, total_page, list_url);

%>

<div align="center">

	<table>
		<tr>
			<th style="height:30px;background-color:#9c9c9c;color:white;font-weight:normal;">
				문의자
			</th>
			<th style="height:30px;width:1200px;background-color:#9c9c9c;color:white;font-weight:normal;"> 
				제목
			</th>
			<th style="height:30px;background-color:#9c9c9c;color:white;font-weight:normal;">
				등록일자
			</th>
			<th style="height:30px;background-color:#9c9c9c;color:white;font-weight:normal;">
				답변여부
			</th>
		</tr>
<c:forEach var="qvo" items="${list }">
		<tr>
			<td align="center" style="border-top: none;border-left: none;border-right: none;">
				${qvo.getMem_id() }
			</td>
			<td align="center" style="border-top: none;border-left: none;border-right: none;">
				<a id="title" href="${pageContext.request.contextPath }/ASK/view.jsp?qna_num=${qvo.getQna_num() }">${qvo.getQna_title() }</a>
			</td>
			<td align="center" style="border-top: none;border-left: none;border-right: none;">
				${qvo.getQna_date() }
			</td>
			<td align="center" style="border-top: none;border-left: none;border-right: none;">
				${qvo.getQna_sign() }
			</td>
		</tr> 
</c:forEach>

	</table> 
</div> <br>

<div style="padding-top: 20px;">
		<%= paging %>
</div> <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath }/ASK/MyAskForm.do">문의하러 가기</a>

</body>
</html>