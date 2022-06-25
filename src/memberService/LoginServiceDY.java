package memberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class LoginServiceDY implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("mem_id");
		String pw = request.getParameter("mem_pw");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(id);
		vo.setMem_pw(pw);
		
		vo = MemberDAO.getInstance().loginck(vo);		
		
		boolean check = false;
		String msg=null;
		
		HttpSession session = request.getSession();
		
		if(vo != null) {
			msg ="로그인성공";
			session.setAttribute("login", vo);
			check = true;
		}else {
			msg="로그인실패";
			check = false;
		}
		
		request.setAttribute("check", check);
		request.setAttribute("msg", msg);
		
		

	}

}
