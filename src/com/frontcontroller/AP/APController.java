// 참고용
package com.frontcontroller.AP;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberService.IDfoundService;
import memberService.JoinService;
import memberService.LoginService;
import memberService.MyPagePWService;
import memberService.PWfoundService;
import memberService.PWupdateService;
import memberService.QnAService;
import memberService.QnAShowService;
import service.NextPage;
import service.ServiceInterface;

@WebServlet("*.do")
public class APController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public APController() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
    	ServiceInterface serv = null;
    	NextPage page = null;
    	
    	String requestURL = request.getRequestURL().toString();
    	System.out.println(requestURL);
    	
    	String requestPath = request.getContextPath().toString();
    	System.out.println(requestPath);
    	
    	int start = requestURL.lastIndexOf("/");
    	
    	String path = requestURL.substring(start);
    	System.out.println("path : " + path);
    	
    	
    	//String path2 = request.getRequestURL().substring(request.getContextPath().length());
    	//System.out.println("path2 : " + path2);
    	
    	// 회원가입 
    	switch(path) {
    	case "/joinForm.do":
    		page = new NextPage("/awesomePlace/join/joinForm.jsp", true);
    		break;
	case "/join.do" : 
		serv = new JoinService(); 
		page = new NextPage("/join/result.jsp", false);
		break;
		
		// 로그인
		case "/loginform.do":
			page = new NextPage("/awesomePlace/login/loginform.jsp", true);
			break;
	case "/login.do" : 
		serv = new LoginService(); 
		page = new NextPage("/login/result.jsp", false);
		break;
		
		// 아이디 찾기
		case "/IDfoundform.do":
			page = new NextPage("/awesomePlace/idfound/IDfoundform.jsp", true);
			break;
	case "/idfound.do" :
		serv = new IDfoundService();
		page = new NextPage("/idfound/result.jsp", false);
		break;
		
		// 비밀번호 찾기
		case "/PWfoundform.do":
			page = new NextPage("/awesomePlace/pwfound/PWfoundform.jsp", true);
			break;
	case "/pwfound.do":
		serv = new PWfoundService();
		page = new NextPage("/pwfound/result.jsp", false);
		break;
		
		// 비밀번호 찾기 (비밀번호 수정)
		case "/PWupdate.do":
			page = new NextPage("/awesomePlace/pwfound/PWupdate.jsp", true);
			break;
	case "/pwupdate.do":
		serv = new PWupdateService();
		page = new NextPage("/pwfound/result2.jsp", false);
		break;
		
		// 마이페이지 접속시 로그인 재확인 
		case "/MyPage.do":
			page = new NextPage("/awesomePlace/mypage/MyPage.jsp", true);
			break;
	case "/mypagePW.do":
		serv = new MyPagePWService();
		page = new NextPage("/mypage/result.jsp", false);
		break;
		
		// 문의글 쓰기  // 작성자: 양준모
		case "/MyAskForm.do":
		page = new NextPage("/awesomePlace/ASK/MyAskForm.jsp", true);
		break;
    case "/askqna.do":
    	serv = new QnAService();
    	page = new NextPage("/ASK/result.jsp", false);
    	break;
    	
    	// 문의글 보는 페이지 // 작성자: 양준모
    	case "/qna.do":
    		page = new NextPage("/awesomePlace/qna.jsp", true);
    		break;
    case "/qna1.do":
    	serv = new QnAShowService();
    	page = new NextPage("MyAskCheck.jsp", false);
    	break;
    	
	/*
	 * //인증번호 발송 case "/emailform.do": page = new
	 * NextPage("/awesomePlace/emailconfig/emailform.jsp", true); break; case
	 * "/email.do": serv = new EmailService(); page = new
	 * NextPage("/emailconfig/result.jsp", false); break;
	 */
	    }  	
    	
    	
    	if(serv != null) {
    		try {
				serv.execute(request, response);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	if(page.isRedirect()) {
    		response.sendRedirect(page.getNextPath());
    	}else {
    		request.getRequestDispatcher(page.getNextPath()).forward(request, response);
    	}
    	
    	
    	
    	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
