<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="member.MemberVO"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 예약내역</title>
</head>
<body>
<%@ include file="/layout/Header.jsp" %> 
<script src="${pageContext.request.contextPath }/resources/js/Mypage_reserlist.js"></script>
<table>
<%
List<HostVO> reserList=(List<HostVO>)request.getAttribute("reserList");
%>

<tr>
<h2>예약내역</h2>



private int host_num;  		// PK 
	private int mem_num; 		// member 테이블 참조 FK
	private String host_name;	// 호스트 이름 
	private String host_addr;	// 호스트 주소 
	private String host_post_num;	// 호스트 우편번호
	private String host_tel;	// 호스트 연락처
	private String room_type;	// 방 타입 ( A(All), P(Private room), S(Share house/room)
	private String room_name;	// 방 호실 
	private int room_cnt;		// 방 개수 
	private int guest_cnt;		// 숙박 인원
	private int weekday_amt;	// 평일 가격
	private int weekend_amt;	// 주말, 공휴일 가격
	private String host_content;
	private String host_file;	// 홍보 용 사진 
	private Date host_date;		// 호스트 등록 일자 
	
	



<div class="container" style="text-align: center;">
<table>
<tr>
<td>호스트 번호</td>
<td>회원 번호</td>
<td>호스트 이름</td>
<td>호스트 주소</td>
<td>호스트 우편번호</td>
<td>호스트 연락처</td>
<td>방 타입</td>
<td>방 호실</td>
<td>방 개수</td>
<td>숙박 인원</td>
<td>평일 가격</td>
<td>주말, 공휴일 가격</td>
<td>평일 가격</td>
<td>호스트 등록 일자</td>

</tr>

<%
	if(reserList.isEmpty()){
%>
<tr>
<td colspan="5" align="center">예약내역이 없습니다</td>
</tr>
<%} else {
int resernum=0;
for(HostVO vo : selectHost)
{
resernum=totalCount--;
%>

<tr align="center"><td><%=resernum %></td>
<td align="center"><%=vo.getHost_num %></td>
<td align="center"><%=vo.getMem_num %></td>
<td align="center"><%=vo.getHost_name %></td>
<td align="center"><%=vo.getHost_addr %></td>
<td align="center"><%=vo.getHost_post_num %></td>
<td align="center"><%=vo.getHost_tel %></td>
<td align="center"><%=vo.getRoom_type %></td>
<td align="center"><%=vo.getRoom_name %></td>
<td align="center"><%=vo.getRoom_cnt %></td>
<td align="center"><%=vo.getGuest_cnt %></td>
<td align="center"><%=vo.getWeekday_amt %></td>
<td align="center"><%=vo.getWeekend_amt %></td>
<td align="center"><%=vo.getHost_content %></td>
<td align="center"><%=vo.getHost_file %></td>
<td align="center"><%=vo.getHost_date %></td>

</div>
</tr>
</table>
</table>

<%@ include file="/layout/Footer.jsp" %> 
</body>
</html>