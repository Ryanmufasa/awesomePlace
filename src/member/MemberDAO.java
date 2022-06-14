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
	public ArrayList<MemberVO> getAllInfo() throws SQLException{
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from member";

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while(rs.next()) {
			int mem_num = rs.getInt("mem_num");
			String mem_name = rs.getString("mem_name");
			String mem_id = rs.getString("mem_id");
			String mem_pw = rs.getString("mem_pw");
			String mem_tel = rs.getString("mem_tel");
			String mem_email = rs.getString("mem_email");

			MemberVO mbv = new MemberVO(mem_num, mem_name, mem_id, mem_pw, mem_tel, mem_email);

			list.add(mbv);
		}

		return list;
	} 



	//회원1명 불러올때
	public MemberVO selectById (String id1) throws SQLException {
		MemberVO vo = null;
		String sql = "select * from member where mem_id = ?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id1);
		rs = pstmt.executeQuery();


		if(rs.next()) {
			int mem_num=rs.getInt(1);
			String mem_name = rs.getString(2);
			String mem_id = rs.getString(3);
			String mem_pw = rs.getString(4);
			String mem_tel = rs.getString(5);
			String mem_email = rs.getString(6);
			vo = new MemberVO(mem_num, mem_name, mem_id, mem_pw, mem_tel, mem_email);
		}else{
			vo = null;}		
		return vo;
	}



	//회원가입
	//private static DataSource ds;
	public boolean join(MemberVO vo) {
		boolean check=false;
		String sql="insert into member "+" values(seq_member.nextval(),?,?,?,?,?)";
		try {
			//			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getMem_pw());
			pstmt.setString(4, vo.getMem_tel());
			pstmt.setString(5, vo.getMem_email());
			if(pstmt.executeUpdate() != 0) {
				check = true;  
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
	public boolean loginck (String mem_id1, String mem_pw2) throws SQLException{
		boolean check=false;
		String sql="select * from member where mem_id=? and mem_pw=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, mem_id1); 
		pstmt.setString(2, mem_pw2);

		try{
			if(rs.next()) { 
				if(rs.getString("mem_pw").equals(mem_pw2)) {  // 조회된 mem_pw 컬럼의 값이 mem_pw2 변수내의 값과 일치 할 경우 로그인 성공 리턴
					System.out.println("로그인 성공");
					check = true;
				} else {
					System.out.println("로그인 실패"); // 다를 경우 실패 리턴
					check = false;
				}
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
		return check;
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
	public boolean update(String mem_pw, String mem_tel, String mem_email, int mem_num) throws SQLException {
		boolean check=false;
		String sql ="update member set mem_pw=?, mem_tel?, mem_email?" + " where mem_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_pw);
			pstmt.setString(2, mem_tel);
			pstmt.setString(3, mem_email);
			pstmt.setInt(4, mem_num);
			pstmt.executeUpdate();

			if(pstmt.executeUpdate() != 0) {
				check = true;
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
		return check;
	}




	//회원 탈퇴	
	public boolean delete(String mem_id) throws SQLException {
		boolean check=false;
		String sql = "delete from member where mem_id=?;";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.executeUpdate();

			if(pstmt.executeUpdate() != 0) {
				check = true;
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
		return check;
	}


}









