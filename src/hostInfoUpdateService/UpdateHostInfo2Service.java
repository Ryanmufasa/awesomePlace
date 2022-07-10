package hostInfoUpdateService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import service.ServiceInterface;

public class UpdateHostInfo2Service implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		
		String room_type = (String)request.getParameter("room_type");
		System.out.println("변경할 room_type : " + room_type);
		
		int room_cnt = Integer.parseInt(request.getParameter("room_cnt"));
		System.out.println("변경할 방 개수 : "+ room_cnt);
		
		int guest_cnt  = Integer.parseInt(request.getParameter("guest_cnt"));
		System.out.println("변경할 숙박 인원 : " + guest_cnt);
		
		HostVO vo = new HostVO();
		
		vo.setGuest_cnt(guest_cnt);
		vo.setRoom_cnt(room_cnt);
		vo.setRoom_type(room_type);
		vo.setHost_num(host_num);
		
		int result = HostDAO.getInstance().updateinfo2(vo);
		
		if(result == 1) {
			System.out.println("정보 수정 완료");
			
		}else {
			System.out.println("정보 수정 실패 ");
		}
		
		request.setAttribute("result", result);
	}

}
