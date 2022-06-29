//https://github.com/Ryanmufasa/awesomePlace/issues/9 작성자: 이명진
package adminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceInterface;

public class AdminService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ss1 = request.getSession();
		ss1.setAttribute("adminPage", true);
	}

}
