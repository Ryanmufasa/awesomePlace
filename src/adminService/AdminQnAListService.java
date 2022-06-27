package adminService;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import service.ServiceInterface;
import admin.QnAVO;

public class AdminQnAListService implements ServiceInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession ss1 = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = MemberDAO.getInstance();
		
		ArrayList<QnAVO> qnaArr = dao.getAllQnAList();
		request.setAttribute("qnaArr", qnaArr); 
		
		
		
	}
	
}
