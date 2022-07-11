/**https://github.com/Ryanmufasa/awesomePlace/issues/42 작성자 정다영 
 * 
 */

$(function(){
	
	var host_num = document.getElementById('host_num').value;
	//alert(host_num);
	
	$('.getTags').each(function(i){
		$(this).click(function(e){
			//alert((i+1)+"번 버튼 ");
			
			var tag_num = (i+1);
			//alert("태그 번호 "+tag_num);
			
			$.ajax({
				async : true,
				type : 'post',
				url : '/awesomePlace/myhosting/updateInfo4.do',
				cache : false,
				data : {
					"host_num" : host_num,
					"tag_num" : tag_num
				},
				datatype : 'json',
				success : function(update4){
					//alert(update4)
					if(update4 == 1){
						alert('추가 완료')
					}else{
						alert('추가 실패')
					}
				},error : function(error){
					alert('에러 : ' + error);
				}
			})
		})
	})
	
	$('.remTags').each(function(j){
		$(this).click(function(f){
		
			var tag_num = (j+1);
			
			$.ajax({
				async : true,
				type : 'post',
				url : '/awesomePlace/myhosting/updateInfo5.do',
				cache : false,
				data : {
					"host_num" : host_num,
					"tag_num" : tag_num
				},
				datatype : 'json',
				success : function(update5){
					//alert(update5)
					if(update5 == 1){
						alert('삭제 완료')
					}else{
						alert('삭제에 실패했습니다. 이미 삭제가 되었거나 없는 태그일 수 있습니다.')
					}
				},error : function(error){
					alert('에러 : ' + error);
				}
			})
		})
	})
	
	
})

$(window).on('blur', function(){
	opener.parent.location.reload();
})


