package memberLoginService; /*https://github.com/Ryanmufasa/awesomePlace/issues/29  //작성자: 양준모*/
						// 로그인시 사용되는 서비스 입니다.

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class LoginService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String mem_id = request.getParameter("id");
		System.out.println(mem_id);
		String mem_pw = request.getParameter("pw");
		System.out.println(mem_pw);
		
		//MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO selectResult = MemberDAO.getInstance().selectID(mem_id, mem_pw);
		
		if(selectResult != null) {
			session.setAttribute("mem_id", selectResult); 
		
		} 

		if ("admin".equals(mem_id)) {
			String admin = "admin";
			session.setAttribute("showAdmin", admin); 
			
		}
		
		request.setAttribute("selectResult", selectResult);
		
	}

}
