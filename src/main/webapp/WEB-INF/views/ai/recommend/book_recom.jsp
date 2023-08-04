<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!--     해당 페이지는 자료를 확인하기 위한 테스트 페이지 입니다 -->
<%-- 	${data} --%>


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
							<sec:authentication property="principal.userVO.userNm" />
							님의 부서, 직급 그리고 관심분야 등을 고려하여 가장 적합한 자기계발 도서를 추천해 드립니다.
							<br />
							추천드리는 도서는 아래와 같습니다.
						</p>
					</sec:authorize>
				</div>
			</div>
			<div class="table table-fixed">
				<table class="table table-hover table-striped overflow-hidden">
					<thead>
						<tr style="text-align: center">
							<th scope="col" style="width: 7%">순위</th>
							<th scope="col" style="width: 35%">제목</th>
							<th scope="col" style="width: 15%">작가</th>
							<th scope="col" style="width: 30%">출판사</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${data}" var="book" varStatus="status">
							<tr class="align-middle">
<!-- 								<td class="text-nowrap"> -->
<!-- 									<div class="d-flex align-items-center"> -->
<!-- 										<div class="ms-2" style="text-align: center">1</div> -->
<!-- 									</div> -->
<!-- 								</td> -->
								<td class="text-center">${(status.count - 1) * 3 + 1}</td>
								<td>${book.bookNm1}</td>
								<td class="text-center">${book.author1}</td>
								<td class="text-center">${book.publisher1}</td>
							</tr>
							<tr class="align-middle">
								<td class="text-center">${(status.count - 1) * 3 + 2}</td>
								<td>${book.bookNm2}</td>
								<td class="text-center">${book.author2}</td>
								<td class="text-center">${book.publisher2}</td>
							</tr>
							<tr class="align-middle">
								<td class="text-center">${(status.count - 1) * 3 + 3}</td>
								<td>${book.bookNm3}</td>
								<td class="text-center">${book.author3}</td>
								<td class="text-center">${book.publisher3}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 하얀 배경 -->
	</div>
</div>