<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />
<link rel="stylesheet" href="/resources/css/chat.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>

<script>
  var jQuery1x = jQuery.noConflict();
</script>

<style>

</style>
<!-- footer 시작 -->
<footer class="footer">
	<div class="row g-0 justify-content-between fs--1 mt-4 mb-3">
		<div class="col-12 col-sm-auto text-center">
			<p class="mb-0 text-600">
				Thank you for creating with Falcon <span class="d-none d-sm-inline-block">| </span><br class="d-sm-none" />
				2023 &copy; <a href="https://themewagon.com">Themewagon</a>
			</p>
		</div>
		<div class="col-12 col-sm-auto text-center"></div>
	</div>
</footer>
<!-- footer 끝 -->

<!-- 사용자 목록 모달 시작 -->
<div class="modal modal-center fade" id="user-list" tabindex="-1" role="dialog" aria-labelledby="myCenterModalLabel">
	<div class="modal-dialog modal-center" role="document">
		<div class="modal-content user-list">
			<div class="card" id="searchBox" style="height: 1000px;">
				<div class="card-header border border-ligth">
					<h3 class="mb-3">사용자 목록</h3>
					<div>
						<i class="fa-solid fa-magnifying-glass"> 사원을 검색하세요.</i>
					</div>
					<input type="text" id="search1" placeholder="이름을 입력하세요.">
				</div>
				<div class="card-body" style="overflow-x:hidden; overflow-y:auto;">
					<div class="" id="jstree1"></div>
				</div>
				<div class="card-footer" id="idCard1"></div>
			</div>
    	</div>
  	</div>
</div> 
<!-- 사용자 목록 모달 끝 -->

<!-- offcanvas 채팅방 목록 시작 -->
<div class="offcanvas offcanvas-end" data-bs-scroll="true" tabindex="-1" data-bs-backdrop="false" id="off-chatlist" aria-labelledby="offcanvasScrollingLabel" style="border:0; background: none;">
	<div class="card" style="height: 100%;">
		<div class="card-header d-flex justify-content-between border border-light"> 
			<h3>채팅방 목록</h3>
			<button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		</div>
		<div class="w-100 card-body" style="height: 100%;">
			<div class="d-flex justify-content-end">
				<a class="mt-auto cursor-pointer" id="user-list-btn">사용자 목록 보기</a>
			</div>
			<div class="w-100 card-body">
				<ul class="w-100" id="off-chat-list">
				</ul>
			</div>
		</div>
		<div class="card-footer"></div>
	</div>
</div>
<!-- offcanvas 채팅방 목록 끝 -->

<!-- modal 채팅창 시작 -->
<div class="modal fade" id="modal-chatroom" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="true">
	<div class="modal-dialog" style="max-width: 600px;" role="document">
		<div class="modal-content" style="background: transparent; border: none;">
			<div class="modal-body">
				<!-- modal body 시작 -->
					<div class="container" style="background: none;">
						<div class="row d-flex justify-content-center">
							<div class="">
								<div class="card" id="chat1" style="height:600px; border-radius: 15px;">
									<div class="card-header d-flex justify-content-between align-items-center p-3 bg-info text-white border-bottom-0" style="border-top-left-radius: 15px; border-top-right-radius: 15px;">
										<i class="fas fa-angle-left"></i>
										<p class="mb-0 fw-bold">Live chat</p>
										<a class="btn btn-outline" id="chat-modal-close">
											<i class="fas fa-times"></i>
										</a>
									</div>
									<div class="card-body" style="500px;">
										<div class="card ms-2" id="modal-chatlist" style="width: 95%; height: 400px; overflow-y: auto;"></div>
										<div class="form-outline d-flex justify-content-between mt-3" style="overflow-y:auto;">
											<textarea class="ms-2 form-control" id="chatMsgCn" rows="3"  style="overflow-y:auto;"></textarea>
											<a class="btn btn-outline btn-sm mt-auto" id="modal-chat-send"><i class="fas fa-paper-plane fa-lg"></i></a>
										</div>
									</div>
								</div>

							</div>
						</div>

					</div>
				<!-- modal body 끝 -->
			</div>
		</div>
	</div>
</div>
<!-- modal 채팅창 끝 -->

<!-- toast 알림 시작 -->
<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
  <div id="liveToast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true">
    <div class="toast-header">
<!--       <img src="#" class="rounded me-2" alt="..."> -->
      <strong class="me-auto alarm-ttl">알람 왔어요</strong>
      <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
    </div>
    <div class="toast-body">
      Hello, world! This is a toast message.
    </div>
  </div>
</div>
<!-- toast 알림 끝 -->

<script>
var html = '';
let userData;

