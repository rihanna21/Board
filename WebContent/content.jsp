<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<title>����! �Խ��� - �Խñ� ����Ʈ</title>
</head>
<%
	String idx = request.getParameter("idx");

	try{
	    String url = "jdbc:postgresql:db_board";  
	    String usr = "postgres";  
	    String pwd = "new1234!";
	    
	    Class.forName("org.postgresql.Driver");
	    
	    Connection conn = DriverManager.getConnection(url, usr, pwd);
	    
	    Statement stmt = conn.createStatement();
	    String sql = "select idx, title, to_char(regdate, 'YYYY-MM-DD HH:MM:SS') as rdate, writer, content, count from tb_board where idx = " + idx;    
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    if(rs.next()){
	    	request.setAttribute("idx", rs.getString("idx"));
	    	request.setAttribute("title", rs.getString("title"));
	    	request.setAttribute("rdate", rs.getString("rdate"));
	    	request.setAttribute("writer", rs.getString("writer"));
	    	request.setAttribute("content", rs.getString("content"));
	    	request.setAttribute("count", rs.getString("count"));
		}
		conn.close();
	}catch(Exception e){
		out.println("Database Connection Something Problem. <hr>");
		out.println(e.getMessage());
		e.printStackTrace();		
	}
%>
<body>
	<h1>�Խñ� ����Ʈ</h1>
	<table>
		<tr>
			<th>��ȣ</th>
			<td>${idx}</td>
			<th>�ۼ���</th>
			<td>${writer}</td>
			<th>��¥</th>
			<td>${rdate}</td>
			<th>��ȸ��</th>
			<td>${count}</td>
		</tr>
		<tr>
			<th colspan="2">����</th>
			<td colspan="6">${title}</td>
		</tr>
		<tr>
			<th colspan="2">����</th>
			<td colspan="6">${content}</td>
		</tr>
	</table>
	<a href="delete.jsp?idx=${idx}">�Խñۻ���</a>
    <a href="list.jsp">�������</a>
</body>
</html>