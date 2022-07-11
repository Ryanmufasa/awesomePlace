<%--https://github.com/Ryanmufasa/awesomePlace/issues/44  작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/layout/Header.jsp" %>
<link href="${pageContext.request.contextPath }/resources/css/myHostList.css?v=<%=System.currentTimeMillis() %>" 
rel="stylesheet">
<script type="text/javascript" src="${pageContest.request.contestPath }/resources/js/MyHosting.js?v=<%=System.currentTimeMillis() %>"></script>

<div class="mainDiv-child">

<div align="center">
<c:if test="${check }"><%-- 등록된 호스트 정보가 있는 경우 --%>
	
	<c:forEach var="host" items="${myHostList }" >
		<section class="box">
			${host.host_name }<br>
			${host.host_date}<br>
			${host.sign }<br>
			<c:set var="sign" value="${host.sign }"/>
				<c:if test="${fn:contains(sign,'true')}">
					<button type="button" onclick="location.href='/awesomePlace/myhosting/myHostOrderManage.do?host_num=${host.host_num}'">예약 정보 보기</button> 
				</c:if>
				<c:if test="${fn:contains(sign,'false') }">
					<button type="button" onclick="signck()">예약 정보 보기</button>
				</c:if>
		</section>
	</c:forEach>

</c:if>
<c:if test="${!check }"><%-- 등록된 호스트 정보가 없는경우--%>


<p>등록된 호스트 정보가 없습니다.</p>

<button type="button" onclick="location.href='/awesomePlace/myhosting/addNewHostForm.do'">호스팅 시작하기</button>


</c:if>

</div>

<script>

function signck(){
	alert('관리자 승인 후에 예약 관리가 가능합니다!');
}

</script>


<span id="counter"></span>
</div>

<%@ include file="/layout/Footer.jsp" %> 