//https://github.com/Ryanmufasa/awesomePlace/issues/9 작성자: 이명진
package adminService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.QnAVO;
import member.MemberDAO;
import service.ServiceInterface;

public class AdminService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession ss1 = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = MemberDAO.getInstance();
		
		ArrayList<QnAVO> qnaArr = dao.getAllQnAList();
		
		ss1.setAttribute("adminPage", "true");
		ss1.removeAttribute("myPage");
		ss1.removeAttribute("hostingPage");
		request.setAttribute("qnaArr", qnaArr); 
	}

}
