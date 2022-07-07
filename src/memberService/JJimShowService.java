package memberService;

import java.io.UnsupportedEncodingException;  //https://github.com/Ryanmufasa/awesomePlace/issues/53 // 작성자: 양준모
import java.util.ArrayList;					  // 마이페이지에서 찜목록 불러오는 서비스입니다.

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.hostVO;
import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class JJimShowService implements ServiceInterface {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException  {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("mem");
		
		int mem_num = vo.getMem_num();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		ArrayList<hostVO> hlist = null;
		
		hlist = dao.jjimList(mem_num);
		request.setAttribute("hlist", hlist);
		
		
	}

}
