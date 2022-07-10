// 마이호스팅 페이지 접속시 패스워드 확인 -- 작성자 정다영
package hostService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class HostPwCheckService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession ses = request.getSession();
		
		MemberVO vo = (MemberVO)ses.getAttribute("mem_id");
		
		String id = vo.getMem_id();
		String repw = request.getParameter("repw");
		
		int check = MemberDAO.getInstance().MyPagePWck(repw, id);
		
		
		if(check == 1) { // 비밀번호가 일치 할때 
			System.out.println("비밀번호 일치");
			ses.setAttribute("hostingPage", "true");
			ses.setAttribute("InhostingPage", "true");

		}else {
			System.out.println("비밀번호 일치하지 않음 ");
		}
		
		request.setAttribute("check", check);
		
		
	}

}

//String myPage = (String)ses.getAttribute("myPage");
//if(myPage != null) {
//	ses.removeAttribute(myPage);
//	ses.setAttribute("InmyPage", "true");
//}