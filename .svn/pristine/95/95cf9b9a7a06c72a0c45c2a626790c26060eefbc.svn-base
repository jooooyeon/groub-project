<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css" />
<style>
.iconBtn {
  border: none; /* 버튼의 보더를 제거합니다 */
  background-color: transparent;
  /* 이외에 필요한 스타일들을 추가로 설정할 수 있습니다. */
}
</style>
<div class="container ">
	<div class="row">
		<div class="card mb-3">
			<div class="card-header ">
				<div class="row flex-between-end">
					<div class="col-auto align-self-center">
						<h3 class="mb-0">설문작성</h3>
						<p class="mb-0 pt-1 mt-2 mb-0"></p>
					</div>
					<div class="col-auto ms-auto">
						<div class="nav nav-pills nav-pills-falcon flex-grow-1 mt-2"
							role="tablist"></div>
					</div>
				</div>
			</div>
			<!-- card-header -->
			<div class="card-body" id="modalData">
				<p class="mb-0">기본정보</p>
				<table
					class="table table-bordered align-middle text-align border border-2">
					<colgroup>
						<col width="20%">
						<col width="80%">
					</colgroup>
					<tbody>
						<tr>
							<td class=" bg-primary-subtle text-center">제목</td>
							<td class=" text-center" ><input type="text" id="srvyTtl"
								class="form-control"></td>
						</tr>
						<tr>
							<td class=" bg-primary-subtle text-center">기간</td>
							<td class=" text-center">
								<div class="d-flex ">
									<input class="form-control datetimepicker " id="bgngDt"
										type="text" placeholder="YYYY-MM-DD"
										data-options='{"disableMobile":true}'
										style="text-align: center;" required />

									<div class="px-2 align-self-center">~</div>

									<input class="form-control datetimepicker " id="endDt"
										type="text" placeholder="YYYY-MM-DD"
										data-options='{"disableMobile":true, "locale": ko}'
										style="text-align: center;" required />
								</div>
						</tr>
						<tr>
							<td class=" bg-primary-subtle text-center">유형</td>
							<td class="  ">
							 <input type="radio" name="typeCheck" value="radioCheck" checked/>  <span>&nbsp;선택형 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 설문 참여자가 항목을 선택하여 답변 할 수 있습니다. </span> <br />
                			 <input type="radio" name="typeCheck" value="tectCheck" /><span> &nbsp;텍스트형 &nbsp;&nbsp;&nbsp; 설문 참여자가 텍스트를 작성하여 답변 할 수 있습니다.</span> <br />
                			 <input type="radio" name="typeCheck" value="pointCheck" /><span> &nbsp;점수형 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;설문 참여자가 점수를 선택하여 답변 할 수 있습니다.</span>
							</td>
						</tr>
						<tr>
							<td class=" bg-primary-subtle text-center">안내문구</td>
							<td class=" text-center"><textarea class="form-control" 
									id="srvyCn" rows="3"
									placeholder="설문에 대한 취지를 입력해 주세요"></textarea></td>
						</tr>
					</tbody>
				</table>
				
				</div>
			<!-- card-body -->
		</div>
	</div>
</div>


<div class="container ">
	<div class="row">
		<div class="card mb-3">
			<div class="card-body" id="modalData">
				<p class="mb-0">설문내용</p>
				<div id="tbDiv" class="tbDiv">
					<table class="table table-bordered align-middle text-align border border-2 servayTable">
						<colgroup>
							<col width="20%">
							<col width="70%">
							<col width="10%">
						</colgroup>
						<tbody>
							<tr>
								<td class=" bg-primary-subtle text-center">질문</td>
									<td class=" text-center">
									<input type="text" name="qitemCt" class="form-control" placeholder="질문을 입력해 주세요"></td>
										<td class=" text-center" rowspan="2" >
											<button onclick="deleteBokiTable(this)"  class="bi-trash-fill iconBtn" ></button>
										</td>
							</tr>
							<tr>
								<td class=" bg-primary-subtle text-center align-top" >보기
								<button class="btn-primary  bi-plus-square iconBtn"  id="addBoki" onclick="addBoki(this)"></button>
								</td>
									<td class="text-center bokiTd">
									  <div class="d-flex align-items-center bokiDiv mb-2">
									    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요">
									    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
									  </div>
									</td>
							</tr>
							
					</tbody>
					</table>
						
				</div>
				<div class="d-flex justify-content-between ">
					<button class="btn btn-info  me-1 mb-1" onclick="addServey()">항목추가</button>
					<button class="btn btn-primary me-1 mb-1" onclick="saveServey2()">저장</button>
				</div>
				
		<button type="button" onclick="autoWrite()">자동완성</button>
			</div>
		</div>
	</div>
