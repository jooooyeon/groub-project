<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- detail!!! -->
<%-- ${data.userId } --%>
<%-- ${data} --%>
<%-- ${comment } --%>
<div class="card mb-3">
	<div class="card-body">
		<h5 class="card-title">공지사항</h5>
		<div class="d-grid gap-3">
			<h3 class=" align-self-center bg-white font-size:large bottom-aligned" id="detailModeHeaderAndTitle" style="margin: 20px;">
			<input id="pstNo" type="hidden" value="${data.pstNo}" />
			<input id="userId" type="hidden" value="${data.userId}" />
			<div>[${data.headerAsKor}] ${data.pstTtl}</div>
			</h3>
			<div align="right" style="margin: px; margin-left: 40px; ">${data.userNm}  ${data.cstCdNm}  <fmt:formatDate value="${data.mdfcnDt}" pattern="yyyy-MM-dd HH:mm" /></div>
			<h4 class="p-2 white" style="margin-left: 40px;">${data.pstCn}</h4>
			<c:if test="${data.bbsAtchVO[0].fileExtn!=null}">
				<div class="p-2 white border " id="myDiv">
					<p>첨부파일</p>
					<c:forEach var="vo" items="${data.bbsAtchVO}" varStatus="stat">
						<c:if test="${vo.fileExtn=='image/jpeg' or vo.fileExtn=='image/png'}">
						    <img src="/resources/bbsUpload${vo.filePath}" style="width: 270px;" />
						</c:if>
						<c:if test="${vo.fileExtn!='image/jpeg' and vo.fileExtn!='image/png'}">
							<a href="/download?filename=${vo.filePath}&sort=bbs" class="d-inline-flex align-items-center border rounded-pill px-3 py-1 me-2 mt-2 inbox-link">
								<span class="ms-2">${vo.fileNm}</span>
							</a>
						</c:if>
					</c:forEach>
				</div>
			</c:if>
		</div>
		<!-- 버튼들 -->
			<div class="d-flex justify-content-end mb-2 py-5 pt-3 pb-0">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<button id="edit" class="btn btn-primary me-1 mb-1 " type="button">수정</button>
					<!-- 게시글삭제 모달 시작-->
					<button id="btnDelete" class="btn btn-danger me-1 mb-1 " type="button" data-bs-toggle="modal" data-bs-target="#scrollinglongcontent" >삭제</button>
				</sec:authorize>
				<a href="/notice/list" class="btn btn-secondary me-1 mb-1" type="button">목록</a>
			</div>
		<div class="modal fade" id="scrollinglongcontent" data-keyboard="false" tabindex="-1" aria-labelledby="scrollinglongcontentLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
			    	<div class="modal-header">
			        	<h5 class="modal-title" id="scrollinglongcontentLabel">공지사항</h5>
			        	<button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
			     	</div>
					<div class="d-flex text-center">
						<div class="modal-body modal-dialog modal-dialog-scrollable my-3 align-self-center">삭제하시겠습니까?	</div>
			      	</div>
			      	<div class="modal-footer">
			       		<button class="btn btn-primary" type="button" id="btnDeleteConfirm" value="true">확인</button>
			        	<button class="btn btn-secondary" type="button" data-bs-dismiss="modal">취소</button>
			      	</div>
				</div>
			</div>
		</div>
	</div>
</div>
		<!-- 게시글 삭제 모달 끝-->
		

<script type="text/javascript">
var userName = '<%= request.getUserPrincipal().getName() %>'
window.onload  = function() {
<%-- 	userName = '<%= request.getUserPrincipal().getName() %>' --%>
	var writer = '${data.userId}';
// 	console.log("접속자~~~",userName);
// 	console.log("게시글 작성자~~~~",writer);
	
// 	var commentUserId = '${co.userId}';
// 	console.log("댓글 작성자~~~~",commentUserId);
	
	if(userName != writer){
		console.log("접속자와 작성자는 다른사람!")
		$("#btnDelete").css('display', 'none');
		$("#edit").css('display', 'none');
		
	}
	if(userName == writer){
		//console.log("접속자와 작성자는 같은사람!")
		
	}
	
};



