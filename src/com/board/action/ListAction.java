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
		    
		    ArrayList<Board> articleList = new ArrayList<Board>(); //Board�� ArrayList ����
		    
		    while(rs.next()){
		    	Board article = new Board(); // Board bean Ŭ���� ��ü ����
		    	article.setIdx(rs.getInt("idx"));
		    	article.setTitle(rs.getString("title"));
		    	article.setWriter(rs.getString("writer"));
		    	article.setRdate(rs.getString("rdate"));
		    	article.setCount(rs.getInt("count"));
		    	
		    	articleList.add(article); // ���õ� Board bean�� ArrayList�� �߰�
		    }
		    
		    request.setAttribute("articleList", articleList); // ���õ� List�� view�� ������
		    
			conn.close();
		}catch(Exception e){
			System.out.println("Database Connection Something Problem. <hr>");
			System.out.println(e.getMessage());
			e.printStackTrace();		
		}
		
		return "list.jsp";
	}

}