</div>

<!--  모달 시작-->
					<div class="modal fade" id="addModal" data-keyboard="false"
						tabindex="-1" aria-labelledby="scrollinglongcontentLabel"
						aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="scrollinglongcontentLabel">설문조사</h5>
									<button class="btn-close" type="button" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body modal-dialog modal-dialog-scrollable">
									<p style="">저장하시겠습니까?</p>
								</div>
								<div class="modal-footer">
									<button class="btn btn-primary" type="button" onclick="saveServey()">확인</button>
									<button class="btn btn-secondary" type="button"
										data-bs-dismiss="modal">취소</button>
								</div>
							</div>
						</div>
					</div>
					<!-- 모달 끝-->




<script type="text/javascript">
  var jQuery1x = jQuery.noConflict();
</script>


<script type="text/javascript">
//자동입력
function autoWrite(){

	//제목
	$("#srvyTtl").val("사내 복지 제도 설문조사")
	$("#bgngDt").val("2023-07-26")
	$("#endDt").val("2023-08-04")
	//안내 문구
	$("#srvyCn").val("회사 내 직원들의 복지에 대한 만족도와 개선점을 파악하기 위해 실시합니다. 이 설문조사를 통해 회사가 제공하는 다양한 복지 혜택과 정책에 대한 직원들의 의견을 수집하고, 그 결과를 바탕으로 더 나은 복지 제도를 구축하고 개선하는데 목적이 있습니다.")
	
	var newServey = `
		<table class="table table-bordered align-middle text-align border border-2 servayTable">
		<colgroup>
			<col width="20%">
			<col width="70%">
			<col width="10%">
		</colgroup>
		<tbody>
			<tr>
				<td class=" bg-primary-subtle text-center">질문</td>
					<td class=" text-center">
					<input type="text" name="qitemCt" class="form-control" placeholder="질문을 입력해 주세요"  value = "귀하의 성별을 선택해 주세요"></td>
						<td class=" text-center" rowspan="2" >
							<button onclick="deleteBokiTable(this)"  class="bi-trash-fill iconBtn" ></button>
						</td>
			</tr>
			<tr>
				<td class=" bg-primary-subtle text-center align-top" >보기
				<button class="btn-primary  bi-plus-square iconBtn"  id="addBoki" onclick="addBoki(this)"></button>
				</td>
					<td class="text-center bokiTd">
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "남성">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "여성">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					</td>
			</tr>
			
	</tbody>
	</table>
	
		<table class="table table-bordered align-middle text-align border border-2 servayTable">
		<colgroup>
			<col width="20%">
			<col width="70%">
			<col width="10%">
		</colgroup>
		<tbody>
			<tr>
				<td class=" bg-primary-subtle text-center">질문</td>
					<td class=" text-center">
					<input type="text" name="qitemCt" class="form-control" placeholder="질문을 입력해 주세요"  value = "귀하의 연령대를 선택해 주세요"></td>
						<td class=" text-center" rowspan="2" >
							<button onclick="deleteBokiTable(this)"  class="bi-trash-fill iconBtn" ></button>
						</td>
			</tr>
			<tr>
				<td class=" bg-primary-subtle text-center align-top" >보기
				<button class="btn-primary  bi-plus-square iconBtn"  id="addBoki" onclick="addBoki(this)"></button>
				</td>
					<td class="text-center bokiTd">
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "20대">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "30대">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "40대">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "50대">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					</td>
			</tr>
			
	</tbody>
	</table>
	
	
		<table class="table table-bordered align-middle text-align border border-2 servayTable">
		<colgroup>
			<col width="20%">
			<col width="70%">
			<col width="10%">
		</colgroup>
		<tbody>
			<tr>
				<td class=" bg-primary-subtle text-center">질문</td>
					<td class=" text-center">
					<input type="text" name="qitemCt" class="form-control" placeholder="질문을 입력해 주세요"  value = "가장 선호하는 복지를 골라 주세요"></td>
						<td class=" text-center" rowspan="2" >
							<button onclick="deleteBokiTable(this)"  class="bi-trash-fill iconBtn" ></button>
						</td>
			</tr>
			<tr>
				<td class=" bg-primary-subtle text-center align-top" >보기
				<button class="btn-primary  bi-plus-square iconBtn"  id="addBoki" onclick="addBoki(this)"></button>
				</td>
					<td class="text-center bokiTd">
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "점심 식대 지원">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "생일 축하금 지원">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "자기 계발비 지원">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "기념일 조기 퇴근">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					</td>
			</tr>
			
	</tbody>
	</table>
	
	
	
		<table class="table table-bordered align-middle text-align border border-2 servayTable">
		<colgroup>
			<col width="20%">
			<col width="70%">
			<col width="10%">
		</colgroup>
		<tbody>
			<tr>
				<td class=" bg-primary-subtle text-center">질문</td>
					<td class=" text-center">
					<input type="text" name="qitemCt" class="form-control" placeholder="질문을 입력해 주세요"  value = "현재 시행하는 복지 가운데 보완해야 할 점을 선택해 주세요"></td>
						<td class=" text-center" rowspan="2" >
							<button onclick="deleteBokiTable(this)"  class="bi-trash-fill iconBtn" ></button>
						</td>
			</tr>
			<tr>
				<td class=" bg-primary-subtle text-center align-top" >보기
				<button class="btn-primary  bi-plus-square iconBtn"  id="addBoki" onclick="addBoki(this)"></button>
				</td>
					<td class="text-center bokiTd">
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "식대 금액 인상">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "자기 계발비 금액 인상">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "명절 선물 변경">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "생일 축하금 금액 인상">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					</td>
			</tr>
			
	</tbody>
	</table>
		<table class="table table-bordered align-middle text-align border border-2 servayTable">
		<colgroup>
			<col width="20%">
			<col width="70%">
			<col width="10%">
		</colgroup>
		<tbody>
			<tr>
				<td class=" bg-primary-subtle text-center">질문</td>
					<td class=" text-center">
					<input type="text" name="qitemCt" class="form-control" placeholder="질문을 입력해 주세요"  value = "희망하는 복리후생에 대해서 선택해 주세요"></td>
						<td class=" text-center" rowspan="2" >
							<button onclick="deleteBokiTable(this)"  class="bi-trash-fill iconBtn" ></button>
						</td>
			</tr>
			<tr>
				<td class=" bg-primary-subtle text-center align-top" >보기
				<button class="btn-primary  bi-plus-square iconBtn"  id="addBoki" onclick="addBoki(this)"></button>
				</td>
					<td class="text-center bokiTd">
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "주4일제 시행">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "장소,시간에 구애받지 않는 자율근무">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					  <div class="d-flex align-items-center bokiDiv mb-2">
					    <input type="text"  class="form-control " name="boki" placeholder="보기를 입력해 주세요" value = "감각적인 인테리어의 사무실">
					    <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
					  </div>
					</td>
			</tr>
			
	</tbody>
	</table>
	
	
	
	
	`
	
	
	
	$("#tbDiv").html(newServey);
	
}




