package memberService; /*https://github.com/Ryanmufasa/awesomePlace/issues/30  //작성자: 양준모 */
						// 마이페이지 접속시 회원에게 비밀번호를 재확인 할 때 사용하는 서비스 입니다.
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class MyPagePWService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		MemberVO vo = (MemberVO) session.getAttribute("mem_id");
		
		String mem_pw = request.getParameter("mem_pw");		
		String mem_id = vo.getMem_id();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int selectResult = dao.MyPagePWck(mem_pw, mem_id);
		 
		if(selectResult == 1) {
			System.out.println("일치");
			session.setAttribute("doubleCheck", "true");
			session.setAttribute("myPage", "true"); 
			session.setAttribute("InmyPage", "true"); // 마이페이지 비밀번호 체크 세션 추가 -- 삭제하지 마세요 
			//session.removeAttribute("adminPage");
			//session.removeAttribute("hostingPage"); 
			
		} 
		
		request.setAttribute("selectResult", selectResult);
		
	}

}
