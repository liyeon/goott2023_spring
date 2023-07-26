<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="./board/loginform">로그인폼</a>
<a href="./board/student">학생폼</a>
<a href="./studentConfirm?id=abc">스튜던트컨퍼어엄:옼ㅋ[이;]</a>
<a href="./studentConfirm?id=abcd">스튜던트컨퍼어엄:엔지</a>
</body>
</html>
