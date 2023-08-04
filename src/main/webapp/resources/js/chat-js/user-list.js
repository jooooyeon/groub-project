/**
 * 
 */

//csrfToken 변수 설정
var csrfToken;
//node.id 변수 설정
let id = '';
//페이지가 다 완성된 다음에
document.addEventListener('DOMContentLoaded',()=>{
	//document에서 click 이벤트가 발생한다면
	document.addEventListener('click', (e) => {
		//전체 사용자 목록 보기,
		if(e.target.matches('#user-list-btn')) {
			const modalElement = document.querySelector('#user-list');
			const bootstrapModal = new bootstrap.Modal(modalElement);
			   		
	   		csrfToken = jQuery1x("input[name='_csrf']").val();
	   		
	   		jQuery1x.ajax({
	   			url:"/organization/jsonList",
	   			type:"post",
	   			dataType:"json",
	   			headers: {
		            'X-CSRF-TOKEN': csrfToken,
		        },
	   			success:function(result){
	   			 	const data = [];
	   			 	let nodes = [];
	   			 	
	   			 	if(nodes==result) return;
	   			 	
	   			 	nodes = result;
	   			 	
	   			 	// parent 기준으로 데이터 정리
	   			 	const parents = {};
	   			 	nodes.forEach(node => {
	   			 	  if (!parents[node.parent]) {
	   			 	    parents[node.parent] = [];
	   			 	  }
	   				  // idCard를 가져올 때 index가 아니라 id를 가져와야 함!!
	   			 	  parents[node.parent].push({name : node.child, id : node.id, jbgdCd : node.jbgdCd, userImg: node.img, deptNm : node.dept});
	   			 	});
	   				
	   			 	// jstree에서 사용할 수 있는 형태로 데이터 변환
	   			 	Object.keys(parents).forEach(parent => {
	   			 	  const children = parents[parent].map(child => {
	   			 	    return {text: child.name + " " + child.jbgdCd, type: "file", id : child.id, userImg : child.userImg, deptNm : child.deptNm};
	   			 	  });
	   			 	  data.push({
	   			 	    text: parent,
	   			 	    children: children
	   			 	  });
	   			 	});
	   			 	
	   			 	jQuery1x('#jstree1').jstree({
	   			 		'core': {
	   			 			"check_callback" : true,
	   			 			'data': data
	   			 			},
	   			 		"types" :{
	   			 			"default" : {
	   			 				"icon" : "fa-solid fa-folder"
	   			 			},
	   			 			"file" : {
	   			 				"icon" : "fa-solid fa-address-card"
	   			 			}
	   			 		},	
	   			 		"plugins" : ["types", "dnd", "search"]
	   			 		
	   			 	//children node 클릭했을때 hidden 처리 해제
	   			 	}).on('select_node.jstree',function(event, data) {
	   					id = $('#jstree1').attr('aria-activedescendant');
						
						if(data.node.parent=='#') {
							id = '';
							return;
						}
						
	   					var text = data.node.text;
	   					
						if(id!=''&&id!=null){
		   					var str = "<div class='card overflow-hidden-card hidden' id='childCard" + id + "'>";
			  		 		str += "<div class='card-head-text'>" + id + "</div>";
			  		 		str += "<div class='card-container2'>";
			  		 		str += "<div class='card-body'>";
			  		 		str += `<a class='btn btn-outline-info me-1 mb-1 btn-sm chat-open' id='user-id' data-usernm='`+text+`' data-id='`+id+`'>채팅 보내기</a>`;
			  		 		str += "</div></div></div>";
			   			 	$('#idCard1').html(str);
		   					
		   					jQuery1x("[id*=childCard]").each(function(){
		   						if(!jQuery1x(this).hasClass("hidden")){  
		   							jQuery1x(this).addClass("hidden");  
		   						}
		   					});
		   					jQuery1x("#childCard" + id).removeClass('hidden');
						}
	   			 	});
	   			}
	   		});
	   		
	   	 	$('#search1').on('keyup', function () {
	   	 	    var searchString = $(this).val();
	   	 	   jQuery1x('#jstree1').jstree(true).search(searchString);
	   	 	    
	   	 	});
			bootstrapModal.show();
		}
	});
});

$('#user-list').on('hide.bs.modal', function (e) {
	  $(this).find('.modal-body').empty();
})

