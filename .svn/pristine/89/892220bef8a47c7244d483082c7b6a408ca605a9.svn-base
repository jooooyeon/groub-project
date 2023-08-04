<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script type="text/javascript" src="/resources/falcon/src/js/jquery-3.6.4.min.js"></script>

<%-- update!! ${data} --%>

<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.userVO" var="userVO" />
	<%-- 	<p>${userVO}</p> --%>
</sec:authorize>

<div class="container">
	<div class="row">
		<div class="card mb-3">
			<div class="card-header ">
				<div class="row flex-between-end">
					<div class="col-auto align-self-center">
						<h3 class="mb-0">익명게시판 수정</h3>
						<p class="mb-0 pt-1 mt-2 mb-0"></p>
					</div>
				</div>
			</div>
		<form action="/community/anonyboard/update" method="post" enctype="multipart/form-data">
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    		<input type="hidden" name="pstNo" id="pstNo" value="${data.pstNo}" />
    		<input type="hidden" name="inqCnt" id="inqCnt" value="${data.inqCnt}" />
			<input type="hidden" name="coId" value="${data.coId}" /> 
			<input type="hidden" name="userId" value="${userVO.userId}" /> 
			<input type="hidden" name="pstHd" value="${data.pstHd}" /> 
			<!-- 말머리 시작 -->
			<div class="form-floating" style="width: 18%; float: left; margin-right: 10px;">
				<select class="form-select" name="pstHd" id=pstHd aria-label="Floating label select example" disabled>
					<option>${data.headerAsKor }</option>
				</select> <label for="floatingSelect">말머리</label>
			</div>
			<!-- 말머리 끝 -->
			<!-- 제목 시작 -->
			<div class="form-floating mb-3" style="width: 80%; float: left">
				<input class="form-control" name="pstTtl" id="floatingInput" type="title" placeholder="제목을 입력해주세요" value="${data.pstTtl}" required /> 
				<label for="floatingInput">제목</label>
			</div>
			<div style="clear: both;"></div>
			<!-- 제목 끝 -->
			<!-- 에디터 시작 -->
			<div>
				<textarea class="tinymce d-none" name="pstCn" data-tinymce="data-tinymce" placeholder="내용을 입력해주세요" required>${data.pstCn}</textarea>
			</div>
			<!-- 에디터 끝 -->
			<!-- 첨부파일 시작 -->
			<div class="mb-3">
				<label class="form-label" for="formFileMultiple"></label>
					<c:if test="${data.bbsAtchVO[0].fileNm != null }">
						<c:forEach var="vo" items="${data.bbsAtchVO}" varStatus="stat">
							<div class="file-input">
								<span class="glyphicon glyphicon-camera" aria-hidden="true"></span>
								<span> ${vo.fileNm} </span> 
<%-- 								<span id="exist">${vo.fileExist} </span>  --%>
									<a href='#' class="clsDelete" data-bbs-fl-no="${vo.bbsFlNo}" name='file-delete'>삭제</a>
							</div>
						</c:forEach>
					</c:if>
				<input class="form-control" id="pictures" type="file" multiple="multiple" name="attachFiles" />
			</div>
			<!-- 첨부파일 끝 -->
			<div style="text-align: center;" class="mb-3">
				<button class="btn btn-primary" type="submit">저장</button>
				<a href="#" class="btn btn-secondary" id="btnCancel" type="button">취소</a>
			</div>
			<sec:csrfInput/>
		</form>	
	</div>
</div>
</div>
<!-- 수정탭에서 첨부파일 삭제버튼을 누르면  -->


<script type="text/javascript">
	$(document).ready(function() {
		$(".clsDelete").on("click",function(){
			let bbsFlNo = $(this).data("bbsFlNo");
			$(this).parent().remove();
			console.log("bbsFlNo : " + bbsFlNo);
			
			let data = {"fileExist":"N","bbsFlNo":bbsFlNo};
			console.log("data.. : " + JSON.stringify(data));
			
			$.ajax({
				url:"/community/anonyboard/updateFileExist",
				contentType:"application/json;charset=utf-8",
				data:JSON.stringify(data),
				type:"post",
				dataType:"text",
				beforeSend: function(xhr) {
	                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
	            },
				success:function(result){
					console.log("result : " + result);					
				}
			});
		});
		
		//취소
		$("#btnCancel").on("click",function(){
			let pstNo = "${data.pstNo}";
			console.log("pstNo : " + pstNo);
			
			let data = {"fileExist":"Y","pstNo":pstNo};
			console.log("data : " + JSON.stringify(data));
			
			$.ajax({
				url:"/community/anonyboard/updateFileExistCancel",
				contentType:"application/json;charset=utf-8",
				data:JSON.stringify(data),
				type:"post",
				dataType:"text",
				beforeSend: function(xhr) {
	                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
	            },
				success:function(result){
					console.log("result : " + result);	
					location.href="/community/anonyboard/detail?pstNo="+pstNo;
				}
			});
		});
	});
	
	

// 	function deleteFile(obj) {
// 		var exist =$("#exist");
// 		exist.text('N');
// 		console.log(exist.text());
// 		obj.parent().remove();
// 	}

</script>
