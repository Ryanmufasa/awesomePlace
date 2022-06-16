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
		
		System.out.println("category : " + category);
		System.out.println("검색내용: " + search);
		
		
		ArrayList<HostVO> hostli = null;
		System.out.println("----");
		
		if(!category.equals("none")) { // select value 없는경우 none 
			System.out.println("0");
			switch(category) {
			case "region":
				System.out.println( "1");
				break;
			case "keyword" :
				System.out.println( "2");
				break;
			}
			
		}else if(!search.equals("")){ // 입력값 없는경우 "" 
			System.out.println( "search");
			
		}else {// 카테고리 선택 안한 경우 전체 호스트 내역 출력 
			System.out.println("전체출력");
			hostli = HostDAO.getInstance().getAllHost();
		}
		

		
		request.setAttribute("hostli", hostli);
		
	}

}
