package com.bit.mysite.service;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mysite.dao.BoardDAO;
import com.bit.mysite.vo.BoardVO;
import com.bit.mysite.vo.CommentVO;
import com.bit.mysite.vo.FileVO;
import com.bit.mysite.vo.MemberVO;
import com.bit.util.MyFileNamePolicy;
import com.oreilly.servlet.MultipartRequest;

public class BoardService {
	private BoardDAO dao = new BoardDAO();
	private BoardVO boardVO = null;
	
	// 게시판 페이지
	public void selectBoardList(HttpServletRequest request, HttpServletResponse response){
		List<BoardVO> boardList = null;
		String paramKeyword = request.getParameter("keyword");
		String paramPage = request.getParameter("page");
		int curPage = 1;
		int boardCntInOnePage = 10;	// 페이지당 글 수
		int lastPage = 1;
		
		if(paramKeyword == null || paramKeyword.equals("")) {	// 전체 게시글 조회
			// 페이지 정리
			lastPage = dao.selectBoardLastPage(boardCntInOnePage);
			curPage = curPageCheck(paramPage, lastPage);
			
			//게시글 조회
			boardList = dao.selectBoardListByPage(curPage);
			
			request.setAttribute("boardList", boardList);
		}else {													// 검색 게시글 조회
			String searchType = request.getParameter("searchType");
			String keyword = request.getParameter("keyword");
			
			// 페이지 정리
			lastPage = dao.selectBoardLastPageWithKeyword(searchType, keyword, boardCntInOnePage);
			curPage = curPageCheck(paramPage, lastPage);
			
			//게시글 조회
			boardList = dao.selectBoardListByKeyword(searchType, keyword, curPage);
			
			request.setAttribute("boardList", boardList);
			request.setAttribute("searchType", searchType);
			request.setAttribute("keyword", keyword);
		}
		
		request.setAttribute("curPage", curPage);
		request.setAttribute("lastPage", lastPage);
	}
	

	// 게시글 상세
	public void selectBoardByNo(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		MemberVO userVO = (MemberVO) request.getSession().getAttribute("userVO");
		String id = (userVO == null) ? "" : userVO.getId();
		
		// 조회수 올리기
		dao.upViewCnt(no, id);	// 로그인 후 자신이 쓴 글은 조회해도 조회수 안올라감
		
		// 게시글 정보
		boardVO = dao.selectBoardByNo(no);
		List<FileVO> fileList = dao.selectFileByBoardNo(no);
		List<CommentVO> commentList = dao.selectCommentByBoardNo(no);
		
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("fileList", fileList);
		request.setAttribute("commentList", commentList);
	}
	
	// 게시글 작성 처리
	public void writeProcess(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String saveFolder = "D:/git/bit2/java-workspace/mysite/WebContent/upload";
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024*1024*3, "utf-8", new MyFileNamePolicy());
		
		int boardNo = dao.getBoardNo();
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		boardVO = new BoardVO(boardNo, title, writer, content);
		
		request.setAttribute("check", dao.write(boardVO));
		
		// 첨부파일 처리
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
				fileVO.setBoard_no(boardNo);
				fileVO.setFile_ori_name(file_ori_name);
				fileVO.setFile_save_name(file_save_name);
				fileVO.setFile_size(file_size);
				
				dao.insertFile(fileVO);
			}
		}
	}
	
	// 게시글 삭제 처리
	public void deleteBoard(HttpServletRequest request, HttpServletResponse response) {
		String saveFolder = "D:/git/bit2/java-workspace/mysite/WebContent/upload";
		
		int no = Integer.parseInt(request.getParameter("no"));
		MemberVO userVO = (MemberVO) request.getSession().getAttribute("userVO");
		boardVO = new BoardVO();
		
		boardVO.setNo(no);
		boardVO.setWriter(userVO.getId());
		
		boolean check = dao.deleteByNo(boardVO);
		
		request.setAttribute("check", check);
		
		// 첨부파일 제거
		deleteFileInFolder(saveFolder, no);
		// 댓글 삭제
		dao.deleteCommentByBoardNo(no);
	}
	
	// 게시글 수정
	public void update(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		
		boardVO = dao.selectBoardByNo(no);
		
		request.setAttribute("boardVO", boardVO);
	}
	
	// 게시글 수정 처리
	public void updateProcess(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String saveFolder = "D:/git/bit2/java-workspace/mysite/WebContent/upload";
		MultipartRequest multi = new MultipartRequest(request, saveFolder, 1024*1024*3, "utf-8", new MyFileNamePolicy());
		
		int boardNo = Integer.parseInt(multi.getParameter("no"));
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		boardVO = new BoardVO(boardNo, title, writer, content);
		
		request.setAttribute("check", dao.updateBoard(boardVO));
		
		// 첨부파일 제거
		deleteFileInFolder(saveFolder, boardNo);
		
		// 첨부파일 등록
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
				fileVO.setBoard_no(boardNo);
				fileVO.setFile_ori_name(file_ori_name);
				fileVO.setFile_save_name(file_save_name);
				fileVO.setFile_size(file_size);
				
				dao.insertFile(fileVO);
			}
		}
	}
	
	// 댓글 등록
	public void insertCommentProcess(HttpServletRequest request, HttpServletResponse response) {
		MemberVO userVO = (MemberVO) request.getSession().getAttribute("userVO");
		String writer = userVO.getId();
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String content = request.getParameter("commentContent");
		
		CommentVO comment = new CommentVO(board_no, writer, content);
		
		request.setAttribute("check", dao.insertComment(comment));
		request.setAttribute("no", board_no);
	}
	
	//------------------------------------- 기능 -------------------------------------
	// 첨부파일 삭제
	private void deleteFileInFolder(String saveFolder, int boardNo) {
		List<FileVO> fileList = dao.selectFileByBoardNo(boardNo);
		
		for(FileVO f : fileList) {
			File file = new File(saveFolder + "/" + f.getFile_save_name());
			if(file.exists()) {
				if(file.delete()) {
					System.out.println("파일 삭제 성공");
				}else {
					System.out.println("파일 삭제 실패");
				}
			}else {
				System.out.println("삭제하려는 파일이 존재하지 않음");
			}
		}
		
		dao.deleteFileByBoardNo(boardNo);
	}
	
	// 페이지 범위 넘어간지 확인 후 정정
	private int curPageCheck(String paramPage, int lastPage) {
		int result = 1;
		
		if(paramPage != null) {
			try {
				result = Integer.parseInt(paramPage);
				result = (result<1) ? 1 : result;
				result = (result>lastPage) ? lastPage : result;
			}catch(Exception e) {
				e.printStackTrace();
				result = 1;
			}			
		}
		
		return result;
	}
}
