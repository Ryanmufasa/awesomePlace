//https://github.com/Ryanmufasa/awesomePlace/issues/39 작성자: 이명진
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
		
		int rowCnt = 10;
		int steadyRowCnt = 10;
		int pageCnt = 10;
		String tempRowCnt = (String)request.getParameter("steadyRowCnt");
		
		if(tempRowCnt != null) {
			steadyRowCnt = Integer.parseInt(tempRowCnt);
		}
		
		int cacIdx = (pageCnt/2);
		int totalCnt = (int)Math.ceil(qnaArr.size()/(double)steadyRowCnt);
		int totalRow = qnaArr.size();
		
		int page = 1;
		int begin = 1;
		int end = totalCnt;
		
		String tempNum = (String)request.getParameter("pageIdx");
		if(tempNum != null) {
			page = Integer.parseInt(tempNum);
		}
		
		if(page>cacIdx) {
			begin = (page - cacIdx - 1);
			if(begin==0)
				begin++;
		}
		
		if((totalCnt-page)>cacIdx) {
			end = (page + cacIdx);
		}
		
		if(page==end) {
			rowCnt = (qnaArr.size()%steadyRowCnt);
		}else {
			rowCnt = steadyRowCnt;
		}
		rowCnt--;
		
		int rowStart = ((page-1)*steadyRowCnt);
		int rowEnd = rowStart+(steadyRowCnt-1);
		
		int [] pageData = {page,begin,end,rowStart,rowEnd,totalCnt,rowCnt,steadyRowCnt,totalRow};
		
		request.setAttribute("pageData", pageData);
		
		request.setAttribute("qnaArr", qnaArr); 
		
		
		
	}
	
}
