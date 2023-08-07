<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<link rel="stylesheet" href="./resources/css/style.css" />
</head>
<body>
	<h1>글을 수정해보자</h1>
	<form action="modify" method="POST">
		<input type="hidden" name="brd_id" value="${dto.brd_id }"/>
		<label for="brd_name">이름</label>
		<input type="text" name="brd_name" value="${dto.brd_name }"/>
		<label for="brd_title">제목</label>
		<input type="text" name="brd_title" value="${dto.brd_title }"/>
		<label for="brd_content">내용</label>
		<textarea name="brd_content" id="bcontent">${dto.brd_content }</textarea>
		<div class="btn_wrap">
			<input type="submit" value="수정하기" />
			<a href="list" class="cancel" style="line-height:49px;">목록</a>
		</div>
		
	</form>
</body>