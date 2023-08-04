<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="col-lg-12">
  <div class="card">
    <div class="card-header">
      <div class="row flex-between-end">
      <h3 id="carTitle" >일정 관리</h3>

        <div class="col-auto align-self-center">
		<div class="col-auto d-flex order-md-0">
		    <button class="btn btn-primary btn-sm" type="button" data-bs-toggle="modal" data-bs-target="#addEventModal">
		      <span class="fas fa-plus me-2"></span>일정등록
		    </button>
		</div>
		<div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" id="inlineCheckbox1" type="checkbox" value="<sec:authentication property="principal.userVO.coId"/>" checked />
			  <label class="form-check-label" for="inlineCheckbox1">전체일정</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" id="inlineCheckbox2" type="checkbox" value="<sec:authentication property="principal.userVO.deptNo"/>" checked />
			  <label class="form-check-label" for="inlineCheckbox2">팀일정</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" id="inlineCheckbox3" type="checkbox" value="<sec:authentication property="principal.userVO.userId"/>" checked />
			  <label class="form-check-label" for="inlineCheckbox3">개인일정</label>
			</div>
		</div>


        </div>
      </div>
    </div>
    <div class="card-body bg-light">
      <div class="tab-content">
        <div class="tab-pane preview-tab-pane active" role="tabpanel" aria-labelledby="tab-dom-d119274c-28f2-4f9b-a522-5ff7a03cee30" id="dom-d119274c-28f2-4f9b-a522-5ff7a03cee30">
         <div id="calendar"></div>
        </div>
      </div>
    </div>
  </div>
</div>
<input id="coId" type="hidden" value="<sec:authentication property="principal.userVO.coId"/>" >
<input id="userId" type="hidden" value="<sec:authentication property="principal.userVO.userId"/>" >






<!-- modal fade -->
<div class="modal fade" id="eventDetailsModal" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
	<div class="modal-content border"></div>
  </div>
</div>
<div class="modal fade" id="addEventModal" tabindex="-1">
  <div class="modal-dialog">
	<div class="modal-content border">
	  <form id="addEventForm" autocomplete="off">
		<div class="modal-header px-x1 bg-light border-bottom-0">
		  <h5 class="modal-title" ></h5>
		  <button class="btn-close me-n1" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
		</div>
		<div class="modal-body p-x1">
		  <div class="mb-3">
			<label class="fs-0" for="eventTitle">일정명</label>
			<input class="form-control" id="eventTitle" type="text" name="title" required="required" />
		  </div>
		  <div class="mb-3">
			<label class="fs-0" for="eventStartDate">시작일자</label>
			<input class="form-control datetimepicker" id="eventStartDate" type="text" required="required" name="startDate" placeholder="yyyy/mm/dd" data-options='{"static":"true","enableTime":"true","dateFormat":"Y-m-d H:i"}' />
		  </div>
		  <div class="mb-3">
			<label class="fs-0" for="eventEndDate">종료일자</label>
			<input class="form-control datetimepicker" id="eventEndDate" type="text" name="endDate" placeholder="yyyy/mm/dd" data-options='{"static":"true","enableTime":"true","dateFormat":"Y-m-d H:i"}' />
		  </div>
		  <div>
		  <div class="col-sm-5 mb-3" style="float:left;">
		  <label class="form-label" for="startTime">시작시간</label>
         	<select class="form-control" id="startTime" >
            <option value="09:00">09:00</option>
            <option value="09:30">09:30</option>
            <option value="10:00">10:00</option>
            <option value="10:30">10:30</option>
            <option value="11:00">11:00</option>
            <option value="11:30">11:30</option>
            <option value="12:00">12:00</option>
            <option value="12:30">12:30</option>
            <option value="13:00">13:00</option>
            <option value="13:30">13:30</option>
            <option value="14:00">14:00</option>
            <option value="14:30">14:30</option>
            <option value="15:00">15:00</option>
            <option value="15:30">15:30</option>
            <option value="16:00">16:00</option>
            <option value="16:30">16:30</option>
            <option value="17:00">17:00</option>
            <option value="17:30">17:30</option>
            <option value="18:00">18:00</option>
            <option value="18:30">18:30</option>
         </select>
        </div>
         <div class="col-sm-5 mb-3"style="float:right;">
         <label class="form-label" for="endTime">종료시간</label>
         <select class="form-control" id="endTime">
            <option value="09:30">09:30</option>
            <option value="10:00">10:00</option>
            <option value="10:30">10:30</option>
            <option value="11:00">11:00</option>
            <option value="11:30">11:30</option>
            <option value="12:00">12:00</option>
            <option value="12:30">12:30</option>
            <option value="13:00">13:00</option>
            <option value="13:30">13:30</option>
            <option value="14:00">14:00</option>
            <option value="14:30">14:30</option>
            <option value="15:00">15:00</option>
            <option value="15:30">15:30</option>
            <option value="16:00">16:00</option>
            <option value="16:30">16:30</option>
            <option value="17:00">17:00</option>
            <option value="17:30">17:30</option>
            <option value="18:00">18:00</option>
            <option value="18:30">18:30</option>
            <option value="19:00">19:00</option>
         </select>
		</div><div style="clear:both;"></div>

			<div class="mb-3">
				<label class="fs-0" for="eventDescription">상세</label>
				<textarea class="form-control" rows="3" name="description" id="eventDescription"></textarea>
			</div>
			<div class="mb-3">
				<label class="fs-0" for="schdlTp">범위</label>
				<select class="form-select" id="schdlTp" name="label">
					<option value="<sec:authentication property="principal.userVO.userId"/>" selected="selected">개인</option>
					<option value="<sec:authentication property="principal.userVO.deptNo"/>">팀</option>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<option value="<sec:authentication property="principal.userVO.coId"/>">전체</option>
					</sec:authorize>
				</select>
			</div>
			<input type="hidden" id="username" value="<sec:authentication property='principal.username' />">
		</div>
		<div class="modal-footer d-flex justify-content-end align-items-center bg-light border-0">
		  <button class="btn btn-primary px-4" id="insertBtn" >등록</button>
		</div>
			<div class="d-flex mt-2">
				<button id="autoInput1" class="btn btn-outline-primary me-1 mb-1" type="button">자동완성</button>
			</div>
		</div>
		<sec:csrfInput />
	  </form>
	</div>
  </div>
