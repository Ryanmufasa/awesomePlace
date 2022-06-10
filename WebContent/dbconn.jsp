<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Connection Pool 테스트를 위한 임시 페이지 -->
<%!
	Connection con = null;
	DataSource ds = null;
	
%>

<% 

	try{
		Context iniCtx = new InitialContext();
		Context ctx = (Context) iniCtx.lookup("java:comp/env/");
		DataSource ds = (DataSource)ctx.lookup("jdbc/oracle");
		
		con = ds.getConnection();
		System.out.println("DBCP 연동 성공 ");
	}catch(NamingException ne){
		ne.printStackTrace();
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		try{
			if(con != null) con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


%>



</body>
</html>