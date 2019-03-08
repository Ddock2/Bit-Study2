package com.bit.jgame.service;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.jgame.dao.MemberDAO;
import com.bit.jgame.vo.FileVO;
import com.bit.jgame.vo.MemberVO;
import com.bit.util.MyFileNamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class MemberService {
	private MemberDAO dao = new MemberDAO();
	private MemberVO memberVO = null;
	
	// 가입 처리
	public void joinProcess(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String saveFolder = "D:/git/bit2/java-workspace/jgame/WebContent/profile_img";
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024*1024*3, "utf-8", new MyFileNamePolicy());
		
		String id = multi.getParameter("inputID");
		String password = multi.getParameter("inputPassword");
		String name = multi.getParameter("inputName");
		boolean result = false;
		
		memberVO = new MemberVO(id, password, name);
		
		result = dao.join(memberVO);
		request.setAttribute("check", result);
		
		if(!result)
			return;
		
		// 프로필 이미지 파일 처리
		@SuppressWarnings("rawtypes")
		Enumeration files = multi.getFileNames();
		while(files.hasMoreElements()) {
			String fileName = (String) files.nextElement();
			File f = multi.getFile(fileName);
			
			if(f != null) {
				String file_ori_name = multi.getOriginalFileName(fileName);
				String file_save_name = multi.getFilesystemName(fileName);
				
				FileVO fileVO = new FileVO();
				fileVO.setId(id);
				fileVO.setFile_ori_name(file_ori_name);
				fileVO.setFile_save_name(file_save_name);
				
				dao.insertFile(fileVO);
			}
		}
	}
	
	// 로그인 처리
	public void loginProcess(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO userVO = null;
		
		memberVO = new MemberVO(id, password);
		
		if((userVO = dao.login(memberVO)) != null) {
			if(userVO.getProfile_img_save_name() == null)	// 프로필 사진 없을 시 기본 사진
				userVO.setProfile_img_save_name("null-profile-image.png");
			
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
	
	// 아이디 중복 체크
	public String checkID(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("inputID");
		
		String msg = dao.checkID(id) ? "사용가능한 아이디 입니다" : "중복되는 아이디가 이미 존재합니다";
		return msg;
	}
}
