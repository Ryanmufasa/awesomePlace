<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int checkResult = (Integer)request.getAttribute("result");
out.println(checkResult);
%>