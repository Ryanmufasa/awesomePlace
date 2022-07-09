package hashtag;

public class HashtagVO {
	int tag_num;
	String tag_name;
	
	public HashtagVO() {}
	
	public HashtagVO(int tag_num, String tag_name) {
		this.tag_num = tag_num;
		this.tag_name = tag_name;
	}
	
	public int getTag_num() {
		return tag_num;
	}
	public void setTag_num(int tag_num) {
		this.tag_num = tag_num;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	
	
}
