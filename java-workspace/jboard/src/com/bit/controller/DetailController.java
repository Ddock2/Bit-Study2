package com.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.board.db.BoardDAO;
import com.bit.board.db.BoardVO;
import com.bit.board.db.FileVO;

public class DetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
//		String type = request.getParameter("type");
		
		BoardDAO dao = new BoardDAO();
		dao.updateViewCnt(no);							// 조회수 증가
		BoardVO board = dao.selectByNo(no);				// 게시글 정보 조회
		List<FileVO> files = dao.selectFileByNo(no);	// 첨부파일 정보 조회
		
		
		request.setAttribute("board", board);
		request.setAttribute("files", files);
		
		return "/jsp/board/boardDetail.jsp";
	}
	
}
