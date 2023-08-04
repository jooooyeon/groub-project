<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.or.ddit.reservation.vo.VhclVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="card mb-3">
  <div class="bg-holder d-none d-lg-block bg-card" >
  </div>
  <div class="card-body position-relative">
    <div class="row">
      <div class="col-lg-12">
        <h3 id="carTitle" >차량 목록</h3>
			<div class="table-responsive scrollbar">
			  <table class="table">
			    <thead>
			      <tr>
			        <th scope="col">차량번호</th>
			        <th scope="col">제조사</th>
			        <th scope="col">모델</th>
			        <th scope="col">연식</th>
			        <th scope="col">연료타입</th>
			        <th scope="col">탑승정원</th>
			      </tr>
			    </thead>
			    <tbody>
				<c:forEach var="vhclVO" items="${data}" varStatus="stat">
			      <tr>
			        <td class="vehicle-number" ><button class="btn btn-success me-1 mb-1" type="button">${vhclVO.vhclNo}</button></td>
			        <td>${vhclVO.vhclMc}</td>
			        <td>${vhclVO.vhclNm}</td>
			        <td>${vhclVO.vhclYmd}</td>
			        <td>${vhclVO.fuelType}</td>
			        <td>${vhclVO.rdcpctCnt}</td>
			      </tr>
				</c:forEach>
			    </tbody>
			  </table>
			</div>
      </div>
    </div>
  </div>
</div>


<div class="col-lg-12">
  <div class="card">
    <div class="card-header">
      <div class="row flex-between-end">
        <div class="col-auto align-self-center">
          <h5 class="mb-0" id="carNumber">
        	<div class="btn btn-default btn-sm" >
		      <span class="fas fa-plus me-2"></span>예약하기
		    </div>
		  </h5>
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
		  <h5 class="modal-title" id="vhclNo"></h5>
		  <button class="btn-close me-n1" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
		</div>
		<div class="modal-body p-x1">
		  <div class="mb-3">
			<label class="fs-0" for="eventTitle">목적</label>
			<input class="form-control" id="eventTitle" type="text" name="title" required="required" />
		  </div>
		  <div class="mb-3">
			<label class="fs-0" for="eventStartDate">시작일자</label>
			<input class="form-control datetimepicker" id="eventStartDate" type="text" required="required" name="startDate" placeholder="yyyy/mm/dd hh:mm" data-options='{"static":"true","enableTime":"true","dateFormat":"Y-m-d H:i"}' />
		  </div>
		  <div class="mb-3">
			<label class="fs-0" for="eventEndDate">종료일자</label>
			<input class="form-control datetimepicker" id="eventEndDate" type="text" name="endDate" placeholder="yyyy/mm/dd hh:mm" data-options='{"static":"true","enableTime":"true","dateFormat":"Y-m-d H:i"}' />
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
		<input type="hidden" id="username" value="<sec:authentication property='principal.username' />">
		</div>
		<div class="modal-footer d-flex justify-content-end align-items-center bg-light border-0">
		  <button class="btn btn-primary px-4" id="insertBtn" >등록</button>
		</div>
		</div>
		<sec:csrfInput />
	  </form>
	</div>
  </div>
</div>



<script>
var vehicleNumberCells = document.querySelectorAll('.vehicle-number');

vehicleNumberCells.forEach(function(cell) {
	cell.addEventListener('click', function() {
		var vhclNo = this.textContent;
		document.getElementById('vhclNo').textContent = vhclNo;

		  const div = document.createElement('div');
		  div.className = 'col-auto d-flex order-md-0';
		  div.innerHTML = `
		    <button class="btn btn-primary btn-sm" type="button" data-bs-toggle="modal" data-bs-target="#addEventModal">
		      <span class="fas fa-plus me-2"></span>예약하기
		    </button>
		  `;

		  // 부모 요소에 추가합니다.
		  const parentContainer = document.getElementById('carNumber');
		  parentContainer.innerHTML = '';
		  parentContainer.appendChild(div);


		$(function(){
			var request = $.ajax({
				url : "/reservation/calendar/"+vhclNo, // 값 불러오기
				method : "POST",
				dataType : "JSON",
				traditional: true,
				async: false, //동기
				beforeSend: function(xhr) {
					xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
				}
			});//request ajax종료
			request.done(function(data){
// 				console.log(data); // log로 데이터 찍어주기
				var calendarEl = document.getElementById('calendar');
				calendar = new FullCalendar.Calendar(calendarEl,{
					height : '700px',
					slotMinTime : '08:00', // Day 캘린더에서 시작 시간
					slotMaxTime : '20:00',  // Day 캘린더에서 종료 시간
					// 헤더에 표시할 툴바
					headerToolbar :{
						left : 'prev,next,today',
						center : 'title',
						right : 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
					},
					initialView : 'timeGridWeek', // 초기 로드 될 때 보이는 캘린더 화면 (기본 설정 : 달)
					navLinks : true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
					events : data,
					locale : 'ko'
				});
				calendar.render();
			});
		})//$(function()종료
	});//cell.addEventListener종료


	insertBtn.onclick = function(){
		event.preventDefault();
		var title = document.querySelector("#eventTitle").value;
		var eventStartDate = document.querySelector("#eventStartDate").value;
		var eventEndDate = document.querySelector("#eventEndDate").value;
		var startTime = document.querySelector("#startTime").value;
		var endTime = document.querySelector("#endTime").value;
		var username = document.getElementById('username').value;

		var strtRsvt = eventStartDate + " " + startTime;
		var endRsvt = eventEndDate + " " + endTime;
		var vhclNoText = vhclNo.innerHTML;

		var events = new Array(); // Json 데이터를 받기 위한 배열 선언
	    var obj = new Object(); // Json을 담기 위해 Object 선언

	    obj.userId = username;
	    obj.prps = title;
	    obj.strtRsvtDt = strtRsvt;
	    obj.endRsvtDt = endRsvt;
	    obj.vhclNo = vhclNoText;
	    events.push(obj);

	    var jsondata = JSON.stringify(events);

	    var redi;

	 	$.ajax({
			url : "/reservation/insertForm",
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

		$(function(){
			var request = $.ajax({
				url : "/reservation/calendar/"+vhclNoText, // 값 불러오기
				method : "POST",
				dataType : "JSON",
				traditional: true,
				async: false, //동기
				beforeSend: function(xhr) {
					xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
				}
			});//request ajax종료
			request.done(function(data){
// 				console.log(data); // log로 데이터 찍어주기
				var calendarEl = document.getElementById('calendar');
				calendar = new FullCalendar.Calendar(calendarEl,{
					height : '700px',
					slotMinTime : '08:00', // Day 캘린더에서 시작 시간
					slotMaxTime : '20:00',  // Day 캘린더에서 종료 시간
					// 헤더에 표시할 툴바
					headerToolbar :{
						left : 'prev,next,today',
						center : 'title',
						right : 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
					},
					initialView : 'timeGridWeek', // 초기 로드 될 때 보이는 캘린더 화면 (기본 설정 : 달)
					navLinks : true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
					events : data,
					locale : 'ko'
				});
				calendar.render();
			});
		})//$(function()종료
	}



});//vehicleNumberCells종료


</script>






