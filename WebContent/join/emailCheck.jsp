<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int emailCheck = (Integer)request.getAttribute("email1");
out.println(emailCheck);
%>