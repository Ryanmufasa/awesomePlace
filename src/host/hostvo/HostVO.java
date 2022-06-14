// https://github.com/Ryanmufasa/awesomePlace/issues/24 -- 작성자 정다영
package host.hostvo;

import java.util.Date;

public class HostVO {
	
	private int host_num;  		// PK 
	private int mem_num; 		// member 테이블 참조 FK
	private String host_name;	// 호스트 이름 
	private String host_addr;	// 호스트 주소 
	private int host_post_num;	// 호스트 우편번호
	private String host_tel;	// 호스트 연락처
	private String room_type;	// 방 타입 ( A(All), P(Private room), S(Share house/room)
	private String room_name;	// 방 호실 
	private int room_cnt;		// 방 개수 
	private int guest_cnt;		// 숙박 인원
	private int weekday_amt;	// 평일 가격
	private int weekend_amt;	// 주말, 공휴일 가격
	private String host_content;
	private String host_file;	// 홍보 용 사진 
	private Date host_date;		// 호스트 등록 일자 
	
	// 디폴트 생성자
	public HostVO() {}
	
	// 호스트 처음 등록시 
	public HostVO(int mem_num, String host_name, String host_addr, int host_post_num, String host_tel,
			String room_type, String room_name, int room_cnt, int guest_cnt, int weekday_amt, int weekend_amt,
			String host_content, String host_file, Date host_date) {
		this.mem_num = mem_num;
		this.host_name = host_name;
		this.host_addr = host_addr;
		this.host_post_num = host_post_num;
		this.host_tel = host_tel;
		this.room_type = room_type;
		this.room_name = room_name;
		this.room_cnt = room_cnt;
		this.guest_cnt = guest_cnt;
		this.weekday_amt = weekday_amt;
		this.weekend_amt = weekend_amt;
		this.host_content = host_content;
		this.host_file = host_file;
		this.host_date = host_date;
	}
	
	// DB에 있는 호스트 정보를 가져올때 생성자 
	public HostVO(int host_num, int mem_num, String host_name, String host_addr, int host_post_num, String host_tel,
			String room_type, String room_name, int room_cnt, int guest_cnt, int weekday_amt, int weekend_amt,
			String host_content, String host_file, Date host_date) {
		super();
		this.host_num = host_num;
		this.mem_num = mem_num;
		this.host_name = host_name;
		this.host_addr = host_addr;
		this.host_post_num = host_post_num;
		this.host_tel = host_tel;
		this.room_type = room_type;
		this.room_name = room_name;
		this.room_cnt = room_cnt;
		this.guest_cnt = guest_cnt;
		this.weekday_amt = weekday_amt;
		this.weekend_amt = weekend_amt;
		this.host_content = host_content;
		this.host_file = host_file;
		this.host_date = host_date;
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
	public int getHost_post_num() {
		return host_post_num;
	}
	public String getHost_tel() {
		return host_tel;
	}
	public String getRoom_type() {
		return room_type;
	}
	public String getRoom_name() {
		return room_name;
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
	public String getHost_file() {
		return host_file;
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
	public void setHost_post_num(int host_post_num) {
		this.host_post_num = host_post_num;
	}
	public void setHost_tel(String host_tel) {
		this.host_tel = host_tel;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
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

	public void setHost_file(String host_file) {
		this.host_file = host_file;
	}
	public void setHost_date(Date host_date) {
		this.host_date = host_date;
	}
	

}
