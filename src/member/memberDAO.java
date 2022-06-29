package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import admin.QnaVO;


public class memberDAO{
	
	private static memberDAO instance;
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	public static memberDAO getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null)
			instance = new memberDAO();
		return instance;
	}
	
	public memberDAO() throws ClassNotFoundException, SQLException {
		con = new memberDBConn().getConnection();
	}
	
	public void pstmtClose() throws SQLException {
		if(pstmt != null) {
			pstmt.close();
		}
	}
	
	public void getAllInfoClose() throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}

	
	//회원 목록
	public ArrayList<memberVO> getAllInfo() throws SQLException{
		ArrayList<memberVO> list = new ArrayList<memberVO>();
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
			
			memberVO mbv = new memberVO(mem_num, mem_name, mem_id, mem_pw, mem_tel, mem_email);
			
			list.add(mbv);
		}
		
		return list;
	} 
	
	
	//로그인 //https://github.com/Ryanmufasa/awesomePlace/issues/5 작성자: 양준모
	public memberVO selectID(String mem_id, String mem_pw) throws ClassNotFoundException {
		
		memberVO vo = null;
		
		try {
		con = new memberDBConn().getConnection();
			pstmt = con.prepareStatement("SELECT * FROM member WHERE mem_id = ? AND mem_pw = ?");
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pw);
			rs = pstmt.executeQuery();

			if (rs.next()) {
					vo = new memberVO(); 
					vo.setMem_id(mem_id);
					vo.setMem_pw(mem_pw);
					vo.setMem_num(rs.getInt("mem_num"));
					vo.setMem_tel(rs.getString("mem_tel"));
					vo.setMem_name(rs.getString("mem_name"));
					vo.setMem_email(rs.getString("mem_email"));
					
				} 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	//내 문의 목록에서 내문의 자세히 보기 //https://github.com/Ryanmufasa/awesomePlace/issues/49 작성자: 양준모
	public QnaVO viewqna(int qna_num) {
		
		try {
			pstmt = con.prepareStatement("select * from QNA where qna_num = ?");
			pstmt.setInt(1, qna_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				QnaVO qo = new QnaVO();
				qo.setQna_num(qna_num);
				qo.setMem_num(rs.getInt("mem_num"));
				qo.setMem_id(rs.getString("mem_id"));
				qo.setQna_title(rs.getString("qna_title"));
				qo.setQna_content(rs.getString("qna_content"));
				qo.setQna_date(rs.getDate("qna_date"));
				qo.setQna_sign(rs.getString("qna_sign"));
				qo.setQna_answer(rs.getString("qna_answer"));
				
				return qo;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//아이디 찾기 (회원정보 일치 여부) // https://github.com/Ryanmufasa/awesomePlace/issues/8  작성자: 양준모
	public int IDfound(String mem_name, String mem_id, String mem_tel, String mem_email) throws ClassNotFoundException {
		
		int result = 0 ;
		
		try {
			con = new memberDBConn().getConnection();
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
	
	
	//비밀번호 찾기 (회원정보 일치 여부) //https://github.com/Ryanmufasa/awesomePlace/issues/10  작성자: 양준모
	public int PWfound(String mem_name, String mem_id, String mem_tel, String mem_email) throws ClassNotFoundException {
	
		int result = 0 ;
		
		try {
			con = new memberDBConn().getConnection();
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
	
	//비밀번호 찾기 (비밀번호 수정) //https://github.com/Ryanmufasa/awesomePlace/issues/10 작성자: 양준모
	 public boolean PWupdate(String mem_id, String mem_pw) throws SQLException {
		 
		 	boolean check = false;
		 
		 	String sql = "update member set mem_pw = ? where mem_id = ?";
		 
		 try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_pw);
			pstmt.setString(2, mem_id);
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
	
	
	//마이페이지 접속시 비밀번호 재확인 //https://github.com/Ryanmufasa/awesomePlace/issues/13 작성자: 양준모
	public int MyPagePWck(String mem_pw, String mem_id) throws ClassNotFoundException {
		
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
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	//고객 문의글 작성 //https://github.com/Ryanmufasa/awesomePlace/issues/40 작성자: 양준모
	public int write(QnaVO qvo) {
		//insert into QNA values(qna_seq.nextval, :1 , :2 , :3 , :4 , sysdate, :5 , :6 )
		//insert into QNA values(qna_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?)
		int check = 0;
		String sql = "insert into QNA values(qna_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qvo.getMem_num());
			pstmt.setString(2, qvo.getMem_id());
			pstmt.setString(3, qvo.getQna_title());
			pstmt.setString(4, qvo.getQna_content());
			pstmt.setString(5, "Wait");
			pstmt.setString(6, "");
			if(pstmt.executeUpdate() != 0) {
				check = 1;
				return check;				
			}
				 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return check;
	}
	
	
	//문의글 목록 불러오기 //https://github.com/Ryanmufasa/awesomePlace/issues/46 작성자: 양준모 
	public ArrayList<QnaVO> qnalist(String mem_id) throws SQLException {
			ArrayList<QnaVO> qarray = new ArrayList<QnaVO>();
			String sql = "SELECT * FROM QNA WHERE mem_id = ? ORDER BY qna_num DESC";
					
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {			
					int qna_num = rs.getInt("qna_num");
					int mem_num = rs.getInt("mem_num");
					String qmem_id = rs.getString("mem_id");
					String qna_title = rs.getString("qna_title");
					String qna_content = rs.getString("qna_content");
					Date qna_date = rs.getDate("qna_date");
					String qna_sign = rs.getString("qna_sign");
					String qna_answer = rs.getString("qna_answer");
					
					QnaVO qvo = new QnaVO(qna_num, mem_num, qmem_id, qna_title, qna_content, qna_date, qna_sign, qna_answer);
					
					qarray.add(qvo);
				} 
			return qarray;
		}

		
	//회원가입
	private static DataSource ds;
	public boolean join(memberVO vo) {
		boolean check=false;
		String sql="insert into member"+"values(?,?,?,?,?)";
		try {
			con=ds.getConnection();
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
		
	
	
	
	//회원 수정
	public boolean update(String mem_pw, String mem_tel, String mem_email, int mem_num) throws SQLException {
		
		String sql ="update member set mem_pw=?, mem_tel?, mem_email?" + "where mem_num=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, mem_pw);
		pstmt.setString(2, mem_tel);
		pstmt.setString(3, mem_email);
		pstmt.setInt(4, mem_num);
		pstmt.executeUpdate();
		
		return true;
	}
	
	
	
	
	

//회원 탈퇴	
public boolean delete(String mem_id) throws SQLException {
	String sql = "delete from member where mem_id=?;";
	
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, mem_id);
	pstmt.executeUpdate();
	return true;
}
}