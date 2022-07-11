package hostInfoUpdateService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import service.ServiceInterface;

public class UpdateHostInfo3Service implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		
		int weekday_amt = Integer.parseInt(request.getParameter("weekday_amt"));
		System.out.println("변경할 weekday_amt : " + weekday_amt);
		
		int weekend_amt = Integer.parseInt(request.getParameter("weekend_amt"));
		System.out.println("변경할 weekend_amt : " + weekend_amt);
		
		HostVO vo = new HostVO();
		vo.setHost_num(host_num);
		vo.setWeekday_amt(weekday_amt);
		vo.setWeekend_amt(weekend_amt);
		
		int result = HostDAO.getInstance().updateAmt(vo);
		
		if(result == 1) {
			System.out.println("기본 정보 수정 완료");
			
		}else {
			System.out.println("정보 수정 실패 ");
		}
		
		request.setAttribute("result", result);
	}

}