</div>











<script>
	$(function() {
		// FullCalendar 캘린더 생성 함수를 정의합니다.
		function createCalendar(data) {
			var calendarEl = document.getElementById('calendar');
			var calendar = new FullCalendar.Calendar(calendarEl, {
				slotMinTime : '08:00',
				slotMaxTime : '20:00',
				headerToolbar : {
					left : 'prev,next,today',
					center : 'title',
					right : 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
				},
				initialView : 'dayGridMonth',
				navLinks : true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
				editable : true, // 수정 가능
				droppable : true, // 드래그 앤 드롭
				selectable : true, // 달력 일자 드래그 설정 가능
				resizable: true,
				events : data,
				locale : 'ko',

				eventClick : function(info){
					if(confirm("'"+info.event.title+"'을 삭제하시겠습니까?")){
						// 확인 클릭 시
						info.event.remove();
					}

					console.log(info.event);
					var events = new Array(); // JSON 데이터를 받기 위한 배열 선언
					var obj = new Object();
					    obj.title = info.event._def.title;
						obj.id	  = info.event._def.publicId;
					    events.push(obj);

				    console.log(events);
				    $(function deleteData(){
				    	$.ajax({
				    		url : "/schedule/deleteSchdl",
				    		method : "DELETE",
				    		dataType : "json",
				    		data : JSON.stringify(events),
				    		contentType : 'application/json;charset=utf-8',
							beforeSend: function(xhr) {
								xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
							}
				    	})
				    })
				},//eventClick종료
				// 드래그로 이벤트 수정하기
				eventDrop : function(info){

					if(confirm("'"+info.event.title+"'을 수정하시겠습니까?")){

						var events = new Array(); // Json 데이터를 받기 위한 배열 선언
						var obj = new Object();

						startSc = info.event._instance.range.start.toJSON();
						endSc   = info.event._instance.range.end.toJSON();

						obj.id	  = info.event._def.publicId;
						obj.title = info.event._def.title;
						obj.start = startSc;
						obj.end   = endSc;

						events.push(obj);

						console.log(events);
					}else{
						location.reload(); // 새로 고침
					}
					$(function modifyData(){
						$.ajax({
							url : "/schedule/updateSchdl",
							method : "PATCH",
							data : JSON.stringify(events),
							contentType : 'application/json',
							beforeSend: function(xhr) {
								xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
							}
						})
					})
				},//eventDrop 종료
				select: function(arg){ // 캘린더에서 드래그로 이벤트를 생성할 수 있다

					var title = prompt('일정명을 입력해주세요 - 개인일정');
				    if(title){
				    	calendar.addEvent({
				    		title : title,
				    		start : arg.start,
				    		end : arg.end,
				    		textColor : "black"
				    	})
				    }else{
				    	 location.reload(); // 새로고침
				    	 return;
				    }

				    var events = new Array(); // Json 데이터를 받기 위한 배열 선언
				    var obj = new Object(); // Json을 담기 위해 Object 선언

				    console.log("arg" + arg);
				    console.log(arg.start);



				    obj.title = title;
				    obj.start = arg.start; // 시작
				    obj.end = arg.end; // 끝
				    events.push(obj);

				    var jsondata = JSON.stringify(events);
				    console.log(jsondata);

				    $(function saveData(jsonData){
				    	$.ajax({
				    		url : "/schedule/selectSchdl",
				    		method : "POST",
				    		dataType : "json",
				    		data : JSON.stringify(events),
				    		contentType : 'application/json',
							beforeSend: function(xhr) {
								xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
							}
				    	})
				    	calendar.unselect()
				    });
				},//select 종료

				eventResize: function(info) {
					if(confirm("'"+info.event.title+"'을 수정하시겠습니까?")){

						var events = new Array(); // Json 데이터를 받기 위한 배열 선언
						var obj = new Object();

						startSc = info.event._instance.range.start.toJSON();
						endSc   = info.event._instance.range.end.toJSON();

						obj.id	  = info.event._def.publicId;
						obj.title = info.event._def.title;
						obj.start = startSc;
						obj.end   = endSc;

						events.push(obj);

						console.log(events);
					}else{
						location.reload(); // 새로 고침
					}
					$(function modifyData(){
						$.ajax({
							url : "/schedule/updateSchdl",
							method : "PATCH",
							data : JSON.stringify(events),
							contentType : 'application/json',
							beforeSend: function(xhr) {
								xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
							}
						})
					})
				 }
			});
			calendar.render();
		}

		// 체크박스 요소들을 선택합니다.
		var checkboxes = document.querySelectorAll('.form-check-input');

		// 체크된 값을 저장할 배열을 생성합니다.
		var checkedValues = [];

		// 체크된 체크박스들의 값을 배열에 추가하는 함수입니다.
		function updateCheckedValues() {
			checkedValues = [];
			checkboxes.forEach(function(checkbox) {
				if (checkbox.checked) {
					checkedValues.push(checkbox.value);
				}
			});
		}

		// 체크박스의 변경 이벤트에 대한 리스너를 추가합니다.
		checkboxes.forEach(function(checkbox) {
			checkbox.addEventListener('change', function() {
				updateCheckedValues();
				fetchCalendarData();
			});
		});

		// 페이지 로딩 후에 체크된 값을 가져와서 캘린더를 생성합니다.
		updateCheckedValues();
		fetchCalendarData();

		// FullCalendar 캘린더를 생성하기 위해 필요한 데이터를 가져오는 함수입니다.
		function fetchCalendarData() {
			var request = $.ajax({
				url : "/schedule/list/",
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

		// 이벤트 등록 버튼 클릭 이벤트 핸들러
		insertBtn.onclick = function() {
			//알람
			stomp.send('/pub/scheduleAll', {}, JSON.stringify({
				senderNm : userData[userId][0]+` `+userData[userId][1]+` `+userData[userId][2],
				sender: userId,
			}));

			event.preventDefault();
			var title = document.querySelector("#eventTitle").value;
			var eventStartDate = document.querySelector("#eventStartDate").value;
			var eventEndDate = document.querySelector("#eventEndDate").value;
			var startTime = document.querySelector("#startTime").value;
			var endTime = document.querySelector("#endTime").value;
			var username = document.getElementById('username').value;
			var schdlTp = document.getElementById('schdlTp').value;
			var schdlCn = document.getElementById('eventDescription').value;

			var strtRsvt = eventStartDate + " " + startTime;
			var endRsvt = eventEndDate + " " + endTime;

			var events = new Array(); // Json 데이터를 받기 위한 배열 선언
			var obj = new Object(); // Json을 담기 위해 Object 선언

			obj.userId = username;
			obj.title = title;
			obj.start = strtRsvt;
			obj.end = endRsvt;
			obj.schdlTp = schdlTp;
			obj.schdlCn = schdlCn;

			events.push(obj);

			var jsondata = JSON.stringify(events);

			var redi;

			$.ajax({
				url : "/schedule/registSchdl",
				data : JSON.stringify(events),
				type : "POST",
				contentType : "application/json; charset=utf-8",
				async: false, //동기
				dataType:"text",
				beforeSend: function(xhr) {
					xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
				},
				success : function(res) {
					if(res == "fail"){
						alert('입력한 예약 시간에 기존 예약이 있습니다.');
					}
				}
			})

			$('.modal').on('hidden.bs.modal', function (e) {
				$('#addEventForm')[0].reset();
			});
			$("#addEventModal").modal('hide');

			updateCheckedValues();
			fetchCalendarData();
		}

	});
</script>

<script type="text/javascript">
	const eventTitle	 	 = $("#eventTitle")[0];
	const eventStartDate	 = $("#eventStartDate")[0];
	const eventEndDate		 = $("#eventEndDate")[0];
	const startTime			 = $("#startTime")[0];
	const endTime			 = $("#endTime")[0];
	const eventDescription	 = $("#eventDescription")[0];

		$("#autoInput1").on("click", function() {
			eventTitle.value = '보고서제출';
			eventStartDate.value = '2023-07-25';
			eventEndDate.value = '2023-07-25';
			startTime.value = '09:00';
			endTime.value = '10:00';
			eventDescription.value = '보고서제출';
		});

</script>

