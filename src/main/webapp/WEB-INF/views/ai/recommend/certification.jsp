<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- certification!!! -->
<%-- ${data} --%>


<div class="card mb-3">
	<div class="card-header">
		<div class="min-vh-50">
			<!-- 하얀 배경 -->
			<div>
				<div style="float: left; width: 100px; padding: 10px">
					<img src="/resources/image/robot.png" width="100%">
				</div>
				<div style="padding: 30px">
					<sec:authorize access="isAuthenticated()">
						<p>
							<sec:authentication property="principal.userVO.userNm"/>님의 부서와 연차 등을 고려하여 가장 적합한 자격증을 추천해 드립니다.<br /> 추천드리는 자격증은 아래와
							같습니다.
						</p>
					</sec:authorize>
				</div>
			</div>
			<div class="table table-fixed">
				<table class="table table-hover table-striped overflow-hidden">
					<thead>
						<tr style="text-align:center">
							<th scope="col" style="width: 5%">순위</th>
							<th scope="col" style="width: 15%">추천 자격증명</th>
							<th scope="col" style="width: 35%">설명</th>
							<th scope="col" style="width: 10%">관련 홈페이지</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${data}" var="certification" varStatus="status">
							<tr class="align-middle">
								<td class="text-nowrap">
									<div class="d-flex align-items-center">
										<div class="ms-2" style="text-align:center">1</div>
									</div>
								</td>
								<td class="text-center" style="text-align:center">${certification.certification1}</td>
								<td class="">${certification.description1}</td>
								<td class="text-center">
									<a href="${certification.url1}" target="_blank">
									  <span class="fab fa-sistrix"></span>
									</a>
								</td>
								
							</tr>
							<tr class="align-middle">
								<td class="text-nowrap">
									<div class="d-flex align-items-center">
										<div class="ms-2" style="text-align:center">2</div>
									</div>
								</td>
								<td class="text-center" style="text-align:center">${certification.certification2}</td>
								<td class="">${certification.description2}</td>
								<td class="text-center">
									<a href="${certification.url2}" target="_blank">
									  <span class="fab fa-sistrix"></span>
									</a>
								</td>
							</tr>
							<tr class="align-middle">
								<td class="text-nowrap">
									<div class="d-flex align-items-center">
										<div class="ms-2" style="text-align:center">3</div>
									</div>
								</td>
								<td class="text-center" style="text-align:center">${certification.certification3}</td>
								<td class="">${certification.description3}</td>
								<td class="text-center">
									<a href="${certification.url3}" target="_blank">
									  <span class="fab fa-sistrix"></span>
									</a>
								</td>
							</tr>
							<tr class="align-middle">
								<td class="text-nowrap">
									<div class="d-flex align-items-center">
										<div class="ms-2" style="text-align:center">4</div>
									</div>
								</td>
								<td class="text-center" style="text-align:center">${certification.certification4}</td>
								<td class="">${certification.description4}</td>
								<td class="text-center">
									<a href="${certification.url4}" target="_blank">
									  <span class="fab fa-sistrix"></span>
									</a>
								</td>
							</tr>
							<tr class="align-middle">
								<td class="text-nowrap">
									<div class="d-flex align-items-center">
										<div class="ms-2" style="text-align:center">5</div>
									</div>
								</td>
								<td class="text-center" style="text-align:center">${certification.certification5}</td>
								<td class="">${certification.description5}</td>
								<td class="text-center">
									<a href="${certification.url5}" target="_blank">
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

