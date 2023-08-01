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
<body style="height:auto;max-height:max-content;padding:100px 0">
	<h1 style="width:1000px;">리슷트트</h1>
	<table style="width:1000px;">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>group</th>
				<th>step</th>
				<th>indent</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="dto">
			<tr class="left">
				<td>${dto.bid }</td>
				<td>${dto.bname }</td>
				<td>
					<c:set value="${dto.bindent }" var="endindent" />
					<c:forEach begin="1" end="${dto.bindent }" var="cnt">
					&nbsp;
						<c:if test="${cnt eq endindent }">
							<img src="./resources/comments-solid.svg" alt="" width="15"/>&nbsp;
						</c:if>
					</c:forEach>
					<a href="content_view?bid=${dto.bid }">${dto.btitle }</a>
				</td>
				<td>${dto.bdate }</td>
				<td>${dto.bhit }</td>
				<td>${dto.bgroup }</td>
				<td>${dto.bindent }</td>
				<td>${dto.bstep }</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="8" class="right">
					<a href="write_view">글쓰기</a>
				</td>
			</tr>
		</tbody>
	</table>
</body>