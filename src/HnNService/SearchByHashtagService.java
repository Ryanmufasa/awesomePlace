//https://github.com/Ryanmufasa/awesomePlace/issues/25 -- 작성자 정다영 
package HnNService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hashtag.HashtagDAO;
import host.hostvo.HostVO;
import service.ServiceInterface;

public class SearchByHashtagService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		String tag_name = (String)request.getParameter("tag_name");
		
		ArrayList<HostVO> hostli = HashtagDAO.getInstance().getHostList(tag_name);
		
		if(hostli != null) {
			System.out.println("해시태그 적용된 호스트 있음 ");
		}else {
			System.out.println("해당 해시태그 적용된 호스트 없음 ");
		}
		
		request.setAttribute("hostli", hostli);
		request.setAttribute("tag_name", tag_name);
		
		
	}

}
