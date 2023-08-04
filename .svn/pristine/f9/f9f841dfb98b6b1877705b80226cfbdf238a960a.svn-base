/**
 * 
 */

//방 번호
let chatRmNo;
//채팅 소켓 열기
var chat = new SockJS("/chat");
var stompChat = Stomp.over(chat);
stompChat.debug = null;

//채팅방 열기
$(document).on('click','.chat-room',(e)=>{
	chatRmNo = $(e.target).data('rmno');
	
	$('#offcanvasRight').offcanvas('hide');
	$('#offcanvas-chat-header').html($(e.target).text());
	$('#offcanvas-chat').css('heigth','400px;');
	$('#offcanvas-chat').offcanvas('show');
	
	//채팅 목록 처음에 받아오기 위해 호출하기
	stompChat.send('/pub/chatRoom',{}, JSON.stringify({
		chatRmNo:chatRmNo,
	}));
	
	//채팅내용 받아오기
	stompChat.subscribe("/sub/chatRoom/"+chatRmNo,(chat)=>{
        var content = JSON.parse(chat.body);
		let str = ``;
        if(content){
			if(content.length==0) $('#off-chat-msg').html('');
			content.forEach((e,i)=>{
				const dsptch = e.userNm;
				const chatMsgCn = e.chatMsgCn;
				
				if(e.userId==userId){
					str += `<div class="d-flex justify-content-end me-2"><div class="bg-primary text-white p-2 rounded-2 chat-message light">`+chatMsgCn+`</div></div>`
				}else{
					str += `<div class="d-flex align-items-center"><div class="chat-message me-2">`+dsptch+`</div><div class="chat-message bg-200 p-2 rounded-2"><div>`+chatMsgCn+`</div></div></div>`
				}
			});
			$('#modal-chatlist').html(str);
			
			setTimeout(function() {
            $('#modal-chatlist').scrollTop(100);
        }, 0);
        }
    });
	$('#modal-chatroom').modal('show');
	$('#off-chatroom').offcanvas('show');
});

//채팅 소켓 열기
stompChat.connect({}, function() {
	if(userId!=null&&userId!='') stomp.send('/pub/userData',{}, JSON.stringify({}));
	stompChat.subscribe("/sub/userData", function(chat) {
		var content = JSON.parse(chat.body);
		if (content) {
			listView(content);
		}		
	});
});


//현재 온라인이 사용자 뿌려주기
function listView(content){
	let html = ``;
	
	const userSesstion = new Map(Object.entries(content));
		html += `<div class="text-center">현재 접속 사용자 현황</div>`;
	if(content.size<=1){
		html += `
			<div class="dropdown-item text-center">현재 접속 인원이 없습니다</div>
		`
	} else {
		userSesstion.forEach((value, key, map)=>{
			if(key==userId) return;
			const deptNm = value[0];
			const jbgdNm = value[1];
			const userNm = value[2];
			
			html += `
					<li>
						<button type="button" class="dropdown-item text-center chat-open" data-toggle="modal" data-target="#modal-list">
							<div class="hover-actions-trigger chat-contact nav-item text-center d-flex align-items-center">
								&nbsp&nbsp&nbsp`+deptNm+` `+userNm+` `+jbgdNm+`
							</div>
						</button>
					</li>
			`
		});
	}
	$('#drop-chat-list').html(html);
}

//채팅 전송
$('#modal-chat-send').on('click',()=>{
	const msgCn = $('#chatMsgCn').val();
	const dsptch = userId;
	
	stompChat.send('/pub/chatRoom',{}, JSON.stringify({
		userId:dsptch,
		chatRmNo:chatRmNo,
		chatMsgCn:msgCn,
	}));
	
	$('#chatMsgCn').val('');
});

//채팅창 닫기
$('#chat-modal-close').click(()=>{
	$('#modal-chatroom').modal('hide');
});
