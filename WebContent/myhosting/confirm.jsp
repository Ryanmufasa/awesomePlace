<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int confirmResult = (Integer)request.getAttribute("confirmResult");
out.println(confirmResult);
%>
