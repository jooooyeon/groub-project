<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="row g-3 d-flex">

	<div class="mx-auto col-md-6 p-3 g-0">
		<div class="d-flex p-0" style="height: 280px">
			<div class="card mb-2 " style="width: 217px">
				<div class="card-header">
					<div class="row flex-between-end">
						<div class="col-auto align-self-center">
							<h3 class="mb-0 card-title">근태관리</h3>
						</div>
					</div>
				</div>
				<div class="card-body py-0">
					<div class="card shadow-none">
						<div class="card-body p-0 pb-3">

	                        <!-- 날짜 -->
	                        <div id="date" style="font-size: 18px; font-family: Arial; color: #dcdcdc; text-align: center;"></div>
	                        <!-- 시간 -->
	                        <div id="clock" style="font-size: 45px; font-family: Arial; color: #1e90ff; text-align: center;"></div>
	                        <!-- 출퇴근버튼 -->
						    <div class="btn-group col-12 mb-3" role="group">
								<c:choose>
			                        <c:when test="${empty atdcToday.dclzNo}">
			                            <button class="btn btn-sm btn-primary" id="startButton" onclick="startWork()">
			                                <span class="d-md-inline-block">출근하기</span>
			                            </button>
			                            <button class="btn btn-sm btn-secondary" id="endButton" onclick="endWork()" disabled>
			                                <span class="d-md-inline-block">퇴근하기</span>
			                            </button>
			                        </c:when>
			                        <c:when test="${not empty atdcToday.dclzNo && empty atdcToday.lvffcDt}">
			                            <button class="btn btn-sm btn-primary" id="startButton" onclick="startWork()" disabled>
			                                <span class="d-md-inline-block">출근하기</span>
			                            </button>
			                            <button class="btn btn-sm btn-secondary" id="endButton" onclick="endWork()" >
			                                <span class="d-md-inline-block">퇴근하기</span>
			                            </button>
			                        </c:when>
			                        <c:when test="${not empty atdcToday.lvffcDt}">
			                            <button class="btn btn-sm btn-primary" id="startButton" onclick="startWork()" disabled>
			                                <span class="d-md-inline-block">출근하기</span>
			                            </button>
			                            <button class="btn btn-sm btn-secondary" id="endButton" onclick="endWork()" disabled>
			                                <span class="d-md-inline-block">퇴근하기</span>
			                            </button>
			                        </c:when>
								</c:choose>
							</div>


						</div>
					</div>
				</div>
			</div>
			<div class="card mb-2 ms-2 flex-fill">
				<div class="card-header">
					<div class="row flex-between-end">
						<div class="col-auto align-self-center">
							<h3 class="mb-0 card-title">예약내역</h3>
						</div>
					</div>
				</div>
				<div class="card-body py-0">
					<div class="card shadow-none">
						<div class="card-body p-0 pb-3 table-responsive scrollbar">
							<table class="table">
								<colgroup>
									<col width="10%">
									<col width="50%">
									<col width="40%">
								</colgroup>
								<tr>
									<td class="bg-primary-subtle text-center">구분</td>
									<td class="bg-primary-subtle text-center">예약</td>
									<td class="bg-primary-subtle text-center">시간</td>
								</tr>
								<c:forEach var="data" items="${offmList}" varStatus="stat">
								<tr>
									<td class="ps-3 text-center" ><span class="badge badge-subtle-secondary">Room</span></td>
									<td class="ps-3 text-center" >${data.offmNm}</td>
									<td class="text-center">${data.strtRsvtDt}</td>
								</tr>
								</c:forEach>
								<c:forEach var="data" items="${vhclList}" varStatus="stat">
								<tr>
									<td class="ps-3 text-center" ><span class="badge badge-subtle-primary">Car</span></td>
									<td class="ps-3 text-center" >${data.vhclNo}</td>
									<td class="text-center">${data.strtRsvtDt}</td>
								</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- ///////////////일정////////////// -->
		<div class="card mb-2 mx-auto" style="">
			<div class="card-header pb-0">
				<div class="row flex-between-end">
					<div class="col-auto align-self-center">
						<div class="card-title p-0 pb-1">일정</div>
					</div>
				</div>
			</div>
			<div class="card-body">
				<span class="badge badge-subtle-danger">전사일정</span>
				<span class="badge badge-subtle-primary">팀일정</span>
				<span class="badge badge-subtle-success">개인일정</span>
				<div class="card shadow-none">
					<div class="tab-pane preview-tab-pane active" role="tabpanel"
						aria-labelledby="tab-dom-d119274c-28f2-4f9b-a522-5ff7a03cee30"
						id="dom-d119274c-28f2-4f9b-a522-5ff7a03cee30">
						<div id="calendar"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- ///////////////일정////////////// -->

	</div>

	<div class="row mx-auto col-md-6 p-3 ps-0">

		<div class="d-flex p-0 " style="height: 280px">

			<div class="card mb-2 ">
				<div class="card-header">
					<div class="row flex-between-end">
						<div class="col-auto align-self-center">
							<h3 class="card-title mb-0">기안 정보</h3>
						</div>
					</div>
				</div>
				<div class="card-body py-0">
					<div class="card shadow-none">
						<div class="card-body p-0 pb-3">
							<div class="row g-0 text-center fs--1">
								<div class="col">
									<div class="bg-white dark__bg-1100 p-3 h-100">
										<a href="/draft/doc?category=during">
										<i class="fa-solid fa-file-arrow-up fa-5x" style="color: #2c7be5;"></i>
										</a>
										<h6 class="mb-1 mt-3">
											<a href="/draft/doc?category=during">진행 중 문서</a>
										</h6>
										<p class="fs--2 mb-1">
											<a class="text-700" href="#!">5건</a>
										</p>
									</div>
								</div>
								<div class="col">
									<div class="bg-white dark__bg-1100 p-3 h-100">
										<a href="/draft/doc/atrz">
											<i class="fa-solid fa-file-signature fa-5x ps-3" style="color: #2c7be5;"></i>
										</a>

										<h6 class="mb-1 mt-3">
											<a href="/draft/doc/atrz">결재 예정 문서</a>
										</h6>
										<p class="fs--2 mb-1">
											<a class="text-700" href="#!">6건</a>
										</p>
									</div>
								</div>
							</div>
