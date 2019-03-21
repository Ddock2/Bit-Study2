package com.bit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor01 implements HandlerInterceptor{
	// preHandle() : Controller로 요청이 들어가기 전에 수행
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2)
			throws Exception {
		System.out.println("MyInterceptor.preHandle Called...");
		return true;
	}
	
	// postHandle() : Controller 수행 후, 화면 응답 전에 수행
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			ModelAndView arg3) throws Exception {
		System.out.println("MyInterceptor.postHandle Called...");
	}
	
	// afterCompletion() : Controller 수행 후, 화면 응답 후에 수행 (전부 완료)
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("MyInterceptor.afterCompletion Called...");
	}
	
}
