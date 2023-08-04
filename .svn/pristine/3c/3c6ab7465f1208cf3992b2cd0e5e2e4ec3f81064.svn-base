<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="card col-lg-8" id="frm">
	<div class="card-header bg-light">
		<h5 class="mb-0">새 메일</h5>
	</div>
	<div class="container card-body p-0">
		<div class="border border-top-0 border-200 d-flex">
			<a class="col-2 btn btn btn-light title">제목</a> <input
				class="form-control border-0 rounded-0 outline-none px-x1"
				id="emlTtl" type="text" value="hi">
		</div>
		<div class="border border-top-0 border-200 d-flex">
			<a class="col-2 btn btn-light">받는 사람</a> 
			<input class="form-control border-0 rounded-0 outline-none px-x1 to-email" id="rcptn" type="email" name="receiver" value="syngyubee@naver.com "/>
<!-- 			<button class="btn btn-light btn-sm py-0 mt border" id="jusorok" data-toggle="modal" data-target="#exampleModal" type="button"> -->
<!-- 				<svg class="svg-inline--fa fa-user-plus fa-w-20" data-fa-transform="shrink-5 left-2" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="user-plus" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" data-fa-i2svg="" style="transform-origin: 0.5em 0.5em;"> -->
<!-- 					<g transform="translate(320 256)"><g transform="translate(-64, 0)  scale(0.6875, 0.6875)  rotate(0 0 0)"><path fill="currentColor" d="M624 208h-64v-64c0-8.8-7.2-16-16-16h-32c-8.8 0-16 7.2-16 16v64h-64c-8.8 0-16 7.2-16 16v32c0 8.8 7.2 16 16 16h64v64c0 8.8 7.2 16 16 16h32c8.8 0 16-7.2 16-16v-64h64c8.8 0 16-7.2 16-16v-32c0-8.8-7.2-16-16-16zm-400 48c70.7 0 128-57.3 128-128S294.7 0 224 0 96 57.3 96 128s57.3 128 128 128zm89.6 32h-16.7c-22.2 10.2-46.9 16-72.9 16s-50.6-5.8-72.9-16h-16.7C60.2 288 0 348.2 0 422.4V464c0 26.5 21.5 48 48 48h352c26.5 0 48-21.5 48-48v-41.6c0-74.2-60.2-134.4-134.4-134.4z" transform="translate(-320 -256)"></path></g></g> -->
<!-- 				</svg> -->
<!-- 			</button> -->
		</div>
		<div class="border border-top-0 border-200 d-flex">
			<a class="col-2 btn btn btn-light" id="receiver-ref">참조</a>
			<input class="form-control border-0 rounded-0 outline-none px-x1 to-email" id="cc" type="email" />
		</div>
		<div class="border border-top-0 border-200 d-flex">
			<a class="col-2 btn btn btn-light" id="receiver-ref-hidden">숨은 참조</a>
			<input class="form-control border-0 rounded-0 outline-none px-x1 to-email" id="hc" type="email" />
		</div>
		<input type="hidden" name="ctxt" id="ctxt" value="">
		<div class="min-vh-50">
			<textarea class="tinymce d-none" name="brdContent" id="emlCn"
				data-tinymce="data-tinymce" name="content">ㅎㅇㅎㅇ
				</textarea>
		</div>
	</div>
	<div class="card-footer border-top border-200 d-flex flex-between-center">
		<div class="d-flex align-items-center">
			<button class="btn btn-falcon-default btn-sm" type="button"
				id="mail-send" style="margin-right: 5px;">
				<span class="d-none d-sm-inline-block ms-1">보내기</span>
			</button>
			<input class="d-none" id="email-attachment" type="file"> <label
				class="me-2 btn btn-light btn-sm mb-0 cursor-pointer"
				for="email-attachment" data-bs-toggle="tooltip"
				data-bs-placement="top" aria-label="Attach files"
				data-bs-original-title="Attach files"><svg
					class="svg-inline--fa fa-paperclip fa-w-14 fs-1"
					data-fa-transform="down-2" aria-hidden="true" focusable="false"
					data-prefix="fas" data-icon="paperclip" role="img"
					xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"
					data-fa-i2svg="" style="transform-origin: 0.4375em 0.625em;">
					<g transform="translate(224 256)">
					<g transform="translate(0, 64)  scale(1, 1)  rotate(0 0 0)">
					<path fill="currentColor"
						d="M43.246 466.142c-58.43-60.289-57.341-157.511 1.386-217.581L254.392 34c44.316-45.332 116.351-45.336 160.671 0 43.89 44.894 43.943 117.329 0 162.276L232.214 383.128c-29.855 30.537-78.633 30.111-107.982-.998-28.275-29.97-27.368-77.473 1.452-106.953l143.743-146.835c6.182-6.314 16.312-6.422 22.626-.241l22.861 22.379c6.315 6.182 6.422 16.312.241 22.626L171.427 319.927c-4.932 5.045-5.236 13.428-.648 18.292 4.372 4.634 11.245 4.711 15.688.165l182.849-186.851c19.613-20.062 19.613-52.725-.011-72.798-19.189-19.627-49.957-19.637-69.154 0L90.39 293.295c-34.763 35.56-35.299 93.12-1.191 128.313 34.01 35.093 88.985 35.137 123.058.286l172.06-175.999c6.177-6.319 16.307-6.433 22.626-.256l22.877 22.364c6.319 6.177 6.434 16.307.256 22.626l-172.06 175.998c-59.576 60.938-155.943 60.216-214.77-.485z"
						transform="translate(-224 -256)"></path></g></g></svg> <!-- <span class="fas fa-paperclip fs-1" data-fa-transform="down-2"></span> Font Awesome fontawesome.com --></label>
			<input class="d-none" type="file" accept="image/*">
		</div>
		<div class="d-flex align-items-center">
			<div class="dropdown font-sans-serif me-2 btn-reveal-trigger">
				<button class="btn btn-link text-600 btn-sm dropdown-toggle btn-reveal dropdown-caret-none" id="email-options" type="button" data-bs-toggle="dropdown" data-boundary="viewport" aria-haspopup="true" aria-expanded="false">
					<svg class="svg-inline--fa fa-ellipsis-v fa-w-6" data-fa-transform="down-2" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="ellipsis-v" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 192 512" data-fa-i2svg="" style="transform-origin: 0.1875em 0.625em;"><g transform="translate(96 256)"><g transform="translate(0, 64)  scale(1, 1)  rotate(0 0 0)"><path fill="currentColor" d="M96 184c39.8 0 72 32.2 72 72s-32.2 72-72 72-72-32.2-72-72 32.2-72 72-72zM24 80c0 39.8 32.2 72 72 72s72-32.2 72-72S135.8 8 96 8 24 40.2 24 80zm0 352c0 39.8 32.2 72 72 72s72-32.2 72-72-32.2-72-72-72-72 32.2-72 72z" transform="translate(-96 -256)"></path></g></g></svg>
				</button>
				<div class="dropdown-menu dropdown-menu-end border py-2" aria-labelledby="email-options">
					<a class="dropdown-item" href="#!">Print</a>
					<a class="dropdown-item" href="#!">Check spelling</a>
					<a class="dropdown-item" href="#!">Plain text mode</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#!">Archive</a>
				</div>
			</div>
			<button class="btn btn-light btn-sm" type="button" data-bs-toggle="tooltip" data-bs-placement="top" aria-label="Delete" data-bs-original-title="Delete">
				<svg class="svg-inline--fa fa-trash fa-w-14" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="trash" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" data-fa-i2svg=""><path fill="currentColor" d="M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z"></path></svg>
			</button>
		</div>
	</div>
	<div class="d-flex" id="upload"></div>
	<sec:csrfInput/>
</form>

<!-- 모달 시작 -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="max-width: 600px;" role="document">
		<div class="modal-content">
			<div class="modal-body">...</div>
		</div>
	</div>
</div>
<!-- 모달 끝 -->

<script>
	const dsptchEml = `${dsptchEml}`;
	const dsptchId = `${dsptchId}`;
</script>

<script src="/resources/js/mail-js/mail-compose.js"></script>
