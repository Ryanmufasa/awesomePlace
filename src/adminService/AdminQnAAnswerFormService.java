//https://github.com/Ryanmufasa/awesomePlace/issues/39 작성자: 이명진
package adminService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.QnAVO;
import member.MemberDAO;
import service.ServiceInterface;

public class AdminQnAAnswerFormService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = MemberDAO.getInstance();
		
		ArrayList<QnAVO> QnACon;
		String temp = request.getParameter("idx");
		
		if(temp==null) {
			String answer = request.getParameter("answer");
			int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
			boolean flag = dao.setQnAAnswer(qnaNum,answer);
			String res;
			if(flag) {
				res = "답변 등록에 성공했습니다.";
				request.setAttribute("QnARes", res);
			}else {
				res = "답변 등록이 실패했습니다.";
				request.setAttribute("QnARes", res);
			}
			QnACon = dao.getQnAContent(qnaNum);
		}else {
			int idx = Integer.parseInt(temp);
			QnACon = dao.getQnAContent(idx);
		}
		request.setAttribute("QnACon", QnACon);
		
	}

}