<!-- 							<a href="/draft/doc?category=during">진행 중 문서</a> -->
<!-- 							<a href="/draft/doc/atrz">결재 예정 문서</a> -->

						</div>
					</div>
				</div>
			</div>

			<div class="card mb-2 flex-fill ms-2">
				<div class="card header p-2">
					<div class="card shadow-none">
						<div class="card-title p-0 pb-1">점심 메뉴 추천</div>
							<div class="card-body p-2">
							<div class="row">
			                    <select class="form-select" id="yy_eat" onchange="yyEatPrint(this.value);" style="width:135px;" >
			                        <option selected="">그제 메뉴</option>
			                        <option value="M00">백반</option>
			                        <option value="M01">냉면</option>
			                        <option value="M02">닭갈비</option>
			                        <option value="M03">된장찌개</option>
			                        <option value="M04">짜장면</option>
			                        <option value="M05">짬뽕</option>
			                        <option value="M06">순대국밥</option>
			                        <option value="M07">파스타</option>
			                        <option value="M08">쌀국수</option>
			                        <option value="M09">케밥</option>
			                        <option value="M10">설렁탕</option>
			                        <option value="M11">돈까스</option>
			                        <option value="M12">갈비탕</option>
			                        <option value="M13">부대찌개</option>
			                        <option value="M14">돼지불고기</option>
			                        <option value="M15">칼국수</option>
			                        <option value="M16">김밥</option>
			                        <option value="M17">마라탕</option>
			                        <option value="M18">생선구이</option>
			                        <option value="M19">햄버거</option>
			                    </select>
			                    <br/>
			                    <select class="form-select" id="y_eat" onchange="yEatPrint(this.value);" style="width:135px;" >
			                        <option selected="">어제 메뉴</option>
			                        <option value="M00">백반</option>
			                        <option value="M01">냉면</option>
			                        <option value="M02">닭갈비</option>
			                        <option value="M03">된장찌개</option>
			                        <option value="M04">짜장면</option>
			                        <option value="M05">짬뽕</option>
			                        <option value="M06">순대국밥</option>
			                        <option value="M07">파스타</option>
			                        <option value="M08">쌀국수</option>
			                        <option value="M09">케밥</option>
			                        <option value="M10">설렁탕</option>
			                        <option value="M11">돈까스</option>
			                        <option value="M12">갈비탕</option>
			                        <option value="M13">부대찌개</option>
			                        <option value="M14">돼지불고기</option>
			                        <option value="M15">칼국수</option>
			                        <option value="M16">김밥</option>
			                        <option value="M17">마라탕</option>
			                        <option value="M18">생선구이</option>
			                        <option value="M19">햄버거</option>
			                    </select>
			                </div>
			                <br/>
			                <form id="dataGo" action="http://127.0.0.1:5000/menu" method="post" >
			                	<input type="hidden" id="yyEatInput" name="yyEatInput" />
			                	<input type="hidden" id="yEatInput" name="yEatInput" />
			                <button class="btn btn-primary" type="button" onclick="gogo()">오늘의 메뉴는?</button>
			                <sec:csrfInput/>
			                </form>
			                <div class="mb-3">
			                	<br/>
								<input class="form-control" id="tEat1" type="text" placeholder="맛점!" style="width:100px;" readonly /><br/>
							</div>
						</div>	
					</div>
				</div>
			</div>

		</div>

		<div class="card mb-2">
			<div class="card-body p-0 py-2">
				<div class="card shadow-none">
					<div class="card-title p-0 pb-1">공지사항</div>
					<table class="border border-2">
						<colgroup>
							<col width="70%">
							<col width="30%">
						</colgroup>
						<tr>
							<td class="bg-primary-subtle text-center">제목</td>
							<td class="bg-primary-subtle text-center">게시일</td>
						</tr>
						<c:forEach var="data" items="${noticeList }" varStatus="stat">
						<tr class="border border-2">
							<td class="ps-3" style="cursor: pointer;" onclick="noticeDetail(${data.pstNo})">${data.pstTtl}</td>
							<td class="text-center">${data.date2String(data.regDt)}</td>
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

			<div class="card mb-2">
				<div class="card-header">
					<div class="row flex-between-end">
						<div class="col-auto align-self-center p-0">
							<div class="card-title p-0 pb-1">AI 경제전망
								<span class="fs--2 ms-1 text-primary" data-bs-toggle="tooltip" data-bs-placement="top" aria-label="Only The group of selected people can see your profile"
								data-bs-original-title="시계열 예측 모델 중 하나인 LSTM에 50영업일 가격정보를 입력하여 예측된 가격전망에 대한 그래프">
								<svg class="svg-inline--fa fa-question-circle fa-w-16" aria-hidden="true" focusable="false" data-prefix="fas"
								data-icon="question-circle" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="">
								<path fill="currentColor" d="M504 256c0 136.997-111.043 248-248 248S8 392.997 8 256C8 119.083 119.043 8 256 8s248 111.083 248 248zM262.655 90c-54.497 0-89.255 22.957-116.549 63.758-3.536 5.286-2.353 12.415 2.715 16.258l34.699 26.31c5.205 3.947 12.621 3.008 16.665-2.122 17.864-22.658 30.113-35.797 57.303-35.797 20.429 0 45.698 13.148 45.698 32.958 0 14.976-12.363 22.667-32.534 33.976C247.128 238.528 216 254.941 216 296v4c0 6.627 5.373 12 12 12h56c6.627 0 12-5.373 12-12v-1.333c0-28.462 83.186-29.647 83.186-106.667 0-58.002-60.165-102-116.531-102zM256 338c-25.365 0-46 20.635-46 46 0 25.364 20.635 46 46 46s46-20.636 46-46c0-25.365-20.635-46-46-46z"></path></svg><!-- <span class="fas fa-question-circle"></span> Font Awesome fontawesome.com --></span>
							</div>
							<div class="d-flex justify-content-end">
			                    <div class="col-auto">
			                      <select id="selectStock" class="form-select form-select-sm select-month me-2">
			                        <option name="selectStock" selected="selected" value="KS11">코스피</option>
			                        <option name="selectStock" value="KQ11">코스닥</option>
			                      </select>
			                    </div>
		                    </div>
						</div>
					</div>
				</div>
				<div class="card-body">
					<div class="card shadow-none">
						<div class="card-body p-0 pb-3" id="prChart"></div>
						<canvas class="max-w-100" id="myChart1" style="display: block; box-sizing: border-box; height: 288.8px; width: 468px;"></canvas>
					</div>
				</div>
			</div>


	</div>
