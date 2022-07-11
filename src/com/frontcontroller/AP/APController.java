// https://github.com/Ryanmufasa/awesomePlace/issues/17 -- 프론트컨트롤러(case는 별도) 작성자 이명진, doGet 부분수정 정다영
package com.frontcontroller.AP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HnNService.GetHashTagService;
import HnNService.MainPageService;
import HnNService.SearchByHashtagService;
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
import hostInfoUpdateService.UpdateHostInfo1Service;
import hostInfoUpdateService.UpdateHostInfo2Service;
import hostInfoUpdateService.UpdateHostInfo3Service;
import hostInfoUpdateService.UpdateHostInfo4Service;
import hostInfoUpdateService.UpdateHostInfo5Service;
import hostService.AddNewHostService;
import hostService.CancleOrderService;
import hostService.ConfirmOrderService;
import hostService.DeleteMyHostService;
import hostService.GetHostInfoService;
import hostService.GetMyHostListService;
import hostService.HostOrderService;
import hostService.HostPwCheckService;
import hostService.ManageMyHostOrderService;
import hostService.SearchService;
import hostService.StopHostingService;
import hostService.UpdateHostInfoFormService;
import memberJoinService.EmailCheckService;
import memberJoinService.IdCheckService;
import memberJoinService.JoinService;

import memberLoginService.LoginService;
import memberLoginService.LogoutService;

