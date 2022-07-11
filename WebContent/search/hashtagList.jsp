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
<title>Awesome Place 호스트 정보 관리 - 해시 태그 목록</title>
</head>
<body>
<div align="center">
<h3> 해시 태그 목록 </h3>
<c:if test="${tagli != null }">
<table border="1">
<input type="hidden" id="host_num" name="host_num" value="${host_num }">
		<tr>
			<th width="20%"> 번호 </th><th colspan="2"> 해시 태그 </th>
		</tr>
	
	<c:forEach var="tag" items="${tagli }" varStatus="status">
		<tr align="center" >
			<td width="20%">${tag.tag_num }</td>
			<td width="40%">${tag.tag_name }</td>
			<td>
				<button class=getTags id="btn${status.count }">추가하기</button>
				<button class=remTags id="btn${status.count }">삭제하기</button>
			</td>
		</tr>
	</c:forEach>
</table><br>
		<button class="newTag" id="newTag">새로운 해시태그 생성하기</button>
</c:if>
<c:if test="${tagli == null }">
		
			<p>정보 불러오기 실패! 잠시후에 다시 시도해주세요 </p>
		
	</c:if>
<br><br>
<hr><br>
<button type="button" onclick="self.close()">닫기</button>
</div>
</body>
</html>