<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차트</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	media="all" />
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
	<div class="container">
		<h1>graph2</h1>
		<div class="row">
			<div class="col-md-4">
				<canvas id="myChart1" height="300"></canvas>
			</div>
			<div class="col-md-4">
				<canvas id="myChart2"></canvas>
			</div>
			<div class="col-md-4">
				<canvas id="myChart3"></canvas>
			</div>
		</div>
	</div>

	<script>
		const ctx1 = document.getElementById('myChart1').getContext('2d');
		const ctx2 = document.getElementById('myChart2').getContext('2d');
		const ctx3 = document.getElementById('myChart3').getContext('2d');
		const myChart1 = new Chart(ctx1, {
			type : 'line',
			data : {
				labels : [ 'aa1', 'aa2', 'aa3', 'aa4', 'aa5' ],
				datasets : [ {
					label : '# 청바지 매출액',
					data : [ 10, 100, 100, 200, 1000 ],
					backgroundColor : [ 'rgba(255,99,132,1.0)', '#FBFFB9',
							'#D499B9', '#EC7357', '#7200da' ],
					borderColor : [ 'rgba(255,200,132,1.0)', '#80d4f6',
							'#bd1550', '#cbe86b', '#6a60a9' ],
					borderWidth : 3
				} ]
			//datasets
			},//data
			options : {
				scales : {
					y : {
						beginAtZero : true
					}
				}
			//scales
			}
		//options
		});//chart
		
		const myChart2 = new Chart(ctx2, {
			type : 'polarArea',
			data : {
				labels : [ 'aa1', 'aa2', 'aa3', 'aa4', 'aa5' ],
				datasets : [ {
					label : '# 청바지 매출액',
					data : [ 50, 200, 100, 450, 500 ],
					backgroundColor : [ 'rgba(255,99,132,1.0)', '#FBFFB9',
							'#D499B9', '#EC7357', '#7200da' ],
					borderColor : [ 'rgba(255,200,132,1.0)', '#80d4f6',
							'#bd1550', '#cbe86b', '#6a60a9' ],
					borderWidth : 3
				} ]
			//datasets
			},//data
			options : {
				scales : {
					y : {
						beginAtZero : true
					}
				}
			//scales
			}
		//options
		});//chart
		
		const myChart3 = new Chart(ctx3, {
			type : 'doughnut',
			data : {
				labels : [ 'aa1', 'aa2', 'aa3', 'aa4', 'aa5' ],
				datasets : [ {
					label : '# 청바지 매출액',
					data : [ 50, 200, 100, 450, 500 ],
					backgroundColor : [ 'rgba(255,99,132,1.0)', '#FBFFB9',
							'#D499B9', '#EC7357', '#7200da' ],
					borderColor : [ 'rgba(255,200,132,1.0)', '#80d4f6',
							'#bd1550', '#cbe86b', '#6a60a9' ],
					borderWidth : 3
				} ]
			//datasets
			},//data
			options : {
				scales : {
					y : {
						beginAtZero : true
					}
				}
			//scales
			}
		//options
		});//chart
	</script>
</body>
</html>