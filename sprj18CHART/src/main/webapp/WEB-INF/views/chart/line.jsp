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
</head>
<body>
	<h1>line1</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<canvas id="myChart"></canvas>
			</div>
			<div class="col-md-4">
				<canvas id="myChart2"></canvas>
			</div>
		</div>
		
	</div>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

	<script>
		const ctx = document.getElementById('myChart');

		new Chart(ctx,
				{
					type : 'bar',
					data : {
						labels : [ 'Red', 'Blue', 'Yellow', 'Green', 'Purple',
								'Orange' ],
						datasets : [ {
							label : '# of Votes',
							data : [ 12, 19, 3, 5, 2, 3 ],
							borderWidth : 5
						} ]
					},
					options : {
						scales : {
							y : {
								beginAtZero : true
							}
						}
					}
				});
		const ctx2 = document.getElementById('myChart2');

		new Chart(ctx2,
				{
					type : 'pie',
					data : {
						labels : [ 'Red', 'Blue', 'Yellow', 'Green', 'Purple',
								'Orange' ],
						datasets : [ {
							label : '# of Votes',
							data : [ 12, 19, 3, 5, 2, 3 ],
							borderWidth : 5
						} ]
					},
					options : {
						scales : {
							y : {
								beginAtZero : true
							}
						}
					}
				});
	</script>

</body>
</html>