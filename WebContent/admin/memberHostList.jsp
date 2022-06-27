<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table border="1" style="width:700px;, left:calc(50% - 150px); margin:auto;">
		<tr><th>호스트번호</th><th>호스트명</th><th>호스트주소</th><th>전화번호</th><th>활성화여부</th></tr>
		<c:forEach var="memHL" items="${memHostList }">
			<tr>
				<td>${memHL.host_num }</td>
				<td>${memHL.host_name }</td>
				<td>${memHL.host_addr }</td>
				<td>${memHL.host_tel }</td>
				<td>${memHL.sign }</td>
			</tr>
		</c:forEach>
	</table>
	<button style="position:absolute; left:calc(50% - 20px);" onclick="window.close();">닫기</button>
</body>
</html>