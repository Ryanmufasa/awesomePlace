<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!-- https://github.com/Ryanmufasa/awesomePlace/issues/10 // 양준모 -->

<style>

	#idfound1 {
		position :absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
	}

</style>

</head>
<body>

<div id="idfound1">

<h1 style="text-align:center;">비밀번호 찾기</h1> <br>

<table>

	<tr>
		<td>
			이름&nbsp;&nbsp;
		</td>
		<td><input type="text" name="irum" style="width:205px;height:30px;"></td>
	</tr>
	
	<tr><td></td><tr><td></td><tr><td></td>
	
	<tr>
		<td>
			아이디&nbsp;&nbsp;
		</td>
		<td><input type="text" name="id" style="width:205px;height:30px;"></td>
	</tr>
	
	<tr><td></td><tr><td></td><tr><td></td>
	
	<tr>
		<td>
			연락처&nbsp;&nbsp;
		</td>
		<td>
			<select name="phone" style="width:70px;height:36px;">
				<option value="010">010</option>
				<option value="02">02</option>
			</select> 
				<input type="text" name="num1" style="width:58px;height:30px;">
				<input type="text" name="num2" style="width:58px;height:30px;">
		</td> 
	</tr>
	
	<tr><td></td><tr><td></td><tr><td></td>
	
	<tr>
		<td>
			이메일&nbsp;&nbsp;
		</td>
		<td>
			<input type="text" name="email" style="width:110px;height:30px;"> @ 
			
			<select name="email" style="width:70px;height:36px;">
				<option value="gmail.com">구글</option>
				<option value="naver.com">네이버</option>
			</select> &nbsp;
			
		<input type="button" value="이메일 인증" style="height:35px;">
		</td> 
	</tr>
	
	<tr><td></td><tr><td></td><tr><td></td>
	
	<tr> <td> </td>
	
		<td>
			<input type="text" style="width:205px;height:30px;" placeholder="인증번호를 입력하세요">
		</td> 
	</tr>
	
</table> <br>
	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="인증완료" style="width:80px;height:40px;color:white;background-color:#3498db;">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" onclick="self.close();" value="취소" style="width:80px;height:40px;"> <br><br> 
						

</div>

</body>
</html>


