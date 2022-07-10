package memberLoginService;

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
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO selectResult = dao.selectID(mem_id, mem_pw);
		
		if(selectResult != null) {
			session.setAttribute("mem", selectResult); // selectResult값이 null이 아니면 mem이름에 로그인한 회원의 모든 정보를 넣는다.	
			session.setAttribute("mem_id", selectResult.getMem_id());
		} 

		if ("admin".equals(mem_id)) {
			session.setAttribute("showAdmin", "true"); // 로그인하 사용자의 아이디가 admin이면 showAdmin이름에 true값을 넣는다.
			
		}
		
		request.setAttribute("selectResult", selectResult);
		
	}

}
