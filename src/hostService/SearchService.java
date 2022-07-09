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
		
		String search = null;
		String checkIn = null;
		String checkOut = null;
		int guestCnt = 2; // default 숙박 검색 인원 2명 
		
		
		try {
			
			search = request.getParameter("search"); // 지역명 검색 
			checkIn = request.getParameter("checkIn");
			checkOut = request.getParameter("checkOut");
			guestCnt = Integer.parseInt(request.getParameter("guestCnt"));
			
		}catch( NullPointerException e) { 
			e.printStackTrace(); 
		}finally {
			
			System.out.println("----검색 내용 확인----");
			System.out.println("search 지역 검색내용 : " + search);
			System.out.println("체크인 날짜 : "+ checkIn ); 
			System.out.println("체크아웃 날짜 : "+ checkOut); 
			System.out.println("숙박인원 : " + guestCnt + "명");
			System.out.println("-------------------");
		}

		// checkIn 날짜 값이 있을 때 checkOut 값은 "" 일 수 있지만
			// checkOut 날짜 값이 있을 때 checkIn 값이 "" 일 수 없다. 
			
			if(checkIn.equals("")) { // checkOut 의 값은 null 로 넘어오므로
				checkOut = ""; 
			}
			
			// 검색이 진행될 때 조회될 host 테이블의 데이터는 sign 컬럼 값이 true 여야만 한다.
			
			ArrayList<HostVO> hostli = null;
			
			String[] search1 = search.split(" ");
			String keyword = "%";
			for(int i = 0; i < search1.length; i ++) {
				keyword  +=  search1[i];
				keyword  +=  "%";
			}
			
			if(search.equals("") && checkIn.equals("") && checkOut.equals("") && guestCnt == 1) {
				System.out.println("입력값 없이 전체 목록 조회");
				hostli = HostDAO.getInstance().AllTrueHost();
			}else {
				System.out.println("입력값에 따른 호스트 목록 조회");
				System.out.println("keyword : " + keyword);
				hostli = HostDAO.getInstance().searchHost(keyword, checkIn, checkOut, guestCnt);
			}
		
		
//		if(!search.trim().equals("")) { // 공백 제외 search 입력값이 있는지 
//			System.out.println("search 검색어 있음");
//			switch(category) {
//			case "region":
//				System.out.println( "1");
//				break;
//			case "keyword" :
//				System.out.println( "2");
//				break;
//			}
//		}else if(search.trim().equals("")){ // 공백제외 입력값 없는경우 "" 
//			System.out.println("search 입력 없으므로 지역 전체로 조회");
//			hostli = HostDAO.getInstance().AllTrueHost();
//		}
//			else {// 
//			System.out.println("전체출력");
//			hostli = HostDAO.getInstance().getAllHost();
//		}
		
		request.setAttribute("hostli", hostli);
		
		// 검색 입력값도 같이 보낸다. 
		request.setAttribute("search", search);
		request.setAttribute("checkIn", checkIn);
		request.setAttribute("checkOut", checkOut);
		request.setAttribute("guestCnt", guestCnt);
		
	}

}
