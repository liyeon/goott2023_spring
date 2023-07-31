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
	<form action="write" method="POST">
		<input type="hidden" name="bid" value="${dto.bid }"/>
		<label for="bname">이름</label>
		<input type="text" name="bname" value="${dto.bname }"/>
		<label for="btitle">제목</label>
		<input type="text" name="btitle" value="${dto.btitle }"/>
		<label for="bcontent">내용</label>
		<textarea name="bcontent" id="bcontent">${dto.bcontent }</textarea>
		<div class="btn_wrap">
			<input type="submit" value="수정하기" />
			<a href="list" class="cancel" style="line-height:49px;">목록</a>
		</div>
		
	</form>
</body>