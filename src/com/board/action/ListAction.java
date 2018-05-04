package com.board.action;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.*;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		ArrayList<Board> articleList = BoardDao.getInstance().getArticleList();
		request.setAttribute("articleList", articleList); // ���õ� List�� view�� ������
		    
		return "list.jsp";
	}

}