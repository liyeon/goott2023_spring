<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" />
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<h3>jobgraph.jsp</h3>
<div class="container">
	<div class="row">
		<div class="col-md-6">
			<canvas width="400" height="400" id="myChartOne"></canvas>
		</div>	
		<div class="col-md-6">
			<canvas width="400" height="400" id="myChartTwo"></canvas>
		</div>	
		<div class="col-md-6">
			<canvas width="400" height="400" id="myChartThree"></canvas>
		</div>	
	</div>
</div>
<hr />
${arr }
<script>
var jArray=new Array();
jArray='${arr}';
/*파싱*/
jArray=JSON.parse(jArray);
//alert(jArray[0].sum);

const ctx1=document.getElementById('myChartOne').getContext('2d');
const ctx2=document.getElementById('myChartTwo').getContext('2d');
const ctx3=document.getElementById('myChartThree').getContext('2d');

const myChart1=new Chart(ctx1,{
		type:'line',
		data:{
			labels:[
				jArray[0].job,
				jArray[1].job,
				jArray[2].job,
				jArray[3].job,
				jArray[4].job
				],
			datasets:[{
				label:'# 청바지매출액',
				data:[
					jArray[0].selsum,
					jArray[1].selsum,
					jArray[2].selsum,
					jArray[3].selsum,
					jArray[4].selsum
					],
				backgroundColor:[
					'rgba(255,99,132,1.0)',
					'rgba(55,99,16,0.2)',
					'rgba(10,99,13,0.2)',
					'rgba(2,99,132,0.2)',
					'#0000ff'	
				],
				borderColor:[
					'rgba(255,99,9,1)',
					'rgba(55,99,9,1)',
					'rgba(255,99,9,1)',
					'rgba(55,255,9,1)',
					'rgba(255,99,9,1)'
				],
				borderWidth:3
			}]
		},
		options:{
			scales:{
				y:{
					beginAtZero:true
				}
			}
		}
	});

const myChart2=new Chart(ctx2,{
	type:'polarArea',
	data:{
		labels:[
			jArray[0].job,
			jArray[1].job,
			jArray[2].job,
			jArray[3].job,
			jArray[4].job
			],
		datasets:[{
			label:'# 청바지매출액',
			data:[
				jArray[0].selsum,
				jArray[1].selsum,
				jArray[2].selsum,
				jArray[3].selsum,
				jArray[4].selsum
				],
			backgroundColor:[
				'rgba(255,99,132,1.0)',
				'rgba(55,99,16,0.2)',
				'rgba(10,99,13,0.2)',
				'rgba(2,99,132,0.2)',
				'#0000ff'	
			],
			borderColor:[
				'rgba(255,99,9,1)',
				'rgba(55,99,9,1)',
				'rgba(255,99,9,1)',
				'rgba(55,255,9,1)',
				'rgba(255,99,9,1)'
			],
			borderWidth:3
		}]
	},
	options:{
		scales:{
			y:{
				beginAtZero:true
			}
		}
	}
});
const myChart3=new Chart(ctx3,{
	type:'doughnut',
	data:{
		labels:[
			jArray[0].job,
			jArray[1].job,
			jArray[2].job,
			jArray[3].job,
			jArray[4].job
			],
		datasets:[{
			label:'# 청바지매출액',
			data:[
				jArray[0].selsum,
				jArray[1].selsum,
				jArray[2].selsum,
				jArray[3].selsum,
				jArray[4].selsum
				],
			backgroundColor:[
				'rgba(255,99,132,1.0)',
				'rgba(55,99,16,0.2)',
				'rgba(10,99,13,0.2)',
				'rgba(2,99,132,0.2)',
				'#0000ff'	
			],
			borderColor:[
				'rgba(255,99,9,1)',
				'rgba(55,99,9,1)',
				'rgba(255,99,9,1)',
				'rgba(55,255,9,1)',
				'rgba(255,99,9,1)'
			],
			borderWidth:3
		}]
	},
	options:{
		scales:{
			y:{
				beginAtZero:true
			}
		}
	}
});

</script>
</body>
</html>