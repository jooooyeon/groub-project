<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>






<h3>이력서 작성</h3>
<hr class="w-75" />
<div class="">
	<label>최종학력</label>
	<div>
		<select>
			<option>--------------</option>
			<option>고등학교 졸업</option>
			<option>대학교 졸업</option>
			<option>대학원 졸업(석사)</option>
			<option>대학원 졸업(박사)</option>
		</select>
	</div>
	<hr class="w-75" />
	<label>경력사항</label>
	<div class="d-flex">
		<div>
			<label>회사명</label> <input type="text" class="form-control">
		</div>
		<div>
			<label>근무기간</label> <input type="text" class="form-control">
		</div>
		<div>
			<label>담당업무</label> <input type="text" class="form-control">
		</div>
	</div>
	<hr class="w-75" />
	<div>
		<div class="d-flex justify-content-between align-item-center">
			<div>자격증</div>
			<a href="#" id="add-certificate" data-toggle="modal"
				data-target="#exampleModal"
				class="btn-link btn-outline-primary small">추가하기</a>
		</div>
		<table class="table table-bordered border-secondary">
			<thead>
				<tr class="table-active">
					<th>자격명</th>
					<th>자격번호</th>
					<th>자격등급</th>
					<th>취득일</th>
					<th>정지일</th>
					<th>기관명</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>

	<hr class="w-75" />

	<div class="card mb-3 w-50">
		<div class="card-body d-flex justify-content-between bg-light">
			<label>자격 기술</label>
			<div>
				<a href="#" id="add-tech" data-toggle="modal"
					data-target="#exampleModal"
					class="btn-link btn-outline-primary small">추가하기</a>
			</div>
		</div>
	</div>
	<div id="tech" class="w-50 border border-gray bg-white"
		style="height: 250px;"></div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-body">...</div>
		</div>
	</div>
</div>

<script>
	$('#add-certificate').on('click', function() {
		$.ajax({
			url:'/goodness/add',
			data:{
				
			},
			type:'get',
			success:(res)=>{
				$('.modal-content').html(res);
				console.log($('.modal-content'))
				$("#exampleModal").modal('show');
			},
		})
	})

	$('#add-tech').on('click', function() {
		$("#exampleModal").modal('show');
	})
	
	$('#close').on('click',function(){
		$('#exampleModal').modal('hide');
	});
</script>