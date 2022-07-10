//https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영
package hostService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hashtag.HashtagDAO;
import hashtag.HashtagVO;
import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import service.ServiceInterface;

public class UpdateHostInfoFormService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		System.out.println("호스트 번호 : " + host_num);
		
		HostVO vo = HostDAO.getInstance().selectHost(host_num);
		ArrayList<HashtagVO> taglist = HashtagDAO.getInstance().selectTag(host_num);
		
		if(vo != null) {
			System.out.println(vo.getHost_name() + "의 정보 불러옴");
			request.setAttribute("vo", vo);
			if(taglist != null) {
				System.out.println("해시태그 목록 불러옴");
				request.setAttribute("taglist", taglist);
			}
		}else {
			System.out.println("호스트 정보 불러오기 실패");
			request.setAttribute("vo", "");
		}
		
		
		
	}

}
