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
			<tr>
				<td>${dto.pzid }</td>
				<td>${dto.pzname }</td>
				<td class="left">
					<c:set value="${dto.pzintent }" var="endindent" />
					<c:forEach begin="1" end="${dto.pzintent }" var="cnt">
					&nbsp;
						<c:if test="${cnt eq endindent }">
							<img src="./resources/comments-solid.svg" alt="" width="15"/>&nbsp;
						</c:if>
					</c:forEach>
					<a href="content_view?pzid=${dto.pzid }">${dto.pzsubj }</a>
				</td>
				<td>${dto.pzdate }</td>
				<td>${dto.pzhit }</td>
				<td>${dto.pzgroup }</td>
				<td>${dto.pzintent }</td>
				<td>${dto.pzstep }</td>
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