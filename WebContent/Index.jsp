<!-- https://github.com/Ryanmufasa/awesomePlace/issues/6 | 작성자 이명진 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file ="Header.jsp" %>
<script src="${contextPath }/resources/js/Main.js?v=<%=System.currentTimeMillis() %>"></script>

<%	
	String[] imgList = {"1","2","3","4","5","6","7","8","9","10","11"}; // 이미지파일 이름 배열화
	String temp="";
	for(int i=0;i<100;i++){ //이미지파일 이름배열 랜덤화
		int idx=(int)(Math.floor(Math.random()*11)); 
		temp=imgList[0];
		imgList[0] = imgList[idx];
		imgList[idx] = temp;
	}
	%>
	
<div class="mainDiv">
<%@include file ="Navigation.jsp" %>
	<div class="mainDiv-image">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[0] %>.jpg" height="800px">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[1] %>.jpg" height="800px">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[2] %>.jpg" height="800px">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[3] %>.jpg" height="800px">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[4] %>.jpg" height="800px">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[5] %>.jpg" height="800px">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[6] %>.jpg" height="800px">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[7] %>.jpg" height="800px">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[8] %>.jpg" height="800px">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[9] %>.jpg" height="800px">
			<img id="imgIdx" src="${contextPath }/resources/image/main/<%=imgList[10] %>.jpg" height="800px">
	</div>
</div>

<%@include file ="Footer.jsp" %>