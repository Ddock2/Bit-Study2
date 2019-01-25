package board.ui;

import board.vo.BoardVO;

public class UpdateUI extends BaseUI{
	
	@Override
	public void process() throws Exception {
		int no = scanInt("수정할 글 번호 입력 : ");
		String title = scanStr("변경할 제목 입력 : ");
		
		BoardVO board = new BoardVO();
		board.setNo(no);
		board.setTitle(title);
		
		int deleteNo = service.updateBoard(board);
		
		if(deleteNo == 0) {
			System.out.println("게시글을 수정에 실패하였습니다.");
			System.out.println("게시 번호 [" + no + "]는 존재하지 않습니다.");
		}
		else
			System.out.println("게시글을 " + deleteNo + "개 수정하였습니다.");
	}
	
}
