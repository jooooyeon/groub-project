<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<!-- 게시판 목록 -->
	<div class="card mb-3">
		<div class="card-body" >
			<h5 class="card-title pb-3">공지사항</h5>
			<div id="tableExample3" 
				data-list='{&quot;valueNames&quot;:[&quot;pstNo&quot;,&quot;pstTtl&quot;,&quot;userId&quot;,&quot;mdfcnDt&quot;,&quot;inqCnt&quot;],&quot;page&quot;:10,&quot;pagination&quot;:true}'>
				<div class="row justify-content-end g-0">
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<div class="col-auto col-sm-7 mb-0 ">
							<a href="/notice/register" class="btn btn-outline-secondary me-1 mb-1 " type="button">글쓰기</a>
						</div>
					</sec:authorize>
					<div class="col-auto col-sm-5 mb-3">
						<form>
							<div class="input-group">
								<input class="form-control form-control-sm shadow-none search" type="search" placeholder="검색어를 입력해 주세요" aria-label="search" />
								<div class="input-group-text bg-transparent">
									<span class="fa fa-search fs--1 text-600"></span>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="table table-fixed">
					<table class="table table-bordered table-striped fs--1 mb-0">
						<colgroup>
							<col style="width: 5%">
							<col style="width: 10%">
							<col style="width: 40%">
							<col style="width: 20%">
							<col style="width: 20%">
							<col style="width: 5%">
						</colgroup>
						<thead class="bg-200 text-900">
							<tr>
								<th class="sort mb-1 text-center" data-sort="rownum">글번호</th>
								<th class="sort mb-1 text-center" data-sort="pstNo">분류</th>
								<th class="sort mb-1 text-center" data-sort="pstTtl">제목</th>
								<th class="sort mb-1 text-center" data-sort="userId">작성자</th>
								<th class="sort mb-1 text-center" data-sort="mdfcnDt">작성일</th>
								<th class="sort mb-1 text-center" data-sort="inqCnt">조회수</th>
							</tr>
						</thead>
						<tbody class="list">
							<!-- 리스트 읽어오기 -->
							<c:forEach var="noticeVO" items="${data}" varStatus="stat">
								<tr >
									<td class="rownum mb-1 text-center"> ${noticeVO.rownum}</td>
									<td class="pstNo mb-1 text-center"> ${noticeVO.headerAsKor}</td>
									<td class="pstTtl mb-1 ps-4"><a href="/notice/detail?pstNo=${noticeVO.pstNo}" style="color:black"> ${noticeVO.pstTtl}</a></td>
									<td class="userId mb-1 text-center">${noticeVO.userNm}</td>
									<td class="mdfcnDt mb-1 text-center"><fmt:formatDate value="${noticeVO.mdfcnDt}" pattern="yyyy-MM-dd" />
									<td class="inqCnt mb-1 text-center">${noticeVO.inqCnt}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- 페이징 -->
				<div class="d-flex justify-content-center mt-3">
					<button class="btn btn-sm btn-falcon-default me-1" type="button" title="Previous" data-list-pagination="prev">
						<span class="fas fa-chevron-left"></span>
					</button>
					<ul class="pagination mb-0"></ul>
					<button class="btn btn-sm btn-falcon-default ms-1" type="button" title="Next" data-list-pagination="next">
						<span class="fas fa-chevron-right"> </span>
					</button>
				</div>
			</div>
		</div>
	</div>