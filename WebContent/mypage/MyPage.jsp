<title>Insert title here</title>  <!-- https://github.com/Ryanmufasa/awesomePlace/issues/13  //작성자: 양준모 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/Header.jsp" %>

<div align="center">

	<h1>마이페이지 조회 시 비밀번호 재확인이 필요합니다.</h1> <br><br><br><br>
	
	<form action="${pageContext.request.contextPath }/mypage/mypagePW.do" method="post">
	
	<table>
	
		<tr>
			<td>
				비밀번호 &nbsp;&nbsp;
			</td> 
			<td>
				<input autocomplete="false" type="password" name="mem_pw" style="width:205px;height:30px;" placeholder="비밀번호">
			</td>
		</tr>
	</table> <br><br><br>
	
	<input type="submit" value="비밀번호 확인" style="width:100px;height:40px;background-color:#3498db;color:white;border:none;">
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소" style="width:100px;height:40px;background-color:#3498db;color:white;border:none;">
	
	</form>
	
</div>
<span id="counter"></span>
<%@ include file="/layout/Footer.jsp" %>