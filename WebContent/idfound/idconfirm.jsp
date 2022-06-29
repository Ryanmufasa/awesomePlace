<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!-- https://github.com/Ryanmufasa/awesomePlace/issues/8  //작성자: 양준모 -->

</head>
<body>

<div align="center">

	<br><br><br><br><br><br><br><br><br><br><br><br>

	<h1>
		<% String mem_name = (String) session.getAttribute("mem_name"); %>
<%-- 		<% String mem_id = (String) session.getAttribute("mem_id"); %>
		<%=mem_name %>님의 아이디는 "<%=mem_id %>" 입니다.
		 --%>
		<% 
			request.setCharacterEncoding("utf-8");

			String mem_tel = (String) session.getAttribute("mem_tel");

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String dbUrl="jdbc:oracle:thin:@192.168.1.140:1521:xe";

			String dbUser="hr";

			String dbPass="hr";

			Connection con=DriverManager.getConnection(dbUrl, dbUser, dbPass);

			String sql="SELECT mem_id FROM member WHERE mem_tel=?";

			PreparedStatement pstmt=con.prepareStatement(sql);

			pstmt.setString(1, mem_tel);

			ResultSet rs=pstmt.executeQuery();

		%>

 

		<% while(rs.next()){%> 
		
			<%=mem_name %>님의 아이디는 "<%=rs.getString("mem_id")%>" 입니다.

		<%} %>
	</h1>

</div>

</body>
</html>