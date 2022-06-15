/**
 * 
 */
//https://github.com/Ryanmufasa/awesomePlace/issues/7 -- 작성자 정다영
// /WebContent/join/joinForm.jsp 에 적용되는 스크립트입니다.

$(function(){
	
	$('#pw1').on("keyup", function(){
		var pw1 = $('#pw1').val();
		pw = lengthCheck(pw1);
	})
	
	$('#pw2').on("keyup", function(){
		var pw2 = $('#pw2').val();
		repw = lengthCheck(pw2);
	})
	
	let ppww = document.querySelector('#pw2');
	ppww.addEventListener("blur",e=>{
		var pw1 = $('#pw1').val();
		var pw2 = $('#pw2').val();
		pwck = pwCheck(pw1,pw2);
		
	})
	
	$('#telinput').on("keyup", function(){
		var tel = $(this).val();
		tel = autoHypenTel(tel);
		$(this).val(tel);
	})
})
	
function lengthCheck(pw){
	if(pw.length < 6){
		$('#pwCheck').text("비밀번호는 6글자 이상 입력")
		$('#submit').attr("disabled", "disabled");
		return false;
	}else{
		$('#pwCheck').text("")
		return true;
	}
}

function pwCheck(pw1,pw2){
	if(pw2 != pw1){
		$('#pwCheck').text("비밀번호가 일치하지 않습니다.");
		return false;
	}else {
		$('#pwCheck').text("비밀번호가 일치합니다.")
		$('#submit').removeAttr("disabled");
		return true;
	}
}

function autoHypenTel(tel){
	var tmp = '';
	
	if(tel.length < 4){
		return tel;
	} else if(tel.length < 7){
		tmp += tel.substr(0,3);
		tmp += '-';
		tmp += tel.substr(3);
		return tmp;
	} else if(tel.length < 11){
		tmp += tel.substr(0,3);
		tmp += '-';
		tmp += tel.substr(3,3);
		tmp += '-';
		tmp += tel.substr(6);
		return tmp;
	} else {
		tmp += tel.substr(0,3);
		tmp += '-';
		tmp += tel.substr(3,4);
		tmp += '-';
		tmp += tel.substr(7);
		return tmp;
	}
	
}