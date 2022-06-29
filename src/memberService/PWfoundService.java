package memberService;  //https://github.com/Ryanmufasa/awesomePlace/issues/10  //작성자: 양준모

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import service.ServiceInterface;

public class PWfoundService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String mem_name = request.getParameter("mem_name");
		String mem_id = request.getParameter("mem_id");
		String mem_tel = request.getParameter("mem_tel1")+"-"+request.getParameter("mem_tel2")+"-"+request.getParameter("mem_tel3");
		String mem_email = request.getParameter("mem_email1")+"@"+request.getParameter("mem_email2");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int selectResult = dao.PWfound(mem_name, mem_id, mem_tel, mem_email);
		
		if(selectResult == 1) {
			session.setAttribute("mem_name", mem_name);
			session.setAttribute("mem_id", mem_id);
			
		} 
		
		request.setAttribute("selectResult", selectResult);
		
	}
		

}
