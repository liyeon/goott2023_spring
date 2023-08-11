<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>edit</h1>
	<form>
		<div class="form-group">
			<label for="title">제목:</label> <input type="text"
				class="form-control" id="title" placeholder="제목을 입력하세요">
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" id="content" rows="22"
				placeholder="내용을 입력하세요"></textarea>
		</div>
		<button type="submit" class="btn btn-danger mt-3">제출</button>
	</form>
</body>
</html>