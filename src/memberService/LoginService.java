package memberService;

import java.io.IOException;
/*import java.sql.Connection;*/
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.memberDAO;
import service.ServiceInterface;

public class LoginService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		request.setCharacterEncoding("UTF-8");
		
		/* Connection con = null; */
		
		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		HttpSession session = request.getSession();
		
		memberDAO dao = memberDAO.getInstance();
		
		/* con = new member.memberDBConn().getConnection(); */
		
		int selectResult = dao.selectID(mem_id, mem_pw);
		
		if(selectResult == 1) {
			session.setAttribute("mem_id", mem_id);
			
		} 
		
		request.setAttribute("selectResult", selectResult);
		
	}

}
