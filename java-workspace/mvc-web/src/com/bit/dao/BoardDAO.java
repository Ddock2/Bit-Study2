package com.bit.dao;

import java.util.ArrayList;
import java.util.List;

import com.bit.vo.BoardVO;

public class BoardDAO {
	static List<BoardVO> list = new ArrayList<>();
	
	public BoardDAO() {
		list.clear();
	}
	
	public List<BoardVO> listAll(){
		list.add(new BoardVO("MVC", "박신혜"));
		list.add(new BoardVO("Web", "박서준"));
		list.add(new BoardVO("Hello", "임시완"));
		list.add(new BoardVO("Board", "한채영"));
		
		return list;
	}
}
