package member;

public class MemberVO {
	
	private int mem_num;
	private String mem_name;
	private String mem_id;
	private String mem_pw;
	private String mem_tel;
	private String mem_email;
	private String mem_available;
	private int mem_hostingcnt;
	
	
	public MemberVO() {}
	
	
	public MemberVO(int mem_num, String mem_name, String mem_id, String mem_pw, String mem_tel, 
			String mem_email, String mem_available, int mem_hostingcnt) {
		super();
		this.mem_num=mem_num;
		this.mem_name=mem_name;
		this.mem_id=mem_id;
		this.mem_pw=mem_pw;
		this.mem_tel=mem_tel;
		this.mem_email=mem_email;
		this.mem_available=mem_available;
		this.mem_hostingcnt=mem_hostingcnt;
	}

	public MemberVO(int mem_num, String mem_name, String mem_id, String mem_pw, String mem_tel, 
			String mem_email) {
		super();
		this.mem_num=mem_num;
		this.mem_name=mem_name;
		this.mem_id=mem_id;
		this.mem_pw=mem_pw;
		this.mem_tel=mem_tel;
		this.mem_email=mem_email;
	}
	
	public MemberVO(String mem_name, String mem_id, String mem_pw, String mem_tel, String mem_email) {
		super();
		this.mem_name=mem_name;
		this.mem_id=mem_id;
		this.mem_pw=mem_pw;
		this.mem_tel=mem_tel;
		this.mem_email=mem_email;
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
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_available() {
		return mem_available;
	}
	public void setMem_available(String mem_available) {
		this.mem_available = mem_available;
	}
	public int getMem_hostingcnt() {
		return mem_hostingcnt;
	}
	public void setMem_hostingcnt(int mem_hostingcnt) {
		this.mem_hostingcnt = mem_hostingcnt;
	}
}
