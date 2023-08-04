<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script type="text/javascript" src="/resources/falcon/src/js/jquery-3.6.4.min.js"></script>
<style>
@import 'https://fonts.googleapis.com/icon?family=Material+Icons|Roboto'
	;

.recorder_wrapper {
	width: 100%;
	display: -webkit-flex;
	display: -moz-flex;
	display: -ms-flex;
	display: -o-flex;
	display: flex;
	align-items: center;
	justify-content: center;
	width: 100%;
	height: 100%;
}

.recorder {
	display: inline-block;
	text-align: center;
	width: 500px;
	max-width: 100%;
}

.record_btn {
	width: 100px;
	height: 100px;
	font-family: 'Material Icons';
	font-size: 48px;
	color: #e74c3c;
	background: none;
	border: 2px solid #e74c3c;
	border-radius: 50%;
	cursor: pointer;
	transition: 0.15s linear;
}

.record_btn:hover {
	transition: 0.15s linear;
	transform: scale(1.05);
}

.record_btn:active {
	background: #f5f5f5;
}

.record_btn:after {
	content: '\E029';
}

.record_btn[disabled] {
	border: 2px solid #ccc;
}

.record_btn[disabled]:after {
	content: '\E02B';
	color: #ccc;
}

.record_btn[disabled]:hover {
	transition: 0.15s linear;
	transform: none;
}

.record_btn[disabled]:active {
	background: none;
}

.recording {
	animation: recording 2s infinite ease-in-out;
	position: relative;
}

.recording:before {
	content: '';
	display: inline-block;
	position: absolute;
	top: 50%;
	left: 50%;
	width: 0px;
	height: 0px;
	margin: 0px;
	border-radius: 50%;
	background: rgba(0, 0, 0, 0.05);
	animation: recording_before 2s infinite ease-in-out;
}

@
keyframes recording {from { transform:scale(1.1);

}

50
%
{
transform
:
none;
}
to {
	transform: scale(1.1);
}

}
@
keyframes recording_before { 80% {
	width: 200px;
	height: 200px;
	margin: -100px;
	opacity: 0;
}

to {
	opacity: 0;
}

}
.record_canvas {
	width: 60px;
	height: 100px;
	display: inline-block;
}

.txt_btn {
	color: #000;
	text-decoration: none;
	transition: 0.15s linear;
	animation: text_btn 0.3s ease-in-out;
}
</style>


	<div class="row flex-center min-vh-100 py-6">
		<div class="col-sm-10 col-md-8 col-lg-6 col-xl-5 col-xxl-4"><a class="d-flex flex-center mb-4" href="/"><img class="me-2" src="/resources/image/groub.png" alt="" width="200" /><span class="font-sans-serif fw-bolder fs-5 d-inline-block"></span></a>
		<div class="card">
			<div class="card-body p-4 p-sm-5">
			<div class="row flex-between-center mb-2">
				<div class="col-auto">
				<h5>Log in</h5>
				</div>
			</div>
				<form:form modelAttribute="userVO" action="/login" method="post">
					<div class="mb-3">
						<input id="userIdLogin" class="form-control" name="username" type="text" placeholder="사원번호"
							value="${userId}" required maxlength="20" />
					</div>
					<div class="mb-3">
						<input id="userPswdLogin" class="form-control" name="password" type="password" placeholder="비밀번호"
							value="java" required />
					</div>
					<div class="row flex-between-center">
					<div>
						${error}&nbsp;
					</div>
						<div class="col-auto">
							<div class="form-check mb-0">
								<input class="form-check-input" name="remember-me" type="checkbox"
									id="remember" />
								<label class="form-check-label mb-0" for="remember">자동 로그인</label>
							</div>
						</div>
						<div class="col-auto">
							<button type="button" class="btn btn-link fs--1" data-bs-toggle="modal"
								data-bs-target="#findPw">비밀번호를 잊으셨나요?</button>
						</div>
					</div>
					<div class="mb-3">
						<button id="frmBtn" class="btn btn-primary d-block w-100 mt-3" type="submit"
							name="submit">Log in</button>
					</div>
					<sec:csrfInput />
				</form:form>
				<div class="position-relative mt-4">
					<hr>
					<div class="divider-content-center">or log in with</div>
				</div>
				<div class="row g-2 mt-2">
					<div class="col-sm-6">
						<button type="button" id="faceAuth" data-bs-toggle="modal" data-bs-target="#error-modal"
							class="btn btn-outline-facebook btn-sm d-block w-100"><span
								class="far fa-smile me-2" data-fa-transform="grow-8"></span>얼굴인증</button>
					</div>
					<div class="col-sm-6">
						<button type="button" id="voiceAuth" data-bs-toggle="modal"
							data-bs-target="#voice-modal"
							class="btn btn-outline-google-plus btn-sm d-block w-100"><span
								class="fas fa-microphone-alt me-2"
								data-fa-transform="grow-8"></span>음성인증</button>
					</div>
				</div>
				<div class="row g-2 mt-2">
					<button id="userChange1" class="btn btn-outline-primary me-1 mb-1" type="button">유저:
						NAVER_2014030001</button>
					<button id="userChange2" class="btn btn-outline-primary me-1 mb-1" type="button">유저:
						NAVER_2023060001</button>
					<button id="userChange3" class="btn btn-outline-primary me-1 mb-1" type="button">유저:
						NAVER_2023060008</button>
				</div>
			</div>
		</div>
	</div>



