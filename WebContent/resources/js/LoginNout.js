/** 테스트를 위한 작성 
 * 로그인 여부 확인, 로그아웃 기능 
 */

function checkLogin(){
	var login = sessionStorage.getItem('mem_id');
	
	if(login == null){
		alert("로그인이 필요한 항목입니다! 회원가입 또는 로그인을 해주세요! ");
		location.href="/awesomePlace/login/loginForm.do";
	}else {
		location.href="/awesomePlace/myhosting/myhosting.do";
	}
}	

function checkLogout(){
	
	if(confirm("정말 로그아웃 하시겠습니까?") == true){
		location.href="/awesomePlace/login/logout.do";
	}else {
		return false;
	}
	
}