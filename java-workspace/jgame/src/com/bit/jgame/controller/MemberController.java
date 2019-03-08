package com.bit.jgame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.jgame.service.MemberService;

public class MemberController implements Controller{
	MemberService service = new MemberService();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String paramA = request.getParameter("a");
		String result = "/jsp/error/error.jsp";
//		System.out.println(paramA);
		
		switch(paramA) {
			case "join" :			// 가입 페이지
				result = "/jsp/member/signUpForm.jsp";
				break;
			case "joinProcess" :	// 가입 처리
				service.joinProcess(request, response);
				result = "/jsp/member/signUpProcess.jsp";
				break;
			case "login" :			// 로그인 페이지
				result = "/jsp/member/loginForm.jsp";
				break;
			case "loginProcess" :	// 로그인 처리
				service.loginProcess(request, response);
				result = "/jsp/member/loginProcess.jsp";
				break;
			case "logoutProcess" :	// 로그아웃 처리
				service.logoutProcess(request, response);
				result = "/jsp/member/logoutProcess.jsp";
				break;
			case "mypage" :	// 로그아웃 처리
				result = "/jsp/member/mypage.jsp";
				break;
		}
		
		return result;
	}
}