</div>



<input type="hidden" id="userId" value="<sec:authentication property="principal.userVO.userId"/>" />
<input type="hidden" id="deptNo" value="<sec:authentication property="principal.userVO.deptNo"/>" />
<input type="hidden" id="coId" value="<sec:authentication property="principal.userVO.coId"/>" />

<!--공지사항-->
<script>
function noticeDetail(res){
	console.log(res);
	window.location.href = '/notice/detail?pstNo=' + res;
}
</script>


<!-- ///////////////////// 일정 시작 ///////////////////// -->
<script>
	$(function() {
		// FullCalendar 캘린더 생성 함수를 정의합니다.
		function createCalendar(data) {
			var calendarEl = document.getElementById('calendar');
			var calendar = new FullCalendar.Calendar(calendarEl, {
				height: 560,
				contentHeight: 350,
				slotMinTime : '08:00',
				slotMaxTime : '20:00',
				headerToolbar : {
					  start: '',
					  center: '',
					  end: ''
				},
				initialView : 'dayGridMonth',
				events : data,
				locale : 'ko'
			});
			calendar.render();
		};//createCalendar끝

		var userId = document.getElementById('userId');
		var deptNo = document.getElementById('deptNo');
		var coId = document.getElementById('coId');

		var checkedValues = [
			userId.value
			, deptNo.value
			, coId.value
		];

		fetchCalendarData();

		// FullCalendar 캘린더를 생성하기 위해 필요한 데이터를 가져오는 함수입니다.
		function fetchCalendarData() {
			var request = $.ajax({
				url : "/schedule/list2Home/",
				method : "POST",
				dataType : "JSON",
				traditional : true,
				async : false,
				data : {
					checkedValues : checkedValues
				},
				beforeSend : function(xhr) {
					xhr.setRequestHeader("${_csrf.headerName}",
							"${_csrf.token}");
				}
			});

			request.done(function(data) {
				createCalendar(data);
			});
		}
	});
