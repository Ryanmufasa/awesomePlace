package memberService;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;
import orderinfo.orderinfodao.OrderInfoDAO;
import orderinfo.orderinfovo.OrderInfoVO;
import service.ServiceInterface;

public class MypageOrderinfoClickService implements ServiceInterface {

	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException{
			
		HttpSession session = request.getSession();		
		int oi_num=Integer.parseInt(request.getParameter("oi_num"));
		OrderInfoVO od = OrderInfoDAO.getInstance().getreser(oi_num);
		request.setAttribute("od", od);	
	
		
		
		
	}
}
