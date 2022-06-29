package memberService; //https://github.com/Ryanmufasa/awesomePlace/issues/46  //작성자: 양준모

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.QnAVO;
import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class QnaShowService implements ServiceInterface {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException  {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("mem");
		
		String mem_id = vo.getMem_id();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		ArrayList<QnAVO> list = null;
		
		list = dao.qnalist(mem_id);
		request.setAttribute("list", list);
	}

}
