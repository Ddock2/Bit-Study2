package board.ui;

import java.util.List;

import board.vo.BoardVO;

public class SelectUI extends BaseUI {

	@Override
	public void process() throws Exception {
		List<BoardVO> list = service.selectBoard();
		
		System.out.println("게시글 목록 (" + list.size() + ")");
		System.out.println("-------------------------------------------");
		System.out.println("번호\t작성자\t제목\t등록일");
		System.out.println("===========================================");
		for(BoardVO board : list) {
			System.out.print(board.getNo() + "\t");
			System.out.print(board.getWriter() + "\t");
			System.out.print(board.getTitle() + "\t");
			System.out.print(board.getRegDate() + "\n");
		}
		if(list.isEmpty()) {
			System.out.println("\t조회된 게시물이 존재하지 않습니다.");
		}
	}
	
}
