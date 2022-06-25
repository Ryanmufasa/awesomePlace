package host.hostordervo;

import java.util.Date;

public class HostOrderVO {
	
	private int order_id; 
	private Date checkin;
	private Date checkout;
	private int host_num;
	private String order_state;
	
	public HostOrderVO() {}
	
	public HostOrderVO(int order_id, Date checkin, Date checkout, int host_num, String order_state) {
		super();
		this.order_id = order_id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.host_num = host_num;
		this.order_state = order_state;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public Date getCheckin() {
		return checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public int getHost_num() {
		return host_num;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	public void setHost_num(int host_num) {
		this.host_num = host_num;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	
	
	

}
