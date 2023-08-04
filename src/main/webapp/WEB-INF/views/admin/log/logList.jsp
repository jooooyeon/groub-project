<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.or.ddit.reservation.vo.VhclVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<div class="col-lg-12 pe-lg-2">
	<div class="card mb-3">
		<div class="card-header">
		  <div class="row align-items-center">
		    <div class="col">
		      <h3 class="mb-0">로그 기록</h3>
		    </div>
		  </div>
		</div>
		<div class="card-body bg-light ">
			<div id="tableExample2" data-list='{"valueNames":["logNo","userId","logStts","logYmd","ipAddr","ntnCd"],"page":10,"pagination":true,"filter":{"key":"logStts"}}'>

			<!-- 검색 -->
			<div class="container">
			  <div class="row">
			    <div class="col">
			      <div class="row justify-content-start">
			        <div class="col-auto col-sm-10 mb-3">
			          <form>
			            <div class="input-group">
			              <input class="form-control form-control-sm shadow-none search" type="search" placeholder="Search..." aria-label="search" />
			              <div class="input-group-text bg-transparent"><span class="fa fa-search fs--1 text-600"></span></div>
			            </div>
			          </form>
			        </div>
			      </div>
			    </div>
			    <div class="col">
			      <div class="row justify-content-end">
			        <div class="col-auto px-3">
			          <select class="form-select form-select-sm mb-3" aria-label="Bulk actions" data-list-filter="data-list-filter">
			            <option selected="" value="">구분</option>
     				    <option value="SUCCESS">SUCCESS</option>
     				    <option value="FAIL">FAIL</option>
     				    <option value="LOCKED">LOCKED</option>
			          </select>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>
			  <div class="table-responsive scrollbar">
			    <table class="table table-bordered table-striped fs--1 mb-0 border-2">
			      <thead class="bg-200 text-900">
			        <tr>
			          <th class="sort mb-1 text-center" data-sort="logNo">번호</th>
			          <th class="sort mb-1 text-center" data-sort="userId">아이디</th>
			          <th class="sort mb-1 text-center" data-sort="logStts">로그상태</th>
			          <th class="sort mb-1 text-center" data-sort="ipAddr">아이피</th>
			          <th class="sort mb-1 text-center" data-sort="logYmd">접속일시</th>
			          <th class="sort mb-1 text-center" data-sort="ntnCd">국가</th>
			          <th class="sort mb-1 text-center" >비고</th>
			        </tr>
			      </thead>
			      <tbody class="list">
			      	<c:forEach var="userLogVO" items="${logList}" varStatus="stat">
			        <tr>
			          <td class="mb-1 text-center logNo">${userLogVO.logNo}</td>
			          <td class="mb-1 text-center userId">${userLogVO.userId}</td>
			          <td class="mb-1 text-center logStts" data-fa-transform="shrink-2">${userLogVO.logStts}</td>
			          <td class="mb-1 text-center ipAddr">${userLogVO.ipAddr}</td>
			          <td class="mb-1 text-center logYmd">${userLogVO.logTime}</td>
			          <td class="mb-1 text-center ntnCd">${userLogVO.ntnCd}</td>
			        </tr>
			        </c:forEach>
			      </tbody>
			    </table>
			  </div>
			  <div class="d-flex justify-content-center mt-3">
			    <button class="btn btn-sm btn-falcon-default me-1" type="button" title="Previous" data-list-pagination="prev"><span class="fas fa-chevron-left"></span></button>
			    <ul class="pagination mb-0"></ul>
			    <button class="btn btn-sm btn-falcon-default ms-1" type="button" title="Next" data-list-pagination="next"><span class="fas fa-chevron-right"></span></button>
			  </div>
			</div>
		</div>
	</div>
</div>

<script>
function delVRNo(vRsvtNo) {
    if (!confirm("예약을 취소하시겠습니까?")) {
    } else {

	    var sendData = {"vRsvtNo":vRsvtNo}
		var csrfToken = $("input[name='_csrf']").val();

	    $.ajax({
	        url : '/reservation/delVhcl',
	        data : sendData,
	        method : 'post',
			headers: {
	            'Content-Type': 'application/x-www-form-urlencoded',
	            'X-CSRF-TOKEN': csrfToken
	        }
	    })
        alert("취소되었습니다.");
	    window.location.href='/reservation/mylist'
    }
}
</script>
