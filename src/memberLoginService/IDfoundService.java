// 작성자 양준모
package memberLoginService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import service.ServiceInterface;

public class IDfoundService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String mem_name = request.getParameter("mem_name");
		String mem_id = request.getParameter("mem_id");
		String mem_tel = request.getParameter("mem_tel1")+"-"+request.getParameter("mem_tel2")+"-"+request.getParameter("mem_tel3");
		String mem_email = request.getParameter("mem_email1")+"@"+request.getParameter("mem_email2");
		
		HttpSession session = request.getSession();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int selectResult = dao.IDfound(mem_name, mem_id, mem_tel, mem_email);
		
		if(selectResult == 1) {
			session.setAttribute("mem_name", mem_name);
			session.setAttribute("mem_tel", mem_tel);
			
		} 
		
		request.setAttribute("selectResult", selectResult);
		
	}


}
