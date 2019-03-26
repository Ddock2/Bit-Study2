package com.bit.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit.mysite.service.UserService;
import com.bit.mysite.vo.UserVO;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println("Login preHandle Called...");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Web Application Context
		ApplicationContext ac
			= WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		// Container 안에 있는 UserService Bean 받아오기
		UserService userService = ac.getBean(UserService.class);
		
		// Database에서 해당 UserVO 받아오기
		UserVO userVO = userService.login(email, password);
		
		// 이메일과 패스워드가 일치하지 않는 경우
		if(userVO == null) {
			response.sendRedirect(request.getContextPath() + "/user/loginform?result=fail");
			return false;
		}
		
		// 인증 처리
		HttpSession session = request.getSession(true);
		userVO.setEmail(email);
		session.setAttribute("authUser", userVO);
		response.sendRedirect(request.getContextPath());
		
		return false;
	}
	
}
