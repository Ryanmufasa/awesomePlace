<%@page import="java.sql.*"%>
<%@page import="member.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String mem_id = request.getParameter("mem_id");
			String mem_pw = request.getParameter("mem_pw");
			memberDAO dao = memberDAO.getInstance();
			con = new member.memberDBConn().getConnection();	
			
			int selectResult = dao.selectID(mem_id, mem_pw); //회원이 가입 되어있는지 확인
			
			if (selectResult == 1) {
			/* session.setAttribute("id", id); */
			response.sendRedirect("index.jsp"); 		
			
			} else {
%>
		 <script>
		 	alert("로그인 실패")
		 	location.href="loginform.jsp";
		 </script>
			<%}; %>
</body>
</html>