var sockJs = new SockJS("/ws");
var stomp = Stomp.over(sockJs);
stomp.debug = null;

var receiver = $('#receiver');

stomp.connect({}, function() {
	stomp.subscribe("/sub/alarm/" + userId, function(chat) {
		var content = JSON.parse(chat.body);
		alarmText(content);
		alarmInit();
	});
	
	stomp.subscribe("/sub/noticeAlarm", function(chat) {
		alarmInit();
		
		var content = JSON.parse(chat.body); 
		$('.alarm-ttl').html(content.memoTtl);
		$('.toast-body').html(content.memoCn);
		$('#liveToast').toast('show');
		
	})
	
	stomp.subscribe("/sub/userData", function(chat) {
		var content = JSON.parse(chat.body); 
		if (content) {
			userData = content;
		}
	})
});

function alarmInit(){
	
	//초기 종모양 알람 세팅
	$.ajax({
		url:'/msg/alarm',
		type:'get',
		data:{
			userId: userId
		},
		success:(res)=>{
			res.forEach((e,i)=>{
				let html = ``;
				if(e.statCd=='MM006'){
					$('#noti-alarm').addClass('notification-indicator notification-indicator-warning');
					html = ``;
					html += `
						<div class="list-group-item">
							<a class="notification notification-flush notification-unread" href="`;
							
					if(e.memoTtl=='결재') html += "/draft/doc/atrz";
					else if(e.memoTtl=='결재완료') html += "/draft/doc?category=during";
					else if(e.memoTtl=='쪽지') html += "/msg/inbox";
					else if(e.memoTtl=='기안') html += "/draft/doc/atrz";
					else if(e.memoTtl=='설문조사') html += "/servey/serveyList";
					else if(e.memoTtl=='메일') html += "/mail/inbox";
					else if(e.memoTtl=='일정') html += "/schedule/list";
					else html += "/notice/list";
							
					html += 
							`">
								<div class="notification-body">
									<p class="mb-1">
										<strong>`+e.memoTtl+`</strong>
									</p>
									<span class="notification-time memo-no" data-memono="`+e.memoNo+`"><span class="me-2 fab fa-gratipay text-danger"></span>`+e.memoCn+`</span>
								</div>
							</a>
						</div>
					`;
					$('#alarm-new').append(html);
				}else{
					html = ``;
					html += `
						<div class="list-group-item">
							<a class="border-bottom-0 notification-unread  notification notification-flush" href="`;
							
					if(e.memoTtl=='결재') html += "/draft/doc/atrz";
					else if(e.memoTtl=='결재완료') html += "/draft/doc?category=during";
					else if(e.memoTtl=='쪽지') html += "/msg/inbox";
					else if(e.memoTtl=='기안') html += "/draft/doc/atrz";
					else if(e.memoTtl=='설문조사') html += "/servey/serveyList";
					else if(e.memoTtl=='메일') html += "/mail/inbox";
					else if(e.memoTtl=='일정') html += "/schedule/list";
					else html += "/notice/list";
					
					html += 		
							`">
								<div class="notification-body">
									<p class="mb-1">
									<strong>`+e.memoTtl+`</strong>
									</p>
									<span class="notification-time"><span class="me-2" role="img" aria-label="Emoji"></span>`+e.memoCn+`</span>
								</div>
							</a>
						</div>
					`
					$('#alarm-old').append(html);
				}
			});
		},
	});
}

document.addEventListener('DOMContentLoaded',()=>{
	alarmInit();
	if(document.querySelector('#alarm-new').querySelectorAll('.list-group-item').length>0) $('#noti-alarm').addClass('notification-indicator notification-indicator-warning');
});


document.querySelector('#alarm-read').addEventListener('click',(e)=>{
	$.ajax({
		url:'/msg/readAll',
		type:'get',
		data:{
			userId:userId,
		},
		success:(r)=>{
			$.ajax({
				url:'/msg/alarm',
				type:'get',
				data:{
					userId: userId
				},
				success:(res)=>{
					$('#alarm-new').html('새로운 알람');
					$('#alarm-old').html('읽은 알람');
					alarmInit();
				},
			});
		},
	});
});

function alarmText(content){
	if (content) {
		if(content.msg!=''&&content.msg!=null){
			$('.toast-body').html(content.msg);
			$('#liveToast').toast('show');
		}
	}
}
</script>

<!-- 채팅 소켓 -->
<script src="/resources/js/chat-js/socket.js"></script>
<!-- 사용자 리스트 -->
<script src="/resources/js/chat-js/user-list.js"></script>
<!-- 사용자 대화방 리스트 -->
<script src="/resources/js/chat-js/chat-list.js"></script>
<!-- 채팅방 추가 -->
<script src="/resources/js/chat-js/room-add.js"></script>
