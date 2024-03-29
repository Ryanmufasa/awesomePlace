package adminService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class AdminMemberDeleteService implements ServiceInterface {

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
		boolean result = dao.getMemberDelete(idx);
		String memDelRes;
		
		if(result) {
			memDelRes = "true";
		}else {
			memDelRes = "false";
		}
		
		request.setAttribute("memDelRes", memDelRes);
	}

}
