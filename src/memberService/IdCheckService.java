//https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영
package memberService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import service.ServiceInterface;

public class IdCheckService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		
		int id1 = MemberDAO.getInstance().searchId(id);
		
		if(id1 == 0) {
			System.out.println("아이디 사용 가능");

		}else {
			System.out.println("아이디 중복 ");
		}
		request.setAttribute("id1", id1); // 0 또는 1 


	}

}
