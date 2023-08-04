<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	
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


<div class="container">
	<input id="mem_id" type="hidden" value="<sec:authentication property="principal.username"/>" />
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.userVO.userId" var="loginId" />
		<sec:authentication property="principal.userVO.userNm" var="loginName" />
	</sec:authorize>
	<div class="row">
		<div class="col-md-9">
			<div class="card mb-2" id="card-container">
	    		<!-- 내정보 메인 -->
				<div class="card-body" id="contentHome">
					<h5 class="card-title">기본정보</h5>
					<table class="table">
						<colgroup>
							<col style="width: 25%">
							<col style="width: 35%">
							<col style="width: 40%">
						</colgroup>
						<tbody>
							<tr>
								<td class="align-middle">이름</td>
								<td class="align-middle">${userVO.userNm }</td>
								<td rowspan="5"><img class="rounded-3" src="${userVO.userImg}" width="100%" height="220px" style="object-fit: cover;" /></td>
							</tr>
	
							<tr>
								<td class="align-middle">사번</td>
								<td id="trUsrId" class="align-middle">${userVO.userId }</td>
							</tr>
							
							<tr>
								<td class="align-middle">핸드폰번호</td>
								<td id="userTelno" class="align-middle">${userVO.userTelno }</td>
							</tr>
							
							<tr>
								<td class="align-middle">성별</td>
								<c:if test="${userVO.gndrMf == 'M'}">
									<td class="align-middle ">남성</td>
								</c:if>
								<c:if test="${userVO.gndrMf == 'W'}">
									<td class="align-middle ">여성</td>
								</c:if>
							</tr>
	
							<tr>
								<td class="align-middle">생일</td>
								<td class="align-middle"><fmt:formatDate value="${userVO.brthYmd }" pattern="yyyy-MM-dd" /></td>
							</tr>
	
							<tr>
								<td class="align-middle">입사일</td>
								<td id="trJoinYmd" class="align-middle">${userVO.jncmpYmd }</td>
								<td rowspan="4"><img class="rounded-3" src="${userVO.signImg}" width="100%" style="object-fit: cover;">
							</tr>
							
							<tr>
								<td class="align-middle">부서</td>
								<td class="align-middle">${userVO.deptNm }</td>
							</tr>
							
							<tr>
								<td class="align-middle">직급</td>
								<td class="align-middle">${userVO.jbgdNm }</td>
							
							</tr>
	
							<tr>
								<td class=부서ign-middle">직무</td>
								<td class="align-middle">${userVO.jbtlNm }</td>
				            </tr>
	       			   </tbody>
	        	</table>
	        </div> 
	        <!-- 내정보 메인 끝 -->
	      
	        <!-- 사진정보변경에 대한 카드 내용 시작 -->
	        <div class="card-body" id="content1" style="display: none;">
	        	<h5 class="card-title">사진 정보 변경</h5>
	        	<table class="table text-center" >
	          		<tbody>
	            		<tr> 
	             			<td><img class="rounded-3" src="${userVO.userImg}" width="70%"  style="object-fit: cover;"></td>
	            		</tr>
	            		<tr> 
	              			<td>
								<form id="personpicForm" action="/mypage/personpic" method="post" enctype="multipart/form-data">
									<input class="form-control" id="personpic" name="personpic" type="file" />
									<button id="btnRegPersonPic" class="btn btn-secondary me-3 text-center mt-3" type="submit">저장</button>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								</form>
	              			</td>
	            		</tr>
					</tbody>
				</table>
	        </div>
	        <!-- 사진정보변경에 대한 카드 내용 끝  -->
	        
	        <!-- 서명정보변경에 대한 카드 내용 시작 -->
	        <div class="card-body" id="content5" style="display: none;">
	        	<h5 class="card-title">서명 정보 변경</h5>
	        	<table class="table text-center" >
	          		<tbody>
	            		<tr> 
	             			<td><img class="rounded-3" src="${userVO.signImg}" width="70%"  style="object-fit: cover;"></td>
	            		</tr>
	            		<tr> 
	              			<td>
								<form id="signForm" action="/mypage/regSign" method="post" enctype="multipart/form-data">
									<input class="form-control" id="regSign" name="regSign" type="file" />
									<button id="btnRegSign" class="btn btn-secondary me-3 text-center mt-3" type="submit">저장</button>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								</form>
	              			</td>
	            		</tr>
					</tbody>
				</table>
	        </div>
	        <!-- 서명정보변경에 대한 카드 내용 끝  -->
	        
	        <!-- 비밀번호변경에 대한 카드 내용 시작 -->
	        <div class="card-body" id="content2" style="display: none;">
	        	<h5 class="card-title mb-4">비밀번호 변경</h5>
	       		<div class="row mb-3">
					<div>
						<label class="col-form-label" for="passwordNow">현재 비밀번호</label>
					</div>
					<div>
						<input class="form-control" id="passwordNow" type="password" required="required"/>
					</div>
				</div>
	       		<div class="row mb-3">
					<div>
						<label class="col-form-label" for="passwordNew">새로운 비밀번호</label>
					</div>
					<div>
						<input class="form-control" id="passwordNew" type="password" required="required" />
					</div>
				</div>
	       		<div class="row mb-3">
					<div>
						<label class="col-form-label" for="passwordNewCheck">비밀번호 확인</label>
					</div>
					<div>
						<input class="form-control" id="passwordNewCheck" type="password" required="required"/>
					</div>
				</div>
				<button id="btnRegPersonPic" class="btn btn-secondary me-3 text-center mt-3" onclick="changePw()" type="submit">저장</button>
				<div id="liveAlertPlaceholderPassword"></div>
	        </div>
	        <!-- 비밀번호변경에 대한 카드 내용 끝 -->
	        
	        <!-- 얼굴인식에 대한 카드 내용 시작 -->
	        <div class="card-body" id="content3" style="display: none;">
	        	<h5 class="card-title">얼굴인식 변경</h5>
	        	<label id="faceLabel" class="col-form-label" for="message-text"></label>
				<video class="form-control" id="video" width="640" height="480" autoplay></video>
	        	<c:choose>
					<c:when test="${userVO.faceYn == 'N'}">
						<button class="btn btn-primary me-1 mb-1" id="captureBtn">얼굴인식 다시등록</button>
					</c:when>
					<c:when test="${userVO.faceYn == 'Y'}">
						<button class="btn btn-primary me-1 mb-1" id="captureBtn">얼굴인식 다시등록</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-primary me-1 mb-1" id="captureBtn">얼굴인식 등록하기</button>
					</c:otherwise>
				</c:choose>
	
				<c:choose>
					<c:when test="${userVO.faceYn == 'N'}">
						<button id="btnOpen" onclick="changeFaceY('${userVO.userId}')"
							class="btn btn-success me-1 mb-1">얼굴인식 활성화</button>
					</c:when>
					<c:when test="${userVO.faceYn == 'Y'}">
						<button id="btnClose" onclick="changeFaceN('${userVO.userId}')"
							class="btn btn-danger me-1 mb-1">얼굴인식 비활성화</button>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
	        </div>
	        <!-- 얼굴인식에 대한 카드 내용 끝 -->
	        
	        <!-- 음성인식에 대한 카드 내용시작 -->
	        <div class="card-body" id="content4" style="display: none;">
	          	<h5 class="card-title">음성인식 등록 및 변경</h5>
		        <div class="border p-3">
		          	<p>음성인식 기능을 사용하기 위해서 녹음을 해주세요</p>
					<div class="recorder_wrapper">
						<div class="recorder">
							<button class="record_btn" id="button"></button>
							<p id="msg_box"></p>
						</div>
					</div>
					 <div class="d-flex justify-content-center">
						<div id="lod"></div>
					</div>
					<p>최소 3개 이상의 녹음한 음성을 첨부하여 전송해 주세요</p>
					<div class="mb-3 uploadDiv">
						<input class="form-control" id="formFileMultiple" type="file" multiple="multiple" name="uploadFile" />
					</div>
					<div style="display: flex; justify-content: center;">
						<button id="uploadBtn" class="btn btn-secondary me-3 text-center ">전송</button>
					</div>
		        </div>
		        <br /> <br /> <br />
				<div id="liveAlertPlaceholder"></div>
	        </div>
	        <!-- 음성인식에 대한 카드 내용끝 -->
	      </div><!-- card-container 끝 -->
	    </div><!-- class="col-md-9 끝 -->
	    
	    
	    
		<div class="col-md-3">
			<div class="card mb-2">
	    		<div class="card-body">
					<!-- 사이드바 항목 -->
					<div class="table-responsive">
	        			<table class="table">
							<colgroup>
								<col style="width: 30%">
								<col style="width: 70%">
							</colgroup>
							<tbody>
								<tr>
									<td style="padding: 0; margin: 0; display: flex; justify-content: center; align-items: center; vertical-align: middle;">
										<div style="width: 60px; height: 60px; overflow: hidden;">
											<img class="rounded-circle" src="${userVO.userImg}" width="100%" height="100%" style="object-fit: cover;">
								  		</div>
									</td>
									<td class="cursor-pointer" style="vertical-align: middle;" onclick="goToContentHome()">${userVO.userNm}</td>
								</tr>
		          			</tbody>
	        			</table>
	      			</div>
	
					<ul class="list-group cursor-pointer">
						<li class="list-group-item sidebar-item border-0" data-content="content1">사진 정보 변경</li>
						<li class="list-group-item sidebar-item border-0" data-content="content5">서명 정보 변경</li>
						<li class="list-group-item sidebar-item border-0" data-content="content2">비밀번호 변경</li>
						<li class="list-group-item sidebar-item border-0" data-content="content3">얼굴인식 등록 및 변경</li>
						<li class="list-group-item sidebar-item border-0" data-content="content4">음성인식 등록 및 변경</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