</script>
<style>
  /* Reduce the font size for the entire calendar */
  #calendar {
    font-size: 8px;
  }

  /* Reduce the font size for the day and time in the calendar cells */
  .fc-time,
  .fc-daygrid-day-number {
    font-size: 8px;
  }

  /* Hide the day of the week header */
  .fc-day-header {
    display: none;
  }
</style>
<!-- ///////////////////// 일정 끝 ///////////////////// -->
<!-- ///////////////////// 주식 시작 ///////////////////// -->

<script>
$(function(){

	var selectStock  = document.getElementById("selectStock");
	var value1 = (selectStock.options[selectStock.selectedIndex].value);

	let sym1 = {"symbol":value1};

	$.ajax({
        url: "/ai/economy/chartEtc",
        async: true,
        //data: JSON.stringify(data),
        type: "GET",
        dataType:"json",
        data: sym1,
        contentType: "application/json; charset=utf-8",
        success:function(data){
            var salelist=[];
            var predlist=[];
            var datelist=[];

            $.each(data,function(){
                salelist.push(this["close"])
                predlist.push(this["pred"])
                datelist.push(this["date"])
            })

            salelist = salelist.slice(0,7);
            datelist = datelist.slice(0,7);
            predlist = predlist.slice(0,7);


            salelist = salelist.reverse();
            predlist = predlist.reverse();
            datelist = datelist.reverse();
            const ctx1 = document.getElementById('myChart1').getContext('2d');
            const myChart1 = new Chart(ctx1,{
                type: 'line',
                data: {
                        labels: datelist,
                        datasets: [{
                            label: data[0]['detail'],
                            data: salelist,
                            backgroundColor: [
                            	'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)'
                            ],
                            borderColor: [
                            	'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)'
                            ],
                            borderWidth: 3
                        },
                        {label: "Prediction",
                            data: predlist,
                            backgroundColor: [
                            	'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)'
                            ],
                            borderColor: [
                            	'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)'
                            ],
                            borderWidth: 3
                            }
                        ]
                    },
                options: {
                    scales: {
                        y: {
                            beginAtZero: false
                        }
                    }
                }

            }//ctx앞
            )//new Chart끝
        }//석세스종료
	})//아작스 종료

});//온로드 펑션 종료

