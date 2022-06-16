package memberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class LoginService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id);
		System.out.println(pw);
		
		MemberVO vo = MemberDAO.getInstance().loginck(id, pw);
		
		boolean check = false;
		String msg=null;
		
		HttpSession session = request.getSession();
		
		if(vo != null) {
			msg ="로그인성공";
			session.setAttribute("login", vo);
			check = true;
		}else {
			msg="로그인실패";
		}
		
		request.setAttribute("check", check);
		request.setAttribute("msg", msg);
		
		

	}

}
