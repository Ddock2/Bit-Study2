package com.bit.jgame.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.jgame.service.MemberService;

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
				case "/game":
					controller = new GameController();
					break;
				case "/ajaxProcess":
					if(ajaxProcess(request, response))
						break;
				default :
					controller = new ErrorController();
			}
			
			if(controller != null) {
				String target = controller.handleRequest(request, response);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(target);
				dispatcher.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//----------------------------------------------------------------------------------------------------------------------------
	// Ajax로 요청된 데이터 처리
	private boolean ajaxProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String paramA = request.getParameter("a");
		boolean result = true;
		
		switch(paramA) {
			case "checkID" :
				checkID(request, response);
				break;
			default :
				result = false;
		}
		
		return result;
	}
	
	private void checkID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		MemberService service = new MemberService();
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		out.print(service.checkID(request, response));
	}
}
