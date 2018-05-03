package com.board.action;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.*;

import com.board.beans.Board;
import com.board.controller.CommandAction;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		try{
		    String url = "jdbc:postgresql:db_board";  
		    String usr = "postgres";  
		    String pwd = "new1234!";
		    
		    Class.forName("org.postgresql.Driver");
		    
		    Connection conn = DriverManager.getConnection(url, usr, pwd);
		    
		    Statement stmt = conn.createStatement();
		    String sql = "select *, to_char(regdate, 'YYYY-MM-DD HH:MM:SS') as rdate from tb_board order by idx desc";    
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    ArrayList<Board> articleList = new ArrayList<Board>(); //Board형 ArrayList 선언
		    
		    while(rs.next()){
		    	Board article = new Board(); // Board bean 클래스 객체 생성
		    	article.setIdx(rs.getInt("idx"));
		    	article.setTitle(rs.getString("title"));
		    	article.setWriter(rs.getString("writer"));
		    	article.setRdate(rs.getString("rdate"));
		    	article.setCount(rs.getInt("count"));
		    	
		    	articleList.add(article); // 셋팅된 Board bean을 ArrayList에 추가
		    }
		    
		    request.setAttribute("articleList", articleList); // 셋팅된 List를 view에 포워드
		    
			conn.close();
		}catch(Exception e){
			System.out.println("Database Connection Something Problem. <hr>");
			System.out.println(e.getMessage());
			e.printStackTrace();		
		}
		
		return "list.jsp";
	}

}
