<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<div class="col-lg-8 pe-lg-2">
	<div class="card mb-3">
		<div class="card-header">
			<h5 class="mb-0">계정 생성</h5>
		</div>
		<div class="card-body bg-light ">
			<form class="row g-3" modelAttribute="userRegisterVO" action="/admin/account/create" method="post">
				<div class="col-lg-6">
					<label class="form-label" for="jncmpYmd">입사일</label>
					<input class="form-control" id="jncmpYmd" name="jncmpYmd" type="date" required>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="userId">사원번호</label>
					<input class="form-control" id="userId" name="userId" type="text" placeholder="자동생성" readonly>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="userNm">이름</label>
					<input class="form-control" id="userNm" name="userNm" type="text" value="" required>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="userEml">이메일</label>
					<input class="form-control" id="userEml" name="userEml" type="email" value="" required><span id="emailcheck"></span></input>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="userTelno">전화번호</label>
					<input class="form-control" id="userTelno" name="userTelno" type="text" placeholder="숫자만 입력" required value="" maxlength='11' oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="brthYmd">생년월일</label>
					<input class="form-control" id="brthYmd" name="brthYmd" type="date" value="2000-01-01" required>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="userZip">우편번호</label>
					<input class="form-control" id="userZip" name="userZip" type="text" value="" required>
				</div>
				<div class="col-lg-2">
					<label class="form-label" for="btnPostCode">&nbsp;</label>
					<input class="form-control btn btn-secondary me-1 mb-1" type="button" name="btnPostCode" id="btnPostCode" value="검색" />
				</div>
				<div class="col-lg-12">
					<label class="form-label" for="userAddr">주소</label>
					<input class="form-control" id="userAddr" name="userAddr" type="text" value="" required>
				</div>
				<div class="col-lg-12">
					<label class="form-label" for="userDaddr">상세주소</label>
					<input class="form-control" id="userDaddr" name="userDaddr" type="text" value="">
				</div>

				<div class="col-lg-6">
					<label class="form-label" for="coId">소속</label>
					<input class="form-control" id="coId" name="coId" type="text" value="<sec:authentication property="principal.userVO.coId"/>" readonly>
				</div>

				<div class="col-lg-6">
					<label class="form-label" for="deptNo">부서</label>
					<select class="form-select" id="deptNo" name="deptNo" required>
							<option value="">부서 선택</option>
						<c:forEach var="data" items="${deptList}" varStatus="stat">
							<option value="${data.deptNo}">${data.deptNm}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="jbgdCd">직급</label>
					<select class="form-select" id="jbgdCd" name="jbgdCd" required>
							<option value="">직급 선택</option>
						<c:forEach var="data" items="${jgList}" varStatus="stat">
							<option value="${data.cstCd}">${data.cstCdNm}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="jbtlCd">직책</label>
					<select class="form-select" id="jbtlCd" name="jbtlCd" required>
							<option value="">직책 선택</option>
						<c:forEach var="data" items="${jtList}" varStatus="stat">
							<option value="${data.cstCd}">${data.cstCdNm}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="gndrMf">성별</label>
					<select class="form-select" id="gndrMf" name="gndrMf" required>
						<option value="">성별 선택</option>
						<option value="M">남자</option>
						<option value="F">여자</option>
					</select>
				</div>

				<div class="col-lg-6">
					<label class="form-label" for="mtrscCd">병역이행</label>
					<select class="form-select" id="mtrscCd" name="mtrscCd" required>
							<option value="">병역이행 선택</option>
						<c:forEach var="data" items="${mtrscList}" varStatus="stat">
							<option value="${data.mngCd}">${data.mngCdNm1}</option>
						</c:forEach>
					</select>
				</div>

				<div class="col-lg-6">
					<label class="form-label" for="anslry">연봉</label>
					<input class="form-control" id="anslry" name="anslry" type="number" value="" required>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="anslryKo"> &nbsp; </label>
					<div class="fs-0" id="anslryKo"></div>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="bankNm">은행</label>
					<input class="form-control" id="bankNm" name="bankNm" type="text" value="" required>
				</div>
				<div class="col-lg-6">
					<label class="form-label" for="actNo">계좌번호</label>
					<input class="form-control" id="actNo" name="actNo" type="" required>
				</div>


				<div class="col-12 d-flex justify-content-end">
					<button class="btn btn-primary" type="submit">생성</button>
				</div>
				<sec:csrfInput />
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		//다음 우편번호 검색
		$("#btnPostCode").on("click", function() {
			new daum.Postcode({
				oncomplete : function(data) {
					/* .을 특수하게 인식하기 때문에, 문자로 인식하라고 역슬래시 두개 붙여주었음 */
					/* form path 이외에도 별도의 id를 부여해서 사용하는 방식도 가능하다 - path가 주로 취급하는것은 name이기 때문에 영향범위안인가봄 */
					$("#userZip").val(data.zonecode);
					$("#userAddr").val(data.address);
					$("#userDaddr").val(data.buildingName);
				}
			}).open();
		});
	$("#userEml").on('keyup',emailcheck);

	$("#anslry").on('change keyup',convertToKoreanNumber);



	});
