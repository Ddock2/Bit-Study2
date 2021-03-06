package com.bit.mysite.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.mysite.dao.MemberDAO;
import com.bit.mysite.vo.MemberVO;

public class MemberService {
	private MemberDAO dao = new MemberDAO();
	private MemberVO memberVO = null;
	
	// 가입 처리
	public void joinProcess(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		memberVO = new MemberVO(id, password, name);
		
		request.setAttribute("check", dao.join(memberVO));
	}
	
	// 로그인 처리
	public void loginProcess(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO userVO = null;
		
		memberVO = new MemberVO(id, password);
		
		if((userVO = dao.login(memberVO)) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			request.setAttribute("msg", "로그인 성공!");
		}else {
			request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않소");			
		}
	}
	
	// 로그아웃 처리
	public void logoutProcess(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
