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
		
//		DateFormat date = new SimpleDateFormat("yyyy-MM-dd"); 
//		SimpleDateFormat toStr = new SimpleDateFormat("yyyy-MM-dd"); 
//		Date checkIn = null;
//		Date checkOut = null;
		
		String search = null;
		String checkIn = null;
		String checkOut = null;
		int guestCnt = 1; // 최소 1명은 숙박해야 하므로...
		
		
		try {
			
			search = request.getParameter("search"); // 지역명 검색 
			checkIn = request.getParameter("checkIn");
			checkOut = request.getParameter("checkOut");
			//checkIn = date.parse(request.getParameter("checkIn")); 
			//checkOut = date.parse(request.getParameter("checkOut"));
			guestCnt = Integer.parseInt(request.getParameter("guestCnt"));
			
		}catch( NullPointerException e) { //ParseException |
			e.printStackTrace(); 
			// checkIn, checkOut 값을 Date 형식으로 변환 에러시 ( 입력값이 없을때 발생 -> null 로 처리)
//			if(checkIn == null) {
//				checkIn = null;
//				checkOut = null;
//			}else if(checkOut == null) {
//				checkOut = null;
//			}
		}finally {
			
			System.out.println("----검색 내용 확인----");
			System.out.println("search 지역 검색내용 : " + search);
			System.out.println("체크인 날짜 : "+ checkIn ); //  +  " \t"+ toStr.format(checkIn)
			System.out.println("체크아웃 날짜 : "+ checkOut);  //  + "\t"+ toStr.format(checkOut)
			System.out.println("숙박인원 : " + guestCnt + "명");
			System.out.println("-------------------");
		}

		
		ArrayList<HostVO> hostli = null;
		
		
		if(!search.trim().equals("")) { // 공백 제외 search 입력값이 있는지 
			System.out.println("search 검색어 있음");
			
//			switch(category) {
//			case "region":
//				System.out.println( "1");
//				break;
//			case "keyword" :
//				System.out.println( "2");
//				break;
//			}
			
		}else if(search.trim().equals("")){ // 공백제외 입력값 없는경우 "" 
			System.out.println("search 입력 없으므로 지역 전체로 조회");
			hostli = HostDAO.getInstance().getAllHost();
			
		}
//			else {// 
//			System.out.println("전체출력");
//			hostli = HostDAO.getInstance().getAllHost();
//		}
		

		
		request.setAttribute("hostli", hostli);
		
	}

}
