// 작성자 양준모
package memberService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import service.ServiceInterface;

public class PWupdateService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	HttpSession session = request.getSession();
	
	
	String mem_id = (String)session.getAttribute("mem_id");
	String mem_pw = request.getParameter("mem_pw");
	
	MemberDAO dao = new MemberDAO();
	
//	dao.PWupdate(mem_id, mem_pw);
	
	}

}
