//https://github.com/Ryanmufasa/awesomePlace/issues/31 = 작성자 고유주
package memberService;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class MypagememinfoService implements ServiceInterface{



	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
		HttpSession session = request.getSession();
		String memid = (String)session.getAttribute("mem_id");		
		MemberVO mb = MemberDAO.getInstance().getMember(memid);
		session.setAttribute("mb", mb);

			
	}

}



