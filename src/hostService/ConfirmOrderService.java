// 예약 승인 테스트를 위한 작성 -- 작성자 정다영 
package hostService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderinfo.orderinfodao.OrderInfoDAO;
import service.ServiceInterface;

public class ConfirmOrderService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int oi_num = Integer.parseInt(request.getParameter("oi_num"));
		System.out.println("oi_num : " + oi_num);
		
		int a = OrderInfoDAO.getInstance().confirmOrder(oi_num);
		
		if(a == 1) {
			System.out.println("예약 승인 완료");
		}else {
			System.out.println("예약 승인 실패");
		}
		
		request.setAttribute("a", a); 
	}

}
