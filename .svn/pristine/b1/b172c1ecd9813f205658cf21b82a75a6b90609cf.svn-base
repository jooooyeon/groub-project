<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="card">
	<div class="card-header">
		<div class="d-flex justify-content-between">
			<div class="row-auto">
				<h4>부서별 적합도 설정</h4>
			</div>
			<div class="col-auto">
				<label>적합도 설정 부서 선택 </label>
				<select class="form-control sel-dept-no" id="save-dept-no">
					<option>----------</option>
					<option value="1">인사</option>
					<option value="2">마케팅</option>
					<option value="3">영업</option>
					<option value="4">회계</option>
					<option value="5">개발</option>
					<option value="6">보안</option>
				</select>
			</div>
		</div>
	</div>
	<div class="card-body">
		<div class="card mb-3">
			<div class="card-body d-flex justify-content-between bg-light">
				<div>자격증</div>
				<div>
					<button id="add-certificate" data-toggle="modal" data-target="#exampleModal" class="btn btn-outline-primary btn-sm border border-light">추가하기</button>
				</div>
			</div>
		</div>
		<div id="crtfct" class=" border border-gray bg-white" style="height: 250px;"></div>
	
		<br />
	
		<div class="card mb-3 ">
			<div class="card-body d-flex justify-content-between bg-light">
				<div>자격 기술</div>
				<div>
					<button href="#" id="add-tech" data-toggle="modal" data-target="#exampleModal" class="btn btn-outline-primary btn-sm border border-light">추가하기</button>
				</div>
			</div>
		</div>
		<div id="qnsinfo" class=" border border-gray bg-white" style="height: 250px;"></div>
		<br />
	</div>
	<div class="card-footer">
		<div class=" d-flex justify-content-end bg-light">
			<button class="btn btn-outline-secondary border" id="fit-save">저장</button>
			<button class="btn btn-outline-secondary border" id="fit-cancle">취소</button>
		</div>
	</div>
</div>

<!-- 모달 시작 -->
<div class="modal fade" id="fit-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content" id="fit-modal-body"  style="background-color: transparent;">
		</div>
	</div>
</div>
<!-- 모달 끝 -->

<script>

	$('#fit-cancle').on('click',()=>{
		$('#rsm-modal').modal('hide');
	});
	
	$('#fit-save').on('click',function(){
		 var crtfcListValues = [];
	    $('.crtfcList').each(function() {
	        crtfcListValues.push($(this).data('value'));
	    });
		    
	    var skillListValues = [];
	    $('.skillList').each(function() {
	        skillListValues.push($(this).data('value'));
	    });
	    
	    var csrfToken = $("input[name='_csrf']").val();
	    
		$.ajax({
			url:'/goodness/add',
			type:'post',
			traditional: true,
			headers: {
	            'Content-Type': 'application/x-www-form-urlencoded',
	            'X-CSRF-TOKEN': csrfToken
	        },
			data:{
				crtfctList:crtfcListValues,
				skillList:skillListValues,
				finalEdu:$('#final-edu option:selected').val(),
				finalEduDtl:$('#final-edu option:selected').text(),
				career:$("#career option:selected").val(),
				careerDtl:$("#career option:selected").text(),
				deptNo:$('#save-dept-no option:selected').val(),
			},
			success:(res)=>{
				console.log(res);
			},
		});
	});

	$('#add-certificate').on('click', function() {
		$.ajax({
			url:'/goodness/add/popup',
			type:'get',
			data:{
				title:'자격증',
				condition: true,
				deptNo: 1
			},
			success:(res)=>{
				$('#fit-modal-body').html(res);
				$("#fit-modal").modal('show');
			},
		});
	})
	
	$('#add-tech').on('click', function() {
		$.ajax({
			url:'/goodness/add/popup',
			type:'get',
			data:{
				title:'자격기술',
				condition: false,
				deptNo: 1
			},
			success:(res)=>{
				$('#fit-modal-body').html(res);
				$("#fit-modal").modal('show');
			},
		});
	})
	
	$('#close').on('click',function(){
		$('#fit-modal').modal('hide');
	});
	
</script>
