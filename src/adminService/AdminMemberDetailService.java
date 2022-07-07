//https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
package adminService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class AdminMemberDetailService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO dao = MemberDAO.getInstance();
		int idx=0;
		String temp = request.getParameter("idx");
		
		if(temp!=null) {
			idx = Integer.parseInt(temp);
		}
		System.out.println(idx);
		MemberVO memInfo = dao.getMemberDetail(idx);
		
		request.setAttribute("memInfo", memInfo);
	}

}
