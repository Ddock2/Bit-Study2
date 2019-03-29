package com.bit.mysite.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit.mysite.service.GalleryService;
import com.bit.mysite.vo.GalleryVO;
import com.bit.mysite.vo.UserVO;
import com.bit.security.Auth;
import com.bit.security.AuthUser;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GalleryVO> list = galleryService.getImageList();
		
		model.addAttribute("list", list);
		model.addAttribute("baseURL", GalleryService.BASE_URL);
		
		return "gallery/index";
	}
	
	@Auth
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(
			@AuthUser UserVO authUser,
			@ModelAttribute GalleryVO galleryVO,
			@RequestParam("file") MultipartFile multipartFile
			) {
		galleryVO.setUserNo(authUser.getNo());
		galleryService.restore(galleryVO, multipartFile);
		
		return "redirect:/gallery";
	}
	
	@Auth
	@RequestMapping(value="/delete/{no}")
	public String delete(
			@AuthUser UserVO authUser,
			@PathVariable("no") Long no
			) {
		galleryService.deleteImage(authUser.getNo(), no);
		
		return "redirect:/gallery";
	}
}
