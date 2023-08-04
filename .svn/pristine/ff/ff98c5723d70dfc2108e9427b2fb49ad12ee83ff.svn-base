/**
 * 
 */

//채팅방 목록 불러오기
$(document).on('click', '#msg-list', () => {
	chatList();
});

function chatList(){
	$.ajax({
		url: '/chat/list',
		type: 'get',
		data: {
			userId: userId,
		},
		success: (res) => {
			let html = ``;
			res.forEach((e, i) => {
				html += `
					<li class="w-100 p-2 border border-light align-items-center" style="list-style-type:none;">
                  		<a class="d-flex justify-content-between">
					`
									
				for(let i=0;i<e.userList.length;i++){
					if(e.userList[i].userId!=userId) {
						html +=`<div class="d-flex flex-row align-items-center">
								<img src="`+e.userList[i].userImg+`" alt="avatar" class="rounded-circle d-flex align-self-center me-3 shadow-1-strong" style="width:60px; height: 60px;"><div class="pt-1"><p class="fw-bold mb-0 chat-room" data-rmno="`+ e.chatRmNo + `">`+e.userList[i].deptNm+` `+e.userList[i].cstCdNm+` `+e.userList[i].userNm+`</p><p class="small text-muted"></p></div>`
					}
				}
									
				html +=
									`
                    		</div>
	                    <div class="pt-1">
	                    	<p class="small text-muted mb-1"></p>
	                    </div>
						</a>
                	</li>
				`
			})
			$('#off-chat-list').html(html);
		},
	});

	$('#off-chatlist').offcanvas('show');
}
