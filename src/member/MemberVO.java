package member;

public class MemberVO {
	
	private int mem_num;
	private String mem_name;
	private String mem_id;
	private String mem_pw;
	private String mem_tel;
	private String mem_email;
	private String mem_sign;
	private int mem_hostCnt;
	
	public MemberVO() {}
	
	public MemberVO(int mem_num, String mem_name, String mem_id, String mem_pw, String mem_tel, String mem_email,
			String mem_sign, int mem_hostCnt) {
		super();
		this.mem_num = mem_num;
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_tel = mem_tel;
		this.mem_email = mem_email;
		this.mem_sign = mem_sign;
		this.mem_hostCnt = mem_hostCnt;
	}
	
	public MemberVO(String mem_name, String mem_id, String mem_pw, String mem_tel, String mem_email,
			String mem_sign, int mem_hostCnt) {
		super();
		this.mem_name = mem_name;
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_tel = mem_tel;
		this.mem_email = mem_email;
		this.mem_sign = mem_sign;
		this.mem_hostCnt = mem_hostCnt;
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


	public String getMem_sign() {
		return mem_sign;
	}


	public void setMem_sign(String mem_sign) {
		this.mem_sign = mem_sign;
	}


	public int getMem_hostCnt() {
		return mem_hostCnt;
	}


	public void setMem_hostCnt(int mem_hostCnt) {
		this.mem_hostCnt = mem_hostCnt;
	}
}
