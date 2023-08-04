<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="certificationList" value="${data.resumeCirtificationVO}" />
<c:set var="careerList" value="${data.resumeCareerVO}" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css" />

<style>
@media print {
	html, body {
		background-color: green;
	}
	table, tr, td {
		background: green;
	}
}
</style>

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
						<div class="nav nav-pills nav-pills-falcon flex-grow-1 mt-2"
							role="tablist"></div>
					</div>
				</div>
			</div>
			<div class="card-body" id="modalData">
				<div class="text-center clearfix">
					<button class="btn float-end bi-printer-fill"
						onclick="startPrint('modalData')">인쇄하기</button>
				</div>
				<table
					class="table table-bordered align-middle text-align border border-2">
					<colgroup>
						<col width="20%">
						<col width="30%">
						<col width="20%">
						<col width="30%">
					</colgroup>
					<tbody>
						<tr>
							<td class=" bg-primary-subtle text-center">채용 구분</td>
							<td class="text-center"><select class="form-select"
								id="resumeTp" disabled>
									<option value="newEmployee">신입</option>
									<option value="experiencedEmployee">경력</option>
							</select></td>
							<td class=" bg-primary-subtle text-center">채용 부서</td>
							<td class="text-center" disabled>
							<select class="form-select" disabled id="deptNo">
									<option value="1 ">인사팀</option>
									<option value="2">마케팅팀</option>
									<option value="3">영업팀</option>
									<option value="4">회계팀</option>
									<option value="5">개발팀</option>
									<option value="6">보안팀</option>
							</select></td>
						</tr>
					</tbody>
				</table>
				<p class="mb-0">기본정보</p>
				<table
					class="table table-bordered align-middle text-align border border-2">
					<colgroup>
						<col width="13%">
						<col width="27%">
						<col width="13%">
						<col width="27%">
						<col width="20%">
					</colgroup>
					<tbody>
						<tr>
							<td class=" bg-primary-subtle text-center">한글 성명</td>
							<td class="text-center">${data.rsmNm }</td>
							<td class=" bg-primary-subtle text-center">영문 성명</td>
							<td class="text-center">${data.rsmEgNm }</td>
							<td class=" bg-primary-subtle text-center">사진</td>
						</tr>
						<tr>
							<td class=" bg-primary-subtle text-center">전화번호</td>
							<td class="text-center" id="telno">${data.telno }</td>
							<td class=" bg-primary-subtle text-center">메일주소</td>
							<td class="text-center">${data.mailAddr }</td>



							<td rowspan="3" id="image"
								style="background-image:url('${data.image}'); background-repeat: no-repeat; background-size : contain;  background-position:center; ">
								<%-- 							<img src="${data.image}" --%> <!-- 								style="max-width: 100%; max-height: 100%; object-fit: contain;"> -->
							</td>



						</tr>
						<tr>
							<td class=" bg-primary-subtle text-center">주소</td>
							<td colspan="3" class="text-center">${data.addr }</td>
						</tr>
						<tr>
							<td class=" bg-primary-subtle text-center ">병역</td>
							<td colspan="3" class="text-center aline-center" id="mtrscCd"
								style="vertical-align: middle;">
								<div class="form-check form-check-inline"
									style="vertical-align: middle;">
									<input class="form-check-input" id="inlineRadio1" type="radio"
										name="inlineRadioOptions" value="MT001"
										<c:if test="${data.mtrscCd=='MT001'}">checked</c:if> disabled />
									<label class="form-check-label" for="inlineRadio1">군필</label>
								</div>
								<div class="form-check form-check-inline aline-center"
									style="vertical-align: middle;">
									<input class="form-check-input" id="inlineRadio2" type="radio"
										name="inlineRadioOptions" value="MT002"
										<c:if test="${data.mtrscCd=='MT002'}">checked</c:if> disabled />
									<label class="form-check-label" for="inlineRadio2">미필</label>
								</div>
								<div class="form-check form-check-inline aline-center"
									style="vertical-align: middle;">
									<input class="form-check-input" id="inlineRadio3" type="radio"
										name="inlineRadioOptions" value="MT003"
										<c:if test="${data.mtrscCd=='MT003'}">checked</c:if> disabled />
									<label class="form-check-label" for="inlineRadio3">면제</label>
								</div>
							</td>
						</tr>
					</tbody>
				</table>


				<p class="mb-0">최종학력</p>
				<table
					class="table table-bordered align-middle text-align border border-2">
					<colgroup>
						<col width="30%">
						<col width="30">
						<col width="40%">
					</colgroup>
					<tbody>
						<tr>
							<td class=" bg-primary-subtle text-center">졸업구분</td>
							<td class=" bg-primary-subtle text-center">학교명</td>
							<td class=" bg-primary-subtle text-center">전공</td>
						</tr>
						<tr>
							<td class="text-center"><select class="form-select" disabled
								id="graduate">
									<option value="highSchool">고등학교 졸업</option>
									<option value="univer2year">대학교 졸업(2년제)</option>
									<option value="univer4year">대학교 졸업(4년제)</option>
									<option value="master">대학원 졸업(석사)</option>
									<option value="doctor">대학원 졸업(박사)</option>
							</select></td>
							<td class="text-center">${data.resumeEdu}</td>
							<td class="text-center">${data.resumeMajor}</td>
						</tr>
					</tbody>
				</table>




				<p id="mytbodyCareer" class="mb-0">경력사항</p>
				<table id="mytbody"
					class="table table-bordered align-middle text-align border border-2"
					style="display: visible">
					<colgroup>
						<col width="30%">
						<col width="30%">
						<col width="40%">
					</colgroup>
					<tbody>
						<tr>
							<td class=" bg-primary-subtle text-center">회사명</td>
							<td class=" bg-primary-subtle text-center">근무기간</td>
							<td class=" bg-primary-subtle text-center">담당업무</td>
						</tr>
						<c:forEach var="career" items="${careerList }" varStatus="stat">
							<tr>
								<td class="text-center" id="careerNeirong">${career.crrcoNm }</td>
								<td class="text-center"><fmt:formatDate
										value="${career.crrStdt }" pattern="yyyy-MM-dd" /> - <fmt:formatDate
										value="${career.crrEndt }" pattern="yyyy-MM-dd" /></td>
								<td class="text-center">${career.crrJob }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<p class="mb-0">자격증</p>
				<table
					class="table table-bordered align-middle text-align border border-2">
					<colgroup>
						<col width="25%">
						<col width="25%">
						<col width="25%">
					</colgroup>
					<tbody>
						<tr>
							<td class="bg-primary-subtle text-center">자격증명</td>
							<td class="bg-primary-subtle text-center">점수/등급</td>
							<td class="bg-primary-subtle text-center">취득일</td>
						</tr>
						<c:choose>
							<c:when test="${empty certificationList}">
								<tr>
									<td class="text-center" colspan="3">-</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="certification" items="${certificationList}">
									<tr>
										<td class="text-center">${certification.crtfctNm}</td>
										<td class="text-center">${certification.rsmCrtfctGrad}</td>
										<td class="text-center"><fmt:formatDate
												value="${certification.rsmCrtfctYmd}" pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>


				<p class="mb-0">기술스택</p>
				<table id=""
					class="table table-bordered align-middle text-align border border-2">
					<tbody>
						<tr>
							<td class=" bg-primary-subtle text-center">보유한 기술 스택</td>
						</tr>
						<tr>
							<td class="d-flex">
								<c:forEach var="qnsinfNm" items="${data.qnsinfNm}" varStatus="stat">
									<div class="me-3">${qnsinfNm}</div>
								</c:forEach>
							</td>
						</tr>

					</tbody>
				</table>


				<p class="mb-0">적합도 평가</p>

				<div class="border border-2 align-middle text-align mb-3 p-2" style="width: 100%; height: ">
					<label>${result}</label>
				</div>



				<p class="mb-0">첨부파일</p>
				<div style="width: 100%">
					<a href="${data.resumeFile}" download> <span class="ms-2"
						id="resumeNm"></span>
					</a>
				</div>


				<div class="text-center clearfix">
					<a id="btn" class="btn btn-secondary  text-center  "
						href="/resume/resumeList" id="btnAreaClose">목록</a>
					<button class="btn float-end bi-printer-fill"
						onclick="startPrint('modalData')" id="btnPrint">인쇄하기</button>
					<!-- 					<button class="btn float-end bi-printer-fill" onclick="doPrint()" id="btnPrint">인쇄하기</button> -->
				</div>
			</div>
		</div>
	</div>
