package memberService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface; // https://github.com/Ryanmufasa/awesomePlace/issues/53 작성자: 양준모

public class JJimHeartService implements ServiceInterface{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException  {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = (MemberVO) session.getAttribute("mem_id");
		
		int host_num = 0;
		
		if(request.getParameter("host_num") != null) {
			host_num = Integer.parseInt(request.getParameter("host_num"));
			System.out.println(host_num);///// 테스트 출력
		}else {
			System.out.println("값이 없음");
		}
		
		int mem_num = vo.getMem_num();
		
		System.out.println(mem_num); //// 테스트 출력
		
		int result = dao.jjimheart(mem_num, host_num);
		
		if( result == 1) {
			System.out.println("삭제");
		}else {
			System.out.println("실패");
		}
	}

}
