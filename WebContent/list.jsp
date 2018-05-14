<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<th>����Ͻ�</th>
			<th>��ȸ��</th>
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
		<a href="list.do?page=${page-10}">����������</a> 
	</c:if>
	<c:if test="${page == 0}"> 
		<a href="#">����������</a> 
	</c:if>

	<fmt:parseNumber value="${page/10+1 }" type="number"  integerOnly="True" />
	
	<c:if test="${fn:length( articleList ) < 10}"> 
		<a href="#">����������</a>
	</c:if>
	<c:if test="${fn:length( articleList ) == 10}"> 
		<a href="list.do?page=${page+10}">����������</a>
	</c:if>

	<a href="write.jsp">�۾���</a>
</body>
</html>