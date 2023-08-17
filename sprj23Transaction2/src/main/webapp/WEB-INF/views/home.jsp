<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
	String path = request.getContextPath();
%>
<html>
<head>
	<title>Home</title>
	<style>
		table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            margin: 20px auto;
            box-shadow: 0px 0px 5px -1px rgba(0, 0, 0, 0.2);
        }

        th,
        td {
            padding: 10px;
            border: 1px solid #ff9f9f;
            text-align: center;
        }

        th {
            background-color: #ffc1c1;
            color: #ffffff;
            text-shadow: rgb(255, 0, 0) 1px 0 3px;
            ;
	</style>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="list">리스트>>>>></a><br/>
<h3>디비 접속 데이터 가져오기</h3>
<a href="javascript:redeptlist()">redeptlist()</a>
<a href="javascript:reemplist()">reemplist()</a>
<a href="star">star</a>
<a href="callgetdbstar?reno=1">callgetdbstar</a>
<div id="display">
	이곳이 데이터 추가되는곳입니다.
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	function redeptlist(){
		<%-- console.log("<%=path%>") --%>
		let htmltxt = "";
		$.ajax({
			type:"post",
			url:"<%=path%>/test/deptlist",
			success:function(result){
				htmltxt=htmltxt+"<table><tr><th>deptno</th><th>dname</th><th>loc</th>";
				for ( var ele in result) {
					console.log(result[ele].loc);
					htmltxt=htmltxt+"<tr><td>"+result[ele].deptno+"</td><td>"+result[ele].dname+"</td><td>"+result[ele].loc+"</td></tr>"
				}
				htmltxt=htmltxt+"</table>";
				$("#display").html(htmltxt);
			}
		});
	}
	function reemplist(){
		<%-- console.log("<%=path%>") --%>
		let htmltxt = "";
		$.ajax({
			type:"post",
			url:"<%=path%>/test/emplist",
			success:function(result){
				htmltxt=htmltxt+"<table><tr><th>empno</th><th>ename</th><th>job</th><th>mgr</th><th>hiredate</th><th>sal</th><th>comm</th><th>deptno</th></tr>";
				for ( var ele in result) {
					console.log(result[ele].ename);
					htmltxt=htmltxt+"<tr><td>"+result[ele].empno+"</td><td>"+result[ele].ename+"</td><td>"+result[ele].job+"</td><td>"+result[ele].mgr+"</td><td>"+result[ele].hiredate+"</td><td>"+result[ele].sal+"</td><td>"+result[ele].comm+"</td><td>"+result[ele].deptno+"</td></tr>"
				}
				htmltxt=htmltxt+"</table>";
				$("#display").html(htmltxt);
			}
		});
	}
</script>
</body>
</html>
