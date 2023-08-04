<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- test123 -->
<nav class="navbar navbar-light navbar-vertical navbar-expand-xl">
	<script>
		var navbarStyle = localStorage.getItem("navbarStyle");
		if (navbarStyle && navbarStyle !== 'transparent') {
			document.querySelector('.navbar-vertical').classList
					.add(`navbar-${navbarStyle}`);
		}
	</script>
	<div class="d-flex align-items-center">
		<div class="toggle-icon-wrapper">
			<button class="btn navbar-toggler-humburger-icon navbar-vertical-toggle" ata-bs-toggle="tooltip" data-bs-placement="left" title="Toggle Navigation">
				<span class="navbar-toggle-icon">
					<span class="toggle-line"></span>
				</span>
			</button>
		</div>
		<!-- 로고 -->
		<a class="navbar-brand" href="/">
			<div class="d-flex align-items-center py-3">
				<img class="me-2" src="/resources/falcon/public/assets/img/icons/spot-illustrations/grouub.png" alt="" width="40" />
				<span class="font-Arial">Groub</span>
			</div>
		</a>
	</div>
	<!-- 좌측 메뉴 -->
	<div class="collapse navbar-collapse" id="navbarVerticalCollapse">
		<div class="navbar-vertical-content scrollbar">
			<ul class="navbar-nav flex-column mb-3" id="navbarVerticalNav">
				<li class="nav-item">
					 <a class="nav-link" href="/" role="button" >
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fa-house"></span>
							</span>
									<span class="nav-link-text ps-1">메인화면</span>
						</div>
					</a>
				<!-- 구분선 -->
				</li>
				<li class="nav-item">
					<!-- label-->
					<div class="row navbar-vertical-label-wrapper mt-3 mb-2">
						<div class="col-auto navbar-vertical-label">Groub</div>
						<div class="col ps-0">
							<hr class="mb-0 navbar-vertical-divider" />
						</div>
					</div>

				<!-- ///////////////// app 시작 ///////////////// -->
				<!-- ////////////////////////////////////// 근태관리 시작 //////////////////////////////////////-->
					<a class="nav-link dropdown-indicator" href="#attendance" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="attendance">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fa-briefcase"></span>
							</span>
							<span class="nav-link-text ps-1">근태관리</span>
						</div>
					</a>
					<ul class="nav collapse" id="attendance">
						<li class="nav-item">
							<a class="nav-link" href="/attendance/work">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">근무현황</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/attendance/attend">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">근태현황</span>
								</div>
							</a>
						</li>
					</ul>
				<!-- ////////////////////////////////////// 근태관리 끝 //////////////////////////////////////-->
				<!-- ////////////////////////////////////// 전자결재 시작 //////////////////////////////////////-->
					<a class="nav-link dropdown-indicator" href="#edsm" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="edsm">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fa-file-lines"></span>
							</span>
							<span class="nav-link-text ps-1">전자결재</span>
						</div>
					</a>
					<!-- 전자결재 하위 메뉴 -->
					<ul class="nav collapse" id="edsm">
					<li class="nav-item">
						<a class="nav-link dropdown-indicator" href="#drafting" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="drafting">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1" aria-hidden="true" focusable="false" data-prefix="fas" >기안</span>
								</div>
						</a>
					</li>
						<!-- 기안 하위 메뉴 -->
					<ul class="nav collapse" id="drafting">
						<li class="nav-item">
							<a class="nav-link" href="/draft/form">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">문서 양식</span>
							</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/draft/doc/temp">
									<div class="d-flex align-items-center">
										<span class="nav-link-text ps-1">임시 저장</span>
								</div>
							</a>
							</li>
					</ul>
					<li class="nav-item">
						<a class="nav-link dropdown-indicator" href="#docubox" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="docubox">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">문서함</span>
								</div>
						</a>
					</li>
					<!-- 문서함 하위 메뉴 -->
					<ul class="nav collapse" id="docubox">
						<li class="nav-item">
							<a class="nav-link" href="/draft/doc?category=during">
									<div class="d-flex align-items-center">
										<span class="nav-link-text ps-1">기안 문서</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/draft/doc?category=during">
									<div class="d-flex align-items-center">
										<span class="nav-link-text ps-1">회람 문서</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/draft/doc?category=during">
									<div class="d-flex align-items-center">
										<span class="nav-link-text ps-1">수신 문서</span>
								</div>
							</a>
						</li>
					</ul>
					<li class="nav-item">
						<a class="nav-link dropdown-indicator" href="#signoffon" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="signoffon">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">결재</span>
								</div>
						</a>
					</li>
						<ul class="nav collapse" id="signoffon">
							<li class="nav-item">
								<a class="nav-link" href="/draft/doc/atrz">
									<div class="d-flex align-items-center">
										<span class="nav-link-text ps-1">결재 문서</span>
									</div>
								</a>
							</li>
						</ul>
					</ul>
					<!-- ////////////////////////////////////// 전자결재 끝 //////////////////////////////////////-->
				<!-- ////////////////////////////////////// 메일 시작 //////////////////////////////////////-->
				<a class="nav-link" href="/mail/inbox" role="button">
					<div class="d-flex align-items-center"><span class="nav-link-icon"><span class="fas fa-envelope"></span></span><span class="nav-link-text ps-1" >메일</span></div>
				</a>
					<!-- ////////////////////////////////////// 메일 끝 //////////////////////////////////////-->
					<!-- ///////////////////////////공지사항 시작////////////////////////////// -->
					<a class="nav-link" href="/notice/list" role="button">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fa-volume-high"></span>
							</span>
							<span class="nav-link-text ps-1">공지사항</span>
						</div>
					</a>
					<!-- ///////////////////////////공지사항 끝////////////////////////////// -->
					<!-- //////////////////////커뮤니티 시작///////////////////////// -->
					<a class="nav-link dropdown-indicator" href="#community" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="community">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fa-users"></span>
							</span>
							<span class="nav-link-text ps-1">커뮤니티</span>
						</div>
					</a>
					<!-- 커뮤니티 하위 메뉴 -->
					<ul class="nav collapse" id="community">
						<li class="nav-item">
							<a class="nav-link" href="/community/board/list">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">자유게시판</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/community/anonyboard/list">
									<div class="d-flex align-items-center">
										<span class="nav-link-text ps-1">익명게시판</span>
								</div>
							</a>
						</li>
						<!-- 설문조사 시작 -->
						<li class="nav-item">
							<a class="nav-link dropdown-indicator" href="#survey" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="survey">
								<div class="d-flex align-items-center">
										<span class="nav-link-text ps-1">설문조사</span>
								</div>
							</a>
						</li>
						<!-- 설문조사 하위 메뉴 -->
						<ul class="nav collapse" id="survey">
						<li class="nav-item">
							<a class="nav-link" href="/servey/serveyList">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">설문조사 참여</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/servey/serveyRegister">
									<div class="d-flex align-items-center">
										<span class="nav-link-text ps-1">설문지 작성</span>
									</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/servey/serveyListEmployee">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">설문내역 확인</span>
								</div>
							</a>
						</li>
						</ul>
						<!-- ai 어시스턴트 시작 -->
						<li class="nav-item">
							<a class="nav-link dropdown-indicator" href="#aiassistant" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="aiassistant">
									<div class="d-flex align-items-center">
										<span class="nav-link-text ps-1">AI 어시스턴트</span>
								</div>
							</a>
						</li>
						<!-- AI 어시스턴트 하위 메뉴 -->
						<ul class="nav collapse" id="aiassistant">
						<li class="nav-item">
							<a class="nav-link" href="/ai/economy">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">경제 전망</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/ai/article/summarize">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">기사 요약</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/ai/recommend/menu">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">메뉴 추천</span>
								</div>
							</a>
						</li>
						</ul>
					</ul>
					<!-- //////////////////////커뮤니티 끝///////////////////////// -->
					<!-- ////////////////////////////인사관리 시작/////////////////////////////// -->
					<a class="nav-link dropdown-indicator" href="#hrm" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="hrm">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fa-user-tie"></span>
							</span>
							<span class="nav-link-text ps-1">인사관리</span>
						</div>
					</a>
					<!-- 인사관리 하위메뉴 -->
						<ul class="nav collapse" id="hrm">
						<li class="nav-item">
							<a class="nav-link" href="/empinfo/empinfo">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">인사 정보</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/empinfo/vacinfopersonal">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">연차 정보</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/empinfo/vacinfoemployee">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">전직원 연차 정보</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/empinfo/payment">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">급여</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/empinfo/paymentemployee">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">전 직원 급여 정보</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/resume/resumeList">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">이력서 관리</span>
								</div>
							</a>
						</li>
						</ul>
					<!-- ////////////////////////////인사관리 끝/////////////////////////////// -->
					<!-- ///////////////////////////일정관리 시작////////////////////////////// -->
					<a class="nav-link" href="/schedule/list" role="button" aria-controls="schedule">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fas fa-calendar-alt"></span>
							</span>
							<span class="nav-link-text ps-1">일정관리</span>
						</div>
					</a>
					<!-- ///////////////////////////일정관리 끝////////////////////////////// -->
					<!-- //////////////////////예약 시작///////////////////////// -->
					<a class="nav-link dropdown-indicator" href="#reservation" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="reservation">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fa-clock"></span>
							</span>
							<span class="nav-link-text ps-1">예약</span>
						</div>
					</a>
					<ul class="nav collapse" id="reservation">
						<li class="nav-item">
							<a class="nav-link" href="/reservationOffm/main">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">회의실 예약</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/reservation/vhcl">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">차량 예약</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/reservation/mylist">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">내 예약 현황</span>
								</div>
							</a>
						</li>
					</ul>
					<!-- //////////////////////예약 끝///////////////////////// -->
					<!-- ////////////////////////////////////// 화상회의 시작 //////////////////////////////////////-->
					<a class="nav-link" href="https://192.168.141.26:7000" role="button">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fa-video"></span>
							</span>
							<span class="nav-link-text ps-1">화상회의</span>
						</div>
					</a>
					<!-- ////////////////////////////////////// 화상회의 끝 //////////////////////////////////////-->
					<!-- ////////////////////////////조직도 시작/////////////////////////////// -->
					<a class="nav-link" href="/organization/list" role="button" aria-controls="organizationchart">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fa-sitemap"></span>
							</span>
							<span class="nav-link-text ps-1">조직도</span>
						</div>
					</a>
					<!-- ////////////////////////////조직도 끝/////////////////////////////// -->
					<!-- ////////////////////////////////////// 증명서 시작 //////////////////////////////////////-->
					<a class="nav-link dropdown-indicator" href="#certificate" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="certificate">
						<div class="d-flex align-items-center">
						<span class="nav-link-icon"><span class="fa-solid fa-award"></span></span><span
								class="nav-link-text ps-1">증명서 발급</span>
						</div>
					</a>
					<ul class="nav collapse" id="certificate">
						<li class="nav-item">
							<a class="nav-link" href="app/msg/compose.html">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">증명서 신청</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="app/msg/compose.html">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">신청 내역</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="app/msg/compose.html">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">발급 승인</span>
								</div>
							</a>
						</li>
					</ul>
					<!-- ////////////////////////////////////// 증명서 끝 //////////////////////////////////////-->

						</li>

					<!-- 구분선 -->
					</li>
			<!-- 관리자 메뉴 시작 -->
			<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="nav-item">
						<!-- label-->
						<div class="row navbar-vertical-label-wrapper mt-3 mb-2">
							<div class="col-auto navbar-vertical-label">Management</div>
							<div class="col ps-0">
								<hr class="mb-0 navbar-vertical-divider" />
							</div>
						</div>
					</li>

					<li class="nav-item">
					 <a class="nav-link" href="/" role="button" >
						<div class="d-flex align-items-center">
							<span class="nav-link-icon"><span class="fa-solid fa-laptop"></span></span>
							<span class="nav-link-text ps-1">관리자 메뉴</span>
						</div>
					</a>


					<!-- //////////////////////계정 관리///////////////////////// -->
					<a class="nav-link dropdown-indicator" href="#userManage" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="reservation">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid far fa-address-card"></span>
							</span>
							<span class="nav-link-text ps-1">계정 관리</span>
						</div>
					</a>
					<ul class="nav collapse" id="userManage">
						<li class="nav-item">
							<a class="nav-link" href="/admin/account/list">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">계정 목록</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/admin/account/create">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">계정 생성</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/admin/account/auth">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">권한 관리</span>
								</div>
							</a>
						</li>
					</ul>
					<!-- //////////////////////계정 관리 끝///////////////////////// -->
					<!-- //////////////////////결제 관리///////////////////////// -->
					<a class="nav-link dropdown-indicator" href="#payment" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="reservation">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fas fa-credit-card"></span>
							</span>
							<span class="nav-link-text ps-1">결제 관리</span>
						</div>
					</a>
					<ul class="nav collapse" id="payment">
						<li class="nav-item">
							<a class="nav-link" href="/reservationOffm/main">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">결제 하기</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/reservation/vhcl">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">결제 내역</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/reservation/mylist">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">결제 수단</span>
								</div>
							</a>
						</li>
					</ul>
					<!-- //////////////////////결제 관리 끝///////////////////////// -->
					<!-- //////////////////////공통코드///////////////////////// -->
					<a class="nav-link dropdown-indicator" href="#codeManage" role="button" data-bs-toggle="collapse" aria-expanded="false" aria-controls="reservation">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fas fa-code"></span>
							</span>
							<span class="nav-link-text ps-1">공통 코드</span>
						</div>
					</a>
					<ul class="nav collapse" id="codeManage">
						<li class="nav-item">
							<a class="nav-link" href="/admin/code/groupCdList">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">공통코드</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/admin/code/manageCdList">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">공통상세코드</span>
								</div>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/admin/code/customeCdList">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">사용자코드</span>
								</div>
							</a>
						</li>
					</ul>
					<!-- //////////////////////공통코드///////////////////////// -->
					<!-- ////////////////////////////////////// 로그 관리 //////////////////////////////////////-->
					<a class="nav-link" href="/admin/log/logList" role="button data-bs-toggle="collapse" aria-expanded="false" aria-controls="chat"">
						<div class="d-flex align-items-center">
							<span class="nav-link-icon">
								<span class="fa-solid fas fa-history"></span>
							</span>
							<span class="nav-link-text ps-1">로그 관리</span>
						</div>
					</a>
					<!-- ////////////////////////////////////// 로그 관리 끝 //////////////////////////////////////-->

			</sec:authorize>

			</ul>
		</div>
	</div>
</nav>