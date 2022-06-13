<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul{
list-style-type : none;
background-color : #ccc;
width : 25%;
padding : 0;
margin : 0;
position : fixed;
height : 100%;
overflow : auto;
}
li a{
text-decoration : none;
display : block;
color : #000;
padding : 8px 15px 8px 15px;
font-weight : bold;
}
li a:hover:not(.mypagememinfo){
background-color : #333;
color : #fff;
}
</style>
<ul>
<li><a href="#">정보수정</a></li>
<li><a href="#">찜목록</a></li>
<li><a href="#">예약 내역</a></li>
<li><a href="#">마이호스팅</a></li>
<li><a href="#">내 문의 확인</a></li>
</ul>
<meta charset="UTF-8">
<title>내 정보 수정</title>


</head>
<body>

<div class="container" style="text-align: center;">
<div class="form-group">

<tr>
<td>이름 <input type="text" class="form-control" value=${??.name } name="mem_name" maxlength="20" readonly></td><br>
<td>아이디 <input type="text" class="form-control" value=${??.id } name="mem_id" maxlength="20" readonly></td><br>
<td>비밀번호 <input type="text" class="form-control" value=${??.pw } name="mem_pw" maxlength="20"></td><br>
<td>비밀번호 확인 <input type="text" class="form-control" value=${??.pw } name="mem_pwck" maxlength="20"></td><br>
<td>연락처 <input type="text" class="form-control" value=${??.tel } name="mem_tel" maxlength="20"></td><br>

<td>이메일</td>
<input type="text" class="form-control" value=${??.email } maxlength="20" required> @ 
	<select name="mem_email" required>
		<option value="naver.com" maxlength="20">naver.com</option>
		<option value="gmail.com" maxlength="20">google.com</option>
		<option value="daum.net" maxlength="20">daum.com</option>
		<option value="nate.com" maxlength="20">nate.com</option>
	</select>
</div>
</tr>

	<tr>
	<td><input type="submit" value="수정완료"></td>
	<td><input type="reset" value="취소"></td>
	</tr>
	</div>
	</form>
	

</body>
</html>