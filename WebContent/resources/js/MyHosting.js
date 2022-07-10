/**
 * 마이 호스팅 페이지에서 사용되는 스크립트 파일입니다 -- 작성자 정다영
 */

$(function(){
	
	const chPw = document.getElementById('checkPw');
	
	chPw.addEventListener('click', checkPw);
	
})
// myHosting.jsp

function checkPw(){
	//alert('비밀번호 확인')
	var repw = document.getElementById('repw').value;
	
	if(repw === ""){
		alert('비밀번호를 입력해주세요!');
	}else{
		//alert('입력한 비밀번호 ' + repw);
		
		$.ajax({
			async : true,
			type : 'post',
			url : '/awesomePlace/myhosting/pwCheck.do',
			cache : false,
			data : {"repw":repw},
			datatype:'json',
			success : function(pwCheckResult){
				var pwCheckResult = parseInt(pwCheckResult);
				//alert(pwCheckResult);
				if(pwCheckResult == 1){
					//alert('비밀번호 확인 완료 호스트 목록창 이동 ')
					location.href="/awesomePlace/myhosting/myHostList.do"
					//sessionStorage.setItem("hostingPage", "hostingPageChecked")
				}else{
					alert('비밀번호 입력이 잘못되었습니다. 다시 입력해주세요')
					$('#repw').focus();
				}
			},error : function(request,error){
				alter('code : ' + request.status + "\n" 
					+ "message : " + request.responseText +
					"\n" + "error : " + error);
			}
			
		})
		
	}
	
	
}

