package com.board.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ControllerAction extends HttpServlet {
	private Map commandMap = new HashMap(); // ��ɾ�� ��ɾ� ó�� Ŭ������ ����
	
	//properties ������ �ҷ��´�.
	public void init(ServletConfig config) throws ServletException{
		loadProperties("com/board/properties/Command");
	}
	
	//properties ���Ͽ��� ������ ���������� ��Ű�������� �������� Ŭ����ȭ ��Ų ��, ���ҽ� ���� ��ü�� �����Ѵ�.
	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path); //������ path�� rb�� ����
		
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		
		while(actionEnumHome.hasMoreElements())
		{
			String command = actionEnumHome.nextElement(); // ��ɾ�
			String className = rbHome.getString(command);  // ��ɾ� ó�� Ŭ����
			
			try {
				Class commandClass = Class.forName(className); // �ش� ��ɾ� ó�� Ŭ�������� ���ڿ��� Ŭ������ ����.
				Object commandInstance = commandClass.newInstance(); // �ش� Ŭ������ ��ü ���� 
				
				commandMap.put(command, commandInstance); // Map�� ��ɾ�, ��ɾ� ó�� Ŭ���� ��ü�� ����
			} catch(ClassNotFoundException e) {
				continue;
			} catch(InstantiationException e) {
				e.printStackTrace();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	// get��İ� post����� requestPro�� ó��
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);
	}
	
	// ����� ��û�� �м��ؼ� �ش� �۾��� ó��
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI(); //����� ��û URL
			
			if(command.indexOf(request.getContextPath()) == 0)
			{
				command = command.substring(request.getContextPath().length());
			}
			
			com = (CommandAction)commandMap.get(command); // ����� ��û�� �ش��ϴ� action 
			
			if(com == null)
			{
				System.out.println("not found : " + command);
				return;
			}
			
			view = com.requestPro(request, response); // action ��ü ����
			
			if(view == null) {
				return;
			}
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		
		if(view == null)
			return;
		
		//view���� �ʿ��� �����͸� jsp�� �����鼭 view�� ��ȯ
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}


