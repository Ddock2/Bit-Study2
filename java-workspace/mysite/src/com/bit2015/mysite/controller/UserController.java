package com.bit2015.mysite.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.UserVO;
import com.bit2015.mysite.vo.UserDAO;

public class UserController implements Controller{
	private UserVO vo = null;
	private UserDAO dao = new UserDAO();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String param = request.getParameter("a");
		String result = "";
		
		switch(param) {
			case "join" :
				result = "/jsp/user/signUpForm.jsp";
				break;
			case "joinProcess" :
				vo = new UserVO(request.getParameter("id"), request.getParameter("password"), request.getParameter("name"));
				dao.signUp(vo);
				result = "/jsp/user/signUpProcess.jsp";
				break;
			case "list" :
				result = "/jsp/user/userList.jsp";
				break;
		}
		return result;
	}
	
}
