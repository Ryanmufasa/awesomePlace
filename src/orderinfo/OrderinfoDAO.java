// https://github.com/Ryanmufasa/awesomePlace/issues/24 -- 작성자 정다영
package orderinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
//목록 불러오기
public ArrayList<OrderinfoVO> getAllreser(){
		
		ArrayList<OrderinfoVO> reser = new ArrayList<OrderinfoVO>();
		
		String sql = "select * from orderinfo order by order_num desc";
		OrderinfoVO vo = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new OrderinfoVO();
				vo.setOrder_num(rs.getInt("order_num"));
				vo.setHost_num(rs.getInt("host_num"));
				vo.setHost_name(rs.getString("host_name"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setOrder_date(rs.getDate("order_date"));
				vo.setPay_amt(rs.getInt("pay_amt"));
				vo.setOrder_sign(rs.getString("order_sign"));
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
	


	//회원 예약내역 불러오기
	public OrderinfoVO getreser(int memnum) {
		OrderinfoVO od = new OrderinfoVO();
		String sql = "select * from order where mem_num = ?";
	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memnum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				od.setOrder_num(rs.getInt("ordernum"));
				od.setHost_num(rs.getInt("host_num"));
				od.setHost_name(rs.getString("host_name"));
				od.setMem_num(rs.getInt("mem_num"));
				od.setMem_name(rs.getString("mem_name"));
				od.setGuest_cnt(rs.getInt("guest_cnt"));
				od.setOrder_date(rs.getDate("order_date"));
				od.setPay_amt(rs.getInt("pay_amt"));
				od.setOrder_sign(rs.getString("order_sign"));
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
	
	
	//예약내역 삭제
	public boolean deletereser (OrderinfoVO vo) {
		boolean reser = false;
		String sql = "delete orderinfo where mem_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getMem_num());
			if(pstmt.executeUpdate() !=0) {
				reser = true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return reser;
	}
	
	
	
	
	
	
	
	
}
