<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file ="/layout/Header.jsp" %>
<%@page import="member.MemberVO"%>
<br><br><br><br><br><br><br><br><br><br>
<div id="info" style="text-align: center;">

<form action="${pageContext.request.contextPath }/mypage/mpmeminfo.do">
<%MemberVO mb=(MemberVO)request.getAttribute("mb"); %>
<input type="hidden" name=action value=info>
<h2><b>정보 수정</b></h2>
<table>
<tr><td>이름</td><td>${mb.mem_name }</td></tr>
<tr><td>아이디</td><td>${mb.mem_id }</td></tr>
<tr><td>비밀번호</td><td>${mb.mem_pw }</td></tr>
<tr><td>연락처</td><td>${mb.mem_tel }</td></tr>
<tr><td>이메일</td><td>${mb.mem_email }</td></tr>
</table>
<!--  <tr><td>이름</td><td>${vo.mem_name }</td></tr>-->
</form>

<!--  onclick="location.href='${pageContext.request.contextPath }/mypage/Mypage_meminfoclear.jsp'"-->
<input type="submit" value="수정완료" 
style="width:130px;height:40px;background-color:#5e5e5e;color:white;border:none;cursor:pointer;">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="취소" 
style="width:100px;height:40px;background-color:#3498db;color:white;border:none;">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type=hidden name=action value=insert>

</div>	 

<br><br><br><br><br><br><br><br>    
<hr> 
<%@ include file="/layout/Footer.jsp" %> 
</body>
</html>