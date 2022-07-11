<%--https://github.com/Ryanmufasa/awesomePlace/issues/44 작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/Header.jsp" %>
<link href="${pageContext.request.contextPath }/resources/css/myHostList.css?v=<%=System.currentTimeMillis() %>" 
rel="stylesheet">

<div class="mainDiv-child">


<div align="center">
<c:if test="${check }"><%-- 등록된 호스트 정보가 있는 경우 --%>
	
	<c:forEach var="host" items="${myHostList }" >
		<section class="box">
			${host.host_name }<br>
			${host.host_date}<br>
			${host.sign }<br>
			<button type="button" onclick="location.href='/awesomePlace/myhosting/updateHostInfoForm.do?host_num=${host.host_num}'">정보 수정하기</button>
			<br>
			<c:set var="sign" value="${host.sign }"/>
				<c:if test="${fn:contains(sign,'true')}">
					<button type="button" onclick="location.href='/awesomePlace/myhosting/myHostOrderManage.do?host_num=${host.host_num}'">예약 관리</button> 
					<br>
					<button type="button" onclick='warning("${host.host_num}")'>호스팅 중지</button>
				</c:if>
				<c:if test="${fn:contains(sign,'false') }">
					<button type="button" onclick="signck()">예약 관리</button><br>
					<button type="button" onclick='deleteck("${host.host_num}")'>호스트 삭제</button>
				</c:if>
		</section>
	</c:forEach>

</c:if>
<c:if test="${!check }"><%-- 등록된 호스트 정보가 없는경우--%>


<p>등록된 호스트 정보가 없습니다.</p>
<br>
<button type="button" onclick="location.href='/awesomePlace/myhosting/addNewHostForm.do'">호스팅 시작하기</button>


</c:if>

</div>

<script>
function warning(f){
	var f1 = f;
	alert(f1);
	var lo1 = "/awesomePlace/myhosting/stopHosting.do?host_num="+f1;
	if(confirm("정말 호스팅을 중지하시겠습니까?") == true){
		location.href=lo1;
	}
}
function signck(){
	alert('관리자 승인 후에 예약 관리가 가능합니다!');
}
function deleteck(f){
	alert(f);
	var f = f;
	var lo = "/awesomePlace/myhosting/deleteMyHost.do?host_num="+f;
	alert(lo);
	if(confirm('아직 관리자 승인 전입니다! 해당 호스트를 삭제하시겠습니까?') == true){	
		if(confirm('현재 호스트 삭제시 삭제된 데이터는 복구되지 않습니다. 정말 삭제하시겠습니까?') == true){
			location.href=lo;
		}
	} 
} 
</script>


<span id="counter"></span>
</div>

<%@ include file="/layout/Footer.jsp" %> 