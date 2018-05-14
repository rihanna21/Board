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
		int page = 0;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ArrayList<Board> articleList = BoardDao.getInstance().getArticleList(page);
		request.setAttribute("articleList", articleList); // 셋팅된 List를 view에 포워드
		request.setAttribute("page", page);
		    
		return "list.jsp";
	}

}