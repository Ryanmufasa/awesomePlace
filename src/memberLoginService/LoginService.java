package memberLoginService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import service.ServiceInterface;

public class LoginService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		HttpSession session = request.getSession();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int selectResult = dao.selectID(mem_id, mem_pw);
		
		if(selectResult == 1) {
			session.setAttribute("mem_id", mem_id);
			session.setAttribute("mem_pw", mem_pw);
			
		} 
		
		request.setAttribute("selectResult", selectResult);
		
	}

}
