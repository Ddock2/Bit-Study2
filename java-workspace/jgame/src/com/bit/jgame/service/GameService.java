package com.bit.jgame.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.jgame.dao.GameDAO;
import com.bit.jgame.vo.GameVO;
import com.bit.jgame.vo.MemberVO;

public class GameService {
	private GameDAO dao = new GameDAO();
	private GameVO gameVO = null;
	
	public void moleGame_result(HttpServletRequest request, HttpServletResponse response) {
		String score = request.getParameter("score");
		String type = request.getParameter("type");
		request.setAttribute("score", score);
		request.setAttribute("type", type);
	}

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
	
	
}
