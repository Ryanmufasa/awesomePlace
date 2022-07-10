//https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영 
package HnNService;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hashtag.HashtagDAO;
import hashtag.HashtagVO;
import service.ServiceInterface;

public class GetHashTagService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int host_num = Integer.parseInt(request.getParameter("host_num"));
		
		ArrayList<HashtagVO> tagli = HashtagDAO.getInstance().getAllTags();
		
		if(tagli != null) {
			System.out.println("해시태그 목록 불러오기");
			request.setAttribute("tagli", tagli);
		}
		
		request.setAttribute("host_num", host_num);
	}

}
