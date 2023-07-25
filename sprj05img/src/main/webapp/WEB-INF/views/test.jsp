<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
<style>
	img{
	width:100%;}
</style>
</head>
<body>
	<h1>test</h1>
	<p>
	spring  &gt; appServlet &gt; servlet-context.xml에<br />
		<code>
			&lt;resources mapping="/images/**" location="/images/" /&gt;
		</code>
		을 추가해줘야 <br />
		./images/img2.jpg 경로를 사용할수있다.
	</p>
	<img src="./images/img2.jpg" alt=""/>
	<img src="/sprj05img/resources/img.jpg" alt="" />
</body>
</html>