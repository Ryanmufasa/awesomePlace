package orderinfo;

import java.util.Date;

public class OrderinfoVO {
	
	private int order_num;  	
	private int host_num; 		
	private String host_name;	
	private int mem_num;	
	private String mem_name;	
	private int guest_cnt;	
	private Date order_date;
	private int pay_amt;	
	private String order_sign;	

	// 디폴트 생성자
	public OrderinfoVO() {}

	public OrderinfoVO(int order_num, int host_num, String host_name, int mem_num, String mem_name, int guest_cnt,
			Date order_date, int pay_amt, String order_sign) {
		super();
		this.order_num=order_num;
		this.host_num=host_num;
		this.host_name=host_name;
		this.mem_num=mem_num;
		this.mem_name=mem_name;
		this.guest_cnt=guest_cnt;
		this.order_date=order_date;
		this.pay_amt=pay_amt;
		this.order_sign=order_sign;
	}
	
	//예약 정보 불러오기
	public OrderinfoVO(int order_num, int host_num, String host_name, String mem_name, int guest_cnt,
			Date order_date, int pay_amt, String order_sign) {
		super();
		this.order_num=order_num;
		this.host_num=host_num;
		this.host_name=host_name;
		this.mem_name=mem_name;
		this.guest_cnt=guest_cnt;
		this.order_date=order_date;
		this.pay_amt=pay_amt;
		this.order_sign=order_sign;
	}
	
	
	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public int getHost_num() {
		return host_num;
	}

	public void setHost_num(int host_num) {
		this.host_num = host_num;
	}

	public String getHost_name() {
		return host_name;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public int getGuest_cnt() {
		return guest_cnt;
	}

	public void setGuest_cnt(int guest_cnt) {
		this.guest_cnt = guest_cnt;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getPay_amt() {
		return pay_amt;
	}

	public void setPay_amt(int pay_amt) {
		this.pay_amt = pay_amt;
	}

	public String getOrder_sign() {
		return order_sign;
	}

	public void setOrder_sign(String order_sign) {
		this.order_sign = order_sign;
	}
	
	
}
