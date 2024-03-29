package admin;

import java.util.Date;

public class QnAVO { /* https://github.com/Ryanmufasa/awesomePlace/issues/46 //작성자: 양준모 */	
	private int qna_num;
	private int mem_num;
	private String mem_id;
	private String qna_title;
	private String qna_content;
	private Date qna_date;
	private String qna_dateS; // 작성자 이명진
	private String qna_sign;
	private String qna_answer;
	
	public QnAVO() {}
	
	public QnAVO(int qna_num, int mem_num, String mem_id, String qna_title, String qna_content, Date qna_date, String qna_sign, String qna_answer) {
		super();
		this.qna_num = qna_num;
		this.mem_num = mem_num;
		this.mem_id = mem_id;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_date = qna_date;
		this.qna_sign = qna_sign;
		this.qna_answer = qna_answer;
		
	}
	
	public QnAVO(int qna_num, int mem_num, String mem_id, String qna_title, String qna_content, String qna_dateS, 
			String qna_sign, String qna_answer) { // QnAList, Content 호출용 //작성자 이명진
		this.qna_num = qna_num;
		this.mem_num = mem_num;
		this.mem_id = mem_id;
		this.qna_title = qna_title;
		this.qna_dateS = qna_dateS;
		this.qna_content = qna_content;
		this.qna_sign = qna_sign;
		this.qna_answer = qna_answer;
	}

	public int getQna_num() {
		return qna_num;
	}

	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public Date getQna_date() {
		return qna_date;
	}

	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}

	public String getQna_sign() {
		return qna_sign;
	}

	public void setQna_sign(String qna_sign) {
		this.qna_sign = qna_sign;
	}

	public String getQna_answer() {
		return qna_answer;
	}

	public void setQna_answer(String qna_answer) {
		this.qna_answer = qna_answer;
	}
	
	public String getQna_dateS() {
		return qna_dateS;
	}
	
	public void setQna_dateS(String qna_dateS) {
		this.qna_dateS = qna_dateS;
	}
	
	
	

}
