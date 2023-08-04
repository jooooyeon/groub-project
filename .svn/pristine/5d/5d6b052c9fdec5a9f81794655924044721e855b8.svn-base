<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
						<h3 class="mb-0">전 직원 급여정보관리</h3>
						<p class="mb-0 pt-1 mt-2 mb-0"></p>
					</div>
      <div class="card-body p-0 pb-3">
        <div id="tableExample3" data-list='{"valueNames":["userNm","deptNoNm","bankNm","actNo","totalPayment","totalTex","pymntamt"],"pagination":true}'>
          <div class="d-flex align-items-center my-3 justify-content-between">
            <div class="ms-3">
              <form>
                <div class="input-group">
                  <input class="form-control form-control-sm shadow-none search" type="search" placeholder="부서명 또는 이름 검색" aria-label="search" />
                  <div class="input-group-text bg-transparent">
                    <span class="fa fa-search fs--1 text-600"></span>
                  </div>
                </div>
              </form>
            </div>
            <div id="bulk-select-replace-element" class="ms-3">
              <button class="btn btn-falcon-success btn-sm" type="button" id="allEmployees">
                <span class="fas fa-plus" data-fa-transform="shrink-3 down-2"></span>
                <span class="ms-1">전체 인원 엑셀 다운로드</span>
              </button>
            </div>
            <div class="d-none ms-3 col-auto d-flex justify-content-end" id="bulk-select-actions">
              <div class="d-flex">
                <select class="form-select form-select-sm" aria-label="Bulk actions">
                  <option selected="selected" id="someEmployees">엑셀 다운로드 받기</option>
                  <option id="sendMail">메일 보내기</option>
                </select>
                <button class="btn btn-falcon-danger btn-sm ms-2" type="button" id="apply">Apply</button>
              </div>
            </div>
          </div>

          <div class="ms-3 mb-3">
            <table>
              <tr>
                <td>
                  <div class="form-group">
                    <select class="form-select" id="selectOptYear"></select>
                  </div>
                </td>
                <td>
                  <div class="form-group">
                    <select class="form-select" id="selectOptMonth">
                      <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                      <option value="4">4</option>
                      <option value="5">5</option>
                      <option value="6" selected="selected">6</option>
                      <option value="7">7</option>
                      <option value="8">8</option>
                      <option value="9">9</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option>
                    </select>
                  </div>
                </td>
                <td>
                  <button class="btn btn-secondary" type="button" onclick="filterBySelectValue()">검색</button>
                </td>
                <td></td>
              </tr>
            </table>
          </div>

          <div class="table-responsive scrollbar">
            <table class="table mb-0" id="myTable">
              <colgroup>
<%--                 <col width="5%"> --%>
                <col width="10%">
                <col width="15%">
                <col width="10%">
                <col width="20%">
                <col width="13%">
                <col width="20%">
              </colgroup>
              <thead class="text-black bg-200">
                <tr>
<!--                   <th class="align-middle white-space-nowrap"> -->
<!--                     <div class="form-check mb-0"> -->
<!--                       <input class="form-check-input" type="checkbox" data-bulk-select='{"body":"bulk-select-body","actions":"bulk-select-actions","replacedElement":"bulk-select-replace-element"}' /> -->
<!--                     </div> -->
<!--                   </th> -->
<!--                   <th class="align-middle sort text-center" data-sort="paymentNo">번호</th> -->
                  <th class="align-middle sort text-center" data-sort="userNm">이름</th>
                  <th class="align-middle sort text-center" data-sort="deptNoNm">부서명</th>
                  <th class="align-middle sort text-center" data-sort="bankNm">은행</th>
                  <th class="align-middle sort text-center" data-sort="actNo">계좌번호</th>
                  <th class="align-middle sort text-center" data-sort="totalPayment">지급 항목 합계</th>
                  <th class="align-middle sort text-center" data-sort="totalTex">공제 항목 합계</th>
                  <th class="align-middle sort text-center" data-sort="pymntamt">공제 후 실지급액</th>
<!--                   <th class="align-middle sort text-center" data-sort="selectYear">연</th> -->
<!--                   <th class="align-middle sort text-center" data-sort="selectMonth">월</th> -->
                </tr>
              </thead>
              <tbody id="bulk-select-body" class="list">
                <c:forEach var="payment" items="${data}" varStatus="stat">
                  <tr data-year="${payment.selectYear}" data-month="${payment.selectMonth}">
