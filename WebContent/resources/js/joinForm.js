//https://github.com/Ryanmufasa/awesomePlace/issues/7 -- 작성자 정다영
// /WebContent/join/joinForm.jsp 에 적용되는 스크립트입니다.


$(function(){
	
	$('#submit').prop("disabled", true);
		
	let idcheck = $('#idCheck');
	idcheck.prop("disabled", true);
	
	$('#id').on("keyup", function(){
		idcheck.removeAttr("disabled");
	})
	
	var idcnt = 0;
	var pwcnt = 0;
	
	$('#idCheck').click(function(){
		alert("아이디 중복 확인요청");
		
		var userid = $('#id').val();
	
		if( userid.trim() == "") {
			alert("아이디를 입력해주세요!");
			$('#id').select();
		}
		
		//var jData = JSON.parse("{}");
		
		if(userid.trim() != ""){
			alert("아이디를 확인합니다");
			alert(userid);
			
			//jData["userid"] = userid;
			$.ajax({
				//async : true,
				type : 'post',
				url : "/awesomePlace/join/idcheck.do",
				cache : false,
				//data : userid,
				data : { userid : userid} ,
				//data : JSON.stringify(jData),
				datatype:"json",
				success : function(data){
					var result = data.dataList;
					alert(result);
			//https://melonicedlatte.com/web/2017/05/18/185045.html		
					
				/*	if(!$.trim(data)){
						
						alert("사용가능한 아이디");
						$('#pw1').focus();
							//$('#submit').prop("disabled", false);
						idcnt = 1;
					} else{
						alert(data);
						alert("이미 사용중인 아이디");
						$('#id').val('').focus();
							//$('#submit').prop("disabled", true);
						idcheck.prop("disabled", true);
						idcnt = 0;
					}*/
				}, error : function(e){
					alert("error");
				}
			});
		}
		
	});
	
	$('#pw1').on("keyup", function(){
		var pw1 = $('#pw1').val();
		pw = lengthCheck(pw1);
	})
	
	$('#pw2').on("keyup", function(){
		var pw2 = $('#pw2').val();
		repw = lengthCheck(pw2);
	})
	
	$('.pw').focusout(function(){
		let pw1 = $('#pw1').val();
		let pw2 = $('#pw2').val();
	
		if(pw == true || repw == true){
			if(pw1 == pw2){
				$('#pwCheck').text("비밀번호가 일치합니다.")
				//$('#submit').removeAttr("disabled");
				pwcnt = 1;
				return true;
			}else{
				$('#pwCheck').text("비밀번호가 일치하지 않습니다.");
				//$('#submit').attr("disabled", "disabled");
				pwcnt = 0;
				return false;
			}
		}
	});
	
	/*let ppww = document.querySelector('#pw2');
	ppww.addEventListener("blur",e=>{
		var pw1 = $('#pw1').val();
		var pw2 = $('#pw2').val();
		pwck = pwCheck(pw1,pw2);
		if(pw == true && repw == true){
			
			if(pwck){
				$('#submit').removeAttr("disabled");
			}else{
				$('#submit').attr("disabled", "disabled");
			}
		}
	})*/
	
	$('#telinput').on("keyup", function(){
		var tel = $(this).val();
		tel = autoHypenTel(tel);
		$(this).val(tel);
	})
	
	if(idcnt == 1 && pwcnt == 1){
		$('#submit').removeAttr("disabled");
	}

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



/*function pwCheck(pw1,pw2){
	if(pw2 != pw1){
		$('#pwCheck').text("비밀번호가 일치하지 않습니다.");
		return false;
	}else {
		$('#pwCheck').text("비밀번호가 일치합니다.")
		$('#submit').removeAttr("disabled");
		return true;
	}
}*/

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

