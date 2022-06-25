package host.hostorderdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import awesomePlace.dbConn.DBConn;
import host.hostordervo.HostOrderVO;

public class HostOrderDAO {
	
	private Connection con = new DBConn().getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static HostOrderDAO instance;
	
	public static HostOrderDAO getInstance() {
		if(instance == null) {
			instance = new HostOrderDAO();
		}
		
		return instance;
	}
	
	
	// 예약 테이블 내열 전체 열람 ( 관리자 ) 
	public ArrayList<HostOrderVO> getAllOrderList(){
		
		ArrayList<HostOrderVO> orderlist = new ArrayList<HostOrderVO>();
		
		String sql = "select * from hostorder order by order_id";
		HostOrderVO vo = null;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = getOrder(rs);
				
				orderlist.add(vo);
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
		
		if(orderlist.isEmpty()) {
			orderlist = null;
			System.out.println("HostOrder 전체 데이터 없음.");
		}else {
			orderlist.trimToSize();
		}
		
		return orderlist;
		
	}

	// DB에 있는 데이터 행 하나씩 반환
	private HostOrderVO getOrder(ResultSet rs2) {
		
		HostOrderVO vo  =  null;
		
		try {
			vo = new HostOrderVO();
			vo.setOrder_id(rs.getInt("order_id"));
			vo.setCheckin(rs.getDate("checkin"));
			vo.setCheckout(rs.getDate("checkout"));
			vo.setHost_num(rs.getInt("host_num"));
			vo.setOrder_state(rs.getString("order_state"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	// 예약 내역 입력
	public boolean insertHostOrder(HostOrderVO vo) {
		boolean  check = false;
		
		String sql = "insert into hostorder values(order_id.nextVal,?,?,?,'Wait')";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setDate(1, (Date) vo.getCheckin());
			ps.setDate(2, (Date) vo.getCheckout());
			ps.setInt(3, vo.getHost_num());
			if(ps.executeUpdate() != 0) {
				check = true;
				System.out.println("예약 내역 입력 성공 ");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("예약 내역 입력 실패 ");
		}finally {
			try {
				if(ps != null) ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	// orderinfo 테이블에서 예약 승인여부에 따른 order_state 변경 
	public boolean updateOrderState(HostOrderVO vo, String state) {
		boolean check = false;
		
		String sql = "update hostorder set order_state = ? where order_id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, state);
			ps.setInt(2, vo.getOrder_id());
			if(ps.executeUpdate() != 0 ) {
				check = true;
				System.out.println("HostOrder update success");
				return check;
			}
		}catch(SQLException e) {
			System.out.println("HostOrder update failed");
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
	
	
	
	
	
	
	

}