<!--                     <td class="align-middle white-space-nowrap"> -->
<!--                       <div class="form-check mb-0"> -->
<%--                         <input class="form-check-input" type="checkbox" id="checkbox-${stat.index}" data-bulk-select-row="data-bulk-select-row" /> --%>
<!--                       </div> -->
<!--                     </td> -->
<%--                     <td class="paymentNo text-center">${payment.paymentNo}</td> --%>
                    <td class="userNm text-center" onclick="openDetail('${payment.paymentNo}')" style="cursor: pointer;">${payment.userNm}</td>
                    <td class="deptNoNm text-center">${payment.deptNoNm}</td>
                    <td class="bankNm text-center">${payment.bankNm}</td>
                    <td class="actNo text-center">${payment.actNo}</td>
                    <td class="totalPayment text-center"><fmt:formatNumber pattern="###,###,###">${payment.totalPayment}</fmt:formatNumber> </td>
                    <td class="totalTex text-center"><fmt:formatNumber pattern="###,###,###">${payment.totalTex}</fmt:formatNumber></td>
                    <td class="pymntamt text-center"><fmt:formatNumber pattern="###,###,###">${payment.pymntamt}</fmt:formatNumber></td>
<%--                     <td class="selectYear text-center">${payment.selectYear}</td> --%>
<%--                     <td class="selectMonth text-center">${payment.selectMonth}</td> --%>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
            
            <table class="table mb-0" id="myTable2">
              <colgroup>
                <col width="30%">
                <col width="50%">
                <col width="20%">
              </colgroup>
              <thead class="text-black bg-200">
                <tr>
                	<td>공제 항목 합계</td>
                	<td>67,035,280원</td>
                	<td></td>
                </tr>
                <tr>
                	<td>공제 후 실지급액</td>
                	<td>386,931,382원</td>
                	<td></td>
                </tr>
                <tr>
                	<td>지급 항목 합계</td>
                	<td>453,962,100원</td>
                	<td></td>
                </tr>
               </thead>
             </table>
            <!-- 상세 모달 시작-->
				<div class="modal fade pdfArea" id="viewData" data-keyboard="false"
					tabindex="-1" aria-labelledby="scrollinglongcontentLabel" aria-hidden="true">
					<div class="modal-dialog modal-lg">
						<div class="modal-content border-0">
							<div class="modal-header">
								<h5 class="modal-title" id="scrollinglongcontentLabel">인사정보_연차</h5>
								<button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
							</div>
							<div class="modal-body modal-dialog modal-dialog-scrollable mx-0 mb-0" id="modalData">
								<h3 class="text-center mb-4">급여명세서</h3>
								<table class="table table-bordered align-middle text-align mb-3 border">
									<colgroup>
										<col width="20%">
										<col width="30%">
										<col width="20%">
										<col width="30%">
									</colgroup>
									<tbody id="dataRowsPayment">
										<tr>
											<td class="bg-primary-subtle text-center ">부서</td>
											<td class=" text-center" id="deptNoNmModal"></td>
											<td class="bg-primary-subtle text-center ">직급</td>
											<td class=" text-center" id="jbgdCdNmModal"></td>
										</tr>
										<tr>
											<td class="bg-primary-subtle text-center ">성명</td>
											<td class=" text-center" id="userNmModal"></td>
											<td class="bg-primary-subtle text-center ">생년월일</td>
											<td class=" text-center" id="brthYmdModal"></td>
										</tr>
										<tr>
											<td class="bg-primary-subtle text-center ">급여연월</td>
											<td class=" text-center" id="workYmModal"></td>
											<td class="bg-primary-subtle text-center ">급여지급일</td>
											<td class=" text-center" id="payYmdModal"></td>
										</tr>
									</tbody>
								</table>
								<table
									class="table table-bordered align-middle text-align mb-3 border">
									<colgroup>
										<col width="20%">
										<col width="30%">
										<col width="20%">
										<col width="30%">
									</colgroup>
									<tbody id="dataRowsPayment2" class="mb-2">
										<tr>
											<td class="bg-primary-subtle text-center " colspan="2">지급항목</td>
											<td class="bg-primary-subtle text-center " colspan="2">공제항목</td>
										</tr>
										<tr>
											<td class="bg-primary-subtle text-center ">기본급</td>
											<td class=" text-center" id="roundSalaryModal"></td>
											<td class="bg-primary-subtle text-center ">국민연금</td>
											<td class=" text-center" id="npnModal"></td>
										</tr>
										<tr>
											<td class="bg-primary-subtle text-center ">식대</td>
											<td class=" text-center" id="cgffdModal"></td>
											<td class="bg-primary-subtle text-center ">건강보험</td>
											<td class=" text-center" id="nhisModal"></td>
										</tr>
										<tr>
											<td class="bg-primary-subtle text-center ">연장근로수당</td>
											<td class=" text-center" id="extnSalaryModal">0</td>
											<td class="bg-primary-subtle text-center ">장기요양보험</td>
											<td class=" text-center" id="ltcModal"></td>
										</tr>
										<tr>
											<td class="bg-primary-subtle text-center ">야간근로수당</td>
											<td class=" text-center">0</td>
											<td class="bg-primary-subtle text-center ">고용보험</td>
											<td class=" text-center" id="emplyminsrncModal"></td>
										</tr>
										<tr>
											<td class="bg-primary-subtle text-center ">휴일근로수당</td>
											<td class=" text-center">0</td>
											<td class="bg-primary-subtle text-center ">소득세</td>
											<td class=" text-center" id="incmtaxModal"></td>
										</tr>
										<tr>
											<td class="bg-primary-subtle text-center "></td>
											<td class=" text-center"></td>
											<td class="bg-primary-subtle text-center ">지방소득세</td>
											<td class=" text-center" id="llxModal"></td>
										</tr>
										<tr>
											<td class="bg-primary-subtle text-center ">합계</td>
											<td class=" text-center" id="totalPaymentModal"></td>
											<td class="bg-primary-subtle text-center ">합계</td>
											<td class=" text-center" id="totalTexModal"></td>
										</tr>
									</tbody>
								</table>
								<table class="table table-bordered align-middle text-align mb-3 border">
									<colgroup>
										<col width="20%">
										<col width="20%">
										<col width="20%">
										<col width="40%">
									</colgroup>
									<tbody id="dataRowsPayment3" class="mb-2">
										<tr>
											<td class="bg-primary-subtle text-center">연장근로시간</td>
											<td class="bg-primary-subtle text-center">야간근로시간</td>
											<td class="bg-primary-subtle text-center">휴일근로시간</td>
											<td class="bg-primary-subtle text-center">공제 후 실지급액</td>
										</tr>
										<tr>
											<td class=" text-center ">0</td>
											<td class=" text-center ">0</td>
											<td class=" text-center ">0</td>
											<td class=" text-center" id="pymntamtModal"></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="d-flex justify-content-center" id="btnAreaPrint">
								<button class="btn btn-primary" type="button" onclick="startPrint()" id="btnPrint">인쇄</button>
