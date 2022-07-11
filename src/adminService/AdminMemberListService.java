//https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
package adminService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class AdminMemberListService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = MemberDAO.getInstance();
		
		ArrayList<MemberVO> memList = dao.getAllMember();
		
		int rowCnt = 10;
		int steadyRowCnt = 10;
		int pageCnt = 10;
		String tempRowCnt = (String)request.getParameter("steadyRowCnt");
		
		if(tempRowCnt != null) {
			steadyRowCnt = Integer.parseInt(tempRowCnt);
		}
		
		int cacIdx = (pageCnt/2);
		int totalCnt = (int)Math.ceil(memList.size()/(double)steadyRowCnt);
		int totalRow = memList.size();
		
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
			rowCnt = (memList.size()%steadyRowCnt);
		}else {
			rowCnt = steadyRowCnt;
		}
		rowCnt--;
		
		int rowStart = ((page-1)*steadyRowCnt);
		int rowEnd = rowStart+(steadyRowCnt-1);
		
		int [] pageData = {page,begin,end,rowStart,rowEnd,totalCnt,rowCnt,steadyRowCnt,totalRow};
		
		request.setAttribute("pageData", pageData);
		
		request.setAttribute("memList", memList);
	}

}