<!-- 얼굴인식 로그인을 위한 모달창 -->

<div class="modal fade" id="error-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document" style="max-width: 500px">
    <div class="modal-content position-relative">
      <div class="position-absolute top-0 end-0 mt-2 me-2 z-1">
        <button class="btn-close btn btn-sm btn-circle d-flex flex-center transition-base" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body p-0">
        <div class="p-4 pb-0">
          <form>
            <div class="mb-3">
              <label class="col-form-label" for="recipient-name">사원번호</label>
              <input class="form-control" id="faceId" type="text" />
            </div>
            <div class="mb-3">
              <label class="col-form-label" for="message-text">얼굴인식</label>
              <video class="form-control" id="video" width="640" height="480" autoplay></video>
            </div>
          </form>
        </div>
      </div>
      <div class="modal-footer">
        <button id="faceBtn" class="btn btn-primary" type="button">로그인</button>
        <button class="btn btn-secondary" type="button" data-bs-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>


<!-- 음성인식 로그인을 위한 모달창 -->

<div class="modal fade" id="voice-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document" style="max-width: 500px">
    <div class="modal-content position-relative">
      <div class="position-absolute top-0 end-0 mt-2 me-2 z-1">
        <button class="btn-close btn btn-sm btn-circle d-flex flex-center transition-base" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body p-0">
        <div class="p-4 pb-0">
          <form>
            <div class="mb-3">
              <label class="col-form-label" for="recipient-name">사원번호</label>
              <input class="form-control" id="voiceId" type="text" />
            </div>
            <div class="mb-3">
              <label class="col-form-label" for="message-text">음성인식</label>
              <div style="width:100%; " class="border p-3">


              	<div class="recorder_wrapper">
						<div class="recorder">
							<button class="record_btn" type="button" id="button"></button>
							<p id="msg_box"></p>
						</div>
					</div>
					<div class="d-flex justify-content-center">
						<div id="lod">
						</div>
					</div>

					<div class="mb-3 uploadDiv ">
						<input class="form-control d-none" id="formFileMultiple" type="file"
							multiple="multiple" name="uploadFile" />
					</div>
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="modal-footer">
        <button id="voiceBtn" class="btn btn-primary" type="button">로그인</button>
        <button class="btn btn-secondary" type="button" data-bs-dismiss="modal">닫기</button>
      </div>
      		<div id="liveAlertPlaceholder"></div>
    </div>
  </div>
</div>

<!--임시 비번 모달-->
<div id="findPw" class="modal fade">
	<div class="modal-dialog modal-dialog-centered modal-login">
		<div class="modal-body">
			<div class="card">
				<div class="card-body p-4 p-sm-5">
					<h5 class="mb-0">임시비밀번호</h5>
					<form class="mt-4" name="findPwEmail" action="/forgotPswd"
						method="post">
						<label class="form-label" for="findPwUserId">아이디</label> <input
							class="form-control" name="findPwUserId" id="findPwUserId"
							type="text" placeholder="사원번호" required /> <label
							class="form-label" for="findPwUserEmail">이메일</label> <input
							class="form-control" name="findPwUserEmail" id="findPwUserEmail"
							type="email" placeholder="이메일 주소" required />
						<div class="mb-3"></div>
						<small>사원번호와 인증된 이메일을 입력하십시오</small>
						<button id="checkEmail" type="button"
							class="btn btn-primary d-block w-100 mt-3">임시비밀번호 발송</button>
						<sec:csrfInput />
					</form>
				</div>
			</div>
		</div>
	</div>