var userPswd = "${userVO.userPswd}";
//유저 비밀번호 변경
function changePw() {
    var passwordNowInput = document.getElementById('passwordNow');
    var passwordNow = passwordNowInput.value;
    var passwordNew = document.getElementById('passwordNew').value;
    var passwordNewCheck = document.getElementById('passwordNewCheck').value;
    

    
    // 현재 비밀번호 일치 여부 검증
    var correctPassword = userPswd; // 실제로는 현재 비밀번호를 가져와야 합니다

    if (passwordNow.length === 0) {
        console.log("현재 비밀번호를 입력해주세요.");
        pwAlert();
        return;
    }

    if (passwordNow !== correctPassword) {
        console.log("현재 비밀번호가 일치하지 않습니다.");
        pwAlert2();
        return;
    }
    

    
 // 비밀번호 확인 유효성 검사
    if (passwordNew === '') {
        console.log("새로운 비밀번호를 입력해주세요.");
        pwAlert3();       
        return;
    }
 
    // 새로운 비밀번호 유효성 검사
    var reg = /^(?=.*[a-zA-Z])(?=.*[0-9]).{5,25}$/;
    if (!reg.test(passwordNew)) {
        console.log("영문자와 숫자를 조합하여 5~25자리로 입력해주세요.");
        pwAlert4();   
        return;
    }
    
 // 비밀번호 확인 유효성 검사
    if (passwordNewCheck === '') {
        console.log("비밀번호 확인을 입력해주세요.");
        pwAlert5();   
        return;
    }
    
 
    // 비밀번호 일치 여부 검증
    if (passwordNew !== passwordNewCheck) {
        console.log("새로운 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        pwAlert6();   
        return;
    }
    
	console.log("비밀번호 변경 완료");
    console.log(passwordNew)
    
    var loginIdSession = '${loginId}'
    console.log("로그인아이디!" ,loginIdSession );
    var data = {
    	"userId" : loginIdSession,
    	"userPswd" : passwordNew
    }
    console.log("나는 보낼 데이터!! : " ,data)
    
	$.ajax({
		url : "/mypage/changePw",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(data),
		type : "post",
		dataType : "text",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("${_csrf.headerName}",
					"${_csrf.token}");
		},
		success : function(result) {
			console.log("나는 돌아온 아작스!!")
		    pwAlert7(); 
	
		},
		error : function(xhr, status, error) {
			console.log("에러 발생:", error);
		}
	
	}); //ajax
   
}


