package hostInfoUpdateService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hashtag.HashtagDAO;
import service.ServiceInterface;

public class UpdateHostInfo4Service implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		
		int tag_num = Integer.parseInt(request.getParameter("tag_num"));
		System.out.println("추가할 태그 번호 : " + tag_num);
		
		
		int result = HashtagDAO.getInstance().addTags(tag_num, host_num);
		
		if(result == 1) {
			System.out.println("태그 추가 완료");
			
		}else {
			System.out.println("태그 추가 실패 ");
		}
		
		request.setAttribute("result", result);
		
		
	}

}
