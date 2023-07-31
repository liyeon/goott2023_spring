<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<link rel="stylesheet" href="./resources/css/style.css" />
</head>
<body>
	<h1>답변</h1>
	<form action="reply" method="POST">
		<input type="hidden" name="pzid" value="${dto.pzid }" />
		<input type="hidden" name="pzgroup" value="${dto.pzgroup }" />
		<input type="hidden" name="pzstep" value="${dto.pzstep }" />
		<input type="hidden" name="pzindent" value="${dto.pzintent }" />
		<label for="pzname">이름</label>
		<input type="text" name="pzname" value="${dto.pzname }"/>
		<label for="pzsubj">제목</label>
		<input type="text" name="pzsubj" value="${dto.pzsubj }"/>
		<label for="pzcontent">내용</label>
		<textarea name="pzcontent" id="pzcontent">${dto.pzcontent }</textarea>
		<div class="btn_wrap">
			<input type="submit" value="답변 입력" />
			<a href="list" class="cancel" style="line-height:49px;">목록</a>
		</div>
		
	</form>
</body>