//보낼 값 가져오기
function saveServey(){
	
	stomp.send('/pub/servey', {}, JSON.stringify({
		sender: userId,
	}));

	//설문제목
	var srvyTtl = document.getElementById("srvyTtl").value;
	console.log("srvyTtl: ",srvyTtl) 
	
	//설문 시작일
	var bgngDt = document.getElementById("bgngDt").value;
	console.log("bgngDt: ",bgngDt) 
	
	//설문 종료일
	var endDt = document.getElementById("endDt").value;
	console.log("endDt :" ,endDt)
	
	//설문목적
	var srvyCn = document.getElementById("srvyCn").value;
	console.log("srvyCn : ",srvyCn)
	
	//설문유형
	const inputType = $("input[name='typeCheck']:checked").val();
	console.log("inputType",inputType);
	
	//설문지
	var servayTable = document.querySelectorAll('.servayTable');
	console.log("servayTable", servayTable);
	
	
	
	let serveyQItemVOList = []
	
	for (let i = 0; i < servayTable.length; i++) {
	    const qitemCtInput = servayTable[i].querySelector('input[name="qitemCt"]');
	    const bokiTd = servayTable[i].querySelector('.bokiTd');
	    const bokiDiv = bokiTd.querySelectorAll('.bokiDiv');
		
		let optnCt = []
		for(let i=0; i < bokiDiv.length; i++){
			const bokiInput = bokiDiv[i].querySelector(`input[name='boki']`);
			optnCt.push({"optnCt":bokiInput.value});
		}
		serveyQItemVOList.push({"qitemCt":qitemCtInput.value, "inputType":inputType, "serveyOptionVOList":optnCt});
	}
	console.log("serveyQItemVOList",serveyQItemVOList);
	
	var csrfToken = $("input[name='_csrf']").val();
	
	$.ajax({
		url : '/servey/serveySave',
		type : 'post',
		headers: {
            'X-CSRF-TOKEN': csrfToken
        },
        contentType:'application/json;charset=UTF-8',
        data:JSON.stringify({
        	srvyTtl: srvyTtl,
        	bgngDt: bgngDt,
        	endDt: endDt,
        	srvyCn: srvyCn,
        	serveyQItemVOList: serveyQItemVOList,
        }),
		success : function(res) {
			console.log("설문 전달 완료")
			location.href = "/servey/serveyList";
		}
	});
}

