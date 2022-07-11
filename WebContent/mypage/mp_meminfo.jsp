<!-- https://github.com/Ryanmufasa/awesomePlace/issues/18 = 작성자 고유주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/Header.jsp" %> 
<%@page import="member.MemberVO"%>
<div id="info" align="center">



<h2><b>정보 수정</b></h2>
<form action="${pageContext.request.contextPath }/mypage/meminfoclear.do">
<table border="1">
<tr><th>이름</th>
	<td colspan="2"><input type="text" name="name" required value="${mem_id.mem_name }" ${!empty mem_id ? "readonly" : "" }></td>
</tr>
<tr><th>아이디</th>
	<td colspan="2"><input type="text" name="id" required value="${mem_id.mem_id }" ${!empty mem_id ? "readonly" : "" }></td>
</tr>
<tr><th>비밀번호</th>
	<td colspan="2"><input type="password" name="mem_pw" id="mem_pw" required value="${mem_id.mem_pw }" ></td>
</tr>
<tr><th>연락처</th>
	<td colspan="2"><input type="tel" name="mem_tel" id="telinput" required value="${mem_id.mem_tel }" maxlength="13"
				onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" ></td>
</tr>
<tr><th>이메일</th>
	<td colspan="2"><input type="text" name="mem_email" id="email1" value="${mem_id.mem_email }" required></td>
</tr>
</table>
</form>

<br><br><br>

<table>
<tr>
	<td><button type="button" id="memUpdate">확인</button></td>
	<td><button type="reset"  onclick="location.href='/awesomePlace/main.do'">취소</button></td>
	<!-- onclick="location.href='/awesomePlace/mypage/mpmeminfo.do'" -->
</tr>
</table>
</div>	 


<script>

$(function(){
	
	var membtn = document.getElementById('memUpdate');
	
	membtn.addEventListener('click', (event)=>{
		var pw = $('#mem_pw').val(); //alert(pw);
		var tel = $('#telinput').val(); //alert(tel);
		var email = $('#email1').val(); //alert(email);
		
		
		var data = {
				"mem_pw" : pw,
				"mem_tel" : tel,
				"mem_email" : email
			}
		
		$.ajax({
			async : true,
			type : 'post',
			url : "/awesomePlace/mypage/meminfoclear.do",
			cache : false,
			data : data,
			datatype : 'json',
			success : function(result){
				var result = parseInt(result);
				alert(result);
				if(result != 1){
					alert('수정 에러')
				}else{
					alert('수정완료')
				}
				
			},
			error : function(e1){
				alert('error');
			}
		});
	});
					
});
</script>  


<%@ include file="/layout/Footer.jsp" %> 