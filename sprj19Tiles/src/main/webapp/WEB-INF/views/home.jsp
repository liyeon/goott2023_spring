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
	font-family: 'HakgyoansimWoojuR';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2307-2@1.0/HakgyoansimWoojuR.woff2')
		format('woff2');
	font-weight: normal;
	font-style: normal;
}

* {
	font-family: 'HakgyoansimWoojuR';
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
			<a class="navbar-brand" href="#">Project19 TILES</a>
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
					<img src="https://source.unsplash.com/1600x900/?lovely-cat"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">메인1</h5>
						<h6 class="card-subtitle mb-2 text-muted">Tiles</h6>
						<p class="card-text"></p>
						<a href="main1" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?cutecat"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">메인2</h5>
						<h6 class="card-subtitle mb-2 text-muted">Tiles</h6>
						<p class="card-text"></p>
						<a href="main2" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?cat"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">메인3</h5>
						<h6 class="card-subtitle mb-2 text-muted">Tiles</h6>
						<p class="card-text"></p>
						<a href="main3" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
		</div>
		<!-- row -->
		<div class="row">
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?kawai-cat"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">board.list</h5>
						<h6 class="card-subtitle mb-2 text-muted">Tiles</h6>
						<p class="card-text">와일드카드..?</p>
						<a href="board.list" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?happy-cat"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">board.detail</h5>
						<h6 class="card-subtitle mb-2 text-muted">Tiles</h6>
						<p class="card-text">와일드카드..?</p>
						<a href="board.detail" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
			<div class="col-md-4 mb-4">
				<div class="card">
					<img src="https://source.unsplash.com/1600x900/?cute-dog"
						class="card-img-top" alt="">
					<div class="card-body">
						<h5 class="card-title">notice</h5>
						<h6 class="card-subtitle mb-2 text-muted">Tiles</h6>
						<p class="card-text">와일드카드 미션</p>
						<a href="notice.list" class="card-link stretched-link"></a>
					</div>
				</div>
			</div>
		</div><!-- row -->
	</div>
	<!-- container -->
	<footer class="footer">
		<div class="container">&copy; 2023 liyeon. All rights reserved.
		</div>
	</footer>
</body>
</html>
