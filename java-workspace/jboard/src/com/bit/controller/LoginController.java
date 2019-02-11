package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.login.db.LoginDAO;
import com.bit.login.db.LoginVO;

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
		
		// 1.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2.
		LoginVO loginVO = new LoginVO();
		loginVO.setId(id);
		loginVO.setPassword(password);
		
		// 3.
		LoginDAO dao = new LoginDAO();
		LoginVO userVO = new LoginVO();
		userVO = dao.login(loginVO);
		
		// 4.
		String msg = "";	// 전달할 메세지
		String url = "";	// 이동할 경로
		
		if(userVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			
			// 유저 타입 체크
			
			switch(userVO.getType()) {
			case "S" :
				msg = userVO.getName() + " 관리자님 환영합니다.";
				
				break;
			case "U" : 
				msg = userVO.getName() + " 회원님 환영합니다.";
				
				break;
			}
			url = request.getContextPath();	// 홈으로
		}else {
			msg = "아이디 또는 비밀번호가 잘못 되었습니다.";
			url = "/jboard/loginForm.do";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/login/login.jsp";
	}
	
}
