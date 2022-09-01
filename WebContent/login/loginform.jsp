<!-- https://github.com/Ryanmufasa/awesomePlace/issues/5  // 양준모 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>AwesomePlace 로그인</title>  

<script src="${contextPath }/resources/js/Main.js?v=<%=System.currentTimeMillis() %>"></script>	

<style>
    #login1 {
      
    }

    * {
        font-family: arial;
    }

    *:focus {
        outline: none;
    }
    
    #mem_id, #mem_pw, #kajalogin, #kajajoin {
    	border-radius: 14px;
    }
    
    #mem_id, #mem_pw {
    	 border-right: #888888 1px solid;
         border-left: #888888 1px solid;
         border-top: #888888 1px solid;
         border-bottom: #888888 1px solid;
    }
    
    a {
 		text-decoration: none;
	}
	
</style>

	<%@include file ="/layout/Header.jsp" %>

	<br><br><br><br><br><br><br><br><br><br>

    <div id="login1" align="center">

        <form action="${pageContext.request.contextPath }/login/login.do" method="post" name="loginform">
        <input type="hidden" name="from" value="">

            <table>

                <tr>
                    <td>
                        아이디&nbsp;&nbsp;
                    </td>
                    <td>
                    	<input type="text" id="mem_id" name="mem_id" style="width:205px;height:30px;" placeholder=" 아이디" required>
                    </td>
                </tr>

                <tr>
                    <td></td>
                <tr>
                    <td></td>

                <tr>
                    <td>
                        비밀번호&nbsp;&nbsp;
                    </td>
                    <td>
                    	<input autocomplete="false" type="password" id="mem_pw" name="mem_pw" style="width:205px;height:30px;" placeholder=" 비밀번호" required>
                    </td>
                </tr>

            </table> <br>

            <button class="submit" id="kajalogin" style="width:130px;height:40px;background-color:#9ddb8f;color:white;border:none;cursor:pointer;">로그인</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" value="회원가입" id="kajajoin" onclick="location.href='${pageContext.request.contextPath }/join/joinForm.jsp'" style="width:130px;height:40px;background-color:#9ddb8f;color:white;border:none;cursor:pointer;"> 
            <br><br>_________________________________<br><br>

            <a href="${pageContext.request.contextPath }/IDfoundform.do" onclick="window.open(this.href, '_blank', 'width=600, height=600'); return false;">아이디 찾기</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath }/PWfoundform.do" onclick="window.open(this.href, '_blank', 'width=600, height=600'); return false;">비밀번호 찾기</a>

        </form>

    <span id="counter" style="top:773px;"></span>
    </div>
    
    <%@include file ="/layout/Footer.jsp" %>