$(document).on("change", "#selectStock", function(){

	var selectStock  = document.getElementById("selectStock");
	var value1 = (selectStock.options[selectStock.selectedIndex].value);

	let sym1 = {"symbol":value1};

	$.ajax({
        url: "/ai/economy/chartEtc",
        async: true,
        data: sym1,
        type: "GET",
        dataType:"json",
        contentType: "application/json; charset=utf-8",
        success:function(data){
            var salelist=[];
            var predlist=[];
            var datelist=[];

            $.each(data,function(){
                salelist.push(this["close"])
                predlist.push(this["pred"])
                datelist.push(this["date"])
            })

            salelist = salelist.slice(0,7);
            datelist = datelist.slice(0,7);
            predlist = predlist.slice(0,7);


            salelist = salelist.reverse();
            predlist = predlist.reverse();
            datelist = datelist.reverse();

            $('#myChart1').remove();
            $('#prChart').append('<canvas class="max-w-100" id="myChart1" style="display: block; box-sizing: border-box; height: 288.8px; width: 468px;"></canvas>');

            const ctx1 = document.getElementById('myChart1').getContext('2d');
            const myChart1 = new Chart(ctx1,{
                type: 'line',
                data: {
                    labels: datelist,
                    datasets: [{
                        label: data[0]['detail'],
                        data: salelist,
                        backgroundColor: [
                        	'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)'
                        ],
                        borderColor: [
                        	'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)', 'rgba(75, 192, 192, 1)'
                        ],
                        borderWidth: 3
                    },
                    {label: "Prediction",
                        data: predlist,
                        backgroundColor: [
                        	'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)'
                        ],
                        borderColor: [
                        	'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 99, 132, 1)'
                        ],
                        borderWidth: 3
                        }
                    ]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: false
                        }
                    }
                }

            }//ctx앞
            )//new Chart끝
        }//석세스종료
	})//아작스 종료
	});


</script>

<!-- ///////////////////// 주식 끝 ///////////////////// -->
<!-- ///////////////////////////////////////// 근태 시작이용 ///////////////////////////////////////// -->


<script>
var clock = document.querySelector("#clock");
var dateElement = document.querySelector("#date");
var attendDtElement = document.querySelector("#attendDt");  //출근시간
var lvffcDtElement = document.querySelector("#lvffcDt");      //퇴근시간
var workDurationElement = document.querySelector("#workDuration");    //근무시간
var startButton = document.querySelector("#startButton");             //출근하기 버튼
var endButton = document.querySelector("#endButton");         		  //퇴근하기 버튼
var workLog = []; // 근무 시간 기록 배열
var startTime; // 출근 시간 저장 변수
var csrfToken = $("input[name='_csrf']").val();
var todayNo = document.querySelector("#dclzNo");

function getClock() {
	const d = new Date();

	var h = String(d.getHours()).padStart(2, "0");
	var m = String(d.getMinutes()).padStart(2, "0");
	var s = String(d.getSeconds()).padStart(2, "0");
	clock.innerText = h + ":" + m + ":" + s;
	s
	var year = d.getFullYear();
    var month = String(d.getMonth() + 1).padStart(2, "0");
    var day = String(d.getDate()).padStart(2, "0");

	var dateInfo = year + "-" + month + "-" + day;
	dateElement.innerText = dateInfo;
}
getClock(); //맨처음에 한번 실행
setInterval(getClock, 1000); //1초 주기로 새로실행

