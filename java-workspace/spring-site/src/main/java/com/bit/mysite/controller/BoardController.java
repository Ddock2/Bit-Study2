package com.bit.mysite.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.mysite.service.BoardService;
import com.bit.mysite.vo.BoardVO;
import com.bit.mysite.vo.UserVO;
import com.bit.security.Auth;
import com.bit.security.AuthUser;
import com.bit.spring.web.util.WebUtil;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String index(
			@RequestParam(value="p", required=true, defaultValue="1") Integer page,
			@RequestParam(value="kwd", required=true, defaultValue="") String keyword,
			Model model
			) {
		Map<String, Object> map
			= boardService.getMessageList(page, keyword);
		model.addAttribute("map", map);
		
		return "board/index";
	}
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm() {
		return "board/write";
	}
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(
			@AuthUser UserVO authUser,
			@ModelAttribute BoardVO vo,
			@RequestParam(value="p", required=true, defaultValue="1") Integer page,
			@RequestParam(value="kwd", required=true, defaultValue="") String keyword
			) {
		vo.setUserNo(authUser.getNo());
		boardService.writeMessage(vo);
		
		return "redirect:/board" + "?p=" + page + "&kwd=" + WebUtil.encodeURL(keyword, "UTF-8");
	}
}
