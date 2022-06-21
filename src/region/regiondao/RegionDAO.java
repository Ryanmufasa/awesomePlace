// https://github.com/Ryanmufasa/awesomePlace/issues/35  -- 작성자 정다영 
package region.regiondao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import awesomePlace.dbConn.DBConn;
import region.regionvo.RegionVO;

public class RegionDAO {
	
	private Connection con = new DBConn().getConnection();
	private PreparedStatement ps;
	private ResultSet rs;
	
	private static RegionDAO instance;
	
	public RegionDAO() {}
	
	public static RegionDAO getInstance() {
		if(instance == null) {
			instance = new RegionDAO();
		}
		return instance;
	}
	
	// DB에서 sido (특별시, 광역시, 특별자치, 도) 내역 불러오기 - ReginVO 클래스 객체X 문자열로
	public ArrayList<String> allSido(){
		
		String sql = "select distinct sido from region order by sido"; // 가나다순 
		
		ArrayList<String> sidoList = new ArrayList<String>();
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				sidoList.add(rs.getString("sido"));
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
		return sidoList;
	}
	
	// DB에서 sido 값에 따른 gungu (시 전체, 구, 군 ) 내역 불러오기
	public ArrayList<String> allGungu(String sido){
		
		String sql = "select gungu from region where sido = ? order by gungu"; // 가나다순
		
		ArrayList<String> gunguList = new ArrayList<String>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				gunguList.add(rs.getString("gungu"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return gunguList;
		
	}
	
	public ArrayList<RegionVO> searchSelect(String search){
		
		ArrayList<RegionVO> searchList = new ArrayList<RegionVO>();
		
		String sql = "";
		
		String[] str = search.split("\\s");
		System.out.println(Arrays.toString(str));
		
		
		try {
			sql = "select * from region where sido like ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, search);
			rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return searchList;
		
		
	}
	

}