import memberService.IDfoundService;
import memberService.JJimShowService;
import memberService.MyPagePWService;
import memberService.MypageOrderinfoClickService;
import memberService.MypagememUpdaService;
import memberService.MypagememinfoService;
import memberService.MypageorderinfoService;
import memberService.PWfoundService;
import memberService.PWupdateService;
import memberService.QnAService;
import memberService.QnAShowService;
import orderinfoService.CheckOrderOkService;
import orderinfoService.GetMoreOrderInfoService;
import service.NextPage;
import service.ServiceInterface;
import service.TagSearchService;

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
    	
    	HttpSession session = request.getSession();
    	String myPage = (String)session.getAttribute("myPage");
    	String InmyPage = (String)session.getAttribute("InmyPage");
    	String hostingPage = (String)session.getAttribute("hostingPage");
    	String InhostingPage = (String)session.getAttribute("InhostingPage");
    	    	
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
				if(InmyPage != null) { // 마이페이지 비밀번호 체크 세션 있음 
					if(InhostingPage != null) { // 호스팅 비밀번호 체크 세션도 있으면 
						session.removeAttribute("hostingPage");
					}
					session.setAttribute("myPage","true");
					page = new NextPage("awesomePlace/mypage/mpmeminfo.do", true);
				}else { // 세션이 없다면 비밀번호 화면으로 이동 
					if(InhostingPage != null) { // 마이호스팅 비밀번호 체크 세션이 있으면
						session.removeAttribute("hostingPage");
					}
					page = new NextPage("/awesomePlace/mypage/MyPage.jsp", true);
				}
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
	    	case "/qna1.do":
	    		serv = new QnAShowService();
	    		page = new NextPage("/mypage/MyAskCheck.jsp", false);
	    		break;

	    	case "/jjimlist1.do": // https://github.com/Ryanmufasa/awesomePlace/issues/53 작성자: 양준모
	    		serv = new JJimShowService();
	    		page = new NextPage("Myjjim.jsp", false);
	    		break;
				
	    	//마이페이지 비밀번호 확인 후 메인 
			case "/mpmeminfo.do" : //작성자 = 고유주
				//serv = new MypagememinfoService();
				page = new NextPage("/awesomePlace/mypage/mp_meminfo.jsp", true);
				break;

			case "/meminfoclear.do" : //작성자 = 고유주
				serv = new MypagememUpdaService();
				page = new NextPage("/mypage/mp_memInfoUpdate.jsp", false);
				break;
	
			//마이페이지 예약내역 
				case "/mpreserinfo.do" : //작성자 = 고유주
				serv = new MypageOrderinfoClickService();
				page = new NextPage("/mypage/mp_reserinfo.jsp", false);
				break;
			
			case "/mpreserinfofirst.do" : //작성자 = 고유주
				serv = new MypageorderinfoService();
				page = new NextPage("/mypage/mp_reserInfoFirst.jsp", false);
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
				
			case "/hashtagList.do": //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영 
				serv = new GetHashTagService();
				page = new NextPage("/search/hashtagList.jsp",false);
				break;
				
			case "/searchByHashtag.do": //https://github.com/Ryanmufasa/awesomePlace/issues/25 작성자 정다영
				serv = new SearchByHashtagService();
				page = new NextPage("/search/search.jsp",false);
				break;
				
			case "/checkOrderOk.do" :
				serv = new CheckOrderOkService();
				page = new NextPage("/search/checkResult.jsp", false);
				break;
				
				
	// 마이 호스팅 ================================================================	
				//https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
			case "/myHosting.do" : // 마이호스팅 버튼 클릭시 
				if(InhostingPage != null) { // 호스팅 버튼 접속 이력 있다면 
					if(InmyPage != null) { // 마이페이지 비밀번호 체크 세션 있으면 
						session.removeAttribute("myPage");
					}
					session.setAttribute("hostingPage", "true");
					page = new NextPage("/awesomePlace/myhosting/myHostList.do",true);
				}else { // 마이호스팅 비밀번호 체크 세션이 없을때 
					if(InmyPage != null) { // 마이페이지 비밀번호 체크 세션이 있는 경우 
						session.removeAttribute("myPage");
					}
					page = new NextPage("/awesomePlace/myhosting/myHosting.jsp", true);
				}
				break;
				
			case "/pwCheck.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				serv = new HostPwCheckService();
				page = new NextPage("/myhosting/pwch.jsp", false);
				break;

			// 호스트 리스트 	
			case "/myHostList.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 -- 작성자 정다영
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
				
			case "/stopHosting.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				// 호스트 중지  
				serv = new StopHostingService();
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
			
			// 호스트 관리 창으로 이동 
			case "/memberHostMng.do": //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				serv = new GetMyHostListService();
				page = new NextPage("/myhosting/updateList.jsp", false);
				break;
				
			case "/updateHostInfoForm.do"://https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				serv = new UpdateHostInfoFormService();
				page = new NextPage("/myhosting/updateHostInfoForm.jsp", false);
				break;
			
			// 호스트 정보 수정
			case "/updateInfo1.do": //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				// 기본정보 
				serv = new UpdateHostInfo1Service();
				page = new NextPage("/myhosting/updateHostInfoResult.jsp", false);
				break;
				
			case "/updateInfo2.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				// 호스트 종류
				serv = new UpdateHostInfo2Service();
				page = new NextPage("/myhosting/updateHostInfoResult.jsp", false);
				break;
				
			case "/updateInfo3.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				// 금액 변경
				serv = new UpdateHostInfo3Service();
				page = new NextPage("/myhosting/updateHostInfoResult.jsp", false);
				break;
				
			case "/updateInfo4.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				// 호스트에 태그 추가 
				serv = new UpdateHostInfo4Service();
				page = new NextPage("/myhosting/updateHostInfoResult.jsp", false);
				break;
				
			case "/updateInfo5.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
				// 호스트에 키워드 삭제
				serv = new UpdateHostInfo5Service();
				page = new NextPage("/myhosting/updateHostInfoResult.jsp", false);
				break;
				
			// 새 호스트 등록	
			case "/addNewHostForm.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/36 -- 작성자 정다영
				page = new NextPage("/awesomePlace/myhosting/addNewHostForm.jsp", true);
				break;
				
			case "/addNewCheck.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/36 -- 작성자 정다영
				serv = new AddNewHostService();
				page = new NextPage("/myhosting/result.jsp", false);
				break;
				
				
	// 관리자  ===============================================================				
			case "/adminIn.do" : //https://github.com/Ryanmufasa/awesomePlace/issues/9 작성자: 이명진
				serv = new AdminService();
				page = new NextPage("/admin/QnAList.do", false);
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
			case "/tagSearch.do": // https://github.com/Ryanmufasa/awesomePlace/issues/28 작성자: 이명진
				serv = new TagSearchService();
				page = new NextPage("/search/search.jsp", false);
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
