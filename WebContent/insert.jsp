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
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	if(title == "" ||title == null) out.println("title이 null입니다.");

	if(writer == "" ||writer == null)
	    out.println("writer가 null입니다.");   
	else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer))
	    out.println("이메일 형식이 아닙니다.");
	 
	if(content == "" ||content == null) out.println("content가 null입니다.");
	
	try{

	    String url = "jdbc:postgresql:db_board";  
	    String usr = "postgres";  
	    String pwd = "new1234!";
	    
	    Class.forName("org.postgresql.Driver");
	    
	    Connection conn = DriverManager.getConnection(url, usr, pwd);
	    
	    Statement stmt = conn.createStatement();
	    String sql = "INSERT INTO tb_board" +
	    			"(writer, title, content, count, regdate)" +
	    			"VALUES ('" + writer + "', '"+ title +"', '" + content + "', " + 0 + ", CURRENT_TIMESTAMP)";    
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
<body>

</body>
</html>