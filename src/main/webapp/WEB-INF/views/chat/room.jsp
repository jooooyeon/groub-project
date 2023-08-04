<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<style>
#modal.modal-overlay {
	width: 100%;
	height: 100%;
	position: absolute;
	left: 0;
	top: 0;
	display: none;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	background: rgba(255, 255, 255, 0.25);
	box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
	backdrop-filter: blur(1.5px);
	-webkit-backdrop-filter: blur(1.5px);
	border-radius: 10px;
	border: 1px solid rgba(255, 255, 255, 0.18);
}

#modal .modal-window {
	background: rgba(69, 139, 197, 0.70);
	box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
	backdrop-filter: blur(13.5px);
	-webkit-backdrop-filter: blur(13.5px);
	border-radius: 10px;
	border: 1px solid rgba(255, 255, 255, 0.18);
	width: 400px;
	height: 500px;
	position: relative;
	top: -100px;
	padding: 10px;
}

#modal .title {
	padding-left: 10px;
	display: inline;
	text-shadow: 1px 1px 2px gray;
	color: white;
}

#modal .title h2 {
	display: inline;
}

#modal .close-area {
	display: inline;
	float: right;
	padding-right: 10px;
	cursor: pointer;
	text-shadow: 1px 1px 2px gray;
	color: white;
}

#modal .content {
	margin-top: 20px;
	padding: 0px 10px;
	text-shadow: 1px 1px 2px gray;
	color: white;
}
</style>
<div class="container">
	<div class="col-6">
		<h1>${room.name}방</h1>
	</div>
	<div>
		<div id="msgArea" class="col"></div>
		<div class="col-6">
			<div class="input-group mb-3">
				<input type="text" id="msg" class="form-control">

				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="button"
						id="button-send">전송</button>
					<button class="btn btn-outline-secondary" type="button"
						id="button-out">나가기</button>
				</div>
				<div class="input-group mb-2">
					<button class="btn btn-outline-secondary" type="button"
						id="button-invite">초대하기</button>
				</div>

			</div>
		</div>
	</div>
	<div class="col-6"></div>
</div>

<!--  초대하기 위한 모달창  -->
<div id="modal" class="modal-overlay">
	<div class="modal-window">
		<div class="title">
			<h2>친구초대</h2>
		</div>
		<div class="close-area" id="close">x</div>
		<form></form>
	</div>
</div>

<script>

</script>
