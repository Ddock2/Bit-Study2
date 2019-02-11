package com.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.board.db.BoardDAO;
import com.bit.board.db.BoardVO;

public class ListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAllBoard();
		
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
		}
		
		return "jsp/board/list.jsp";
	}

}
