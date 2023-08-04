<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<style>
img .dz-image {
	height: 50%;
}

.fa-stack-2x {
	font-size: 1em;
}

.no-underline {
	text-decoration: none !important;
}

.my-img-size {
	width: 40px;
	height: 40px;
}

.jstree-icon {
	margin-right: 5px;
	margin-left: 0px;
}
</style>
<form name="frm2"
	action="/draft/doc/atrz/post?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="application/x-www-form-urlencoded">
	<c:forEach var="mydraftAtrz" items="${mydraftAtrzList}" varStatus="stat">
		<c:if test="${mydraftAtrz.drNo == draftSelect.drNo}">
			<input type="hidden" id="maxAtrzSn" name="draftAtrzVOList[0].maxAtrzSn" value="${mydraftAtrz.draftAtrzVOList[0].maxAtrzSn}">		
			<input type="hidden" id="atrzSn" name="draftAtrzVOList[0].atrzSn" value="${mydraftAtrz.draftAtrzVOList[0].maxAtrzSn}">		
			<input type="hidden" id="is" value="${mydraftAtrz.drSttsCd}">		
		</c:if>
	</c:forEach>
	
	<div class="d-flex">
<!-- 	기안문서 불러오기-->
	${draftSelect.drStrg}
<!-- 	결재선 잡는 부분 -->
		<div class="card col-4 ms-3 my-3 border border-secondary">
			<div class="card-body position-relative pt-4 ">
					<div class="btn-group col-12 mb-3" role="group" aria-label="draft">
						<c:set var="ddid" value='<sec:authentication property="principal.userVO.userId" />' />
							<c:if test="${draftSelect.userId == draUserId && draftSelect.drSttsCd == 'DF003'}">
								<button type="button" id="setCancel" class="btn btn-secondary btn-lg">회수하기</button>
							</c:if>
						<c:if test="${draftSelect.drSttsCd == 'DF002'}">
							<div class="btn btn-primary btn-lg"> 결재 완료 </div>
						</c:if>
						<c:if test="${draftSelect.drSttsCd == 'DF004'}">
							<div class="btn btn-danger btn-lg"> 반려 </div>
						</c:if>
						<c:forEach var="mydraftAtrz" items="${mydraftAtrzList}" varStatus="stat">
							<c:if test="${mydraftAtrz.drNo == draftSelect.drNo}">
								<c:if test="${draftSelect.drSttsCd == 'DF003'}">
									<button type="button" id="setAtrz"
										class="btn btn-primary btn-lg">결제하기</button>
									<button type="button" id="setReject" class="btn btn-secondary btn-lg">반려하기</button>
								</c:if>
							</c:if>
						</c:forEach>
					</div>
				<div class="mb-3 row g-2">
					<span>기안서 제목</span>
					<div class="form-control-plaintext p-2 border border-200" id="draftTitle">${draftSelect.drftTitle}</div>
				</div>

				<hr class="opacity-75" style="border: solid 1px" />

				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link active"
						id="approval-tab" data-bs-toggle="tab" href="#tab-approval"
						role="tab" aria-controls="tab-approval" aria-selected="true">결재선</a></li>
					<li class="nav-item"><a class="nav-link" id="opinion-tab"
						data-bs-toggle="tab" href="#tab-opinion" role="tab"
						aria-controls="tab-opinion" aria-selected="false">의견</a></li>
					<li class="nav-item"><a class="nav-link" id="attachment-tab"
						data-bs-toggle="tab" href="#tab-attachment" role="tab"
						aria-controls="tab-attachment" aria-selected="false">첨부파일</a></li>
				</ul>
				<div class="tab-content border border-top-0 p-3 pt-0"
					id="myTabContent">
					<div class="tab-pane fade show active" id="tab-approval"
						role="tabpanel" aria-labelledby="approval-tab">
						<!-- 결재선 선택시 나오는 부분 -->
						<div class="d-flex flex-column draftSideInfo" id="draftApproval">
								<table class="table my-3">
									<tbody>
										<tr class="bg-primary-subtle">
											<td>결재선 (결재순서)</td>
										</tr>
										<tr>
											<td class="align-middle p-0">
												<div>
													<div class="card my-3 shadow-sm dark__bg-1100">
														<div class="card-body border p-2">
															<div
																class="d-flex align-items-center fs--1 fw-medium font-sans-serif mb-0">
																<div class="align-middle mx-auto">1</div>
																<div class="mx-auto">
																	<img alt="유저사진" class="rounded-circle my-img-size"
																		src="${empInfoVO.userImg}">
																</div>
																<div class="mx-auto">
																	${empInfoVO.userNm}
																	<input type="hidden" name="userId" value="${empInfoVO.userId}">
																	<input type="hidden" class="drftData" value="${empInfoVO.deptNm}">
																	<input type="hidden" class="drftData" value="${empInfoVO.jbgdCdNm}">
																	<input type="hidden" class="drftData" value="${empInfoVO.userNm}">
																</div>
																<div class="mx-auto">
																	${empInfoVO.deptNm}
																</div>
																<div class="mx-auto">
																	${empInfoVO.jbgdCdNm}
																</div>
																<div class="mx-auto">
																	<span class="badge rounded-pill badge-subtle-secondary">기안자</span>
																</div>
																<div class="mx-auto">
																	<span class="fas fa-pen"></span>
																</div>
															</div>
														</div>
													</div>
												</div>
												<div id="draftLineDisplay">
													<c:forEach var="draftAtrzVO" items="${draftSelect.draftAtrzVOList}" varStatus="stat">
														<c:if test="${draftAtrzVO.atrzCd == 'DR001'}">
															<div class="card my-3 shadow-sm dark__bg-1100">
															<div class="card-body border p-2">
																<div
																	class="d-flex align-items-center fs--1 fw-medium font-sans-serif mb-0">
																		<div class="align-middle mx-auto">${draftAtrzVO.atrzSn + 1}</div>
																		<div class="mx-auto">
																			<img alt="유저사진" class="rounded-circle my-img-size"
																				src="${draftAtrzVO.userImg}">
																			<img alt="사인이미지" class="rounded-circle my-img-size d-none"
																				src="${draftAtrzVO.signImg}">
																		</div>
																		<div class="mx-auto">
																			${draftAtrzVO.userNm}
																		</div>
																		<div class="mx-auto">
																			${draftAtrzVO.deptNm}
																		</div>
																		<div class="mx-auto">
																			${draftAtrzVO.jbgdNm}
																		</div>
																		<div class="mx-auto">
																			<c:if test="${draftAtrzVO.atrzSttsCd eq null}">
																				<input type="hidden" class="users" value="${draftAtrzVO.userId}">
																				<span code-name="${draftAtrzVO.atrzSttsCd}" class="badge rounded-pill badge-subtle-warning">대기</span>																	
		 																	</c:if>
																			<c:if test="${draftAtrzVO.atrzSttsCd eq 'DS001'}">
																				<span when="${draftAtrzVO.getAtrzDtForm()}" code-name="${draftAtrzVO.atrzSttsCd}" class="badge rounded-pill badge-subtle-primary">결재완료</span>																	
																			</c:if>
																			<c:if test="${draftAtrzVO.atrzSttsCd eq 'DS002'}">
																				<span when="${draftAtrzVO.atrzDtFm}" code-name="${draftAtrzVO.atrzSttsCd}" class="badge rounded-pill badge-subtle-danger">반려</span>																	
																			</c:if>
																		</div>
																		<div class="mx-auto invisible">
																			<span class="fas fa-pen"></span>
																		</div>
																	</div>
																</div>
															</div>
														</c:if>
													</c:forEach>
												</div>
											</td>
										</tr>

										<tr class="bg-primary-subtle">
											<td>
												<div class="float-start">수신자</div>
												
											</td>
										</tr>
										<tr class="invisible">
											<td></td>
										</tr>
										<tr>
											<td id="draftSusinDisplay" class="p-0">
												<c:forEach var="draftAtrzVO" items="${draftSelect.draftAtrzVOList}" varStatus="stat">
													<c:if test="${draftAtrzVO.atrzCd == 'DR002'}">
														<div class="card my-3 shadow-sm dark__bg-1100" style="border: 0px">
															<div class="card-body border p-2">
																<div class="d-flex align-items-center fs--1 fw-medium font-sans-serif mb-0">
																	<input type="hidden" id="lineId" value="` + userId + `" />
																	<div class=" mx-auto">${draftAtrzVO.userNm}</div>
																	<div class=" mx-auto">${draftAtrzVO.jbgdNm}</div>
																</div>
															</div>
														</div>
													</c:if>
												</c:forEach>	
											</td>
										</tr>

										<tr class="bg-primary-subtle">
											<td>
												<div class="float-start">회람자</div>
											</td>
										</tr>
										<tr>
											<td id="draftRamDisplay" class="p-0">
												<c:forEach var="draftAtrzVO" items="${draftSelect.draftAtrzVOList}" varStatus="stat">
													<c:if test="${draftAtrzVO.atrzCd == 'DR003'}">
														<div class="card my-3 shadow-sm dark__bg-1100" style="border: 0px">
															<div class="card-body border p-2">
																<div class="d-flex align-items-center fs--1 fw-medium font-sans-serif mb-0">
																	<input type="hidden" id="lineId" value="` + userId + `" />
																	<div class=" mx-auto">${draftAtrzVO.userNm}</div>
																	<div class=" mx-auto">${draftAtrzVO.jbgdNm}</div>
																</div>
															</div>
														</div>
													</c:if>
												</c:forEach>
											</td>
										</tr>
									</tbody>
								</table>
						</div>
						<!-- 결재선 선택시 나오는 부분 -->
					</div>
					<div class="tab-pane fade" id="tab-opinion" role="tabpanel"
						aria-labelledby="opinion-tab">
						<!-- 의견 선택시 나오는 부분 -->
						<div class="row g-1 draftSideInfo" id="draftOpinion">
							<h5 class="mt-3">의견</h5>
							<hr class="opacity-75 mb-1" style="border: solid 1px" />
							<div id="draftShowOpinion" class="align-items-center">
								<c:forEach var="draftOpnVO" items="${draftSelect.draftOpnVOList}" varStatus="stat">
									<c:if test="${draftOpnVO.opnnCn eq null || draftOpnVO.opnnCn == ''}">
										<div class="form-control-plaintext" id="opZero">의견이 없습니다</div>
									</c:if>
									<c:if test="${draftOpnVO.opnnCn ne null}">
										<div class="form-control-plaintext" id="opZero" style="display: none;">의견이 없습니다</div>
										<div class="alert d-flex align-items-center p-0 mb-0">						
											<input class="form-control-plaintext"
											readonly value="${draftOpnVO.opnnCn}"/>
											<button class="btn-close opn-del invisible" type="button" data-bs-dismiss="alert" aria-label="Close"></button>
										</div>
									</c:if>
								</c:forEach>
							</div>
							<hr class="opacity-75" style="border: solid 1px" />
							<div class="col">
							
							<c:forEach var="mydraftAtrz" items="${mydraftAtrzList}" varStatus="stat">
								<c:if test="${mydraftAtrz.drNo == draftSelect.drNo}">
									<c:if test="${mydraftAtrz.draftAtrzVOList[0].atrzSttsCd eq null}">
										<textarea class="form-control" id="draftRegistOpnion" rows="3"
											placeholder="의견 작성하기"></textarea>
										<button id="setOpnionBtn" type="button"
											class="btn btn-primary btn-sm float-end mt-3">작성</button>
									</c:if>
								</c:if>
							</c:forEach>
							</div>
						</div>
						<!-- 의견 선택시 나오는 부분 -->
					</div>
					<div class="tab-pane fade" id="tab-attachment" role="tabpanel"
						aria-labelledby="attachment-tab">
						<!-- 첨부파일 선택시 나오는 부분 -->
						<div class="row g-1 draftSideInfo" id="draftAttachment">
							<h5 class="mt-3">첨부 파일</h5>
							<hr class="opacity-75" style="border: solid 1px" />
							<div class="mb-3">
							<c:forEach var="draftAttachVO" items="${draftSelect.draftAttachVOList}" varStatus="stat">
								<c:if test="${draftAttachVO.filePath ne null}">
									<a href="/download?sort=draft&filename=${draftAttachVO.filePath}">${draftAttachVO.fileNm}</a>
								</c:if>
								<c:if test="${draftAttachVO.filePath eq null}">
									<div>첨부파일이 없습니다.</div>
								</c:if>
							</c:forEach>
							</div>
						</div>
						<!-- 첨부파일 선택시 나오는 부분 -->
					</div>
					<div class="tab-pane fade" id="tab-schedule" role="tabpanel"
						aria-labelledby="schedule-tab">
					</div>
				</div>

			</div>
		</div>
		<!-- 결재선 잡는 부분 -->
	<input type="hidden" id="drNo" name="drNo" value="${draftSelect.drNo}" />
	<input type="hidden" id="atrzSttsCd" name="draftAtrzVOList[0].atrzSttsCd" value="" />
