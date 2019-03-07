package com.bit.jgame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameController implements Controller {

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
		}
		
		return result;
	}
	
}
