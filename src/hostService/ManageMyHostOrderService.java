//https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
package hostService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import orderinfo.orderinfodao.OrderInfoDAO;
import orderinfo.orderinfovo.OrderInfoVO;
import service.ServiceInterface;

public class ManageMyHostOrderService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int host_num = Integer.parseInt(request.getParameter("host_num"));
		System.out.println("host_num : " + host_num);
		
		HostVO hostvo = HostDAO.getInstance().selectHost(host_num);
		ArrayList<OrderInfoVO> orderli = OrderInfoDAO.getInstance().selectOrder(host_num);
		

			request.setAttribute("host", hostvo);
			request.setAttribute("orderInfoList", orderli);

		
		// /myhosting/myHostOrderManage.jsp
	}

}