const alertPlaceholderPW = document.getElementById('liveAlertPlaceholderPassword');
//비밀번호변경 오류 띄울 알림창
const pwAlert = () => {
	alertPlaceholderPW.innerHTML = [
  '<div class="alert alert-danger border-2 d-flex align-items-center" role="alert">',
  '	<div class="bg-danger me-3 icon-item"><span class="fas fa-times-circle text-white fs-3"></span></div>',
  '   <p class="mb-0 flex-1">현재 비밀번호를 입력해주세요.</p>',
  '   <button type="button" class="btn-close"  data-bs-dismiss="alert" aria-label="Close"></button>',
  '</div>'
].join('');	
	
  setTimeout(() => {
	  alertPlaceholderPW.innerHTML = '';
    }, 2000);
}

const pwAlert2 = () => {
	alertPlaceholderPW.innerHTML = [
  '<div class="alert alert-danger border-2 d-flex align-items-center" role="alert">',
  '	<div class="bg-danger me-3 icon-item"><span class="fas fa-times-circle text-white fs-3"></span></div>',
  '   <p class="mb-0 flex-1">현재 비밀번호가 일치하지 않습니다.</p>',
  '   <button type="button" class="btn-close"  data-bs-dismiss="alert" aria-label="Close"></button>',
  '</div>'
].join('');
	
	
  setTimeout(() => {
	  alertPlaceholderPW.innerHTML = '';
    }, 2000);
}