$("#edit").click(function() {
    // update 컨트롤러로 이동
    window.location.href = "/notice/update?pstNo=" + ${data.pstNo};
});



//게시글 삭제
$("#btnDeleteConfirm").click(function(){
	console.log("삭제버튼");
	
	var pstNo = ${data.pstNo};
	//console.log(pstNo);
	
	var data = {"pstNo":pstNo}; 
	console.log(JSON.stringify(data))
	
	//var btnDel = confirm('삭제하시겠습니까?');
	var btnDel = $("#btnDeleteConfirm").val();
	console.log(btnDel);
	
	var deleteModal = $("#deleteModal");
	
	if(btnDel=='true'){
		console.log("true!!!")
		$.ajax({
            url: "/notice/delete",
            contentType: "application/json;charset:utf-8",
            data: JSON.stringify(data),
            type: "post",
            dataType: "text",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
            success: function(result){
            	deleteModal.show();
                location.href="/notice/list";
            },
            error: function(xhr, status, error){
                console.log("에러 발생:", error);
            }
        });
	}
});

//댓글작성
// $("#cmntBtn").click(function() {
// 	console.log("댓글올려랏!");
// 	var cmntCn = $("#cmntCn").val();
// 	  //console.log("댓글내용! : "+cmntCn);
	
// 	//console.log(userName);

// 	var pstNo = ${data.pstNo};
// 	  //console.log("글번호! " +pstNo );

// 	var data = {"cmntCn":cmntCn,"userId":userName,"pstNo":pstNo}
// 	//console.log(data);
	  
// 	  $.ajax({
// 		 url:"/community/board/commentRegister" ,
// 		 contentType:"application/json;charset:utf-8",
// 		 data:JSON.stringify(data),
// 		 type:"post",
// 		 dataType:"text",
// 		 beforeSend: function(xhr) {
//              xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
//          },
//          success:function(result){
//         	 $("#cmntCn").val("");
//         	 //alert("댓글 작성 성공");
//         	 reloadDivArea();
//          },
//          error:function(xhr, status, error){
//              console.log("에러 발생:", error);
//          }

// 	  });
	  
	  
// 	});
	
// //대댓글달기 시작/////////////////////////////////
// $(".commentSaveBtn").click(function() {
// 	rereply(this);
// });
// //대댓글달기 끝/////////////////////////////////	



// //댓글 삭제
// $(document).on("click", ".commentDelBtn", function() {
// 	var pstNo = ${data.pstNo};
// 	console.log("글번호", pstNo);
//     console.log("댓글 삭제 버튼이 클릭되었습니다.");
//     var cmntNo = $(this).data("cmnt-no");
//     console.log("댓글 번호:", cmntNo);
    
//     var data = {"delrNm":userName,"cmntNo":cmntNo}; 
//     console.log(JSON.stringify(data))
    
//     $('#commentDelBtnConfirm').click(function(){
//         var commentDelBtnConfirm = $("#commentDelBtnConfirm").val();
//         //console.log(commentDelBtnConfirm); //true
//         //var deleteModal = $("#deleteModal");
//         //commentDelBtn.hide();
//         if(commentDelBtnConfirm=='true'){
//             console.log("true!!!")
//             $.ajax({
//                 url: "/community/board/deleteCommentPost",
//                 contentType: "application/json;charset:utf-8",
//                 data: JSON.stringify(data),
//                 type: "post",
//                 dataType: "text",
//                 beforeSend: function(xhr) {
//                     xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
//                 },
//                 success: function(result){
                    
//                     location.href="/community/board/detail?pstNo="+pstNo;
                    
//                 },
//                 error: function(xhr, status, error){
//                     console.log("에러 발생:", error);
//                 }
//             });
//         }
//     });
// });



