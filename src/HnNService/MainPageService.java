//https://github.com/Ryanmufasa/awesomePlace/issues/9 작성자: 이명진
package HnNService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceInterface;

public class MainPageService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession ss1 = request.getSession();
		
		ss1.removeAttribute("myPage");
		ss1.removeAttribute("hostingPage");
	}

}
