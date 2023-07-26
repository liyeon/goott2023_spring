<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>I</title>
</head>
<body>
	<h1>modelAndView2</h1>
	<h3>list</h3>
	<c:forEach items="${hobbys }" var="hobby">
		${hobby }<br>
	</c:forEach>
	<hr />
	<c:forEach items="${hobbys }" var="hobby">
		${hobby },
	</c:forEach>
	<hr />
	<c:forEach items="${hobbys }" var="hobby" varStatus="st">
		${hobby }
		<c:if test="${not st.last }">
		,
		</c:if>
	</c:forEach>
	<hr />
	
	<c:forEach var="i" begin="0" end="${hobbys.size()-1 }">
		<c:if test="${i!=hobbys.size()-1 }">
			<!-- 마지막 요소가 아니라는뜻 -->
      		${hobbys[i] },
	   </c:if>
		<c:if test="${i==hobbys.size()-1 }">
				<!-- 마지막 요소라는뜻 -->
	      ${hobbys[i] }
	   </c:if>
	</c:forEach>
	
</body>
</html>