// //대댓글 입력 창 나타내기
// $(document).on("click", "#comment", function() {
//     console.log("글 내용클릭!!!");
//     var cmntNo = $(this).data("cmntno");
//     console.log("댓글 번호:", cmntNo);
    
//     if($("#commentInputArea_" + cmntNo).is(":visible")){	
// 	    $("#commentInputArea_" + cmntNo).slideUp();
//     }else{
// 	    $("#commentInputArea_" + cmntNo).slideDown();
//     }
// });


// //댓글 수정 버튼
// $(document).on("click", "#commentModModal", function() {
// 	console.log("댓글수정할꼬얌!!")
// 	var pstNo = ${data.pstNo};
// 	//console.log("글번호", pstNo);
// 	var cmntNo = $(this).data("cmnt-no");
//     //console.log("댓글 번호:", cmntNo);
//     let cmntCn = $(this).data("cmnt-cn");
//     //console.log("댓글 내용 : " + cmntCn);
    
   
//     //댓글 수정 모달에서 취소버튼 누르면 입력 값 비우기
//  	$("#commentModModalCancle").click(function(){
//  		$("#writeModComment").val("");
//  	});
    
    
    
//     //댓글 수정 확인 버튼
//     $("#commentModModalConfirm").click(function(){
//     	console.log("댓글 수정 확인 !!!")
//     	let  writeModComment = $("#writeModComment").val();
    	
//     	console.log(writeModComment);
    	
//     	var data = {"userId":userName,"cmntNo":cmntNo,"pstNo":pstNo,"cmntCn":writeModComment}; 
//     	   console.log("수정댓글",JSON.stringify(data));
    	
//     	$.ajax({
//     		url:"/community/board/commentModify",
//     		contentType:"application/json;charset:utf-8",
//     		data:JSON.stringify(data),
//     		type:"post",
//     		dataType:"text",
//     		beforeSend: function(xhr) {
//                 xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
//             },
//             success:function(result){
//             	//alert("댓글 수정 성공!!");
            	
// 			    $('#commentModModal1').modal('hide');
// 			    reloadDivArea();
//             },
//             error:function(xhr, status, error){
//                 console.log("에러 발생:", error);
//             }
    		
    		
//     	});//ajax끝
    	

	    
//     })
    
    
// });



// //재응답
// function rereply(obj){
// 	//reloadDivArea();
// 	//data-cmnt-no="22"
// 	//this : 저장버튼들 중에서 방금 클릭한 바로 그 버튼
// 	let cmntNo = $(obj).data("cmntNo");
// 	//console.log("cmntNo : " + cmntNo);
	
// 	let cmntLv = $(obj).data("cmntLv");
// 	//console.log("cmntLv : " + cmntLv);
	
// 	let cmntCn = $(obj).prev().val();
// 	//console.log("cmntCn : " + cmntCn);
	
// 	let pstNo = $(obj).data("pstNo");
// 	//console.log("pstNo : " + pstNo);
	
// 	var data = {"upCmntNo":cmntNo,"cmntLv":cmntLv,"cmntCn":cmntCn,"pstNo":pstNo,"userId":userName,}
// 	console.log("commentSaveBtn",data);
// 	$.ajax({
// 		url:"/community/board/commentInComment" ,
// 		 contentType:"application/json;charset:utf-8",
// 		 data:JSON.stringify(data),
// 		 type:"post",
// 		 dataType:"text",
// 		 beforeSend: function(xhr) {
//              xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
//          },
//          success:function(result){
//         	 $("#cmntCn").val("");
//         	 //alert("babo2");
//         	 reloadDivArea();
//         	 //window.location.reload();
        	 
//          },
//          error:function(xhr, status, error){
//              console.log("에러 발생:", error);
//          }

		
//	});
// 	//location.href="/community/board/detail?pstNo="+pstNo;
	
//}




	
</script>