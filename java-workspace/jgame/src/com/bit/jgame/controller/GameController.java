package com.bit.jgame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.jgame.service.GameService;

public class GameController implements Controller {
	GameService service = new GameService();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String paramA = request.getParameter("a");
		String result = "/jsp/error/error.jsp";
//		System.out.println(paramA);
		if(paramA != null) {
			switch(paramA) {
				case "moleGame_intro" :		// 게임 튜토리얼
					result = "/jsp/game/moleGame_intro.jsp";
					break;
				case "moleGame" :			// 게임 페이지
					result = "/jsp/game/moleGame_main.jsp";
					break;
				case "moleGame_result" :	// 게임 결과 페이지
					service.moleGame_result(request, response);
					result = "/jsp/game/moleGame_result.jsp";
					break;
				case "save_moleGame_result" :	// 게임 결과 등록
					service.save_moleGame_result(request, response);
					result = "/jsp/game/save_moleGame_result.jsp";
					break;
				case "ranking_page" :		// 게임 결과 랭킹 조회
					String paramI = request.getParameter("item");
					if(paramI != null) {
						switch(paramI) {
							case "주먹" :
							case "망치" :
								service.moleGame_ranking(request, response, paramI);
								break;
							default :	
								service.moleGame_ranking(request, response);
						}
					}else {
						service.moleGame_ranking(request, response);
					}
					result = "/jsp/game/moleGame_ranking.jsp";
					break;
			}
		}
		return result;
	}
	
}