const pwAlert3 = () => {
	alertPlaceholderPW.innerHTML = [
  '<div class="alert alert-danger border-2 d-flex align-items-center" role="alert">',
  '	<div class="bg-danger me-3 icon-item"><span class="fas fa-times-circle text-white fs-3"></span></div>',
  '   <p class="mb-0 flex-1">새로운 비밀번호를 입력해주세요.</p>',
  '   <button type="button" class="btn-close"  data-bs-dismiss="alert" aria-label="Close"></button>',
  '</div>'
].join('');
	
	
  setTimeout(() => {
	  alertPlaceholderPW.innerHTML = '';
    }, 2000);
}

const pwAlert4 = () => {
	alertPlaceholderPW.innerHTML = [
  '<div class="alert alert-danger border-2 d-flex align-items-center" role="alert">',
  '	<div class="bg-danger me-3 icon-item"><span class="fas fa-times-circle text-white fs-3"></span></div>',
  '   <p class="mb-0 flex-1">영문자와 숫자를 조합하여 5~25자리로 입력해주세요.</p>',
  '   <button type="button" class="btn-close"  data-bs-dismiss="alert" aria-label="Close"></button>',
  '</div>'
].join('');
	
	
  setTimeout(() => {
	  alertPlaceholderPW.innerHTML = '';
    }, 2000);
}
const pwAlert5 = () => {
	alertPlaceholderPW.innerHTML = [
  '<div class="alert alert-danger border-2 d-flex align-items-center" role="alert">',
  '	<div class="bg-danger me-3 icon-item"><span class="fas fa-times-circle text-white fs-3"></span></div>',
  '   <p class="mb-0 flex-1">비밀번호 확인을 입력해주세요.</p>',
  '   <button type="button" class="btn-close"  data-bs-dismiss="alert" aria-label="Close"></button>',
  '</div>'
].join('');
	
	
  setTimeout(() => {
	  alertPlaceholderPW.innerHTML = '';
    }, 2000);
}
const pwAlert6 = () => {
	alertPlaceholderPW.innerHTML = [
  '<div class="alert alert-danger border-2 d-flex align-items-center" role="alert">',
  '	<div class="bg-danger me-3 icon-item"><span class="fas fa-times-circle text-white fs-3"></span></div>',
  '   <p class="mb-0 flex-1">새로운 비밀번호와 비밀번호 확인이 일치하지 않습니다.</p>',
  '   <button type="button" class="btn-close"  data-bs-dismiss="alert" aria-label="Close"></button>',
  '</div>'
].join('');
	
	
  setTimeout(() => {
	  alertPlaceholderPW.innerHTML = '';
    }, 2000);
}


