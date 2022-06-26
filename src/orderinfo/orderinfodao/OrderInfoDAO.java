// 개인 작업을 위한 작성  -- 작성자 정다영
package orderinfo.orderinfodao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import awesomePlace.dbConn.DBConn;
import orderinfo.orderinfovo.OrderInfoVO;

public class OrderInfoDAO {
	
	private Connection con = new DBConn().getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static OrderInfoDAO instance;
	
	public static OrderInfoDAO getInstance() {
		if(instance == null) {
			instance = new OrderInfoDAO();
		}
		return instance;
	}
	
	
	// 전체 예약 내역 조회 - 관리자용
	public ArrayList<OrderInfoVO> getOrderInfoList(){
		
		ArrayList<OrderInfoVO> orderli = new ArrayList<OrderInfoVO>();
		
		String sql = "select * from orderinfo by order_num desc";
		
		OrderInfoVO vo = null;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = getInfo(rs);
				
				orderli.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
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
			vo.setOrder_num(rs.getInt("order_num"));
			vo.setHost_num(rs.getInt("host_num"));
			vo.setMem_num(rs.getInt("mem_num"));
			vo.setGuest_cnt(rs.getInt("guest_cnt"));
			vo.setOrder_date(rs.getDate("order_date"));
			vo.setCheckIn_date(rs.getDate("checkIn_date"));
			vo.setCheckOut_date(rs.getDate("checkOut_date"));
			vo.setPay_amt(rs.getInt("pay_amt"));
			vo.setOrder_sign(rs.getString("order_sign"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	
	
	// 예약 신청시
	public boolean memberOrder(OrderInfoVO vo) {
		boolean check = false;
		
		String sql = "insert into orderinfo values(orderinfo_seq.nextval, ?,?,?,"
				+ "sysdate,?,?,?,'unknown'";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getHost_num());
			ps.setInt(2, vo.getMem_num());
			ps.setInt(3, vo.getGuest_cnt());
			ps.setDate(4, (Date) vo.getCheckIn_date());
			ps.setDate(5, (Date) vo.getCheckOut_date());
			ps.setInt(6, vo.getPay_amt());
			if(ps.executeUpdate() != 0) {
				check = true;
				System.out.println("예약 신청 완료");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	
	// 예약 정보 조회시
	public ArrayList<OrderInfoVO> selectOrder(int host_num) {
		
		ArrayList<OrderInfoVO> oili = new ArrayList<OrderInfoVO>();
		
		OrderInfoVO vo = null;
		
		String sql ="select * from orderinfo where host_num=?";
		
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1, host_num);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = getInfo(rs);
				oili.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(oili.isEmpty()) {
			oili = null;
			System.out.println("해당 호스트의 예약 정보 없음");
		}else {
			oili.trimToSize();
		}
		
		return oili;
	}
	
	
	

}
