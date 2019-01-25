package board.ui;

import board.vo.BoardVO;

public class DeleteUI extends BaseUI{

	@Override
	public void process() throws Exception {
		int no = scanInt("삭제할 글 번호 입력 : ");
		
		BoardVO board = new BoardVO();
		board.setNo(no);
		
		int deleteNo = service.deleteBoard(board);
		
		if(deleteNo == 0)
			System.out.println("게시글을 삭제하지 못했습니다.");
		else
			System.out.println("게시글을 " + deleteNo + "개 삭제하였습니다.");
	}
	
}
