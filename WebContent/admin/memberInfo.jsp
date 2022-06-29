<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table border="1" style="width:300px;, left:calc(50% - 150px); margin:auto;">
		<tr><th>회원번호</th><td>${memInfo.mem_num}</td></tr>
		<tr><th>회원명</th><td>${memInfo.mem_name}</td></tr>
		<tr><th>회원 ID</th><td>${memInfo.mem_id}</td></tr>
		<tr><th>전화번호</th><td>${memInfo.mem_tel}</td></tr>
		<tr><th>이메일</th><td>${memInfo.mem_email}</td></tr>
		<tr><th>탈퇴신청여부</th><td>${memInfo.mem_available}</td></tr>
	</table>
	<button style="position:absolute; left:calc(50% - 20px);" onclick="window.close();">닫기</button>
</body>
</html>