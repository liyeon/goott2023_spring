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
		<h1>graph1</h1>
		<div class="col-md-6">
			<canvas id="myChart"></canvas>
		</div>
	</div>
	
<script>
	const ctx = document.getElementById('myChart').getContext('2d');
	const myChart = new Chart(ctx,{
		type:'pie',
		data:{
			labels:['Red','Blue','Yellow','Green','Purple','Orange'],
			datasets:[{
				label:'# Votes',
				data:[12,9,5,50,2,3],
				backgroundColor:[
					'rgba(255,99,132,1.0)',
					'#FBFFB9',
					'#D499B9',
					'#EC7357',
					'#7200da',
					'#fdc23e'
				],
				borderColor:[
					'rgba(255,200,132,1.0)',
					'#80d4f6',
					'#bd1550',
					'#cbe86b',
					'#6a60a9',
					'#ee6e9f'
				],
				borderWidth:3
			}]//datasets
		},//data
		options:{
			scales:{
				y:{
					beginAtZero:true
				}
			}//scales
		}//options
	});//chart
</script>
</body>
</html>