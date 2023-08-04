<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<div class="card mb-3">
	<div class="card-header">
		<div class="min-vh-50">
			<h5>출차 현황 확인</h5>
			<form>
				<div style="float: left; width: 100px; padding: 10px"></div>
				<div id="tableExample4">
					<div class="row justify-content-end g-0">
							<div class="col-auto px-3 text-center" >
								<select class="form-select form-select-sm mb-3"
									aria-label="Bulk actions" data-list-filter="data-list-filter">
									<option selected="" value="">상태 확인</option>
									<option value="Success">입차</option>
									<option value="Blocked">출차</option>
								</select>
							</div>
						</div>
					</div>
					<div class="table-responsive scrollbar">
						<table
							class="table table-sm table-striped fs--1 mb-0 overflow-hidden text-center">
							<thead class="bg-200 text-900">
								<tr>
									<th class="sort pe-1 align-middle white-space-nowrap" data-sort="vhclNo">차량 번호</th>
									<th class="sort pe-1 align-middle white-space-nowrap" data-sort="cgDt">시간</th>
									<th class="sort pe-1 align-middle white-space-nowrap" data-sort="vhclIo">입/출차</th>
								</tr>
							</thead>
							<tbody class="list">
								<c:forEach var="vehicleVO" items="${data}" varStatus="stat">
									<tr class="btn-reveal-trigger">
										<th id="licensePlateValue" class="align-middle white-space-nowrap vhclNo">${vehicleVO.vhclNo}</th>
										<td class="align-middle white-space-nowrap cgDt"><fmt:formatDate value="${vehicleVO.cgDt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td class="align-middle pe-1 fs-0 white-space-nowrap vhclIo">
										<c:choose>
											<c:when test="${vehicleVO.vhclIo == 'O'}">
												<span class="badge badge rounded-pill badge-subtle-danger">출차
												<span class="ms-1 fas fa-car" data-fa-transform="shrink-2"></span></span>
											</c:when>
											<c:otherwise>
												<span class="badge badge rounded-pill badge-subtle-success">입차
												<span class="ms-1 fas fa-check" data-fa-transform="shrink-2"></span></span>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				<br />
				<br />
			</form>
			<form id="dataGo" action="http://127.0.0.1:5000/menu" method="post">
				<div class="input-group">
				  <label class="input-group-text" for="licenseImg">
				    <i class="fas fa-camera"></i>
				  </label>
				  <input class="form-control" type="file" id="licenseImg" style= "display:none"/> 카메라 버튼을 눌러 번호판이 포함된 차량 사진을 업로드 하세요.
				</div>
<!-- 				<input class="form-control" type="file" id="licenseImg" /> -->
				<button class="btn btn-outline-danger btn-sm" type="button" onclick="vehicleOut()">출차</button>
				<button class="btn btn-outline-success btn-sm" type="button" onclick="vehicleIn()">입차</button>
				<sec:csrfInput />
			</form>
			<br />
		</div>
	</div>
</div>

<script>
	function vehicleIn() {
		var formData = new FormData();
		var licenseImg = document.getElementById('licenseImg').files[0];
		formData.append('licenseImg', licenseImg)
		console.log(typeof licenseImg);

		// ajax를 이용해서 flask와 데이터 주고 받기
		$.ajax({
			// flask와 연결
			url : 'http://127.0.0.1:5000/vehicleIn.ajax',
			contentType : false,
			processData : false,
			type : "POST",
			data : formData,
			dataType : "json",
			success : function(resp) {
				console.log(resp);
				var vhcl_no = resp.vhcl_no;
				//json 형태로 받아온 값
				$("#licensePlateValue").text(vhcl_no);
				location.reload(); // 페이지 새로고침
				alert("입차되었습니다.");
			},
			error : function() {
				alert('error');
			}
		});
		
	}
	function vehicleOut() {
		var formData = new FormData();
		var licenseImg = document.getElementById('licenseImg').files[0];
		formData.append('licenseImg', licenseImg)
		console.log(typeof licenseImg);

		// ajax를 이용해서 flask와 데이터 주고 받기
		$.ajax({
			// flask와 연결
			url : 'http://127.0.0.1:5000/vehicleOut.ajax',
			contentType : false,
			processData : false,
			type : "POST",
			data : formData,
			dataType : "json",
			success : function(resp) {
				console.log(resp);
				var vhcl_no = resp.vhcl_no;
				//json 형태로 받아온 값
				$("#licensePlateValue").text(vhcl_no);
				location.reload(); // 페이지 새로고침
				alert("출차되었습니다.");
				
			},
			error : function() {
				alert('out error');
			}
		});
		
	}
</script>

