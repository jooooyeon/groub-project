<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="col-lg-12 pe-lg-2">
	<div class="card mb-3">
		<div class="card-header">
			<h3 class="mb-0">관리자 계정 목록</h3>
		</div>
		<div class="card-body pt-0">
			<div id="tableExample2" data-list='{"valueNames":["userId","userNm","userEml","deptNm","jbgdNm","jbtlNm","auth"],"page":10,"pagination":true}'>
    		<div class="d-flex align-items-center justify-content-end my-3">
				<div class="d-grid gap-1">
					<div class="col text-end">
						<button class="btn btn-primary" type="button"
							data-bs-toggle="modal" data-bs-target="#cst-modal">추가</button>
					</div>
				</div>
			</div>
			  <div class="table-responsive scrollbar">
			    <table class="table table-bordered table-striped fs--1 mb-0">
	   				<colgroup>
						<col width="20%">
						<col width="10%">
						<col width="20%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="13%">
						<col width="7%">
	   				</colgroup>
			      <thead class="bg-200 text-900">
			        <tr>
			          <th class="sort mb-1 text-center" data-sort="userId">사원번호</th>
			          <th class="sort mb-1 text-center" data-sort="userNm">이름</th>
			          <th class="sort mb-1 text-center" data-sort="userEml">이메일</th>
			          <th class="sort mb-1 text-center" data-sort="deptNm">부서</th>
			          <th class="sort mb-1 text-center" data-sort="jbgdNm">직급</th>
			          <th class="sort mb-1 text-center" data-sort="jbtlNm">직책</th>
			          <th class="sort mb-1 text-center" data-sort="auth">관리자 권한</th>
			          <th class="sort mb-1 text-center" >비고</th>
			        </tr>
			      </thead>
			      <tbody class="list">
			      	<c:forEach var="data" items="${userList}" varStatus="stat">
			        	<tr>
							<td class="mb-1 text-center userId">${data.userId}</a></td>
							<td class="mb-1 text-center userNm">${data.userNm}</td>
							<td class="mb-1 text-center userEml">${data.userEml}</td>
							<td class="mb-1 text-center deptNm">${data.deptNm}</td>
							<td class="mb-1 text-center jbgdNm">${data.jbgdNm}</td>
							<td class="mb-1 text-center jbtlNm">${data.jbtlNm}</td>
							<td class="mb-1 text-center auth">${data.usersAuthVOList[0].auth}</td>
							<td class="mb-1 text-center ">
								<div>
									<button onclick="delAuth('${data.userId}')" class="btn btn-link p-0 ms-2">
										<span class="text-500 fas fa-trash-alt"></span>
									</button>
								</div>
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


<div class="modal fade" id="cst-modal" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document"
		style="max-width: 500px">
		<div class="modal-content position-relative">
			<div class="position-absolute top-0 end-0 mt-2 me-2 z-1">
				<button
					class="btn-close btn btn-sm btn-circle d-flex flex-center transition-base"
					data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body p-0">
				<div class="rounded-top-3 py-3 ps-4 pe-6 bg-light">
					<h4 class="mb-1" id="modalExampleDemoLabel">관리자 권한 추가</h4>
				</div>
				<div class="p-4 pb-0">
					<form name="addAuthfrm" action="/admin/account/addAuth" method="post">
					<div class="mb-3">
						<label class="form-label" for="userId">사원번호</label>
						<input class="form-control" id="userId" name="userId" type="text" value="" required>
					</div>
					<div class="mb-3">
						<label class="form-label" for="userAuth">권한</label>
						<input class="form-control" id="userAuth" name="userAuth" type="text" value="관리자" readonly />
					</div>
					<sec:csrfInput />
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<input id="coId" type="hidden"
					value="<sec:authentication property="principal.userVO.coId"/>"
					readonly> <input id="userId" type="hidden"
					value="<sec:authentication property="principal.userVO.userId"/>"
					readonly>
				<button class="btn btn-secondary" type="button"
					data-bs-dismiss="modal">취소</button>
				<button class="btn btn-primary" id="addAuthBtn" type="button">저장</button>
			</div>
		</div>
	</div>
</div>





<script>
function delAuth(userId) {
    if (!confirm(userId + " 권리자 권한을 삭제하시겠습니까?")) {
        alert("취소하였습니다.");
    } else {

	    var sendData = {"userId":userId}
		var csrfToken = $("input[name='_csrf']").val();

	    $.ajax({
	        url : '/admin/account/delAuth',
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
        alert("권한이 삭제 되었습니다.");
	    window.location.href='/admin/account/auth'
    }
}


document.getElementById("addAuthBtn").addEventListener("click", function() {
	document.addAuthfrm.submit();
});
</script>
