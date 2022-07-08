package memberService; //https://github.com/Ryanmufasa/awesomePlace/issues/46  //작성자: 양준모
						// 회원 자신이 등록한 문의글을 보기위한 서비스 입니다.

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.QnAPaging;
import admin.QnAVO;
import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class QnAShowService implements ServiceInterface {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException  {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

		MemberVO vo = (MemberVO) session.getAttribute("mem");
		MemberDAO dao = MemberDAO.getInstance();

		String mem_id = vo.getMem_id();

		String pageNum = request.getParameter("page");
		int current_page = 1;
		if(pageNum != null) {
			current_page = Integer.parseInt(pageNum);;
		}
		
		QnAPaging admin = new QnAPaging();
		
		int dataCount = dao.getTotal(mem_id);
		int rows = 4;
		int total_page = admin.pageCount(rows, dataCount);
		if(current_page > total_page) {
			current_page = total_page;
		}
		
		String list_url = "qna1.do";
		String paging = admin.paging(current_page, total_page, list_url);
		
		int startRow = (current_page-1)*4+1;
		
		ArrayList<QnAVO> list = null;
		
		list = dao.qnalist(mem_id, startRow);  // 해결사항) QnAPaging 에서 현재 페이지 받아오기 
		request.setAttribute("list", list);
		session.setAttribute("paging", paging);
	}

}
