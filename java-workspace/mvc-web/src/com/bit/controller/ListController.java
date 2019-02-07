package com.bit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.BoardDAO;
import com.bit.vo.BoardVO;

public class ListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.listAll();
		
		// BoardDAO 작업 후 request 영역에 등록
		request.setAttribute("list", list);
		
		return "/board/list.jsp";	// 실제 파일 위치(경로)를 반환
	}

}
