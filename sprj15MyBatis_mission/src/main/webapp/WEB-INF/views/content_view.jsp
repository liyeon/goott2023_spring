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
	<h1>글 상세</h1>
	<table>
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<caption>DETAIL</caption>
		<tbody>
			<tr>
				<th>글번호</th>
				<td>${dto.brd_id }</td>
				<th>조회수</th>
				<td>${dto.brd_hit }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${dto.brd_name }</td>
				<th>작성시간</th>
				<td>${dto.brd_date }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3" class="left">${dto.brd_title }</td>
			</tr>

			<tr id="content">
				<th>내용</th>
				<td colspan="3" class="left"><pre>${dto.brd_content }</pre></td>
			</tr>
		</tbody>
	</table>
	<div class="a_wrap">
		<a href="content_update?bid=${dto.brd_id }">수정</a>
		<a href="delete?bid=${dto.brd_id }">삭제</a>
		<a href="./list">목록</a>
		<a href="reply_view?bid=${dto.brd_id }">답변</a>
	</div>
</body>