//https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
package orderinfoService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderinfo.orderinfodao.OrderInfoDAO;
import orderinfo.orderinfovo.OrderInfoVO;
import service.ServiceInterface;

public class GetMoreOrderInfoService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int oi_num = Integer.parseInt(request.getParameter("oi_num"));
		
		OrderInfoVO vo = OrderInfoDAO.getInstance().getOrder(oi_num);
		
		request.setAttribute("vo", vo);
		
	}
	

}
