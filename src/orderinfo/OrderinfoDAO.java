//https://github.com/Ryanmufasa/awesomePlace/issues/41 = 작성자 고유주
package orderinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import awesomePlace.dbConn.DBConn;
import orderinfo.OrderinfoVO;

public class OrderinfoDAO { 

	private Connection con = new DBConn().getConnection();
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static OrderinfoDAO instance;

	public static OrderinfoDAO getInstance() {
		if(instance == null) {
			instance = new OrderinfoDAO();
		}
		return instance;
	}


	//전체 목록 불러오기
	// 조회 select / 삽입 insert / 삭제 delete / 수정 update
	public ArrayList<OrderinfoVO> getAllreser(String oi_mem_id){
		ArrayList<OrderinfoVO> reser = new ArrayList<OrderinfoVO>();
		String sql = "select * from orderinfo where oi_mem_id=?";
		OrderinfoVO vo = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, oi_mem_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new OrderinfoVO();
				vo.setOi_num(rs.getInt("oi_num"));
				vo.setOi_guest_cnt(rs.getInt("oi_guest_cnt"));
				vo.setCheckin_date(rs.getDate("checkin_date"));
				vo.setCheckout_date(rs.getDate("checkout_date"));
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



	//마이페이지에서 자세히 예약내역 불러오기
	public OrderinfoVO getreser(int oi_num) {
		OrderinfoVO od = new OrderinfoVO();
		String sql = "select * from orderinfo where oi_num = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, oi_num);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				od.setOi_num(rs.getInt("oi_num"));
				od.setOi_host_name(rs.getString("oi_host_name"));
				od.setOi_host_addr(rs.getString("oi_host_addr"));
				od.setOi_host_tel(rs.getString("oi_host_tel"));
				od.setOi_guest_cnt(rs.getInt("oi_guest_cnt"));
				od.setCheckin_date(rs.getDate("checkin_date"));
				od.setCheckout_date(rs.getDate("checkout_date"));
				od.setPay_amt(rs.getInt("pay_amt"));
				od.setPay_date(rs.getDate("pay_date"));
				od.setOi_sign(rs.getString("oi_sign"));

			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return od;
	}





	//마이페이지 예약내역 삭제
	public boolean deletereser (OrderinfoVO vo) {
		boolean reser = false;
		String sql = "delete orderinfo where oi_mem_id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getOi_mem_id());
			if(pstmt.executeUpdate() !=0) {
				reser = true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reser;
	}


}
