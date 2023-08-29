<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/nstyle.css" />
</head>
<body>
<h2>content_view.jsp</h2>
<table>
	<form action="content_update" method="post">
	<input type="hidden" name="bid" value="${content_view.bid }" />
		<tr>
			<td class="left">번호</td>
			<td>${content_view.bid }</td>
		</tr>
		<tr>
			<td class="left">히트</td>
			<td>${content_view.bhit }</td>
		</tr>
		<tr>
			<td class="left">이름</td>
			<td>${content_view.bname }</td>
		</tr>
		<tr>
			<td class="left">제목</td>
			<td>${content_view.btitle }</td>
		</tr>
		<tr>
			<td class="left">내용</td>
			<td>${content_view.bcontent }</td>
		</tr>
		<tr>
			<td class="left">첨부</td>
			<td>
				<%-- <a href="download?p=resources/upload/&f=${content_view.filesrc }
				&bid=${content_view.bid }">${content_view.filesrc }</a>	 --%>
				<c:forEach items="${imglist }" var="imgdto">
					<a href="download?p=resources/upload/&f=${imgdto.rebchgfile }&bid=${content_view.bid }">${imgdto.rebchgfile }</a><br>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정" /> &nbsp;&nbsp;
				<a href="list">목록보기</a> &nbsp;&nbsp;
				<a href="delete?bid=${content_view.bid }">삭제</a>&nbsp;&nbsp;
				<a href="reply_view?bid=${content_view.bid }">답변</a>&nbsp;&nbsp;
			</td>
		</tr>
	</form>

</table>
<hr />
<c:set value="${content_view.filesrc }" var="filename" />
<c:set var="fileNm" value="${fn:toLowerCase(filename)}" />
<c:forTokens var="token" items="${fileNm}" delims="." varStatus="status">
 <c:if test="${status.last}">
   <c:choose>
    <c:when test="${token eq 'jpg'}">
     ${filename}::::그림파일 jpg <br />
     ${status.last}
     <div>
		<img border="1" width="100" height="100" 
		src="resources/upload/${content_view.filesrc }" alt="" />
	</div>
    </c:when>
    <c:when test="${token eq 'xsl' || token eq 'xlsx'}">
     ${filename}::::엑셀파일
    </c:when>
    <c:when test="${token eq 'jpg' || token eq 'png' || token eq 'bmp' }">
     ${filename}::::이미지파일
    </c:when>
   </c:choose>
  </c:if>
	
</c:forTokens>


<%-- <c:if test="${content_view.filesrc ne null}">
	<div>
		<img border="1" width="100" height="100" 
		src="resources/upload/${content_view.filesrc }" alt="" />
	</div>
</c:if> --%>


</body>
</html>