function addServey() {

  var addServeyHtml = `
    <table class="table table-bordered align-middle text-align border border-2 servayTable">
      <colgroup>
        <col width="20%">
        <col width="70%">
        <col width="10%">
      </colgroup>
      <tbody>
        <tr>
          <td class="bg-primary-subtle text-center">질문</td>
          <td class="text-center">
            <input type="text" class="form-control" name="qitemCt" placeholder="질문을 입력해 주세요" >
          </td>
          <td class="text-center" rowspan="2">
            <button onclick="deleteBokiTable(this)" class="bi-trash-fill iconBtn" ></button>
          </td>
        </tr>
        <tr>
	        <td class=" bg-primary-subtle text-center align-top" >보기
				<button class="btn-primary  bi-plus-square iconBtn"  id="addBoki" onclick="addBoki(this)"></button>
			</td>
          <td class="text-center bokiTd">
          <div class="d-flex align-items-center bokiDiv mb-2">
		      <input type="text" class="form-control" name="boki" placeholder="보기를 입력해 주세요"  >
		      <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
		    </div>
          </td>
        </tr>
      </tbody>
    </table>
  `;
  

  $(".tbDiv").append(addServeyHtml);
}




function addBoki(button){
	console.log("보기내역 추가 할거야");
	 var boki = `
		    <div class="d-flex align-items-center bokiDiv mb-2">
		      <input type="text" class="form-control" name="boki" placeholder="보기를 입력해 주세요">
		      <button onclick="deleteBoki(this)" class="iconBtn bi-backspace"></button>
		    </div>`;
	 $(button).closest("tr").find(".bokiTd").append(boki);
}

