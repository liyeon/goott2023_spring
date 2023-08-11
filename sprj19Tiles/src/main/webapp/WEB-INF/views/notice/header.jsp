<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>header</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">타일즈 노티쓰으으으으ㅡㅇ</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="">Home</a></li>
					<li class="nav-item active"><a class="nav-link" href="notice.list">list</a></li>
					<li class="nav-item active"><a class="nav-link" href="notice.detail">detail</a></li>
					<li class="nav-item active"><a class="nav-link" href="notice.edit">edit</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>