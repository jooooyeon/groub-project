
var csrfToken = $("input[name='_csrf']").val();

var html = ``;
let files = [];
$('#email-attachment').on('change',function(e){
    if(e.target.files[0]){
        html = $('#upload').html();
        html += `<button class="col-2 btn btn-outline-secondary btn-sm file-del mail-file" type="button" title="누르면 삭제됩니다.">`+e.target.files[0].name+`</button>`
        var file = e.target.files[0];
		files.push(file);

        $('#upload').html(html);
    }
});


$('.to-email').on('keydown', function(e) {
    var email = $(this).val();
    let html = "";
    var domainRegex = /\.[a-zA-Z]{2,}$/; // 점 이후에 두 글자 이상을 감지하도록 수정
    
    if (!(domainRegex.test(email))) return;
    if(!(e.which==32||e.keyCode==32||e.which==13||e.keyCode==13)) return;
    
    if($('#rcptn').val()){
        html +=
        	`<button type="button" class="btn btn-outline-secondary btn-del to-rcptn" data-cd="rcptn" title="누르면 삭제됩니다">`+$(this).val()+`</button>`;
    }
    else if($('#cc').val()){
    	html +=
        	`<button type="button" class="btn btn-outline-secondary btn-del to-rcptn" data-cd="cc" title="누르면 삭제됩니다">`+$(this).val()+`</button>`;
    }
    else if($('#hc').val()){
    	html +=
        	`<button type="button" class="btn btn-outline-secondary btn-del to-rcptn" data-cd="hc" title="누르면 삭제됩니다">`+$(this).val()+`</button>`;
    }
    $(this).prev().after(html);
    $(this).val('');
    
    
});

//추후에 생긴 child를 observe 함
var target = document.body;
var config = { childList: true, subtree: true };

var observer = new MutationObserver(function(mutations) {
	mutations.forEach(function(mutation) {
		if (mutation.type == "childList") {
			//받는 사람, 참조, 숨은 참조에 등록된 이메일 삭제
			var btnDel = $('.btn-del');
			$(btnDel).on('click',function(){
				$(this).remove();
			});
			
			//등록된 파일 목록 삭제
			$('.file-del').on('click',function(){
			    var fileName = $(this).text();

			    // 배열에서 해당 파일을 찾아 제거합니다.
			    files = files.filter(function(file) {
			        return file.name !== fileName;
			    });
			    $(this).remove();
			});
		}
	});
});
// Mutation Observer 시작
observer.observe(target, config);

$('#jusorok').on('click', function() {
	$.ajax({
		url : '/address/book/popup',
		type : 'post',
		headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'X-CSRF-TOKEN': csrfToken
        },
		success : function(res) {
			$('.modal-body').html(res);
			$('#exampleModal').modal('show');
		}
	});
});

//메일 보내기
$("#mail-send").on("click", function() {
	const userDataMap = new Map(Object.entries(userData));
	let receiver = '';
	$('.to-rcptn').each((i,e)=>{
		
		userDataMap.forEach((v,k)=>{
			if(v[3]==$(e).text()) receiver = v[4]
		})
		
		stomp.send('/pub/mail', {}, JSON.stringify({
			senderNm : userData[userId][0]+` `+userData[userId][1]+` `+userData[userId][2],
			sender : userId,
			userId : receiver,
		}));
		
		//메일 내용 태그 없애기
		var emlCn = $(`#emlCn`);
		var txt = $(emlCn).text();
		
		var formData = new FormData();
		formData.append("dsptchEml",dsptchEml);
		formData.append("rcptnEml",$(e).text());
		formData.append("emlTtl",$(`#emlTtl`).val());
		formData.append("txt",txt);
		formData.append("emlCn",emlCn.val());
		formData.append("dsptchCd",$(e).data('cd'));
		
		for (let i = 0; i < files.length; i++) {
			formData.append('files', files[i]); 
		}
		
		
		//ajax 통신으로 메일 내용 전달하기
		$.ajax({
			url:`/mail/send`,
			type:`post`,
			data:formData,
		    processData: false,
		    contentType: false,
			headers: {
	            'X-CSRF-TOKEN': csrfToken,
	        },
	        success:(res)=>{
			},
		});
		
		location.href = '/mail/inbox';
	
	});
	
});