//https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진
package adminService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostvo.HostVO;
import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class AdminHostingListService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = MemberDAO.getInstance();
		
		ArrayList<HostVO> hostList = dao.getAllHosting();
		
		request.setAttribute("hostList", hostList);
	}

}
