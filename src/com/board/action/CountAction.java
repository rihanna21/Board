package com.board.action;

import javax.servlet.http.*;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class CountAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx")); // 이전 페이지에서 넘어온 idx 값
		String regip = request.getRemoteAddr();  // 현재 조회를 요청한 사용자의 IP
		
		Board article = BoardDao.getInstance().getContentArticle(idx); //게시글을 가져온다.
		
		if(!regip.equals(article.getRegip())) {
			int count = article.getCount();
			article.setCount(++count);
			
			BoardDao.getInstance().setArticleCount(article);
		}
		
		return "content.do?idx="+idx;
	}

}
