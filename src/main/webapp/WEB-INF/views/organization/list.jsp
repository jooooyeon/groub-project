<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>

<!-- jquery 낮은 버전 사용하기 -->
<script>
  var jQuery1x = jQuery.noConflict();
</script>


<style>

.image {
        display: flex;
        align-items: flex-start;
    }

.image img {
       width: 100px;
       height: 100px;
   }

.info {
    padding-left: 10px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin-left: 18px;
}

.btn-group {
    margin-top: 8px;
    margin-bottom: 10px;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-left: 12px;
}

.btn-group .btn {
    margin-bottom: 5px;
}

.wrapper {
	display: grid;
	grid-template-columns: 1fr;
	grid-template-rows: 100px 100px 100px;
	grid-gap: 100px;
	
}


#jstree {
	width: 20rem;
	grid-column: 2/4;
	grid-row: 1;
	overflow:overlay;
	position:relative;

}

#jstree::-webkit-scrollbar {
	width: 10px;
}

#jstree::-webkit-scrollbar-thumb {
	background-color: hsla(207.2, 63.9%, 87.1%, 0.45);
    border-radius: 100px;
}

#outBox {
	display: flex;
	height: 700px;
}


#childCard {
	width: 600px;
	height: 400px;
}

.card .image {
	max-width : 90%; 
	height: auto; 
	text-align: left;
	padding: 10px;
	width: 130px;
	height: 130px;
}

.card .image img {
	max-width: 100%;
	max-height: 100%;
}

.card-container2 {
	display: flex;
	
}

.card .card-body {
	/* 남은 공간을 모두 차지하도록 설정 */
/* 	flex-grow: 1;  */
	padding: 10px;
}

.hidden {
	display: none;
}

.card-head-text {
	font-size: 3px;
	font-color: gray;

}

</style>



<!-- 바깥쪽 카드 -->
<div class="card" style="width:800px; height:700px;">
		<br/>
		<h5 class="card-title">조직도</h5>
		<br/>
		<div class="card" id="searchBox">
		  <div class="input-group">
		    <input type="text" id="search" class="form-control" placeholder="이름을 입력하세요." style="font-size: 13px;">
		    <button class="btn btn-primary" type="button">
		      <i class="fa fa-search"></i>
		    </button>
		  </div>
		</div>
			<br />
<!-- 		 <label> 사원 이름을 클릭하여 ID 카드를 열 수 있습니다. <br> 부서명을 클릭하면 사라져용. </label> -->
		<div class="" style="width:200px; height:150px;" >
			<div class="card" id="jstree" style="overflow:scroll; width:200px; height:450px; layout:fixed;" ></div>
		</div>
			<div id="idCard" style="position: absolute; left: 250px; top: 200px; width:350px; height: 200px; " ></div>
			
</div>			