</div>






<script type="text/javascript">
$("#faceAuth").on("click", function() {
	var video = document.getElementById('video');
    var faceBtn = document.getElementById('faceBtn');
    var canvas = document.createElement('canvas');
    var context = canvas.getContext('2d');
    var userId = document.getElementById('userIdLogin').value;
    var formData = new FormData();
	var csrfToken = document.querySelector("input[name='_csrf']").value;

    document.getElementById('faceId').value = userId;

    navigator.mediaDevices.getUserMedia({ video: true }).then(function(stream) {
   	videoStream = stream;
    video.srcObject = stream;
    video.play();
    })
    .catch(function(error) {
    	console.error(error);
    });

    faceBtn.onclick = function() {
        var userId = document.getElementById('faceId').value;
        document.getElementById('userIdLogin').value = userId;
        captureAndSend();
    };

	function captureAndSend() {
	    return new Promise(function(resolve, reject) {
	    	function captureFrame() {
			    canvas.width = video.videoWidth;
			    canvas.height = video.videoHeight;
			    context.drawImage(video, 0, 0, canvas.width, canvas.height);
			    canvas.toBlob(function(blob) {
	                formData.delete('file');
	                formData.delete('user_id');
					formData.append('file', blob, 'login.jpg');
					formData.append('user_id', document.getElementById('userIdLogin').value);
					console.log(formData);
			        $.ajax({
			        	url: "http://127.0.0.1:5000/login.ajax",
						processData: false,
						contentType: false,
						data: formData,
						type: "POST",
						success: function(response) {
				        	console.log(response.message);
 				        	if (response.message == 'success') {
 				        		document.getElementById('userIdLogin').value = response.userId;
 				        		document.getElementById('userPswdLogin').value = response.userPswd;
 				        		document.getElementById("frmBtn").click();
				        	} else if (response.message == 'fail') {
				        		alert('얼굴이 일치하지 않습니다.');
				        	} else {
				        		alert('얼굴 인식을 등록하지 않았습니다.');
				        	}
				    	}
            		});//ajax끝
            		resolve();
	    		}, 'image/jpeg', 0.9);
	    	}
   			captureFrame();
		});
  	}
});


$("#error-modal").on("hidden.bs.modal", function() {
    var video = document.getElementById('video');
	faceBtn.innerText = "로그인";
    if (videoStream) {
        var tracks = videoStream.getTracks();
        tracks.forEach(function(track) {
            track.stop(); // 비디오 스트림의 트랙을 중지
        });
    }
    video.srcObject = null;
});
</script>

<script type="text/javascript">
	const userIdLogin = $("#userIdLogin")[0];

		$("#userChange1").on("click", function() {
			userIdLogin.value = 'NAVER_2014030001';
		});
		$("#userChange2").on("click", function() {
			userIdLogin.value = 'NAVER_2023060001';
		});
		$("#userChange3").on("click", function() {
			userIdLogin.value = 'NAVER_2023060008';
		});

</script>

<!-- 음성인식  -->
<script type="text/javascript">

let media;

var msg_box = document.getElementById( 'msg_box' ),
button = document.getElementById( 'button' ),
canvas = document.getElementById( 'canvas' ),
lang = {
	'mic_error': 'Error accessing the microphone',
	'press_to_start': '버튼을 누르고 [바나나]라고 말씀해 주세요',
	'recording': 'Recording',
	'play': 'Play',
	'stop': 'Stop',
	'download': 'Download',
	'use_https': 'This application in not working over insecure connection. Try to use HTTPS'
},
time;


msg_box.innerHTML = lang.press_to_start;

if ( navigator.mediaDevices === undefined ) {
	navigator.mediaDevices = {};
}


if ( navigator.mediaDevices.getUserMedia === undefined ) {
	navigator.mediaDevices.getUserMedia = function ( constrains ) {
	    var getUserMedia = navigator.webkitGetUserMedia || navigator.mozGetUserMedia
	    if ( !getUserMedia )  {
	        return Promise.reject( new Error( 'getUserMedia is not implemented in this browser' ) );
	    }

	    return new Promise( function( resolve, reject ) {
	        getUserMedia.call( navigator, constrains, resolve, reject );
	    } );
	}
}


