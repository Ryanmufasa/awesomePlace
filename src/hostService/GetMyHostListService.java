// https://github.com/Ryanmufasa/awesomePlace/issues/42 -- 작성자 정다영 
package hostService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import member.MemberVO;
import service.ServiceInterface;

public class GetMyHostListService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		
		MemberVO loginVO = (MemberVO) session.getAttribute("login");
		
		int mem_num = loginVO.getMem_num();
		
		ArrayList<HostVO> myHostList = null;
		
		myHostList = HostDAO.getInstance().getMyHostList(mem_num);
		
		boolean check = false;
		String msg = null;
		
		if(myHostList != null) {
			System.out.println("호스트 정보를 불러옵니다.");
			check = true;
			//session.setAttribute("myHostList", myHostList);
			request.setAttribute("myHostList", myHostList);
		}else {
			System.out.println("등록된 호스트 정보가 업습니다");
		}
		
		request.setAttribute("check", check);
		
	
	}

}
