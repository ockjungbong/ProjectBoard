package com.board.controller;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.RequestProcessingPolicy;

public class ControllerAction extends HttpServlet{
	private Map commandMap = new HashMap();  // 명령어와 명령어 처리 클랫를 쌍으로 저장
	public void init(ServletConfig config) throws SecurityException{
		// Common properties
		loadProperties("com/board/properties/Command");
	}
	// properties 설정
	private void loadProperties(String path){
		ResourceBundle rbHome = ResourceBundle.getBundle(path);  // 누구를 실행할지를 rb에 저장
		
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		while(actionEnumHome.hasMoreElements()){
			
			String command = actionEnumHome.nextElement();
			String className = rbHome.getString(command);
			System.out.println("command : " + command);
			System.out.println("className :" + className);
			
			try{
				Class commandClass = Class.forName(className);            // 해당 문자열을 클래스로 만든다
				
				Object commandInstance = commandClass.newInstance();  //  해당 클래스의 객체를 생성
				commandMap.put(command, commandInstance);            //   Map 객체인 commandMap에 객체 저장
				
				System.out.println("commandClass : " + commandClass);
				System.out.println("commandInstance " + commandInstance);
				System.out.println();
				
			}catch(ClassNotFoundException e){
				continue; // error
				// throw new ServletException(e);
			}catch(InstantiationException e){
				e.printStackTrace();
			}catch(IllegalAccessException e){
				e.printStackTrace();
			}
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);  // get 방식과 post 방식을 모두 requestPro 로 처리
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestPro(request, response);
	}
	// 사용자의 요청을 분석해서 해당 작업을 처리
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String view = null;
		CommandAction com = null;
		try{
			String command = request.getRequestURI();
			System.out.println("URI : "+ command);
			if(command.indexOf(request.getContextPath()) == 0){
				command = command.substring(request.getContextPath().length());
				//System.out.println(command);
			}
					
			com = (CommandAction) commandMap.get(command);
			System.out.println("object : "+com);
			if (com == null) {				 
                System.out.println("not found : " + command); 
                return; 
            } 
            
			view = com.requestPro(request, response); 
			System.out.println("화면 : " + view);
			System.out.println();
            if (view == null) { 
                return; 
            }			
		}catch(Throwable e){
			throw new ServletException(e);
		}
		if (view == null)
			 
            return;
 
        RequestDispatcher dispatcher = request.getRequestDispatcher(view); 
        dispatcher.forward(request, response); 
	}
	
	
}
