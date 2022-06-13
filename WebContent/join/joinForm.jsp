<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="#.jsp" %> 
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/tag.css"> 
--%>
<script>

$(function(){
	$('#pw1').on("keyup", function(){
		var pw1 = $('#pw1').val();
		pw = lengthCheck(pw1);
	})
	
	$('#pw2').on("keyup", function(){
		var pw2 = $('#pw2').val();
		repw = lengthCheck(pw2);
	})
	
	let ppww = document.querySelector('#pw2');
	ppww.addEventListener("blur",e=>{
		var pw1 = $('#pw1').val();
		var pw2 = $('#pw2').val();
		pwck = pwCheck(pw1,pw2);
		
	})
	
	$('#telinput').on("keyup", function(){
		var tel = $(this).val();
		tel = autoHypenTel(tel);
		$(this).val(tel);
	})
})
	
function lengthCheck(pw){
	if(pw.length < 6){
		$('#pwCheck').text("비밀번호는 6글자 이상 입력")
		$('#submit').attr("disabled", "disabled");
		return false;
	}else{
		$('#pwCheck').text("")
		return true;
	}
}

function pwCheck(pw1,pw2){
	if(pw2 != pw1){
		$('#pwCheck').text("비밀번호가 일치하지 않습니다.");
		return false;
	}else {
		$('#pwCheck').text("비밀번호가 일치합니다.")
		$('#submit').removeAttr("disabled");
		return true;
	}
}

function autoHypenTel(tel){
	var tmp = '';
	
	if(tel.length < 4){
		return tel;
	} else if(tel.length < 7){
		tmp += tel.substr(0,3);
		tmp += '-';
		tmp += tel.substr(3);
		return tmp;
	} else if(tel.length < 11){
		tmp += tel.substr(0,3);
		tmp += '-';
		tmp += tel.substr(3,3);
		tmp += '-';
		tmp += tel.substr(6);
		return tmp;
	} else {
		tmp += tel.substr(0,3);
		tmp += '-';
		tmp += tel.substr(3,4);
		tmp += '-';
		tmp += tel.substr(7);
		return tmp;
	}
	
}

</script>


<div align="center">
<form action="#" method="post" >
	<table border="1">
		<tr>
			<td>이름</td>
			<td colspan="2"><input type="text" required></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" required></td>
			<td><button onclick="#">중복확인</button></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td colspan="2"><input type="password" required></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td colspan="2"><input type="password" required></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td colspan="2">
				<input type="tel" id="telinput" required maxlength="13"
				onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"
				placeholder="-를 제외한 휴대폰번호 입력">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td colspan="2"><input type="text" required> @ 
				<select name="email" required>
					<option value="naver.com">네이버</option>
					<option value="gmail.com">구글</option>
					<option value="daum.net">다음</option>
					<option value="nate.com">네이트</option>
				</select>
			
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td><input type="submit" value="회원가입하기"></td>
			<td><input type="reset" value="취소"></td>
		</tr>
		</table>
</form>
</div>

<%-- <%@ include file="#.jsp" %> --%>
