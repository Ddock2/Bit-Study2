package com.bit.mysite.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.mysite.dao.MemberDAO;
import com.bit.mysite.vo.MemberVO;

public class MemberController implements Controller{
	private MemberDAO dao = new MemberDAO();
	private MemberVO memberVO = null;
	
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
				joinProcess(request, response);
				result = "/jsp/member/signUpProcess.jsp";
				break;
			case "login" :			// 로그인 페이지
				result = "/jsp/member/loginForm.jsp";
				break;
			case "loginProcess" :	// 로그인 처리
				loginProcess(request, response);
				result = "/jsp/member/loginProcess.jsp";
				break;
			case "logoutProcess" :	// 로그아웃 처리
				logoutProcess(request, response);
				result = "/jsp/member/logoutProcess.jsp";
				break;
		}
		
		return result;
	}
	
	// 가입 처리
	private void joinProcess(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		memberVO = new MemberVO(id, password, name);
		
		request.setAttribute("check", dao.join(memberVO));
	}
	
	// 로그인 처리
	private void loginProcess(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO userVO = null;
		
		memberVO = new MemberVO(id, password);
		
		if((userVO = dao.login(memberVO)) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			request.setAttribute("msg", "로그인 성공!");
		}else {
			request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않소");			
		}
	}
	
	// 로그아웃 처리
	private void logoutProcess(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
