<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<style>
.no-underline {
	text-decoration: none !important;
}
</style>

<div class="card mb-2">
	<div class="card-header ">
		<div class="row flex-between-end">
			<div class="col-auto align-self-center">
				<h3 class="mb-0">기안 문서함</h3>
			</div>
		</div>
	</div>
	<div class="card-body">
		<div class="card shadow-none">
			<div id="tableExample2" data-list='{"valueNames":["drNo","drftTitle","userNm","deptNm","drDt","atrzStts","atrzDt"],"page":10,"pagination":true,"filter":{"key":"atrzStts"}}'>
			<!-- 검색 -->
			<div class="container">
			  <div class="row">
				<div class="col">
				  <div class="row justify-content-start">
					<div class="col-auto col-sm-10 mb-3 ps-0">
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
					<div class="col-auto ps-3 pe-0">
					  <select id="statCd" class="form-select form-select-sm mb-3" aria-label="Bulk actions" data-list-filter="data-list-filter">
						<option selected value="">구분</option>
						<option value="진행중">진행중</option>
						<option value="결재">결재</option>
						<option value="반려">반려</option>
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
					  <th class="sort mb-1 text-center" data-sort="drNo">기안번호</th>
					  <th class="sort mb-1 text-center" data-sort="drftTitle">제목</th>
					  <th class="sort mb-1 text-center" data-sort="userNm">작성자</th>
					  <th class="sort mb-1 text-center" data-sort="deptNm">부서명</th>
					  <th class="sort mb-1 text-center" data-sort="drDt">작성일시</th>
					  <th class="sort mb-1 text-center" data-sort="atrzStts">결재여부</th>
					  <th class="sort mb-1 text-center" data-sort="atrzDt">처리일자</th>
					</tr>
				  </thead>
				  <tbody id="atrzList" class="list">
						<c:if test="${draftSelectList.size() == 0}">
							<td colspan="7" class="text-center">기안 문서가 없습니다.</td>
						</c:if>
						<c:forEach var="draft" items="${draftSelectList}" varStatus="stat">
							<tr id="atrzList">
								<td class="drNo text-center" >${draft.drNo}</td>
								<td class="drftTitle"><a class="no-underline" href="/draft/doc/${draft.drNo}">${draft.drftTitle}</a></td>
								
								<td class="userNm text-center">${draftUserVO.userNm}</td>
								<td class="deptNm text-center">${draftUserVO.deptNm}</td>
								<td class="drDt text-center">${draft.drDtFm2}</td>
								<c:if test="${draft.drSttsCd eq 'DF003'}">
									<td class="atrzStts text-center" data-fa-transform="shrink-2">진행중</td>
								</c:if>
								<c:if test="${draft.drSttsCd eq 'DF002'}">
									<td class="atrzStts text-center" data-fa-transform="shrink-2">결재완</td>
								</c:if>
								<c:if test="${draft.drSttsCd eq 'DF004'}">
									<td class="atrzStts text-center" data-fa-transform="shrink-2">반려</td>
								</c:if>
								<c:if test="${draft.fnshDt ne null}">
									<td class="atrzDt text-center">${draft.getMakeYMD(draft.fnshDt)}</td>
								</c:if>
								<c:if test="${draft.fnshDt eq null}">
									<td class="atrzDt text-center"></td>
								</c:if>
								
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