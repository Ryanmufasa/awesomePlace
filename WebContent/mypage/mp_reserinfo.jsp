<!-- https://github.com/Ryanmufasa/awesomePlace/issues/21 = 작성자 고유주 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/Header.jsp" %> 

<style>
  table {
    width: 50%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    border-left: 1px solid #444444;
    padding: 10px;
  }
  th:first-child, td:first-child {
    border-left: none;
  }
</style>
<div id="reser" align="center">


<h2><b>예약내역</b></h2>
<table border="1">
<tr><td>호스트명</td><td>${od.oi_host_name }</td></tr>
<tr><td>호스트 주소</td><td>${od.oi_host_addr }</td></tr>
<tr><td>호스트 연락처</td><td>${od.oi_host_tel }</td></tr>
<tr><td>예약 인원</td><td>${od.oi_guest_cnt }</td></tr>
<tr><td>체크인</td><td>${od.checkIn_date }</td></tr>
<tr><td>체크아웃</td><td>${od.checkOut_date }</td></tr>
<tr><td>지불금액</td><td>${od.pay_amt }</td></tr>
<tr><td>결제일</td><td>${od.pay_date }</td></tr>
<tr><td>예약승인</td><td>${od.oi_sign }</td></tr>
</table>

<br><br>
<button type="button" onclick="history.back()">확인</button>
</div>
<%@ include file="/layout/Footer.jsp" %> 