/** 마이 호스팅 페이지를 눌렀을때 작동하는 스크립트 입니다 -- 작성자 정다영 
 * 로그인 여부 확인, 로그아웃 기능 
 */

$(document).ready(function(){
	
	var login = (sessionStorage.getItem("mem_id"));
	var pwch = (sessionStorage.getItem("hostingPage"));
	
})

function checkLogin(){
	//alert('로그인확인')
	login = (sessionStorage.getItem("mem_id"));
	pwch = (sessionStorage.getItem("hostingPage"));
	//alert("로그인 세션이 '' ? "+login)
	//alert("마이호스팅 비번 체크 세션이 ''? "+pwch)
	
	login = (login == "null")? true:false;
	//alert(login) // 로그인 안했을때 true 로 나옴 
	pwch = (pwch == "null")? true:false;
	//alert(pwch)
	
	if(login){
		//로그인창으로 이동 
		alert("로그인이 필요한 항목입니다! 회원가입 또는 로그인을 해주세요! ");
		location.href="/awesomePlace/login/loginform.do";
	}else{
		if(pwch){
			// 비밀번호 확인창으로 이동 
			location.href="/awesomePlace/myhosting/myHosting.do";
		}else{
			location.href="/awesomePlace/myhosting/myHostList.do";
		}
		
		
	}
	
	
/*	if(login){ // login 안했으면 세션 null
		//로그인창으로 이동 
		alert("로그인이 필요한 항목입니다! 회원가입 또는 로그인을 해주세요! ");
		location.href="/awesomePlace/login/loginform.do";
	}else if(pwch){ // 비번 체크 안했으면 세션 null
		// 비밀번호 확인창으로 이동 
		location.href="/awesomePlace/myhosting/myHosting.do";
	}else{
		location.href="/awesomePlace/myhosting/myHostList.do";
	}*/
}	

function checkLogout(){
	
	if(confirm("정말 로그아웃 하시겠습니까?") == true){
		location.href="/awesomePlace/login/logout.do";
	}else {
		return false;
	}
	
}