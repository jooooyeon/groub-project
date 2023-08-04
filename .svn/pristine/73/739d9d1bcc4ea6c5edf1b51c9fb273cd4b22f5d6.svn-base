<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<body>
<div class="container">
	<div class="row">
		<div class="card mb-3">
			<div class="card-header ">
				<div class="row flex-between-end">
					<div class="col-auto align-self-center">
						<h3 class="mb-0" >인사정보</h3>
						<p class="mb-0 pt-1 mt-2 mb-0"></p>
					</div>
			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal.userVO.userId" var="loginId" />
				<sec:authentication property="principal.userVO.userNm"
					var="loginName" />
			</sec:authorize>
			<!-- border-primary 빼면 파란색 보더 사라짐 -->
			<table
				class="table table-bordered align-middle text-align border border-2">
				<colgroup>
					<col width="20%">
					<col width="15%">
					<col width="25%">
					<col width="15%">
					<col width="25%">
				</colgroup>
				<tbody>
					<tr>
						<td rowspan="4" class="text-center img-fluid m-1 p-1">
							<img src=${data.userImg } width="100%" height="100%">
						</td>
						<td class="bg-primary-subtle text-center">이름</td>
						<td colspan="3" >${data.userNm}</td>
					</tr>
					<tr>
						<td class="bg-primary-subtle text-center">소속</td>
						<td colspan="3">${data.coNm }${data.deptNm}</td>
					</tr>
					<tr>
						<td class="bg-primary-subtle text-center">사번</td>
						<td class="text-center" id="splitUserId"></td>
						<td class="bg-primary-subtle text-center">휴대번호</td>
						<td class="text-center" id="phoneNo"></td>
					</tr>
					<tr>
						<td class="bg-primary-subtle text-center">직급/직무</td>
						<td class="text-center">${data.jbgdCdNm}/${data.jbtlCdNm}</td>
						<td class="bg-primary-subtle text-center">메일주소</td>
						<td class="text-center">${data.userEml}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	</div>
	<div id="commentArea" class="card mb-3">
		<div class="card-body">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link active"
					id="emp-info-basic-nav" data-bs-toggle="tab" href="#emp-info-basic"
					role="tab" aria-controls="emp-info-basic" aria-selected="true">기본정보</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					id="emp-info-personal-nav" data-bs-toggle="tab"
					href="#emp-info-personal" role="tab"
					aria-controls="emp-info-personal" aria-selected="false">신상정보</a></li>
				<li class="nav-item"><a class="nav-link "
					id="emp-info-dept-nav" data-bs-toggle="tab" href="#emp-info-dept"
					role="tab" aria-controls="emp-info-dept" aria-selected="false">직무/담당</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					id="emp-info-certification-nav" data-bs-toggle="tab"
					href="#emp-info-certification" role="tab"
					aria-controls="tab-contact" aria-selected="false">자격증</a></li>
				<li class="nav-item"><a class="nav-link"
					id="emp-info-family-nav" data-bs-toggle="tab"
					href="#emp-info-family" role="tab" aria-controls="tab-contact"
					aria-selected="false">가족정보</a></li>
			</ul>
			<div class="tab-content  border-top-0 p-3" id="myTabContent">
				<div class="tab-pane fade show active" id="emp-info-basic"
					role="tabpanel" aria-labelledby="emp-info-basic">
					<table
						class="table table-bordered align-middle text-align border border-2">
						<colgroup>
							<col width="15%">
							<col width="18%">
							<col width="15%">
							<col width="18%">
							<col width="15%">
							<col width="18%">
						</colgroup>
						<tbody>
							<tr>
								<td class="text-center bg-primary-subtle">입사일</td>
								<td class="text-center"><fmt:formatDate
										value="${data.jncmpYmd}" pattern="yyyy-MM-dd" /></td>
								<td class="text-center bg-primary-subtle">성별</td>
								<td class="text-center" id="gndrMf"></td>
								<td class="text-center bg-primary-subtle">병역이행여부</td>
								<td class="text-center">${data.mtrscCdNm }</td>
							</tr>
							<tr>
								<td class="text-center bg-primary-subtle">생년월일</td>
								<td class="text-center"><fmt:formatDate
										value="${data.brthYmd}" pattern="yyyy-MM-dd" /></td>
								<td class="text-center bg-primary-subtle">재직상태</td>
								<td class="text-center">${data.hdofCdNm}</td>
								<td class="text-center bg-primary-subtle">퇴사일</td>
								<td class="text-center">${data.rsgntnYmd}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="tab-pane fade" id="emp-info-personal" role="tabpanel"
					aria-labelledby="emp-info-personal">
					<table class="table table-bordered align-middle text-align border border-2">
						<colgroup>
							<col width="15%">
							<col width="35%">
							<col width="15%">
							<col width="35%">
						</colgroup>
						<tbody>
							<tr class="empInfoPersonalDiv">
								<td class="text-center bg-primary-subtle">취미</td>
								<c:if test="${data.hobby == NULL}">
									<td class="text-center"></td>
								</c:if>
								<c:if test="${data.hobby!=null}">
									<td class="text-center">${data.hobby}</td>
								</c:if>
								<td class="text-center bg-primary-subtle">특기</td>
								<c:if test="${data.spcabl == NULL}">
									<td class="text-center"></td>
								</c:if>
								<c:if test="${data.spcabl != NULL}">
									<td class="text-center">${data.spcabl}</td>
								</c:if>
							</tr>
							<tr class="empInfoPersonalDiv">
								<td class="text-center bg-primary-subtle">주소</td>
								<td class="text-center" colspan="3">(${data.userZip})
									${data.userAddr } ${data.userDaddr}</td>
							</tr>


							<tr class="regEmpInfoPersonalDiv text-center"
								style="display: none;">
								<td class="text-center bg-primary-subtle">취미</td>
								<td class="text-center"><input class="form-control"
									type="text" id="regHobby" style="text-align: center;"
									value="${data.hobby}"></td>
								<td class="text-center bg-primary-subtle">특기</td>
								<td class="text-center"><input class="form-control"
									type="text" id="regSpecial" style="text-align: center;"
									value="${data.spcabl}"></td>
							</tr>
							<tr class="regEmpInfoPersonalDiv" style="display: none;">
								<td class="text-center bg-primary-subtle">주소</td>
								<td class="text-center" colspan="3"><input id="regAddr"
									class="form-control" type="text" style="text-align: center;"
									value="(${data.userZip}) ${data.userAddr } ${data.userDaddr}">
								</td>
							</tr>
						</tbody>
					</table>
					<!-- 카카오주소 -->
					<div class="kakao" style="display: none;">
						<input class="form-control kakao" type="text"
							id="sample4_postcode" placeholder="우편번호">
						<!-- 					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br> -->
						<input class="form-control kakao" type="text"
							id="sample4_roadAddress" placeholder="도로명주소"> <input
							class="form-control kakao" type="text" id="sample4_jibunAddress"
							placeholder="지번주소"> <span id="guide"
							style="color: #999; display: none"></span> <input
							class="form-control kakao" type="text" id="sample4_detailAddress"
							placeholder="상세주소"> <input class="form-control kakao"
							type="text" id="sample4_extraAddress" placeholder="참고항목">
					</div>
					<div class="d-flex justify-content-end">
						<button id="btnRegEmpInfoPersonal" class="btn btn-primary me-3">변경</button>

					</div>
					<div class="d-flex justify-content-between">
						<button id="cancleBtnRegEmpInfoPersonal"
							class="btn btn-secondary me-3" style="display: none;"
							onclick="location.href ='/empinfo/empinfo'">취소</button>
						<button id="submitBtnRegEmpInfoPersonal"
							class="btn btn-primary me-3" style="display: none;">저장</button>
					</div>
				</div>
				<div class="tab-pane fade" id="emp-info-dept" role="tabpanel"
					aria-labelledby="emp-info-dept">
					<div
						data-list='{"valueNames":["count","deptNoRecord","jbgdCdNmRecord","jbtlCdNmRecord","bgngYmd","endYmd","hrRcrdExpln"],"pagination":true}'>
						<table
							class="table table-bordered align-middle text-align table-bordered scrollbar border border-2">
							<colgroup>
								<col width="10%">
								<col width="15%">
								<col width="15%">
								<col width="15%">
								<col width="15%">
								<col width="15%">
								<col width="15%">
							</colgroup>
							<thead>
								<tr>
									<td class="text-center bg-primary-subtle sort"
										data-sort="count">번호</td>
									<td class="text-center bg-primary-subtle sort"
										data-sort="deptNoRecord">부서</td>
									<td class="text-center bg-primary-subtle sort"
										data-sort="jbgdCdNmRecord">직급</td>
									<td class="text-center bg-primary-subtle sort"
										data-sort="jbtlCdNmRecord">직책</td>
									<td class="text-center bg-primary-subtle sort"
										data-sort="bgngYmd">시작일</td>
									<td class="text-center bg-primary-subtle sort"
										data-sort="endYmd">종료일</td>
									<td class="text-center bg-primary-subtle sort"
										data-sort="hrRcrdExpln">변경사유</td>
								</tr>
							</thead>
							<tbody class="list">
								<c:forEach var="hrRcrdVO" items="${data.hrRcrdVO}"
									varStatus="stat">
									<tr>
										<td class="text-center count">${stat.count}</td>
										<td class="text-center deptNoRecord">${hrRcrdVO.deptNoRecord}</td>
										<td class="text-center jbgdCdNmRecord">${hrRcrdVO.jbgdCdNmRecord}</td>
										<td class="text-center jbtlCdNmRecord">${hrRcrdVO.jbtlCdNmRecord}</td>
										<td class="text-center bgngYmd"><fmt:formatDate
												value="${hrRcrdVO.bgngYmd}" pattern="yyyy-MM-dd" /></td>
										<td class="text-center endYmd"><fmt:formatDate
												value="${hrRcrdVO.endYmd}" pattern="yyyy-MM-dd" /></td>
										<td class="text-center hrRcrdExpln">${hrRcrdVO.hrRcrdExpln}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="emp-info-certification"
					role="tabpanel" aria-labelledby="emp-info-certification">
					<table
						class="table table-bordered align-middle text-align crtfctArea border border-2">
						<colgroup>
							<col width="10%">
							<col width="25%">
							<col width="20%">
							<col width="15%">
							<col width="20%">
							<col width="10%">
						</colgroup>

						<thead>
							<tr>
								<td class="text-center bg-primary-subtle">번호</td>
								<td class="text-center bg-primary-subtle">자격증명</td>
								<td class="text-center bg-primary-subtle">자격증 번호</td>
								<td class="text-center bg-primary-subtle">점수/등급</td>
								<td class="text-center bg-primary-subtle">취득일</td>
								<td class="text-center bg-primary-subtle">삭제</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="crtfct" items="${data.empInfoCertificationVO}"
								varStatus="stat">
								<tr>
									<td class="text-center">${stat.count}</td>
									<td class="text-center">${crtfct.crtfctNoNm}</td>
									<td class="text-center">${crtfct.crtfctIssuNo}</td>
									<c:if test="${crtfct.crtfctScr == 0}">
										<td class="text-center">-</td>
									</c:if>
									<c:if test="${crtfct.crtfctScr != 0}">
										<td class="text-center">${crtfct.crtfctScr}</td>
									</c:if>
									<td class="text-center"><fmt:formatDate
											value="${crtfct.crtfctAcqsYmd}" pattern="yyyy-MM-dd" /></td>
									<td class="text-center">
										<button data-cr-acqs-no="${crtfct.crAcqsNo}"
											class=" trashCanIcon far fa-trash-alt" type="button"
											data-bs-toggle="modal" data-bs-target="#scrollinglongcontent"></button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<table
						class="InsertCrtfctArea table table-bordered align-middle text-align border border-2"
						style="display: none;">
						<tr>
							<td class="text-center bg-primary-subtle">자격증명</td>
							<td class="text-center bg-primary-subtle">자격증 번호</td>
							<td class="text-center bg-primary-subtle">점수/등급</td>
							<td class="text-center bg-primary-subtle">취득일</td>
						</tr>
						<tr>
							<td class="text-center">
								<div class="form-group">
									<select class="form-select selectpicker " id="crtfctNo"
										data-options='{"placeholder":"자격증을 선택해주세요"}' required>
										<option selected disabled>자격증을 선택해주세요</option>
										<c:forEach var="crtfctVO" items="${crtfct}" varStatus="stat">
											<option value="${crtfctVO.crtfctNo}">${crtfctVO.crtfctNm}</option>
										</c:forEach>
									</select>
								</div>
							</td>
							<td class="text-center"><input class="form-control"
								type="text" id="crtfctIssuNo" style="text-align: center;"></td>
							<td class="text-center"><input class="form-control"
								type="text" id="crtfctScr" style="text-align: center;"></td>
							<td class="text-center"><input class="form-control"
								type="date" id="crtfctAcqsYmd" style="text-align: center;"></td>
						</tr>
					</table>

					<!-- 자격증 추가 -->
					<div class="d-flex justify-content-end">
						<button id="btnUpdEmpInfocrtfct" class="btn btn-primary me-3">추가</button>
					</div>
					<!-- 자격증 저장 -->
					<div class="d-flex justify-content-between d-none">
						<button id="cancleBtnUpdEmpInfocrtfctConfirm"
							class="btn btn-secondary me-3" style="display: none;"
							onclick="location.href ='/empinfo/empinfo'">취소</button>
						<button id="btnUpdEmpInfocrtfctConfirm"
							class="btn btn-primary me-3" type="button" data-bs-toggle="modal"
							data-bs-target="#scrollinglongcontent2">저장</button>
					</div>
					<!-- 자격증 삭제 모달 시작-->
					<div class="modal fade" id="scrollinglongcontent"
						data-keyboard="false" tabindex="-1"
						aria-labelledby="scrollinglongcontentLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="scrollinglongcontentLabel">인사정보_자격증</h5>
									<button class="btn-close" type="button" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body modal-dialog modal-dialog-scrollable">
									<p style="">삭제하시겠습니까?</p>
								</div>
								<div class="modal-footer">
									<button class="btn btn-primary" type="button" id="btnDelCrt">확인</button>
									<button class="btn btn-secondary" type="button"
										data-bs-dismiss="modal">취소</button>
								</div>
							</div>
						</div>
					</div>
					<!-- 자격증 삭제 모달 끝-->
					<!-- 자격증 추가 모달 시작-->
					<div class="modal fade" id="scrollinglongcontent2"
						data-keyboard="false" tabindex="-1"
						aria-labelledby="scrollinglongcontentLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="scrollinglongcontentLabel">인사정보_자격증</h5>
									<button class="btn-close" type="button" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body modal-dialog modal-dialog-scrollable">
									<p style="">추가하시겠습니까?</p>
								</div>
								<div class="modal-footer">
									<button class="btn btn-primary" type="button" id="btnInsertCrt">확인</button>
									<button class="btn btn-secondary" type="button"
										data-bs-dismiss="modal">취소</button>
								</div>
							</div>
						</div>
					</div>
					<!-- 자격증 추가 모달 끝-->
				</div>
				<div class="tab-pane fade" id="emp-info-family" role="tabpanel"
					aria-labelledby="emp-info-family">

					<table
						class="table table-bordered align-middle text-align border border-2"
						id="famInfo">
						<colgroup>
							<col width="10%">
							<col width="15%">
							<col width="10%">
							<col width="15%">
							<col width="15%">
							<col width="10%">
						</colgroup>
						<thead>
							<tr>
								<td class="text-center bg-primary-subtle">번호</td>
								<td class="text-center bg-primary-subtle">성명</td>
								<td class="text-center bg-primary-subtle">가족관계</td>
								<td class="text-center bg-primary-subtle">성별</td>
								<td class="text-center bg-primary-subtle">생년월일</td>
								<td class="text-center bg-primary-subtle">삭제</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="fam" items="${data.famVO}" varStatus="stat">
								<tr>
									<td class="text-center">${stat.count}</td>
									<td class="text-center">${fam.famNm}</td>
									<td class="text-center">${fam.famRelCdNm}</td>
									<c:if test="${fam.gndrMfFam == 'M'}">
										<td class="text-center ">남성</td>
									</c:if>
									<c:if test="${fam.gndrMfFam == 'W'}">
										<td class="text-center ">여성</td>
									</c:if>
									<td class="text-center" id="brthYmdFam"><fmt:formatDate
											value="${fam.brthYmdFam}" pattern="yyyy-MM-dd" /></td>
									<td class="text-center">
										<button data-fam-no="${fam.famNo}"
											class=" trashCanIcon far fa-trash-alt" type="button"
											data-bs-toggle="modal" data-bs-target="#deleteFamModal"></button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- 가족 변경 테이블 -->
					<form id="frmFamily" name="frmFamily" action="/empinfo/updateFam"
						method="post">
						<input type="hidden" name="userId" value="${data.userId}" />
						<table
							class="table table-bordered align-middle text-align border border-2"
							style="display: none;" id="updateFam">
							<colgroup>

								<col width="15%">
								<col width="10%">
								<col width="10%">
								<col width="15%">
							</colgroup>
							<thead>
								<tr>
									<td class="text-center bg-primary-subtle">성명</td>
									<td class="text-center bg-primary-subtle">가족관계</td>
									<td class="text-center bg-primary-subtle">성별</td>
									<td class="text-center bg-primary-subtle">생년월일</td>
								</tr>
							</thead>
							<tbody id="idTbody">
								<c:forEach var="fam" items="${data.famVO}" varStatus="stat0">
									<tr class="trFam">
										<td class="text-center famNm"><input class="form-control"
											type="text" name="famVO[${stat0.index}].famNm" id="famNm"
											style="text-align: center;" value="${fam.famNm}"> <input
											type="hidden" name="famVO[${stat0.index}].famNo" id="famNo"
											value="${fam.famNo}"> <input type="hidden"
											name="famVO[${stat0.index}].userId" id="userId"
											value="${data.userId}"></td>
										<td class="text-center">
											<div class="form-group">
												<select class="form-select"
													name="famVO[${stat0.index}].famRelCd" id="famRela"
													data-options='{"placeholder":"관계를 선택해 주세요"}'>
													<c:forEach var="famCode" items="${famManageCode}"
														varStatus="stat">
														<option value="${famCode.mngCd}"
															${fam.famRelCdNm == famCode.mngCdNm1 ? 'selected' : ''}>${famCode.mngCdNm1}</option>
													</c:forEach>
												</select>
											</div>
										</td>
										<td class="text-center">
											<div class="form-group">
												<select class="form-select"
													name="famVO[${stat0.index}].gndrMfFam" id="gender"
													data-options='{"placeholder":" 성별을 선택하세요"}'>
													<c:if test="${fam.gndrMfFam == 'M'}">
														<option value="M" selected>남성</option>
														<option value="W">여성</option>
													</c:if>
													<c:if test="${fam.gndrMfFam == 'W'}">
														<option value="M">남성</option>
														<option value="W" selected>여성</option>
													</c:if>
												</select>
											</div>
										</td>
										<td class="text-center"><input class="form-control"
											type="date" name="famVO[${stat0.index}].brthYmdFam"
											id="brthYmdFam" style="text-align: center;"
											value="<fmt:formatDate value="${fam.brthYmdFam}" pattern="yyyy-MM-dd"/>">

										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<sec:csrfInput />
					</form>

					<!-- 가족 삭제 모달 시작-->
					<div class="modal fade" id="deleteFamModal" data-keyboard="false"
						tabindex="-1" aria-labelledby="scrollinglongcontentLabel"
						aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="scrollinglongcontentLabel">인사정보_가족</h5>
									<button class="btn-close" type="button" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body modal-dialog modal-dialog-scrollable">
									<p style="">삭제하시겠습니까?</p>
								</div>
								<div class="modal-footer">
									<button class="btn btn-primary" type="button" id="btnDelFam">확인</button>
									<button class="btn btn-secondary" type="button"
										data-bs-dismiss="modal">취소</button>
								</div>
							</div>
						</div>
					</div>
					<!-- 가족 삭제 모달 끝-->
					<!-- 가족 수정 이동 -->
					<div class="d-flex justify-content-end">
						<button id="updatefampage" class="btn btn-primary me-3">수정</button>
					</div>
					<!-- 가족 추가 -->
					<div class="d-flex justify-content-between d-none">
						<button id="createFam" class="btn btn-primary me-3">추가</button>
						<div>
							<button id="btmUpdateFam" class="btn btn-primary me-3">저장</button>
							<button id="cancleUpdatefampage" class="btn btn-secondary me-3"
								onclick="location.href ='/empinfo/empinfo'"
								style="display: none;">취소</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>


