package com.board.action;

import java.sql.*;

import javax.servlet.http.*;

import com.board.controller.CommandAction;

public class InsertAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
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
			System.out.println("db 접속에 오류가 있습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return "list.do";
	}

}
