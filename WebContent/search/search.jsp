<%--https://github.com/Ryanmufasa/awesomePlace/issues/23 -- 작성자 정다영  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/Header.jsp" %>
<!-- 테스트 위해 임시로 구현한 내용입니다. UI 변경 예정 -->
<div align="center"  class="mainDiv">
<h1>검색결과 조회 </h1>
	<div>
		<div>호스트명</div>
	</div>


	<table border="1">
		<tr>
			<th>호스트명</th>
		</tr>
	<c:forEach var="host" items="${hostli }">
		<tr>
			<td><a href="moreinfo.do=?name=${host.host_name }">${host.host_name }</a></td>
		</tr>
	</c:forEach>
	</table>
</div>

<%@ include file="/layout/Footer.jsp" %>
