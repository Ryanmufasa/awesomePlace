package member;

import java.sql.*;
import java.util.*;

import awesomePlace.dbConn.DBConn;


public class MemberDAO{
	Connection con = new DBConn().getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public MemberDAO() {
	}
	
	private static MemberDAO instance;
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
//	//회원 목록
//	public ArrayList<MemberVO> getAllInfo() {
//		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
//		String sql = "select * from member";
//		try {
//		pstmt = con.prepareStatement(sql);
//		rs = pstmt.executeQuery();
//
//		while(rs.next()) {
//			int mem_num = rs.getInt("mem_num");
//			String mem_name = rs.getString("mem_name");
//			String mem_id = rs.getString("mem_id");
//			String mem_pw = rs.getString("mem_pw");
//			String mem_tel = rs.getString("mem_tel");
//			String mem_email = rs.getString("mem_email");
//			
//			MemberVO mbv = new MemberVO(mem_num, mem_name, mem_id, mem_pw, mem_tel, mem_email);
//			
//			list.add(mbv);
//		}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs != null) rs.close();
//				if(pstmt != null) pstmt.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if(list.isEmpty()) {
//			list = null;
//		}else {
//			list.trimToSize();
//		}
//		
//		return list;
//	} 
	
	
	//회원가입
	public boolean join(MemberVO vo) {
		
		boolean check=false;
		String sql="insert into member values(seq_member.nextval,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getMem_pw());
			pstmt.setString(4, vo.getMem_tel());
			pstmt.setString(5, vo.getMem_email());
			if(pstmt.executeUpdate() != 0) {
				check = true;  
				System.out.println("회원가입 성공");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	//로그인 확인
	public MemberVO loginck (String mem_id1, String mem_pw2) {
		
		MemberVO vo = null;
		String sql="select * from member where mem_id=? and mem_pw=?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id1); 
			pstmt.setString(2, mem_pw2);
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				vo = new MemberVO();
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_pw(rs.getString("mem_pw"));
				vo.setMem_tel(rs.getString("mem_tel"));
				vo.setMem_email(rs.getString("mem_email"));
				System.out.println("로그인 성공");
			} 
		}catch(SQLException e){
			System.out.println("로그인 실패"); // 다를 경우 실패 리턴
			System.out.println(e);
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				//if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
//	
//	// 회원 1명 불러올때
//	public MemberVO selectById (String id1) {
//		MemberVO vo = null;
//		String sql = "select * from member where mem_id = ?";
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, id1);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				int mem_num=rs.getInt(1);
//				String mem_name = rs.getString(2);
//				String mem_id = rs.getString(3);
//				String mem_pw = rs.getString(4);
//				String mem_tel = rs.getString(5);
//				String mem_email = rs.getString(6);
//				vo = new MemberVO(mem_num, mem_name, mem_id, mem_pw, mem_tel, mem_email);
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(rs != null) rs.close();
//				if(pstmt != null) pstmt.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//			
//		return vo;
//	}
//	
	
	
//  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
	public int searchId(String id) {
		int cnt = 0;
		String sql = "select count(*) from member where mem_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1); // 0 이면 없음, 1 이상이면 중복 
				return cnt;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

//  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
	public int searchEmail(String email) {
		int cnt = 0;
		
		String sql = "select count(*) from member where mem_email=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1); // 0 이면 없음, 1 이상이면 중복 
				return cnt;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	
//	//회원 수정
//	public boolean update(String mem_pw, String mem_tel, String mem_email, int mem_num) throws SQLException {
//		
//		String sql ="update member set mem_pw=?, mem_tel?, mem_email?" + " where mem_num=?";
//		
//		pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, mem_pw);
//		pstmt.setString(2, mem_tel);
//		pstmt.setString(3, mem_email);
//		pstmt.setInt(4, mem_num);
//		pstmt.executeUpdate();
//		
//		return true;
//	}
//	
//	
//
//	//회원 탈퇴	
//	public boolean delete(String mem_id) throws SQLException {
//		String sql = "delete from member where mem_id=?;";
//		
//		pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, mem_id);
//		pstmt.executeUpdate();
//		return true;
//	}
}
	
	
	
	
	
	
	
	
	
	