package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/login")
	public String login() {
		System.out.println("LoginController login Method Called...");
		return "WEB-INF/views/loginsuccess.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		System.out.println("LoginController login Method Called...");
		return "WEB-INF/views/logoutsuccess.jsp";
	}
}
