<!-- https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.js?v=<%=System.currentTimeMillis() %>" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/addHashtag.js?v=<%=System.currentTimeMillis() %>"></script>
<title>해시 태그 목록</title>
</head>
<body>
<div align="center">
<table>
		<tr>
			<th>태그 번호 </th><th>태그 명</th><th>     </th>
		</tr>
	<c:if test="${tagli != null }">
	<c:forEach var="tag" items="${tagli }" varStatus="status">
		<tr>
			<td>${tag.tag_num }</td>
			<td>${tag.tag_name }</td>
			<td>
				<button class=getTags id="btn${status.count }">추가하기</button>
			</td>
		</tr>
	</c:forEach></c:if>
	<c:if test="${tagli == null }">
		<tr>
			<td colspan="3">정보 불러오기 실패! 잠시후에 다시 시도해주세요 </td>
		</tr>
	</c:if>
</table>
<br><br>
<hr><br>
<button type="button" onclick="self.close()">닫기</button>
</div>
</body>
</html>