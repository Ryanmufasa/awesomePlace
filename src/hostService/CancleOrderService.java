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
		
		int cancleResult = OrderInfoDAO.getInstance().cancleOrder(oi_num);
		System.out.println(cancleResult);
		if(cancleResult == 1) {
			System.out.println("예약 승인 취소 완료");
		}else {
			System.out.println("예약 승인 실패 ");
		}
		
		request.setAttribute("cancleResult", cancleResult);
		
	}

}
