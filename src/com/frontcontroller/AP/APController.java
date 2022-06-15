// 참고용
package com.frontcontroller.AP;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	
    	// 회원가입 
    	switch(path) {
    	case "/joinForm.do":
    		page = new NextPage("/awesomePlace/join/joinForm.jsp", true);
    		break;
	case "/join.do" : 
		serv = new JoinService(); 
		page = new NextPage("/join/result.jsp", false);
		break;
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
    	
    	
    	// 로그인
    	switch(path) {
    	case "/loginform.do":
    		page = new NextPage("/awesomePlace/login/loginform.jsp", true);
    		break;
	case "/login.do" : 
		serv = new LoginService(); 
		page = new NextPage("/login/result.jsp", false);
		break;
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
