<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="${fit.title}" var="title"/>
<c:set value="${fitList}" var="fitList"/>
<div class="card">
	<div class="card-header">
		<div class="d-flex justify-content-between">
			<h5 class="modal-title" id="fit-title">적합도 추가하기</h5>
		</div>
		<hr/>
		<div class="d-flex justify-content-between align-item-center">
			<h4>${title}</h4>
			<div>
				<select class="form-control sel-dept-no">
					<option value="1">인사과</option>
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
		<div id="condition">
			<div>
				<c:if test="${fitList.get(0).aiCrtfctNo!=null}">
					<c:forEach var="item" items="${fitList}" varStatus="stat">
						<input type="checkbox" class="crtfct" data-nm="${item.crtfctNm}" value="${item.aiCrtfctNo}"> ${item.crtfctNm}
						<br/>
					</c:forEach>
				</c:if>
			</div>
			
			<div>
				<c:if test="${fitList.get(0).qnsinfoNo!=null}">
					<c:forEach var="item" items="${fitList}" varStatus="stat">
						<input type="checkbox" class="qnsinfo" data-nm="${item.skillNm}" value="${item.qnsinfoNo}"> ${item.skillNm}
						<br/>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
		<div class="card-footer">
		<div class="d-flex justify-content-end">
			<button id="add-data" class="btn btn-outline-secondary border-less btn-sm">저장</button>
			<button id="cancle" class="btn btn-outline-secondary border-less btn-sm">취소</button>
		</div>
	</div>
</div>

<script type="text/javascript">

    $('.sel-dept-no').on('change',function(){
        const deptNo = $(this).val();
        var html = "";
        
        $.ajax({
            url:'/goodness/condition',
            type:'get',
            data:{
                deptNo:deptNo,
                condition:${fit.condition}
            },
            success:(res)=>{
            	if(res.length==0) $("#condition").html("맞는 자격증 혹은 기술이 없습니다");
                res.forEach((value, index, array) => {
                	if(value.aiCrtfctNo) {
                		html += `
                			<div>
                				<input type="checkbox" class="crtfct" value="`+value.aiCrtfctNo+`" data-nm="`+value.crtfctNm+`">
                				`+ value.crtfctNm +`
                			</div>
                			`;
                	}
                	else if(value.qnsinfoNo) {
                		html += `<input type="checkbox" class="qnsinfo" value="`+value.qnsinfoNo+`" data-nm="`+value.skillNm+`">`+ value.skillNm;
                	}
                    $("#condition").html(html);
                });
            },
        });
    });
    
    $("#cancle").on('click',()=>{
    	$("#fit-modal").modal('hide');
    });
    
    function processData(classSelector, outputId, className){
        var html = `<div class="d-flex">`;
        $(classSelector).each(function(idx){
            html += `<div class="`+className+`" data-value="`+$(this).val()+`">`+$(this).data('nm')+`&nbsp;&nbsp;</div>`;
            if((idx + 1) % 3 == 0) html += `</div><div class="d-flex">`;
            if($(idx == classSelector).length) html += `</div>`;
        });
        $(outputId).html(html);
    }

    $('#add-data').on('click',()=>{
    	const aiCrtfctNo = `${fitList.get(0).aiCrtfctNo}`;
    	const qnsinfoNo = `${fitList.get(0).qnsinfoNo}`;
        if(aiCrtfctNo) processData('.crtfct:checked', '#crtfct','crtfcList');
        if(qnsinfoNo) processData('.qnsinfo:checked', '#qnsinfo','skillList');
        $('#fit-modal').modal('hide');
    });
</script>