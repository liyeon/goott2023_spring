<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
<link rel="stylesheet" href="./resources/css/style.css" />
</head>
<body>
	<h1>글을 써보자</h1>
	<form action="write" method="POST">
		<label for="brd_name">이름</label>
		<input type="text" name="brd_name" value="작성자"/>
		<label for="brd_title">제목</label>
		<input type="text" name="brd_title" value="글제목"/>
		<label for="brd_content">내용</label>
		<textarea name="brd_content" id="brd_content">내용</textarea>
		<div class="btn_wrap">
			<input type="submit" value="입력" />
			<a href="list" class="cancel" style="line-height:49px;">목록</a>
		</div>
		
	</form>
</body>