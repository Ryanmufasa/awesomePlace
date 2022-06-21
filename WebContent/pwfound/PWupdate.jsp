<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">

<form action="${pageContext.request.contextPath }/pwfound/pwupdate.do" method="get">

	<h1>
	<% String mem_name = (String) session.getAttribute("mem_name"); %>
	<%=mem_name %>님의 비밀번호를 수정하여 주십시오.</h1>
	
	<br><br><br><br><br><br><br><br>
	
	<table >
		<tr>
			<td>
				비밀번호&nbsp;&nbsp;
			</td>
			<td>
				<input type="text" name="mem_pw" style="width:205px;height:30px;" placeholder="비밀번호 수정">
			</td>
		</tr>		
	</table>
	
	<br>
			
			<input type="submit" value="수정" style="width:80px;height:30px;color:white;background-color:#3498db;border:none;cursor:pointer;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" onclick="self.close();" value="취소" style="width:80px;height:30px;border:none;background-color:#bcc1c4;cursor:pointer;">
			
		
</form>

</div>

</body>
</html>