package memberLoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceInterface;

public class LogoutService implements ServiceInterface{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ss1 = request.getSession();
		ss1.invalidate();
		/*
		 * ss1.removeAttribute("mem_id"); //ss1.removeAttribute("doubleCheck");
		 * ss1.removeAttribute("myPage"); ss1.removeAttribute("hostingPage");
		 * ss1.removeAttribute("adminPage");
		 */
	}

}
