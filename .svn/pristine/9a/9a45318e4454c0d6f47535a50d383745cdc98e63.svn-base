<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

${currentDate }
<div class="container">
	<div class="row">
		<div class="card mb-3">
			<div class="card-header ">
				<div class="row flex-between-end">
					<div class="col-auto align-self-center">
						<h3 class="mb-0">설문내역 확인</h3>
						<p class="mb-0 pt-1 mt-2 mb-0"></p>
					</div>
					<div class="col-auto ms-auto">
						<div class="nav nav-pills nav-pills-falcon flex-grow-1 mt-2"
							role="tablist"></div>
					</div>
				</div>
			</div>
			<div class="card-body"><!-- 내용시작 -->
			
			<div id="tableExample3" data-list='{"valueNames":["cnt","srvyTtl","bgngDt","endDt","state"],"page":5,"pagination":true}'>
				  <div class="row justify-content-end g-0">
				    <div class="col-auto col-sm-5 mb-3">
				      <form>
				        <div class="input-group">
				          <input class="form-control form-control-sm shadow-none search" type="search" placeholder="Search..." aria-label="search" />
				          <div class="input-group-text bg-transparent"><span class="fa fa-search fs--1 text-600"></span></div>
				        </div>
				      </form>
				    </div>
				  </div>
				  <div class="table-responsive scrollbar">
				    <table class="table table-bordered table-striped fs--1 mb-0 text-center">
				    	<colgroup>
							<col style="width: 10%">
							<col style="width: 40%">
							<col style="width: 20%">
							<col style="width: 20%">
							<col style="width: 10%">
						</colgroup>
				      <thead class="bg-200 text-900">
				        <tr>
				          <th class="sort" data-sort="cnt">번호</th>
				          <th class="sort" data-sort="srvyTtl">제목</th>
				          <th class="sort" data-sort="bgngDt">시작일</th>
				          <th class="sort" data-sort="endDt">종료일</th>
				          <th class="sort" data-sort="state">상태</th>
				        </tr>
				      </thead>
				      <tbody class="list">
				      	<c:forEach var="data" items="${data }" varStatus="stat">
				      		<c:set var="endDt"  value="${data.endDt}" />
				      		<c:set var="bgngDt"  value="${data.bgngDt}" />
				      	<tr>
					      	 <td class="cnt">${stat.count }</td>
					      	 <td class="srvyTtl" onclick="serveyDetailEmployee(${data.srvyNo})" style="cursor: pointer;">${data.srvyTtl }</td>
					         <td class="bgngDt">${fn:substring(bgngDt, 0,10)}</td>
					         <td class="endDt">${fn:substring(endDt, 0,10)}</td>
					        <td class="state">${data.srvyStts}</td>
				      	</tr>
				      	</c:forEach>
				      
				      
				      
				     </tbody>
				    </table>
				  </div>
				  <div class="d-flex justify-content-center mt-3">
				    <button class="btn btn-sm btn-falcon-default me-1" type="button" title="Previous" data-list-pagination="prev"><span class="fas fa-chevron-left"></span></button>
				    <ul class="pagination mb-0"></ul>
				    <button class="btn btn-sm btn-falcon-default ms-1" type="button" title="Next" data-list-pagination="next"><span class="fas fa-chevron-right"> </span></button>
				  </div>
				</div>
								
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			</div> <!-- 카드바디 -->
		</div>
	</div>
</div>


<script>


// 상태 요소에 배지를 추가하는 함수
function addBadge(stateElement, badgeText, badgeColor) {
  var badge = $("<span></span>").addClass("badge rounded-pill " + badgeColor).text(badgeText);
  stateElement.empty().append(badge);
}

// 상태 요소에 배지를 추가합니다.
$(".state").each(function() {
  var state = $(this);
  var srvyStts = state.text();

  if (srvyStts === "SV001") {
    addBadge(state, "진행중", "bg-primary");
  } else if (srvyStts === "SV002") {
    addBadge(state, "마감", "bg-secondary");
  }
});



function serveyDetailEmployee(res){
	console.log(res);
	window.location.href = '/servey/serveyDetailEmployee?srvyNo=' + res;
// 	window.location.href = 'resume/resumeDetail;
}

</script>

