//https://github.com/Ryanmufasa/awesomePlace/issues/16 = 작성자 고유주
package member;

import java.sql.*;
import java.sql.Date;
import java.util.*;



import awesomePlace.dbConn.DBConn;
import member.MemberVO;

public class MemberDAO{
	Connection con = new DBConn().getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private static MemberDAO instance;

	public static MemberDAO getInstance() {

		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}



	//회원 목록
	public List<MemberVO> getMemList(){
			List<MemberVO> memlist = new ArrayList<>();
	
			try {
				String sql="select * from member";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					MemberVO vo=new MemberVO();
					vo.setMem_name(rs.getString("mem_name"));
					vo.setMem_id(rs.getString("mem_id"));
					vo.setMem_pw(rs.getString("mem_pw"));
					vo.setMem_tel(rs.getString("mem_tel"));
					vo.setMem_email(rs.getString("mem_email"));
					vo.setMem_hostcnt(rs.getString("mem_hostcnt"));
					vo.setMem_sign(rs.getString("mem_sign"));
					memlist.add(vo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				if(con!=null) {
					try {
						con.close();
						}catch(SQLException e) {						
					}
				}
			}
			return memlist;
		}
	
	
	

	//회원 id로 불러올때
	public MemberVO getMember (String memid) {
		MemberVO mb=new MemberVO();
		String sql = "select * from member where mem_id = ?";
try {
	

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memid);
		rs = pstmt.executeQuery();


		if(rs.next()) {
			
			mb.setMem_name(rs.getString("mem_name"));
			mb.setMem_id(rs.getString("mem_id"));
			mb.setMem_pw(rs.getString("mem_pw"));
			mb.setMem_tel(rs.getString("mem_tel"));
			mb.setMem_email(rs.getString("mem_email"));
			
		}
		}catch(SQLException e){
			System.out.println(e);
		}finally{

			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mb;
	}


	
	
	

	
	
	

	//회원가입
	//private static DataSource ds;
	public boolean join(MemberVO vo) {
		boolean check=false;
		String sql="insert into member "+" values(seq_member.nextval,?,?,?,?,?,'Y',0)";
		try {
			//			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getMem_pw());
			pstmt.setString(4, vo.getMem_tel());
			pstmt.setString(5, vo.getMem_email());
			pstmt.setString(6, vo.getMem_sign());
			pstmt.setString(6, vo.getMem_hostcnt());
			if(pstmt.executeUpdate() != 0) {
				check = true;  
				char mem_sign = 'Y';
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}



	//로그인 확인
public MemberVO loginck (MemberVO vo1) {
		
		MemberVO vo = null;
		String sql="select * from member where mem_id=? and mem_pw=?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo1.getMem_id()); 
			pstmt.setString(2, vo1.getMem_pw());
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				vo = new MemberVO();
				vo.setMem_num(rs.getInt("mem_num"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_pw(rs.getString("mem_pw"));
				vo.setMem_tel(rs.getString("mem_tel"));
				vo.setMem_email(rs.getString("mem_email"));
				vo.setMem_hostcnt(rs.getString("mem_hostcnt"));
				vo.setMem_sign(rs.getString("mem_sign"));
				
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패"); // 다를 경우 실패 리턴
			}
		}catch(SQLException e){
			e.printStackTrace();
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



	//아이디 찾기
	public String id_search(String mem_name, String mem_tel, String mem_email){ 
		String mem_id=null; //찾을아이디
		String sql="select mem_id from member where mem_name=? and mem_tel=? and mem_email=?";

		try{
			pstmt=con.prepareStatement(sql); 
			pstmt.setString(1, mem_name); 
			pstmt.setString(2, mem_tel); 
			pstmt.setString(3, mem_email); 


			rs=pstmt.executeQuery(); 
			while(rs.next()){
				mem_id=rs.getString("mem_id"); 
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mem_id;
	}



	//비밀번호 찾기
	public String pw_search(String mem_name, String mem_id, String mem_tel, String mem_email){ 
		String mem_pw=null; 
		String sql="select mem_pw from member where mem_name=? and mem_id=? and mem_tel=? and mem_email=?";

		try{
			pstmt=con.prepareStatement(sql); 
			pstmt.setString(1, mem_name);
			pstmt.setString(2, mem_id);
			pstmt.setString(3, mem_tel); 
			pstmt.setString(4, mem_email); 


			rs=pstmt.executeQuery(); 
			while(rs.next()){
				mem_pw=rs.getString("mem_pw"); 
			}
			System.out.println(mem_pw);

		}catch(Exception e){
			System.out.println(e);
		}finally{
			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mem_pw;
	}



	//회원 수정
	public int update(MemberVO mb) {
		int result=0;
		String sql ="update member set mem_pw=?, mem_tel=?, mem_email=? where mem_id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mb.getMem_pw());
			pstmt.setString(2, mb.getMem_tel());
			pstmt.setString(3, mb.getMem_email());
			pstmt.setString(4, mb.getMem_id());
			pstmt.executeUpdate();
			
			if(pstmt.executeUpdate() > 0) {
				result = 1;
			}else{
				result = 0;
			}
			
			
		}catch(SQLException e){

		}finally{

			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}




	//회원 탈퇴	
	public boolean delete(MemberVO vo) {
		boolean check=false;
		String sql = "delete from member where mem_id=?;";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_id());
			
			if(pstmt.executeUpdate() != 0) {
				check = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println(e);
		}finally{

			try {
				if(rs != null) rs.close();
				if(con != null) con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	
//  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
	//이메일 중복체크
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

//  https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영 
	// 아이디 중복체크
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
	
	//마이페이지 접속시 비밀번호 재확인 
		public int MyPagePWck(String mem_pw, String mem_id) {
			
			int result = 0 ;
			
				try {
					pstmt = con.prepareStatement("SELECT mem_pw, mem_id FROM member WHERE mem_id = ?");
				pstmt.setString(1, mem_id);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					
					if (mem_pw.equals(rs.getString("mem_pw"))) {
						result = 1;
						
					} else
						result = -1;
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return result;
		}
	
	//로그인
		public int selectID(String mem_id, String mem_pw) {
			
			int result = 0 ;
			
			try {
				pstmt = con.prepareStatement("SELECT mem_id, mem_pw FROM member WHERE mem_id = ? AND mem_pw = ?");
				pstmt.setString(1, mem_id);
				pstmt.setString(2, mem_pw);
				rs = pstmt.executeQuery();

				if (rs.next()) {
						result = 1; 
						return result;
						 
					} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		//비밀번호 찾기 (회원정보 일치 여부) 
		public int PWfound(String mem_name, String mem_id, String mem_tel, String mem_email) {
		
			int result = 0 ;
			
			try {
				pstmt = con.prepareStatement("SELECT mem_name, mem_id, mem_tel, mem_email FROM member "
						+ "WHERE mem_name = ? AND mem_id = ? AND mem_tel = ? AND mem_email = ?");
				pstmt.setString(1, mem_name);
				pstmt.setString(2, mem_id);
				pstmt.setString(3, mem_tel);
				pstmt.setString(4, mem_email);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {				
						result = 1;
						return result;
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		//아이디 찾기 (회원정보 일치 여부) 작성자:양준모
		public int IDfound(String mem_name, String mem_id, String mem_tel, String mem_email) {
			
			int result = 0 ;
			
			try {
				pstmt = con.prepareStatement("SELECT mem_name, mem_id, mem_tel, mem_email FROM member "
						+ "WHERE mem_name = ?  AND mem_tel = ? AND mem_email = ?");
				pstmt.setString(1, mem_name);
				pstmt.setString(2, mem_tel);
				pstmt.setString(3, mem_email);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {				
						result = 1;
						return result;
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}



	
}









