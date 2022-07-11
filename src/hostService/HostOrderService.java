//// https://github.com/Ryanmufasa/awesomePlace/issues/57 -- 작성자 정다영 
package hostService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import host.hostdao.HostDAO;
import host.hostvo.HostVO;
import member.MemberVO;
import orderinfo.orderinfodao.OrderInfoDAO;
import orderinfo.orderinfovo.OrderInfoVO;
import service.ServiceInterface;

public class HostOrderService implements ServiceInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// orderinfo 에 저장될 내용
		OrderInfoVO oivo = new OrderInfoVO();
		// 예약 번호
		// 숙박인원, 체크인 체크아웃 날짜, 결제일자, 결제 금액, 예약 승인
		// 호스트 번호, 호스트 이름, 호스트 주소, 호스트 우편번호, 호스트 연락처
		// 회원 아이디, 회원 전화번호 
		
		// 현재 로그인 중인 회원 정보
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("mem_id");
		String m_id = mvo.getMem_id();
		String m_tel = mvo.getMem_tel();
		System.out.println("예약하는 회원 아이디 : " + m_id  );
		System.out.println("예약 회원 연락처 : " + m_tel);
		
		oivo.setOi_mem_id(m_id);
		oivo.setOi_mem_tel(m_tel);
		
		int pay_amt = Integer.parseInt(request.getParameter("pay_amt"));
		System.out.println("결제 금액 : " + pay_amt);
		oivo.setPay_amt(pay_amt);

		// 회원이 선택한 호스트 정보 
		//HostVO hvo = (HostVO)request.getParameter("host");  -- error
		
		// 객체는 json 형식으로 입력해서 받아야 하므로 host_num 으로 해당 host 찾기
		
		int host_num = Integer.parseInt(request.getParameter("host_num"));
		System.out.println("host_num : " + host_num);
		
		HostVO hvo = HostDAO.getInstance().selectHost(host_num);
		
		oivo.setOi_host_num(hvo.getHost_num());
		oivo.setOi_host_name(hvo.getHost_name());
		oivo.setOi_host_addr(hvo.getHost_addr());
		oivo.setOi_host_post_num(hvo.getHost_post_num());
		oivo.setOi_host_tel(hvo.getHost_tel());
		
		// 클라이언트 입력값 
		int guest_cnt = Integer.parseInt(request.getParameter("guest_cnt"));
		System.out.println("숙박 인원 : " + guest_cnt);
		
		oivo.setOi_guest_cnt(guest_cnt);
		
		
		String chIn = request.getParameter("checkIn1");
		System.out.println("checkIn : "  + chIn); 
		
		String chOut = request.getParameter("checkOut1");
		System.out.println("checkOut : " + chOut);
		
		// 파라미터로 넘어온 값을 java.util.Date 로 받음
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date checkIn_date = null;
		Date checkOut_date = null;
		
		try {
			checkIn_date = df.parse(chIn);
			checkOut_date = df.parse(chOut);
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			System.out.println("checkIn_date : " + checkIn_date);
			System.out.println("checkIn_date : " + checkOut_date);
			oivo.setCheckIn_date(checkIn_date);
			oivo.setCheckOut_date(checkOut_date);
		}
		
		// OrderInfo 테이블에 예약 입력하기

		boolean check = OrderInfoDAO.getInstance().memberOrder(oivo);
		String msg = "";
		
		if(check) {
			msg = "예약 성공";
			
		}else {
			System.out.println("예약 실패 ");
			msg = "예약에 실패하였습니다. 잠시 후 다시 시도해주세요";
		}
		
		request.setAttribute("check", check);
		request.setAttribute("msg", msg);
		
		
		
		//checkIn = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(chIn);
		//checkOut = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(chOut);
		//checkIn = (Date) new SimpleDateFormat().parse(chIn);
		//System.out.println(checkIn);
		//checkOut = (Date) new SimpleDateFormat().parse(chOut);
		//System.out.println(checkOut);
	
	
		//oivo.setCheckIn_date(checkIn_date);
		//oivo.setCheckOut_date(checkOut_date);
	
	
	
	
	// Date 로 처리시 parseException 이 계속 발생해서
	// String 형식으로 처리함. 
	/*
	 * Date checkIn = null; Date checkOut = null;
	 * 
	 * //SimpleDateFormat toStr = new SimpleDateFormat("yyyy-MM-dd"); DateFormat
	 * date = new SimpleDateFormat("yyyy-MM-dd"); try { checkIn = date.parse(chIn);
	 * System.out.println(checkIn); checkOut = date.parse(chOut);
	 * System.out.println(checkOut); } catch (ParseException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 */
	
	//oivo.setCheckIn_date(chIn);
	//oivo.setCheckOut_date(chOut);
	
		//oivo.setCheckIn_date(chIn);
		
		/*
		 * Date checkIn = null; Date checkOut = null;
		 * 
		 * try { SimpleDateFormat toStr = new SimpleDateFormat("yyyy-MM-dd");
		 * 
		 * checkIn = toStr.parse("chIn"); System.out.println("체크인 일자 : " + checkIn );
		 * 
		 * checkOut = toStr.parse("chOut"); System.out.println("체크아웃 일자 : " + checkOut);
		 * 
		 * 
		 * }catch(ParseException e) { e.printStackTrace();
		 * System.out.println("날짜 변환 에러"); }
		 * 
		 * oivo.setCheckIn_date(checkIn); oivo.setCheckOut_date(checkOut);
		 */
		
		// OrderInfo 테이블에 예약 입력하기

//		boolean check = OrderInfoDAO.getInstance().memberOrder(oivo);
//		String msg = "";
//		
//		if(check) {
//			msg = "예약 성공";
//			
//		}else {
//			System.out.println("예약 실패 ");
//			msg = "예약에 실패하였습니다. 잠시 후 다시 시도해주세요";
//		}
//		
//		request.setAttribute("check", check);
//		request.setAttribute("msg", msg);
		
	}

}
