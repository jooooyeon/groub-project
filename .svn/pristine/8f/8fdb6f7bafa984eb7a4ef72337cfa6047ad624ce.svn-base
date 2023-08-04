<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css" />
	


<%-- ${data } --%>

<div class="container">
	<div class="row">
		<div class="card mb-3">
			<div class="card-header ">
				<div class="row flex-between-end">
					<div class="col-auto align-self-center">
						<h3 class="mb-0" >설문조사</h3>
						<p class="mb-0 pt-1 mt-2 mb-0"></p>
					</div>
					<div class="col-auto ms-auto">
						<div class="nav nav-pills nav-pills-falcon flex-grow-1 mt-2"
							role="tablist"></div>
					</div>
				</div>
			</div>
			
			<form name="frm1" action="/servey/serveyListPost?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
			<input type="hidden" name="srvyNo" value="${data.srvyNo }" />
			<div class="card-body" id="modalData">
				<div class="border border-2 p-2">
					<table
						class="table table-bordered align-middle text-align border border-2">
						<colgroup>
							<col width="20%">
							<col width="80%">
						</colgroup>
						<tbody >
							<tr>
								<td class=" bg-primary-subtle text-center">제목</td>
								<td class=" text-center ">${data.srvyTtl}</td>
							</tr>
							<tr>
								<td class=" bg-primary-subtle text-center">기간</td>
								<td class=" text-center " id="serveyDate"></td>
							</tr>
							<tr>
								<td class=" bg-primary-subtle text-center">안내문구</td>
								<td class="  ">${data.srvyCn}</td>
							</tr>
						</tbody>
					</table>
					
					
					
					<table id="myTable"
						class="table table-bordered align-middle text-align border border-2">
						<colgroup>
							<col width="20%">
							<col width="80%">
						</colgroup>
						<c:forEach var="serveyQItemVO" items="${data.serveyQItemVOList }" varStatus="stat">
							<input type="hidden" name="qNo" value="${serveyQItemVO.qitemNo}" />
						<tbody class="myTbody">
							<tr>
								<td class=" bg-primary-subtle text-center" rowspan="2">${stat.count }</td>
								<td class="" >${serveyQItemVO.qitemCt}</td>
							</tr>
							<tr class="bokiList" id="bokiList">
								<td class="boki" name="boki" >
							<c:forEach var="serveyOptionVO" items="${serveyQItemVO.serveyOptionVOList}" varStatus="stat2">
									<input class="radio" type="radio" name="bokiboki${stat.count}" id="opn${stat.count}${stat2.count}" value="${serveyOptionVO.optnCt}"   onclick="aaa('${serveyOptionVO.optnNo}', ${stat.count})">
									<label class="form-check-label"  for="opn${stat.count}${stat2.count}">${serveyOptionVO.optnCt }</label>
									&nbsp;&nbsp;&nbsp;
							</c:forEach>
									 <input type="hidden" id="${stat.count}" name="rsCt" value="">
								</td>
							</tr>
						</tbody>
						</c:forEach>
					</table>
				<div class="d-flex justify-content-between ">
					<button type="button" class="btn btn-secondary  me-1 mb-1" onclick="goList()">목록</button>
					<button class="btn btn-primary me-1 mb-1" onclick="savemodal()">저장</button>
				</div>
				

				</div>
			</div>
			
		<sec:csrfInput />
		</form>
		</div>
	</div>
</div>


<script>

function aaa(a, statCount){
	
	console.log("a",a)
	
	const inputElement = document.getElementsByName('rsCt');
	inputElement[statCount-1].value = a;
}







//목록이동
function goList(){
	window.location.href = '/servey/serveyList';
}


//날자 짜르기
var bgngDtData = `${data.bgngDt}`;
var endDtData = `${data.endDt}`;
//console.log(bgngDtData)
bgngDtData = bgngDtData.substring(0, 10);
endDtData = endDtData.substring(0, 10);

var serveyDateElement = document.getElementById('serveyDate');
serveyDateElement.textContent = bgngDtData + '  ~  ' + endDtData;


</script>				
							
							

		
						