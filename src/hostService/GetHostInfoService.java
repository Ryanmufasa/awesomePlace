//https://github.com/Ryanmufasa/awesomePlace/issues/38 -- 작성자 정다영
package hostService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import service.ServiceInterface;

public class GetHostInfoService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String host_name = request.getParameter("host_name");
		System.out.println("host_name : " + host_name);
		
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		
		System.out.println("host_num : " + host_num);
		
		HostVO vo = new HostVO();
		vo = HostDAO.getInstance().selectHost(host_num);
		
		if(vo != null) {
			System.out.println(vo.getHost_name() + " 상세 보기");
			request.setAttribute("vo", vo);
		}else {
			System.out.println("호스트 정보 불러오기 실패");
		}


	}

}
