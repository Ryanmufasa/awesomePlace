// https://github.com/Ryanmufasa/awesomePlace/issues/17 -- 프론트컨트롤러(case는 별도) 작성자 이명진, doGet 부분수정 정다영
package com.frontcontroller.AP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HnNService.MainPageService;
import adminService.AdminHostingListService;
import adminService.AdminMemberHostListService;
import adminService.AdminMemberInfoService;
import adminService.AdminMemberListService;
import adminService.AdminMemberSwitchAvailableService;
import adminService.AdminOutService;
import adminService.AdminQnAAnswerFormService;
import adminService.AdminQnAListService;
import adminService.AdminService;
import hostService.AddNewHostService;
import hostService.SearchService;
import memberService.EmailCheckService;
import memberService.IDfoundService;
import memberService.IdCheckService;
import memberService.JoinService;
import memberService.LoginService;
import memberService.MyPagePWService;
import memberService.PWfoundService;
import memberService.PWupdateService;
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
    	    	
    	switch(path) {
	    	case "/joinForm.do":  // https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
	    		page = new NextPage("/awesomePlace/join/joinForm.jsp", true);
	    		break;
			case "/join.do" :  //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
				serv = new JoinService(); 
				page = new NextPage("/join/result.jsp", false);
				break;
			case "/search.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/25 -- 작성자 정다영
				serv = new SearchService();
				page = new NextPage("/search/search.jsp", false);
				break;
			case "/loginform.do":
				page = new NextPage("/awesomePlace/login/loginform.jsp", true);
				break;
			case "/login.do" : 
				serv = new LoginService(); 
				page = new NextPage("/login/result.jsp", false);
				break;
			
			// 아이디 찾기 작성자:양준모
			case "/IDfoundform.do":
				page = new NextPage("/awesomePlace/idfound/IDfoundform.jsp", true);
				break;
			case "/idfound.do" :
				serv = new IDfoundService();
				page = new NextPage("/idfound/result.jsp", false);
				break;
			
			// 비밀번호 찾기 작성자:양준모
			case "/PWfoundform.do":
				page = new NextPage("/awesomePlace/pwfound/PWfoundform.jsp", true);
				break;
			case "/pwfound.do":
				serv = new PWfoundService();
				page = new NextPage("/pwfound/result.jsp", false);
				break;
			
			// 비밀번호 찾기 (비밀번호 수정) 작성자:양준모
			case "/PWupdate.do":
				page = new NextPage("/awesomePlace/pwfound/PWupdate.jsp", true);
				break;
			case "/pwupdate.do":
				serv = new PWupdateService();
				page = new NextPage("/pwfound/result1.jsp", false);
				break;
			
			// 마이페이지 접속시 로그인 재확인 작성자:양준모
			case "/MyPage.do":
				page = new NextPage("/awesomePlace/mypage/MyPage.jsp", true);
				break;
			case "/mypagePW.do":
				serv = new MyPagePWService();
				page = new NextPage("/mypage/result.jsp", false);
				break;
				
			case "/idCheck.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
				 serv = new IdCheckService();
				 page = new NextPage("/join/idCheck.jsp",false);
				 break;
			
			case "/emailCheck.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
				serv = new EmailCheckService();
				page = new NextPage("/join/emailCheck.jsp", false);
				break;
			
			case "/myhosting.do" : // 테스트를 위한 임시 작성 
				page = new NextPage("/awesomePlace/myhosting/myboard.jsp", true);
				break;
				
			case "/addNewHostForm.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/36 -- 작성자 정다영
				page = new NextPage("/awesomePlace/myhosting/addNewHostForm.jsp", true);
				break;
				
			case "/addNewCheck.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/36 -- 작성자 정다영
				serv = new AddNewHostService();
				page = new NextPage("/myhosting/result.jsp", false);
				break;
			case "/admin.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/9 작성자: 이명진
				serv = new AdminService();
				page = new NextPage("/QnAList.jsp", false);
				break;
			case "/adminOut.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/9 작성자: 이명진
				serv = new AdminOutService();
				page = new NextPage("/index.jsp", false);
				break;
			case "/main.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/9 작성자: 이명진
				serv = new MainPageService();
				page = new NextPage("/index.jsp", false);
				break;
			case "/QnAList.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/39 작성자: 이명진
				serv = new AdminQnAListService();
				page = new NextPage("/admin/QnAList.jsp", false); 
				break;
			case "/QnAAnswerForm.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/39 작성자: 이명진
				serv = new AdminQnAAnswerFormService();
				page = new NextPage("/admin/QnAAnswerForm.jsp", false); 
				break;
			case "/memberList.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
				serv = new AdminMemberListService();
				page = new NextPage("/admin/memberList.jsp", false); 
				break;
			case "/memberInfo.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
				serv = new AdminMemberInfoService();
				page = new NextPage("/admin/memberInfo.jsp", false); 
				break;
			case "/memberHostList.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
				serv = new AdminMemberHostListService();
				page = new NextPage("/admin/memberHostList.jsp", false); 
				break;
			case "/switchAvailable.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
				serv = new AdminMemberSwitchAvailableService();
				page = new NextPage("memberList.do", false); 
				break;
			case "/hostingList.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진
				serv = new AdminHostingListService();
				page = new NextPage("/admin/hostingList.jsp", false); 
				break;
			case "/siteMap.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/51 작성자: 이명진
				page = new NextPage("/admin/siteMap.jsp", true); 
				break;
    	}
    	
    	if(serv != null) {
    		serv.execute(request, response);
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
