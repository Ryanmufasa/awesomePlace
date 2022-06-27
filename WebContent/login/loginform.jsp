<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>AwesomePlace 로그인</title>  <!-- https://github.com/Ryanmufasa/awesomePlace/issues/5  // 양준모 -->

<script src="${contextPath }/js/jquery-3.3.1.js"></script>
<script src="${contextPath }/js/Main.js"></script>

<style>
    #login1 {
      
    }

    * {
        font-family: arial;
    }

    *:focus {
        outline: none;
    }
    
</style>

<!-- <script>
    function gologinCheck() {
        location.href = "login.do"
    }
</script> -->

</head>

<body>

<%@ include file="/Header.jsp" %> 

	<br><br><br><br><br><br><br><br><br><br>

    <div id="login1" align="center">

        <form action="${pageContext.request.contextPath }/login/login.do" method="post">

            <table>

                <tr>
                    <td>
                        아이디&nbsp;&nbsp;
                    </td>
                    <td onmouseover="this.style.backgroundColor='#9c9898FF'" onmouseout="this.style.backgroundColor=''">
                    	<input type="text" name="mem_id" style="width:205px;height:30px;" placeholder="아이디" required>
                    </td>
                </tr>

                <tr>
                    <td></td>

                <tr>
                    <td>
                        비밀번호&nbsp;&nbsp;
                    </td>
                    <td onmouseover="this.style.backgroundColor='#9c9898FF'" onmouseout="this.style.backgroundColor=''">
                    	<input autocomplete="false" type="password" name="mem_pw" style="width:205px;height:30px;" placeholder="비밀번호" required>
                    </td>
                </tr>

            </table> <br>

            <!-- <button class="submit" style="width:130px;height:40px;background-color:#5e5e5e;color:white;border:none;cursor:pointer;">로그인</button> -->
            <input type="submit" value="로그인" style="width:130px;height:40px;background-color:#5e5e5e;color:white;border:none;cursor:pointer;">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="회원가입" onclick="location.href='${pageContext.request.contextPath }/join/joinForm.jsp'" style="width:130px;height:40px;background-color:#5e5e5e;color:white;border:none;cursor:pointer;"> <br><br>
            &nbsp;&nbsp;

            <a href="${pageContext.request.contextPath }/IDfoundform.do" onclick="window.open(this.href, '_blank', 'width=800, height=600'); return false;">아이디 찾기</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath }/PWfoundform.do" onclick="window.open(this.href, '_blank', 'width=800, height=600'); return false;">비밀번호 찾기</a>

        </form>

    </div>
    
    <br><br><br><br><br><br><br><br>
    
    <hr>
    
<%@ include file="/Footer.jsp" %> 

</body>

</html>

