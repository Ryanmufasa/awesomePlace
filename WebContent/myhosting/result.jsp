<%--https://github.com/Ryanmufasa/awesomePlace/issues/33 
	https://github.com/Ryanmufasa/awesomePlace/issues/42  작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 호스트 등록 후, 호스트 삭제 후, 호스팅 중지 요청 후 결과 화면 --%>
<c:if test="${check }"> <%--호스트 등록 & 삭제 성공, 호스팅 중지 불가일때 --%>
	<c:if test="${empty ck }"> <%-- 중지 서비스에서는 빈 문자열 보냄 --%>
		<script>
			alert('${msg}');
			location.href='/awesomePlace/myhosting/myHostOrderManage.do?host_num=${host_num}';
			// 호스트 예약 목록 창으로 이동
		</script>
	</c:if>
	<c:if test="${!empty ck }"><%-- 등록,삭제 서비스에서는 공백아님--%>
		<script>
			alert("${msg}");
			location.href="/awesomePlace/myhosting/myHostList.do";
			// 회원 호스트 목록 조회 창으로 이동
		</script>
	</c:if>
</c:if>
<c:if test="${!check }"> <%--호스트 등록 & 삭제 실패, 호스팅 중지 결과 --%>
	<c:if test="${empty ck }"><%-- 등록 서비스에서 빈문자열 보냄 --%>
		<script>
			alert("${msg}");
			location.href="/awesomePlace/myhosting/addNewHostForm.do";
			// 새 호스트 등록 창으로 이동
		</script>
	</c:if>
	<c:if test="${!empty ck }"><%-- 삭제,중지 서비스에서는 공백 아님 --%>
		<script>
			alert('${msg}');
			location.href='/awesomePlace/myhosting/myHostList.do';
			// 회원 호스트 목록 조회 창으로 이동
		</script>
	</c:if>
</c:if>

