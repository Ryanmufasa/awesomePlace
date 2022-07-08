package memberService;  //https://github.com/Ryanmufasa/awesomePlace/issues/10  //작성자: 양준모
						// 로그인 페이지에서 비밀번호찾기시 회원의 비밀번호를 수정할 수 있도록 하는 서비스 입니다.
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import service.ServiceInterface;


public class PWupdateService implements ServiceInterface{
	
	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	HttpSession session = request.getSession();
	
	
	String mem_id = (String)session.getAttribute("mem_id");
	String mem_pw = request.getParameter("mem_pw");
	
	MemberDAO dao = new MemberDAO();
	
//	dao.PWupdate(mem_id, mem_pw);
	
	boolean check = dao.PWupdate(mem_id, mem_pw);

	
	if(check) {
		System.out.println("수정성공");
	}else{
		System.out.println("수정실패");
	}
	request.setAttribute("check", check);
	
	
}

}
