/**
 * 
 */	
$(document).on('click','.chat-open',function(){
	
	let html = ``;
	html += $(this).find('div').text()
	
	$('#chat-label').html(html);
	$('#modal-list').modal('show');
	
	$('#user-list').modal('hide');
	
	let chatId = [];
	chatId.push($('#user-id').data('id'));
	chatId.push(userId);
	console.log("chatId",chatId)
	
	
	
	let cahtRmNm = $('#user-id').data('usernm');
	console.log("cahtRmNm",cahtRmNm);
	
	let formData = new FormData();
	
	formData.append('chatRoomVO.cahtRmNm',cahtRmNm)
	formData.append('chatRoomVO.userId',userId)
	for(let i=0;i<chatId.length;i++){
		formData.append(`chatUserList[${i}].userId`,chatId[i]);
	}
	
	$.ajax({
		url:'/chat/add',
		type:'post',
		data:formData,
		processData: false,  // FormData를 사용할 때 필요한 설정
		contentType: false,  // FormData를 사용할 때 필요한 설정
		headers: {
	            'X-CSRF-TOKEN': csrfToken
		},
		success:(res)=>{
			chatList();
		},
	});
});

function idSet(id){
	return id;
}