if ( navigator.mediaDevices.getUserMedia ) {
	var btn_status = 'inactive',
	    mediaRecorder,
	    chunks = [],
	    audio = new Audio(),
	    mediaStream,
	    audioSrc,
	    type = {
	        'type': 'audio/wav,codecs=opus'
	    },
	    ctx,
	    analys,
	    blob;

	button.onclick = function () {
	    if ( btn_status == 'inactive' ) {
	        start();
	    } else if ( btn_status == 'recording' ) {
	        stop();
	    }
	}

	function parseTime( sec ) {
	    var h = parseInt( sec / 3600 );
	    var m = parseInt( sec / 60 );
	    var sec = sec - ( h * 3600 + m * 60 );

	    h = h == 0 ? '' : h + ':';
	    sec = sec < 10 ? '0' + sec : sec;

	    return h + m + ':' + sec;
	}


	function start() {
	    navigator.mediaDevices.getUserMedia( { 'audio': true } ).then( function ( stream ) {
	        mediaRecorder = new MediaRecorder( stream );
	        mediaRecorder.start();

	        button.classList.add( 'recording' );
	        btn_status = 'recording';

	        msg_box.innerHTML = lang.recording;

	        if ( navigator.vibrate ) navigator.vibrate( 150 );

	        time = Math.ceil( new Date().getTime() / 1000 );


	        mediaRecorder.ondataavailable = function ( event ) {
	            chunks.push( event.data );
	        }

	        mediaRecorder.onstop = function () {
	            stream.getTracks().forEach( function( track ) { track.stop() } );

	            blob = new Blob( chunks, type );
	            audioSrc = window.URL.createObjectURL( blob );

	            audio.src = audioSrc;

	            chunks = [];
	        }



	    } ).catch( function ( error ) {
	        if ( location.protocol != 'https:' ) {
	          msg_box.innerHTML = lang.mic_error + '<br>'  + lang.use_https;
	        } else {
	          msg_box.innerHTML = lang.mic_error;
	        }
	        button.disabled = true;
	    });
	}

	function stop() {
		console.log("mediaRecorder",mediaRecorder);
	    mediaRecorder.stop();
	    button.classList.remove( 'recording' );
	    btn_status = 'inactive';

	    if ( navigator.vibrate ) navigator.vibrate( [ 200, 100, 200 ] );

	    var now = Math.ceil( new Date().getTime() / 1000 );

	    var t = parseTime( now - time );

	    msg_box.innerHTML = '<a href="#" onclick="play(); return false;" class="txt_btn">' + lang.play + ' (' + t + 's)</a><br>' +
	                        '<a href="#" onclick="save(); return false;" class="txt_btn">' + lang.download + '</a>'

        mediaRecorder.ondataavailable = function(event) {
            if (event.data && event.data.size > 0) {
                var blob = event.data;
                var file = new File([blob], 'record.wav', { type: 'audio/wav' });
                media = file;
                }

            }
	}



	function play() {
	    audio.play();
	    msg_box.innerHTML = '<a href="#" onclick="pause(); return false;" class="txt_btn">' + lang.stop + '</a><br>' +
	                        '<a href="#" onclick="save(); return false;" class="txt_btn">' + lang.download + '</a>';
	}

	function pause() {
	    audio.pause();
	    audio.currentTime = 0;
	    msg_box.innerHTML = '<a href="#" onclick="play(); return false;" class="txt_btn">' + lang.play + '</a><br>' +
	                        '<a href="#" onclick="save(); return false;" class="txt_btn">' + lang.download + '</a>'
	}

	function roundedRect(ctx, x, y, width, height, radius, fill) {
	    ctx.beginPath();
	    ctx.moveTo(x, y + radius);
	    ctx.lineTo(x, y + height - radius);
	    ctx.quadraticCurveTo(x, y + height, x + radius, y + height);
	    ctx.lineTo(x + width - radius, y + height);
	    ctx.quadraticCurveTo(x + width, y + height, x + width, y + height - radius);
	    ctx.lineTo(x + width, y + radius);
	    ctx.quadraticCurveTo(x + width, y, x + width - radius, y);
	    ctx.lineTo(x + radius, y);
	    ctx.quadraticCurveTo(x, y, x, y + radius);

	    ctx.fillStyle = fill;
	    ctx.fill();
	}

	function save() {
	    var a = document.createElement( 'a' );
	    a.download = 'record.wav';
	    a.href = audioSrc;
	    document.body.appendChild( a );
	    a.click();

	    document.body.removeChild( a );
	}

} else {
	if ( location.protocol != 'https:' ) {
	  msg_box.innerHTML = lang.mic_error + '<br>'  + lang.use_https;
	} else {
	  msg_box.innerHTML = lang.mic_error;
	}
	button.disabled = true;
}



