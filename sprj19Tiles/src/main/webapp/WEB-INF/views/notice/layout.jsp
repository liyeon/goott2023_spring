<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 자바의 import 문처럼 타일즈를 사용하기 위해 반드시 추가해야한다-->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>use wildcard</title>
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
	background-color: #ff638e;
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
	background-color: #ff638e;
	color: #fff;
	padding: 20px 0;
	text-align: center;
	vertical-align: middle;
	margin-top : 40px;
}
.footer .container{
	margin-bottom:40px;
}
</style>
</head>
<body>
	<div id="container">
		<header id="header">
			<!-- tiles_member.xml의 <defintion>의 하위 태그인
				<put-attribute>태그의 name이 header인 JSP를 표시하겠다 -->
			<tiles:insertAttribute name="header" />
		</header>
		<article id="content" class="container">
			<tiles:insertAttribute name="content" />
		</article>
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>
</html>