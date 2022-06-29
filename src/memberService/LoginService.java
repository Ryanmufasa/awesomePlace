package memberService; /*https://github.com/Ryanmufasa/awesomePlace/issues/29  //작성자: 양준모*/
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.memberDAO;
import member.memberVO;
import service.ServiceInterface;

public class LoginService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		request.setCharacterEncoding("UTF-8");
		
		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		HttpSession session = request.getSession();
		
		memberDAO dao = memberDAO.getInstance();
		
		memberVO selectResult = dao.selectID(mem_id, mem_pw);
		
		if(selectResult != null) {
			session.setAttribute("mem", selectResult);
			
			
		} 
		
		request.setAttribute("selectResult", selectResult);
		
	}

}
