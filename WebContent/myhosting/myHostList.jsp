<%--https://github.com/Ryanmufasa/awesomePlace/issues/44  작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/layout/Header.jsp" %>
<style>
.box{
  width: 200px;
  height: 100px;
  border: 1px solid black;
  margin: auto;
  transition: all 0.5s;
  transition-delay: 0.2s;
}
.box:hover{
  box-shadow: 5px 5px 20px;
}

</style>
<div class="mainDiv-child">

<div align="center">
<c:if test="${check }"><%-- 등록된 호스트 정보가 있는 경우 --%>
	
	<c:forEach var="host" items="${myHostList }" >
		<section class="box">
			${host.host_name }<br>
			${host.host_date}<br>
			${host.sign }<br>
			<button onclick="location.href='/awesomePlace/myhosting/myHostOrderManage.do?host_num=${host.host_num}'">예약 관리</button>
			<button onclick="warning()">호스팅 중지</button>
		</section>
		
	</c:forEach>

</c:if>
<c:if test="${!check }"><%-- 등록된 호스트 정보가 없는경우--%>


<p>등록된 호스트 정보가 없습니다.</p>

<button type="button" onclick="location.href='/awesomePlace/myhosting/addNewHostForm.do'">호스팅 시작하기</button>


</c:if>

</div>

<script>
function warning(){
	if(confirm("정말 호스팅을 중지하시겠습니까?") == true){
		
	}
}
</script>


<span id="counter"></span>
</div>

<%@ include file="/layout/Footer.jsp" %> 