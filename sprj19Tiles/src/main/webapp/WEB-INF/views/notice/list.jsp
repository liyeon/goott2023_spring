<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트</h1>
	<table class="table">
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
			<c:forEach begin="1" end="15" var="i">
				<tr>
					<td>${i }</td>
					<td>홍길동</td>
					<td>제목제목제목제목제목제목제목${i }</td>
					<td>2023-08-11</td>
					<td>100</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>