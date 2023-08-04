<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--<p>${userVO}</p> --%>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.userVO" var="userVO" />
	</sec:authorize>
	
	<div class="card mb-3">
		<div class="card-body">
			<h5 class="card-title pb-3">공지사항 작성</h5>
			<form name="notice-frm" action="/notice/register?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
				<input type="hidden" name="coId" value="${userVO.coId}" /> 
				<!-- 말머리 시작 -->
				<div class="form-floating" style="width: 18%; float: left; margin-right: 10px;">
					<select class="form-select" name="pstHd" id=pstHd aria-label="Floating label select example" >
						<c:forEach var="vo" items="${data}" varStatus="stat">
							<option value="${vo.cstCd}" data-cstnm='${vo.cstCdNm}'>${vo.cstCdNm}</option>
						</c:forEach>
					</select>
					<label for="floatingSelect">말머리</label>
				</div>
				<!-- 말머리 끝 -->
				<!-- 제목 시작 -->
				<div class="form-floating mb-3" style="width: 80%; float: left">
					<input class="form-control" name="pstTtl" id="floatingInput" type="title"	placeholder="제목을 입력해주세요" required />
					<label for="floatingInput">제목</label>
				</div>
				<div style="clear: both;"></div>
				<!-- 제목 끝 -->
				<!-- 에디터 시작 -->
				<div>
					<textarea class="tinymce d-none" name="pstCn" data-tinymce="data-tinymce" placeholder="내용을 입력해주세요" required ></textarea>
				</div>
				<!-- 에디터 끝 -->
				<!-- 첨부파일 시작 -->
 				<div class="mb-3">
					<label class="form-label" for="formFileMultiple"></label>
				  	<input class="form-control"  id="pictures" type="file" multiple="multiple" name="attachFiles" />
				</div>
				<!-- 첨부파일 끝 -->
			
				<div style="text-align: center;">
					<button class="btn btn-primary me-1 mb-1" id="notice-send" type="submit">저장</button>
					<button onclick="location.href='/notice/list'" class="btn btn-secondary me-1 mb-1" type="button">목록</button>
				</div>
				<sec:csrfInput/>
			</form>	
		   <!-- 글작성 div끝 -->
		</div>
	</div>

<script>
$('#notice-send').on('click',()=>{
	var cstCdNm = $('#pstHd option:selected').text();
	var coId = $(`input[name='coId']`).val();

	stomp.send('/pub/noticeAlarm', {}, JSON.stringify({
		cstCdNm: cstCdNm,
		sender: userId,
		userId: userId,
		coId:coId,
	}));
})
</script>
