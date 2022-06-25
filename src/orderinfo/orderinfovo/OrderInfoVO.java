package orderinfo.orderinfovo;

import java.util.Date;

public class OrderInfoVO {
	
	private int order_num;
	private int host_num;
	private int mem_num;
	private int guest_cnt;
	private Date order_date;
	private Date checkIn_date;
	private Date checkOut_date;
	private int pay_amt;
	private String order_sign;
	
	public OrderInfoVO() {}
	
	public OrderInfoVO(int host_num, int mem_num, int guest_cnt, Date order_date, Date checkIn_date, Date checkOut_date,
			int pay_amt, String order_sign) {
		this.host_num = host_num;
		this.mem_num = mem_num;
		this.guest_cnt = guest_cnt;
		this.order_date = order_date;
		this.checkIn_date = checkIn_date;
		this.checkOut_date = checkOut_date;
		this.pay_amt = pay_amt;
		this.order_sign = order_sign;
	}
	
	public OrderInfoVO(int order_num, int host_num, int mem_num, int guest_cnt, Date order_date, Date checkIn_date,
			Date checkOut_date, int pay_amt, String order_sign) {
		super();
		this.order_num = order_num;
		this.host_num = host_num;
		this.mem_num = mem_num;
		this.guest_cnt = guest_cnt;
		this.order_date = order_date;
		this.checkIn_date = checkIn_date;
		this.checkOut_date = checkOut_date;
		this.pay_amt = pay_amt;
		this.order_sign = order_sign;
	}
	
	public int getOrder_num() {
		return order_num;
	}
	public int getHost_num() {
		return host_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public int getGuest_cnt() {
		return guest_cnt;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public Date getCheckIn_date() {
		return checkIn_date;
	}
	public Date getCheckOut_date() {
		return checkOut_date;
	}
	public int getPay_amt() {
		return pay_amt;
	}
	public String getOrder_sign() {
		return order_sign;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public void setHost_num(int host_num) {
		this.host_num = host_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public void setGuest_cnt(int guest_cnt) {
		this.guest_cnt = guest_cnt;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public void setCheckIn_date(Date checkIn_date) {
		this.checkIn_date = checkIn_date;
	}
	public void setCheckOut_date(Date checkOut_date) {
		this.checkOut_date = checkOut_date;
	}
	public void setPay_amt(int pay_amt) {
		this.pay_amt = pay_amt;
	}
	public void setOrder_sign(String order_sign) {
		this.order_sign = order_sign;
	}
	
	
	
	

}
