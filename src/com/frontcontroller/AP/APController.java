// https://github.com/Ryanmufasa/awesomePlace/issues/17 -- 프론트컨트롤러(case는 별도) 작성자 이명진, doGet 부분수정 정다영
package com.frontcontroller.AP;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostService.AddNewHostService;
import hostService.SearchService;
import memberService.EmailCheckService;
import memberService.IdCheckService;
import memberService.JoinService;
import memberService.LoginService;
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
			
		case "/idCheck.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
			 serv = new IdCheckService();
			 page = new NextPage("/join/idCheck.jsp",false);
			 break;
		
		case "/emailCheck.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
			serv = new EmailCheckService();
			page = new NextPage("/join/emailCheck.jsp", false);
			break;
		
		case "/login.do" : // 테스트를 위한 임시 작성 
			 page = new NextPage("/awesomePlace/login/login.jsp", true);
			 break;
		
		case "/loginck.do" :  // 테스트를 위한 임시 작성 
			 serv = new LoginService();
			 page = new NextPage("/login/result.jsp", false);
			 break;
		
		case "/search.do" : //  https://github.com/Ryanmufasa/awesomePlace/issues/25 -- 작성자 정다영
			serv = new SearchService();
			page =new NextPage("/search/search.jsp", false);
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