package admin; /* https://github.com/Ryanmufasa/awesomePlace/issues/46  //작성자: 양준모 */
				// 자신의 문의글 보기 페이지에서 사용될 페이징 자바 입니다.

public class QnAPaging {
	
	public int pageCount(int rows, int dataCount) {
		
		if(dataCount <= 0) {
			return 0;
		}
		
		return dataCount / rows + (dataCount % rows > 0?1:0);
	}
	
	public String paging(int current_page, int total_page, String list_url) {
		StringBuilder sb = new StringBuilder();
		
		int numPerBlock = 5;
		int currentPageSetup;
		int n, page;
		int firstPage = current_page - ((current_page-1)%5);
		int lastPage = firstPage + 4;
		
		if(current_page < 1 || total_page < 1) {
			return "";
		}
		if(list_url.indexOf("?") != -1) {
			list_url += "&";
		}else {
			list_url += "?";
		}
		
		currentPageSetup = (current_page/numPerBlock) * numPerBlock;
		if(current_page % numPerBlock == 0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		sb.append("<div class='paginate'>");
		
		n = firstPage  -1;
		if(total_page > numPerBlock && currentPageSetup > 0) {
			sb.append("<a href='"+list_url+"page=1'>«</a>");
			sb.append("<a href='"+list_url+"page="+n+"'>‹</a>");
		}
		
		page = currentPageSetup +1;
		while(page <= total_page && page <= (currentPageSetup + numPerBlock)) {
			if(page == current_page) {
				sb.append("<span>"+page+"</span>");
			}else {
				sb.append("<a href='"+list_url+"page="+page+"'>" + page + "</a>");
			}
			page++;
		}
		n = lastPage + 1;
		if(n > total_page) n = total_page;
		if(total_page - currentPageSetup > numPerBlock) {
			sb.append("<a href='"+list_url+"page="+n+"'>›</a>");
			sb.append("<a href='"+list_url+"page="+total_page+"'>»</a>");
		}
		sb.append("</div>");
		
		return sb.toString();
		
	}

}
