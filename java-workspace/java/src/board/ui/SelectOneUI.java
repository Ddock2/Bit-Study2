package board.ui;

import board.vo.BoardVO;

public class SelectOneUI extends BaseUI{

	@Override
	public void process() throws Exception {
		int no = scanInt("조회할 글 번호 입력 : ");
		
		BoardVO board = new BoardVO();
		board.setNo(no);
		
		BoardVO result = service.selectOneBoard(board);
		
		if(result == null) {
			System.out.println("게시 번호 " + no + "는 존재하지 않습니다.");
			return;
		}else {
			System.out.println("-----------------------------------");
			System.out.println("번호 : " + result.getNo());
			System.out.println("제목 : " + result.getTitle());
			System.out.println("작성자: " + result.getWriter());
			System.out.println("등록일: " + result.getRegDate());
			System.out.println("-----------------------------------");
		}
	}

}
