package com.board.action;

import javax.servlet.http.*;

import com.board.beans.Board;
import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class CountAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int idx = Integer.parseInt(request.getParameter("idx")); // ���� ���������� �Ѿ�� idx ��
		String regip = request.getRemoteAddr();  // ���� ��ȸ�� ��û�� ������� IP
		
		Board article = BoardDao.getInstance().getContentArticle(idx); //�Խñ��� �����´�.
		
		if(!regip.equals(article.getRegip())) {
			int count = article.getCount();
			article.setCount(++count);
			
			BoardDao.getInstance().setArticleCount(article);
		}
		
		return "content.do?idx="+idx;
	}

}
