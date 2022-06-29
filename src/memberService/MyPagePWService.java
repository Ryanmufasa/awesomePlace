package memberService; /*https://github.com/Ryanmufasa/awesomePlace/issues/30  //작성자: 양준모 */
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.memberDAO;
import member.memberVO;
import service.ServiceInterface;

public class MyPagePWService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		memberVO vo = (memberVO) session.getAttribute("mem");
		
		String mem_pw = request.getParameter("mem_pw");		
		String mem_id = vo.getMem_id();
		
		memberDAO dao = memberDAO.getInstance();
		
		int selectResult = dao.MyPagePWck(mem_pw, mem_id);
		
		if(selectResult == 1) {
			System.out.println("일치");
			
		} 
		
		request.setAttribute("selectResult", selectResult);
		
	}

}
