package com.bit.mysite.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.mysite.service.UserService;
import com.bit.mysite.vo.UserVO;
import com.bit.security.Auth;
import com.bit.security.AuthUser;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/joinform")
	public String joinForm(@ModelAttribute UserVO userVO) {
		return "user/joinform";
	}
	
	// @Valid : Bean의 유효성을 자동 검증
	@RequestMapping("/join")
	public String join(@ModelAttribute @Valid UserVO userVO, BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError oe : list) {
				System.out.println("Object Error : " + oe);
			}
			return "user/joinform";
		}
		
		userService.join(userVO);
		
		return "redirect:/user/joinsuccess"; // 리다이렉트
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "user/joinsuccess";
	}

	@RequestMapping("/loginform")
	public String loginForm() {
		return "user/loginform";
	}
	
	@Auth
	@RequestMapping("/modifyform")
	public String modifyForm(@AuthUser UserVO authUser, Model model) {
		System.out.println(authUser);
		UserVO vo = userService.getUser(authUser.getNo());
		model.addAttribute("userVO", vo);
		
		return "user/modifyform";
	}
	
	@Auth
	@RequestMapping("/modify")
	public String modify(@AuthUser UserVO authUser, @ModelAttribute UserVO vo) {
		System.out.println(authUser);
		System.out.println(vo);
		vo.setNo(authUser.getNo());
		userService.updateUser(vo);
		authUser.setName(vo.getName());
		
		return "redirect:/user/modifyform?update=success";
	}
	
}
