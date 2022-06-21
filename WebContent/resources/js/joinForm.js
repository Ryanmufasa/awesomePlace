//https://github.com/Ryanmufasa/awesomePlace/issues/7 -- 작성자 정다영
//https://github.com/Ryanmufasa/awesomePlace/issues/22 -- 작성자 정다영
// /WebContent/join/joinForm.jsp 에 적용되는 스크립트입니다.
// 관련 컨트롤러 서비스 : joinService., idCheckService, EmailCheckService
// ajax 작동시 결과값 전달 페이지 : idCheck.jsp, emailCheck.jsp

var idcnt;
var pwcnt;
var emcnt;

$(function(){

	$('#id').on("keyup", function(){ // 아이디 입력시 중복확인 버튼 활성화 
		$('#idCheck').removeAttr("disabled");
		idcnt = false;
	})
	
	$('#idCheck').click(function(){ // 아이디 중복확인 버튼 클릭시 
		//alert("아이디 중복 확인요청");
		
		var userid = $('#id').val();
	
		if( userid.trim() == "") { // 입력 값이 빈문자열일때 
			alert("아이디를 입력해주세요!");
			$('#id').select();
		}
		
		if(userid.trim() != ""){
			//alert("아이디를 확인합니다");
			//alert(userid);
			
			$.ajax({
				async : true,
				type : 'post',  
				url : "/awesomePlace/join/idCheck.do", 
				cache : false,
				data : { "id" : userid} , // key:value 형태로 보내야 request.getParameter 가능 
				datatype: 'json',  // html, text, script 형태도 있으나 json 사용
				success : function(idResult){
					// DAO return 값을 int형으로 변환 
					//alert(cnt); // 0이면 없음, 1이상이면 중복 
					if(idResult == 0){
						alert("아이디 사용가능");
						$('#pw1').focus();
						idcnt = true;
						return true;
					}else {
						alert("이미 사용중인 아이디");
						$('#id').val('').focus();
						idcheck.prop("disabled", true);
						idcnt = false;
						return false;
					}
				},error : function(e){
					alert('error');
				}
				// 아래는 DAO 리턴타입이 String 이나 MemberVO 객체인경우.... 
				// NullPointException 발생해서 int 형으로 변경함. 
				/*success : function(response){ 
						// idcheck.do로 컨트롤러에서 service 실행후 결과값 전달페이지를 joinCheck.jsp 로 함.
						// service 의 결과가 joinCheck.jsp 로 전달되는데 
						// joinCheck.jsp 에서 NullPointException 이 발생하면 해당 아이디 사용 가능. 
						// NullPointException 발생하지 않는 경우는 아이디가 DB에 있는 경우로 사용 불가. 
					alert("이미 사용중인 아이디");
					$('#id').val('').focus();
					idcheck.prop("disabled", true);
					idcnt = 0;
				}, 
				error : function(e){ // (XHR인스턴스,상태값,예외객체)
					// joinChedck.jsp 에서 NullPointException 발생.
					alert("아이디 사용가능");
					$('#pw1').focus();
					idcnt = 1;
				}*/
			});
		}
	});
	
	$('#pw1').on("keyup", function(){ // 비밀번호 입력시 입력값 최소 길이 확인 
		var pw1 = $('#pw1').val();
		pw = lengthCheck(pw1);
		pwcnt = false;
	})
	
	$('#pw2').on("keyup", function(){ // 비밀번호 확인란 입력시 입력값 최소 길이 확인 
		var pw2 = $('#pw2').val();
		repw = lengthCheck(pw2);
	})
	
	$('.pw').focusout(function(){ // 두개의 비밀번호 일치 여부 확인 
		let pw1 = $('#pw1').val();
		let pw2 = $('#pw2').val();
	
		if(pw == true || repw == true){
			if(pw1 == pw2){
				$('#pwCheck').text("비밀번호가 일치합니다.")
				pwcnt = true;
				return true;
			}else{
				$('#pwCheck').text("비밀번호가 일치하지 않습니다.");
				pwcnt = false;
				return false;
			}
		}
	});

	$('#telinput').on("keyup", function(){ // 전화번호 입력시 입력값 길이에 따른 - 추가 
		var tel = $(this).val();
		tel = autoHypenTel(tel);
		$(this).val(tel);
	})
	
	$('#email1').on("keyup", function(){ // 이메일 주소 입력시 중복확인 버튼 활성화 
		$('#emailCheck').prop('disabled', false);
		emcnt = false;
	})

	$('#emailCheck').click(function(){ // 이메일 주소 중복 확인
		alert("email 중복을 확인합니다");
		
		var email1 = $('#email1').val();
		var email2 = $('#email2').val();
		var email = email1 + "@" + email2;
	
		if(email1.trim() == "" || email2.trim() == ""){ // 입력 값에 빈 문자열이 있는 경우 
			//alert(email1);
			//alert(email2);
			alert("이메일 주소 입력을 확인해주세요!")
		}else {
			alert("입력한 이메일 주소 : " + email);
			
			$.ajax({
				async : true,
				type : 'post',
				url : "/awesomePlace/join/emailCheck.do",
				cache : false,
				data : {"email" : email },
				datatype : 'json',
				success : function(emailResult){
					if(emailResult == 0){ // 0이면 사용가능 
						alert('이메일 주소 사용 가능');
						emcnt = true;
						return true;
					}else {
						alert('이미 사용중인 이메일 주소입니다.');
						$('#email1').val('').focus();
						emcnt = false;
						return false;
					}
				}, error : function(e1){
					alert('error');
				}
			})
		}
	})
})
	
function lengthCheck(pw){
	if(pw.length < 6){
		$('#pwCheck').text("비밀번호는 6글자 이상 입력")
		return false;
	}else{
		$('#pwCheck').text("")
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

function allCheck(f){
	
	if(idcnt){ 
		f.idCheck.className -='blinkBtn';
	}
	
	if(emcnt){
		f.emailCheck.className -='blinkBtn';
	}
	
	if(f.name.value == ""){
		f.name.focus();
	}else if(f.id.value == ""){
		f.id.focus();
	}else if(!idcnt){
		f.idCheck.className ='blinkBtn';
	}else if(f.pw.value == ""){
		f.pw.focus();
	}else if(f.pw2.value == ""){
		f.pw2.focus();
	}else if(f.pw.value != f.pw2.value){
		//alert('비밀번호 입력 확인 ');
		//f.pw.value('');
		f.pw2.focus();
	}else if(f.tel.value == ""){
		f.tel.focus();
	}else if(f.email1.value == ""){
		f.email1.focus();
	}else if(!emcnt){
		f.emailCheck.className ='blinkBtn';
	}else{
		f.submit();
	}
	
}

