// https://github.com/Ryanmufasa/awesomePlace/issues/17 -- 프론트컨트롤러(case는 별도) 작성자 이명진, doGet 부분수정 정다영
package com.frontcontroller.AP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HnNService.MainPageService;
import adminService.AdminHostDetailService;
import adminService.AdminHostSwitchSignService;
import adminService.AdminHostingListService;
import adminService.AdminMemberDeleteService;
import adminService.AdminMemberHostListService;
import adminService.AdminMemberDetailService;
import adminService.AdminMemberListService;
import adminService.AdminMemberSwitchSignService;
import adminService.AdminOutService;
import adminService.AdminQnAAnswerFormService;
import adminService.AdminQnAListService;
import adminService.AdminService;

import hostService.AddNewHostService;
import hostService.CancleOrderService;
import hostService.ConfirmOrderService;
import hostService.DeleteMyHostService;
import hostService.GetHostInfoService;
import hostService.GetMyHostListService;
import hostService.HostOrderService;
import hostService.ManageMyHostOrderService;
import hostService.SearchService;

import memberJoinService.EmailCheckService;
import memberJoinService.IdCheckService;
import memberJoinService.JoinService;

import memberLoginService.LoginService;
import memberLoginService.LogoutService;

import memberService.IDfoundService;
import memberService.JJimShowService;
import memberService.MyPagePWService;
import memberService.PWfoundService;
import memberService.PWupdateService;
import memberService.QnAService;
import memberService.QnAShowService;
import orderinfoService.GetMoreOrderInfoService;
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
	    		
			case "/idCheck.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
				 serv = new IdCheckService();
				 page = new NextPage("/join/idCheck.jsp",false);
				 break;
			
			case "/emailCheck.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
				serv = new EmailCheckService();
				page = new NextPage("/join/emailCheck.jsp", false);
				break;	
				
			case "/join.do" :  //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
				serv = new JoinService(); 
				page = new NextPage("/join/result.jsp", false);
				break;
				
	
				
				
				
	// 로그인  ===============================================================
			case "/loginform.do" : 
				page = new NextPage("/awesomePlace/login/loginform.jsp", true);
				break;
			case "/login.do" : 
				serv = new LoginService(); 
				page = new NextPage("/login/result.jsp", false);
				break;
				
			case "/logout.do" : 
				serv = new LogoutService();
				page = new NextPage("/awesomePlace/", true);
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
			
				
				
				
				
	// 마이페이지  ===============================================================
			// 마이페이지 접속시 로그인 재확인 작성자:양준모
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
	    	
	    	case "/jjimlist.do": // https://github.com/Ryanmufasa/awesomePlace/issues/53 작성자: 양준모
	    		page = new NextPage("/awesomePlace/jjimshow.jsp", true);
	    		break;
	    	case "/jjimlist1.do": // https://github.com/Ryanmufasa/awesomePlace/issues/53 작성자: 양준모
	    		serv = new JJimShowService();
	    		page = new NextPage("Myjjim.jsp", false);
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
				
			case "/hostOrder.do" : // https://github.com/Ryanmufasa/awesomePlace/issues/57 -- 작성자 정다영 
				// 마이호스팅 부분 테스트를 위한 임시 예약 처리 서비스 
				serv = new HostOrderService(); 
				page = new NextPage("/search/hostOrder.jsp", false);
				break;	
				
				
				
				
	// 마이 호스팅 ================================================================			
			case "/myhosting.do" : // 테스트를 위한 임시 작성 
				page = new NextPage("/awesomePlace/myhosting/myboard.jsp", true);
				break;
			case "/memberMyHosting.do" : // 테스트를 위한 임시 작성 
				page = new NextPage("/awesomePlace/myhosting/myboard.jsp", true);
				break;	
			case "/addNewHostForm.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/36 -- 작성자 정다영
				page = new NextPage("/awesomePlace/myhosting/addNewHostForm.jsp", true);
				break;
				
			case "/addNewCheck.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/36 -- 작성자 정다영
				serv = new AddNewHostService();
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
				
			case "/getOrderInfoMore.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				// 예약 정보에서 상세 정보보기를 클릭 했을 때
				serv = new GetMoreOrderInfoService();
				page = new NextPage("/myhosting/orderInfoPopup.jsp", false);
				break;
				
			case "/confirmOrder.do" : // https://github.com/Ryanmufasa/awesomePlace/issues/57 -- 작성자 정다영 
				// 예약 승인하는경우 
				serv = new ConfirmOrderService();
				page = new NextPage("/myhosting/confirm.jsp", false);
				break;
				
			case "/cancleOrder.do" :// https://github.com/Ryanmufasa/awesomePlace/issues/57 -- 작성자 정다영 
				// 예약 승인 요청을 취소하는 경우. 
				serv = new CancleOrderService();
				page = new NextPage("/myhosting/cancle.jsp", false);
				break;	
				
				
				
				
				
				
				
	// 관리자  ===============================================================				
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
			case "/memberDetail.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
				serv = new AdminMemberDetailService();
				page = new NextPage("/admin/memberDetail.jsp", false); 
				break;
			case "/memberDelete.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
				serv = new AdminMemberDeleteService();
				page = new NextPage("/admin/memberDetail.jsp", false); 
				break;
			case "/memberHostList.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
				serv = new AdminMemberHostListService();
				page = new NextPage("/admin/memberHostList.jsp", false); 
				break;
			case "/switchSign.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
				serv = new AdminMemberSwitchSignService();
				page = new NextPage("memberList.do", false); 
				break;
			case "/hostingList.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진
				serv = new AdminHostingListService();
				page = new NextPage("/admin/hostingList.jsp", false); 
				break;
			case "/hostDetail.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진
				serv = new AdminHostDetailService();
				page = new NextPage("/admin/hostDetail.jsp", false); 
				break;
			case "/switchHostSign.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
				serv = new AdminHostSwitchSignService();
				page = new NextPage("/admin/hostDetail.jsp", false); 
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