//문항 하나 지우기
function deleteBokiTable(button) {
	  var table = $(button).closest("table");
	  table.remove();
	  console.log("테이블 삭제되었습니다.");
	}

//보기한줄 지우기
function deleteBoki(button) {
	 $(button).closest("div.d-flex.align-items-center").remove();
  }
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  /////////////////////////////////////////////////////////////////////////////////////////
//설문 문항 타입 선택
function addServey123123123(){
	var question = 
		
		`<table
					class="table table-bordered align-middle text-align border border-2 question">
					<colgroup>
						<col width="20%">
						<col width="80%">
					</colgroup>
					<tbody>
						<tr>
							<td class=" bg-primary-subtle text-center">문항타입 선택</td>
							<td class=" text-center  d-flex align-items-center">
								<select class="form-select col-8" onchange="changeSelect()" >
									<option value="selectType">---문항타입---</option>
									<option value="selectType">선택형</option>
									<option value="textType">텍스트형</option>
									<option value="scoreType">점수형</option>
								</select>
								<button id="deleteMunhang" onclick="deleteMunhang(this)">x<button>
							</td>
						</tr>`

		$("#Qposition").append(question);

						
						
}



//설문문항타입 가져오기
function changeSelect() {
  var selectedType = $(".form-select").val();
  console.log(selectedType);
  
  if(selectedType === 'selectType') {
	    var selectedTypeAn = "난 선택형 답변나올곳";
	    $(".question").append(selectedTypeAn);
	  } 
}


	


function deleteMunhang213123(button) {
	  var row = $(button).closest("table");
	  row.remove();
	  console.log("행이 삭제되었습니다.");
	}




/////////////////////////////////////////////////////////////////////////
//조직도에서 선택된 직원 아이디 값 받아오기
function cklickSave(){
	console.log("dddd")
	
	var targetUser = $("#targetUser").text();
	console.log(targetUser)
	
	let lineIdArr = [];
	$("#targetUser").find(".lineId").each(function(i,v){
		lineIdArr.push($(v).val());
	});
	console.log("lineIdArr", lineIdArr);
}


function saveServey2(){
$("#addModal").modal("show");
	
}

$(function (){
	
	// DB에서 조직 정보 가져오기
	jQuery1x.ajax({
		url:"/organization/jsonList",
		type:"post",
		dataType:"json",
		beforeSend: function(xhr) {
            xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
        },
		success:function(result){
			//[{"userId":"NAVER_2023060009","userNm":"김윤아","userTelno":"01029949383","userEml":"2023060009@naver.com","userImg":"NULL","deptNo":1,"jbgdCd":"JG001","jbtlCd":"JT001"}
		 	const data = [];
		 	let nodes = result;
		 	
		 	// parent 기준으로 데이터 정리
		 	const parents = {};
		 	nodes.forEach(node => {
		 	  if (!parents[node.parent]) {
		 	    parents[node.parent] = [];
		 	  }
			  // idCard를 가져올 때 index가 아니라 id를 가져와야 함!!
		 	  parents[node.parent].push({name : node.child, id : node.id, jbgdCd : node.jbgdCd, userImg: node.img, deptNm : node.dept});
		 	});
			
		 	// jstree에서 사용할 수 있는 형태로 데이터 변환
		 	Object.keys(parents).forEach(parent => {
		 	  const children = parents[parent].map(child => {
		 	    return {text: child.name + " " + child.jbgdCd, type: "file", id : child.id, userImg : child.userImg, deptNm : child.deptNm};
		 	  });
		 	  data.push({
		 	    text: parent,
		 	    children: children
		 	  });
		 	});
		 	
		 	// ajax data 받아오기 
		 	jQuery1x('#jstree').jstree({
		 		'core': {
		 			"check_callback" : true,
		 			'data': data
		 			},
		 		"types" :{
		 			"default" : {
		 				"icon" : "fa-solid fa-folder"
		 			},
		 			"file" : {
		 				"icon" : "fa-solid fa-address-card"
		 			}
		 		},	
		 		"plugins" : ["types", "dnd", "search"]
		 		
		 		
		 		//children node 클릭했을때 hidden 처리 해제
		 	}).on('select_node.jstree', function(event, data) {
		 		
				var selectedNode = data.node;
				// 자식 노드(사원 정보)일 경우 이벤트 실행
				if(selectedNode.parent != '#') {
					//중복 실행 방지
					$("#draftmy1").off().on('click', function() {
						lineEdit(selectedNode);
					})

				}
				
				// 확인 버튼
				$("#lineSave").off().on("click", function() {
					console.log("확인버튼");
					// 확정이 난 데이터에서 수정할 데이터라는 뜻을 가진 클래스를 지워줌
					$(".draft-line, .draft-susin, .draft-ram").removeClass("draft-line draft-susin draft-ram");
					// 삭제버튼을 눌러 d-none 처리했던 태그들을 지워줌
					$(".draft-div.d-none, .draft-div.d-none, .draft-div.d-none").remove();
					
					// 확인 누르면 기존에 등록된 html을 초기화
					$("#targetUser").html("");
					
					//추가로 생성됬던 태그들을 결재선 설정 밖으로 보내줌
					$("#lineSpace > .alert").each(function(index, value) {
						changeDisplay(index, value);
							
					});		
					
				})
				
		 	});
			 	
		}
		 	
	});
})

