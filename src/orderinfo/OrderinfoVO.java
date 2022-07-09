//https://github.com/Ryanmufasa/awesomePlace/issues/37 = 작성자 고유주
package orderinfo;

import java.util.Date;

public class OrderinfoVO {
	
	private int oi_num;
	private int oi_guest_cnt;
	private Date checkin_date;
	private Date checkout_date;
	private Date pay_date;
	private int pay_amt;
	private String oi_sign;
	private int oi_host_num;
	private String oi_host_name;
	private String oi_host_addr;
	private String oi_host_post_num;
	private String oi_host_tel;
	private String oi_mem_id;
	private String oi_mem_tel;
	
	public OrderinfoVO() {}

	public OrderinfoVO(int oi_num, int oi_guest_cnt, Date checkin_date, Date checkout_date, Date pay_date, int pay_amt,
			String oi_sign, int oi_host_num, String oi_host_name, String oi_host_addr, String oi_host_post_num,
			String oi_host_tel, String oi_mem_id, String oi_mem_tel) {
		super();
		this.oi_num = oi_num;
		this.oi_guest_cnt = oi_guest_cnt;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
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

	public OrderinfoVO(int oi_guest_cnt, Date checkin_date, Date checkout_date, Date pay_date, int pay_amt,
			String oi_sign, int oi_host_num, String oi_host_name, String oi_host_addr, String oi_host_post_num,
			String oi_host_tel, String oi_mem_id, String oi_mem_tel) {
		super();
		this.oi_guest_cnt = oi_guest_cnt;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
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

	//마이페이지에서 예약내역
	public OrderinfoVO(int oi_num, int oi_guest_cnt, Date checkin_date, Date checkout_date, Date pay_date, int pay_amt,
			String oi_sign, String oi_host_name, String oi_host_addr, String oi_host_tel) {
		super();
		this.oi_num = oi_num;
		this.oi_guest_cnt = oi_guest_cnt;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.pay_date = pay_date;
		this.pay_amt = pay_amt;
		this.oi_sign = oi_sign;
		this.oi_host_name = oi_host_name;
		this.oi_host_addr = oi_host_addr;
		this.oi_host_tel = oi_host_tel;
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

	public Date getCheckin_date() {
		return checkin_date;
	}

	public void setCheckin_date(Date checkin_date) {
		this.checkin_date = checkin_date;
	}

	public Date getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(Date checkout_date) {
		this.checkout_date = checkout_date;
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