<!-- 	<input type="hidden" id="drSttsCd" name="drSttsCd" value="" /> -->
	</div>
	<sec:csrfInput />
	<sec:authorize access="isAuthenticated()">
		<input type="hidden" id="draftMyName" value="<sec:authentication property="principal.userVO.userNm" />">  
		<input type="hidden" id="draftMyId" name="draftAtrzVOList[0].userId" value="<sec:authentication property="principal.userVO.userId" />">  
	</sec:authorize>
</form>

<script type="text/javascript">
	// 데이터 검증 및 처리 스크립트
	// 오늘 날짜 계산
	var today = new Date();
	var year = today.getFullYear();
	var month = ('0' + (today.getMonth() + 1)).slice(-2);
	var day = ('0' + today.getDate()).slice(-2);

	var formattedDate = year + '-' + month + '-' + day;
	var formattedDate2 = year + '' + month + '' + day;
	
	// 오늘 날짜 계산
	
	$(document).ready(function() {
	 	$("#vacChose").attr("data-bs-target", "");
	 	$("#vacChose").attr("data-bs-toggle", "");
	 	$("#vacReason").attr("readonly", "readonly");
	
		tinymce.init({
		    selector: "#draftClobContent",
		});
		
		// 결재 승인
		$("#setAtrz").on('click', function() {
			//알람
			const drftId = document.querySelector(`input[name="userId"]`).value;
			const nextUser = document.querySelectorAll(`.users`);
			const drftData = document.querySelectorAll('.drftData')
			
			stomp.send('/pub/docResult', {}, JSON.stringify({
				senderNm : userData[userId][0]+` `+userData[userId][1]+` `+userData[userId][2],
				sender: userId,
				userId: drftId,
			}));
			
			nextUser.forEach((e,i)=>{
				if(e.value!=userId){
					stomp.send('/pub/docAlarm', {}, JSON.stringify({
						senderNm : drftData[0].value+` `+drftData[1].value+` `+drftData[2].value,
						sender: drftId,
						userId: e.value,
					}));
				}
			});
			
			
			
			var maxAtrzSn = $("#maxAtrzSn").val();
			var atrzSn = $("#atrzSn").val();
			
			// 최종 결재자 일 경우
			if(maxAtrzSn === atrzSn) {
				$("#drSttsCd")[0].value = 'DF002';
			}
			
			$("#atrzSttsCd").val('DS001');
			
			frm2.submit();
			
		});
		
		// 반려
		$("#setReject").on('click', function() {
			
			//기안 문서 번호 업데이트
			$("#drSttsCd")[0].value = 'DF004';
			$("#atrzSttsCd").val('DS002');
			frm2.submit();
			
		});
	
		// 기안 의견 데이터 전달
	    $("#draftRegistOpnion").keyup(function(event) {
	        if (event.which === 13) {
	            $("#setOpnionBtn").click();
	        }
	    });
		var cnt = 0;
		$("#setOpnionBtn").on("click", function() {
			var draftShowOpinion = document.querySelector("#draftShowOpinion");
			var draftRegistOpnion = document.querySelector("#draftRegistOpnion");
			var count = $("#draftShowOpinion > .alert").length;
			var opinion = draftRegistOpnion.value;
			var myName = $("#draftMyName").val()
			var myId = $("#draftMyId").val()
			$("#opZero").hide();
			
			var nowTime = new Date();
			
			var opinionTemp = `
					<div class="alert d-flex align-items-center p-0 mb-0">						
							<input class="form-control-plaintext"
							name="draftOpnVOList[` + cnt + `].opnnCn"
							readonly value="`+ myName + `: ` + opinion +  `"/>
						<button class="btn-close opn-del" type="button" data-bs-dismiss="alert" aria-label="Close"></button>
				`
			opinionTemp += `<input type="hidden" name="draftOpnVOList[` + cnt + `].userId" value="` + myId + `"/>`
			opinionTemp += `<input type="hidden" name="draftOpnVOList[` + cnt + `].drOpnnDt" value="` + nowTime + `"/></div>`
			draftShowOpinion.innerHTML += opinionTemp;
			cnt++;

			draftRegistOpnion.value = "";
		});
		
		$(document).on("click", ".opn-del", function() {
			var count = $("#draftShowOpinion > .alert").length;
			cnt--;
			if (count <= 0) {
				$("#opZero").show();
			}
		});

		
	// 기안 의견 데이터 전달
	
	});
	
	

</script>


<!-- 사인박스 처리 -->
<script type="text/javascript">
$(function (){
	setSignBox();
});

function setSignBox() {
var signBox = $(".signBox");
	
	var draftLine = $("#draftLineDisplay > .card");
	
	draftLine.each(function(index1, value) {
	    var imgTag1 = $(this).find("img.d-none");
	    var imgSrc = imgTag1.attr("src");
	    
	    var artzDate = $(this).find("span")[0];
	    var artzYmd = artzDate.getAttribute('when');
	    var code = artzDate.getAttribute('code-name');
	    
	    if(artzYmd == null) {
	    	artzYmd = '날짜';
	    }
	    
		signBox.each(function(index2, value) {
		    var imgTag2 = $(this).find("img");
		    var signDate = $(this).find("td")[2];
		    
			if(index1 === index2 && code === 'DS001') {
				imgTag2.attr("src", imgSrc);
				signDate.innerText = artzYmd;
			}
		    
		});
	});
}
</script>
<!-- 사인박스 처리	 -->

<!-- 받아온 기안 의견 처리 -->
<script type="text/javascript">
$(document).ready(function() {
	
});
</script>
<!-- 받아온 기안 의견 처리 -->
