package com.board.action;

import java.sql.*;

import javax.servlet.http.*;

import com.board.controller.CommandAction;
import com.board.dao.BoardDao;

public class InsertAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String regip = request.getRemoteAddr();
/* 
 * write.jsp 에서 javascript로 입력값 유효성 검증 기능 만들 것.

		if(title == "" ||title == null) out.println("title이 null입니다.");

		if(writer == "" ||writer == null)
		    out.println("writer가 null입니다.");   
		else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer))
		    out.println("이메일 형식이 아닙니다.");
		 
		if(content == "" ||content == null) out.println("content가 null입니다.");
 */
		BoardDao.getInstance().insertArticle(title, writer, content, regip);
		
		return "list.do";
	}

}
