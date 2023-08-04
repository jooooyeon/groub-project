<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- ${data } --%>
<div class="container">
	<div class="row">
		<div class="card mb-3">
			<div class="card-header ">
				<div class="row flex-between-end">
					<div class="col-auto align-self-center">
						<h3 class="mb-0">이력서</h3>
						<p class="mb-0 pt-1 mt-2 mb-0"></p>
					</div>
					<div class="col-auto ms-auto">
						<a id="rsm-fit" class="nav-link mb-auto" style="display: flex; align-items: center; justify-content: center; flex-direction: column; " role="button">
							<svg class="svg-inline--fa fa-file-alt fa-w-12" data-fa-transform="shrink-6" style="font-size: 35px;transform-origin: 0.375em 0.5em;" aria-hidden="true" focusable="false" data-prefix="far" data-icon="file-alt" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512" data-fa-i2svg=""><g transform="translate(192 256)"><g transform="translate(0, 0)  scale(0.625, 0.625)  rotate(0 0 0)"><path fill="currentColor" d="M288 248v28c0 6.6-5.4 12-12 12H108c-6.6 0-12-5.4-12-12v-28c0-6.6 5.4-12 12-12h168c6.6 0 12 5.4 12 12zm-12 72H108c-6.6 0-12 5.4-12 12v28c0 6.6 5.4 12 12 12h168c6.6 0 12-5.4 12-12v-28c0-6.6-5.4-12-12-12zm108-188.1V464c0 26.5-21.5 48-48 48H48c-26.5 0-48-21.5-48-48V48C0 21.5 21.5 0 48 0h204.1C264.8 0 277 5.1 286 14.1L369.9 98c9 8.9 14.1 21.2 14.1 33.9zm-128-80V128h76.1L256 51.9zM336 464V176H232c-13.3 0-24-10.7-24-24V48H48v416h288z" transform="translate(-192 -256)"></path></g></g></svg><!-- <span class="far fa-file-alt" data-fa-transform="shrink-6" style="font-size: 35px;"></span> Font Awesome fontawesome.com -->
							<p>적합도 설정</p>
						</a>
					</div>
				</div>
			</div>
			<div class="card-body"><!-- 내용시작 -->
			
			<div id="tableExample3" data-list='{"valueNames":["rsmNo","resumeTp","deptNo","rsmNm","rsmDt"],"page":5,"pagination":true}'>
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
							<col style="width: 20%">
							<col style="width: 20%">
							<col style="width: 20%">
							<col style="width: 20%">
						</colgroup>
				      <thead class="bg-200 text-900">
				        <tr>
				          <th class="sort" data-sort="rsmNo">이력서 번호</th>
				          <th class="sort" data-sort="resumeTp">채용 구분</th>
				          <th class="sort" data-sort="deptNo">채용 부서</th>
				          <th class="sort" data-sort="rsmNm">지원자 명</th>
				          <th class="sort" data-sort="rsmDt">지원일</th>
				        </tr>
				      </thead>
				      <tbody class="list">
				      <c:forEach var="data" items="${data }" varStatus="stat">
				        <tr class="cursor-pointer" onclick="rsmDetail(${data.rsmNo})">
				          <td class="rsmNo">${data.rsmNo}</td>
				          <c:if test="${data.resumeTp == 'newEmployee'}">
				          <td class="resumeTp">신입</td>
				          </c:if>
				          <c:if test="${data.resumeTp == 'experiencedEmployee'}">
				          <td class="resumeTp">경력</td>
				          </c:if>
				          <td class="deptNo">${data.deptNoNm}</td>
				          <td class="rsmNm">${data.rsmNm}</td>
				          <td class="rsmDt"><fmt:formatDate value="${data.rsmDt}"/>  </td>
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

<!-- 모달 시작 -->
<div class="modal fade" id="rsm-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="border: none; background-color: transparent;">
	<div class="modal-dialog" style="max-width: 600px;" role="document">
		<div class="modal-content" id="rsm-modal-body" style="background-color: transparent;">
		</div>
	</div>
</div>
<!-- 모달 끝 -->
<script>
function rsmDetail(res){
	window.location.href = '/resume/resumeDetail?rsmNo=' + res;
}

$('#rsm-fit').on('click',()=>{
	$.ajax({
		url:'/goodness/fit/popup',
		type:'get',
		success:(res)=>{
			$('#rsm-modal-body').html(res);
			$('#rsm-modal').modal('show');
		},
	});
});

</script>