</script>


<script>
	let dateInput = document.getElementById('jncmpYmd');
	dateInput.addEventListener('change', function() {
		var selectedDate = dateInput.value;
		var numericString = selectedDate.replace(/-/g, '');
		var yearMonth = numericString.substring(0, 6);
		var csrfToken = $("input[name='_csrf']").val();

		let coId = document.getElementById('coId').value;
		let search = coId + "_" + yearMonth+"%";
		let searchCondition = {"search":search, "coId":coId, "yearMonth":yearMonth}

		// 알림 표시
		$.ajax({
			url:"/admin/account/maxUserId",
			contentType:"application/json;charset=utf-8",
			data:searchCondition,
			type:"post",
			headers: {
	            'Content-Type': 'application/x-www-form-urlencoded',
	            'X-CSRF-TOKEN': csrfToken
	        },
			success:function(result){
				document.getElementById('userId').value = result;
			}
		});
	});


	function emailcheck(){
	    var email = $("#userEml").val();
	    var sendData = {"email":email}
		var csrfToken = $("input[name='_csrf']").val();
	    $.ajax({
	        url : '/admin/account/checkEmail',
	        data : sendData,
	        method : 'post',
			headers: {
	            'Content-Type': 'application/x-www-form-urlencoded',
	            'X-CSRF-TOKEN': csrfToken
	        },
	        success : function(resp){
	            if(resp=='fail'){
	                $('#emailcheck').css('color','red')
	                $('#emailcheck').html("존재하는 이메일입니다.")
	                flag=false;

	            }else{
	                $('#emailcheck').css('color','blue')
	                $('#emailcheck').html("사용할 수 있는 이메일입니다.")
	                flag=true;
	            }}
	    })
	}


	function convertToKoreanNumber() {
	    var num = $("#anslry").val();
		var result = '';
		var digits = [ '영', '일', '이', '삼', '사', '오', '육', '칠', '팔', '구' ];
		var units = [ '', '십', '백', '천', '만', '십만', '백만', '천만', '억', '십억',
				'백억', '천억', '조', '십조', '백조', '천조' ];

		var numStr = num.toString(); // 문자열로 변환
		var numLen = numStr.length; // 문자열의 길이

		for (var i = 0; i < numLen; i++) {
			var digit = parseInt(numStr.charAt(i)); // i번째 자릿수 숫자
			var unit = units[numLen - i - 1]; // i번째 자릿수 단위

			// 일의 자리인 경우에는 숫자를 그대로 한글로 변환
			if (i === numLen - 1 && digit === 1 && numLen !== 1) {
				result += '일';
			} else if (digit !== 0) { // 일의 자리가 아니거나 숫자가 0이 아닐 경우
				result += digits[digit] + unit;
			} else if (i === numLen - 5) { // 십만 단위에서는 '만'을 붙이지 않습니다.
				result += '만';
			}
		}
		$("#anslryKo").text(result);
	}
</script>