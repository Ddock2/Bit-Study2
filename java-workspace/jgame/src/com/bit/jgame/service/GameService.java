package com.bit.jgame.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.jgame.dao.GameDAO;
import com.bit.jgame.vo.GameVO;
import com.bit.jgame.vo.MemberVO;

public class GameService {
	private GameDAO dao = new GameDAO();
	private GameVO gameVO = null;
	
	// 게임 결과 화면
	public void moleGame_result(HttpServletRequest request, HttpServletResponse response) {
		String score = request.getParameter("score");
		String type = request.getParameter("type");
		request.setAttribute("score", score);
		request.setAttribute("type", type);
	}
	
	// 게임 기록 등록
	public void save_moleGame_result(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		int no = dao.getRankingNo();
		String id = ((MemberVO) session.getAttribute("userVO")).getId();
		String item = request.getParameter("type");
		int score = Integer.parseInt(request.getParameter("score"));
		
		gameVO = new GameVO(no, id, item, score);
		String msg = dao.writeRanking(gameVO) ? "기록 등록" : "기록 등록 실패";
		request.setAttribute("msg", msg);
	}
	
	// 게임 기록 전체 조회
	public void moleGame_ranking(HttpServletRequest request, HttpServletResponse response) {
		List<GameVO> recordList = null;
		String paramPage = request.getParameter("page");
		int curPage = 1;
		int boardCntInOnePage = 10;	// 페이지당 기록 수
		int lastPage = 1;
		
		lastPage = dao.selectRankingLastPage(boardCntInOnePage);
		curPage = curPageCheck(paramPage, lastPage);
		
		recordList = dao.selectMoleGameRankingList(curPage);
		
		request.setAttribute("recordList", recordList);
		request.setAttribute("curPage", curPage);
		request.setAttribute("lastPage", lastPage);
	}
	// 게임 기록 아이템 조회
	public void moleGame_ranking(HttpServletRequest request, HttpServletResponse response, String paramI) {
		List<GameVO> recordList = null;
		String paramPage = request.getParameter("page");
		int curPage = 1;
		int boardCntInOnePage = 10;	// 페이지당 기록 수
		int lastPage = 1;
		
		lastPage = dao.selectRankingLastPage(boardCntInOnePage);
		curPage = curPageCheck(paramPage, lastPage);
		
		recordList = dao.selectMoleGameRankingList(curPage);
		
		request.setAttribute("recordList", recordList);
		request.setAttribute("curPage", curPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("item", paramI);
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
