package memberService;  //https://github.com/Ryanmufasa/awesomePlace/issues/10  //작성자: 양준모

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.QnAVO;
import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class QnAService implements ServiceInterface { // 작성자: 양준모
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException  {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		MemberVO vo = (MemberVO) session.getAttribute("mem");

		String mem_id = vo.getMem_id();
		int mem_num = vo.getMem_num();
		String qna_title = request.getParameter("qna_title");
		String qna_content = request.getParameter("qna_content");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		QnAVO qvo = new QnAVO();
		qvo.setMem_id(mem_id);
		qvo.setMem_num(mem_num);	
		qvo.setQna_content(qna_content);
		qvo.setQna_title(qna_title);
		
		int check = 0;
		
		check = dao.write(qvo);
		
		if( check == 1) {
			System.out.println("등록");
			session.setAttribute("qna", qvo);
		}else {
			System.out.println("실패");
		}
		request.setAttribute("check", check);
	
		
		
	}

}
