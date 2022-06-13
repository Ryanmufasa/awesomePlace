package memberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberDAO;
import member.memberVO;
import service.ServiceInterface;

public class JoinService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email1")+"@"+request.getParameter("email2");
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(tel);
		System.out.println(email);
		
		memberVO vo = new memberVO(name, id, pw, tel, email);
		
		memberDAO dao = memberDAO.getInstance();
				
		boolean check = dao.join(vo);
		String msg = null;
		
		if(check) {
			msg="회원가입 성공!";
		}else{
			msg = "회원가입실패";
			System.out.println("회원가입실패");
		}
		request.setAttribute("check", check);
		request.setAttribute("msg",msg);
		
		
	}

}
