<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스스트</title>
<link rel="stylesheet" href="./resources/css/style.css" />
</head>
<body>
	<h1>리슷트트</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.bid }</td>
				<td>${dto.bname }</td>
				<td><a href="content_view?bid=${dto.bid }">${dto.btitle }</a></td>
				<td>${dto.bdate }</td>
				<td>${dto.bhit }</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="5" class="right">
					<a href="write_view">글쓰기</a>
				</td>
			</tr>
		</tbody>
	</table>
</body>