const pwAlert7 = () => {
	alertPlaceholderPW.innerHTML = [
  '<div class="alert alert-success border-2 d-flex align-items-center" role="alert">',
  '<div class="bg-success me-3 icon-item"><span class="fas fa-check-circle text-white fs-3"></span></div>',
  '<p class="mb-0 flex-1">비밀번호 변경 완료.</p>',
  '<button class="btn-close" type="button" data-bs-dismiss="alert" aria-label="Close"></button>',
'</div>'
  
].join('');	
	
  setTimeout(() => {
	  alertPlaceholderPW.innerHTML = '';
    }, 2000);
}









//전화번호 하이픈
var phoneNo = '${userVO.userTelno}'
	phoneNo = phoneNo.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
	//console.log(phoneNo)
	$("#userTelno").text(phoneNo);


//인물사진 변경
$('#personpicForm').submit(function(event) {
    event.preventDefault(); // 폼 제출 기본 동작 막기

    var formData = new FormData(this); // 폼 데이터 생성

    $.ajax({
        url: $(this).attr('action'), // 폼의 action 속성 값으로 URL 지정
        type: $(this).attr('method'), // 폼의 method 속성 값으로 요청 메서드 지정
        data: formData,
        processData: false,
        contentType: false,
        success: function(response) {
        	 setTimeout(function() {
        	        location.reload();
        	    }, 3000); // 1초(1000밀리초) 지연 후 페이지 새로고침
            // 파일 업로드 성공 시 페이지 새로고침
            location.reload();
        },
        error: function(xhr, status, error) {
        }
    });
});


//서명사진 변경
$('#signForm').submit(function(event) {
    event.preventDefault(); // 폼 제출 기본 동작 막기

    var formData = new FormData(this); // 폼 데이터 생성

    $.ajax({
        url: $(this).attr('action'), // 폼의 action 속성 값으로 URL 지정
        type: $(this).attr('method'), // 폼의 method 속성 값으로 요청 메서드 지정
        data: formData,
        processData: false,
        contentType: false,
        success: function(response) {
        	 setTimeout(function() {
        	        location.reload();
        	    }, 3000); // 1초(1000밀리초) 지연 후 페이지 새로고침
            // 파일 업로드 성공 시 페이지 새로고침
            location.reload();
        },
        error: function(xhr, status, error) {
        }
    });
});


//메인화면보이기
document.getElementById('contentHome').style.display = 'block';

// 사이드바 항목 클릭 이벤트 핸들러
var sidebarItems = document.getElementsByClassName('sidebar-item');
for (var i = 0; i < sidebarItems.length; i++) {
	sidebarItems[i].addEventListener('click', function() {
	    var contentId = this.getAttribute('data-content');
	    var cardContainer = document.getElementById('card-container');
	    var contentElements = cardContainer.getElementsByClassName('card-body');
	    for (var j = 0; j < contentElements.length; j++) {
	      if (contentElements[j].id === contentId) {
	        contentElements[j].style.display = 'block';
	      } else {
	        contentElements[j].style.display = 'none';
	      }
	    }
  });
}

//메인화면다시클릭
function goToContentHome() {
    var cardContainer = document.getElementById('card-container');
    var contentElements = cardContainer.getElementsByClassName('card-body');
    for (var i = 0; i < contentElements.length; i++) {
	    if (contentElements[i].id === 'contentHome') {
	      contentElements[i].style.display = 'block';
	    } else {
	      contentElements[i].style.display = 'none';
	    }
    }
  }



  
//사번 가져오기
 var trUsrIdElement = document.getElementById('trUsrId');
 var trUsrId = trUsrIdElement.innerText;
 trUsrId = trUsrId.split('_')[1];
 trUsrIdElement.innerText = trUsrId;
 
 //입사일 가져오기
 var trJoinYmdElement = document.getElementById('trJoinYmd');
 var trJoinYmd = trJoinYmdElement.innerText;
 trJoinYmd = trJoinYmd.split(' ')[0];
 trJoinYmdElement.innerText = trJoinYmd;
  
