<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
	<div class="card-body">
		<div class="row d-flex justify-content-center">

			<div class="col-md-5 mb-4 ">
				<div class="card border h-100 border-primary ">
					<div class="card-body">
						<div class="card-title">
							<input class="form-control-plaintext text-left" type="text"
								placeholder="회사명" id="osCoNm" name="osCoNm" value="대덕인재개발원" />
						</div>
						<div class="d-flex">
							<div class="me-2">
								<input class="form-control-plaintext pb-0" type="text"
									placeholder="이름" id="osUserNm" name="osUserNm" value="전아현" />
								<label class="form-label mt-0" for="osUserNm"> <input
									class="form-control-plaintext pt-0" type="text"
									placeholder="직급명" id="osJbgdNm" name="osJbgdNm" value="대리" />
								</label>
							</div>
							<div class="border-start border-3 ps-3">
								<div class="d-flex">
									<div class="align-self-center me-2">Dept:</div>
									<input class="form-control-plaintext me-auto" type="text"
										placeholder="부서명" id="osJbgdNm" name="osJbgdNm"
										value="경영개발지원팀" />
								</div>
								<div class="d-flex">
									<div class="align-self-center me-2">Email:</div>
									<input class="form-control-plaintext" type="email"
										placeholder="이메일" id="osEml" name="osEml"
										value="ahkim333@ddit.or.kr" />
								</div>
								<div class="d-flex">
									<div class="align-self-center me-2">Mobile:</div>
									<input class="form-control-plaintext" type="text"
										placeholder="핸드폰번호" id="osTel" name="osTel"
										value="010-1234-1234" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-5 mb-4 ">
				<div class="card border h-100 border-primary ">
					<div class="card-body">
						<div class="card-title">
							<input class="form-control-plaintext text-left" type="text"
								placeholder="회사명" id="osCoNm" name="osCoNm" value="대덕인재개발원" />
						</div>
						<div class="d-flex">
							<div class="me-4" >
								<div class="border border-3 " style="width: 120px; height: 150px" >
									사진
								</div>
							</div>
							<div class="border-start border-3 ps-3">
								<div class="d-flex">
									<input class="form-control-plaintext" style="width: 30%" type="text"
										placeholder="직급명" id="osJbgdNm" name="osJbgdNm" value="대리" />
										
									<input class="form-control-plaintext" type="text"
										placeholder="이름" id="osUserNm" name="osUserNm" value="전아현" /> 
								</div>
								<div class="d-flex">
									<div class="align-self-center me-2">Dept:</div>
									<input class="form-control-plaintext me-auto" type="text"
										placeholder="부서명" id="osJbgdNm" name="osJbgdNm"
										value="경영개발지원팀" />
								</div>
								<div class="d-flex">
									<div class="align-self-center me-2">Email:</div>
									<input class="form-control-plaintext" type="email"
										placeholder="이메일" id="osEml" name="osEml"
										value="ahkim333@ddit.or.kr" />
								</div>
								<div class="d-flex">
									<div class="align-self-center me-2">Mobile:</div>
									<input class="form-control-plaintext" type="text"
										placeholder="핸드폰번호" id="osTel" name="osTel"
										value="010-1234-1234" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>