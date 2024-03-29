// https://github.com/Ryanmufasa/awesomePlace/issues/57 , 
// https://github.com/Ryanmufasa/awesomePlace/issues/44  작성자 정다영
package orderinfo.orderinfodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import awesomePlace.dbConn.DBConn;
import orderinfo.orderinfovo.OrderInfoVO;

public class OrderInfoDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static OrderInfoDAO instance;
	
	public static OrderInfoDAO getInstance() {
		if(instance == null) {
			instance = new OrderInfoDAO();
		}
		return instance;
	}
	
	
	private void closeAll() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//전체 목록 불러오기 작성자 = 고유주
			// 조회 select / 삽입 insert / 삭제 delete / 수정 update
			public ArrayList<OrderInfoVO> getAllreser(String oi_mem_id){
				ArrayList<OrderInfoVO> reser = new ArrayList<OrderInfoVO>();
				String sql = "select * from orderinfo where oi_mem_id=?";
				OrderInfoVO vo = null;
				try {

					ps = con.prepareStatement(sql);
					ps.setString(1, oi_mem_id);
					rs = ps.executeQuery();
					while(rs.next()) {
						vo = new OrderInfoVO();
						vo.setOi_num(rs.getInt("oi_num"));
						vo.setOi_guest_cnt(rs.getInt("oi_guest_cnt"));
						vo.setCheckIn_date(rs.getDate("checkIn_date"));
						vo.setCheckOut_date(rs.getDate("checkOut_date"));
						vo.setPay_date(rs.getDate("pay_date"));
						vo.setPay_amt(rs.getInt("pay_amt"));
						vo.setOi_sign(rs.getString("oi_sign"));
						vo.setOi_host_num(rs.getInt("oi_host_num"));
						vo.setOi_host_name(rs.getString("oi_host_name"));
						vo.setOi_host_addr(rs.getString("oi_host_addr"));
						vo.setOi_host_post_num(rs.getString("oi_host_post_num"));
						vo.setOi_host_tel(rs.getString("oi_host_tel"));
						vo.setOi_mem_id(rs.getString("oi_mem_id"));
						vo.setOi_mem_tel(rs.getString("oi_mem_tel"));
						reser.add(vo);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}		
				if(reser.isEmpty()) {
					reser = null;
					System.out.println("예약내역 없음");
				}else {
					reser.trimToSize();
				}

				return reser;
			} 

		//마이페이지에서 자세히 예약내역 불러오기 작성자 = 고유주
			public OrderInfoVO getreser(int oi_num) {
				OrderInfoVO od = new OrderInfoVO();
				String sql = "select * from orderinfo where oi_num = ?";

				try {
					ps = con.prepareStatement(sql);
					ps.setInt(1, oi_num);
					rs = ps.executeQuery();

					if(rs.next()) {
						od.setOi_num(rs.getInt("oi_num"));
						od.setOi_host_name(rs.getString("oi_host_name"));
						od.setOi_host_addr(rs.getString("oi_host_addr"));
						od.setOi_host_tel(rs.getString("oi_host_tel"));
						od.setOi_guest_cnt(rs.getInt("oi_guest_cnt"));
						od.setCheckIn_date(rs.getDate("checkIn_date"));
						od.setCheckOut_date(rs.getDate("checkOut_date"));
						od.setPay_amt(rs.getInt("pay_amt"));
						od.setPay_date(rs.getDate("pay_date"));
						od.setOi_sign(rs.getString("oi_sign"));

					}
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
					try {
						if(rs != null) rs.close();
						if(ps != null) ps.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return od;
			}		
	
	
	// 전체 예약 내역 조회 - 관리자용
	public ArrayList<OrderInfoVO> getOrderInfoList(){
		
		ArrayList<OrderInfoVO> orderli = new ArrayList<OrderInfoVO>();
		
		String sql = "select * from orderinfo by oi_num desc";
		
		OrderInfoVO vo = null;
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = getInfo(rs);
				
				orderli.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		if(orderli.isEmpty()) {
			orderli = null;
		}else {
			orderli.trimToSize();
		}
		
		return orderli;
		
	}

	// vo 생성시 
	private OrderInfoVO getInfo(ResultSet rs2) {
		
		OrderInfoVO vo = null;
		
		try {
			vo = new OrderInfoVO();
			vo.setOi_num(rs.getInt("oi_num"));
			vo.setOi_guest_cnt(rs.getInt("oi_guest_cnt"));
			vo.setCheckIn_date(new java.util.Date(rs.getDate("checkIn_date").getTime()));
			vo.setCheckOut_date(new java.util.Date(rs.getDate("checkOut_date").getTime()));
			vo.setPay_date(rs.getDate("pay_date"));
			vo.setPay_amt(rs.getInt("pay_amt"));
			vo.setOi_sign(rs.getString("oi_sign"));
			
			vo.setOi_host_num(rs.getInt("oi_host_num"));
			vo.setOi_host_name(rs.getString("oi_host_name"));
			vo.setOi_host_post_num(rs.getString("oi_host_post_num"));
			vo.setOi_host_tel(rs.getString("oi_host_tel"));
			
			vo.setOi_mem_id(rs.getString("oi_mem_id"));
			vo.setOi_mem_tel(rs.getString("oi_mem_tel"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	
	
	// 예약 신청시
	public boolean memberOrder(OrderInfoVO vo) {
		boolean check = false;
		
		String sql = "insert into orderinfo values(orderinfo_seq.nextval, "
				+ "?,?,?,sysdate,?,'wait',"
				+ "?,?,?,?,?,?,?)";
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getOi_guest_cnt());
			ps.setDate(2, new java.sql.Date(vo.getCheckIn_date().getTime()));
			ps.setDate(3, new java.sql.Date(vo.getCheckOut_date().getTime()));
			ps.setInt(4, vo.getPay_amt());
			
			ps.setInt(5, vo.getOi_host_num());
			ps.setString(6, vo.getOi_host_name());
			ps.setString(7, vo.getOi_host_addr());
			ps.setString(8, vo.getOi_host_post_num());
			ps.setString(9, vo.getOi_host_tel());
			ps.setString(10, vo.getOi_mem_id());
			ps.setString(11, vo.getOi_mem_tel());
			if(ps.executeUpdate() != 0) {
				check = true;
				System.out.println("예약 신청 완료");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return check;
	}
	
	
	// 호스트의 예약 정보 리스트 조회시
	public ArrayList<OrderInfoVO> selectOrder(int oi_host_num) {
		
		ArrayList<OrderInfoVO> oili = new ArrayList<OrderInfoVO>();
		
		OrderInfoVO vo = null;
		
		String sql ="select * from orderinfo where oi_host_num=?";
		
		try {
			con = new DBConn().getConnection();
			ps= con.prepareStatement(sql);
			ps.setInt(1, oi_host_num);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = getInfo(rs);
				oili.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		if(oili.isEmpty()) {
			oili = null;
			System.out.println("해당 호스트의 예약 정보 없음");
		}else {
			oili.trimToSize();
		}
		
		return oili;
	}
	
	// 예약 정보 상세보기
	public OrderInfoVO getOrder(int oi_num) {
		
		OrderInfoVO vo = null;
		
		String sql = "select * from orderinfo where oi_num=?";
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, oi_num);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = getInfo(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return vo;
		
	}
	
	// 예약 승인 - 호스트 
	public int confirmOrder(int oi_num) {
		
		int a = 0;
		
		String sql = "update orderinfo set oi_sign='confirm' where oi_num=?";
		
		try {
			con = new DBConn().getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, oi_num);
			if(ps.executeUpdate() != 0) {
				a = 1;
				return a;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return a;
		
	}
	
	// 예약 승인 취소 - 호스트 
	public int cancleOrder(int oi_num) {
		
		int a = 0;
		String sql = "update orderinfo set oi_sign='cancle' where oi_num=?";
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, oi_num);
			if(ps.executeUpdate() != 0) {
				a = 1;
				return a;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return a;
	}
	
	
	// 호스트 중지시 예약 내역 존재 유무 확인
	public boolean findOrder(int oi_host_num) {
		
		String sql = "select * from orderinfo "
				+ "where oi_host_num =? "
				+ "and checkin_date >= sysdate "
				+ "and checkout_date >= sysdate "
				+ "and oi_sign in('confirm','wait')";
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, oi_host_num);
			rs = ps.executeQuery();
			if(rs.next()) { // 하나라도 있으면 중지 못함. 
				System.out.println("남은 예약 일정이 존재");
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return false;
		
	}

	
	// 예약 가능한지 확인하기
	public int checkOrderOk(int oi_host_num, String checkIn_date, String checkOut_date) {
		int result = 0;
		
		String sql = "select * from orderinfo "
				+ "where oi_host_num=? "
				+ "and checkIn_date between ? and ? "
				+ "or checkOut_date between ? and ?";
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, oi_host_num);
			ps.setString(2, checkIn_date);
			ps.setString(3, checkOut_date);
			ps.setString(4, checkIn_date);
			ps.setString(5, checkOut_date);
			rs = ps.executeQuery();
			while(rs.next()) {
				result += 1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return result;
	}
	
	
}
