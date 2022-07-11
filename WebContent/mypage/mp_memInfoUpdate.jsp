<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
int result = (Integer)request.getAttribute("result");
//int result = (Integer)session.getAttribute("result");
//out.println("수정완료");
out.println(result);
%> 

