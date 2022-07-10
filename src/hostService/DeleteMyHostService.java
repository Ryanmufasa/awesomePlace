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

public class DeleteMyHostService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		System.out.println("삭제할 host_num : " + host_num);
		HostVO vo = new HostVO();
		vo.setHost_num(host_num);
		
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("mem_id");
		int mem_hostcnt = mvo.getMem_host_Cnt();
		int mem_num = mvo.getMem_num();
		System.out.println("현재 회원 호스트 개수 mem_hostcnt : " + mem_hostcnt);
		System.out.println("회원 번호 : " + mem_num);
		
		boolean check = HostDAO.getInstance().deleteHost(vo);
		
		mem_hostcnt -= 1; 
		boolean ch = MemberDAO.getInstance().updateHostCnt(mem_hostcnt, mem_num);
		
		String msg = null;
		String ck = "호스트 삭제";
		
		if(check && ch) {
			// Host 테이블에서 삭제 성공
			//mem_hostcnt -= 1; 
			//boolean ch = MemberDAO.getInstance().updateHostCnt(mem_hostcnt, mem_num);
			//if(ch) {
				msg = "호스트가 삭제되었습니다.";
				ck = "";
			//}
		}else {
			msg ="삭제 실패! 다시 시도해주세요!";
			ck = "호스트 삭제 실패";
			System.out.println("호스트 삭제 실패");
		}
		
		request.setAttribute("check", check);
		request.setAttribute("msg", msg);
		request.setAttribute("ck", ck);
		
		
		
		
		
		
	}

}
