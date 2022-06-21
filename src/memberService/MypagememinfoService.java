package memberService;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class MypagememinfoService implements ServiceInterface{

	
	private String mempw;

	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {


		String action = request.getParameter("action");
		//		String url="";

		String mem_name=request.getParameter("mem_name");
		String mem_id=request.getParameter("mem_id");
		String mem_pw=request.getParameter("mem_pw");
		String mem_tel=request.getParameter("mem_tel");
		String mem_email=request.getParameter("mem_email");
		HttpSession session = request.getSession();

		MemberVO mb = MemberDAO.getInstance().getMember(mempw);
		
		//		request.setAttribute("md", md);
		if("info".equals(action)) {
			session.setAttribute("mem_name", mem_name);
			session.setAttribute("mem_id", mem_id);
			session.setAttribute("mem_pw", mem_pw);
			session.setAttribute("mem_tel", mem_tel);
			session.setAttribute("mem_email", mem_email);
		}
		
		session.setAttribute("mb", mb);
		//		if("info".equals(action)) {
		//			String mempw=request.getParameter("mempw");
		//			MemberVO mb=memberDAO.getMember(mempw);
		//			request.setAttribute("mb", mb); //여기로 받겠다
		//			url="/mypageinfo/Mypagememinfo.jsp";
		//			}
		//			request.getRequestDispatcher(url).forward(request, response);

	}
	//response.sendRedirect("Mypage_meminfo.jsp");
}



