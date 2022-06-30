//https://github.com/Ryanmufasa/awesomePlace/issues/36 -- 작성자 정다영
package hostService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import member.MemberDAO;
import member.MemberVO;
import service.ServiceInterface;

public class AddNewHostService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 현재 로그인 세션에 저장된 계정 정보 가져오기
		HttpSession session = request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("login");
		
		int mem_num = memvo.getMem_num();
		String mem_id = memvo.getMem_id();
		int mem_hostcnt = memvo.getMem_hostCnt();
		System.out.println("mem_num : " + mem_num);
		System.out.println("mem_id : " + mem_id);
		System.out.println("mem_hostcnt : " + mem_hostcnt);
		
		// Form 에서 입력된 값 받기 
		String host_name = request.getParameter("host_name");
		System.out.println("host_name : " + host_name);
		
		String host_addr = request.getParameter("host_addr1")
				+ request.getParameter("host_addr2")
				+ request.getParameter("host_addr3");
		System.out.println("host_addr : " + host_addr);
		
		String host_post_num =request.getParameter("host_post_num");
		System.out.println("host_post_num : " + host_post_num);
		
		String host_tel = request.getParameter("host_tel");
		System.out.println("host_tel : " + host_tel);
		
		String room_type = request.getParameter("room_type"); // A 전체, P 개인실, S 다인실
		System.out.println("room_type : " + room_type);
		
		int room_cnt = Integer.parseInt(request.getParameter("room_cnt_1"));
		if(room_cnt == 0) {
			room_cnt = Integer.parseInt(request.getParameter("room_cnt_2"));
		}
		System.out.println("room_cnt : " + room_cnt);
		
		int guest_cnt = Integer.parseInt(request.getParameter("guest_cnt"));
		System.out.println("guest_cnt : " + guest_cnt);
		
		int weekday_amt = Integer.parseInt(request.getParameter("weekday_amt").replace(",", ""));
		System.out.println("weekday_amt : " + weekday_amt);
		
		int weekend_amt = Integer.parseInt(request.getParameter("weekend_amt").replace(",", ""));
		System.out.println("weekend_amt : "+ weekend_amt);
		
		String host_content = request.getParameter("host_content");
		System.out.println("host_content : " + host_content);

		
		HostVO vo = new HostVO(host_name, host_addr, host_post_num, host_tel, room_type,
				room_cnt, guest_cnt, weekday_amt, weekend_amt, host_content, mem_num, mem_id);
		
		boolean check = HostDAO.getInstance().insertHost(vo);
		
		mem_hostcnt += 1;
		boolean ch = MemberDAO.getInstance().updateHostCnt(mem_hostcnt, mem_num);
		
		String msg = null;
		String ck = "";
		
		if(check && ch) {
			// Host 테이블에 등록 완료 되었으므로 member 테이블의 mem_hostcnt 값 변경
			//mem_hostcnt += 1; // 한번에 하나씩만 등록하므로
			//boolean ch = MemberDAO.getInstance().updateHostCnt(mem_hostcnt, mem_num);
			//if(ch) {
				msg = "새 호스트 등록 성공! 관리자 승인 후 예약 관리 가능합니다!";
				ck="성공";
			//}
		}else {
			msg = "등록 실패! 다시 시도해주세요!";
			System.out.println("호스트 등록 실패");
			
		}
		
		request.setAttribute("check", check);
		request.setAttribute("msg", msg);
		request.setAttribute("ck", ck);
		

	}

}
