// https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진

package adminService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostvo.HostVO;
import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class AdminHostDetailService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = MemberDAO.getInstance();
		int idx=0;
		String temp = request.getParameter("idx");
		
		if(temp!=null) {
			idx = Integer.parseInt(temp);
		}
		HostVO hostDetail = dao.getHostDetail(idx);
		
		request.setAttribute("hostDetail", hostDetail);
	}

}
