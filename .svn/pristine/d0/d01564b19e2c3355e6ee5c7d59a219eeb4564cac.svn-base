/**
 * 
 */

var html = "";
//메일 삭제
$("#mail-delete").on('click', function() {
	let modal = document.querySelector('#mail-modal-delete');
	$(modal).modal('show');
	
	$('#mail-delete-cancle').on('click',()=>{
		$(modal).modal('hide');
	});
	
	$('#mail-delete-check').on('click',()=>{
		let sort = '';
		$('.form-check-input:checked').each((i, e) => {
			const emlNo = $(e).data('no');
			const emlStts = $(e).data('stts');
			sort = $(e).data('sort');
	
			$.ajax({
				url: '/mail/delete',
				type: 'post',
				data: {
					emlNo: emlNo,
					emlStts: emlStts,
					sort: sort,
				},
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded',
					'X-CSRF-TOKEN': csrfToken
				},
				success: (res) => {
				},
			});
		});
		
		$('.form-check-input.test').prop('checked', false);
		if (sort == 'rcptn') mail('/mail/receiver', '받은 메일', 'detailReceiver', rcptnEml, 'rcptn');
		else if (sort == 'dsptch') {
			
			mail('/mail/sender', '보낸 메일', 'detailSender', dsptchEml, 'dsptch');
		}
		
		$(modal).modal('hide');
	})
});



//화면이 불러와질 때 최초 설정
$(() => {
	mail('/mail/receiver', '받은 메일', 'detailReceiver', rcptnEml, 'rcptn');
});

//ajax에서 csrfToken을 사용하기 위함
var csrfToken = $("input[name='_csrf']").val();

//동적으로 만들어진 요소에 대한 핸들링
$(document).on('click', '.mail-import', function() {
	html = "";
	var emlNo = $(this).data('value');
	var emlStts = $(this).data('stts');
	var svg = $(this).find('svg')[0];
	var cnt = $(svg).data('cnt');

	if (emlStts == "MM005") {
		html = `<svg class="svg-inline--fa fa-star fa-w-18 text-warning ms-1" data-cnt="1" data-fa-transform="down-4" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="star" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" data-fa-i2svg="" style="transform-origin: 0.5625em 0.75em;"><g transform="translate(288 256)"><g transform="translate(0, 128)  scale(1, 1)  rotate(0 0 0)"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z" transform="translate(-288 -256)"></path></g></g></svg>`;
	} else {
		html = `<svg class="svg-inline--fa fa-star fa-w-18 text-300 ms-1" data-cnt="0" data-fa-transform="down-4" aria-hidden="true" focusable="false" data-prefix="far" data-icon="star" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" data-fa-i2svg="" style="transform-origin: 0.5625em 0.75em;"><g transform="translate(288 256)"><g transform="translate(0, 128)  scale(1, 1)  rotate(0 0 0)"><path fill="currentColor" d="M528.1 171.5L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6zM388.6 312.3l23.7 138.4L288 385.4l-124.3 65.3 23.7-138.4-100.6-98 139-20.2 62.2-126 62.2 126 139 20.2-100.6 98z" transform="translate(-288 -256)"></path></g></g></svg>`;
	}
	$(this).html(html);

	$.ajax({
		url: '/mail/importSet',
		type: 'get',
		data: {
			emlNo: emlNo,
			emlStts: emlStts,
		},
		success: (res) => {
			mail('/mail/receiver', '받은 메일', 'detailReceiver', rcptnEml, 'rcptn');
		},
	});
});


//input check box에 대한 모든 요소에 대한 check 설정
$('.form-check-input.test').on('click', function() {
	var isChecked = $(this).is(':checked');
	$('.form-check-input').prop('checked', isChecked);
});

