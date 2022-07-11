package orderinfoService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderinfo.orderinfodao.OrderInfoDAO;
import service.ServiceInterface;

public class CheckOrderOkService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int oi_host_num = Integer.parseInt(request.getParameter("host_num"));
		
		String checkIn_date = request.getParameter("checkIn1");
		String checkOut_date = request.getParameter("checkOut1");
		
		int result = OrderInfoDAO.getInstance().checkOrderOk(oi_host_num, checkIn_date, checkOut_date);
		
		if(result == 0) {
			System.out.println("예약 가능");
		}else {
			System.out.println("예약 불가 ");
		}
		
		request.setAttribute("result", result);

	}

}
