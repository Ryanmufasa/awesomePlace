<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> <!--  https://github.com/Ryanmufasa/awesomePlace/issues/10  //작성자: 양준모 -->
<script src="${contextPath }/js/jquery-3.6.0.js"></script>

<style>
	#mem_pw {
		 border-radius: 14px;
    	 border-right: #888888 1px solid;
         border-left: #888888 1px solid;
         border-top: #888888 1px solid;
         border-bottom: #888888 1px solid;
    }
    
    #pwupdate, #exit {
    	border-radius: 14px;
    }

</style>

<script>

function chkPW(){

	 var pw = $("#mem_pw").val();

	 if(pw.length < 6 || pw.length > 20){

	  alert("6자리 ~ 20자리 이내로 입력해주세요.");
	  return false;
	  console.log("실패"); 
	 }else {
		 return true;
		 console.log("통과"); 
	 }
}

</script>

</head>
<body>

<div align="center">

<form action="${pageContext.request.contextPath }/pwfound/pwupdate.do" method="post">
	<br>
	<h1>
	<% String mem_name = (String) session.getAttribute("mem_name"); %>
	<%=mem_name %>님 비밀번호를 수정하여 주십시오.</h1>
	
	<br><br><br><br><br><br><br><br>
	
	<table >
		<tr>
			<td>
				비밀번호&nbsp;&nbsp;
			</td>
			<td>
				<input type="password" name="mem_pw" id="mem_pw" style="width:205px;height:30px;" placeholder=" 비밀번호 수정">
			</td>
		</tr>		
	</table>
	
	<br>
			
			<input type="submit" onclick="chkPW()" value="수정" id="pwupdate" style="width:80px;height:35px;color:white;background-color:#9ddb8f;border:none;cursor:pointer;">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" onclick="self.close();" id="exit" value="취소" style="width:80px;height:35px;border:none;background-color:#d7db8f;cursor:pointer;">
			
		
</form>

</div>

</body>
</html>