function lineEdit(selectedNode) {
	console.log("selectedNode",selectedNode)
	var userNm = selectedNode.text.split(" ")[0];
	var jbgdNm = selectedNode.text.split(" ")[1];
	var userId = selectedNode.id;
	var userImg = selectedNode.original.userImg;
	var deptNm = selectedNode.original.deptNm;
	var line =
			`<div class="alert card mb-3 kanban-item shadow-sm dark__bg-1100 p-0 draft-div draft-line" style="border: 0px">
				<div class="card-body border p-2">
					<div class="d-flex align-items-center fs--1 fw-medium font-sans-serif mb-0">
						<div class=" mx-auto">` + `</div>
						<input type="hidden" id="lineId" class="lineId" value="` + userId + `" />
						<div class=" mx-auto">` + userNm + `</div>
						<div class="mx-auto">
						<span class="hidden-data">` + deptNm + `</span>
					</div>
					<div class="mx-auto">
						<span class="hidden-data">` + jbgdNm + `</span>
					</div>
						<button class="btn-close close-card draft-del-btn" type="button" onclick="removeSelectedPerson(this)"></button>
					</div>
				</div>
			</div>`
		$("#lineSpace").append(line);
		
}

//조직도에서 선택한 대상자 삭제
function removeSelectedPerson(button) {
	  var card = button.closest('.card');
	  if (card) {
	    card.remove(); // 선택한 데이터의 부모 요소인 card를 제거합니다.
	  }
	}




	// 조직도 내 검색 기능
	$('#search').on('keyup', function () {
	    var searchString = $(this).val();
	   jQuery1x('#jstree').jstree(true).search(searchString);
	    
	});

	
	
	// 결제선 설정 모달 밖으로 결제선 생성 
	function changeDisplay(index, value){
		var content = value.cloneNode(true);
		
		// 결재 라인 내용 태그
			var draftLineContent = content.querySelector('.card-body > .d-flex')
			content.classList.remove('kanban-item');
		
		// form에 전달할 userId 생성
			var atrzUserId = content.querySelector('#lineId').value;
			var inputHiddenId = document.createElement('input');
			inputHiddenId.setAttribute('type', 'hidden');
			inputHiddenId.setAttribute('name', 'serveyVOList[' + index + '].userId');
// 			inputHiddenId.setAttribute('value', atrzUserId);
			
			draftLineContent.prepend(inputHiddenId);
		// form에 전달할 userId 생성
				
			$("#targetUser").append(content);
	}
	
	
	
	
	
	
	
	
</script>







