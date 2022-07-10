package hostInfoUpdateService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import service.ServiceInterface;

public class UpdateHostInfo1Service implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		
		
		String host_name = (String)request.getParameter("host_name");
		System.out.println("변경할 host_name : " + host_name);
		
		String host_tel = (String)request.getParameter("host_tel");
		System.out.println("변경할 host_tel : " + host_tel);
		
		String host_content = (String)request.getParameter("host_content");
		System.out.println("변경할 host_content 내용 : " + host_content);
		
		HostVO vo = new HostVO();
		vo.setHost_name(host_name);
		vo.setHost_num(host_num);
		vo.setHost_tel(host_tel);
		vo.setHost_content(host_content);
		
		int result = HostDAO.getInstance().updateinfo1(vo);
		
		if(result == 1) {
			System.out.println("기본 정보 수정 완료");
			
		}else {
			System.out.println("정보 수정 실패 ");
		}
		
		request.setAttribute("result", result);
		
	}

}
