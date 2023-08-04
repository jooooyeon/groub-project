<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<meta charset="UTF-8">

<div class="card mb-3">
    <div class="card-header">
        <div class="min-vh-50">
            <form>
            	<div style="float: left; width: 100px; padding:10px " >
            	<label>메뉴를 선택하세요.</label>
            	<img src="/resources/image/yum.png" width="100%" />
            	</div>
                <div style="display: flex;">
                    <select class="form-select" id="yy_eat" onchange="yyEatPrint(this.value);" style="width:300px; margin-right: 10px;" >
                        <option selected="">그제 먹은 메뉴를 선택하세요.</option>
                        <option value="M00">백반</option>
                        <option value="M01">냉면</option>
                        <option value="M02">닭갈비</option>
                        <option value="M03">된장찌개</option>
                        <option value="M04">짜장면</option>
                        <option value="M05">짬뽕</option>
                        <option value="M06">순대국밥</option>
                        <option value="M07">파스타</option>
                        <option value="M08">쌀국수</option>
                        <option value="M09">케밥</option>
                        <option value="M10">설렁탕</option>
                        <option value="M11">돈까스</option>
                        <option value="M12">갈비탕</option>
                        <option value="M13">부대찌개</option>
                        <option value="M14">돼지불고기</option>
                        <option value="M15">칼국수</option>
                        <option value="M16">김밥</option>
                        <option value="M17">마라탕</option>
                        <option value="M18">생선구이</option>
                        <option value="M19">햄버거</option>
                    </select>
                    <select class="form-select" id="y_eat" onchange="yEatPrint(this.value);" style="width:300px;" >
                        <option selected="">어제 먹은 메뉴를 선택하세요.</option>
                        <option value="M00">백반</option>
                        <option value="M01">냉면</option>
                        <option value="M02">닭갈비</option>
                        <option value="M03">된장찌개</option>
                        <option value="M04">짜장면</option>
                        <option value="M05">짬뽕</option>
                        <option value="M06">순대국밥</option>
                        <option value="M07">파스타</option>
                        <option value="M08">쌀국수</option>
                        <option value="M09">케밥</option>
                        <option value="M10">설렁탕</option>
                        <option value="M11">돈까스</option>
                        <option value="M12">갈비탕</option>
                        <option value="M13">부대찌개</option>
                        <option value="M14">돼지불고기</option>
                        <option value="M15">칼국수</option>
                        <option value="M16">김밥</option>
                        <option value="M17">마라탕</option>
                        <option value="M18">생선구이</option>
                        <option value="M19">햄버거</option>
                    </select>
                    <br/>
                </div>
                <br/>
            </form>
                <form id="dataGo" action="http://127.0.0.1:5000/menu" method="post" >
                	<input type="hidden" id="yyEatInput" name="yyEatInput" />
                	<input type="hidden" id="yEatInput" name="yEatInput" />
                <button class="btn btn-primary" type="button" onclick="gogo()" >오늘의 메뉴는?</button>
                <sec:csrfInput/>
                </form>
            <br/>
		<div class="mb-3">
			<label class="form-label">추천1</label>
			<input class="form-control" id="tEat1" type="text" placeholder="첫번째 추천 메뉴입니다." style="width:250px;" readonly /><br/>
			<label class="form-label">추천2</label>
			<input class="form-control" id="tEat2" type="text" placeholder="두번째 추천 메뉴입니다." style="width:250px;" readonly /><br/>
			<label class="form-label">추천3</label>
			<input class="form-control" id="tEat3" type="text" placeholder="세번째 추천 메뉴입니다." style="width:250px;" readonly />
		</div>
            
        </div>
    </div>
</div>

<script>
	var yyEatPrint = function(value){
// 		console.log("엊그제 메뉴: " + value);
		$("#yyEatInput").val(value);
	}
	var yEatPrint = function(value){
// 		console.log("어제 메뉴: " + value);
		$("#yEatInput").val(value);
	}
	
    function gogo() {
        var data = {
			yyEatInput: $("#yyEatInput").val(),
			yEatInput: $("#yEatInput").val()
		};        
//         console.log("data",data);
		
		// ajax를 이용해서 flask와 데이터 주고 받기
    	$.ajax({
    		// flask와 연결
    		url : 'http://127.0.0.1:5000/menu.ajax',  
    		type : "POST",
    		data : data,
    		dataType : "json",
    		success : function(resp) {
//     			console.log(resp);
				// json형태로 받아온 값을 하나씩 뽑아내기
    			$("#tEat1").val(resp.menu1);
    			$("#tEat2").val(resp.menu2);
    			$("#tEat3").val(resp.menu3);
    			
    		},
    		error : function() {
    			alert('메뉴를 선택해주세요.');
    		}
    	});  
        
        
      }

	
</script>