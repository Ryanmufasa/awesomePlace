//https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영
package memberJoinService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import service.ServiceInterface;

public class EmailCheckService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String email = request.getParameter("email");
		System.out.println("email : " + email);
		
		int email1 = MemberDAO.getInstance().searchEmail(email);
		
		if (email1 == 0 ){
			System.out.println("이메일 사용 가능 ");
		} else {
			System.out.println("이메일 중복");
		}
		
		request.setAttribute("email1", email1);
		
	}

}
