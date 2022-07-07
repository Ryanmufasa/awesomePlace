<%--https://github.com/Ryanmufasa/awesomePlace/issues/33 -- 작성자 정다영 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file ="/layout/Header.jsp" %>
<style>
#t{
	width:80px;
	height:80px;
	margin:auto;
}

</style>

<div class="mainDiv-child" align="center">

	<form name="chType"> 
		
		<h2> 호스트 유형을 선택해주세요!</h2>
	
		<button id="t" type="button" onclick="checkType('A')" >집 전체</button>
		<button id="t" type="button" onclick="checkType('P')" >개인실</button>
		<button id="t" type="button" onclick="checkType('S')" >다인실</button>
	
	</form>




<span id="counter"></span>
</div>


<script>

function checkType(btn){
	
	var chType = document.chType;
	chType.method="post";
	chType.target="_self";
	
	var type = btn;
	alert(type);
	
	if(type == "A"){
		alert("A로 보낼거야 ")
		chType.action="addNewHostTypeA.do";
		
	}else if(type == "P"){
		alert("P로 보낼거야 ")
		chType.action="addNewHostTypeP.do";
	}else{
		alert("S로 보낼거야 ")
		chType.action="addNewHostTypeS.do";
	}
	chType.submit();
	
	//var type = btn;  alert(type.value);
	
	//type = btn.value;  alert(type);
	
	//if(type === "A"){
		
	//}

}


</script>


<%@ include file="/layout/Footer.jsp" %> 