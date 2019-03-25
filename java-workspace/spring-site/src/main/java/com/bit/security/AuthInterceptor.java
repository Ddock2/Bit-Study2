package com.bit.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit.mysite.vo.UserVO;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1. handler 종류
		if(handler instanceof HandlerMethod == false) {
			return true;
		}
		
		// 2. @Auth 여부
		Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
		if(auth == null) {	// 접근 제어가 필요 없는 handler
			return true;
		}
		
		// 3. 접근 제어 (User Session)
		HttpSession session = request.getSession();
		if(session == null) {
			response.sendRedirect(request.getContextPath() + "/user/loginform");
			return false;
		}
		
		UserVO authUser = (UserVO) session.getAttribute("authUser");
		if(authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/loginform");
			return false;	// 해당 컨트롤러로 진행하지 말고 loginform으로 강제 이동!
		}
		
		// 4. 인증된 사용자
		return true;
	}
	
}
