<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- ///////////////// 근무현황 ////////////-->
<table class="card overflow-hidden" style="width: 55rem;">
    <tbody>
        <tr>
            <td colspan="3" class="card-body" style="gap: 10px; justify-content: space-between; display: flex; flex-wrap: wrap;">
	                        <h3 class="card-title">근무현황</h3>
            		<td >
	                        <!-- 날짜 -->
	                        <div id="date" style="font-size: 18px; font-family: Arial; color: #dcdcdc; text-align: center;"></div>
	                        <!-- 시간 -->
	                        <div id="clock" style="font-size: 45px; font-family: Arial; color: #1e90ff; text-align: center;"></div>
	                        <!-- 출퇴근버튼 -->
	              
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
		            	</td>
                    <td style="padding: 50px;">
                            <form id="frm" action="/attendance/insert" method="post">
	                                <input type="hidden" name="attendanceDt" id="attendanceDt" value="${attendance.attendDt}" pattern="yyyy-MM-dd">
	                                <input type="hidden" name="attendanceDt" id="dclzNo" value="${atdcToday.dclzNo}">
	                                <span>출근 시간 : <span id="attendDt" style="display: inline-block; text-align: center;"><fmt:formatDate value="${atdcToday.attendDt}" pattern="HH:mm:ss" /></span></span>
	                                
	                                <br>
	                            <form id="frm" action="/attendance/update" method="post">
	                                <span>퇴근 시간 : <span id="lvffcDt" style="display: inline-block; text-align: center;"><fmt:formatDate value="${atdcToday.lvffcDt}" pattern="HH:mm:ss" /></span></span>
	                                <br>
	                                <span>근무 시간 : <span id="workDuration" style="display: inline-block; text-align: center;">${atdcToday.workH}시간  ${atdcToday.workM}분 </span></span>
	                                <!-- 시큐리티 관련.. form태그 안에 꼭 붙여야함 -->
	                            </form>
                                <sec:csrfInput/>
                            </form>
                    </td>
                    <td>
                        <sec:authorize access="isAuthenticated()">
							  <sec:authentication property="principal.userVO.userId"/> <br/>
							  <sec:authentication property="principal.userVO.deptNm"/> <br/>
							  <sec:authentication property="principal.userVO.userNm"/> <br/> 
						</sec:authorize>
               		 </td>
                    <td>
                        <sec:authorize access="isAuthenticated()">
							  <img class="profile-image" style="width:100px; height:130px;"src="<sec:authentication property="principal.userVO.userImg"/>"/> <br/>
						</sec:authorize>
               		 </td>
            </td>
        </tr>
    </tbody>
</table>

<div class="card overflow-hidden" style="width: 55rem;">
	<div class="card-body" style="height: 800px;">
		<div id="tableExample4" data-list='{"valueNames":["name","email","payment"],"filter":{"key":"payment"}}'>
  <div class="row justify-content-end g-0">
    <div class="col-auto px-3">
      <select class="form-select form-select-sm mb-3" aria-label="Bulk actions" data-list-filter="data-list-filter">
        <option selected="" value="">근무 구분 선택</option>
        <option value="Success">정상 출근</option>
        <option value="Blocked">출장</option>
        <option value="Pending">조퇴</option>
        <option value="Blocked">결근</option>
      </select>
    </div>
  </div>
  <div class="table-responsive scrollbar">
    <table class="table table-sm table-striped fs--1 mb-0 overflow-hidden">
	    <colgroup>
			<col style="width: 20%">
			<col style="width: 20%">
			<col style="width: 20%">
			<col style="width: 20%">
			<col style="width: 20%">
		</colgroup>
      <thead class="bg-200 text-900">
        <tr>
          <th class="sort pe-1 text-center white-space-nowrap" >날짜</th>
          <th class="sort pe-1 text-center white-space-nowrap" >출근 시간</th>
          <th class="sort pe-1 text-center white-space-nowrap" >퇴근 시간</th>
          <th class="sort pe-1 text-center white-space-nowrap" >근무 시간</th>
          <th class="sort pe-1 text-center white-space-nowrap" >근무구분</th>
        </tr>
      </thead>
      
      
      <tbody class="list" id="table-purchase-body">
	      <c:forEach var ="attendanceVO" items="${atdcList}">
	        <tr class="btn-reveal-trigger">
	          <td class="sort pe-1 text-center white-space-nowrap"><fmt:formatDate value="${attendanceVO.attendDt}" pattern="yyyy-MM-dd" /></td>
	          <td class="sort pe-1 text-center white-space-nowrap"><fmt:formatDate value="${attendanceVO.attendDt}" pattern="HH:mm:ss" /></td>
 	          <td class="sort pe-1 text-center white-space-nowrap"><fmt:formatDate value="${attendanceVO.lvffcDt}" pattern="HH:mm:ss" /></td>
	          <td class="sort pe-1 text-center white-space-nowrap">${attendanceVO.workH}시간  ${attendanceVO.workM}분</td>
	          <td class="sort pe-1 text-center white-space-nowrap"><span class="badge badge rounded-pill badge-subtle-success">정상 출근<span class="ms-1 fas fa-check" data-fa-transform="shrink-2"></span></span>
	          </td>
	        </tr>
	      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
	</div>
</div>



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








