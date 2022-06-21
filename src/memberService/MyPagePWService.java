package memberService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import service.ServiceInterface;

public class MyPagePWService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		String mem_pw = request.getParameter("mem_pw");		
		String mem_id = (String)session.getAttribute("mem_id");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int selectResult = dao.MyPagePWck(mem_pw, mem_id);
		
		if(selectResult == 1) {
			session.setAttribute("mem_id", mem_id);
			
		} 
		
		request.setAttribute("selectResult", selectResult);
		
	}

}
