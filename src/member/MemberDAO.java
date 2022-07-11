package member;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import admin.QnAVO;
import admin.hostVO;
import awesomePlace.dbConn.DBConn;
import hashtag.HashtagVO;
import host.hostvo.HostVO;

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
				if(pstmt != null) pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
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
	
	//로그인 확인   // 개인 테스트 위해 수정함
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
					vo.setmem_sign(rs.getString("mem_sign"));
					vo.setMem_host_Cnt(rs.getInt("mem_hostCnt"));
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
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return vo;
		}
	
	//https://github.com/Ryanmufasa/awesomePlace/issues/36 -- 작성자 정다영
		// 회원이 호스트 등록시 mem_hostCnt 칼럼 값 수정
		public boolean updateHostCnt(int mem_hostCnt, int mem_num) {
			boolean check = false;
			
			String sql = "update member set mem_hostCnt = ? where mem_num = ?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, mem_hostCnt);
				pstmt.setInt(2, mem_num);
				if(pstmt.executeUpdate() != 0) {
					check = true;
					System.out.println("member 테이블 mem_hostCnt 값 변경 완료 ");
				}
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("member 테이블 mem_hostCnt 값 변경 실패");
			}finally {
				try {
					if(pstmt != null) pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			return check;
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
					memlist.add(vo);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return memlist;
		}
	
	
	

	//회원1명 불러올때
	public MemberVO selectById (String id1)  {
		MemberVO vo = null;
		String sql = "select * from member where mem_id = ?";
		
		try {
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
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
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
			if(pstmt.executeUpdate() != 0) {
				check = true;  
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
	public MemberVO loginck (String mem_id1, String mem_pw2){
		
		MemberVO vo=null;
		
		//boolean check=false;
		
		String sql="select * from member where mem_id=? and mem_pw=?";
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id1);
			pstmt.setString(2, mem_pw2);
			rs=pstmt.executeQuery();
	
			if(rs.next()) { 
					System.out.println("로그인 성공");
					//check = true;
				} else {
					System.out.println("로그인 실패");
				}
		}catch(SQLException e){
			System.out.println(e);
		}finally{

			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
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
				if(rs !=  null) rs.close();
				if(pstmt != null) pstmt.close();
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
				if(pstmt != null) pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mem_pw;
	}
	
	
	//찜목록  https://github.com/Ryanmufasa/awesomePlace/issues/53 //작성자: 양준모
	public ArrayList<hostVO> jjimList(int mem_num) {
		ArrayList<hostVO> harray = new ArrayList<hostVO>();
		String sql = "SELECT * FROM host WHERE host_num IN (select host_num from JJIM where mem_num = ?)";
				
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {			
				int host_num = rs.getInt("host_num");
				String host_name = rs.getString("host_name");
				String host_addr = rs.getString("host_addr");
				String host_post_num = rs.getString("host_post_num");
				String host_tel = rs.getString("host_tel");
				String room_type = rs.getString("room_type");
				int room_cnt = rs.getInt("room_cnt");
				int guest_cnt = rs.getInt("guest_cnt");
				int weekday_amt = rs.getInt("weekday_amt");
				int weekend_amt = rs.getInt("weekend_amt");
				String host_content = rs.getString("host_content");
				Date host_date = rs.getDate("host_date");
				String sign = rs.getString("sign");
				int hmem_num = rs.getInt("mem_num");
				String mem_id = rs.getString("mem_id");
				
				hostVO ho = new hostVO(host_num, host_name, host_addr, host_post_num, host_tel, room_type, room_cnt, guest_cnt, weekday_amt, weekend_amt, host_content, host_date, sign, hmem_num, mem_id);
				
				harray.add(ho);
				} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return harray;
	}
	
	public int jjimheart(int mem_num, int host_num) { //찜목록  https://github.com/Ryanmufasa/awesomePlace/issues/53 //작성자: 양준모
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement("DELETE FROM JJIM WHERE mem_num = ? AND host_num = ?");
			pstmt.setInt(1, mem_num);
			pstmt.setInt(2, host_num);
			pstmt.executeUpdate();
			

			if(pstmt.executeUpdate() != 0) {
					result = 1;
				} else {
					result = -1;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result;
	}
	
	
	public int AskPWck(String mem_pw, String mem_id) {
		
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
				if(pstmt != null) pstmt.close();
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
				if(pstmt != null) pstmt.close();
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
	
	//마이페이지 접속시 비밀번호 재확인 https://github.com/Ryanmufasa/awesomePlace/issues/13  //작성자: 양준모
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
					e.printStackTrace();
				}finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				
			return result;
		}
	
		//로그인 //https://github.com/Ryanmufasa/awesomePlace/issues/5 작성자: 양준모
		public MemberVO selectID(String mem_id, String mem_pw) {
			
			MemberVO vo = null;
			
			try {
				pstmt = con.prepareStatement("SELECT * FROM member WHERE mem_id = ? AND mem_pw = ?");
				pstmt.setString(1, mem_id);
				pstmt.setString(2, mem_pw);
				rs = pstmt.executeQuery();

				if (rs.next()) {
						vo = new MemberVO(); 
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
		
		//고객 문의글 작성 //https://github.com/Ryanmufasa/awesomePlace/issues/40 작성자: 양준모
		public int write(QnAVO qvo) {
			//insert into QNA values(qna_seq.nextval, :1 , :2 , :3 , :4 , sysdate, :5 , :6 )
			//insert into QNA values(qna_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?)
			int check = 0;
			String sql = "insert into QNA values(qna_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?,?)";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, qvo.getMem_num());
				pstmt.setString(2, qvo.getMem_id());
				pstmt.setString(3, qvo.getQna_title());
				pstmt.setString(4, qvo.getQna_content());
				pstmt.setString(5, "Wait");
				pstmt.setString(6, "");
				pstmt.setString(7, null);
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
		public ArrayList<QnAVO> qnalist(String mem_id, int startRow) {
				ArrayList<QnAVO> qarray = new ArrayList<QnAVO>();
				String sql = "SELECT *\r\n"
						+ "  FROM (\r\n"
						+ "        SELECT ROW_NUMBER() OVER (ORDER BY qna_num DESC) NUM\r\n"
						+ "             , A.*\r\n"
						+ "          FROM QNA A\r\n"
						+ "          WHERE mem_id = ?\r\n"
						+ "        ORDER BY qna_num DESC\r\n"
						+ "        ) \r\n"
						+ " WHERE NUM BETWEEN ? AND ?+3";
						
				try {
					pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mem_id);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, startRow);
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
						
						QnAVO qvo = new QnAVO(qna_num, mem_num, qmem_id, qna_title, qna_content, qna_date, qna_sign, qna_answer);
						
						
						qarray.add(qvo);
					} 
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				return qarray;
			}
		
		
		//문의목록 게시글 수 확인 //작성자: 양준모
		public int getTotal(String mem_id) {
			int result = 0;
			String sql = "select count(*) as total from QNA where mem_id = ?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mem_id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt("total");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}		
			return result;
		}
		
		
		//비밀번호 찾기 (비밀번호 수정) //https://github.com/Ryanmufasa/awesomePlace/issues/10 작성자: 양준모
		 public boolean PWupdate(String mem_id, String mem_pw) {
			 
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
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return check;
		}
		
			//내 문의 목록에서 내문의 자세히 보기 //https://github.com/Ryanmufasa/awesomePlace/issues/49 작성자: 양준모
			public QnAVO viewqna(int qna_num) {
				
				try {
					pstmt = con.prepareStatement("select * from QNA where qna_num = ?");
					pstmt.setInt(1, qna_num);
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						QnAVO qo = new QnAVO();
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
				}finally {
					try {
						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				return null;
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
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
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
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
		}


		//https://github.com/Ryanmufasa/awesomePlace/issues/39 작성자: 이명진
		public ArrayList<QnAVO> getAllQnAList() {
			ArrayList<QnAVO> qnaList = new ArrayList<>();
			
			String sql = "SELECT * FROM qna ORDER BY qna_sign DESC";
			try {
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			
				int qna_num;
				int mem_num;
				String mem_id;
				String qna_title;
				String qna_Content;
				String qna_date;
				String qna_sign;
				String qna_answer;
				while(rs.next()) {
					qna_num = Integer.parseInt(rs.getString("qna_num"));
					mem_num = Integer.parseInt(rs.getString("mem_num"));
					mem_id = rs.getString("mem_id");
					qna_title = rs.getString("qna_title");
					qna_Content = rs.getString("qna_Content");
					String temp = rs.getString("qna_date");
					qna_sign = rs.getString("qna_sign");
					qna_answer = rs.getString("qna_answer");
					
					
					qna_date = temp.substring(0, 10);
					
					QnAVO qna = new QnAVO(qna_num,mem_num,mem_id,qna_title,qna_Content,qna_date,qna_sign,qna_answer);
					qnaList.add(qna);
				}
			
			}  catch (SQLException e) {
					
				try {
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			return qnaList;
		}
		
		
		//https://github.com/Ryanmufasa/awesomePlace/issues/39 작성자: 이명진
		public ArrayList<QnAVO> getQnAContent(int idx) {
			ArrayList<QnAVO> qnaCon= new ArrayList<>();
			String sql = "SELECT * FROM qna WHERE qna_num=?";
			try {
				
				
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				rs=pstmt.executeQuery();
				
				int qna_num;
				int mem_num;
				String mem_id;
				String qna_title;
				String qna_content;
				String qna_date;
				String qna_sign;
				String qna_answer;
				while(rs.next()) {
					qna_num = Integer.parseInt(rs.getString("qna_num"));
					mem_num = Integer.parseInt(rs.getString("mem_num"));
					mem_id = rs.getString("mem_id");
					qna_title = rs.getString("qna_title");
					qna_content = rs.getString("qna_content");
					String temp = rs.getString("qna_date");
					qna_sign = rs.getString("qna_sign");
					qna_answer = rs.getString("qna_answer");
					
					qna_date = temp.substring(0, 10);
					
					QnAVO qna = new QnAVO(qna_num,mem_num,mem_id,qna_title,qna_content,qna_date,qna_sign,qna_answer);
					qnaCon.add(qna);
				}
				}  catch (SQLException e) {
						
					try {
						if(pstmt != null) {
							pstmt.close();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				return qnaCon;
			}


		//https://github.com/Ryanmufasa/awesomePlace/issues/39 작성자: 이명진
		public boolean setQnAAnswer(int qnaNum, String answer) {
			String sql = "UPDATE qna SET qna_answer=?, qna_sign='Done' WHERE qna_num=?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, answer);
				pstmt.setInt(2, qnaNum);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}finally {
				try {
					if(pstmt != null) pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return true;
		}


		//https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
		public ArrayList<MemberVO> getAllMember() { 
			ArrayList<MemberVO> memList = new ArrayList<>();
			
			String sql = "SELECT * FROM member ORDER BY mem_sign";
			try {
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			
				int mem_num;
				String mem_name;
				String mem_id;
				String mem_sign;
				int mem_host_Cnt;
				
				while(rs.next()) {
					mem_num = Integer.parseInt(rs.getString("mem_num"));
					mem_name = rs.getString("mem_name");
					mem_id = rs.getString("mem_id");
					mem_sign = rs.getString("mem_sign");
					mem_host_Cnt = Integer.parseInt(rs.getString("mem_hostingcnt"));
					
					MemberVO mem = new MemberVO(mem_num,mem_name,mem_id,mem_sign,mem_host_Cnt);
					
					if(!mem_id.equals("admin"))
					memList.add(mem);
				}
			
			}  catch (SQLException e) {
					
				try {
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			return memList;
		}

		//https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
		public MemberVO getMemberDetail(int idx) { 
			MemberVO memInfo=null;
			String sql = "SELECT * FROM member WHERE mem_num=?";
			try {
				System.out.println("여기 오긴 하니?");
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				rs = pstmt.executeQuery();
				
				int mem_num;
				String mem_name;
				String mem_id;
				String mem_pw;
				String mem_tel;
				String mem_email;
				String mem_sign;
				int mem_host_Cnt;
				
				if(rs.next()) {
					mem_num = Integer.parseInt(rs.getString("mem_num"));
					mem_name = rs.getString("mem_name");
					mem_id = rs.getString("mem_id");
					mem_pw = rs.getString("mem_pw");
					mem_tel = rs.getString("mem_tel");
					mem_email = rs.getString("mem_email");
					mem_sign = rs.getString("mem_sign");
					mem_host_Cnt = Integer.parseInt(rs.getString("mem_hostingcnt"));
					
					memInfo = new MemberVO(mem_num,mem_name,mem_id,mem_pw,mem_tel,mem_email,mem_sign,mem_host_Cnt);
				}
			} catch (SQLException e) {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			return memInfo;
		}
		
		//https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
		public ArrayList<HostVO> getMemberHostList(int idx) { 
			ArrayList<HostVO> memHostList= new ArrayList<>();
			String sql = "SELECT * FROM host WHERE mem_num=?";
			try {
				System.out.println("여기 오긴 하니?");
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				rs = pstmt.executeQuery();
				
				int host_num;
				String host_name;
				String host_addr;
				String host_post_num;
				String host_tel;
				String room_type;
				int room_cnt;
				int guest_cnt;
				int weekday_amt;
				int weekend_amt;
				String host_content;
				String host_date;
				String sign;
				int mem_num;
				String mem_id;
				
				while(rs.next()) {
					host_num = Integer.parseInt(rs.getString("host_num"));
					host_name = rs.getString("host_name");
					host_addr = rs.getString("host_addr");
					host_post_num = rs.getString("host_post_num");
					host_tel = rs.getString("host_tel");
					room_type = rs.getString("room_type");
					room_cnt = Integer.parseInt(rs.getString("room_cnt"));
					guest_cnt = Integer.parseInt(rs.getString("guest_cnt"));
					weekday_amt = Integer.parseInt(rs.getString("weekday_amt"));
					weekend_amt = Integer.parseInt(rs.getString("weekend_amt"));
					host_content = rs.getString("host_content");
					String temp = rs.getString("host_date");
					sign = rs.getString("sign");
					mem_num = Integer.parseInt(rs.getString("mem_num"));
					mem_id = rs.getString("mem_id");
					
					host_date = temp.substring(0, 10);
					
					HostVO hostInfo = new HostVO(host_num, host_name, host_addr, host_post_num, host_tel,
							room_type, room_cnt, guest_cnt, weekday_amt, weekend_amt, host_content,
							host_date, sign, mem_num, mem_id);
					
					memHostList.add(hostInfo);
				}
			} catch (SQLException e) {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			return memHostList;
		}
		
		//https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
		public boolean HostingCheck(int idx) {
			String sql = "select count(*) from host where mem_num=?";
			String temp= null;
			int cnt=0;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				rs = pstmt.executeQuery();
				
				temp = rs.getString("count(*)");
				
			} catch (SQLException e) {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			if(temp!=null) {
				cnt = Integer.parseInt(temp);
			}
			
			if(cnt == 0) {
				return false;
			}else {
				return true;
			}
			
		}
		
		//https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
		public boolean memSwitchSign(int idx, String flag) {
			String sql = null;
			if(flag.equals("Y"))
				sql = "UPDATE member SET mem_sign='N' WHERE mem_num=?";
			else if(flag.equals("N"))
				sql = "UPDATE member SET mem_sign='Y' WHERE mem_num=?";
			System.out.println("1");
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return false;
			}
			return true;
		}
		
		//https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진
		public boolean hostSwitchSign(int idx, String flag) {
			String sql = null;
			if(flag.equals("true"))
				sql = "UPDATE host SET sign='false' WHERE host_num=?";
			else if(flag.equals("false"))
				sql = "UPDATE host SET sign='true' WHERE host_num=?";
			System.out.println("메서드 실행");
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return false;
			}
			return true;
		}


		//https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진
		public ArrayList<HostVO> getAllHosting() {
			String sql = "SELECT * FROM host ORDER BY sign";
			ArrayList<HostVO> hostList = new ArrayList<HostVO>();
			try {
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				int host_num;
				String host_name;
				String host_addr;
				String host_post_num;
				String host_tel;
				String room_type;
				int room_cnt;
				int guest_cnt;
				int weekday_amt;
				int weekend_amt;
				String host_content;
				String host_date;
				String sign;
				int mem_num;
				String mem_id;
				
				while(rs.next()) {
					host_num = Integer.parseInt(rs.getString("host_num"));
					host_name = rs.getString("host_name");
					host_addr = rs.getString("host_addr");
					host_post_num = rs.getString("host_post_num");
					host_tel = rs.getString("host_tel");
					room_type = rs.getString("room_type");
					room_cnt = Integer.parseInt(rs.getString("room_cnt"));
					guest_cnt = Integer.parseInt(rs.getString("guest_cnt"));
					weekday_amt = Integer.parseInt(rs.getString("weekday_amt"));
					weekend_amt = Integer.parseInt(rs.getString("weekend_amt"));
					host_content = rs.getString("host_content");
					String temp = rs.getString("host_date");
					sign = rs.getString("sign");
					mem_num = Integer.parseInt(rs.getString("mem_num"));
					mem_id = rs.getString("mem_id");
					
					host_date = temp.substring(0, 10);
					
					HostVO hostInfo = new HostVO(host_num, host_name, host_addr, host_post_num, host_tel,
							room_type, room_cnt, guest_cnt, weekday_amt, weekend_amt, host_content,
							host_date, sign, mem_num, mem_id);
					
					hostList.add(hostInfo);
				}
			} catch (SQLException e) {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			return hostList;
		}
		
		//https://github.com/Ryanmufasa/awesomePlace/issues/50 작성자: 이명진
		public HostVO getHostDetail(int idx) {
			String sql = "SELECT * FROM host WHERE host_num=?";
			HostVO hostDetail=null;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				rs = pstmt.executeQuery();
				
				int host_num;
				String host_name;
				String host_addr;
				String host_post_num;
				String host_tel;
				String room_type;
				int room_cnt;
				int guest_cnt;
				int weekday_amt;
				int weekend_amt;
				String host_content;
				String host_date;
				String sign;
				int mem_num;
				String mem_id;
				
				if(rs.next()) {
					host_num = Integer.parseInt(rs.getString("host_num"));
					host_name = rs.getString("host_name");
					host_addr = rs.getString("host_addr");
					host_post_num = rs.getString("host_post_num");
					host_tel = rs.getString("host_tel");
					room_type = rs.getString("room_type");
					room_cnt = Integer.parseInt(rs.getString("room_cnt"));
					guest_cnt = Integer.parseInt(rs.getString("guest_cnt"));
					weekday_amt = Integer.parseInt(rs.getString("weekday_amt"));
					weekend_amt = Integer.parseInt(rs.getString("weekend_amt"));
					host_content = rs.getString("host_content");
					String temp = rs.getString("host_date");
					sign = rs.getString("sign");
					mem_num = Integer.parseInt(rs.getString("mem_num"));
					mem_id = rs.getString("mem_id");
					
					host_date = temp.substring(0, 10);
					
					hostDetail = new HostVO(host_num, host_name, host_addr, host_post_num, host_tel,
							room_type, room_cnt, guest_cnt, weekday_amt, weekend_amt, host_content,
							host_date, sign, mem_num, mem_id);
				}
			} catch (SQLException e) {
				try {
					if(rs!=null)rs.close();
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			return hostDetail;
		}

		//https://github.com/Ryanmufasa/awesomePlace/issues/47 작성자: 이명진
		public boolean getMemberDelete(int idx) {
			String sql = "DELETE FROM member WHERE mem_num=?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				pstmt.executeUpdate();
			
			} catch (SQLException e) {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return false;
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return true;
		}
		
		//https://github.com/Ryanmufasa/awesomePlace/issues/28 작성자: 이명진
		public ArrayList<HashtagVO> getHashtag() {
			String sql = "SELECT * FROM hashtag";
			ArrayList<HashtagVO> idxList = new ArrayList<HashtagVO>();
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
			
				int tag_num;
				String tag_name;
			
			while(rs.next()) {
				tag_num = Integer.parseInt(rs.getString("tag_num"));
				tag_name = rs.getString("tag_name");

				HashtagVO idx = new HashtagVO(tag_num, tag_name);
				idxList.add(idx);
			}
			
			} catch (SQLException e) {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return idxList;
		}

		//https://github.com/Ryanmufasa/awesomePlace/issues/28 작성자: 이명진
		public ArrayList<HostVO> tagSearch(int idx) {
			
			ArrayList<String> hostNumArr = tagSearchHostList(idx);
			
			String sql = "SELECT * FROM host WHERE host_num IN (";
			for(int i=1 ; i<=hostNumArr.size() ; i++) {
				sql += "?";
				if(i<hostNumArr.size()) {
					sql += ",";
				}
			}
			sql += ") and sign='true'";
			System.out.println("sql : " + sql);
			ArrayList<HostVO> hostList = new ArrayList<HostVO>();
			try {
			
				pstmt=con.prepareStatement(sql);
				for(int i=1 ; i<=hostNumArr.size() ; i++) {
					pstmt.setString(i, hostNumArr.get(i-1));
				}
				rs=pstmt.executeQuery();
				
				int host_num;
				String host_name;
				String host_addr;
				String host_post_num;
				String host_tel;
				String room_type;
				int room_cnt;
				int guest_cnt;
				int weekday_amt;
				int weekend_amt;
				String host_content;
				String host_date;
				String sign;
				int mem_num;
				String mem_id;
				
				while(rs.next()) {
					host_num = Integer.parseInt(rs.getString("host_num"));
					host_name = rs.getString("host_name");
					host_addr = rs.getString("host_addr");
					host_post_num = rs.getString("host_post_num");
					host_tel = rs.getString("host_tel");
					room_type = rs.getString("room_type");
					room_cnt = Integer.parseInt(rs.getString("room_cnt"));
					guest_cnt = Integer.parseInt(rs.getString("guest_cnt"));
					weekday_amt = Integer.parseInt(rs.getString("weekday_amt"));
					weekend_amt = Integer.parseInt(rs.getString("weekend_amt"));
					host_content = rs.getString("host_content");
					String temp = rs.getString("host_date");
					sign = rs.getString("sign");
					mem_num = Integer.parseInt(rs.getString("mem_num"));
					mem_id = rs.getString("mem_id");
					
					host_date = temp.substring(0, 10);
					
					HostVO hostInfo = new HostVO(host_num, host_name, host_addr, host_post_num, host_tel,
							room_type, room_cnt, guest_cnt, weekday_amt, weekend_amt, host_content,
							host_date, sign, mem_num, mem_id);
					
					hostList.add(hostInfo);
				}
			} catch (SQLException e) {
				try {
					if(pstmt != null) {
						pstmt.close();
					}else if(con!=null)
						con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			return hostList;
		}

		//https://github.com/Ryanmufasa/awesomePlace/issues/28 작성자: 이명진
		private ArrayList<String> tagSearchHostList(int idx) {
			
			String sql = "SELECT * FROM hnh WHERE tag_num=?";
			String res = "";
			ArrayList<String> hostNum = new ArrayList<String>();
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, idx);
				rs=pstmt.executeQuery();
				
				String hNum=null;
				
				
				while(rs.next()) {
					hNum = rs.getString("host_num");
					System.out.println("hNum 1 : " + hNum);
					hostNum.add(hNum);
				}
			} catch (SQLException e) {
				try {
					if(pstmt != null) {
						pstmt.close();
					}else if(con!=null)
						con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return hostNum;
	
		}
		
		
		
}









