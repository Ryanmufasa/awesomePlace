// https://github.com/Ryanmufasa/awesomePlace/issues/17 -- 프론트컨트롤러(case는 별도) 작성자 이명진, doGet 부분수정 정다영
package com.frontcontroller.AP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostService.AddNewHostService;
import hostService.DeleteMyHostService;
import hostService.GetHostInfoService;
import hostService.GetMyHostListService;
import hostService.HostOrderService;
import hostService.ManageMyHostOrderService;
import hostService.SearchService;

import adminService.AdminOutService;
import adminService.AdminQnAListService;
import adminService.AdminService;

import memberLoginService.IDfoundService;
import memberLoginService.PWfoundService;

import memberJoinService.EmailCheckService;
import memberJoinService.IdCheckService;
import memberJoinService.JoinService;

import memberService.LoginServiceDY;
import memberService.LogoutServiceDY;
import memberService.MyPagePWService;
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
    // 회원가입   ===============================================================
	    	case "/joinForm.do":  // https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
	    		page = new NextPage("/awesomePlace/join/joinForm.jsp", true);
	    		break;
	    		
			case "/join.do" :  //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
				serv = new JoinService(); 
				page = new NextPage("/join/result.jsp", false);
				break;
				
			case "/idCheck.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
				serv = new IdCheckService();
				page = new NextPage("/join/idCheck.jsp",false);
				break;
				
			case "/emailCheck.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
				serv = new EmailCheckService();
				page = new NextPage("/join/emailCheck.jsp", false);
				break;
			
	// 로그인  ===============================================================
//			case "/loginForm.do":
//				page = new NextPage("/awesomePlace/login/loginForm.jsp", true);
//				break;
//			case "/login.do" : 
//				serv = new LoginService(); 
//				page = new NextPage("/login/result.jsp", false);
//				break;
			
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
	
	// 마이페이지  ===============================================================
			// 마이페이지 접속시 로그인 재확인 작성자:양준모
			case "/MyPage.do":
				page = new NextPage("/awesomePlace/mypage/MyPage.jsp", true);
				break;
			case "/mypagePW.do":
				serv = new MyPagePWService();
				page = new NextPage("/mypage/result.jsp", false);
				break;
				
			case "/mypage.do" : 
				page = new NextPage("/awesomePlace/mypage/mypagememinfo.jsp", true);
				break;
			
	// 검색   ===============================================================
			case "/search.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/25 -- 작성자 정다영
				serv = new SearchService();
				page = new NextPage("/search/search.jsp", false);
				break;
				
			case "/moreinfo.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/43 -- 작성자 정다영
				serv = new GetHostInfoService();
				page = new NextPage("/search/hostInfo.jsp", false);
				break;
				
			case "/hostOrder.do" :
				serv = new HostOrderService();
				page = new NextPage("/search/hostOrder.jsp", false);
				break;
				
	// 마이 호스팅 ================================================================			
			case "/memberMyHosting.do" : // 테스트를 위한 임시 작성 
				page = new NextPage("/awesomePlace/myhosting/myboard.jsp", true);
				break;
				
			case "/addNewHostForm.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/36 -- 작성자 정다영
				// 새 호스트 등록 버튼 클릭시 Form 입력 페이지로 이동
				page = new NextPage("/awesomePlace/myhosting/addNewHostForm.jsp", true);
				break;
				
			case "/addNewCheck.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/36 -- 작성자 정다영
				// 새 호스트 정보 입력후 등록하기 했을 때  
				serv = new AddNewHostService();  // 파일 첨부 기능 제외되었으므로 변경 가능성 있음. 
				page = new NextPage("/myhosting/result.jsp", false);
				break;

			case "/myHostList.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 -- 작성자 정다영
				// 내 호스트 관리 또는 마이 호스팅 페이지에서 호스트 목록 눌렀을때 로그인 중인 회원의 호스트 목록 출력
				// 내 호스트 관리 버튼은 myboard.jsp 에 있는것으로 임시 입니다. 네비게이션바로 적용으로 수경 예정..
				serv = new GetMyHostListService();
				page = new NextPage("/myhosting/myHostList.jsp", false);
				break;
				
			case "/myHostOrderManage.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				// 회원의 호스트 목록중에서 예약 관리 버튼을 눌렀을때 
				serv = new ManageMyHostOrderService(); // 해당 호스트의 예약 목록을 가져옵니다 
				page = new NextPage("/myhosting/myHostOrderManage.jsp", false); 
				break;
				
			case "/deleteMyHost.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				// 관리자 승인이 false 인 호스트에 한해 회원이 삭제 가능. 
				serv = new DeleteMyHostService();
				page = new NextPage("/myhosting/result.jsp", false);
				break;
				
	// 관리자  ===============================================================		
			case "/admin.do" :
				serv = new AdminService();
				page = new NextPage("/QnAList.jsp", false);
				break;
			case "/adminOut.do" :
				serv = new AdminOutService();
				page = new NextPage("/Index.jsp", false);
				break;
			case "/QnAList.do" :
				serv = new AdminQnAListService();
				page = new NextPage("/admin/QnAList.jsp", false); 
				break;
				
	// 개인 테스트 =======================================================================
				
			case "/loginForm.do" : // 테스트를 위한 임시 작성 
				 page = new NextPage("/awesomePlace/login/loginForm.jsp", true);
				 break;
			
			case "/login.do" :  // 테스트를 위한 임시 작성 
				 serv = new LoginServiceDY();
				 page = new NextPage("/login/result.jsp", false);
				 break;
			 
			case "/logout.do" : // 테스트를 위한 임시 작성 
				serv = new LogoutServiceDY();
				page = new NextPage("/awesomePlace/", true);
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