</script>


<!-- 얼굴인식 이미지 등록 작업 -->
<script type="text/javascript">
$(function() {
	var video = document.getElementById('video');
	var captureBtn = document.getElementById('captureBtn');
	var canvas = document.createElement('canvas');
	var context = canvas.getContext('2d');
	var formData = new FormData();

	navigator.mediaDevices.getUserMedia({ video: true }).then(function(stream) {
	video.srcObject = stream;
    video.play();
    })
    .catch(function(error) {
    	console.error(error);
	});

	captureBtn.addEventListener('click', function() {
		document.getElementById('faceLabel').innerText = "얼굴인식 및 데이터 만드는중..";
    	captureAndSend();
	});

	function captureAndSend() {
		return new Promise(function(resolve, reject) {
			var count = 0;
			function captureFrame() {
				canvas.width = video.videoWidth;
				canvas.height = video.videoHeight;
          		context.drawImage(video, 0, 0, canvas.width, canvas.height);
          		canvas.toBlob(function(blob) {
					formData.append('file[]', blob, count + '.jpg');
          	  		count++;
	          	  	if (count < 100) {
	          		  	setTimeout(captureFrame, 10);
	          	  	} else {
	            	  	formData.append('mem_id', document.getElementById('mem_id').value);
	            	  	$.ajax({
					  		url: "http://127.0.0.1:5000/capture.ajax",
					  		processData: false,
					  		contentType: false,
					  		data: formData,
					  		type: "POST",
					  		success: function(response) {
					  			console.log(response);
					  			document.getElementById('faceLabel').innerText = "서버에 저장중..";
					  			var data = {
					  				    memId : document.getElementById('mem_id').value
					  				};

					  			$.ajax({
					  			    url: "http://127.0.0.1/ddit/sign/signup",
					  			    data: JSON.stringify(data),
					  			    type: "POST",
					  			    contentType: 'application/json; charset=utf-8',
					  			    success: function(response) {
					  			        console.log(response);
					  			        document.getElementById('faceLabel').innerText = "완료!";
					  			        alert("인식정보 등록 성공!");
					  			        window.location.href = "/mypage";
					  			    },
					  			    error: function(xhr, status, error) {
					  			        console.error(xhr, status, error);
					  			    }
					  			});//ajax끝
					  		},
					  		error: function(xhr, status, error) {
					      		console.error(xhr, status, error);
							}
	                	});//ajax 끝
	                	resolve();
            		}//if끝
        		}, 'image/jpeg', 0.9);
   			}
   			captureFrame();
		});
  	}
});


function changeFaceY(userId) {
    if (!confirm(userId + " 얼굴인식 로그인을 활성화하시겠습니까?")) {
        alert("취소하였습니다.");
    } else {

	    var sendData = {"userId":userId}
		var csrfToken = $("input[name='_csrf']").val();

	    $.ajax({
	        url : '/mypage/faceAct',
	        data : sendData,
	        method : 'post',
			headers: {
	            'Content-Type': 'application/x-www-form-urlencoded',
	            'X-CSRF-TOKEN': csrfToken
	        },
	        success : function(resp){
	        	  // 버튼 변경
	        	  var openBtn = document.getElementById("btnOpen");
	        	  var closeBtn = document.createElement("button");
	        	  closeBtn.id = "btnClose";
	        	  closeBtn.onclick = function() {
	        	    changeFaceN('${userVO.userId}');
	        	  };
	        	  closeBtn.className = "btn btn-danger me-1 mb-1";
	        	  closeBtn.innerText = "얼굴인식 비활성화";

	        	  openBtn.parentNode.replaceChild(closeBtn, openBtn);
	        }
	    })
        alert("활성화 되었습니다.");
    }
}
function changeFaceN(userId) {
    if (!confirm(userId + " 얼굴인식 로그인을 비활성화하시겠습니까?")) {
        alert("취소하였습니다.");
    } else {

	    var sendData = {"userId":userId}
		var csrfToken = $("input[name='_csrf']").val();

	    $.ajax({
	        url : '/mypage/faceAct',
	        data : sendData,
	        method : 'post',
			headers: {
	            'Content-Type': 'application/x-www-form-urlencoded',
	            'X-CSRF-TOKEN': csrfToken
	        },
	        success : function(resp){
	        	  // 버튼 변경
	        	  var closeBtn = document.getElementById("btnClose");
	        	  var openBtn = document.createElement("button");
	        	  openBtn.id = "btnOpen";
	        	  openBtn.onclick = function() {
	        	    changeFaceY('${userVO.userId}');
	        	  };
	        	  openBtn.className = "btn btn-success me-1 mb-1";
	        	  openBtn.innerText = "얼굴인식 활성화";

	        	  closeBtn.parentNode.replaceChild(openBtn, closeBtn);
	        }
	    })
        alert("비활성화 되었습니다.");
    }
}



