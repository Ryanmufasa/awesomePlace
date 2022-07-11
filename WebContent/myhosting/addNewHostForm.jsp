<%--https://github.com/Ryanmufasa/awesomePlace/issues/33 -- 작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 다음 우편번호 서비스 api (카카오맵 연동 가능) --%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%@include file ="/layout/Header.jsp" %>
<script type="text/javascript" src="${contextPath }/resources/js/addNewHostForm.js?v=<%=System.currentTimeMillis()%>"></script>
<style>
.addHostForm {
	width : 80%;
}

</style>
<!-- 기존 호스트 정보 입력 방식  -->
<div class="mainDiv-child" align="center">
<fieldset>
<form action="${contextPath }/myhosting/addNewCheck.do" method="post" name="addHostForm">
	<table class="addHostForm">
		<tr>
			<td>호스트 이름</td>
			<td><input type="text" id="host_name" name="host_name" required placeholder="very cozy house"></td>
		</tr>
		<tr>
			<td>호스트 주소</td>
			<td>
				<input type="text" id="sample6_postcode" name="host_post_num" placeholder="우편번호">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" id="sample6_address" name="host_addr1" placeholder="주소"><br>
				<input type="text" id="sample6_detailAddress" name="host_addr2" placeholder="상세주소">
				<input type="text" id="sample6_extraAddress" name="host_addr3" placeholder="참고항목">
			</td>
		</tr>
		<tr>
			<td>호스트연락처</td>
			<td>
				<input type="tel" name="host_tel" id="host_tel" required maxlength='13'
					onkeyup = "this.value=this.value.replace(/[^0-9]/g,'')"
					placeholder = "-를 제외한 전화번호 또는 휴대폰 번호 입력 "
					value="${mem_id.mem_tel }"
					>
			</td>
		</tr>
		<tr>
			<td>숙소 유형</td>
			<td>
					<input type="radio" name="room_type" value="A"/>집 전체(All)
					<input type="radio" name="room_type" value="P"/>개인실(Private)
					<input type="radio" name="room_type" value="S"/>다인실(Share)
				
			</td>
		</tr>
		<tr>
			<td>방 개수 </td>
			<td>
				<select name="room_cnt_1" id="room_cnt_1" onchange="changeRoomCnt()">
					<option value=" ">선택해주세요</option>
					<option value="0">직접입력</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				<span id="room_cnt_2">
				<input type="text" name="room_cnt_2" placeholder="6"> 개
				<!-- 직접 입력 선택시 보이기 -->
				</span>
			</td>
		</tr>
		<tr>
			<td>숙박 가능 인원</td>
			<td>
				<input type="text" name="guest_cnt" min="1" onkeyup = "this.value=this.value.replace(/[^0-9]/g,'')" required> 명
			</td>
		</tr>
		<tr>
			<td>평일 가격</td>
			<td>
				<input type="text" id="weekday_amt" name="weekday_amt" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"> 원
			</td>
		</tr>
		<tr>
			<td>공휴일가격</td>
			<td>
				<input type="text" id="weekend_amt" name="weekend_amt" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')"> 원
			</td>
		</tr>
		<tr>
			<td>상세 설명</td>
			<td>
				<p><textarea name="host_content" cols="50" rows="10" required placeholder="호스트에 대한 설명을 입력해주세요"></textarea></p>
			</td>
		</tr>
	</table>
	<br>
	<button type="button" onclick="check(addHostForm)">등록신청</button>
	<button type="button" onclick="history.back()">취소</button>

</form>
</fieldset>

<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>


<%@ include file="/layout/Footer.jsp" %> 
