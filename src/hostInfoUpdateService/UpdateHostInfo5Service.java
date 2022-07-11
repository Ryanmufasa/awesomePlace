package hostInfoUpdateService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hashtag.HashtagDAO;
import service.ServiceInterface;

public class UpdateHostInfo5Service implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		
		int tag_num = Integer.parseInt(request.getParameter("tag_num"));
		System.out.println("삭제할 태그 번호 : " + tag_num);
		
		int result = HashtagDAO.getInstance().delTags(tag_num, host_num);
		
		if(result == 1) {
			System.out.println("태그 삭제 완료");
			
		}else {
			System.out.println("태그 삭제 실패. 이미 삭제되었거나 잘못된 선택 ");
		}
		
		request.setAttribute("result", result);

	}

}
