// https://github.com/Ryanmufasa/awesomePlace/issues/24 -- 작성자 정다영
package host.hostdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import awesomePlace.dbConn.DBConn;
import hashtag.HashtagVO;
import host.hostvo.HostVO;

public class HostDAO {
	
	private Connection con;
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
	
	private void closeAll() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// 전체 호스트 목록 가져오기 - 관리자만
	public ArrayList<HostVO> getAllHost(){
		
		ArrayList<HostVO> hostli = new ArrayList<HostVO>();
		
		String sql = "select * from host order by host_num desc";
		HostVO vo = null;
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new HostVO(); 
				vo.setHost_num(rs.getInt("host_num"));
				vo.setHost_name(rs.getString("host_name"));
				vo.setHost_addr(rs.getString("host_addr"));
				vo.setHost_post_num(rs.getString("host_post_num"));
				vo.setHost_tel(rs.getString("host_tel"));
				vo.setRoom_type(rs.getString("room_type"));
				vo.setRoom_cnt(rs.getInt("room_cnt"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setWeekday_amt(rs.getInt("weekday_amt"));
				vo.setWeekend_amt(rs.getInt("weekend_amt"));
				vo.setHost_content(rs.getString("host_content"));
				vo.setHost_date(rs.getDate("host_date"));
				vo.setSign(rs.getString("sign"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setMem_id(rs.getString("mem_id"));
				
				hostli.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
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
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new HostVO(); 
				vo.setHost_num(rs.getInt("host_num"));
				vo.setHost_name(rs.getString("host_name"));
				vo.setHost_addr(rs.getString("host_addr"));
				vo.setHost_post_num(rs.getString("host_post_num"));
				vo.setHost_tel(rs.getString("host_tel"));
				vo.setRoom_type(rs.getString("room_type"));
				vo.setRoom_cnt(rs.getInt("room_cnt"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setWeekday_amt(rs.getInt("weekday_amt"));
				vo.setWeekend_amt(rs.getInt("weekend_amt"));
				vo.setHost_content(rs.getString("host_content"));
				vo.setHost_date(rs.getDate("host_date"));
				vo.setSign(rs.getString("sign"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setMem_id(rs.getString("mem_id"));
				
				hostli.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
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
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, host_num);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new HostVO(); 
				vo.setHost_num(rs.getInt("host_num"));
				vo.setHost_name(rs.getString("host_name"));
				vo.setHost_addr(rs.getString("host_addr"));
				vo.setHost_post_num(rs.getString("host_post_num"));
				vo.setHost_tel(rs.getString("host_tel"));
				vo.setRoom_type(rs.getString("room_type"));
				vo.setRoom_cnt(rs.getInt("room_cnt"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setWeekday_amt(rs.getInt("weekday_amt"));
				vo.setWeekend_amt(rs.getInt("weekend_amt"));
				vo.setHost_content(rs.getString("host_content"));
				vo.setHost_date(rs.getDate("host_date"));
				vo.setSign(rs.getString("sign"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setMem_id(rs.getString("mem_id"));
			}
				
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return vo;
	}


	// 회원이 호스팅중인 호스트 목록 가져오기 
	public ArrayList<HostVO> getMyHostList(int mem_num){
		ArrayList<HostVO> hostli = new ArrayList<HostVO>();
		
		String sql = "select * from host where mem_num=? order by host_num desc";
		HostVO vo = null;
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, mem_num);
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new HostVO(); 
				vo.setHost_num(rs.getInt("host_num"));
				vo.setHost_name(rs.getString("host_name"));
				vo.setHost_addr(rs.getString("host_addr"));
				vo.setHost_post_num(rs.getString("host_post_num"));
				vo.setHost_tel(rs.getString("host_tel"));
				vo.setRoom_type(rs.getString("room_type"));
				vo.setRoom_cnt(rs.getInt("room_cnt"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setWeekday_amt(rs.getInt("weekday_amt"));
				vo.setWeekend_amt(rs.getInt("weekend_amt"));
				vo.setHost_content(rs.getString("host_content"));
				vo.setHost_date(rs.getDate("host_date"));
				vo.setSign(rs.getString("sign"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setMem_id(rs.getString("mem_id"));
				
				hostli.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
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
			con = new DBConn().getConnection();
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

		String sql = "insert into host values(host_seq.nextval,?,?,?,?,?,"
				+ "?,?,?,?,"
				+ "?, sysdate, 'false',?,?)";
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getHost_name());
			ps.setString(2, vo.getHost_addr());
			ps.setString(3, vo.getHost_post_num());
			ps.setString(4, vo.getHost_tel());
			ps.setString(5, vo.getRoom_type());
			
			ps.setInt(6, vo.getRoom_cnt());
			ps.setInt(7, vo.getGuest_cnt());
			ps.setInt(8, vo.getWeekday_amt());
			ps.setInt(9, vo.getWeekend_amt());
			
			ps.setString(10, vo.getHost_content());
			ps.setInt(11, vo.getMem_num());
			ps.setString(12, vo.getMem_id());

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
			con = new DBConn().getConnection();
			if(!checkIn.equals("") && checkOut.equals("") ) { // 체크인 날짜만 있으면
				// 검색어, 체크인날짜, 숙박인원 
				sql += "and guest_cnt >= ?  order by host_num desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, keyword);
				ps.setInt(2, guestCnt);
				
			}else if(!checkIn.equals("") && !checkOut.equals("")) { // 체크인, 체크아웃 둘다 있으면
				// 검색어, 체크인, 체크아웃, 숙박인원
				sql += "and guest_cnt >= ?  "
						+ "and host_num not in(select distinct oi_host_num from orderinfo "
						+ "where checkout_date  between to_date(?) and to_date(?) "
						+ "and oi_sign in ('confirm','wait')) "
						+ "order by host_num desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, keyword); // 검색어
				ps.setInt(2, guestCnt); // 숙박인원
				ps.setString(3, checkIn); // 체크인일자
				ps.setString(4, checkOut); // 체크아웃일자
				
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
				vo.setHost_name(rs.getString("host_name"));
				vo.setHost_addr(rs.getString("host_addr"));
				vo.setHost_post_num(rs.getString("host_post_num"));
				vo.setHost_tel(rs.getString("host_tel"));
				vo.setRoom_type(rs.getString("room_type"));
				vo.setRoom_cnt(rs.getInt("room_cnt"));
				vo.setGuest_cnt(rs.getInt("guest_cnt"));
				vo.setWeekday_amt(rs.getInt("weekday_amt"));
				vo.setWeekend_amt(rs.getInt("weekend_amt"));
				vo.setHost_content(rs.getString("host_content"));
				vo.setHost_date(rs.getDate("host_date"));
				vo.setSign(rs.getString("sign"));
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setMem_id(rs.getString("mem_id"));
				
				hostli.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
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
				+ "host_tel=?, room_type=?, room_cnt=? "
				+ "guest_cnt=?, weekday_amt=?, weekend_amt=?, "
				+ "host_content=? where host_num=?";
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getHost_name());
			ps.setString(2, vo.getHost_addr());
			ps.setString(3, vo.getHost_post_num());
			
			ps.setString(4, vo.getHost_tel());
			ps.setString(5, vo.getRoom_type());
			ps.setInt(6, vo.getRoom_cnt());
			
			ps.setInt(7, vo.getGuest_cnt());
			ps.setInt(8, vo.getWeekday_amt());
			ps.setInt(9, vo.getWeekend_amt());
			
			ps.setString(10, vo.getHost_content());
			ps.setInt(11, vo.getHost_num());
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
	
	// 호스트 기본 정보 수정시
	public int updateinfo1(HostVO vo) {
		int result = 0;
		String sql = "update host set host_name=?, host_tel=?, host_content=? "
				+ "where host_num=?";
		try{
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getHost_name());
			ps.setString(2, vo.getHost_tel());
			ps.setString(3, vo.getHost_content());
			ps.setInt(4, vo.getHost_num());
			if(ps.executeUpdate() != 0) {
				result = 1;
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return result;
	}
	
	// 호스트 종류 변경 시
	public int updateinfo2(HostVO vo) {
		int result = 0;
		String sql = "update host set room_type=?, room_cnt=?, guest_cnt=? "
				+ "where host_num=?";
		try{
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getRoom_type());
			ps.setInt(2, vo.getRoom_cnt());
			ps.setInt(3, vo.getGuest_cnt());
			ps.setInt(4, vo.getHost_num());
			if(ps.executeUpdate() != 0) {
				result = 1;
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return result;
	}
	
	// 호스트 가격정보만 수정시 
	public int updateAmt(HostVO vo) {
		int result = 0;
		
		String sql ="update host set weekday_amt=?, weekend_amt=? "
				+ "where host_num=?";
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getWeekday_amt());
			ps.setInt(2, vo.getWeekend_amt());
			ps.setInt(3, vo.getHost_num());
			if(ps.executeUpdate() != 0) {
				result = 1;
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

		return result;
	}
	
	// 호스트 등록 삭제 
	// 호스트에 해시태그가 적용된게 있다면 hnh 테이블에서 host_num 으로 해당 DB 먼저 삭제
	// 그 다음에 host 테이블에서 삭제 해야합니다.
	// hnh 테이블에서 fk 에 대한 제약조건(delete rule) 없음. 
	public boolean deleteHost(HostVO vo) {
		boolean check=false;
		
		String sql ="delete host where host_num=?";
		
		try {
			con = new DBConn().getConnection();
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
	
	// 회원이 호스팅 중인 호스트 중지 
	public boolean stopHost(HostVO vo) {
		boolean check = false;
		
		String sql = "update host set sign='false' where host_num=?";
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getHost_num());
			if(ps.executeUpdate()!=0) {
				check = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("호스트 중지");
			
		}finally {
			closeAll();
		}
		
		return check;
	}

	
}
