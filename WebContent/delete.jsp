<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
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
	    String sql = "delete from tb_board where idx = " + idx ;
	    stmt.executeUpdate(sql);
	    conn.close();
	}catch (Exception e){
		out.println("db ���ӿ� ������ �ֽ��ϴ�.");
		out.println(e.getMessage());
		e.printStackTrace();
	}finally{
		out.print("<script>location.href='list.jsp';</script>");
	}
%>
<script>
    alert("�Խñ��� �����Ǿ����ϴ�");  // �Խñ��� �����Ǿ��ٴ� ���â�� ����ְ�
    location.href="list.jsp";          // ����Ʈ�������� �̵��մϴ�.
</script>
<body>
</body>
</html>