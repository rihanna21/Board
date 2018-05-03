package com.board.action;

import java.sql.*;

import javax.servlet.http.*;

import com.board.beans.Board;
import com.board.controller.CommandAction;

public class ContentAction implements CommandAction {

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
		    String sql = "select idx, title, to_char(regdate, 'YYYY-MM-DD HH:MM:SS') as rdate, writer, content, count from tb_board where idx = " + idx;    
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    Board article = new Board();
		    
		    if(rs.next()){  
				article.setIdx(rs.getInt("idx"));
				article.setTitle(rs.getString("title"));
				article.setRdate(rs.getString("rdate"));
				article.setWriter(rs.getString("writer"));
				article.setContent(rs.getString("content"));
				article.setCount(rs.getInt("count"));
		    }
		    
		    request.setAttribute("article", article);
			
			conn.close();
		}catch(Exception e){
			System.out.println("Database Connection Something Problem. <hr>");
			System.out.println(e.getMessage());
			e.printStackTrace();		
		}
		
		return "content.jsp";
	}

}
