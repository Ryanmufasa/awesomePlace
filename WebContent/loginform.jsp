<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>AwesomePlace 로그인</title>  <!-- https://github.com/Ryanmufasa/awesomePlace/issues/5  // 양준모 -->

<style>
    #login1 {
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }

    * {
        font-family: arial;
    }

    *:focus {
        outline: none;
    }
</style>

<script>
    function gologinCheck() {
        location.href = "loginCheck.jsp"
    }
</script>

</head>

<body>

    <div id="login1">

        <form action="loginCheck.jsp" method="post">

            <table>

                <tr>
                    <td>
                        아이디&nbsp;&nbsp;
                    </td>
                    <td><input type="text" name="mem_id" id="mem_id" style="width:205px;height:30px;" placeholder="아이디" required></td>
                </tr>

                <tr>
                    <td></td>

                <tr>
                    <td>
                        비밀번호&nbsp;&nbsp;
                    </td>
                    <td><input autocomplete="false" type="password" name="mem_pw" id="mem_pw" style="width:205px;height:30px;" placeholder="비밀번호" required></td>
                </tr>

            </table> <br>

            <button class="submit" onclick="gologinCheck()" style="width:130px;height:40px;background-color:#5e5e5e;color:white;border:none;cursor:pointer;">로그인</button>
            <!-- <input type="submit" value="로그인" onclick="gologinck()" style="width:130px;height:40px;background-color:#5e5e5e;color:white;"> -->
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="회원가입" onclick="location.href='joinform.jsp'" style="width:130px;height:40px;background-color:#5e5e5e;color:white;border:none;cursor:pointer;"> <br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <a href="IDfoundform.jsp" onclick="window.open(this.href, '_blank', 'width=800, height=600'); return false;">아이디 찾기</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="PWfoundform.jsp" onclick="window.open(this.href, '_blank', 'width=800, height=600'); return false;">비밀번호 찾기</a>

        </form>

    </div>

</body>

</html>