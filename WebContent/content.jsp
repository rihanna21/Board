<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<td>${article.idx}</td>
			<th>작성자</th>
			<td>${article.writer}</td>
			<th>날짜</th>
			<td>${article.regdate}</td>
			<th>조회수</th>
			<td>${article.count}</td>
		</tr>
		<tr>
			<th colspan="2">제목</th>
			<td colspan="6">${article.title}</td>
		</tr>
		<tr>
			<th colspan="2">내용</th>
			<td colspan="6">${article.content}</td>
		</tr>
	</table>
	<a href="delete.do?idx=${article.idx}">게시글삭제</a>
    <a href="list.do">목록으로</a>
</body>
</html>