<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style>
td:hover{
	background-color: #f5f5f5;
}
</style>

<c:set var="list" value="${artiList}"/>
<div class="card mb-3">
	<div class="card-header">
		<div class="min-vh-50">
			<!-- 하얀 배경 -->
			<div>
				<div style="float: left; width: 100px; padding: 10px">
					<img src="/resources/image/robot.png" width="100%">
				</div>
				<div class="align-items-center" style="padding: 30px">
					<sec:authorize access="isAuthenticated()">
						<p class="mt-2">
							최신 기사의 내용을 간략하게 요약해서 보여드립니다.
						</p>
					</sec:authorize>
				</div>
			</div>
			<div class="table table-fixed">
				<table class="table overflow-hidden">
					<thead>
						<tr class="text-center">
							<th class="col-1">번호</th>
							<th class="col-9">제목</th>
							<th class="col-2">본 기사 링크</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="item" varStatus="status">
							<tr class="align-middle">
								<td class="col-1">
									<div class="text-center">${item.rownum}</div>
								</td>
								<td class="col-9">${item.artiTtl}</td>
								<td class="col-2 text-center">
								</td>
							</tr>
							<tr class="align-middle">
								<td>
								</td>
								<td>
									${item.artiCn}
								</td>
								<td class="col-2 text-center">
									<a href="${item.url}" target="_blank">
									  <span class="fab fa-sistrix"></span>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 하얀 배경 -->
	</div>
</div>

