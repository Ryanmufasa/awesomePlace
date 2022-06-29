<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check }">
	<script>
		alert("${msg}");
		location.href="/awesomePlace/";
	</script>
</c:if>
<c:if test="${!check }">
	<script>
		alert("${msg}");
		location.href="/awesomePlace/join/joinForm.do";
	</script>
</c:if>

