<%--https://github.com/Ryanmufasa/awesomePlace/issues/33 -- 작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check }">
	<script>
		alert("${msg}");
		location.href="/awesomePlace/myhosting/memberMyHosting.do";
	</script>
</c:if>
<c:if test="${!check }">
	<script>
		alert("${msg}");
		location.href="/awesomePlace/myhosting/addNewHostForm.do";
	</script>
</c:if>

