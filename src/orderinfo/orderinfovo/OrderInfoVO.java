// 개인 작업을 위한 작성  -- 작성자 정다영
package orderinfo.orderinfovo;

import java.util.Date;

public class OrderInfoVO {
	
	private int oi_num;
	private int oi_guest_cnt;		// 예약 숙박 인원 
	private Date checkIn_date;		
	private Date checkOut_date;
	private Date pay_date;			// 결제일자 default sysdate
	private int pay_amt;			// 결제 금액
	private String oi_sign; 		// wait, confirm, cancle
	private int oi_host_num;  		// 예약하는 호스트 정보 
	private String oi_host_name;
	private String oi_host_addr;
	private String oi_host_post_num;
	private String oi_host_tel;
	private String oi_mem_id;			// 예약 하는 회원 정보 
	private String oi_mem_tel;
	
	public OrderInfoVO() {}

	public OrderInfoVO(int oi_num, int oi_guest_cnt, Date checkIn_date, Date checkOut_date, Date pay_date, int pay_amt,
			String oi_sign, int oi_host_num, String oi_host_name, String oi_host_addr, String oi_host_post_num,
			String oi_host_tel, String oi_mem_id, String oi_mem_tel) {
		super();
		this.oi_num = oi_num;
		this.oi_guest_cnt = oi_guest_cnt;
		this.checkIn_date = checkIn_date;
		this.checkOut_date = checkOut_date;
		this.pay_date = pay_date;
		this.pay_amt = pay_amt;
		this.oi_sign = oi_sign;
		this.oi_host_num = oi_host_num;
		this.oi_host_name = oi_host_name;
		this.oi_host_addr = oi_host_addr;
		this.oi_host_post_num = oi_host_post_num;
		this.oi_host_tel = oi_host_tel;
		this.oi_mem_id = oi_mem_id;
		this.oi_mem_tel = oi_mem_tel;
	}
	
	public OrderInfoVO(int oi_guest_cnt, Date checkIn_date, Date checkOut_date, Date pay_date, int pay_amt,
			String oi_sign, int oi_host_num, String oi_host_name, String oi_host_addr, String oi_host_post_num,
			String oi_host_tel, String oi_mem_id, String oi_mem_tel) {
		super();
		this.oi_guest_cnt = oi_guest_cnt;
		this.checkIn_date = checkIn_date;
		this.checkOut_date = checkOut_date;
		this.pay_date = pay_date;
		this.pay_amt = pay_amt;
		this.oi_sign = oi_sign;
		this.oi_host_num = oi_host_num;
		this.oi_host_name = oi_host_name;
		this.oi_host_addr = oi_host_addr;
		this.oi_host_post_num = oi_host_post_num;
		this.oi_host_tel = oi_host_tel;
		this.oi_mem_id = oi_mem_id;
		this.oi_mem_tel = oi_mem_tel;
	}

	public int getOi_num() {
		return oi_num;
	}

	public void setOi_num(int oi_num) {
		this.oi_num = oi_num;
	}

	public int getOi_guest_cnt() {
		return oi_guest_cnt;
	}

	public void setOi_guest_cnt(int oi_guest_cnt) {
		this.oi_guest_cnt = oi_guest_cnt;
	}

	public Date getCheckIn_date() {
		return checkIn_date;
	}

	public void setCheckIn_date(Date checkIn_date) {
		this.checkIn_date = checkIn_date;
	}

	public Date getCheckOut_date() {
		return checkOut_date;
	}

	public void setCheckOut_date(Date checkOut_date) {
		this.checkOut_date = checkOut_date;
	}

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}

	public int getPay_amt() {
		return pay_amt;
	}

	public void setPay_amt(int pay_amt) {
		this.pay_amt = pay_amt;
	}

	public String getOi_sign() {
		return oi_sign;
	}

	public void setOi_sign(String oi_sign) {
		this.oi_sign = oi_sign;
	}

	public int getOi_host_num() {
		return oi_host_num;
	}

	public void setOi_host_num(int oi_host_num) {
		this.oi_host_num = oi_host_num;
	}

	public String getOi_host_name() {
		return oi_host_name;
	}

	public void setOi_host_name(String oi_host_name) {
		this.oi_host_name = oi_host_name;
	}

	public String getOi_host_addr() {
		return oi_host_addr;
	}

	public void setOi_host_addr(String oi_host_addr) {
		this.oi_host_addr = oi_host_addr;
	}

	public String getOi_host_post_num() {
		return oi_host_post_num;
	}

	public void setOi_host_post_num(String oi_host_post_num) {
		this.oi_host_post_num = oi_host_post_num;
	}

	public String getOi_host_tel() {
		return oi_host_tel;
	}

	public void setOi_host_tel(String oi_host_tel) {
		this.oi_host_tel = oi_host_tel;
	}

	public String getOi_mem_id() {
		return oi_mem_id;
	}

	public void setOi_mem_id(String oi_mem_id) {
		this.oi_mem_id = oi_mem_id;
	}

	public String getOi_mem_tel() {
		return oi_mem_tel;
	}

	public void setOi_mem_tel(String oi_mem_tel) {
		this.oi_mem_tel = oi_mem_tel;
	}
	
	
	
	
	

}
