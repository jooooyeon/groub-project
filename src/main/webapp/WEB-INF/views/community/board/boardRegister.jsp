<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글등록</title>
<script type="text/javascript"></script>
</head>
<body>
<%--<p>${userVO}</p> --%>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.userVO" var="userVO" />
	</sec:authorize>
	
<div class="container">
	<div class="row">
		<div class="card mb-3">
			<div class="card-header ">
				<div class="row flex-between-end">
					<div class="col-auto align-self-center">
						<h3 class="mb-0">게시글 작성</h3>
						<p class="mb-0 pt-1 mt-2 mb-0"></p>
					</div>
				</div>
			</div>
			<form action="/community/board/register?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
				<input type="hidden" name="coId" value="${userVO.coId}" /> 
				<!-- 말머리 시작 -->
				<div class="form-floating" style="width: 18%; float: left; margin-right: 10px;">
					<select class="form-select" name="pstHd" id=pstHd aria-label="Floating label select example" >
						<c:forEach var="vo" items="${data}" varStatus="stat">
							<option value="${vo.cstCd}">${vo.cstCdNm}</option>
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
					<textarea class="tinymce d-none" name="pstCn" id="pstCn" data-tinymce="data-tinymce" placeholder="내용을 입력해주세요"  ></textarea>
				</div>
				<!-- 에디터 끝 -->
				<!-- 첨부파일 시작 -->
 				<div class="mb-3">
					<label class="form-label" for="formFileMultiple"></label>
				  	<input class="form-control"  id="pictures" type="file" multiple="multiple" name="attachFiles" />
				</div>
				<!-- 첨부파일 끝 -->
			
				<div style="text-align: center;" class="mb-3">
					<button class="btn btn-primary me-1 mb-1" type="submit">저장</button>
					<button onclick="location.href='/community/board/list'" class="btn btn-secondary me-1 mb-1" type="button">목록</button>
				</div>
				<div>
					<button type="button" onclick="autoWrite()">자동입력</button>
				</div>
				<sec:csrfInput/>
			</form>	
		   <!-- 글작성 div끝 -->
		</div>
	</div>
	</div>
</body>
</html>

<script>
function autoWrite(){
	console.log("자동입력!");
	//제목
	var floatingInput = $("#floatingInput");
	floatingInput.val("회식장소 추천해 주세요");
	
	var pstCn = tinyMCE.get("pstCn"); // 
	var content = "이번주 금요일에 회식을 할 예정입니다.<br>회사 주변 맛집을 추천해 주시면 감사하겠습니다!<br>조용하게 팀원들끼리 이야기하면서 먹을 수 있는 장소였으면 좋겠습니다<br>감사합니다!";
    pstCn.setContent(content); // 텍스트 에디터의 내용을 변경합니다.
}

</script>
