package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.server.Dispatcher;

// 모든 요청을 받아 요청에 맞는 Controller를 Mapping하는 역할
public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping mappings = null;
	
	// HandlerMapping 초기화
	@Override
	public void init(ServletConfig config) throws ServletException {
		// web.xml의<init-param>...</init-param>
		String configName = config.getInitParameter("configName");
		mappings = new HandlerMapping(configName);
	}
	
	// 요청을 받아 HandlerMapping을 통해 해당 페이지 호출
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			String uri = request.getRequestURI();		// /jboard/login.do
			String context = request.getContextPath();	// /jboard
			uri = uri.substring(context.length());		// /login.do
			
			// uri를 전달하여 실제 Controller 객체를 반환 받음
			Controller controller = mappings.getController(uri);
			
			// 해당 Controller를 통해, 실제 파일 경로를 반환 받음
			String callPage = controller.handleRequest(request, response);
			
			// Dispatcher(forward) 방식으로 페이지 이동
			RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