</div>





<script type="text/javascript">
	// //경력사항이 없으면 경력없음 나타내기
	// var table = document.querySelector("#mytbody");
	// var mytbodyCareer = document.querySelector("#mytbodyCareer");
	// var careerNeirong = document.querySelector("#careerNeirong");

	// if (careerList.length == 0) {
	// 	 $("#careerNeirong").attr("colspan", "3").text("경력사항이 없습니다.");
	// 	$("#careerNeirong").nextAll().remove();
	// 	//careerNeirong.textContent = "No career information";
	// }

	//이력서 파일명으로 보이게 하기
	var resumeNmData = '${data.resumeFile}';
	resumeNmData = resumeNmData.split('resume/');
	resumeNmData = resumeNmData[1];

	var resumeNm = document.querySelector("#resumeNm");
	resumeNm.textContent = resumeNmData;

	//졸업구분
	var graduateData = '${data.graduate}';

	var graduate = document.querySelector("#graduate");
	graduate.value = graduateData;

	//휴대폰번호 하이픈 넣기
	var telno = document.querySelector("#telno");
	telno = telno.textContent + "";

	telno = 0 + telno;
	telno = telno.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
	$("#telno").text(telno);

	//채용구분 넣기
	var resumeTpData = '${data.resumeTp}';
	var resumeTp = document.querySelector("#resumeTp");
	// console.log(resumeTp)
	// console.log(resumeTp.value)
	resumeTp.value = resumeTpData;

	//채용부서 넣기
	var deptNoData = '${data.deptNo}';

	var deptNo = document.querySelector("#deptNo");
	deptNo.value = deptNoData;
	// console.log(deptNo)

	// 	//pdf저장 및 인쇄
	// function doPrint(){
	// 	// 프린트를 보이는 그대로 나오기위한 셋팅
	//     window.onbeforeprint = function(ev) {
	// 	    // 프린트 전에 내용을 복사하여 새 창에 적용
	// // 		var btnAreaPrint = document.getElementById('btnAreaPrint');
	// // 		var btnAreaClose = document.getElementById('btnAreaClose');
	// 		btnAreaPrint.classList.remove('d-flex');
	// 		btnAreaPrint.classList.add('d-none');
	// 		btnAreaClose.style.display = 'none';

	// 		var printContent = document.getElementById('modalData').innerHTML;
	// 		var printWindow = window.open('', '_blank');
	// 		printWindow.document.write('<html><head><title>인쇄</title>');
	// 	//  printWindow.document.write('<link rel="preconnect" href="path/to/your/styles.css">');
	// 		printWindow.document.write('</head><body>');
	// 		printWindow.document.write(printContent);
	// 		printWindow.document.write('</body></html>');
	// 		printWindow.document.close();

	// 		};

	//     window.print();
	//     location.reload();

	// 	}

	//인쇄
	// function printPageArea(areaID, imageURL) {
	//     var printContent = document.getElementById(areaID).innerHTML;
	//     var originalContent = document.body.innerHTML;

	//     // 이미지 요소 생성
	//     var imageElement = document.createElement('img');
	//     imageElement.src = imageURL;
	//     imageElement.style.maxWidth = '100%';
	//     imageElement.style.maxHeight = '100%';
	//     imageElement.style.objectFit = 'contain';

	//     // 프린트 영역에 이미지 요소 추가
	//     var printContainer = document.createElement('div');
	//     printContainer.appendChild(imageElement);
	//     printContainer.innerHTML += printContent;

	//     document.body.innerHTML = printContainer.innerHTML;
	//     window.print();
	//     document.body.innerHTML = originalContent;
	// }

	//pdf저장 및 인쇄

	var prtContent; // 프린트 하고 싶은 영역
	var initBody; // body 내용 원본
	//프린트하고 싶은 영역의 id 값을 통해 출력 시작
	function startPrint(div_id) {
		prtContent = document.getElementById('modalData');
		window.onbeforeprint = beforePrint;
		window.onafterprint = afterPrint;
		window.print();
	}

	// 웹페이지 body 내용을 프린트하고 싶은 내용으로 교체
	function beforePrint() {
		initBody = document.body.innerHTML;
		document.body.innerHTML = prtContent.innerHTML;
		document.body.style.backgroundColor = "white";
	}

	// 프린트 후, 웹페이지 body 복구
	function afterPrint() {
		document.body.innerHTML = initBody;
		document.body.style.backgroundColor = "";
	}

	/* //pdf저장 및 인쇄
	 function doPrint(){
	 // 프린트를 보이는 그대로 나오기위한 셋팅
	 window.onbeforeprint = function(ev) {
	 // 프린트 전에 내용을 복사하여 새 창에 적용
	 var btnAreaPrint = document.getElementById('btnAreaPrint');
	 var btnAreaClose = document.getElementById('btnAreaClose');
	
	
	
	 var printContent = document.getElementById('modalData').innerHTML;
	 var printWindow = window.open('', '_blank');
	 printWindow.document.write('<html><head><title>인쇄</title>');
	 // 	 printWindow.document.write('<link rel="preconnect" href="path/to/your/styles.css">');
	 printWindow.document.write('</head><body>');
	 printWindow.document.write(printContent);
	 printWindow.document.write('</body></html>');
	 printWindow.document.close();
	
	 };

	 window.print();
	 location.reload();
	
	 }	
	 */
</script>