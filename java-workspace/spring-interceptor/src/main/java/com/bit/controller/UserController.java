package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.annotation.Auth;

@Controller
public class UserController {
	@RequestMapping("/login")
	public String login() {
		System.out.println("UserController login Method Called...");
		return "WEB-INF/views/loginsuccess.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		System.out.println("UserController login Method Called...");
		return "WEB-INF/views/logoutsuccess.jsp";
	}
	
	// 회원정보 수정은 인증된 사용자여야만 한다
	// @Auth를 붙여 로그인 세션 인증 과정을 수행하도록! (AuthInterceptor에서)
	@Auth
	@RequestMapping("/modifyform")
	public String modify() {
		System.out.println("UserController modify() Method Called...");
		return "WEB-INF/views/modifyform.jsp";
	}
	
	// 유저 게시판은 유저 인증이 필요 없다
	// @Auth를 붙이지 않는다.
	@RequestMapping("/userlist")
	public String userList() {
		System.out.println("UserController userList() Method Called...");
		return "WEB-INF/views/userlist.jsp";
	}
}
