<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css" />
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/chart.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.0/chart.min.js"></script>




<%-- ${data } --%>

<div class="container">
	<div class="row">
		<div class="card mb-3">
			<div class="card-header ">
				<div class="row flex-between-end">
					<div class="col-auto align-self-center">
						<h3 class="mb-0" >설문조사 상세내역</h3>
						<p class="mb-0 pt-1 mt-2 mb-0"></p>
					</div>
					<div class="col-auto ms-auto">
						<div class="nav nav-pills nav-pills-falcon flex-grow-1 mt-2"
							role="tablist"></div>
					</div>
				</div>
			</div>
			
			<div class="card-body" id="modalData">
				<div class="border border-2 p-2" id=""modalData"">
					<table
						class="table table-bordered align-middle text-align border border-2">
						<colgroup>
							<col width="20%">
							<col width="80%">
						</colgroup>
						<tbody >
							<tr>
								<td class=" bg-primary-subtle text-center">제목</td>
								<td class=" text-center ">${data.srvyTtl}</td>
							</tr>
							<tr>
								<td class=" bg-primary-subtle text-center">기간</td>
								<td class=" text-center " id="serveyDate"></td>
							</tr>
							<tr>
								<td class=" bg-primary-subtle text-center">안내문구</td>
								<td class="  ">${data.srvyCn}</td>
							</tr>
						</tbody>
					</table>
					
					
					
					<table id="myTable"
						class="table table-bordered align-middle text-align border border-2">
						<colgroup>
							<col width="20%">
							<col width="80%">
						</colgroup>
						<c:forEach var="serveyQItemVO" items="${data.serveyQItemVOList}" varStatus="stat" >
						<tbody class="myTbody" id="myTbody">
							<tr>
								<td class=" bg-primary-subtle text-center" rowspan="2">${stat.count }</td>
								<td class="" >${serveyQItemVO.qitemCt}</td>
							</tr>
							<tr class="bokiList" id="bokiList">
								<td class="boki" name="boki" >
								
									<table>
										<tr>
							<!-- 설문지 질문 속 보기에 담긴 serveyQItemVO의 serveyOptionVO의 member 변수 받아오기 시작 -->
							<c:forEach var="serveyOptionVO" items="${serveyQItemVO.serveyOptionVOList}" varStatus="stat2">
							    <tr>
							        <td>${stat2.count}.</td>
							        <td class="ps-2">${serveyOptionVO.optnCt}</td>
							        <td class="ps-3" boki1> ${serveyOptionVO.selectUser} /  ${data.totalUser}</td>
							        <input type="hidden" class="aa" value="${stat.count }:${serveyOptionVO.selectUser}" />
							        <input type="hidden" class="bb" value="${stat.count }&${serveyOptionVO.optnCt}" />
							    </tr>
							</c:forEach>

							<!-- 설문지 질문 속 보기에 담긴 serveyQItemVO의 serveyOptionVO의 member 변수 받아오기 끝 -->
									</table>
									<div class="chart-wrap">
									<canvas id="myChart${stat.count }" width="300px"></canvas>
									</div>
									
<%-- 								<p>${stat2.count}. ${serveyOptionVO.optnCt} </p> --%>
								</td>
							</tr>
						</tbody>
						</c:forEach>
					</table>
					
				<div class="d-flex justify-content-end ">
					<button class="btn btn-secondary  me-1 mb-1" onclick="goList()">목록</button>
				</div>
				

				</div>
			</div>
			
		</div>
	</div>
</div>


<script>
//문제 수
var bbElements = document.querySelectorAll('.myTbody');
var outerForEachLength = bbElements.length;
console.log(outerForEachLength);


// //보기 선택자 수
// $(".aa").each(function() {
//     var aaaa = $(this).val();
//     console.log(aaaa);
// });


window.person1 = [];
window.person2 = [];
window.person3 = [];
window.person4 = [];
window.person5 = [];


$(".aa").each(function() {
    var value = $(this).val();
    var parts = value.split(':');
    var prefix = parts[0];
    var number = parseInt(parts[1]);

    if (prefix === '1') {
    	person1.push(number);
    } else if (prefix === '2') {
    	person2.push(number);
    } else if (prefix === '3') {
    	person3.push(number);
    } else if (prefix === '4') {
    	person4.push(number);
    } else if (prefix === '5') {
    	person5.push(number);
    }
    
    
});

// console.log("답변 선택한사람의 수:", a); // [5, 3, 2]
// console.log("답변 선택한사람의 수:", b); // [3, 4, 3]



window.label1 = [];
window.label2 = [];
window.label3 = [];
window.label4 = [];
window.label5 = [];

$(".bb").each(function() {
    var value = $(this).val();
    var parts = value.split('&');
    var prefix = parts[0];
    var number = parts[1];

    if (prefix === '1') {
        label1.push(number);
    } else if (prefix === '2') {
        label2.push(number);
    } else if (prefix === '3') {
        label3.push(number);
    } else if (prefix === '4') {
        label4.push(number);
    } else if (prefix === '5') {
        label5.push(number);
    }
});


// console.log("라벨:", aa); 
// console.log("라벨:", bb); 





const ctxArray = []; // 각각의 ctx 변수를 저장할 배열
const myChartArray = []; // 각각의 myChart 변수를 저장할 배열

for (let i = 1; i <= outerForEachLength; i++) {
  const ctx = document.getElementById("myChart" + i).getContext('2d');
  ctxArray.push(ctx); // ctx를 배열에 추가하여 나중에 참조할 수 있도록 함

  const myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
      labels: window['label' + i],
      datasets: [{
        data: window['person' + i],
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)'
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)'
        ],
        borderWidth: 1,
      }]
    },
    options: {
      maintainAspectRatio: false,
      responsive: false,
     
      scales: {
        y: {
          beginAtZero: false,grid: {
            display: false, // 가로 줄을 숨김
          },
          ticks: {
              display: false, // Y 축 레이블을 숨김
            },
        }
      },
      plugins: {
          legend: {
            position: 'bottom', // 범례를 오른쪽에 표시
            align: 'center', // 범례 내용을 가운데 정렬
          }
        }
    }
  });

  myChartArray.push(myChart); // myChart를 배열에 추가하여 나중에 참조할 수 있도록 함
}






</script>


<script>

function aaa(a, statCount){
	
	console.log("a",a)
	
	const inputElement = document.getElementsByName('rsCt');
	inputElement[statCount-1].value = a;
}







//목록이동
function goList(){
	window.location.href = '/servey/serveyListEmployee';
}


//날자 짜르기
var bgngDtData = `${data.bgngDt}`;
var endDtData = `${data.endDt}`;
//console.log(bgngDtData)
bgngDtData = bgngDtData.substring(0, 10);
endDtData = endDtData.substring(0, 10);

var serveyDateElement = document.getElementById('serveyDate');
serveyDateElement.textContent = bgngDtData + '  ~  ' + endDtData;


</script>				
							
							

		
						