//https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진
package adminService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostvo.HostVO;
import member.MemberDAO;
import service.ServiceInterface;

public class AdminHostingListService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = MemberDAO.getInstance();
		
		ArrayList<HostVO> hostList = dao.getAllHosting();
		
		int rowCnt = 10;
		int pageCnt = 10;
		String tempRowCnt = (String)request.getParameter("rowCnt");
		
		if(tempRowCnt != null) {
			rowCnt = Integer.parseInt(tempRowCnt);
		}
		
		int cacIdx = (pageCnt/2);
		int totalCnt = (int)Math.ceil(hostList.size()/(double)pageCnt);
		
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
			rowCnt = (hostList.size()%rowCnt);
		}
		rowCnt--;
		
		int rowStart = ((page-1)*10);
		int rowEnd = rowStart+rowCnt;
		
		int [] pageData = {page,begin,end,rowStart,rowEnd,totalCnt,rowCnt};
		
		request.setAttribute("pageData", pageData);
		
		request.setAttribute("hostList", hostList);
	}

}
