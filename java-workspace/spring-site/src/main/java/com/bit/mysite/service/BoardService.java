package com.bit.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mysite.repository.BoardDAO;
import com.bit.mysite.vo.BoardVO;

@Service
public class BoardService {
	private static final int LIST_SIZE = 5;	// 리스팅 게시물의 수
	private static final int PAGE_SIZE = 5; // 페이징 리스트의 페이지 수
	
	@Autowired
	private BoardDAO boardDAO;
	
	public boolean deleteMessage(BoardVO boardVO) {
		return boardDAO.delete(boardVO) == 1;
	}
	
	public BoardVO getMessage(Long no) {
		BoardVO boardVO = boardDAO.get(no);
		if(boardVO != null) {
			boardDAO.updateHit(no);
		}
		return boardVO;
	}
	
	public boolean writeMessage(BoardVO boardVO) {
		Integer groupNo = boardVO.getGroupNo();
		
		if(groupNo != null) {
			Integer orderNo = boardVO.getOrderNo();
			Integer depth = boardVO.getDepth();
			
			boardDAO.increaseGroupOrder(groupNo, orderNo);
			boardVO.setOrderNo(orderNo + 1);
			boardVO.setDepth(depth + 1);
		}
		
		return boardDAO.insert(boardVO) == 1;
	}
	
	public boolean updateMessage(BoardVO boardVO) {
		return boardDAO.update(boardVO) == 1;
	}
	
	public Map<String, Object> getMessageList(int currentPage, String keyword) {
		// 1. 페이징을 위한 기본 데이터 가공
		int totalCount = boardDAO.getTotalCount(keyword);
		int pageCount = (int)Math.ceil( (double)totalCount / LIST_SIZE);
		int blockCount = (int)Math.ceil( (double)pageCount / PAGE_SIZE);
		int currentBlock = (int)Math.ceil( (double)currentPage / PAGE_SIZE);
		
		// 2. 파라미터 page 값 검증
		if(currentPage < 1) {
			currentPage = 1;
			currentBlock = 1;
		}else if(currentPage > pageCount) {
			currentPage = pageCount;
			currentBlock = (int)Math.ceil( (double)currentPage / PAGE_SIZE);
		}
		
		// 3. view에서 페이지 리스트를 랜더링 하기위한 데이터' 가공
		int beginPage = ( currentBlock == 0 ) ? 1 : (currentBlock - 1)*PAGE_SIZE + 1;
		int prevPage = ( currentBlock > 1 ) ? (currentBlock - 1)*PAGE_SIZE : 0;
		int nextPage = ( currentBlock < blockCount ) ? currentBlock * PAGE_SIZE + 1 : 0;
		int endPage = ( nextPage > 0 ) ? (beginPage - 1) + LIST_SIZE : pageCount;
		
		// 4. 리스트 가져오기
		List<BoardVO> list = boardDAO.getList(keyword, currentPage, LIST_SIZE);
		
		// 5. 맵에 리스트 정보 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", totalCount);
		map.put("listSize", LIST_SIZE);
		map.put("currentPage", currentPage);
		map.put("beginPage", beginPage);
		map.put("endPage", endPage);
		map.put("prevPage", prevPage);
		map.put("nextPage", nextPage);
		map.put("keyword", keyword);
		
		// 6. 맵 정보 반환
		return map;
	}
}
