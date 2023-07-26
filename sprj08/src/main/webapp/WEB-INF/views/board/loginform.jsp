<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
</head>
<body>
	<form action="./confirm" method="post">
        <input type="text"  name="id" placeholder="아이디" >
        <input type="password" name="pwd" placeholder="비밀번호">
        <input type="submit" value="로그인">
    </form>
</body>
</html>