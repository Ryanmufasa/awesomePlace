package memberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceInterface;

public class AdminOutService implements ServiceInterface{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ss1 = request.getSession();
		ss1.removeAttribute("adminPage");
	}

}