<script type="text/javascript">
$(function(){
// 	console.log("왔다");
	
	// DB에서 조직 정보 가져오기
	jQuery1x.ajax({
		url:"/organization/jsonList",
		type:"post",
		dataType:"json",
		beforeSend: function(xhr) {
            xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
        },
		success:function(result){
			//[{"userId":"NAVER_2023060009","userNm":"김윤아","userTelno":"01029949383","userEml":"2023060009@naver.com","userImg":"NULL","deptNo":1,"jbgdCd":"JG001","jbtlCd":"JT001"}
// 			console.log(result);
// 			console.log("result : " + JSON.stringify(result));
		 	const data = [];
		 	let nodes = result;
		 	
		 	console.log("result", result);
		 	
		 	//idCard step1
// 		 	var list = data.list;
// 		 	var html = '';
			
		 	// parent 기준으로 데이터 정리
		 	const parents = {};
		 	nodes.forEach(node => {
		 	  if (!parents[node.parent]) {
		 	    parents[node.parent] = [];
		 	  }
// 		 	  parents[node.parent].push(node.child);
			  // idCard를 가져올 때 index가 아니라 id를 가져와야 함!!
		 	  parents[node.parent].push({name : node.child, id : node.id});
		 	});
			
		 	console.log("parents", parents);
		 	// jstree에서 사용할 수 있는 형태로 데이터 변환
		 	Object.keys(parents).forEach(parent => {
		 	  const children = parents[parent].map(child => {
// 		 	    return {text: child};
		 	    return {text: child.name, type: "file", id : child.id};
		 	  });
		 	  data.push({
		 	    text: parent,
		 	    children: children
		 	  });
		 	});
			console.log("data", data);
// 		 	console.log($('#jstree'))
		 	// ajax data 받아오기 
		 	jQuery1x('#jstree').jstree({
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
				var selectedNodeId = data.node.id;
				console.log("selectedNodeId", selectedNodeId);
				
				//idCard 하나씩만 보이기 : 보였던걸 hidden 처리하고 새롭게 클릭한 정보를 hidden 해제
				jQuery1x("[id*=childCard]").each(function(){
					if(!jQuery1x(this).hasClass("hidden")){  
						jQuery1x(this).addClass("hidden");   //현재 있는 idCard hidden
					}
				}); //하나씩 보이기 끝
				jQuery1x("#childCard" + selectedNodeId).removeClass('hidden');
		 	});
		 	
		 	
		 	// .on("activate_node.jstree", function (node) {node, event}
		 	
		 	
		 	
		 	
		 	let str = "";
	
		 	$.each(result, function(index, obj) {
		 	    var str = "<div class='card overflow-hidden-card hidden' id='childCard" + obj.id + "'>";
		 	    str += "<div class='card-head-text'>" + obj.id + "</div>";
		 	    str += "<div class='image'>";
// 	 	        str += "<img class='img-fluid' src='" + obj.img + "' alt='Image'>";
		 	    if (obj.img) { // 이미지가 있을 경우에만 이미지 추가
		 	        str += "<img class='img-fluid' src='" + obj.img + "' alt='Image'>";
		 	     } else {
		 	        str += "<img class='img-fluid' src='/resources/image/noimage3.png' alt='No Image'>";
// 		 	        str += "<div class='no-image' style='width: 130px; height: 130px; background-color: #f0f0f0;'></div>";
		 	    }
		 	    str += "<div class='info'>";
		 	    str += "<p class='card-text'>" + obj.dept + "</p>";
                str += "<p class='card-text'>" + obj.jbgdCd + "</p>";
                str += "<h5 class='card-title'>" + obj.name + "</h5>";
                str += "<p class='card-text'>" + obj.email + "</p>";
                str += "<p class='card-text'>" + obj.tel + "</p>";
		 	    str += "</div>";
		 	    str += "</div>";
		 	    str += "<div class='btn-group'>";
		 	    str += "<a class='btn btn-outline-info me-1 mb-1 btn-sm' href='/mail/compose'>메일 보내기</a>";
		 	    str += "<a class='btn btn-outline-info me-1 mb-1 btn-sm' href='/msg/compose'>쪽지 보내기</a>";
		 	    str += "</div>";
		 	    //빨간 close 버튼
// 		 	    str += "<button type='button' id='closeCard" + obj.id + "' class='btn btn-outline-danger btn-sm' style='position: absolute; top: 0; right: 0;'>X</button>";
// 		 	    str += "<button type='button' id='closeCard" + obj.id + "' class='btn-close' disabled='' aria-label='Close' style='position: absolute; top: 0; right: 0;'></button>";
		   	    //되는 close 버튼
		   	    str += "<button type='button' class='btn-close close-button' data-card-id='" + obj.id + "' aria-label='Close' style='position: absolute; top: 0; right: 0;'></button>";
		 	    str += "</div>";
		 	    $("#idCard").append(str);
		 		  
		 		// X 버튼 클릭 이벤트 처리
	                $("#idCard").on("click", ".close-button", function() {
				      var cardId = $(this).attr("data-card-id");
				      $("#childCard" + cardId).addClass("hidden");
	                });
		 		  
		       });
			 	
			}
		 	
		});
	
		 	// 조직도 내 검색 기능
		 	$('#search').on('keyup', function () {
		 	    var searchString = $(this).val();
		 	   jQuery1x('#jstree').jstree(true).search(searchString);
		 	    
		 	});
			
			
});

</script>



