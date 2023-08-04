<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-6 pe-lg-2">
	<div class="card mb-3">
		<div class="card-header">
			<h5 class="mb-0">${userVO.userNm} ${userVO.jbgdNm}</h5>
		</div>
		<div class="card-body bg-light ">
			<form class="row g-3" >
				<div class="col-lg-6">
					<label class="form-label" for="userId">사원번호</label>
					<input class="form-control" id="userId" name="userId" type="text" value="${userVO.userId}" placeholder="자동생성" readonly>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="userNm">이름</label>
					<input class="form-control" id="userNm" name="userNm" type="text" value="${userVO.userNm}" required readonly>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="userEml">이메일</label>
					<input class="form-control" id="userEml" name="userEml" type="email" value="${userVO.userEml}" required readonly><span id="emailcheck"></span></input>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="userTelno">전화번호</label>
					<input class="form-control" id="userTelno" name="userTelno" type="text" placeholder="숫자만 입력" readonly required value="${userVO.userTelno}" maxlength='11' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="userZip">우편번호</label>
					<input class="form-control" id="userZip" name="userZip" type="text" value="${userVO.userZip}" readonly required>
				</div>
				<div class="col-lg-2">
					<label class="form-label" for="btnPostCode">&nbsp;</label>
					<input class="form-control btn btn-secondary me-1 mb-1" type="button" name="btnPostCode" id="btnPostCode" value="검색" />
				</div>
				<div class="col-lg-12">
					<label class="form-label" for="userAddr">주소</label>
					<input class="form-control" id="userAddr" name="userAddr" type="text" value="${userVO.userAddr}" readonly required />
				</div>
				<div class="col-lg-12">
					<label class="form-label" for="userDaddr">상세주소</label>
					<input class="form-control" id="userDaddr" name="userDaddr" type="text" readonly value="${userVO.userDaddr}" />
				</div>

				<div class="col-lg-6">
					<label class="form-label" for="coId">소속</label>
					<input class="form-control" id="coId" name="coId" type="text" value="${userVO.coId}" readonly readonly>
				</div>

				<div class="col-lg-6">
					<label class="form-label" for="deptNo">부서</label>
					<input class="form-select" id="deptNo" name="deptNo" type="text" value="${userVO.deptNm}" readonly required />
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="jbgdCd">직급</label>
					<input class="form-select" id="jbgdCd" name="jbgdCd" type="text" value="${userVO.jbgdNm}" readonly required/>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="jbtlCd">직책</label>
					<input class="form-select" id="jbtlCd" name="jbtlCd" type="text" value="${userVO.jbtlNm}" readonly required/>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="gndrMf">성별</label>
          	  <c:choose>
		          <c:when test="${userVO.gndrMf == 'M'}">
					<input class="form-select" id="gndrMf" name="gndrMf" value="남자" readonly required />
		          </c:when>
				  <c:otherwise>
					<input class="form-select" id="gndrMf" name="gndrMf" value="여자" readonly required />
		          </c:otherwise>
	          </c:choose>

				</div>

				<div class="col-lg-6">
					<label class="form-label" for="mtrscCd">병역이행</label>
					<input class="form-select" id="mtrscCd" name="mtrscCd" value="${userVO.mtrscCdNm}" readonly required>
				</div>

				<div class="col-lg-6">
					<label class="form-label" for="anslry">연봉</label>
					<input class="form-control" id="anslry" name="anslry" type="number" value="${userVO.anslry}" readonly required>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="anslryKo"> &nbsp; </label>
					<div class="fs-0" id="anslryKo"></div>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="bankNm">은행</label>
					<input class="form-control" id="bankNm" name="bankNm" type="text" value="${userVO.bankNm}" readonly required>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="actNo">계좌번호</label>
					<input class="form-control" id="actNo" name="actNo" type="" value="${userVO.actNo}" readonly required>
				</div>


				<div class="col-12 d-flex justify-content-end">
					<input type="button" class="btn btn-primary me-2 mb-2" onClick="location.href='/admin/account/update/${userVO.coId}/${userVO.userId}'" value="수정" />
					<input type="button" class="btn btn-secondary me-2 mb-2" onClick="location.href='/admin/account/list'" value="목록" />
				</div>
			</form>
		</div>
	</div>
</div>

