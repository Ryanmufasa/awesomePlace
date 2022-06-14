//https://github.com/Ryanmufasa/awesomePlace/issues/25 -- 작성자 정다영
package hostService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import service.ServiceInterface;

public class SearchService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String category = request.getParameter("category");
		String search = request.getParameter("search");
		
		
		System.out.println(category);
		System.out.println(search);
		
		
		ArrayList<HostVO> hostli = null;
		
		
		if(category.equals("region")) {
			// 미구현
			
		}else if(category.equals("keyword")){
			// 미구현
			
		}else { // 카테고리 선택 안한 경우 전체 호스트 내역 출력 
			
			hostli = HostDAO.getInstance().getAllHost();
			
		}
		
		request.setAttribute("hostli", hostli);
		

	}

}
