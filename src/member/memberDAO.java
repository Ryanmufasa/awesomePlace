package member;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

public class memberDAO{
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
	
	
	
	
	
	
	
	
	
	