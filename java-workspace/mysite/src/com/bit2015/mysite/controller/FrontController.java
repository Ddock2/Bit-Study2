package com.bit2015.mysite.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String uri = request.getRequestURI();
			String contextPath = request.getContextPath();
			
			uri = uri.substring(contextPath.length());
			
			Controller controller = null;
			switch(uri) {
				case "/user":
					controller = new UserController();
					break;
			}
			
			String target = controller.handleRequest(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(target);
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