</script>


<!-- 음성인식  -->
<script type="text/javascript">
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
	    mediaRecorder.stop();
	    button.classList.remove( 'recording' );
	    btn_status = 'inactive';

	    if ( navigator.vibrate ) navigator.vibrate( [ 200, 100, 200 ] );

	    var now = Math.ceil( new Date().getTime() / 1000 );

	    var t = parseTime( now - time );

	    msg_box.innerHTML = '<a href="#" onclick="play(); return false;" class="txt_btn">' + lang.play + ' (' + t + 's)</a><br>' +
	                        '<a href="#" onclick="save(); return false;" class="txt_btn">' + lang.download + '</a>'


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




var loginIdSession = '${loginId}'
//console.log(loginIdSession)

//파이썬으로 보내기
$("#uploadBtn").click(function() {
	
	var inputFile = $("input[name='uploadFile']");
	var files = inputFile[0].files;
	console.log("files",files);
	
	var formData = new FormData();
	formData.append('mem_id', loginIdSession);
	for (var i = 0; i < files.length; i++) {
		formData.append("my_file", files[i]);
	}
	$.ajax({
		url: 'http://127.0.0.1:5000/capture2.ajax',
		type: 'POST',
		data: formData,
		contentType: false,
		processData: false,
		success: function(response) {
			console.log(response);
			$("#lod").html("");
			alert2();
			 setTimeout(() => {
			        alertPlaceholder.innerHTML = '';
			      }, 3000);
			
			location.href = "/mypage";
		},
		error : function(xhr, status, error) {
			console.log("에러 발생:", error);
			alert();
			
			$("#lod").html("");
		}
	})
	
	

});


//로딩 동그라미
$("#uploadBtn").on("click", function() {
	
	var lod = `<div class="spinner-border text-primary" role="status">
				<span class="visually-hidden">Loading...</span>
				</div>`
		$("#lod").html(lod);
});


const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
//음성파일인식이 잘 되지 않았을 때 띄울 알림창
const alert = () => {
	alertPlaceholder.innerHTML = [
    '<div class="alert alert-danger border-2 d-flex align-items-center" role="alert">',
    '	<div class="bg-danger me-3 icon-item"><span class="fas fa-times-circle text-white fs-3"></span></div>',
    '   <p class="mb-0 flex-1">음성파일을 다시 제출해 주세요.</p>',
    '   <button type="button" class="btn-close"  data-bs-dismiss="alert" aria-label="Close"></button>',
    '</div>'
  ].join('');
	
	
    setTimeout(() => {
        alertPlaceholder.innerHTML = '';
      }, 3000);
}

const alert2 = () => {
	alertPlaceholder.innerHTML = [
    '<div class="alert alert-success border-2 d-flex align-items-center" role="alert">',
    '<div class="bg-success me-3 icon-item"><span class="fas fa-check-circle text-white fs-3"></span></div>',
    '<p class="mb-0 flex-1">등록되었습니다</p>',
    '<button class="btn-close" type="button" data-bs-dismiss="alert" aria-label="Close"></button>',
 	 '</div>'
  ].join('');
	
	
    setTimeout(() => {
        alertPlaceholder.innerHTML = '';
      }, 3000);
}



</script>