const checkInbox = $('.dropdown-item')
checkInbox.on('click', function() {
	checkInbox.find('svg').remove();
	checkInbox.attr("class", "dropdown-item d-flex justify-content-between");

	$(this).append(`<svg class="svg-inline--fa fa-check fa-w-16" data-fa-transform="down-4 shrink-4" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="check" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg="" style="transform-origin: 0.5em 0.75em;">
		<g transform="translate(256 256)"><g transform="translate(0, 128)  scale(0.75, 0.75)  rotate(0 0 0)">
		<path fill="currentColor" d="M173.898 439.404l-166.4-166.4c-9.997-9.997-9.997-26.206 0-36.204l36.203-36.204c9.997-9.998 26.207-9.998 36.204 0L192 312.69 432.095 72.596c9.997-9.997 26.207-9.997 36.204 0l36.203 36.204c9.997 9.997 9.997 26.206 0 36.204l-294.4 294.401c-9.998 9.997-26.207 9.997-36.204-.001z" transform="translate(-256 -256)"></path></g></g></svg>`)
})

//받은 메일함
$('#receive-mail').on('click', () => {
	mail('/mail/receiver', '받은 메일', 'detailReceiver', rcptnEml, 'rcptn');
	$('#mail-delete').show();
});

//보낸 메일함
$('#send-mail').on('click', () => {
	mail('/mail/sender', '보낸 메일', 'detailSender', dsptchEml, 'dsptch');
	$('#mail-delete').show();
});

//중요 메일함
$('#import-mail').on('click', () => {
	mail('/mail/importMsg', '중요 메일', 'detailReceiver', rcptnEml, 'rcptn');
	$('#mail-delete').show();
});

//휴지통
$('#trash-mail').on('click', () => {
	mail('/mail/trash', '휴지통', 'detailReceiver', rcptnEml, 'rcptn');
	$('#mail-delete').hide();
});

//메일의 총 데이터 보관하는 변수
let mailData = [];

//페이징 처리 변수
let currentPage = 0;
let total = 0;
let size = 10;
let endPage = 0;
let content = [];
let pageData;

//화면 내용 받아오기
function mail(link, classSort, path, emlSort, mailSort) {
	$('#mail-output').html("");
	$.ajax({
		url: link,
		data: {
			emlSort: emlSort,
		},
		type: 'post',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
			'X-CSRF-TOKEN': csrfToken
		},
		success: (res) => {
			mailData = [];
			for (let i = 0; i < res.length; i++) mailData.push(res[i]);

			if (res.length == 0) total = 0;
			else {
				total = res.length;
				currentPage = 1;
			}

			if (total / size % 0) endPage = total / size;
			else endPage = parseInt(total / size) + 1;
			if (total < size) {
				content = res;
			} else {
				content = [];
				for (let i = 0; i < size; i++) {
					content.push(res[i]);
				}
			}
			pageData = [{ "currentPage": currentPage }, { "total": total }, { "size": size }, { "content": content }];
			//메일 화면 뿌리는 곳
			mailView(link, classSort, path, emlSort, mailSort, content, currentPage, parseInt(total/size)+1);
			let endRow = currentPage * size;

			if (endRow < total) $('#next').attr('disabled', false);
			else $('#next').attr('disabled', true);
		},
	})
}

$(document).on('click', '#prev, #next', function() {
	//두 버튼을 눌렀을 때 발생되는 currentPage 설정
	if ($(this).attr('id') === 'prev') {
		currentPage -= 1;
	} else {
		currentPage += 1;
	}

	//content 배열 초기화
	content = [];

	//시작행
	let startRow = (currentPage - 1) * size;
	//끝행
	let endRow = currentPage * size;
	if (endRow > mailData.length) endRow = mailData.length;

	for (let i = startRow; i < endRow; i++) {
		content.push(mailData[i]);
	}

	const cls = $(this).data('cls');

	//cls 값에 따라 호출하는 부분
	if (cls == '받은 메일') mailView('/mail/receiver', '받은 메일', 'detailReceiver', rcptnEml, 'rcptn', content, currentPage, parseInt(total/size)+1);
	else if (cls == '보낸 메일') {
		mailView('/mail/receiver', '보낸 메일', 'detailReceiver', dsptchEml, 'dsptch', content, currentPage, parseInt(total/size)+1);
	}
	else if (cls == '중요 메일') mailView('/mail/receiver', '중요 메일', 'detailReceiver', rcptnEml, 'rcptn', content, currentPage, parseInt(total/size)+1);
	else if (cls == '휴지통') mailView('/mail/receiver', '휴지통', 'detailReceiver', rcptnEml, 'rcptn', content, currentPage, parseInt(total/size)+1);

	//버튼에 대한 disabled 설정
	startRow = (currentPage - 1) * size;
	endRow = currentPage * size;

	if (endRow >= total) $('#next').attr('disabled', true);
	else $('#next').attr('disabled', false);
	if (startRow > 0) $('#prev').attr('disabled', false);
	else $('#prev').attr('disabled', true);
});

