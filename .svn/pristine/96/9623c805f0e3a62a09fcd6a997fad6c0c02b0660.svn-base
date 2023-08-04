<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%-- 	${data} --%>


<div class="card mb-3">
	<div class="card-header">
		<div>
			<div>
				명함인식
				<sec:authorize access="isAuthenticated()">
				</sec:authorize>
			</div>
		</div>
	</div>

	<div class="card-body bg-light d-flex">
		<div>
			<div class="row d-flex justify-content-center">
				<div class="mb-4 " style="width: 35rem;">
					<div id="bdControl" class="card border h-100 border-primary ">
						<div class="card-body">
							<div class="card-title">
								<input class="form-control-plaintext text-left" type="text"
									placeholder="회사명" id="osCoNm" name="osCoNm" value="" />
							</div>
							<div class="d-flex">
								<div class="me-2">
									<input class="form-control-plaintext pb-0" type="text"
										placeholder="이름" id="osUserNm" name="osUserNm" value="" />
									<label class="form-label mt-0" for="osUserNm"> <input
										class="form-control-plaintext pt-0" type="text"
										placeholder="직급명" id="osJbgdNm" name="osJbgdNm" value="" />
									</label>
								</div>
								<div class="border-start border-3 ps-3 w-100">
									<div class="d-flex">
										<div class="align-self-center me-2">Dept:</div>
										<input class="form-control-plaintext" type="text"
											placeholder="부서명" id=osDeptNm name="osDeptNm" value="" />

									</div>
									<div class="d-flex">
										<div class="align-self-center me-2">Email:</div>
										<input class="form-control-plaintext" type="email"
											placeholder="이메일" id="osEml" name="osEml"
											value="" />
									</div>
									<div class="d-flex">
										<div class="align-self-center me-2">Mobile:</div>
										<input class="form-control-plaintext" type="text"
											placeholder="핸드폰번호" id="osTel" name="osTel"
											value="" />
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<div class="d-flex justify-content-center">
				<div id="lod">
				</div>
			</div>
			<div class="d-flex justify-content-center my-3">
				<input class="form-control invisible" /> 
				<input
					class="form-control" type="file" id="cardImg" name="cardImg"/>
				<button class="btn btn-secondary" style="width: 11em" type="button" id="mybtn33" name="btn">전송</button>
				<input class="form-control invisible" />
			</div>
<!-- 			<div class="d-flex justify-content-center"> -->
<!-- 				<input class="form-control invisible" />  -->
<!-- 				<input class="form-control" type="text" value="사진찍기" />  -->
<!-- 				<input class="form-control invisible" /> -->
<!-- 			</div> -->
			<div class="d-flex justify-content-center">
				<button class="btn btn-primary mt-2" type="button">저장하기</button>
			</div>
		</div>
		<div>
			<div class="card border h-100 border-primary ">
				<div class="card-body">
					<div class="card-title">
						<span>사용 설명서</span>			
					</div>
					<span>
						원하는 명함 사진을 업로드 하여 전송하면
						<br />
						<br />
						AI가 글자를 인식하여 양식에 맞춰서 명함의
						<br />
						내용을 작성해줍니다
						<br />
						<br />
						다른 내용이 있거나 수정할 부분이 있다면 클릭 후 수정이 가능합니다
					</span>
				</div>
			</div>
		
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(
			function() {
				var temp;
				$('#cardImg').on('change', function(e) {
					temp = e.target.files[0]

					$("#mybtn33").on("click", function() {
						
						var lod = `<div class="spinner-border text-primary" role="status">
									<span class="visually-hidden">Loading...</span>
									</div>`
						if(temp != null){
							$("#lod").html(lod);
							cardSet();
						}		
					});
				});

				function cardSet() {
					var formData = new FormData();
					formData.append('cardImg', temp);

					$.ajax({
						url : 'http://127.0.0.1:5000/card.ajax',
						type : 'POST',
						data : formData,
						beforeSend : function(xhr) {
							xhr.setRequestHeader("${_csrf.headerName}",
									"${_csrf.token}");
						},
						contentType : false,
						processData : false,
						success : function(response) {
							$("#lod").html("");
							$("#bdControl").removeClass('border-primary')
							$("#bdControl").addClass('border-success border-4')
							
							var name = response.osUserNm;
							var coName = response.osCoNm;
							var tel = response.osTel;
							var jbgd = response.osJbgdNm;
							var eml = response.osEml;
							var dept = response.osDeptNm;
							$("#osUserNm").val(name);
							$("#osCoNm").val(coName);
							$("#osTel").val(tel);
							$("#osJbgdNm").val(jbgd);
							$("#osEml").val(eml);
							$("#osDeptNm").val(dept);

						}
					}).fail(function(){
						$("#lod").html("");
						$("#bdControl").removeClass('border-primary')
						$("#bdControl").addClass('border-danger border-4')
	                });
				}
			});
</script>