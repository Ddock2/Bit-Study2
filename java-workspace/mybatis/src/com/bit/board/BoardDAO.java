package com.bit.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bit.MyConfig;

public class BoardDAO {
	private SqlSession session = null;
	
	public BoardDAO() {
		session = new MyConfig().getInstance();
		System.out.println("session : " + session);
	}
	
	public void process() {
		System.out.println("게시판 작업 수행!");
		
		insert();
		select();
		
		selectOne();
		selectNos();
	}
	
	private void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("Monster");
		board.setContent("MyBatis");
		
		// board.xml의 매핑을 위한 namespace를 통해,
		// 해당 파일에 만들어 놓은 id="insertBoard"의 내용을 수행!
		session.insert("com.bit.insertBoard", board);
		session.commit();
		
		System.out.println("글 등록 완료");
	}
	
	private void select() {
		List<BoardVO> list = session.selectList("com.bit.selectBoard");
		for(BoardVO vo : list) {
			System.out.println(vo);
		}
	}
	
	private void selectOne() {
		BoardVO board = new BoardVO();
		board.setNo(3);
		BoardVO vo = session.selectOne("com.bit.selectOneBoard", board);
		System.out.println("검색 결과 : " + vo);
	}
	
	private void selectNos() {
		BoardVO board = new BoardVO();
		board.setNos(new int[] {1, 2, 3});
		List<BoardVO> list = session.selectList("com.bit.selectNos", board);
		
		System.out.println(list);
	}
}
