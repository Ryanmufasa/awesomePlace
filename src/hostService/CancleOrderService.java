package hostService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderinfo.orderinfodao.OrderInfoDAO;
import service.ServiceInterface;

public class CancleOrderService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int oi_num = Integer.parseInt(request.getParameter("oi_num"));
		System.out.println("oi_num : " + oi_num);
		
		int a = OrderInfoDAO.getInstance().cancleOrder(oi_num);
		
		if(a == 1) {
			System.out.println("예약 승인 취소 완료");
		}else {
			System.out.println("예약 승인 실패 ");
		}
		
		request.setAttribute("a", a);
		
	}

}