<!-- 								<button class="btn btn-primary" type="button" onclick="savePDF()" id="btnPrint">PDF저장</button> -->
							</div>
							<div class="modal-footer" id="btnAreaClose">
								<button class="btn btn-secondary modalCloseBtn" type="button" data-bs-dismiss="modal">닫기</button>
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
</div>


<script type="text/javascript">
window.onload = function() {
	  filterBySelectValue();
	};

var selectOptYear = document.getElementById('selectOptYear');
var currentYear = new Date().getFullYear();

var selectOptMonth = document.getElementById('selectOptMonth');
var currentDate = new Date();
var currentMonth = (currentDate.getMonth() + 1).toString().padStart(2, '0');


for (var year = 2023; year >= 2000; year--) {
  var optionElement = document.createElement('option');
  optionElement.value = year;
  optionElement.textContent = year;
  selectOptYear.appendChild(optionElement);
}

function filterBySelectValue() {
  var selectOptYear = document.getElementById('selectOptYear').value;
  var selectOptMonth = document.getElementById('selectOptMonth').value;
 
  var tableRows = document.querySelectorAll('#bulk-select-body tr');

  tableRows.forEach(function(row) {
    var year = row.dataset.year;
    var month = row.dataset.month;

    if (year === selectOptYear && month === selectOptMonth) {
      row.style.display = 'table-row';
    } else {
      row.style.display = 'none';
    }
  });
}


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
	
	$(document).on("click", ".modalCloseBtn", function(){
		$("div.modal-backdrop").hide();
// 		$("body").removeClass("modal-open").removeAttr("style");
		$("#viewData")
// 		.removeClass("show")
// 		.removeAttr("role")
		.hide();
	})
}


