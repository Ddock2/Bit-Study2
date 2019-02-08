package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
			Login Process 수행
				1. 로그인 시 넘어온 파라미터 정보 얻기
				2. LoginVO 객체에 파라미터 설정
				3. 데이터베이스의 로그인 과정 수행 (DAO)
				4. 성공 시 로그인 세션 등록
		 */
		
		return "/jsp/login/login.jsp";
	}
	
}
