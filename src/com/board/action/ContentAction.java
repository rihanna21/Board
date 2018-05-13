package com.board.action;

import java.sql.*;

import javax.servlet.http.*;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String idx = request.getParameter("idx");
	    Board article = BoardDao.getInstance().getContentArticle(Integer.parseInt(idx));
		request.setAttribute("article", article);

		return "content.jsp";
	}

}
