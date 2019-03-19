package com.bit.log01.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController {
	/**
	 * Logger 생성
	 */
	private static final Log LOG
		= LogFactory.getLog(LogController.class);
	
	@RequestMapping("/ex01")
	@ResponseBody
	public String ex01() {
		LOG.debug("#ex01 - debug log");
		LOG.info("#ex01 - info log");
		LOG.warn("#ex01 - warn log");
		LOG.error("#ex01 - error log");
		
		return "Logback Logging Ex01";
	}
}