function openDetail(paymentNo){
	console.log(paymentNo)
	var data = {
			"paymentNo" : paymentNo
		}
	
	$.ajax({
		url : "/empinfo/paymentDetail",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(data),
		type : "post",
		dataType : "JSON",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("${_csrf.headerName}",
					"${_csrf.token}");
		},
		success : function(result) {
			//consoel("전송성공")
			//location.href = "/empinfo/empinfo";
			console.log(result);
			$("#viewData").modal("show");
			
			
			//생년월일
			var birthDate = new Date(result.brthYmd);
			var birYear = birthDate.getFullYear();
			var birMonth = birthDate.getMonth() + 1; // 월은 0부터 시작하므로 1을 더해줌
			var birDay = birthDate.getDate();
			
			
			//급여지급일
			var payYmd = result.payYmd;
			var payYmdYear = payYmd.substring(0, 4);
			var payYmdMonth = payYmd.substring(4, 6);
			var payYmdDay = payYmd.substring(6, 8);
			
			
			//급여 연월
			var workYm = result.workYm;
			var workYmYear = workYm.substring(0, 4);
			var workYmMonth = workYm.substring(4, 6);
	
			//값 넣기
			$("#deptNoNmModal").text(result.deptNoNm);
			$("#jbgdCdNmModal").text(result.jbgdCdNm);
			$("#userNmModal").text(result.userNm);
			$("#brthYmdModal").text(birYear + "년 " + birMonth + "월 " + birDay + "일");
			$("#workYmModal").text(workYmYear + "년 " +workYmMonth + "월");
			$("#payYmdModal").text(payYmdYear + "년 " +payYmdMonth + "월" + payYmdDay + "일");
			
			$("#roundSalaryModal").text(result.roundSalary.toLocaleString());
			$("#npnModal").text(result.npn.toLocaleString());
			$("#cgffdModal").text(result.cgffd.toLocaleString());
			$("#nhisModal").text(result.nhis.toLocaleString());
			
			$("#extnSalaryModal").text(result.extnSalary.toLocaleString());
			$("#ltcModal").text(result.ltc.toLocaleString());
			$("#emplyminsrncModal").text(result.emplyminsrnc.toLocaleString());
			$("#incmtaxModal").text(result.incmtax.toLocaleString());
			$("#llxModal").text(result.llx.toLocaleString());
			$("#totalPaymentModal").text(result.totalPayment.toLocaleString());
			$("#totalTexModal").text(result.totalTex.toLocaleString());
			
			$("#pymntamtModal").text(result.pymntamt.toLocaleString());
			
		},
		error : function(xhr, status, error) {
			console.log("에러 발생:", error);
		}
	}); //ajax
	
	
}

//pdf저장 및 인쇄
function doPrint(){
	// 프린트를 보이는 그대로 나오기위한 셋팅
    window.onbeforeprint = function(ev) {
	    // 프린트 전에 내용을 복사하여 새 창에 적용
		var btnAreaPrint = document.getElementById('btnAreaPrint');
		var btnAreaClose = document.getElementById('btnAreaClose');
		btnAreaPrint.classList.remove('d-flex');
		btnAreaPrint.classList.add('d-none');
		btnAreaClose.style.display = 'none';
	
		
			
		var printContent = document.getElementById('modalData').innerHTML;
		var printWindow = window.open('', '_blank');
		printWindow.document.write('<html><head><title>인쇄</title>');
	//  printWindow.document.write('<link rel="preconnect" href="path/to/your/styles.css">');
		printWindow.document.write('</head><body>');
		printWindow.document.write(printContent);
		printWindow.document.write('</body></html>');
		printWindow.document.close();
		
		};

    window.print();
    location.reload();
		
	}
	
//엑셀 전직원 다운로드 컨트롤러이동
$("#allEmployees").click(function() {
	location.href = "/empinfo/paymentEmployeeExcel";

});








</script>
