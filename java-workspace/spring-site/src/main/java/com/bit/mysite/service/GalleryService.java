package com.bit.mysite.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit.mysite.exception.GalleryUploadException;
import com.bit.mysite.repository.GalleryDAO;
import com.bit.mysite.vo.GalleryVO;

@Service
public class GalleryService {
	private static final String SAVE_PATH = "D:/git/bit2/java-workspace/spring-site/webapp/mysite-upload";
	public static final String BASE_URL = "/mysite-upload";
	
	@Autowired
	private GalleryDAO galleryDAO;
	
	public boolean deleteImage(Long userNo, Long no) {
		GalleryVO galleryVO = new GalleryVO();
		galleryVO.setUserNo(userNo);
		galleryVO.setNo(no);
		
		return galleryDAO.delete(galleryVO) == 1;
	}
	
	public List<GalleryVO> getImageList() {
		return galleryDAO.getList();
	}
	
	public void restore(GalleryVO galleryVO, MultipartFile multipartFile)
		throws GalleryUploadException {
		try {
			if(multipartFile.isEmpty() == true) {
				throw new GalleryUploadException("MultipartFile is Empty");
			}
			String orgFileName = multipartFile.getOriginalFilename();
			String fileExtName
				= orgFileName.substring(orgFileName.lastIndexOf('.') + 1, orgFileName.length());
			String saveFileName = generateSaveFileName(fileExtName);
			Long fileSize = multipartFile.getSize();
			
			// 파일 저장
			writeFile(multipartFile, saveFileName);
			
			// 데이터베이스 저장
			galleryVO.setOrgFileName(orgFileName);
			galleryVO.setSaveFileName(saveFileName);
			galleryVO.setFileExtName(fileExtName);
			galleryVO.setFileSize(fileSize);
			galleryDAO.insert(galleryVO);
			
		}catch(IOException e) {
			e.printStackTrace();
			throw new GalleryUploadException("save file uploaded");
		}
	}
	
	private void writeFile(MultipartFile multipartFile, String saveFileName)
		throws IOException{
		byte[] fileData = multipartFile.getBytes();
		System.out.println(GalleryService.class.getResource("").getPath());
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(fileData);;
		fos.close();
	}
	
	private String generateSaveFileName(String extName) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("." + extName);
		
		return fileName;
	}
}
