package com.bit.mysite.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private static final Log LOG
		= LogFactory.getLog(MainController.class);
	
	@RequestMapping(value= {"/main", "/"})
	public String index() {
		return "main/index";
	}
	
	// 로그 테스트
	@RequestMapping("/logger")
	public String logger() {
		LOG.debug("MainController.logger Called...");
		return "Hello logger";
	}
}
