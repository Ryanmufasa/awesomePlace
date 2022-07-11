//https://github.com/Ryanmufasa/awesomePlace/issues/48 = 작성자 고유주
package memberService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;
import orderinfo.orderinfodao.OrderInfoDAO;
import orderinfo.orderinfovo.OrderInfoVO;
import service.ServiceInterface;

public class MypageorderinfoService implements ServiceInterface{
//	private OrderinfoDAO reserDAO;


	@Override
	public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();		
		MemberVO vo = (MemberVO)session.getAttribute("mem_id");
		String oi_mem_id = vo.getMem_id();
		ArrayList<OrderInfoVO> reser = null;
		reser = OrderInfoDAO.getInstance().getAllreser(oi_mem_id);
		
		
		boolean check = false;
		String ms = null;
		
		if(reser != null) {
			check = true;
			request.setAttribute("reser", reser);
			
		}else {

		}
		request.setAttribute("check", check);

		
		

	}

}



