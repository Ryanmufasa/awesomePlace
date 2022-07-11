//https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
package hostService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import member.MemberVO;
import orderinfo.orderinfodao.OrderInfoDAO;
import service.ServiceInterface;

public class StopHostingService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		System.out.println("호스팅 중지할 host_num : " + host_num);
		
		HostVO vo = new HostVO();
		vo.setHost_num(host_num);
		
		String ck = "";
		String msg = null;
		
		// 요청 현재 일자 이후에 예약이 있는경우에는 중지 할 수 없으므로
		// 예약 여부 먼저 조회해야함.
		boolean check = OrderInfoDAO.getInstance().findOrder(host_num);
		boolean check1 = false;
		
		if(check) { // true 인경우 남은 예약이 있음. 
			System.out.println("남은 예약 있으므로 호스팅 중지 할 수 없음");
			msg = "승인된 예약 내역이 있어 호스팅을 중지할 수 없습니다! 중지를 원하시면 고객센터에 문의해주세요!";
			ck ="";
			request.setAttribute("check", check); // true, ck 공백 -> 예약 조회 창으로 
			request.setAttribute("host_num", host_num);
		}else { // false 로 남은 예약이 없음
			System.out.println("남은 예약이 없으므로 호스팅 중지 가능");
			check1 = HostDAO.getInstance().stopHost(vo);
			// 호스팅 중지는 삭제가 아니므로 sign 만 false 로 수정
			// member 테이블의 호스트 개수는 변동 없음. 
			
			if(check1) { 
				System.out.println("호스팅 중지 성공");
				msg = "호스팅을 중지합니다.";
				ck="성공";
				request.setAttribute("check", check1); // true, ck 공백 아님 -> 호스트 목록창으로 
			}else {
				System.out.println("호스팅 중지 실패");
				msg ="요청 실패! 다시 시도해주세요!";
				ck="실패";
				request.setAttribute("check", check1); // false, ck 공백 아님 -> 호스트 목록창으로 
			}
		}

		
		request.setAttribute("msg", msg);
		request.setAttribute("ck", ck);
		
	}

}
