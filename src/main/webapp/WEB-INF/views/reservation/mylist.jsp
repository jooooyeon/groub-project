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
		      <h3 class="mb-0">예약 목록</h3>
		    </div>
		  </div>
		</div>
		<div class="card-body pt-1 ">
			<div id="tableExample2" data-list='{"valueNames":["cate","rsvtNo","stDt","edDt","prps","process"],"page":10,"pagination":true,"filter":{"key":"cate"}}'>

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
     				    <option value="회의실">회의실</option>
     				    <option value="차량">차량</option>
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
			          <th class="sort mb-1 text-center" data-sort="cate">구분</th>
			          <th class="sort mb-1 text-center" data-sort="rsvtNo">예약물</th>
			          <th class="sort mb-1 text-center" data-sort="stDt">시작일시</th>
			          <th class="sort mb-1 text-center" data-sort="edDt">종료일시</th>
			          <th class="sort mb-1 text-center" data-sort="prps">예약목적</th>
			          <th class="sort mb-1 text-center" data-sort="process">상태</th>
			          <th class="sort mb-1 text-center" >비고</th>
			        </tr>
			      </thead>
			      <tbody class="list">
			      	<c:forEach var="data" items="${offmFute}" varStatus="stat">
			        <tr>
			          <td class="mb-1 text-center cate" data-fa-transform="shrink-2">회의실</td>
			          <td class="mb-1 text-center rsvtNo">${data.offmNm}</td>
			          <td class="mb-1 text-center stDt" >${data.strtRsvtDt}</td>
			          <td class="mb-1 text-center edDt">${data.endRsvtDt}</td>
			          <td class="mb-1 ps-4 prps" >${data.prps}</td>
			          <td class="mb-1 text-center process" ><span class="badge badge-subtle-primary">예정</span></td>
			          <td class="mb-1 text-center">
						<div>
							<button onclick="delORNo(${data.onoStr})" class="btn btn-link p-0 ms-2">
								<span class="text-500 fas fa-trash-alt"></span>
							</button>
						</div>
			          </td>
			        </tr>
			        </c:forEach>
			      	<c:forEach var="data" items="${offmIng}" varStatus="stat">
			        <tr>
			          <td class="mb-1 text-center cate" data-fa-transform="shrink-2">회의실</td>
			          <td class="mb-1 text-center rsvtNo">${data.offmNm}</td>
			          <td class="mb-1 text-center stDt" >${data.strtRsvtDt}</td>
			          <td class="mb-1 text-center edDt">${data.endRsvtDt}</td>
			          <td class="mb-1 ps-4 prps" >${data.prps}</td>
			          <td class="mb-1 text-center process" ><span class="badge badge-subtle-success">진행</span></td>
			          <td class="mb-1 text-center "></td>
			        </tr>
			        </c:forEach>
			      	<c:forEach var="data" items="${offmEnd}" varStatus="stat">
			        <tr>
			          <td class="mb-1 text-center cate" data-fa-transform="shrink-2">회의실</td>
			          <td class="mb-1 text-center rsvtNo">${data.offmNm}</td>
			          <td class="mb-1 text-center stDt" >${data.strtRsvtDt}</td>
			          <td class="mb-1 text-center edDt">${data.endRsvtDt}</td>
			          <td class="mb-1 ps-4 prps" >${data.prps}</td>
			          <td class="mb-1 text-center process" ><span class="badge badge-subtle-secondary">완료</span></td>
			          <td class="mb-1 text-center "></td>
			        </tr>
			        </c:forEach>
			      	<c:forEach var="data" items="${vhclFute}" varStatus="stat">
			        <tr>
			          <td class="mb-1 text-center cate" data-fa-transform="shrink-2">차량</td>
			          <td class="mb-1 text-center rsvtNo">${data.vhclNo}</td>
			          <td class="mb-1 text-center stDt" >${data.strtRsvtDt}</td>
			          <td class="mb-1 text-center edDt">${data.endRsvtDt}</td>
			          <td class="mb-1 ps-4 prps" >${data.prps}</td>
			          <td class="mb-1 text-center process" ><span class="badge badge-subtle-primary">예정</span></td>
			          <td class="mb-1 text-center">
						<div>
							<button onclick="delVRNo(${data.vnoStr})" class="btn btn-link p-0 ms-2">
								<span class="text-500 fas fa-trash-alt"></span>
							</button>
						</div>
			          </td>
			        </tr>
			        </c:forEach>
			      	<c:forEach var="data" items="${vhclIng}" varStatus="stat">
			        <tr>
			          <td class="mb-1 text-center cate" data-fa-transform="shrink-2">차량</td>
			          <td class="mb-1 text-center rsvtNo">${data.vhclNo}</td>
			          <td class="mb-1 text-center stDt" >${data.strtRsvtDt}</td>
			          <td class="mb-1 text-center edDt">${data.endRsvtDt}</td>
			          <td class="mb-1 ps-4 prps" >${data.prps}</td>
			          <td class="mb-1 text-center process" ><span class="badge badge-subtle-success">진행</span></td>
			          <td class="mb-1 text-center "></td>
			        </tr>
			        </c:forEach>
			      	<c:forEach var="data" items="${vhclEnd}" varStatus="stat">
			        <tr>
			          <td class="mb-1 text-center cate" data-fa-transform="shrink-2">차량</td>
			          <td class="mb-1 text-center rsvtNo">${data.vhclNo}</td>
			          <td class="mb-1 text-center stDt" >${data.strtRsvtDt}</td>
			          <td class="mb-1 text-center edDt">${data.endRsvtDt}</td>
			          <td class="mb-1 ps-4 prps" >${data.prps}</td>
			          <td class="mb-1 text-center process" ><span class="badge badge-subtle-secondary">완료</span></td>
			          <td class="mb-1 text-center "></td>
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

<script>
function delORNo(oRsvtNo) {
    if (!confirm("예약을 취소하시겠습니까?")) {
    } else {

	    var sendData = {"oRsvtNo":oRsvtNo}
		var csrfToken = $("input[name='_csrf']").val();

	    $.ajax({
	        url : '/reservation/delOffm',
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
