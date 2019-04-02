package com.bit.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.vo.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(BoardVO boardVO) {
		return sqlSession.insert("board.insert", boardVO);
	}
	
	public int delete(BoardVO boardVO) {
		System.out.println(boardVO);
		return sqlSession.delete("board.delete", boardVO);
	}
	
	public int getTotalCount(String keyword) {
		return sqlSession.selectOne("board.getTotalCount", keyword);
	}
	
	public List<BoardVO> getList(String keyword, Integer page, Integer size){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("page", page);
		map.put("size", size);
		
		return sqlSession.selectList("board.getList", map);
	}
	
	public int increaseGroupOrder(Integer groupNo, Integer orderNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupNo", groupNo);
		map.put("orderNo", orderNo);
		
		return sqlSession.update("board.increaseGroupNo", map);
	}
	
	public int updateHit(Long no) {
		return sqlSession.update("board.updateHit", no);
	}
	
	public int update(BoardVO boardVO) {
		return sqlSession.update("board.update", boardVO);
	}
	
	public BoardVO get(Long no) {
		return sqlSession.selectOne("board.getByNo", no);
	}
}
