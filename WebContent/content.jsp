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
			<td>${article.idx}</td>
			<th>�ۼ���</th>
			<td>${article.writer}</td>
			<th>��¥</th>
			<td>${article.regdate}</td>
			<th>��ȸ��</th>
			<td>${article.count}</td>
		</tr>
		<tr>
			<th colspan="2">����</th>
			<td colspan="6">${article.title}</td>
		</tr>
		<tr>
			<th colspan="2">����</th>
			<td colspan="6">${article.content}</td>
		</tr>
	</table>
	<a href="delete.do?idx=${article.idx}">�Խñۻ���</a>
    <a href="list.do">�������</a>
</body>
</html>