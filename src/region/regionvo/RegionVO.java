// https://github.com/Ryanmufasa/awesomePlace/issues/35  -- 작성자 정다영 
package region.regionvo;

public class RegionVO {
	
	private int no;
	private String sido;
	private String gungu;
	
	public RegionVO() {}
	
	public RegionVO(String sido, String gungu) {
		this.sido = sido;
		this.gungu = gungu;
	}
	
	public RegionVO(int no,String sido, String gungu) {
		this.no = no;
		this.sido = sido;
		this.gungu = gungu;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGungu() {
		return gungu;
	}
	public void setGungu(String gungu) {
		this.gungu = gungu;
	}
	
	

}
