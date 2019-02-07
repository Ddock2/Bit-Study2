package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			String uri = request.getRequestURI();	// /mvc-web/list.do
			String context = request.getContextPath();	// /mvc-web
			
			uri = uri.substring(context.length());	//	/list.do
			
			Controller controller = null;
			switch(uri) {
				case "/list.do" :
					System.out.println("글 목록 선택");
					controller = new ListController();
					break;
				case "/write.do" :
					System.out.println("글 등록 선택");
					controller = new WriteController();
					break;
			}
			
			String pageCall = controller.handleRequest(request, response);	// 실제 파일(.jsp)의 경로 반환받음(확장자 포함)
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(pageCall);
			dispatcher.forward(request, response);	// list.jsp로 forward (영역을 공유)
			// /board/list.jsp로 forward(영역을 공유)
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
