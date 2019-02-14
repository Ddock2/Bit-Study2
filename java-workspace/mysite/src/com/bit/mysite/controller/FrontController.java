package com.bit.mysite.controller;

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
			request.setCharacterEncoding("UTF-8");
			String uri = request.getRequestURI();
			String contextPath = request.getContextPath() + "/controller";
			
			uri = uri.substring(contextPath.length());
//			System.out.println(uri);
			
			Controller controller = null;
			switch(uri) {
				case "/member":
					controller = new MemberController();
					break;
				case "/board":
					controller = new BoardController();
					break;
				default :
					controller = new ErrorController();
			}
			
			String target = controller.handleRequest(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(target);
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
