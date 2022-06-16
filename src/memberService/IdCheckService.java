package memberService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class IdCheckService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("userid");
		System.out.println("id : " + id);
		
	
		String id1 = MemberDAO.getInstance().searchId(id);
		
		if(id1 == null) {
			System.out.println("아이디 사용 가능");
		}else {
			System.out.println("아이디 중복 ");
		}
		
		request.setAttribute("id1",id1);
		
		
//		MemberVO vo = new MemberVO(); 
//		vo = MemberDAO.getInstance().selectById(id);
//		
//		if(vo != null) {
//			System.out.println("아이디 중복");
//		} else {
//			System.out.println("아이디 중복 아님");
//			vo = null;
//		}
//		
//		request.setAttribute("vo", vo);
		
//		int cnt = MemberDAO.getInstance().searchId(id);
//		
//		if(cnt == 1) {
//			System.out.println("아이디 중복 ");
//		}else if(cnt == 0) {
//			System.out.println("아이디 중복 아님");
//		}
//		
//		request.setAttribute("cnt", cnt);
//		
		//String id2 = request.getParameter("id");
		//System.out.println("id2 : " + id2 );
		
		
		
		

		
		//PrintWriter out = response.getWriter();

	}

}
