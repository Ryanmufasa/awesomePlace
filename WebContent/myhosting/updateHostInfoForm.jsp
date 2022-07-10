<%--//https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/layout/Header.jsp" %>
<link href="${contextPath }/resources/css/updateHostForm.css?v=<%=System.currentTimeMillis() %>" rel="stylesheet">
<script type="text/javascript" src="${contextPath }/resources/js/updateHostForm.js?v=<%=System.currentTimeMillis()%>"></script>
<div class="mainDiv-child" align="center">
<c:if test="${empty vo }">
	<script>
		alert('호스트 정보를 불러오는데 실패했습니다. 잠시 후에 다시 시도해주세요');
		location.href="history.back()";
	</script>
</c:if>
<section id="host1">
<h2>호스트 정보 수정</h2>
	<article class="host">
		<div class="infomenu"><h3>호스트 기본정보 변경하기</h3>
		<form class="info1" action="${contextPath }/myhosting/updateInfo1.do" method="post">
		<input type="hidden" id="host_num" name="host_num" value="${vo.host_num }">
			<table>
				<tr>
					<td>호스트 이름</td>
					<td><input type="text" id="host_name" name="host_name" required value="${vo.host_name }"></td>
				</tr>
				<tr>
					<td>호스트 주소</td> <%--주소는 변경 불가 --%>
					<td>
						<span>우편번호 : ${vo.host_post_num }</span>
						<span>주소 : ${vo.host_addr }</span>
					</td>
				</tr>
				<tr>
					<td>호스트 연락처</td>
					<td><input type="tel" name="host_tel" id="host_tel" required maxlength='13'
						onkeyup = "this.value=this.value.replace(/[^0-9]/g,'')"
						placeholder = "-를 제외한 전화번호 또는 휴대폰 번호 입력 "
						value="${vo.host_tel }">
					</td>
				</tr>
				<tr>
					<td>상세 설명</td>
					<td>
					<p><textarea id="host_content" name="host_content" cols="50" rows="10" 
						required placeholder="호스트에 대한 설명을 입력해주세요">${vo.host_content }</textarea></p>
					</td>
				</tr>
			</table>
			<button type="button" id="info1btn">수정하기</button>
		</form>
		</div>
	</article>
	<article class="host">
		<div class="infomenu"><h3>호스트 종류 변경하기</h3>
		<form class="info2" action="${contextPath }/myhosting/updateInfo2.do" method="post">
		<%-- <input type="hidden" name="host_num" value="${vo.host_num }"> --%>
		<table>
			<tr>
				<td>방 종류</td>
				<td><c:set var="room" value="${vo.room_type }"/>
				<c:choose>
					<c:when test="${fn:contains(room, 'A') }">
						<input type="radio" name="room_type" value="A" checked/>집 전체(All)
						<input type="radio" name="room_type" value="P"/>개인실(Private)
						<input type="radio" name="room_type" value="S"/>다인실(Share)
					</c:when>
					<c:when test="${fn:contains(room,'P') }">
						<input type="radio" name="room_type" value="A"/>집 전체(All)
						<input type="radio" name="room_type" value="P" checked/>개인실(Private)
						<input type="radio" name="room_type" value="S"/>다인실(Share)
					</c:when>
					<c:otherwise>
						<input type="radio" name="room_type" value="A"/>집 전체(All)
						<input type="radio" name="room_type" value="P"/>개인실(Private)
						<input type="radio" name="room_type" value="S" checked/>다인실(Share)
					</c:otherwise>
				</c:choose>
				<input type="hidden" id="checkedType" name="checkedType" value="${vo.room_type }"> 
				</td>
			</tr>
			<tr>
				<td>방 개수 </td>
				<td><span id="db_room_cnt">${vo.room_cnt } 개</span> <button type="button" id="room_cnt">변경하기</button> 
					<!-- 변경하기 선택시 보이기  -->
					<select name="room_cnt_1" id="room_cnt_1">
						<option value=" ">선택해주세요</option>
						<option value="0">직접입력</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
					<span id="room_cnt_2">
					<input type="text" name="room_cnt_2" placeholder="6" value="${vo.room_cnt }"> 개
					<!-- 직접 입력 선택시 보이기 -->
					</span>
					<input type="hidden" id="roomCnt" name="roomCnt" value="${vo.room_cnt }">
				</td>
			</tr>
			<tr>
				<td>숙박 가능 인원</td>
				<td>
					<input type="text" value="${vo.guest_cnt }"  id="guest_cnt" name="guest_cnt" min="1" onkeyup = "this.value=this.value.replace(/[^0-9]/g,'')" required> 명
					<input type="hidden" id="guestCnt" value="${vo.guest_cnt }">
				</td>
			</tr>
		</table>
		<button type="button" id="info2btn">수정하기</button>
		</form>
		</div>
	</article>
	<article  class="host">
		<div class="infomenu"><h3>호스트 예약 가격 변경하기</h3>
		<form class="info3" action="${contextPath }/myhosting/updateInfo3.do" method="post">
		<input type="hidden" name="host_num" value="${vo.host_num }">
			<table>
				<tr>
					<td>평일 가격</td>
					<td>
						<input type="text" id="weekday_amt" name="weekday_amt" value="${vo.weekday_amt }" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"> 원
					</td>
				</tr>
				<tr>
					<td>공휴일가격</td>
					<td>
						<input type="text" id="weekend_amt" name="weekend_amt"  value="${vo.weekend_amt }" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"> 원
					</td>
				</tr>
			</table>
			<button type="button" id="info3btn">수정하기</button>
		</form>
		</div>
	</article>
	<article  class="host">
		<div class="infomenu"><h3>호스트 키워드 관리</h3>
		<form class="info4" action="${contextPath }/myhosting/updateInfo4.do" method="post">
		<input type="hidden" name="host_num" value="${vo.host_num }">
		<c:if test="${!empty taglist}">
			<c:forEach var="tag" items="${taglist }">
				<span>${tag.tag_name }</span>
			</c:forEach>
		</c:if>
		<c:if test="${empty taglist}">
			<p> 호스트 키워드가 없습니다! 키워드를 입력해보세요! </p>
		</c:if>
		<br>
		<button type="button" id="addTag">키워드 추가하기</button><br>
		<button type="button" id="info4btn">수정완료</button>
		</form>
		</div>
	</article>
</section>
<span id="counter"></span> 
</div>

<%@ include file="/layout/Footer.jsp" %> 