<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/layout/header.jsp" %> 
<%@page import="member.MemberVO"%>
<script src="${contextPath }/js/jquery-3.6.0.js"></script>
<div id="info" align="center">

<form action="${pageContext.request.contextPath }/mypage/mpmeminfo.do">
<%MemberVO mb = (MemberVO)session.getAttribute("mb"); %>

<h2><b>정보 수정</b></h2>
<table border="1">
<tr><td>이름</td><td colspan="2"><input type="text" name="name" required value="<%=mb.getMem_name() %>" readonly></td></tr>
<tr><td>아이디</td><td colspan="2"><input type="text" name="id" required value="<%=mb.getMem_id() %>" readonly></td></tr>
<tr><td>비밀번호</td><td colspan="2"><input type="password" name="mem_pw" id="mem_pw" required value="<%=mb.getMem_pw() %>" ></td></tr>
<!-- <tr><td>비밀번호 확인</td>
<td colspan="2"><input type="password"  name="pw2" class="pw" id="mem_pw_chk" required>
<span id="pwCheck"></span>
</td></tr> -->
<tr><td>연락처<td colspan="2">
<input type="tel" name="mem_tel" id="telinput" required value="<%=mb.getMem_tel() %>" maxlength="13"
				onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" >
<tr><td>이메일<td colspan="2">
<input type="text" name="mem_email" id="email1" value="<%=mb.getMem_email() %>" required></td></tr>
</table>
</form>


<table>
<tr>
<td><button type="button" onclick="memUpdate()">회원가입하기</button></td>
<td><button type="reset">취소</button></td>
</tr>
</table>

</div>	 
<script>
function memUpdate(){
	
	var pw = $('#mem_pw').val();
	var tel = $('#telinput').val();
	var email = $('#email1').val();
	
	var data = { 
					mem_pw : pw,
					mem_tel : tel,
					mem_email : email
				}
	
	$.ajax({
		async : true,
		type : 'get',
		url : "/awesomePlace/mypage/meminfoclear.do",
		cache : false,
		data : data,
		datatype : 'JSON',
		success : function(result){
			console.log(result);
			if(result > 0) {
				alert("회원수정 완료");
			} else {
				alert("회원수정 실패");
			}
			
		}, error : function(e1){
			alert('error');
		}
	})
	
	
	
	
	
	
	
	
}





</script>


<%@ include file="/layout/footer.jsp" %> 