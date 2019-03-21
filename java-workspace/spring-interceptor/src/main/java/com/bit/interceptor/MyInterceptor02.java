package com.bit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// HanlerInterceptorAdaptor Abstract Class
//	- 인터페이스는 모두 재정의해야 하기 때문에,
//	    하나만 재정의 하도록 추상 클래스 상속!
public class MyInterceptor02 extends HandlerInterceptorAdapter{
	// preHandle() : Controller로 요청이 들어가기 전에 수행
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2)
			throws Exception {
		System.out.println("MyInterceptor.preHandle Called...");
		return true;
	}
	
}
