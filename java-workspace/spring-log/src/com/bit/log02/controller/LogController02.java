package com.bit.log02.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController02 {
	/**
	 * Logger 생성 (File)
	 */
	private static final Log LOG
		= LogFactory.getLog(LogController02.class);
	
	@RequestMapping("/ex02")
	@ResponseBody
	public String ex02() {
		LOG.debug("#ex02 - debug log");
		LOG.info("#ex02 - debug info");
		LOG.warn("#ex02 - debug warn");
		LOG.error("#ex02 - debug error");
		
		return "Logback Logging Ex02";
	}
}
