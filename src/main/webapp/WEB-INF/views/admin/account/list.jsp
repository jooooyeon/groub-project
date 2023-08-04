<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="col-lg-12 pe-lg-2">
	<div class="card mb-3">
		<div class="card-header">
			<h3 class="mb-0">계정 목록</h3>
		</div>
		<div class="card-body pt-0 ">
			<div id="tableExample2" data-list='{"valueNames":["userId","userNm","userEml","deptNm","jbgdNm","jbtlNm","enabled"],"page":10,"pagination":true}'>

			<!-- 검색 -->
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
			    <table class="table table-bordered table-striped fs--1 mb-0">
				<colgroup>
					<col width="20%">
					<col width="10%">
					<col width="25%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="15%">
				</colgroup>
			      <thead class="bg-200 text-900">
			        <tr>
			          <th class="sort mb-1 text-center" data-sort="userId">사원번호</th>
			          <th class="sort mb-1 text-center" data-sort="userNm">이름</th>
			          <th class="sort mb-1 text-center" data-sort="userEml">이메일</th>
			          <th class="sort mb-1 text-center" data-sort="deptNm">부서</th>
			          <th class="sort mb-1 text-center" data-sort="jbgdNm">직급</th>
			          <th class="sort mb-1 text-center" data-sort="jbtlNm">직책</th>
			          <th class="sort mb-1 text-center" data-sort="enabled">계정활성여부</th>
			        </tr>
			      </thead>
			      <tbody class="list">
			      	<c:forEach var="data" items="${userList}" varStatus="stat">
			        <tr>
			          <td class="mb-1 text-center userId"><a href="/admin/account/detail/${data.userId}">${data.userId}</a></td>
			          <td class="mb-1 text-center userNm">${data.userNm}</td>
			          <td class="mb-1 text-center userEml">${data.userEml}</td>
			          <td class="mb-1 text-center deptNm">${data.deptNm}</td>
			          <td class="mb-1 text-center jbgdNm">${data.jbgdNm}</td>
			          <td class="mb-1 text-center jbtlNm">${data.jbtlNm}</td>
			          <td class="mb-1 text-center enabled">
			          	  <c:choose>
					          <c:when test="${data.enabled == '1'}">
						          <button id="btnOpen" onclick="deActUserId('${data.userId}')" class="btn btn-falcon-success btn-sm">사용계정
						          </button>
					          </c:when>
					          <c:otherwise>
						          <button id="btnClose" onclick="actUserId('${data.userId}')" class="btn btn-falcon-default btn-sm">잠긴계정
						          </button>
					          </c:otherwise>
				          </c:choose>
			          </td>
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
    function actUserId(userId) {
        if (!confirm(userId + " 계정을 활성화하시겠습니까?")) {
        } else {

    	    var sendData = {"userId":userId}
    		var csrfToken = $("input[name='_csrf']").val();

    	    $.ajax({
    	        url : '/admin/account/accountAct',
    	        data : sendData,
    	        method : 'post',
    			headers: {
    	            'Content-Type': 'application/x-www-form-urlencoded',
    	            'X-CSRF-TOKEN': csrfToken
    	        },
    	        success : function(resp){
    	        	console.log(resp);
    	        }
    	    })
            alert("활성화 되었습니다.");
    	    window.location.href='/admin/account/list'
        }
    }
    function deActUserId(userId) {
        if (!confirm(userId + " 계정을 비활성화하시겠습니까?")) {
        } else {

    	    var sendData = {"userId":userId}
    		var csrfToken = $("input[name='_csrf']").val();

    	    $.ajax({
    	        url : '/admin/account/accountAct',
    	        data : sendData,
    	        method : 'post',
    			headers: {
    	            'Content-Type': 'application/x-www-form-urlencoded',
    	            'X-CSRF-TOKEN': csrfToken
    	        },
    	        success : function(resp){
    	        	console.log(resp);
    	        }
    	    })
            alert("비활성화 되었습니다.");
    	    window.location.href='/admin/account/list'
        }
    }
</script>