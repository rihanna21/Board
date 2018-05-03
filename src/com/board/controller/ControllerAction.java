package com.board.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ControllerAction extends HttpServlet {
	private Map commandMap = new HashMap(); // 명령어와 명령어 처리 클래스를 저장
	
	//properties 파일을 불러온다.
	public void init(ServletConfig config) throws ServletException{
		loadProperties("com/board/properties/Command");
	}
	
	//properties 파일에서 가져온 맵핑정보의 패키지정보를 바탕으로 클래스화 시킨 후, 리소스 번들 객체에 저장한다.
	private void loadProperties(String path) {
		ResourceBundle rbHome = ResourceBundle.getBundle(path); //실행할 path를 rb에 저장
		
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		
		while(actionEnumHome.hasMoreElements())
		{
			String command = actionEnumHome.nextElement(); // 명령어
			String className = rbHome.getString(command);  // 명령어 처리 클래스
			
			try {
				Class commandClass = Class.forName(className); // 해당 명령어 처리 클래스네임 문자열을 클래스로 만듬.
				Object commandInstance = commandClass.newInstance(); // 해당 클래스의 객체 생성 
				
				commandMap.put(command, commandInstance); // Map에 명령어, 명령어 처리 클래스 객체를 저장
			} catch(ClassNotFoundException e) {
				continue;
			} catch(InstantiationException e) {
				e.printStackTrace();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	// get방식과 post방식을 requestPro로 처리
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);
	}
	
	// 사용자 요청을 분석해서 해당 작업을 처리
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI(); //사용자 요청 URL
			
			if(command.indexOf(request.getContextPath()) == 0)
			{
				command = command.substring(request.getContextPath().length());
			}
			
			com = (CommandAction)commandMap.get(command); // 사용자 요청에 해당하는 action 
			
			if(com == null)
			{
				System.out.println("not found : " + command);
				return;
			}
			
			view = com.requestPro(request, response); // action 객체 실행
			
			if(view == null) {
				return;
			}
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		
		if(view == null)
			return;
		
		//view에서 필요한 데이터를 jsp로 보내면서 view에 반환
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}


