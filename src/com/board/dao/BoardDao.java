package com.board.dao;

import java.sql.*;
import java.util.ArrayList;

import com.board.beans.Board;

public class BoardDao extends CommonDao{
	public static BoardDao getInstance() {
		BoardDao _instance = new BoardDao();
		_instance.SetDB();
		return _instance;
	}
	
	public ArrayList<Board> getArticleList() throws SQLException {
		
		ArrayList<Board> articleList = null; //BoardÇü ArrayList ¼±¾ð
		articleList = (ArrayList<Board>)GetDB().queryForList("getArticleList", null);
	    
	    return articleList;		
	}

	public void insertArticle(String title, String writer, String content) throws SQLException {
		Board article = new Board();
		article.setTitle(title);
		article.setWriter(writer);
		article.setContent(content);
		
		GetDB().insert("insertArticle", article);

	}
	
	public void deleteArticle(int idx) throws SQLException {
		GetDB().delete("deleteArticle", idx);
	}

	public Board getContentArticle(int idx) throws SQLException {
		Board article = new Board();
		article = (Board)GetDB().queryForObject("getContentArticle", idx);

		return article;
	}


}
