<!-- https://github.com/Ryanmufasa/awesomePlace/issues/18 = 작성자 고유주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/layout/header.jsp" %> 
<%@page import="member.MemberVO"%>
<script src="${contextPath }/js/jquery-3.6.0.js"></script>
<div id="info" align="center">



<h2><b>정보 수정</b></h2>
<form action="${pageContext.request.contextPath }/mypage/mpmeminfo.do">
<table border="1">
<tr><th>이름</th><td colspan="2"><input type="text" name="name" required value="${mb.mem_name }" ${!empty mb ? "readonly" : "" }></td></tr>
<tr><th>아이디</th><td colspan="2"><input type="text" name="id" required value="${mb.mem_id }" ${!empty mb ? "readonly" : "" }></td></tr>
<tr><th>비밀번호</th><td colspan="2"><input type="password" name="mem_pw" id="mem_pw" required value="${mb.mem_pw }" ></td></tr>
<tr><th>연락처<th colspan="2">
<input type="tel" name="mem_tel" id="telinput" required value="${mb.mem_tel }" maxlength="13"
				onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" >
<tr><th>이메일<th colspan="2">
<input type="text" name="mem_email" id="email1" value="${mb.mem_email }" required></td></tr>
</table>
</form>


<table>
<tr>
<br><br><br>
<td><button type="button" onclick="memUpdate()">확인</button></td>
<td><button type="reset" onclick="location.href='/awesomePlace/mypage/mpmeminfo.do'">취소</button></td>
</tr>
</table>
</div>	 


    <script>
	function memUpdate(){
	
	var pw = $('#mem_pw').val();
	var tel = $('#telinput').val();
	var email = $('#email1').val();
	var data = {
					"mem_pw" : pw,
					"mem_tel" : tel,
					"mem_email" : email
	} 
	

	$.ajax({
		async : true,
		type : 'get',
		url : "/awesomePlace/mypage/meminfoclear.do",
		cache : false,
		data : data,
		datatype : 'json',
		success : function(result){
			
//			console.log(result);
alert(result);
/* 			if(result == 1) {
				alert("수정 완료");
			} else {
				alert("취소");
			}  */
			
		},
		error : function(e1){
			alert('error');
		}
	});
	
	}
</script>  






<%@ include file="/layout/footer.jsp" %> 