$("#voiceId").val('NAVER_2014030001');

//var loginIdSession = '${loginId}'
	//console.log(loginIdSession)

	//파이썬으로 보내기
	$("#voiceBtn").click(function() {

		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		console.log("files",files);
		//console.log("loginIdSession",loginIdSession);

		var memId = $("#voiceId").val();
		console.log("memId" , memId);
		var formData = new FormData();
		formData.append('mem_id', memId);
		console.log("media[0].files",media);

		formData.append("my_file", media);
		$.ajax({
			url: 'http://127.0.0.1:5000/login2.ajax',
			type: 'POST',
			data: formData,
			contentType: false,
			processData: false,
			success: function(response) {
				if (response.message == 'success') {
		        		document.getElementById('userIdLogin').value = response.userId;
		        		document.getElementById('userPswdLogin').value = response.userPswd;
		        		document.getElementById("frmBtn").click();
	        	} else if (response.message == 'fail') {
	        		$("#lod").html("");
	        		alert1();
	        	} else {
	        		$("#lod").html("");
	        		alert2();
	        	}
			}
		})



	});


	$("#voiceBtn").on("click", function() {

		var lod = `<div class="spinner-border text-primary" role="status">
					<span class="visually-hidden">Loading...</span>
					</div>`
			$("#lod").html(lod);
	});


	const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
	//음성파일인식이 잘 되지 않았을 때 띄울 알림창
	const alert1 = () => {
		alertPlaceholder.innerHTML = [
	    '<div class="alert alert-danger border-2 d-flex align-items-center" role="alert">',
	    '	<div class="bg-danger me-3 icon-item"><span class="fas fa-times-circle text-white fs-3"></span></div>',
	    '   <p class="mb-0 flex-1">음성이 일치하지 않습니다.</p>',
	    '   <button type="button" class="btn-close"  data-bs-dismiss="alert" aria-label="Close"></button>',
	    '</div>'
	  ].join('');


	    setTimeout(() => {
	        alertPlaceholder.innerHTML = '';
	      }, 3000);
	}

	const alert2 = () => {
		alertPlaceholder.innerHTML = [
	    '<div class="alert alert-danger border-2 d-flex align-items-center" role="alert">',
	    '	<div class="bg-danger me-3 icon-item"><span class="fas fa-times-circle text-white fs-3"></span></div>',
	    '   <p class="mb-0 flex-1">음성 인식을 등록하지 않았습니다.</p>',
	    '   <button type="button" class="btn-close"  data-bs-dismiss="alert" aria-label="Close"></button>',
	    '</div>'
	  ].join('');


	    setTimeout(() => {
	        alertPlaceholder.innerHTML = '';
	      }, 3000);
	}


</script>

<!-- 임시비밀번호 발송 처리 script -->
<script>
    $("#checkEmail").click(function () {
        const findUserId  = $("#findPwUserId").val();
        const findUserEmail = $("#findPwUserEmail").val();
        const findSendEmail = document.forms["findPwEmail"];
    	var csrfToken = document.querySelector("input[name='_csrf']").value;
        $.ajax({
            method: 'post',
            url: '/forgotPswd/checkEmail',
            data: {
                "findUserId": findUserId,
                "findUserEmail": findUserEmail
            },
			headers: {
	            'Content-Type': 'application/x-www-form-urlencoded',
	            'X-CSRF-TOKEN': csrfToken
	        },
            dataType: "text",
            success: function (result) {
                if(result == "yes"){
                    alert('임시비밀번호를 전송 했습니다.');
                    findSendEmail.submit();
                } else if (result == "noMatch"){
                    alert('이메일이 일치하지 않습니다.');
                } else if (result == "no") {
                	alert('아이디가 존재하지 않습니다.')
                }

            },error: function () {
                console.log('에러 체크!!')
            }
        })
    });
</script>
