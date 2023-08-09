<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 자바의 import 문처럼 타일즈를 사용하기 위해 반드시 추가해야한다-->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<div id="container">
		<header id="header">
		<!-- tiles_member.xml의 <defintion>의 하위 태그인
				<put-attribute>태그의 name이 header인 JSP를 표시하겠다 -->
			<tiles:insertAttribute name="header" />
		</header>
		<aside id="sidebar-left">
			<tiles:insertAttribute name="side" />
		</aside>
		<article id="content">
			<tiles:insertAttribute name="body" />
		</article>
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>
</html>