<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<title>����! �Խ��� - �Խñ� ����Ʈ</title>
</head>
<body>
	<h1>�Խñ� ����Ʈ</h1>
	<table>
		<tr>
			<th>��ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
			<th>��¥</th>
			<th>��ȸ��</th>
		</tr>
		<c:forEach items="${articleList}" var="article">
		<tr>
			<td>${article.idx}</td>
			<td><a href='content.do?idx=${article.idx}'>${article.title}</a></td>
			<td>${article.writer}</td>
			<td>${article.rdate}</td>
			<td>${article.count}</td>
		</tr>
		</c:forEach>
	</table>
	<a href="write.jsp">�۾���</a>
</body>
</html>