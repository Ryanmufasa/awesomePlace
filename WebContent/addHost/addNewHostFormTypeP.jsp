<%--https://github.com/Ryanmufasa/awesomePlace/issues/33 -- 작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 다음 우편번호 서비스 api (카카오맵 연동 가능) --%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%@include file ="/layout/Header.jsp" %>
<script type="text/javascript" src="${contextPath }/resources/js/addNewHostFormJs.js?v=<%=System.currentTimeMillis()%>"></script>
<style>
.addHostForm {
	width : 80%;
}

</style>
<!-- 개인실 -->
<!-- UI 임시 디자인 -->
<div class="mainDiv-child" align="center">
<fieldset>
<form action="${contextPath }/addHost/addNewPCheck.do" method="post" name="addHostForm">
	<input type="hidden" name="room_type" value="P">
	<table class="addHostForm">
		<tr>
			<td>호스트 이름</td>
			<td><input type="text" id="host_name" name="host_name" required placeholder="very cozy house"></td>
		</tr>
		<tr>
			<td>호스트 주소</td>
			<td>
				<input type="text" id="sample6_postcode" name="host_post_num" placeholder="우편번호" required>
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" required><br>
				<input type="text" id="sample6_address" name="host_addr1" placeholder="주소" required><br>
				<input type="text" id="sample6_detailAddress" name="host_addr2" placeholder="상세주소" required> 
				<input type="text" id="sample6_extraAddress" name="host_addr3" placeholder="참고항목">
			</td>
		</tr>
		<tr>
			<td>호스트연락처</td>
			<td>
				<input type="tel" name="host_tel" id="host_tel" required maxlength='13'
					onkeyup = "this.value=this.value.replace(/[^0-9]/g,'')"
					placeholder = "-를 제외한 전화번호 또는 휴대폰 번호 입력 "
					value="${login.mem_tel }"
					>
			</td>
		</tr>
	</table>
		<br>
	<table class="addHostForm" id="addRow">
		<tr>
			<th>호실 명</th>
			<th>숙박 가능 인원</th>
			<th>평일 가격</th>
			<th>공휴일가격</th>
		</tr>
		<!-- <tbody  id="addRow" ></tbody> -->
		<tr>
			<td><input type="text" name="room_name" placeholder="ex)101호, 커플방, 가족방" required></td>
			<td>
				<input type="text" name="guest_cnt" min="1" onkeyup = "this.value=this.value.replace(/[^0-9]/g,'')" required> 명
			</td>
			<td>
				<input type="text" id="weekday_amt" name="weekday_amt" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" required> 원
			</td>
			<td>
				<input type="text" id="weekend_amt" name="weekend_amt" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" required> 원
			</td>
		</tr> 
	</table>
	<input type="button" value="객실 추가" onclick="addRow()"/>
	<table>
		<tr>
			<td>상세 설명</td>
			<td>
				<p><textarea name="host_content" cols="50" rows="10" required placeholder="호스트에 대한 설명을 입력해주세요"></textarea></p>
			</td>
		</tr>
	</table>

	<br>
	<button type="submit" >등록신청</button><!-- onclick="checkHost(addHostForm)" -->
	<button type="button" onclick="history.back()">취소</button>

</form>
</fieldset>

<span id="counter"></span> 	<!-- 메인 컨텐츠 바닥위치값 확인용 -->
</div>
<!-- 		<tr>
			<td>등록할 객실 수</td>최대 한번에 등록 가능한 개수 10개로 제한 =
			<td>
				<select id="input_room">
					<option value="1">1개</option>
					<option value="2">2개</option>
					<option value="3">3개</option>
					<option value="4">4개</option>
					<option value="5">5개</option>
					<option value="6">6개</option>
					<option value="7">7개</option>
					<option value="8">8개</option>
					<option value="9">9개</option>
					<option value="10">10개</option>
				</select>
			</td>		
		</tr> -->

<%@ include file="/layout/Footer.jsp" %> 
