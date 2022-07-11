//https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영 
package hashtag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import awesomePlace.dbConn.DBConn;
import host.hostvo.HostVO;

public class HashtagDAO {
	
	private Connection con = new DBConn().getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static HashtagDAO instance;
	
	public static HashtagDAO getInstance() {
		if(instance == null) {
			instance = new HashtagDAO();
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
	
	// 전체목록 가져오기
	public ArrayList<HashtagVO> getAllTags(){
		
		ArrayList<HashtagVO> tagli = new ArrayList<HashtagVO>();
		
		String sql = "select * from hashtag order by tag_num";
		
		HashtagVO htvo = null;
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				htvo = new HashtagVO();
				htvo.setTag_num(rs.getInt("tag_num"));
				htvo.setTag_name(rs.getString("tag_name"));
				
				tagli.add(htvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		if(tagli.isEmpty()) {
			tagli = null;
			System.out.println("불러올 전체 해시태그 목록 없음 ");
		}else {
			tagli.trimToSize();
		}
		
		return tagli;
	}
	
	
	
	// 태그 추가하기
	public int insertTag(String tag_name) {
		int result = 0;
		String sql = "insert into hashtag values(hashtag_seq.nextVal, ?)";
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, tag_name);
			if(ps.executeUpdate() != 0 ) {
				result = 1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return result;
	}
	
	
	// 해시태그로 호스트 번호 가져오기
	public ArrayList<Integer> getHost(String tag_name){
		ArrayList<Integer> hostNumList = new ArrayList<Integer>();
		
		String sql = "select n.host_num from hnh n, hashtag t "
				+ "where n.tag_num = t.tag_num and t.tag_name=?";
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, tag_name);
			rs = ps.executeQuery();
			while(rs.next()){
				int host_num = rs.getInt("host_num");
				
				hostNumList.add(host_num);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		if(hostNumList.isEmpty()) {
			hostNumList = null;
			System.out.println("불러올 전체 해시태그 목록 없음 ");
		}else {
			hostNumList.trimToSize();
		}
		
		return hostNumList;
	}

	// 해시태그로 호스트 정보 가져오기
	public ArrayList<HostVO> getHostList(String tag_name){
		ArrayList<HostVO> hostli = new ArrayList<HostVO>();
		
		String sql = "select * from host h, hnh n, hastag t "
				+ "where n.tag_num = t.tag_num and n.host_num = h.host_num "
				+ "and t.tag_name=?";
		
		HostVO vo = null;
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, tag_name);
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
			System.out.println("등록된 호스트 정보가 없음.");
		}else {
			hostli.trimToSize();
		}
		
		
		return hostli;
		
	}
	
	// 호스트 해시태그 키워드 가져오기
	public ArrayList<HashtagVO> selectTag(int host_num){
		ArrayList<HashtagVO> taglist = new ArrayList<HashtagVO>();
		
		HashtagVO htvo = null;
		
		String sql ="select distinct t.tag_name from host h, hnh n, hashtag t "
				+ "where h.host_num = n.host_num "
				+ "and n.tag_num = t.tag_num "
				+ "and h.host_num = ?";
		
		try {
			con = new DBConn().getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, host_num);
			rs = ps.executeQuery();
			while(rs.next()) {
				htvo = new HashtagVO();
				htvo.setTag_name(rs.getString("tag_name"));
				taglist.add(htvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		
		if(taglist.isEmpty()) {
			taglist = null;
			System.out.println("불러올 해시태그 목록 없음.");
		}else {
			taglist.trimToSize();
		}
		return taglist;
		
	}

	
	// 호스트에 해시태그 키워드 정보 추가하기
	public int addTags(int tag_num, int host_num) {
		int result = 0;
		String sql = "insert into hnh values(?,?)";
		
		try {
			con = new DBConn().getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1,tag_num);
			ps.setInt(2, host_num);
			if(ps.executeUpdate() != 0 ) {
				result = 1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll();
		}
		
		return result;
	}
	
	
	// 호스트의 해시태그 키워드 정보 삭제하기
	public int delTags(int tag_num, int host_num) {
		
		int result = 0;
		String sql = "delete from hnh where tag_num=? and host_num=?";
		
		try {
			con = new DBConn().getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1,tag_num);
			ps.setInt(2, host_num);
			if(ps.executeUpdate() != 0 ) {
				result = 1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
}
