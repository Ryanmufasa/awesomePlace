package memberService;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import service.ServiceInterface;

public class MypagememUpdaService implements ServiceInterface {

	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
		HttpSession session = request.getSession();
		
		String memPw = request.getParameter("mem_pw");	
		String memTel = request.getParameter("mem_tel");	
		String memEmail = request.getParameter("mem_email");	
		String memId = (String)session.getAttribute("mem_id");
		
		System.out.println(memPw);
		System.out.println(memTel);
		System.out.println(memEmail);
		System.out.println(memId);
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.update(memPw, memTel, memEmail, memId);
		
		System.out.println(result);
		
		request.setAttribute("result", result);
		

			
	}

}
