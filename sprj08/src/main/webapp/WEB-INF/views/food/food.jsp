<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한국음식</title>
</head>
<body>
	<h1>음식전달</h1>
	<form action="./kfood" >
		한국음식1 : <input type="text" name="k1" />
		한국음식2 : <input type="text" name="k2" />
		<input type="submit" value="한국음식 전달" />
	</form>
	<form action="./wfood">
		외국음식1 : <input type="text" name="w1" />
		외국음식2 : <input type="text" name="w2" />
		<input type="submit" value="외국음식 전달" />
	</form>
</body>
</html>