// https://github.com/Ryanmufasa/awesomePlace/issues/24 -- 작성자 정다영
package host.hostdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import awesomePlace.dbConn.DBConn;

import host.hostvo.HostVO;

public class HostDAO {
	
	private Connection con = new DBConn().getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static HostDAO instance;
	
	public HostDAO() {}
	
	public static HostDAO getInstance() {
		if(instance == null) {
			instance = new HostDAO();
		}
		return instance;
	}
	
	
	// 전체 호스트 목록 가져오기 - 관리자만
	public ArrayList<HostVO> getAllHost(){
		
		ArrayList<HostVO> hostli = new ArrayList<HostVO>();
		
		String sql = "select * from host order by host_num desc";
		HostVO vo = null;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new HostVO(); 
				vo.setHost_num(rs.getInt("host_num"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setHost_name(rs.getString("host_name"));
				vo.setHost_addr(rs.getString("host_addr"));
				vo.setHost_post_num(rs.getString("host_post_num"));
				vo.setHost_tel(rs.getString("host_tel"));
				vo.setRoom_type(rs.getString("room_type"));
				vo.setRoom_name(rs.getString("room_name"));
				vo.setRoom_cnt(rs.getInt("room_cnt"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setWeekday_amt(rs.getInt("weekday_amt"));
				vo.setWeekend_amt(rs.getInt("weekend_amt"));
				vo.setHost_content(rs.getString("host_content"));
				vo.setHost_date(rs.getDate("host_date"));
				vo.setSign(rs.getString("sign"));
				
				hostli.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(hostli.isEmpty()) {
			hostli = null;
			System.out.println("불러올 호스트 목록 없음.");
		}else {
			hostli.trimToSize();
		}
		
		return hostli;
	}
	

	// 전체 호스트 목록 가져오기 - sign컬럼 값이 true인 데이터만 (검색 화면)
	public ArrayList<HostVO> AllTrueHost(){
		
		ArrayList<HostVO> hostli = new ArrayList<HostVO>();
		
		String sql = "select * from host where sign='true'";
		HostVO vo = null;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new HostVO(); 
				vo.setHost_num(rs.getInt("host_num"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setHost_name(rs.getString("host_name"));
				vo.setHost_addr(rs.getString("host_addr"));
				vo.setHost_post_num(rs.getString("host_post_num"));
				vo.setHost_tel(rs.getString("host_tel"));
				vo.setRoom_type(rs.getString("room_type"));
				vo.setRoom_name(rs.getString("room_name"));
				vo.setRoom_cnt(rs.getInt("room_cnt"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setWeekday_amt(rs.getInt("weekday_amt"));
				vo.setWeekend_amt(rs.getInt("weekend_amt"));
				vo.setHost_content(rs.getString("host_content"));
				vo.setHost_date(rs.getDate("host_date"));
				vo.setSign(rs.getString("sign"));
				
				hostli.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(hostli.isEmpty()) {
			hostli = null;
			System.out.println("불러올 True 호스트 목록 없음.");
		}else {
			hostli.trimToSize();
		}
		
		return hostli;
		
	}
	
	// DB 에 있는 하나의 호스트 정보 가져오기 (PK)
	public HostVO selectHost(int host_num) {  // HostVO vo 도 가능.
		
		String sql = "select * from host where host_num=?";
		HostVO vo = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, host_num);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new HostVO(); 
				vo.setHost_num(rs.getInt("host_num"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setHost_name(rs.getString("host_name"));
				vo.setHost_addr(rs.getString("host_addr"));
				vo.setHost_post_num(rs.getString("host_post_num"));
				vo.setHost_tel(rs.getString("host_tel"));
				vo.setRoom_type(rs.getString("room_type"));
				vo.setRoom_name(rs.getString("room_name"));
				vo.setRoom_cnt(rs.getInt("room_cnt"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setWeekday_amt(rs.getInt("weekday_amt"));
				vo.setWeekend_amt(rs.getInt("weekend_amt"));
				vo.setHost_content(rs.getString("host_content"));
				vo.setHost_date(rs.getDate("host_date"));
				vo.setSign(rs.getString("sign"));
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}


	// 회원이 호스팅중인 호스트 목록 가져오기 
	public ArrayList<HostVO> getMyHostList(int mem_num){
		ArrayList<HostVO> hostli = new ArrayList<HostVO>();
		
		String sql = "select * from host where mem_num=? order by host_num desc";
		HostVO vo = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mem_num);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new HostVO(); 
				vo.setHost_num(rs.getInt("host_num"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setHost_name(rs.getString("host_name"));
				vo.setHost_addr(rs.getString("host_addr"));
				vo.setHost_post_num(rs.getString("host_post_num"));
				vo.setHost_tel(rs.getString("host_tel"));
				vo.setRoom_type(rs.getString("room_type"));
				vo.setRoom_name(rs.getString("room_name"));
				vo.setRoom_cnt(rs.getInt("room_cnt"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setWeekday_amt(rs.getInt("weekday_amt"));
				vo.setWeekend_amt(rs.getInt("weekend_amt"));
				vo.setHost_content(rs.getString("host_content"));
				vo.setHost_date(rs.getDate("host_date"));
				vo.setSign(rs.getString("sign"));
				
				hostli.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(hostli.isEmpty()) {
			hostli = null;
			System.out.println("등록된 호스트 정보가 없음.");
		}else {
			hostli.trimToSize();
		}
		
		return hostli;
	}
	
	// 회원이 호스트회원인지 확인...
	
	public boolean checkHost(int mem_num) {
		boolean check =false;
		String sql = "select * from host where mem_num=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mem_num);
			rs = ps.executeQuery();
			if(rs.next()) {
				check = true;
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
		return check;
	}
	
	// 호스트 등록
	public boolean insertHost(HostVO vo) {
		
		boolean check = false;

		String sql = "insert into host values(host_seq.nextval,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,sysdate, 'false')";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getMem_num());
			ps.setString(2, vo.getHost_name());
			ps.setString(3, vo.getHost_addr());
			ps.setString(4, vo.getHost_post_num());
			
			ps.setString(5, vo.getHost_tel());
			ps.setString(6, vo.getRoom_type());
			ps.setString(7, vo.getRoom_name());
			
			ps.setInt(8, vo.getRoom_cnt());
			ps.setInt(9, vo.getGuest_cnt());
			ps.setInt(10, vo.getWeekday_amt());
			ps.setInt(11, vo.getWeekend_amt());
			
			ps.setString(12, vo.getHost_content());

			if(ps.executeUpdate() != 0) {
				check = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("호스트 DB 등록 실패");
		}finally {
			try {
				if(ps != null) ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return check; 
	}

	
	// 검색어에 따른 호스트 목록 가져오기
	public ArrayList<HostVO> searchHost(String keyword, String checkIn, String checkOut, int guestCnt){
		
		ArrayList<HostVO> hostli = new ArrayList<HostVO>();
		HostVO vo = null;
		
		String sql = "select * from host where sign='true' and host_addr like ? ";
		
		try { 
			
			if(!checkIn.equals("") && checkOut.equals("") ) { // 체크인 날짜만 있으면
				// 검색어, 체크인날짜, 숙박인원 
				sql += "and guest_cnt >= ?  order by host_num desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, keyword);
				ps.setInt(2, guestCnt);
				
			}else if(!checkIn.equals("") && !checkOut.equals("")) { // 체크인, 체크아웃 둘다 있으면
				// 검색어, 체크인, 체크아웃, 숙박인원
				sql += "and guest_cnt >= ?  order by host_num desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, keyword);
				ps.setInt(2, guestCnt);
				
			}else { // 검색어가 없는 경우에도 '%%' 으로 실행됨. 
				// 체크인, 체크아웃 없고, guestCnt 조건만 판단
				sql += "and guest_cnt >= ? order by host_num desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, keyword);
				ps.setInt(2, guestCnt);
			}
			
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new HostVO(); 
				vo.setHost_num(rs.getInt("host_num"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setHost_name(rs.getString("host_name"));
				vo.setHost_addr(rs.getString("host_addr"));
				vo.setHost_post_num(rs.getString("host_post_num"));
				vo.setHost_tel(rs.getString("host_tel"));
				vo.setRoom_type(rs.getString("room_type"));
				vo.setRoom_name(rs.getString("room_name"));
				vo.setRoom_cnt(rs.getInt("room_cnt"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setWeekday_amt(rs.getInt("weekday_amt"));
				vo.setWeekend_amt(rs.getInt("weekend_amt"));
				vo.setHost_content(rs.getString("host_content"));
				vo.setHost_date(rs.getDate("host_date"));
				vo.setSign(rs.getString("sign"));
				
				hostli.add(vo);
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
		
		if(hostli.isEmpty()) {
			hostli = null;
			System.out.println("해당 조건에 맞는 호스트 또는 등록된 호스트 정보가 없음");
		}else {
			hostli.trimToSize();
		}
		
		return hostli;
		
	}	
	
	
	
	
	
	// 호스트 정보 수정 (전체 정보 수정시. 호스트 등록일자는 수정 불가)
	public boolean updateHost(HostVO vo) {
		boolean check = false;
		
		String sql = "update host set "
				+ "host_name=?, host_addr=?, host_post_num=?, "
				+ "host_tel=?, room_type=?, room_name=?, room_cnt=? "
				+ "guest_cnt=?, weekday_amt=?, weekend_amt=?, "
				+ "host_content=? where host_num=?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getHost_name());
			ps.setString(2, vo.getHost_addr());
			ps.setString(3, vo.getHost_post_num());
			
			ps.setString(4, vo.getHost_tel());
			ps.setString(5, vo.getRoom_type());
			ps.setString(6, vo.getRoom_name());
			ps.setInt(7, vo.getRoom_cnt());
			
			ps.setInt(8, vo.getGuest_cnt());
			ps.setInt(9, vo.getWeekday_amt());
			ps.setInt(10, vo.getWeekend_amt());
			
			ps.setString(11, vo.getHost_content());
			ps.setInt(12, vo.getHost_num());	
			if(ps.executeUpdate() != 0) {
				check = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("정보 수정 실패");
		}finally {
			try {
				if(ps != null) ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return check;
	}
	
	
	// 호스트 가격정보만 수정시 
	public boolean updateAmt(HostVO vo) {
		boolean check=false;
		
		String sql ="update host set weekday_amt=?, weekend_amt=? "
				+ "where host_num=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getWeekday_amt());
			ps.setInt(2, vo.getWeekend_amt());
			ps.setInt(3, vo.getHost_num());
			if(ps.executeUpdate() != 0) {
				check = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("가격 수정 실패");
		}finally {
			try {
				if(ps != null) ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return check;
	}
	
	// 호스트 등록 삭제 
	// 호스트에 해시태그가 적용된게 있다면 hnh 테이블에서 host_num 으로 해당 DB 먼저 삭제
	// 그 다음에 host 테이블에서 삭제 해야합니다.
	// hnh 테이블에서 fk 에 대한 제약조건(delete rule) 없음. 
	public boolean deleteHost(HostVO vo) {
		boolean check=false;
		
		String sql ="delete host where host_num=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getHost_num());
			if(ps.executeUpdate()!=0) {
				check=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("호스트 삭제 실패");
			System.out.println("hnh 테이블 데이터를 먼저 삭제 했는지 확인");
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
