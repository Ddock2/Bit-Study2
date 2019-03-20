package com.bit.log03.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController03 {
	private static final Log LOG
		= LogFactory.getLog(LogController03.class);
	
	@RequestMapping("/ex03")
	@ResponseBody
	public String ex03() {
		LOG.debug("#ex03 - debug log");
		LOG.info("#ex03 - debug info");
		LOG.warn("#ex03 - debug warn");
		LOG.error("#ex03 - debug error");
		
		return "LogBack Logging Ex03";
	}
}
