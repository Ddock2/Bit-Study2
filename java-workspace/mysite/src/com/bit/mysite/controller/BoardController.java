package com.bit.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mysite.dao.BoardDAO;
import com.bit.mysite.vo.BoardVO;
import com.bit.mysite.vo.FileVO;
import com.bit.mysite.vo.MemberVO;

public class BoardController implements Controller {
	private BoardDAO dao = new BoardDAO();
	private BoardVO boardVO = null;
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String paramA = request.getParameter("a");
		String result = "/jsp/error/error.jsp";
//		System.out.println(paramA);
		
		switch(paramA) {
			case "boardList":			// 게시판 전체 글
				selectAllBoard(request, response);
				result = "/jsp/board/boardList.jsp";
				break;
			case "boardDetail" :		// 게시글 상세
				selectBoardByNo(request, response);
				result = "/jsp/board/boardDetail.jsp";
				break;
			case "write" :				// 게시글 작성 페이지
				result = "/jsp/board/writeForm.jsp";
				break;
			case "writeProcess" :		// 게시글 작성 처리
				writeProcess(request, response);
				result = "/jsp/board/writeProcess.jsp";
				break;
			case "updateBoard" :		// 게시글 수정 페이지		form페이지 만들기
				request.getParameter("no");
				result = "/jsp/board/updateForm.jsp";
				break;
//			case "updateProcess" :		// 게시글 수정 처리
//				System.out.println(request.getParameter("no"));
//				result = "/jsp/board/updateForm.jsp";
//				break;
			case "deleteBoard" :		// 게시글 삭제
				deleteBoard(request, response);
				result = "/jsp/board/deleteProcess.jsp";
				break;
		}
		
		return result;
	}
	
	// 게시판 전체 글
	private void selectAllBoard(HttpServletRequest request, HttpServletResponse response) {
		List<BoardVO> boardList = dao.selectAllBoard();
		
		request.setAttribute("boardList", boardList);
	}
	
	// 게시글 상세
	private void selectBoardByNo(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		
		dao.upViewCnt(no);
		boardVO = dao.selectBoardByNo(no);
		List<FileVO> fileList = dao.selectFileByNo(no);
		
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("fileList", fileList);
	}
	
	// 게시글 작성 처리
	private void writeProcess(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		boardVO = new BoardVO(title, writer, content);
		
		request.setAttribute("check", dao.write(boardVO));
	}
	
	// 게시글 삭제 처리
	private void deleteBoard(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		MemberVO userVO = (MemberVO) request.getSession().getAttribute("userVO");
		boardVO = new BoardVO();
		
		boardVO.setNo(no);
		boardVO.setWriter(userVO.getId());
		
		request.setAttribute("check", dao.deleteByNo(boardVO));
	}
}
