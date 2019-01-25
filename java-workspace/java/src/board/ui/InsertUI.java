package board.ui;

import board.vo.BoardVO;

public class InsertUI extends BaseUI{
	
	@Override
	public void process() throws Exception{
		String title = scanStr("등록할 글 제목 입력 : ");
		String writer = scanStr("이름 입력 : ");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		
		int insertNo = service.insertBoard(board);
		
		if(insertNo == 0)
			System.out.println("게시글을 등록하지 못했습니다");
		else
			System.out.println("게시글을 " + insertNo + "개 등록하였습니다.");
	}
}
