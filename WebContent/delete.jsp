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
		out.println("db 접속에 오류가 있습니다.");
		out.println(e.getMessage());
		e.printStackTrace();
	}finally{
		out.print("<script>location.href='list.jsp';</script>");
	}
%>
<script>
    alert("게시글이 삭제되었습니다");  // 게시글이 삭제되었다는 경고창을 띄워주고
    location.href="list.jsp";          // 리스트페이지로 이동합니다.
</script>
<body>
</body>
</html>