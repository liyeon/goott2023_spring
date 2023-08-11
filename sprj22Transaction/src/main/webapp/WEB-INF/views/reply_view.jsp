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
		<input type="hidden" name="bid" value="${dto.bid }" />
		<input type="hidden" name="bgroup" value="${dto.bgroup }" />
		<input type="hidden" name="bstep" value="${dto.bstep }" />
		<input type="hidden" name="bindent" value="${dto.bindent }" />
		<label for="bname">이름</label>
		<input type="text" name="bname" value="${dto.bname }"/>
		<label for="btitle">제목</label>
		<input type="text" name="btitle" value="${dto.btitle }"/>
		<label for="bcontent">내용</label>
		<textarea name="bcontent" id="bcontent">${dto.bcontent }</textarea>
		<div class="btn_wrap">
			<input type="submit" value="답변 입력" />
			<a href="list" class="cancel" style="line-height:49px;">목록</a>
		</div>
		
	</form>
</body>