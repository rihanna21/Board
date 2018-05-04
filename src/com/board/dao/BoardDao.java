package com.board.dao;

import java.sql.*;
import java.util.ArrayList;

import com.board.beans.Board;

public class BoardDao extends CommonDao{
	public static BoardDao getInstance() {
		BoardDao _instance = new BoardDao();
		return _instance;
	}
	
	public ArrayList<Board> getArticleList() throws SQLException {
		ResultSet rs = null;
		String sql = "select *, to_char(regdate, 'YYYY-MM-DD HH:MM:SS') as rdate from tb_board order by idx desc";
		rs = openConnection().executeQuery(sql); // DB connection�� ���� ������ ����
		
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
	    
	    closeConnection();
	    
	    return articleList;		
	}
	
	public void insertArticle(String title, String writer, String content) throws SQLException {
		String sql = "INSERT INTO tb_board" + "(writer, title, content, count, regdate)" + "VALUES ('" + writer + "', '"+ title +"', '" + content + "', " + 0 + ", CURRENT_TIMESTAMP)";
		openConnection().executeUpdate(sql); // DB connection�� ���� ������ ����
		
		closeConnection();		
	}
	
	public void deleteArticle(String idx) throws SQLException {
		String sql = "delete from tb_board where idx = " + idx ;
		openConnection().executeUpdate(sql);
		
		closeConnection();
	}
	
	public Board getContentArticle(String idx) throws SQLException {
		ResultSet rs = null;
		String sql = "select idx, title, to_char(regdate, 'YYYY-MM-DD HH:MM:SS') as rdate, writer, content, count from tb_board where idx = " + idx;
		rs = openConnection().executeQuery(sql);
		
		Board article = new Board();
	    
	    if(rs.next()){		    	
	    	article.setIdx(rs.getInt("idx"));
	    	article.setTitle(rs.getString("title"));
	    	article.setRdate(rs.getString("rdate"));
	    	article.setWriter(rs.getString("writer"));
	    	article.setContent(rs.getString("content"));
	    	article.setCount(rs.getInt("count"));
	    }
	    
	    return article;
	}

}
