package com.bit.log01.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController01 {
	/**
	 * Logger 생성 (Console)
	 */
	private static final Log LOG
		= LogFactory.getLog(LogController01.class);
	
	@RequestMapping("/ex01")
	@ResponseBody
	public String ex01() {
		/*
		 	logback.xml에서,
		 	
		 	root loger의 level="DEBUG"
		 	DEBUG > INFO > WARN > ERROR 순으로 로그 출력
		 	
		 	level="WARN"
		 	WARN > ERROR 메소드의 로그 메시지만 출력
		 */
		LOG.debug("#ex01 - debug log");
		LOG.info("#ex01 - info log");
		LOG.warn("#ex01 - warn log");
		LOG.error("#ex01 - error log");
		
		return "Logback Logging Ex01";
	}
}
