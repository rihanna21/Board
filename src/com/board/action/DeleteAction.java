package com.board.action;

import java.sql.*;

import javax.servlet.http.*;

import com.board.controller.CommandAction;

public class DeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
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
			System.out.println("db 접속에 오류가 있습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		return "list.do";
	}

}
