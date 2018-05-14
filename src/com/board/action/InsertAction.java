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
 * write.jsp ���� javascript�� �Է°� ��ȿ�� ���� ��� ���� ��.

		if(title == "" ||title == null) out.println("title�� null�Դϴ�.");

		if(writer == "" ||writer == null)
		    out.println("writer�� null�Դϴ�.");   
		else if(!Pattern.matches("^[_0-9a-zA-Z-]+@[0-9a-zA-Z-]+(.[_0-9a-zA-Z-]+)*$", writer))
		    out.println("�̸��� ������ �ƴմϴ�.");
		 
		if(content == "" ||content == null) out.println("content�� null�Դϴ�.");
 */
		BoardDao.getInstance().insertArticle(title, writer, content, regip);
		
		return "list.do";
	}

}
