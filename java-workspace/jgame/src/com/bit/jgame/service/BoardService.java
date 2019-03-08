package com.bit.jgame.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.jgame.dao.BoardDAO;
import com.bit.jgame.vo.BoardVO;
import com.bit.jgame.vo.CommentVO;
import com.bit.jgame.vo.MemberVO;

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
		List<CommentVO> commentList = dao.selectCommentByBoardNo(no);
		
		request.setAttribute("boardVO", boardVO);
		request.setAttribute("commentList", commentList);
	}
	
	// 게시글 작성 처리
	public void writeProcess(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int boardNo = dao.getBoardNo();
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		boardVO = new BoardVO(boardNo, title, writer, content);
		
		request.setAttribute("check", dao.write(boardVO));
	}
	
	// 게시글 삭제 처리
	public void deleteBoard(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		MemberVO userVO = (MemberVO) request.getSession().getAttribute("userVO");
		boardVO = new BoardVO();
		
		boardVO.setNo(no);
		boardVO.setWriter(userVO.getId());
		
		boolean check = dao.deleteByNo(boardVO);
		
		request.setAttribute("check", check);
	}
	
	// 게시글 수정
	public void update(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		
		boardVO = dao.selectBoardByNo(no);
		
		request.setAttribute("boardVO", boardVO);
	}
	
	// 게시글 수정 처리
	public void updateProcess(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int boardNo = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		boardVO = new BoardVO(boardNo, title, writer, content);
		
		request.setAttribute("check", dao.updateBoard(boardVO));
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
