package com.bit.mysite.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
 	@ControllerAdvice
 		: 클래스 경로 탐색 후 예외를 캐치할 구현 클래스
 		
 	@ExceptionHandler
 		: 예외 처리 메소드에 붙어 구체화
 		
 		-> 전역 예외 처리
 */

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Log LOG
		= LogFactory.getLog(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(HttpServletRequest request, Exception e) {
		// 1. 로깅
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		LOG.error(errors.toString());
		
		// 2. 시스템 오류 화면 (유저에게 보여줄 뷰)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/exception");
		
		return mav;
	}
}
