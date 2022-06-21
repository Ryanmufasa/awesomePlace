<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/layout/Header.jsp" %>
<script src="${pageContext.request.contextPath }/resources/js/slide.js?v=<%=System.currentTimeMillis()%>"></script>

<div class="mainDiv">
	<div class="mainDiv-child">
		<img id="mainImg" src="${pageContext.request.contextPath }/resources/image/main/1.jpg" height="800px" name="SlideShow">
	</div>
</div>

<%@include file ="/layout/Footer.jsp" %>