<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/scriptjsp.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body onload="callpoint();">

	<script>
		function callpoint() {
			console.log("${dto.repoint}")
			$('#star2').css('width','${dto.repoint*10}%'); 
		}
	</script>
	<span class="star"> ★★★★★ 
		<span id="star2">★★★★★</span>
		<input type="range" value="1" step="1" min="0" max="10">
	</span>
	<p>
		${dto.review }
	</p>
</body>
</html>
