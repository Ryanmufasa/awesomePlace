package hostService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import orderinfo.orderinfodao.OrderInfoDAO;
import orderinfo.orderinfovo.OrderInfoVO;
import service.ServiceInterface;

public class HostOrderService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 클라이언트 입력값 
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		System.out.println("host_num : " + host_num);
		
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut");
		
		System.out.println("checkIn : "  + checkIn); 
		System.out.println("checkOut : " + checkOut);
		
		// 예약할 호스트 정보 가져오기 
		HostVO vo = HostDAO.getInstance().selectHost(host_num);
		
		// OrderInfo 테이블에 예약 입력 
		//OrderInfoVO oivo = OrderInfoDAO.getInstance().memberOrder()
		
		
		request.setAttribute("host", vo);
		
		
	}

}
