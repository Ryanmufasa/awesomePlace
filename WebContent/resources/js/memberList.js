function memInfo(idx) {
		var url = "memberInfo.do?idx="+idx;
		var name = "memInfo";
		var opt = "left=calc(50% - 175px), top=calc(50% - 150px), width = 350px, height = 300px, margin:auto";
		
		window.open(url, name, opt);
	}
	
function memHostList(idx) {
		var url = "memberHostList.do?idx="+idx;
		var name = "memHostList";
		var opt = "left=calc(50% - 400px), top=calc(50% - 250px), width = 800px, height = 800px";
		
		window.open(url, name, opt);
}

function switchAvailable(idx, flag) {
		var url = "switchAvailable.do?idx="+idx+"&flag="+flag;
		if(flag == "Y"){
			var queue = window.confirm("회원 비활성화를 진행하십니까?");
			if(queue)
				location.href=url;
		}else if(flag == "N"){
			var queue = window.confirm("회원을 다시 활성화 하십니까?");
			if(queue)
				location.href=url;
		}
//		$.ajax({
//				type:"GET",
//				url:"memUnavailable.do",
//				data: {idx},
//				success: alert("회원 비활성화 성공"),
//				error: (log)=>{alert("실패"+log)}
//			})
}
