package com.bit.mysite.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.mysite.service.BoardService;

public class BoardController implements Controller {
	BoardService service = new BoardService();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String paramA = request.getParameter("a");
		String result = "/jsp/error/error.jsp";
//		System.out.println(paramA);
		
		switch(paramA) {
			case "boardList":			// 게시판 페이지
				service.selectBoardList(request, response);
				result = "/jsp/board/boardList.jsp";
				break;
			case "boardDetail" :		// 게시글 상세
				service.selectBoardByNo(request, response);
				result = "/jsp/board/boardDetail.jsp";
				break;
			case "write" :				// 게시글 작성 페이지
				result = "/jsp/board/writeForm.jsp";
				break;
			case "writeProcess" :		// 게시글 작성 처리
				service.writeProcess(request, response);
				result = "/jsp/board/writeProcess.jsp";
				break;
			case "updateBoard" :		// 게시글 수정 페이지
				service.update(request, response);
				result = "/jsp/board/updateForm.jsp";
				break;
			case "updateProcess" :		// 게시글 수정 처리
				service.updateProcess(request, response);
				result = "/jsp/board/updateProcess.jsp";
				break;
			case "deleteBoard" :		// 게시글 삭제
				service.deleteBoard(request, response);
				result = "/jsp/board/deleteProcess.jsp";
				break;
			case "insertComment" :		// 댓글 등록 처리
				service.insertCommentProcess(request, response);
				result = "/jsp/board/insertCommentProcess.jsp";
				break;
		}
		
		return result;
	}
	
}
