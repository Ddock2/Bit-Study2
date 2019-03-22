package com.bit.mysite.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.mysite.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
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
		
		// TODO
		// 1. 유저 서비스 join 기능 수행
		// 2. 가입 성공 여부 반환
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
	
	@RequestMapping("/modifyform")
	public String modifyForm(UserVO authUser, Model model) {
		return "user/modifyform";
	}
	
	@RequestMapping("/modify")
	public String modify(UserVO authUser, @ModelAttribute UserVO vo) {
		return "redirect:/user/modifyform?update=success";
	}
	
}
