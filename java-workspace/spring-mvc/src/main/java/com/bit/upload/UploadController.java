package com.bit.upload;

import java.io.File;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/file")
public class UploadController {
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/uploadForm.do")
	public String fileUploadForm() {
		return "file/fileUploadForm";
	}
	
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView fileUpload(MultipartHttpServletRequest multi) throws Exception {
		String uploadDir = servletContext.getRealPath("/upload");
		System.out.println(uploadDir);
		
		ModelAndView mav = new ModelAndView("file/uploadResult");
		
		String id = multi.getParameter("id");
		System.out.println("ID : " + id);
		
		Iterator<String> ite = multi.getFileNames();
		while(ite.hasNext()) {
			String formFileName = ite.next();
			
			MultipartFile mFile = multi.getFile(formFileName);
			
			String oriFileName = mFile.getOriginalFilename();
			System.out.println("원본 파일명 : "+ oriFileName);
			
			if(oriFileName != null && !oriFileName.equals("")) {
				// 확장자 처리
				String ext = "";
				
				// 확장자를 의미하는 뒤쪽의 "."의 위치
				int index = oriFileName.lastIndexOf(".");
				
				if(index != -1) { // EOF == -1
					// 파일명에서 확장자 추출
					ext = oriFileName.substring(index);
				}
				
				// 파일 사이즈
				long filesize = mFile.getSize();
				System.out.println("파일 사이즈 : " + filesize);
				
				// 고유한 파일 명(UUID)
				String saveFileName = "my-" + UUID.randomUUID().toString() + ext;
				
				// 해당 디렉토리 없을경우 디렉토리를 생성
				File folder = new File(uploadDir);
				if(!folder.exists()) {
					folder.mkdir();	// 폴더 생성
				}
				
				//임시 저장된 파일을 원하는 경로에 저장
				mFile.transferTo(new File(uploadDir + "/" + saveFileName));
			}
		}
		
		return mav;
	}
	
}
