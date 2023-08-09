<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	media="all" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<style>
@font-face {
	font-family: 'KOTRA_BOLD-Bold';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10-21@1.1/KOTRA_BOLD-Bold.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10-21@1.1/KOTRA_BOLD-Bold.woff')
		format('woff');
	font-weight: normal;
}

* {
	font-family: 'KOTRA_BOLD-Bold';
}

.card {
	transition: all 0.2s ease-in-out;
}

.card:hover {
	transform: scale(1.05);
}

body {
	background-color: #f8f9fa;
}

.navbar {
	background-color: #6c63ff;
}

.navbar-brand {
	color: #fff;
	font-weight: bold;
}

.navbar-nav .nav-link {
	color: #fff;
}

.container {
	margin-top: 40px;
}

.footer {
	background-color: #6c63ff;
	color: #fff;
	padding: 20px 0;
	text-align: center;
	vertical-align: middle;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Project18 CHART</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="#">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Disabled</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<h1 style="color: #6c63ff;">Hello, world!</h1>
		<div class="row">
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?space"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">라인1</h5>
						<h6 class="card-subtitle mb-2 text-muted">chart.js</h6>
						<p class="card-text">chart.js 라이브러리 처음 적용</p>
						<a href="line1" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?travle"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">graph1</h5>
						<h6 class="card-subtitle mb-2 text-muted">chart.js</h6>
						<p class="card-text">chart.js PIE</p>
						<a href="graph1" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?food-drink"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">graph2</h5>
						<h6 class="card-subtitle mb-2 text-muted">chart.js</h6>
						<p class="card-text">chart.js line, polarArea, doughnut</p>
						<a href="graph2" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?street-photography"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">graph3</h5>
						<h6 class="card-subtitle mb-2 text-muted">chart.js</h6>
						<p class="card-text">
							sale2 db 테이블 접속해서 통계 내기<br>JsonArray와 JSON Object 이용
						</p>
						<a href="graph3" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?blue"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">emp</h5>
						<h6 class="card-subtitle mb-2 text-muted">chart.js</h6>
						<p class="card-text">emp db 테이블 접속해서 job 별로 salery 합계 그래프로
							표현하기</p>
						<a href="emp" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?purple"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">main1</h5>
						<h6 class="card-subtitle mb-2 text-muted">tiles</h6>
						<p class="card-text">tiles는 include의 역할과 유사하지만, include 코드
							자체까지도 (여러 번 작성하지 않도록) 집중화할 수 있도록 한다. 타일을 사용하면 작성자가 페이지 조각을 정의할 수
							있다. 이러한 조각 및 타일은 일반적인 페이지 요소의 중복을 줄이거나 다른 타일을 포함하여 재사용이 가능한 템플릿을
							개발할 때 사용할 수 있다.</p>
						<a href="main1" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
	<footer class="footer">
		<div class="container">&copy; 2023 liyeon. All rights reserved.
		</div>
	</footer>
</body>
</html>