</body>

<%-- ${data } --%>
<%-- ${crtfct } --%>
<%-- ${famManageCode } --%>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	window.onload = function() {

		//세션에서 받아온 아이디
		var loginIdSession = '${loginId}'
		console.log("세션에서 받아온 로그인아이디 : ", loginIdSession);

		var loginId = '${data.userId}'
		console.log("컨트롤러에서 받아온 로그인아이디 : ", loginId);

		if (loginIdSession == loginId) {
			console.log("동일인 로그인")
		}

		//아이디에서 사번 추출하기
		var splitUserId = '${data.userId}';
		splitUserId = splitUserId.split("_");

		//console.log("splitUserId : ", splitUserId)
		//console.log("splitUserId!!! : ", splitUserId[1])

		$("#splitUserId").text(splitUserId[1]);

		//휴대폰번호 하이픈 넣기
		var phoneNo = '${data.userTelno}'
		phoneNo = phoneNo.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
		//console.log(phoneNo)
		$("#phoneNo").text(phoneNo);

		//성별 가져오기
		var gndrMf = '${data.gndrMf}'
		//console.log(gndrMf)

		if (gndrMf == 'M') {
			$("#gndrMf").text("남성");
		} else if (gndrMf == 'W') {
			$("#gndrMf").text("여성");
		}

		//자격증 입력가능 화면
		$("#btnUpdEmpInfocrtfct").click(function() {
			//console.log("자격증 추가할거야")
			$(".InsertCrtfctArea").show();
			$(".crtfctArea").hide();
			$("#btnUpdEmpInfocrtfct").hide();
			$("#cancleBtnUpdEmpInfocrtfctConfirm").show();
			$("#btnUpdEmpInfocrtfctConfirm").parent().removeClass('d-none');

		});

		//자격증 정보 저장하기
		$("#btnInsertCrt").click(
				function() {
					var crtfctNo = $("#crtfctNo").val();
					var crtfctIssuNo = $("#crtfctIssuNo").val();
					var crtfctScr = $("#crtfctScr").val();
					var crtfctAcqsYmd = $("#crtfctAcqsYmd").val();
					var crtfctNoNm = $("#crtfctNo option:selected").text();

					// 		console.log("자격증 저장!")
					// 		console.log(crtfctNo);
					// 		console.log(crtfctIssuNo);
					// 		console.log(crtfctScr);
					// 		console.log(crtfctAcqsYmd);
					// 		console.log(loginIdSession);
					// 		console.log("ddd",crtfctNoNm);

					//자격증인증번호, 자격증 연결 번호, 자격증취득일, 유저아이디, 한글자격증명
					var data = {
						"crtfctIssuNo" : crtfctIssuNo,
						"crtfctNo" : crtfctNo,
						"crtfctAcqsYmd" : crtfctAcqsYmd,
						"userId" : loginIdSession,
						"crtfctNoNm" : crtfctNoNm
					};
					console.log(data)

					$.ajax({
						url : "/empinfo/insertCrtfct",
						contentType : "application/json;charset=utf-8",
						data : JSON.stringify(data),
						type : "post",
						dataType : "text",
						beforeSend : function(xhr) {
							xhr.setRequestHeader("${_csrf.headerName}",
									"${_csrf.token}");
						},
						success : function(result) {
							//alert("자격증추가성공")
							location.href = "/empinfo/empinfo";

						},
						error : function(xhr, status, error) {
							console.log("에러 발생:", error);
						}

					}); //ajax

				});

		//신상정보 수정하기
		$("#btnRegEmpInfoPersonal").click(function() {
			//console.log("btnRegEmpInfoPersonal cliked!")
			$(".regEmpInfoPersonalDiv").show();
			$(".empInfoPersonalDiv").hide();
			$("#btnRegEmpInfoPersonal").hide(); //수정하기들어오는 버튼
			$("#submitBtnRegEmpInfoPersonal").show(); //저장버튼
			$("#cancleBtnRegEmpInfoPersonal").show(); //취소버튼

			$("#regAddr").click(function() {
				var regAddr = $(this).val();
				//console.log(regAddr)
				$("#regAddr").val("");
				sample4_execDaumPostcode();
				$(".kakao").show();
				$("#regAddr").prop("disabled", true); //다시 주소입력 누르기 방지

			});

		});//btnRegEmpInfoPersonal

		//삭제버튼(휴지통)
		var crtfctNo;
		var famNo;
		$(".trashCanIcon").click(function() {
			//console.log("aaaaaaaaaaaaaa")
			crtfctNo = $(this).data("cr-acqs-no");
			famNo = $(this).data("fam-no");

			console.log(crtfctNo);
			console.log(famNo);

		})
		//자격증 삭제 모달의 확인 버튼
		$("#btnDelCrt").click(
				function() {
					console.log("난 자격증 삭제 모달의 확인 버튼!")
					//console.log(loginIdSession);
					console.log(crtfctNo);

					var data = {
						"crAcqsNo" : crtfctNo
					}
					console.log(data);

					$.ajax({
						url : "/empinfo/deleteCrtfct",
						contentType : "application/json;charset=utf-8",
						data : JSON.stringify(data),
						type : "post",
						dataType : "text",
						beforeSend : function(xhr) {
							xhr.setRequestHeader("${_csrf.headerName}",
									"${_csrf.token}");
						},
						success : function(result) {
							//alert("자격증삭제성공")
							location.href = "/empinfo/empinfo";

						},
						error : function(xhr, status, error) {
							console.log("에러 발생:", error);
						}

					}); //ajax

				});
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//가족추가입력
		$("#createFam").click(function() {
			let famCnt = $(".trFam").length;
			let userId = "${data.userId}";
			
			//var updateFam = $("#updateFam")
			console.log("가족 입력폼추가 : " + famCnt);
			
			let newTr = "<tr class='trFam'><td class='text-center famNm'><input class='form-control' type='text' name='famVO["+famCnt+"].famNm' id='famNm' style='text-align: center;' value='' required /><input type='hidden' name='famVO["+famCnt+"].famNo' id='famNo' value='"+(Number(famCnt)+1)+"'><input type='hidden' name='famVO["+famCnt+"].userId' id='userId' value='"+userId+"'></td>";
				newTr += "<td class='text-center'><div class='form-group'>";
				newTr += "<select class='form-select ' name='famVO["+famCnt+"].famRelCd' id='famRela' data-options='{&quot;placeholder&quot;:&quot;관계를 선택해 주세요&quot;}'>";
				newTr += "<option value='FM001'>본인</option><option value='FM002'>처</option><option value='FM003'>부</option>";
				newTr += "<option value='FM004' selected=''>모</option><option value='FM005'>자</option><option value='FM007'>남편</option>";
				newTr += "<option value='FM020'>형</option><option value='FM022'>제</option><option value='FM030'>누이</option>";
				newTr += "<option value='FM032'>매</option></select>";
				newTr += "</div></td>";
				newTr += "<td class='text-center'>";
				newTr += "<div class='form-group'>";
				newTr += "<select class='form-select' name='famVO["+famCnt+"].gndrMfFam' id='gender' data-options='{&quot;placeholder&quot;:&quot; 성별을 선택하세요&quot;}' required>";
				newTr += "<option value='M'>남성</option><option value='W' selected=''>여성</option>";
				newTr += "</select></div></td>";
				newTr += "<td class='text-center'><input class='form-control' type='date' name='famVO["+famCnt+"].brthYmdFam' id='brthYmdFam' style='text-align: center;' value=''>";
				newTr += "</td></tr>";
		
				$("#idTbody").append(newTr);
			
				famCnt++;
		});

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		$("#updatefampage").click(function() {
			console.log("가족수정페이지이동");
			$("#BtnUpdateFam").parent().removeClass('d-none');
			$("#updatefampage").hide();
			$("#cancleUpdatefampage").show();
			$("#updateFam").show();
			$("#createFam").parent().removeClass('d-none');
			$("#famInfo").hide();
		});

		//가족 수정양식에서 값 가져오기!
		$("#btmUpdateFam")
				.click(
						function() {

							var table = document.getElementById("updateFam");
							var rowList = table.rows;

							for (var i = 1; i < rowList.length; i++) {
								var row = rowList[i];

								var famNo = row.querySelector("#famNo").value;
								var famNm = row.querySelector("#famNm").value;

								var famRelaSelect = row
										.querySelector("#famRela");
								var selectedOption = famRelaSelect.options[famRelaSelect.selectedIndex];
								var famRela = selectedOption.value;

								var brthYmdFam = row
										.querySelector("#brthYmdFam").value;

								var gndrMfFamSelect = row
										.querySelector("#gender");
								var selectedOption2 = gndrMfFamSelect.options[gndrMfFamSelect.selectedIndex];
								var gndrMfFam = selectedOption2.value;

								//var gndrMfFam = row.querySelector("#gndrMfFam").value;

								console.log("기본키", famNo);
								console.log("이름", famNm);
								console.log("가족공통코드", famRela);
								console.log("생일", brthYmdFam);
								console.log("성별", gndrMfFam);

							}
							$("#frmFamily").submit();
						});

		// 가족 모달 확인버튼
		$("#btnDelFam").click(
				function() {
					console.log("나는 삭제 모달 확인버튼")
					console.log("famNo", famNo);

					var data = {
						"famNo" : famNo
					};
					console.log(data);

					$.ajax({
						url : "/empinfo/deleteFam",
						contentType : "application/json;charset=utf-8",
						data : JSON.stringify(data),
						type : "post",
						dataType : "text",
						beforeSend : function(xhr) {
							xhr.setRequestHeader("${_csrf.headerName}",
									"${_csrf.token}");
						},
						success : function(result) {
							//alert("삭제성공")
							location.href = "/empinfo/empinfo";

						},
						error : function(xhr, status, error) {
							console.log("에러 발생:", error);
						}

					}); //ajax
				});

		//신상정보 수정	
		$("#submitBtnRegEmpInfoPersonal").click(
				function() {
					var regHobby = $("#regHobby").val();
					var regSpecial = $("#regSpecial").val();

					// 		console.log(regHobby)
					// 		console.log(regSpecial)

					var postcodeKakao = $("#sample4_postcode").val();
					var roadAddressKakao = $("#sample4_roadAddress").val();
					var detailAddressKakao = $("#sample4_detailAddress").val();
					// 		console.log("postcodeKakao : " ,postcodeKakao)
					// 		console.log("roadAddressKakao : ",roadAddressKakao)
					// 		console.log("detailAddressKakao: ",detailAddressKakao)

					if (postcodeKakao == "") {
						console.log("기존 주소임")
						var userZip = '${data.userZip}';
						var userAddr = '${data.userAddr}';
						var userDaddr = '${data.userDaddr}';
					} else {
						var userZip = $("#sample4_postcode").val();
						var userAddr = $("#sample4_roadAddress").val();
						var userDaddr = $("#sample4_detailAddress").val();
					}

					// 		console.log(userZip, userAddr, userDaddr)

					// 		console.log(loginIdSession) //NAVER_2014030001

					var data = {
						"userId" : loginIdSession,
						"hobby" : regHobby,
						"spcabl" : regSpecial,
						"userZip" : userZip,
						"userAddr" : userAddr,
						"userDaddr" : userDaddr
					}
					console.log(data);

					$.ajax({
						url : "/empinfo/updatePersonal",
						contentType : "application/json;charset=utf-8",
						data : JSON.stringify(data),
						type : "post",
						dataType : "text",
						beforeSend : function(xhr) {
							xhr.setRequestHeader("${_csrf.headerName}",
									"${_csrf.token}");
						},
						success : function(result) {
							location.href = "/empinfo/empinfo";

						},
						error : function(xhr, status, error) {
							console.log("에러 발생:", error);
						}

					}); //ajax

				});

	}//onload

	//카카오 주소
	function sample4_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample4_postcode').value = data.zonecode;
						document.getElementById("sample4_roadAddress").value = roadAddr;
						document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

						// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
						if (roadAddr !== '') {
							document.getElementById("sample4_extraAddress").value = extraRoadAddr;
						} else {
							document.getElementById("sample4_extraAddress").value = '';
						}

						var guideTextBox = document.getElementById("guide");
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							var expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							guideTextBox.innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';
							guideTextBox.style.display = 'block';

						} else if (data.autoJibunAddress) {
							var expJibunAddr = data.autoJibunAddress;
							guideTextBox.innerHTML = '(예상 지번 주소 : '
									+ expJibunAddr + ')';
							guideTextBox.style.display = 'block';
						} else {
							guideTextBox.innerHTML = '';
							guideTextBox.style.display = 'none';
						}
					}

				}).open();
	}
</script>