<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<meta http-equiv='Content-Type' content='application/vnd.ms-excel; charset=utf-8'/>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.userVO.userId" var="loginId" />
	<sec:authentication property="principal.userVO.userNm" var="loginName" />
</sec:authorize>
<div class="container">
	<div class="row">
		<div class="card mb-3">
			<div class="card-header ">
				<div class="row flex-between-end">
					<div class="col-auto align-self-center">
						<h3 class="mb-0">전 직원 연차정보관리</h3>
						<p class="mb-0 pt-1 mt-2 mb-0"></p>
					</div>
<!-- 		<h5 class="card-title">전 직원 연차정보관리</h5> -->
<!-- 		<div class="card shadow-none"> -->
			<div class="card-body p-0 pb-3">
				<div id="tableExample3"
					data-list='{"valueNames":["userId","userNm","deptNoNm","totalVacGrntDays","totalCnyDay","remainDays","workingYear","hdofCdNm"],"page":15,"pagination":true}'>
					<div class="d-flex align-items-center my-3 justify-content-between">
						<div class="ms-3">
							<form>
								<div class="input-group">
									<input class="form-control form-control-sm shadow-none search"
										type="search" placeholder="부서명 또는 이름 검색" aria-label="search" />
									<div class="input-group-text bg-transparent">
										<span class="fa fa-search fs--1 text-600"></span>
									</div>
								</div>
							</form>
						</div>
						<div id="bulk-select-replace-element" class="ms-3">
							<button class="btn btn-falcon-success btn-sm" type="button"
								id="allEmployees">
								<span class="fas fa-plus" data-fa-transform="shrink-3 down-2"></span>
								<span class="ms-1">전체 인원 엑셀 다운로드</span>
							</button>
						</div>
						<div class="d-none ms-3 col-auto d-flex justify-content-end"
							id="bulk-select-actions">
							<div class="d-flex">
								<select class="form-select form-select-sm"
									aria-label="Bulk actions">
									<option selected="selected" id="someEmployees">엑셀
										다운로드 받기</option>
									<option id="sendMail">메일 보내기</option>
								</select>
								<button class="btn btn-falcon-danger btn-sm ms-2" type="button"
									id="apply">Apply</button>
							</div>
						</div>
					</div>
					<div class="table-responsive scrollbar">
						<table class="table mb-0" id="myTable">
							<thead class="text-black bg-200">
								<tr>
									<th class="align-middle white-space-nowrap">
										<div class="form-check mb-0">
											<input class="form-check-input" type="checkbox"
												data-bulk-select='{"body":"bulk-select-body","actions":"bulk-select-actions","replacedElement":"bulk-select-replace-element"}' />
										</div>
									</th>
									<th class="align-middle sort userId text-center" data-sort="userId">아이디</th>
									<th class="align-middle sort text-center" data-sort="userNm">이름</th>
									<th class="align-middle sort text-center" data-sort="deptNoNm">부서명</th>
									<th class="align-middle sort text-center" data-sort="totalVacGrntDays">발생연차</th>
									<th class="align-middle sort text-center" data-sort="totalCnyDay">사용연차</th>
									<th class="align-middle sort text-center" data-sort="remainDays">잔여연차</th>
									<th class="align-middle sort text-center" data-sort="workingYear">근속
										연수</th>
									<th class="align-middle sort text-center" data-sort="hdofCdNm">상태</th>
								</tr>
							</thead>

							<tbody id="bulk-select-body" class="list">
								<c:forEach var="vacation" items="${data}" varStatus="stat">
									<tr>
										<td class="align-middle white-space-nowrap">
											<div class="form-check mb-0">
												<input class="form-check-input" type="checkbox"
													id="checkbox-1" data-bulk-select-row="data-bulk-select-row" />
											</div>
										</td>
										<td class="userId text-center" >${vacation.userId}</td>
										<td class="userNm text-center" style="cursor: pointer;">${vacation.userNm}</td>
										<td class="deptNoNm text-center">${vacation.deptNoNm}</td>
										<td class="totalVacGrntDays text-center">${vacation.totalVacGrntDays}</td>
										<td class="totalCnyDay text-center">${vacation.totalCnyDay}</td>
										<td class="remainDays text-center">${vacation.remainDays}</td>
										<td class="workingYear text-center">${vacation.workingYear}</td>
										<td class="hdofCdNm text-center">${vacation.hdofCdNm}</td>

									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<div class="d-flex justify-content-center mt-3">
						<button class="btn btn-sm btn-falcon-default me-1" type="button"
							title="Previous" data-list-pagination="prev">
							<span class="fas fa-chevron-left"></span>
						</button>
						<ul class="pagination mb-0"></ul>
						<button class="btn btn-sm btn-falcon-default ms-1" type="button"
							title="Next" data-list-pagination="next">
							<span class="fas fa-chevron-right"></span>
						</button>
					</div>
					<!-- 상세 모달 시작-->
					<div class="modal fade" id="viewData" data-keyboard="false"
						tabindex="-1" aria-labelledby="scrollinglongcontentLabel"
						aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content border-0">
								<div class="modal-header">
									<h5 class="modal-title" id="scrollinglongcontentLabel">인사정보_연차</h5>
									<button class="btn-close" type="button" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div
									class="modal-body modal-dialog modal-dialog-scrollable mx-0 ">
									<p style="">연차 사용내역 입니다</p>
									<table class="table table-bordered align-middle text-align">
										<colgroup>
											<col width="12%">
											<col width="15%">
											<col width="18%">
											<col width="18%">
											<col width="12%">
											<col width="25%">
										</colgroup>
										<tbody id="dataRows">
											<tr>
												<td class="bg-primary-subtle text-center ">번호</td>
												<td class="bg-primary-subtle text-center ">휴가종류</td>
												<td class="bg-primary-subtle text-center ">시작일자</td>
												<td class="bg-primary-subtle text-center ">종료일자</td>
												<td class="bg-primary-subtle text-center ">사용일수</td>
												<td class="bg-primary-subtle text-center ">내용</td>
											</tr>
											<tr id="currentYearData">
												<td class="text-center count" id="count"></td>
												<td class="text-center vacTpNm" id="vacTpNm"></td>
												<td class="text-center bgngDt" id="bgngDt"></td>
												<td class="text-center endDt" id="endDt"></td>
												<td class="text-center cnyDay" id="cnyDay"></td>
												<td class="text-center vacRsn" id="vacRsn"></td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="modal-footer">
									<button class="btn btn-secondary" type="button"
										data-bs-dismiss="modal">닫기</button>
								</div>
							</div>
						</div>
					</div>
					<!-- 상세 모달 끝-->
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<%-- data ==> ${data} --%>
<script type="text/javascript">
	// 세션에서 받아온 아이디
	var loginIdSession = '${loginId}'
	console.log("세션에서 받아온 로그인아이디 : ", loginIdSession);

	//console.log(${data[2].totalVacGrntDays})

	var userNm = $(".userNm").val();
	console.log(userNm)

	//엑셀다운로드 컨트롤러이동
	$("#allEmployees").click(function() {
		location.href = "/empinfo/excelDown";

	});

	//아이디 숨기기
	var elements = document.querySelectorAll('[class*="userId"]');
	for (var i = 0; i < elements.length; i++) {
		elements[i].classList.add('d-none');
	}

	//이름 클릭시 상세정보 모달 띄우기
	$(".userNm")
			.click(
					function() {
						var userNm = $(this).text().trim();
						var userId = $(this).closest("tr").find(".userId")
								.text().trim();
						console.log("이름: " + userNm + ", 아이디: " + userId);

						$("#viewData").modal("show");

						var data = {
							"userId" : userId
						}

						$
								.ajax({
									url : "/empinfo/vacinfoemployee",
									contentType : "application/json;charset=utf-8",
									data : JSON.stringify(data),
									type : "post",

									beforeSend : function(xhr) {
										xhr.setRequestHeader(
												"${_csrf.headerName}",
												"${_csrf.token}");
									},
									success : function(response) {
										console.log("성공");
										console.log("상세 정보 요청 성공:", response);

										var tableBody = $("#dataRows");
										tableBody.empty();
										var header = '<tr>'
												+ '<td class="bg-primary-subtle text-center ">번호</td>'
												+ '<td class="bg-primary-subtle text-center ">휴가종류</td>'
												+ '<td class="bg-primary-subtle text-center ">시작일자</td>'
												+ '<td class="bg-primary-subtle text-center ">종료일자</td>'
												+ '<td class="bg-primary-subtle text-center ">사용일수</td>'
												+ '<td class="bg-primary-subtle text-center ">내용</td>'
												+ '</tr>';
										$("#dataRows").append(header);

										$
												.each(
														response,
														function(index, item) {

															var vacTpNm = item.vacTpNm;
															var formattedBgngDt = new Date(
																	item.bgngDt)
																	.toLocaleDateString();
															var formattedEndDt = new Date(
																	item.endDt)
																	.toLocaleDateString();
															var cnyDay = item.cnyDay;
															var vacRsn = item.vacRsn;

															var row = '<tr>'
																	+ '<td class="text-center count">'
																	+ (index + 1)
																	+ '</td>'
																	+ '<td class="text-center vacTpNm">'
																	+ vacTpNm
																	+ '</td>'
																	+ '<td class="text-center bgngDt">'
																	+ formattedBgngDt
																	+ '</td>'
																	+ '<td class="text-center endDt">'
																	+ formattedEndDt
																	+ '</td>'
																	+ '<td class="text-center cnyDay">'
																	+ cnyDay
																	+ '</td>'
																	+ '<td class="text-center vacRsn">'
																	+ vacRsn
																	+ '</td>'
																	+ '</tr>';

															$("#dataRows")
																	.append(row);
														});

									},
									error : function(xhr, status, error) {
										console.log("에러 발생:", error);
									}

								}); //ajax

					});

	//Apply 버튼 클릭 시 선택된 직원 정보를 서버로 전송
	$("#apply").click(function() {
				var selectedEmployees = [];
				$("input[data-bulk-select-row]:checked").each(function() {
							var userNm = $(this).closest("tr").find(".userNm").text().trim();
							var deptNoNm = $(this).closest("tr").find(".deptNoNm").text().trim();
							var totalVacGrntDays = $(this).closest("tr").find(".totalVacGrntDays").text().trim();
							var totalCnyDay = $(this).closest("tr").find(".totalCnyDay").text().trim();
							var remainDays = $(this).closest("tr").find(".remainDays").text().trim();
							var workingYear = $(this).closest("tr").find(".workingYear").text().trim();
							var hdofCdNm = $(this).closest("tr").find(".hdofCdNm").text().trim();

							var employee = {
								'userNm' : userNm,
								'deptNoNm' : deptNoNm,
								'totalVacGrntDays' : totalVacGrntDays,
								'totalCnyDay' : totalCnyDay,
								'remainDays' : remainDays,
								'workingYear' : workingYear,
								'hdofCdNm' : hdofCdNm
							};

							selectedEmployees.push(employee);
						});

				if (selectedEmployees.length > 0) {
					// AJAX 요청으로 선택된 직원 정보를 서버로 전송
					$.ajax({
						url : '/empinfo/sendSelectedEmployees',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(selectedEmployees),
						beforeSend : function(xhr) {
							xhr.setRequestHeader("${_csrf.headerName}",
									"${_csrf.token}");
						}, 
					    xhrFields:{
					        responseType: 'blob'
					    },
						success : function(result) {
					        console.log(result)
					       // alert("sfa");
					        var blob = new Blob([result], { type: 'application/vnd.ms- excel' });
// 					        var blob = new Blob([result], { type: 'application/ms-vnd/excel' });
					        var downloadUrl = URL.createObjectURL(blob);
					        var a = document.createElement("a");
					        a.href = downloadUrl;
					        a.download = "downloadFile.xlsx";
					        document.body.appendChild(a);
					        a.click();

						},
						error : function(xhr, status, error) {
							console.log("에러");
						}
					});

				}
			});
</script>