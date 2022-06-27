<!-- https://github.com/Ryanmufasa/awesomePlace/issues/18 = 작성자 고유주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int result = (Integer)request.getAttribute("result");
out.println(result);
%>