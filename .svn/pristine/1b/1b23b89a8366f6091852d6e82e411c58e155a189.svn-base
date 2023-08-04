/**
 * 
 */


var text = $('#msg-text');
var title = $('#msg-title');
var csrfToken = $("input[name='_csrf']").val();

$("#msg-send").on("click", function(e) {
	
	stomp.send('/pub/msg', {}, JSON.stringify({
		senderNm : userData[userId][0]+` `+userData[userId][1]+` `+userData[userId][2],
		sender: userId,
		userId: $('#receiver').val(),
	}));

	$.ajax({
		url: '/msg/save',
		data: {
			sender: userId,
			userId: $('#receiver').val(),
			memoCn: text.val(),
			memoTtl: title.val()
		},
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
			'X-CSRF-TOKEN': csrfToken
		},
		type: 'post',
		success: (res) => {
			location.href = "/msg/inbox";
		},
	})
});

$('#jusorok').on('click', function() {
	$.ajax({
		url: '/address/book/popup',
		type: 'post',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
			'X-CSRF-TOKEN': csrfToken
		},
		success: function(res) {
			$('.modal-body').html(res);
			$('#exampleModal').modal('show');
		}
	});
});