//메일을 화면에 뿌려줌
function mailView(link, classSort, path, emlSort, mailSort, data, currentPage, totalPage) {
	html = "";
	html = `<h5 class="fs-0 px-3 pt-3 pb-2 mb-0 border-bottom border-200">` + classSort + `</h5>`;

	if (data.length == 0) {
		$('#mail-output').html("");
		html += `<div class='text-center'>메일이 없습니다.</div>`
		$('#mail-output').append(html);
	} else {
		data.forEach((value, index, array) => {
			html += `
				<div class="ms-2 d-flex justify-content-between border-bottom border-200 hover-actions-trigger hover-shadow py-2 bg-light align-items-center">
				`
			if (path != `detailSender`) {
				html += `
					<div class="d-flex bg-light">
						<div class="form-check mb-0 fs-0">
							<input class="form-check-input" type="checkbox" data-stts="`+ value.emlStts + `" data-sort="` + mailSort + `" data-no="` + value.emlNo + `" id="checkbox-11">
						</div>
						<div class="mail-import" data-value=` + value.emlNo + ` data-stts=` + value.emlStts + `>`
				//중요 메일인 경우
				if (value.emlStts == "MM005") {
					html += `<svg class="svg-inline--fa fa-star fa-w-18 text-warning ms-1" data-fa-transform="down-4" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="star" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" data-fa-i2svg="" style="transm-origin: 0.5625em 0.75em;"><g transform="translate(288 256)"><g transform="translate(0, 128)  scale(1, 1)  rotate(0 0 0)"><path fill="currentColor" d="M259.3 17.8L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0z" transform="translate(-288 -256)"></path></g></g></svg></div></div>`
				}
				//휴지통인 경우
				else if (value.emlStts == "MM003") {
					html += `</div></div>`
				}
				//중요 메일이 아닌 경우
				else {
					html += `<svg class="svg-inline--fa fa-star fa-w-18 text-300 ms-1" data-cnt="0" data-fa-transform="down-4" aria-hidden="true" focusable="false" data-prefix="far" data-icon="star" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" data-fa-i2svg="" style="transform-origin: 0.5625em 0.75em;"><g transform="translate(288 256)"><g transform="translate(0, 128)  scale(1, 1)  rotate(0 0 0)"><path fill="currentColor" d="M528.1 171.5L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6zM388.6 312.3l23.7 138.4L288 385.4l-124.3 65.3 23.7-138.4-100.6-98 139-20.2 62.2-126 62.2 126 139 20.2-100.6 98z" transform="translate(-288 -256)"></path></g></g></svg></div></div>`
				}
			} else {
				html += `
						<div class="d-flex bg-light">
							<div class="form-check mb-0 fs-0">
							<input class="form-check-input" type="checkbox" data-stts="`+ value.emlStts + `" data-sort="` + mailSort + `" data-no="` + value.emlNo + `" id="checkbox-11">
							</div>
						</div>`
			}

			if (value.userNm != null) {
				html += `
					<div class="w-25 col-2 d-flex position-relative">
						<a class="stretched-link inbox-link" href="/mail/`+ path + `?emlNo=` + value.emlNo + `&emlStts=` + value.emlStts + `&sort=` + mailSort + `">` + value.deptNm + ` ` + value.cstCdNm + ` ` + value.userNm + `</a>
					</div>
					`
			} else {
				html += `
					<div class="w-25 col-2 d-flex position-relative">
						<a class="stretched-link inbox-link" href="/mail/`+ path + `?emlNo=` + value.emlNo + `&emlStts=` + value.emlStts + `&sort=` + mailSort + `">` + value.rcptnEml + `</a>
					</div>
					`
			}
			
			html +=
				`<div class="col-8 bg-light d-flex">
						<div class="col-8">
							<a class="d-block inbox-link" href="/mail/`+ path + `?emlNo=` + value.emlNo + `&emlStts=` + value.emlStts + `&sort=` + mailSort + `">`
			if(value.mngCdNm1=='열람'){
				html += `<span>`+value.emlTtl+`</span>`;
			}else if(value.mngCdNm1=='미열람'){
				html += `<span style="color: black;">`+value.emlTtl+`</span>`;
			}else if(value.mngCdNm1=='중요'){
				html += `<span style="color: blue;">`+value.emlTtl+`</span>`;
			}else{
				html += `<span>`+value.emlTtl+`</span>`;
			}		
			html +=
					`</a>
						</div>
						<div class="col-auto d-flex justify-content-between">
							<span>`+ value.dsptchDt + `  `
			if(value.mngCdNm1!=null){
				html += `<span>`+ value.mngCdNm1 +`</span>`
			}
						
			html += `</span>
						<svg class="svg-inline--fa fa-star fa-w-18 text-300 ms-auto mb-2 d-sm-none" data-fa-transform="down-7" aria-hidden="true" focusable="false" data-prefix="far" data-icon="star" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" data-fa-i2svg="" style="transform-origin: 0.5625em 0.9375em;">
							<g transform="translate(288 256)">
							<g transform="translate(0, 224)  scale(1, 1)  rotate(0 0 0)">
							<path fill="currentColor" d="M528.1 171.5L382 150.2 316.7 17.8c-11.7-23.6-45.6-23.9-57.4 0L194 150.2 47.9 171.5c-26.2 3.8-36.7 36.1-17.7 54.6l105.7 103-25 145.5c-4.5 26.3 23.2 46 46.4 33.7L288 439.6l130.7 68.7c23.2 12.2 50.9-7.4 46.4-33.7l-25-145.5 105.7-103c19-18.5 8.5-50.8-17.7-54.6zM388.6 312.3l23.7 138.4L288 385.4l-124.3 65.3 23.7-138.4-100.6-98 139-20.2 62.2-126 62.2 126 139 20.2-100.6 98z" transform="translate(-288 -256)"></path></g></g></svg>
						</div>
					</div>
				</div>
				`
		});
		html += `
				<div class="card-footer d-flex justify-content-end align-items-center">
					<div>
						<small>`+((currentPage-1)*size+1)+` of `
						
		if(currentPage*size>total) html+= total
		else html += currentPage*size
						
		html +=	
						` 전체 페이지 `+totalPage+`</small>
						<button class="btn btn-falcon-default btn-sm ms-1 ms-sm-2" id="prev" type="button" data-cls="`+ classSort + `" disabled>
							<svg class="svg-inline--fa fa-chevron-left fa-w-10" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="chevron-left" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 512" data-fa-i2svg=""><path fill="currentColor" d="M34.52 239.03L228.87 44.69c9.37-9.37 24.57-9.37 33.94 0l22.67 22.67c9.36 9.36 9.37 24.52.04 33.9L131.49 256l154.02 154.75c9.34 9.38 9.32 24.54-.04 33.9l-22.67 22.67c-9.37 9.37-24.57 9.37-33.94 0L34.52 272.97c-9.37-9.37-9.37-24.57 0-33.94z"></path></svg>
						</button>
						<button class="btn btn-falcon-default btn-sm ms-1 ms-sm-2" id="next" type="button" data-cls="`+ classSort + `">
							<svg class="svg-inline--fa fa-chevron-right fa-w-10" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="chevron-right" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 320 512" data-fa-i2svg=""><path fill="currentColor" d="M285.476 272.971L91.132 467.314c-9.373 9.373-24.569 9.373-33.941 0l-22.667-22.667c-9.357-9.357-9.375-24.522-.04-33.901L188.505 256 34.484 101.255c-9.335-9.379-9.317-24.544.04-33.901l22.667-22.667c9.373-9.373 24.569-9.373 33.941 0L285.475 239.03c9.373 9.372 9.373 24.568.001 33.941z"></path></svg>
						</button>
					</div>
				</div>
			`
		$('#mail-output').html(html);
	}
}