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
		<label for="bname">이름</label>
		<input type="text" name="bname" value="작성자"/>
		<label for="btitle">제목</label>
		<input type="text" name="btitle" value="글제목"/>
		<label for="bcontent">내용</label>
		<textarea name="bcontent" id="bcontent">내용</textarea>
		<div class="btn_wrap">
			<input type="submit" value="입력" />
			<a href="list" class="cancel" style="line-height:49px;">목록</a>
		</div>
		
	</form>
</body>