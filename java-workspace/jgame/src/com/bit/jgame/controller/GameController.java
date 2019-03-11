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
		
		switch(paramA) {
			case "moleGame_intro" :
				result = "/jsp/game/moleGame_intro.jsp";
				break;
			case "moleGame" :
				result = "/jsp/game/moleGame_main.jsp";
				break;
			case "moleGame_result" :
				service.moleGame_result(request, response);
				result = "/jsp/game/moleGame_result.jsp";
				break;
			case "save_moleGame_result" :
				service.save_moleGame_result(request, response);
				result = "/jsp/game/save_moleGame_result.jsp";
				break;
		}
		
		return result;
	}
	
}
