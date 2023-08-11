<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스스트</title>
<link rel="stylesheet" href="./resources/css/style.css" />
<script src="https://kit.fontawesome.com/183a0f8087.js" crossorigin="anonymous"></script>
</head>
<body style="height: auto; max-height: max-content; padding: 100px;">
	<h1 style="width: 1000px;">리슷트트</h1>
	<table style="width: 1000px;">
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
				<tr class="left">
					<td>${dto.bid }</td>
					<td>${dto.bname }</td>
					<td><c:set value="${dto.bindent }" var="endindent" /> <c:forEach
							begin="1" end="${dto.bindent }" var="cnt">
					&nbsp;
						<c:if test="${cnt eq endindent }">
								<img src="./resources/comments-solid.svg" alt="" width="15" />&nbsp;
						</c:if>
						</c:forEach> <a href="content_view?bid=${dto.bid }">${dto.btitle }</a></td>
					<td>${dto.bdate }</td>
					<td>${dto.bhit }</td>
					<td>${dto.bgroup }</td>
					<td>${dto.bindent }</td>
					<td>${dto.bstep }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8" class="right"><a href="write_view">글쓰기</a></td>
			</tr>
		</tbody>
	</table>
		
		
	<form action="list" method="post" style="width:1000px;">
		<div class="search-wrap">
			<p>
				전체글 : ${totRowcnt }<br />
				현재페이지/토탈페이지 : ${searchVO.page } / ${searchVO.totPage }
			</p>
			<div>
			<c:choose>
				<c:when test="${btitle }">
				<input type="checkbox" name="searchType" value="btitle" checked/>
				</c:when>
				<c:otherwise>
				<input type="checkbox" name="searchType" value="btitle"/>
				</c:otherwise>
			</c:choose>
				&nbsp;&nbsp;제목&nbsp;
			<c:choose>
				<c:when test="${bcontent }">
				<input type="checkbox" name="searchType" value="bcontent" checked/>
				</c:when>
				<c:otherwise>
				<input type="checkbox" name="searchType" value="bcontent"/>
				</c:otherwise>
			</c:choose>
				&nbsp;&nbsp;내용
				<input type="text" name="sk" style="width:150px;" maxlength="50" value="${searchKey }"/>
				<button type="submit" class="search-icon"><i class="fa-solid fa-magnifying-glass"></i></button>
			</div>
		</div>
		
		<ul class="paging">
			<!-- 13 현재페이지/토탈페이지:1/10 나타내기-->
	
			<!-- 페이징 처리 #1 
			<a href="list?page=1">1</a> -->
			<!-- #16 -->
<%-- 			<c:if test="${searchVO.page>1}">
				<li><a href="list?page=1"><i class="fa-solid fa-angles-left"></i></a></li>
				<li><a href="list?page=${searchVO.page-1 }"><i class="fa-solid fa-circle-chevron-left"></i></a></li>
			</c:if> --%>
			<c:choose>
				<c:when test="${searchVO.page>1}">
					<li><a href="list?page=1"><i class="fa-solid fa-angles-left"></i></a></li>
					<li><a href="list?page=${searchVO.page-1 }"><i class="fa-solid fa-circle-chevron-left"></i></a></li>
				</c:when>
				<c:otherwise>
					<li><i class="fa-solid fa-angles-left" style="color:#cecece"></i></li>
					<li><i class="fa-solid fa-circle-chevron-left" style="color:#cecece"></i></li>
				</c:otherwise>
			</c:choose>
			<!-- 14 -->
			<c:forEach begin="${searchVO.pageStart }" end="${searchVO.pageEnd }" var="i">
				<c:choose>
					<c:when test="${i eq searchVO.page }">
						<!-- 내가 클릭한 페이지의 숫자랑 같냐 -->
						<li><span >${i }</span></li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="list?page=${i }&sk=${searchKey }&btitle=${btitle==true?'btitle':''}&bcontent=${bcontent==true?'bcontent':''}">${i }</a>
						</li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 15 화살표 넣기 (페이지 그룹 구분)-->
<%-- 			<c:if test="${searchVO.page < searchVO.totPage}">
				<li><a href="list?page=${searchVO.page+1 }"><i class="fa-solid fa-circle-chevron-right"></i></a></li>
				<li><a href="list?page=${searchVO.totPage }"><i class="fa-solid fa-angles-right"></i></a></li>
			</c:if> --%>
			
			<c:choose>
				<c:when test="${searchVO.page < searchVO.totPage}">
					<li><a href="list?page=${searchVO.page+1 }"><i class="fa-solid fa-circle-chevron-right"></i></a></li>
					<li><a href="list?page=${searchVO.totPage }"><i class="fa-solid fa-angles-right"></i></a></li>
				</c:when>
				<c:otherwise>
					<li><i class="fa-solid fa-circle-chevron-right" style="color:#cecece"></i></li>
					<li><i class="fa-solid fa-angles-right" style="color:#cecece"></i></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</form>
</body>