function startWork(){

	startTime = new Date();

	var startTimeString = formatTime(startTime);
	var workEntry = document.createElement("div");
	workEntry.innerText = startTimeString;

	attendDtElement.insertAdjacentHTML('afterbegin',workEntry.outerHTML);

//		document.getElementById('frm').submit();

	// Ajax를 이용해서 출근시간을 컨트롤러로 보내서 컨트롤러에서는
	// 출근시간을 받아서 지각 여부를 확인하고 세션에서 로그인한 회원ID를 구한 후
	//  DB 에 Insert한다.

	$.ajax({
		type : 'post',
		url : '/attendance/insert', //서버에서 데이터를 처리할 URL로 변경
		headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'X-CSRF-TOKEN': csrfToken
        },
		success : function(data){
			console.log('출근 데이터 갔당');
			location.reload(); // 페이지 새로고침
			alert("출근완료");
		}, error: function (error) {
            console.error('땡!!!!!!!!!', error);
        }
	});

}


function endWork() {
	endTime = new Date();

	var workHours = (endTime - startTime) / 1000 / 60 / 60; //근무시간
	console.log("퇴근하기@@@@@@");
	//시간이 마이너스면 0으로 출력
//		if (workHours < 0) {
//         workHours = 0;
//     }

	var endTimeString = formatTime(endTime);
	var workEntry = document.createElement("div");
	lvffcDtElement.innerText = endTimeString;
	lvffcDtElement.insertAdjacentHTML('afterbegin',workEntry.outerHTML);


	$.ajax({
		type : 'post',
		url : '/attendance/update', //서버에서 데이터를 처리할 URL로 변경
		data : {"dclzNo" : todayNo.value},
		headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'X-CSRF-TOKEN': csrfToken
        },
		success : function(data){
			console.log('퇴근 데이터 갔당');
			location.reload(); // 페이지 새로고침
			alert("퇴근완료");
		}, error: function (error) {
            console.error('땡!!!!!!!!!', error);
        }
	});

	//데이터 전송
//		document.getElementById('frm').submit();
}


//실시간 시간 출력
function formatTime(time) {
    var hour = String(time.getHours()).padStart(2, "0");
    var minute = String(time.getMinutes()).padStart(2, "0");
    var second = String(time.getSeconds()).padStart(2, "0");
    return hour + ":" + minute + ":" + second;
 }



</script>

<!-- ///////////////////////////////////////// 근태 끝이용 ///////////////////////////////////////// -->
<!-- ///////////////////////////////////////// 점메추 시작이용 ///////////////////////////////////////// -->
<script>
	var yyEatPrint = function(value){
// 		console.log("엊그제 메뉴: " + value);
		$("#yyEatInput").val(value);
	}
	var yEatPrint = function(value){
// 		console.log("어제 메뉴: " + value);
		$("#yEatInput").val(value);
	}

    function gogo() {
        var data = {
			yyEatInput: $("#yyEatInput").val(),
			yEatInput: $("#yEatInput").val()
		};
//         console.log("data",data);

		// ajax를 이용해서 flask와 데이터 주고 받기
    	$.ajax({
    		// flask와 연결
    		url : 'http://127.0.0.1:5000/menu.ajax',
    		type : "POST",
    		data : data,
    		dataType : "json",
    		success : function(resp) {
//     			console.log(resp);
				// json형태로 받아온 값을 하나씩 뽑아내기
    			$("#tEat1").val(resp.menu1);
    			$("#tEat2").val(resp.menu2);
    			$("#tEat3").val(resp.menu3);

    		},
    		error : function() {
//     			alert('메뉴를 선택해주세요.');
    		}
    	});


      }

</script>





<!-- ///////////////////////////////////////// 점메추 끝이용 ///////////////////////////////////////// -->






