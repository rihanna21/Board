<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<title>본격! 게시판 - 게시글 리스트</title>
</head>
<body>
	<h1>게시글 리스트</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일시</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${articleList}" var="article">
		<tr>
			<td>${article.idx}</td>
			<td><a href='content.do?idx=${article.idx}'>${article.title}</a></td>
			<td>${article.writer}</td>
			<td>${article.regdate}</td>
			<td>${article.count}</td>
		</tr>
		</c:forEach>
	</table>
	
	<c:if test="${page > 0}"> 
		<a href="list.do?page=${page-10}">이전페이지</a> 
	</c:if>
	<c:if test="${page == 0}"> 
		<a href="#">이전페이지</a> 
	</c:if>

	<fmt:parseNumber value="${page/10+1 }" type="number"  integerOnly="True" />
	
	<c:if test="${fn:length( articleList ) < 10}"> 
		<a href="#">다음페이지</a>
	</c:if>
	<c:if test="${fn:length( articleList ) == 10}"> 
		<a href="list.do?page=${page+10}">다음페이지</a>
	</c:if>

	<a href="write.jsp">글쓰기</a>
</body>
</html>