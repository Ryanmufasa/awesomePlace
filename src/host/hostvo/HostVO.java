// https://github.com/Ryanmufasa/awesomePlace/issues/24 -- 작성자 정다영
package host.hostvo;

import java.util.Date;

public class HostVO {
	
	private int host_num;  		// PK 
	private String host_name;	// 호스트 이름 
	private String host_addr;	// 호스트 주소 
	private String host_post_num;	// 호스트 우편번호
	private String host_tel;	// 호스트 연락처
	private String room_type;	// 방 타입 ( A(All), P(Private room), S(Share house/room)
	private int room_cnt;		// 방 개수 
	private int guest_cnt;		// 숙박 인원
	private int weekday_amt;	// 평일 가격
	private int weekend_amt;	// 주말, 공휴일 가격
	private String host_content;
	private Date host_date;		// 호스트 등록 일자 
	private String sign; // 호스트 승인 여부 ( default 값 false ) 
	private int mem_num; 		// member 테이블 참조 FK
	private String mem_id;
	
	private String host_dateS; //호스트리스트 출력 생성자용 작성자:이명진
	
	// 디폴트 생성자
	public HostVO() {}
	
	// 호스트 처음 등록시 
	public HostVO(String host_name, String host_addr, String host_post_num, String host_tel,
			String room_type, int room_cnt, int guest_cnt, int weekday_amt, int weekend_amt,
			String host_content, int mem_num, String mem_id) {
		this.host_name = host_name;
		this.host_addr = host_addr;
		this.host_post_num = host_post_num;
		this.host_tel = host_tel;
		this.room_type = room_type;
		this.room_cnt = room_cnt;
		this.guest_cnt = guest_cnt;
		this.weekday_amt = weekday_amt;
		this.weekend_amt = weekend_amt;
		this.host_content = host_content;
		this.mem_num = mem_num;
		this.mem_id=mem_id;
		
	}
	
	//호스트리스트 출력용 생성자 작성자:이명진
	public HostVO(int host_num, String host_name, String host_addr, String host_post_num, String host_tel,
				String room_type, int room_cnt, int guest_cnt, int weekday_amt, int weekend_amt, 
				String host_content, String host_dateS, String sign, int mem_num, String mem_id) {
		
		this.host_num = host_num;
		this.host_name = host_name;
		this.host_addr = host_addr;
		this.host_post_num = host_post_num;
		this.host_tel = host_tel;
		this.room_type = room_type;
		this.room_cnt = room_cnt;
		this.guest_cnt = guest_cnt;
		this.weekday_amt = weekday_amt;
		this.weekend_amt = weekend_amt;
		this.host_content = host_content;
		this.host_dateS = host_dateS;
		this.sign = sign;
		this.mem_num = mem_num;
		this.mem_id = mem_id;
	}
	
	// DB에 있는 호스트 정보를 가져올때 생성자 
	public HostVO(int host_num, String host_name, String host_addr, String host_post_num, String host_tel,
			String room_type, int room_cnt, int guest_cnt, int weekday_amt, int weekend_amt,
			String host_content, Date host_date, String sign, int mem_num, String mem_id) {
		super();
		this.host_num = host_num;
		this.host_name = host_name;
		this.host_addr = host_addr;
		this.host_post_num = host_post_num;
		this.host_tel = host_tel;
		this.room_type = room_type;
		this.room_cnt = room_cnt;
		this.guest_cnt = guest_cnt;
		this.weekday_amt = weekday_amt;
		this.weekend_amt = weekend_amt;
		this.host_content = host_content;
		this.host_date = host_date;
		this.sign = sign;
		this.mem_num = mem_num;
		this.mem_id = mem_id;
	}
	
	public int getHost_num() {
		return host_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public String getHost_name() {
		return host_name;
	}
	public String getHost_addr() {
		return host_addr;
	}
	public String getHost_post_num() {
		return host_post_num;
	}
	public String getHost_tel() {
		return host_tel;
	}
	public String getRoom_type() {
		return room_type;
	}
	public int getRoom_cnt() {
		return room_cnt;
	}
	public int getGuest_cnt() {
		return guest_cnt;
	}
	public int getWeekday_amt() {
		return weekday_amt;
	}
	public int getWeekend_amt() {
		return weekend_amt;
	}
	public Date getHost_date() {
		return host_date;
	}
	public void setHost_num(int host_num) {
		this.host_num = host_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	public void setHost_addr(String host_addr) {
		this.host_addr = host_addr;
	}
	public void setHost_post_num(String host_post_num) {
		this.host_post_num = host_post_num;
	}
	public void setHost_tel(String host_tel) {
		this.host_tel = host_tel;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public void setRoom_cnt(int room_cnt) {
		this.room_cnt = room_cnt;
	}
	public void setGuest_cnt(int guest_cnt) {
		this.guest_cnt = guest_cnt;
	}
	public void setWeekday_amt(int weekday_amt) {
		this.weekday_amt = weekday_amt;
	}
	public void setWeekend_amt(int weekend_amt) {
		this.weekend_amt = weekend_amt;
	}
	public String getHost_content() {
		return host_content;
	}

	public void setHost_content(String host_content) {
		this.host_content = host_content;
	}

	public void setHost_date(Date host_date) {
		this.host_date = host_date;
	}
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getHost_dateS() {
		return host_dateS;
	}

	public void setHost_dateS(String host_dateS) {
		this.host_dateS = host_dateS;
	}
}
