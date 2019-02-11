package com.bit.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.board.db.BoardDAO;
import com.bit.board.db.BoardVO;
import com.bit.board.db.FileVO;
import com.bit.util.MyFileNamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class WriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 	DB에는 실제 파일명을 저장,
		 	서버의 다른 하드디스크에 파일을 저장하거나 다운로드
		 	즉, 하드디스크의 실제 폴더로 지정
		 */
		String saveFolder = "D:\\git\\bit2\\java-workspace\\jboard\\WebContent\\upload";
		
		/*
		 	MultipartRequest
		 		파일에 대한 내용을 알기 위해 사용
		 		파일의 크기 규약
		 		파일의 인코딩
		 		동명의 파일명을 바꿔주는 rename 정책
		 */
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024*1024*3, "utf-8", new MyFileNamePolicy());
		
		// 게시물 저장
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		int board_no = dao.selectNo();
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(board_no);
		boardVO.setTitle(title);
		boardVO.setWriter(writer);
		boardVO.setContent(content);
		
		dao.insert(boardVO);
		
		// 첨부파일 저장
		@SuppressWarnings("rawtypes")
		Enumeration files = multi.getFileNames();
		while(files.hasMoreElements()) {
			String fileName = (String) files.nextElement();
			File f = multi.getFile(fileName);
			
			if(f != null) {
				String file_ori_name = multi.getOriginalFileName(fileName);
				String file_save_name = multi.getFilesystemName(fileName);
				int file_size = (int) f.length();
				
				FileVO fileVO = new FileVO();
				fileVO.setBoard_no(board_no);
				fileVO.setFile_ori_name(file_ori_name);
				fileVO.setFile_save_name(file_save_name);
				fileVO.setFile_size(file_size);
				
				dao.insertFile(fileVO);
			}
		}
		
		return "jsp/board/write.jsp";
	}
	
}
