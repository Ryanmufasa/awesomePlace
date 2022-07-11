package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostvo.HostVO;
import member.MemberDAO;

public class TagSearchService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = MemberDAO.getInstance();
		
		//int idx = Integer.parseInt(request.getParameter("idx"));
		
		int idx = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		System.out.println("tag_name : " + name);
		
		ArrayList<HostVO> hostList = dao.tagSearch(idx);
		
		
		
		request.setAttribute("hostli", hostList);
		request.setAttribute("tag_name", name);
		
		request.setAttribute("search", "");
		request.setAttribute("checkIn", "");
		request.setAttribute("checkOut", "");
		request.setAttribute("guestCnt", "");
	}

}
